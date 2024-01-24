package net.okamiz.thelongstory.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ContainerLock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.screen.BeaconScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.custom.greffed_command_blocks.GreffedCommandSystemBlock;
import net.okamiz.thelongstory.block.entity.ImplementedInventory;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.screen.GreffedCommandSystemScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GreffedCommandSystemBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {


    public static final StatusEffect[][] EFFECTS_BY_CONTAINERS = new StatusEffect[][]{
            {StatusEffects.SPEED, StatusEffects.HASTE}, {StatusEffects.RESISTANCE, StatusEffects.JUMP_BOOST}, {StatusEffects.STRENGTH}, {StatusEffects.REGENERATION}
    };
    private static final Set<StatusEffect> EFFECTS = (Set<StatusEffect>) Arrays.stream(EFFECTS_BY_CONTAINERS).flatMap(Arrays::stream).collect(Collectors.toSet());
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int INPUT_SLOT_4 = 3;

    protected final PropertyDelegate propertyDelegate;
    private StatusEffect effect;
    private int timer;
    private int maxTimer = 3600;



    public GreffedCommandSystemBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GREFFED_COMMAND_SYSTEM_BLOCK_ENTITY_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch(index) {
                    case 0 -> GreffedCommandSystemBlockEntity.getRawIdForStatusEffect(GreffedCommandSystemBlockEntity.this.effect);
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0:
                        assert GreffedCommandSystemBlockEntity.this.world != null;
                        if (!GreffedCommandSystemBlockEntity.this.world.isClient) {
                            GreffedCommandSystemBlockEntity.playSound(GreffedCommandSystemBlockEntity.this.world, GreffedCommandSystemBlockEntity.this.pos,
                                    SoundEvents.BLOCK_BEACON_POWER_SELECT);
                        }

                        GreffedCommandSystemBlockEntity.this.effect = GreffedCommandSystemBlockEntity.getEffectOrNull(BeaconScreenHandler.getStatusEffectForRawId(value));
                        break;
                }
            }

            @Override
            public int size() {
                return 1;
            }
        };
    }

    public static int getRawIdForStatusEffect(@Nullable StatusEffect statusEffect) {
        return statusEffect == null ? 0 : Registries.STATUS_EFFECT.getRawId(statusEffect) + 1;
    }

    @Nullable
    static StatusEffect getEffectOrNull(@Nullable StatusEffect effect) {
        return EFFECTS.contains(effect) ? effect : null;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("display.thelongstory.greffed_command_system");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GreffedCommandSystemScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        writeStatusEffect(nbt, "effect", effect);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.effect = readStatusEffect(nbt, "effect");
    }

    public static void playSound(World world, BlockPos pos, SoundEvent sound) {
        world.playSound(null, pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }


    private static void writeStatusEffect(NbtCompound nbt, String key, @Nullable StatusEffect effect) {
        if (effect != null) {
            Identifier identifier = Registries.STATUS_EFFECT.getId(effect);
            if (identifier != null) {
                nbt.putString(key, identifier.toString());
            }
        }
    }

    @Nullable
    private static StatusEffect readStatusEffect(NbtCompound nbt, String key) {
        if (nbt.contains(key, NbtElement.STRING_TYPE)) {
            Identifier identifier = Identifier.tryParse(nbt.getString(key));
            return getEffectOrNull(Registries.STATUS_EFFECT.get(identifier));
        } else {
            return null;
        }
    }

    public void tick(World world, BlockPos pos, BlockState state){
        if(world.isClient()){
            return;
        }

            if(timer >= 0){
                timer --;
                markDirty(world,pos, state);
            }

    }




    private void resetTimer() {
        timer = maxTimer;
    }

    private void applyEffect() {
        
    }

    private boolean hasRecipe() {
        return false;
    }

    private boolean isBlockCooledDown() {
        if(timer >= 0){
            return false;
        }else {
            return true;
        }
    }



}
