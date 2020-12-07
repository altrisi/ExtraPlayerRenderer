package github.io.lucunji.explayerenderer;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.hotkeys.IKeybindManager;
import fi.dy.masa.malilib.hotkeys.IKeybindProvider;
import github.io.lucunji.explayerenderer.config.ConfigHandler;
import github.io.lucunji.explayerenderer.config.Configs;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Main implements ModInitializer{

    public static final String MOD_ID = "explayerenderer";

    public static final KeyBinding MASTER_CONTROL = new KeyBinding("key." + MOD_ID + ".master_control",
            InputUtil.Type.KEYSYM,
            InputUtil.fromName("key.keyboard.f8").getKeyCode(),
            "key.categories.ui");

    @Override
    public void onInitialize(){
        ConfigManager.getInstance().registerConfigHandler(MOD_ID, new ConfigHandler());
        new Configs();
        ConfigHandler.loadFile();
        InputEventHandler.getKeybindManager().registerKeybindProvider(new KeybindProvider());
        Configs.MENU_OPEN_KEY.getKeybind().setCallback(new KeyBindHandler());
    }

    public static class KeybindProvider implements IKeybindProvider {

        @Override
        public void addKeysToMap(IKeybindManager manager) {
            manager.addKeybindToMap(Configs.MENU_OPEN_KEY.getKeybind());
        }

        @Override
        public void addHotkeys(IKeybindManager manager) {
            // Not necessary
        }
    }
}
