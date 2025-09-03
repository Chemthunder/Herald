package bcsmp.chemthunder.herald.mixin;

import bcsmp.chemthunder.herald.index.HeraldItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VindicatorEntity.class)
public abstract class VindicatorEntityMixin extends IllagerEntity {
    protected VindicatorEntityMixin(EntityType<? extends IllagerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    private void randomlyGiveSoli(Random random) {
        if ((double) random.nextFloat() > 0.9) {
            int i = random.nextInt(16);
            if (i < 10) {
                this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(HeraldItems.SOLITUDE));
                this.updateDropChances(EquipmentSlot.MAINHAND);
            }
        }
    }

    @Inject(method = "initEquipment", at = @At(value = "TAIL"))
    protected void herald$equipSoliOnVindicators(Random random, LocalDifficulty localDifficulty, CallbackInfo ci) {
        this.randomlyGiveSoli(random);
    }

}