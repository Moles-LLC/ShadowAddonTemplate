package me.shitcum.fart.modules;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import net.shadow.client.feature.module.AddonModule;
import net.shadow.client.helper.render.Renderer;
import net.shadow.client.helper.util.Utils;

import java.awt.*;

public class TestModule extends AddonModule {
    public TestModule() {
        // configuration for the module, name and description
        // module type not applicable here
        super("AddonTestModule", "Example addon for shadow");
    }

    @Override
    public void tick() {
        // called every player tick (20 times a second)
        Utils.Logging.message("Ticked");
    }

    @Override
    public void enable() {
        // called every time the module gets enabled
        Utils.Logging.message("Enabled");
    }

    @Override
    public void disable() {
        // called every time the module gets disabled
        Utils.Logging.message("Disabled");
    }

    @Override
    public String getContext() {
        // called every time the hud wants "context" from the module (to display right next to it in the arraylist)
        return "context";
    }

    @Override
    public void onWorldRender(MatrixStack matrices) {
        // called every time the world is rendered (do world rendering operations here)
        Renderer.R3D.renderEdged(matrices, Vec3d.ZERO,new Vec3d(1,1,1), Color.RED,Color.WHITE);
    }

    @Override
    public void onHudRender() {
        // called every time the hud is rendered (do hud rendering operations here)
    }
}
