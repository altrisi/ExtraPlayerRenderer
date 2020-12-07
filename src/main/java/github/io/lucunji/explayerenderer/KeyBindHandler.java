package github.io.lucunji.explayerenderer;

import fi.dy.masa.malilib.hotkeys.IHotkeyCallback;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyAction;
import github.io.lucunji.explayerenderer.client.render.screen.GuiConfig;
import net.minecraft.client.MinecraftClient;

public class KeyBindHandler implements IHotkeyCallback {

	@Override
	public boolean onKeyAction(KeyAction action, IKeybind key) {
		MinecraftClient.getInstance().openScreen(new GuiConfig());
		return true;
	}
}
