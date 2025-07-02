package tech.thatgravyboat.skycubed.features.map.dev

import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.Renderable
import net.minecraft.util.ARGB

val COLORS = listOf(
    0xF4EBD3,
    0xDED3C4,
    0x98A1BC,
    0x687FE5,
    0xEBD6FB,
    0xFEEBF6,
    0x898AC4,
    0xA2AADB,
    0xC0C9EE,
    0xEEEFE0,
    0xD1D8BE,
    0xA7C1A8,
).map { ARGB.color(122, it) }

private var lastIndex = 0

data class BoundingBoxWidget(val x: Int, val y: Int, val width: Int, val height: Int) : Renderable {
    val color = COLORS[(lastIndex++ - ++lastIndex) % COLORS.size]
    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, partialTick: Float) {
        guiGraphics.fill(x, y, x + width, y + height, color)
    }
}
