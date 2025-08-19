package net.supremetor.prismarine.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SentMessage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.supremetor.prismarine.item.ModArmorMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends Item {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.PRISMARINE_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false))).build();

    public ModArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

        return !helmet.isEmpty() && !chestplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        return isCorrectArmorMaterial(player.getEquippedStack(EquipmentSlot.HEAD), material) &&
                isCorrectArmorMaterial(player.getEquippedStack(EquipmentSlot.CHEST), material) &&
                isCorrectArmorMaterial(player.getEquippedStack(EquipmentSlot.LEGS), material) &&
                isCorrectArmorMaterial(player.getEquippedStack(EquipmentSlot.FEET), material);
    }

    private boolean isCorrectArmorMaterial(ItemStack armorItem, ArmorMaterial armorMaterial) {
        EquippableComponent equippableComponent = armorItem.getComponents().get(DataComponentTypes.EQUIPPABLE);
        return equippableComponent.assetId().get().equals(armorMaterial.assetId());
    }
}
