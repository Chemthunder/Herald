package bcsmp.chemthunder.herald.index;

import bcsmp.chemthunder.herald.Herald;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public interface HeraldDamageSources {
    RegistryKey<DamageType> GRACE_KILL = of("grace_kill");
    RegistryKey<DamageType> SOLITUDE_KILL = of("solitude_kill");

    static DamageSource grace_kill(LivingEntity entity) {
        return entity.getDamageSources().create(GRACE_KILL); }

    static DamageSource solitude_kill(LivingEntity entity) {
        return entity.getDamageSources().create(SOLITUDE_KILL); }


    private static RegistryKey<DamageType> of(String name) {
        return RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Herald.id(name));
    }
}
