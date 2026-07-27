package com.duypon.inscraftion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Inscraftion implements ModInitializer {
    public static final String MOD_ID = "inscraftion";

    // 1. Ítems base
    public static final Item SQUIRREL = new Item(new Item.Settings());
    public static final Item STOAT_TALKING = new Item(new Item.Settings());

    // 2. Creamos la pestaña creativa usando la API de Fabric
    public static final ItemGroup INSCRAFTION_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SQUIRREL)) // El ícono de la pestaña será la ardilla
            .displayName(Text.translatable("itemGroup.inscraftion.cartas")) // Nombre traducible
            .entries((context, entries) -> {
                entries.add(SQUIRREL);      // Metemos la ardilla en la pestaña
                entries.add(STOAT_TALKING); // Metemos el armiño en la pestaña
            })
            .build();

    @Override
    public void onInitialize() {
        // Registramos los ítems
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "squirrel"), SQUIRREL);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "stoat_talking"), STOAT_TALKING);

        // Registramos la pestaña en el juego
        Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "cartas_group"), INSCRAFTION_GROUP);
    }
}
