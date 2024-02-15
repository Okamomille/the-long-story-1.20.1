package net.okamiz.thelongstory.block.entity.custom;


import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.custom.MaterialProcessorBlock;
import net.okamiz.thelongstory.block.custom.RedCoalGeneratorBlock;
import net.okamiz.thelongstory.block.entity.ImplementedInventory;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.recipe.MaterialProcessingRecipe;
import net.okamiz.thelongstory.screen.MaterialProcessorScreenHandler;
import net.okamiz.thelongstory.screen.RedCoalGeneratorScreenHandler;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class RedCoalGeneratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public RedCoalGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.RED_COAL_GENERATOR_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> RedCoalGeneratorBlockEntity.this.progress;
                    case 1 -> RedCoalGeneratorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: RedCoalGeneratorBlockEntity.this.progress = value;
                    case 1: RedCoalGeneratorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(64000, 200, 200){
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };





    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(RedCoalGeneratorBlock.FACING);

        if(side == Direction.DOWN){
            return false;
        }

        if(side == Direction.UP){
            return slot == INPUT_SLOT;
        }

        return switch(localDir){
            default -> //NORTH
                    side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.getOpposite() == Direction.WEST && slot == INPUT_SLOT;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYClockwise() == Direction.WEST && slot == INPUT_SLOT;
            case SOUTH ->
                    side == Direction.NORTH && slot == INPUT_SLOT ||
                            side == Direction.WEST && slot == INPUT_SLOT;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == INPUT_SLOT;

        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        return false;
    }





    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Red Coal Generator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new RedCoalGeneratorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("red_coal_generator.progress", progress);
        nbt.putLong("red_coal_generator.energy", energyStorage.amount);

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("red_coal_generator.progress");
        energyStorage.amount = nbt.getLong("red_coal_generator.energy");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {



        fillUpOnEnergy(); // until we have othermods / machines that give us energy

        if(hasRecipe()) {
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void fillUpOnEnergy() {
        if(hasEnergyItemInEnergySlot(INPUT_SLOT)){
            this.removeStack(INPUT_SLOT, 1);
            addEnergy();
        }
    }

    private void addEnergy() {
        try(Transaction transaction = Transaction.openOuter()){
            this.energyStorage.insert(1200,transaction);
            transaction.commit();
        }
    }


    public void transferEnergy(Block block, BlockPos pos){

        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof MaterialProcessorBlockEntity) {

            MaterialProcessorBlockEntity materialProcessorBlockEntity = (MaterialProcessorBlockEntity) blockEntity;

                if(this.energyStorage.amount >= 64){
                    try(Transaction transaction = Transaction.openOuter()){
                    this.energyStorage.extract(64,transaction);
                    materialProcessorBlockEntity.energyStorage.insert(64, transaction);
                    transaction.commit();}
                }

        }


    }



    private boolean hasEnergyItemInEnergySlot(int inputSlot) {
        return this.getStack(inputSlot).getItem() == ModItems.RED_COAL;
    }

    private void craftItem() {
        Optional<MaterialProcessingRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<MaterialProcessingRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        } else{
            return true;
        }

    }

    private Optional<MaterialProcessingRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory((this.size()));
        for(int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(MaterialProcessingRecipe.Type.INSTANCE, inventory, this.getWorld());
    }


    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }


    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }




}

