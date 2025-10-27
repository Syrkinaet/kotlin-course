package org.example.lessons.lesson15.homeworks.materials

class Task6: Materials() {

    fun sortedAfterAdd(name: String) {
        val materials = (extractMaterials() + name).sorted()
        materials.forEach { addMaterial(it) }
    }
}