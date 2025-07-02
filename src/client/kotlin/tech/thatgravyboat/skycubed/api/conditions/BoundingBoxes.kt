package tech.thatgravyboat.skycubed.api.conditions

import me.owdding.ktcodecs.GenerateCodec
import net.minecraft.core.Vec3i

@GenerateCodec
data class Rectangle(val x: Int, val y: Int, val x2: Int, val y2: Int, val plane: Axis) {
    fun test(pos: Vec3i) = plane.test(x, y, x2, y2, pos)
}

enum class Axis {

    XY {
        override fun test(x: Int, y: Int, x2: Int, y2: Int, pos: Vec3i) = pos.x in x..x2 && pos.y in y..y2
    },
    XZ {
        override fun test(x: Int, z: Int, x2: Int, z2: Int, pos: Vec3i) = pos.x in x..x2 && pos.z in z..z2
    },
    ZY {
        override fun test(z: Int, y: Int, z2: Int, y2: Int, pos: Vec3i) = pos.z in z..z2 && pos.y in y..y2
    },
    ZX {
        override fun test(z: Int, x: Int, z2: Int, x2: Int, pos: Vec3i) = pos.z in z..z2 && pos.x in x..x2
    },
    YX {
        override fun test(y: Int, x: Int, y2: Int, x2: Int, pos: Vec3i) = pos.y in y..y2 && pos.x in x..x + x2
    },
    YZ {
        override fun test(y: Int, z: Int, y2: Int, z2: Int, pos: Vec3i) = pos.y in y..y2 && pos.z in z..z2
    },
    ;

    abstract fun test(x: Int, y: Int, x2: Int, y2: Int, pos: Vec3i): Boolean

}
