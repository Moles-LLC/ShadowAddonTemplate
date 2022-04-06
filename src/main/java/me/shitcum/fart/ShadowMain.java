package me.shitcum.fart;

import me.shitcum.fart.command.TestCommand;
import me.shitcum.fart.modules.TestModule;
import net.minecraft.util.Identifier;
import net.shadow.client.feature.addon.Addon;
import net.shadow.client.feature.command.Command;
import net.shadow.client.feature.module.AddonModule;
import net.shadow.client.helper.Texture;
import net.shadow.client.helper.util.Utils;

import javax.imageio.ImageIO;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

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
        // i recommend adding the icon as resource, and loading that when the icon is first requested
        // and then returning that identifier you used
        // this is an example
        // nullable for default icon
        return loadIcon();
    }
    Texture iconStored = null;
    Identifier loadIcon() {
        if (iconStored != null) return iconStored;
        InputStream is = getClass().getClassLoader().getResourceAsStream("unknown.png");
        Objects.requireNonNull(is);
        try {
            iconStored = new Texture("amogussus");
            Utils.registerBufferedImageTexture(iconStored, ImageIO.read(is));
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iconStored;
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
