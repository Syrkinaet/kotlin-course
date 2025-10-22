package org.example.lessons.lesson14.homework

class Shelf(val capacity: Int) {

    private var tmpCapacity = capacity
    private val tmpItems: MutableList<String> = mutableListOf()
    fun addItem(nameItem: String): Boolean {
        val nameSum = nameItem.length
        if (nameSum <= tmpCapacity) {
            tmpCapacity -= nameSum
            tmpItems.add(nameItem)
            return true
        } else {
            return false
        }
    }

    fun removeItem(nameItem: String): Boolean {
        val nameSum = nameItem.length
        if (tmpItems.contains(nameItem)) {
            tmpCapacity += nameSum
            tmpItems.remove(nameItem)
            return true
        } else {
            return false
        }

    }

    fun canAccommodate(nameItem: String): Boolean {
        val nameSum = nameItem.length
        if (nameSum <= tmpCapacity) {
            return true
        } else {
            return false
        }
    }

    fun containsItem(nameItem: String) = tmpItems.contains(nameItem)


    fun getItems() = tmpItems.toList()

}
