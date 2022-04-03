package me.shitcum.fart;

import me.shitcum.fart.command.TestCommand;
import me.shitcum.fart.modules.TestModule;
import net.minecraft.util.Identifier;
import net.shadow.client.feature.addon.Addon;
import net.shadow.client.feature.command.Command;
import net.shadow.client.feature.module.AddonModule;

import java.util.List;

// Main class for the addon
// Any class extending Addon is seen as main class
// There can only be exactly one main class per addon, or else it is invalidated and not loaded
@SuppressWarnings("unused")
public class ShadowMain extends Addon {
    // The list of custom modules we want to register
    List<AddonModule> addonModules = List.of(new TestModule());
    // The list of custom commands we want to register
    List<Command> addonCommands = List.of(new TestCommand());
    public ShadowMain() {
        // Configuration for the addon, name, description and authors
        super("ExampleAddon", "An example of how to set up an addon with shadow", new String[]{"0x150", "Shadow"});
    }
    @Override
    public Identifier getIcon() {
        // this is the icon of the addon that gets shown in the addon screen
        // i recommend downloading the icon from the internet, and registering it using Utils.registerBufferedImageTexture(bufferedImageFromInternet, identifierToUse);
        // and then returning that identifier you used
        // this is an example
        // nullable for default icon
        return new Identifier("textures/misc/enchanted_item_glint.png");
    }

    @Override
    public List<AddonModule> getAdditionalModules() {
        // gets the custom modules you want to register
        // nullable
        return addonModules;
    }

    @Override
    public List<Command> getAdditionalCommands() {
        // gets the custom commands you want to register
        // nullable
        return addonCommands;
    }

    @Override
    public void enabled() {
        // called when the addon is enabled
        System.out.println("Addon got enabled!");
    }

    @Override
    public void disabled() {
        // called when the addon is disabled
        System.out.println("Addon is disabled!");
    }

    @Override
    public void reloaded() {
        // called when the addon is reloaded
        // this will reload the addon from disk, not just reinizialize it
        System.out.println("Addon got reloaded from disk!");
    }
}
