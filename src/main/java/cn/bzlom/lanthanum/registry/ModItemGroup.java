package cn.bzlom.lanthanum.registry;

import cn.bzlom.lanthanum.Lanthanum;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup LanthanumBase = FabricItemGroup.builder(new Identifier(Lanthanum.MOD_ID, "gemstone"))
            .displayName(Text.translatable("itemGroup.lanthanum.lanthanumBase"))
            .icon(() -> new ItemStack(ModItems.GEMSTONE))
            .build();

    public static void registerModItemGroup() {
        Lanthanum.LOGGER.debug("Registering mod item group for" + Lanthanum.MOD_ID);
    }
}
