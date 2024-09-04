package net.talllu0904.questionableadditions;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.talllu0904.questionableadditions.block.ModBlocks;
import net.talllu0904.questionableadditions.item.ModCreativeModeTabs;
import net.talllu0904.questionableadditions.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(QuestionableAdditions.MOD_ID)
public class QuestionableAdditions {
    public static final String MOD_ID = "questionableadditions";
    public static final Logger LOGGER = LogUtils.getLogger();
    public QuestionableAdditions() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register((modEventBus));

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }
    @Mod.EventBusSubscriber
    public static class FuelItem {
        @SubscribeEvent
        public static void addFuel(FurnaceFuelBurnTimeEvent event) {
            ItemStack itemStack = event.getItemStack();
            if(itemStack.getItem() == ModBlocks.COMPRESSED_COAL_BLOCK_X1.get().asItem()) {
                event.setBurnTime(160000);

            }
        }
    }
}

