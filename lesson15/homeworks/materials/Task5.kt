package org.example.lessons.lesson15.homeworks.materials

class Task5 : Materials() {

    fun addList(list: List<String>){

        val materials = extractMaterials()
        val index = list.lastIndex + materials.lastIndex
        for (i in 0 until index) {
            if (i < list.size) {
                addMaterial(list[i])
            }
            if (i < materials.size) {
                addMaterial(materials[i])
            }
        }
    }
}