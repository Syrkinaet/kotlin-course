package org.example.lessons.lesson15.homeworks.materials

class Task7: Materials() {

    fun addMap(map: Map<String, String>) {
        val materials = extractMaterials()
        map.keys.reversed().forEach { addMaterial(it) }
        materials.forEach { addMaterial(it) }
        map.values.forEach { addMaterial(it) }
    }
}