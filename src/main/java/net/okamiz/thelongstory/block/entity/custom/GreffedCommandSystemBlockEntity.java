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
import net.minecraft.item.Item;
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
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.okamiz.thelongstory.block.ModBlocks;
import net.okamiz.thelongstory.block.custom.greffed_command_blocks.GreffedCommandSystemBlock;
import net.okamiz.thelongstory.block.entity.ImplementedInventory;
import net.okamiz.thelongstory.block.entity.ModBlockEntities;
import net.okamiz.thelongstory.item.ModItems;
import net.okamiz.thelongstory.item.custom.SoulContainerItem;
import net.okamiz.thelongstory.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GreffedCommandSystemBlockEntity extends BlockEntity {
    private int timer;
    private int maxTimer = 3600;
    private int effectID;

    public int state;

    public boolean isActive = false;

    private StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.REGENERATION, 3600, 1);

    public GreffedCommandSystemBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GREFFED_COMMAND_SYSTEM_BLOCK_ENTITY_BLOCK_ENTITY, pos, state);
    }


    public static void playSound(World world, BlockPos pos) {
        world.playSound(null, pos, ModSounds.GREFFED_COMMAND_SYSTEM_GIVE_EFFECT, SoundCategory.BLOCKS, 1f, 1f);
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


    public void useBlock(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand){

        if(this.isActive){
            if(this.timer <= 0){
                if(!world.isClient()){
                    applyEffect(player);
                    this.timer = maxTimer;
                    playSound(world, pos);
                }

            }else if (this.timer > 0){
                //WRONG
                if(!world.isClient()){
                    player.sendMessage(Text.literal("§o§7The Command System is cooling, you have to wait. " + this.timer), true);
                    world.playSound(null, pos, ModSounds.GREFFED_COMMAND_SYSTEM_FAIL, SoundCategory.BLOCKS, 1f, 1f);
                }

            }
        }else {

            Item mainHand = player.getMainHandStack().getItem();

            if(!world.isClient()){
                if (mainHand == ModItems.SOUL_CONTAINER_REGENERATION){
                    activate(1, player);
                    player.getStackInHand(hand).decrement(1);
                } else if (mainHand == ModItems.SOUL_CONTAINER_FIRE_RESISTANCE) {
                    activate(2, player);
                    player.getStackInHand(hand).decrement(1);
                }
                else if (mainHand == ModItems.SOUL_CONTAINER_JUMP_BOOST){
                    activate(3, player);
                    player.getStackInHand(hand).decrement(1);
                }
                else if (mainHand == ModItems.SOUL_CONTAINER_RESISTANCE){
                    activate(4, player);
                    player.getStackInHand(hand).decrement(1);
                }
                else if (mainHand == ModItems.SOUL_CONTAINER_DOLPHIN_GRACE){
                    activate(5, player);
                    player.getStackInHand(hand).decrement(1);
                }
                else if (mainHand == ModItems.SOUL_CONTAINER_NIGHT_VISION){
                    activate(6, player);
                    player.getStackInHand(hand).decrement(1);
                }else{
                    player.sendMessage(Text.literal("§o§7The Command System need to be activated with an Essence Container. "),true);
                    world.playSound(null, pos, ModSounds.GREFFED_COMMAND_SYSTEM_FAIL, SoundCategory.BLOCKS, 1f, 1f);
                }


            }
        }

    }


    public void activate(int id, PlayerEntity player){

        effectID = id;
        world.playSound(null, pos, ModSounds.GREFFED_COMMAND_SYSTEM_ACTIVATE, SoundCategory.BLOCKS, 1f, 2f);
        player.sendMessage(Text.literal("§o§7Command System Activated. "),true);
        isActive = true;

    }


    public Integer getCustomState(){
        return state;
    }



    private void resetTimer() {
        timer = maxTimer;
    }

    private void applyEffect(PlayerEntity player) {

        if(effectID == 1){
            effect = new StatusEffectInstance(StatusEffects.REGENERATION, 3600, 1);
        }
        if(effectID == 2){
            effect = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 3600, 1);
        }
        if(effectID == 3){
            effect = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 3600, 1);
        }
        if(effectID == 4){
            effect = new StatusEffectInstance(StatusEffects.RESISTANCE, 3600, 1);
        }
        if(effectID == 5){
            effect = new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 3600, 1);
        }
        if(effectID == 6){
            effect = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 3600, 1);
        }



        player.addStatusEffect(effect);

    }

    private boolean isBlockCooledDown() {
        if(timer >= 0){
            return false;
        }else {
            return true;
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        nbt.putInt("timer",timer);
        nbt.putInt("effectID",effectID);
        nbt.putBoolean("isActive", isActive);
        nbt.putInt("state", state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        timer = nbt.getInt("timer");
        effectID = nbt.getInt("effectID");
        isActive = nbt.getBoolean("isActive");
        state = nbt.getInt("state");

    }
}
