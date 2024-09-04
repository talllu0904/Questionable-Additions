package net.talllu0904.questionableadditions.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.talllu0904.questionableadditions.QuestionableAdditions;
import net.talllu0904.questionableadditions.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuestionableAdditions.MOD_ID);
    public static final RegistryObject<CreativeModeTab> QUESTIONABLE_TAB = CREATIVE_MODE_TABS.register("questionable_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.translatable("creativetab.questionable_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Items
                        output.accept(ModItems.RAW_RUBY.get());
                        output.accept(ModItems.RUBY.get());
                        //BLocks
                        output.accept(ModBlocks.RUBY_BLOCK.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.COMPRESSED_COAL_BLOCK_X1.get());
                    })
                    .build());
    public  static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
