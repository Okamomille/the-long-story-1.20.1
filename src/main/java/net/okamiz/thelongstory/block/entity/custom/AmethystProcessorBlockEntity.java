package net.okamiz.thelongstory.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
import net.okamiz.thelongstory.block.custom.AmethystProcessorBlock;
import net.okamiz.thelongstory.block.entity.ImplementedInventory;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.recipe.MaterialProcessingRecipe;
import net.okamiz.thelongstory.screen.AmethystProcessorScreenHandler;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class AmethystProcessorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    private static final int INPUT_SLOT_2 = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int INPUT_SLOT_1 = 3;
    private static final int INPUT_SLOT_3 = 4;
    private static final int ENERGY_ITEM_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 200;

    public AmethystProcessorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.AMETHYST_PROCESSOR_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> AmethystProcessorBlockEntity.this.progress;
                    case 1 -> AmethystProcessorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: AmethystProcessorBlockEntity.this.progress = value;
                    case 1: AmethystProcessorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(32000, 800, 200) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        Direction localDir = this.getWorld().getBlockState(pos).get(AmethystProcessorBlock.FACING);

        if(side == Direction.DOWN) {
            return false;
        }

        if(side == Direction.UP) {
            return slot == INPUT_SLOT_2;
        }

        return switch (localDir) {
            default -> //NORTH
                    side.getOpposite() == Direction.NORTH && slot == INPUT_SLOT_2 ||
                            side.getOpposite() == Direction.WEST && slot == INPUT_SLOT_2;
            case EAST ->
                    side.rotateYClockwise() == Direction.NORTH && slot == INPUT_SLOT_2 ||
                            side.rotateYClockwise() == Direction.WEST && slot == INPUT_SLOT_2;
            case SOUTH ->
                    side == Direction.NORTH && slot == INPUT_SLOT_2 ||
                            side == Direction.WEST && slot == INPUT_SLOT_2;
            case WEST ->
                    side.rotateYCounterclockwise() == Direction.NORTH && slot == INPUT_SLOT_2 ||
                            side.rotateYCounterclockwise() == Direction.WEST && slot == INPUT_SLOT_2;
        };
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction side) {
        Direction localDir = this.getWorld().getBlockState(this.pos).get(AmethystProcessorBlock.FACING);

        if(side == Direction.UP) {
            return false;
        }

        // Down extract 2
        if(side == Direction.DOWN) {
            return slot == OUTPUT_SLOT;
        }

        // bottom extract 2
        // right extract 2
        return switch (localDir) {
            default ->  side.getOpposite() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.getOpposite() == Direction.EAST && slot == OUTPUT_SLOT;

            case EAST -> side.rotateYClockwise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.rotateYClockwise() == Direction.EAST && slot == OUTPUT_SLOT;

            case SOUTH ->   side == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side == Direction.EAST && slot == OUTPUT_SLOT;

            case WEST -> side.rotateYCounterclockwise() == Direction.SOUTH && slot == OUTPUT_SLOT ||
                    side.rotateYCounterclockwise() == Direction.EAST && slot == OUTPUT_SLOT;
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Amethyst Processor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new AmethystProcessorScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("amethyst_processor.progress", progress);
        nbt.putLong(("amethyst_processor.energy"), energyStorage.amount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("amethyst_processor.progress");
        energyStorage.amount = nbt.getLong("amethyst_processor.energy");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        fillUpOnEnergy(); // until we have machines/other mods that give us Energy

        if(canInsertIntoOutputSlot() && hasRecipe()) {
            extractEnergy();
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            if(this.getStack(INPUT_SLOT_2).getItem() == Items.COAL){

            }else if(this.getStack(INPUT_SLOT_2).getItem() == ModItems.IMPURE_ZAROSITE_INGOT){

            }else{
                resetProgress();
            }

        }
    }

    private void extractEnergy() {

        if(isRecipe(INPUT_SLOT_1, Items.AMETHYST_SHARD) && isRecipe(INPUT_SLOT_2, ModItems.THESTONE_DUST) && isRecipe(INPUT_SLOT_3, Items.AMETHYST_SHARD)){
            maxProgress = 700;
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.extract(2L, transaction);
                transaction.commit();
            }
        }





    }

    private boolean isRecipe(int inputSlot, Item item) {
        return this.getStack(inputSlot).getItem() == item;
    }

    private void fillUpOnEnergy() {
        if(hasEnergyItemInEnergySlot(ENERGY_ITEM_SLOT)) {
            this.removeStack(ENERGY_ITEM_SLOT, 1);
            addEnergy();
        }
    }

    private void addEnergy() {
        try(Transaction transaction = Transaction.openOuter()) {
            this.energyStorage.insert(800, transaction);
            transaction.commit();
        }
    }

    private boolean hasEnergyItemInEnergySlot(int energyItemSlot) {
        return this.getStack(energyItemSlot).getItem() == ModItems.DRONIUM_POWDER;
    }

    private void craftItem() {
        this.removeStack(INPUT_SLOT_1, 1);
        this.removeStack(INPUT_SLOT_2, 1);
        this.removeStack(INPUT_SLOT_3, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(ModItems.PURE_AMETHYST_SHARD,
                this.getStack(OUTPUT_SLOT).getCount() + 1));
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

        return this.getStack(INPUT_SLOT_3).getItem() == Items.AMETHYST_SHARD &&
                this.getStack(INPUT_SLOT_1).getItem() == Items.AMETHYST_SHARD &&
                this.getStack(INPUT_SLOT_2).getItem() == ModItems.THESTONE_DUST &&

                canInsertAmountIntoOutputSlot(1) &&
                canInsertItemIntoOutputSlot(new ItemStack(ModItems.PURE_AMETHYST_SHARD)) &&
                hasEnoughEnergyToCraft();

    }


    private boolean hasEnoughEnergyToCraft() {
        return this.energyStorage.amount >= 1L;
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
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
