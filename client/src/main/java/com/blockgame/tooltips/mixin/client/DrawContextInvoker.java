package com.blockgame.tooltips.mixin.client;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.text.OrderedText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.Optional;

@Mixin(DrawContext.class)
public interface DrawContextInvoker {

    @Invoker("drawTooltip")
    void drawTooltip(TextRenderer textRenderer, List<Text> text, Optional<TooltipData> data2, int x, int y);

}
