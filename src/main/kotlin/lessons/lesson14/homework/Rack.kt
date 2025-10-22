package org.example.lessons.lesson14.homework

class Rack(private val maxShelves: Int) {
    private val listOfShelves = mutableListOf<Shelf>()
    fun addShelf(shelf: Shelf): Boolean {
        if (listOfShelves.contains(shelf) || listOfShelves.size == maxShelves) {
            return false
        }
        listOfShelves.add(shelf)
        return true
    }

    fun removeShelf(index: Int): List<String> {
        if (index in listOfShelves.indices) {
            val items = listOfShelves[index].getItems()
            listOfShelves.removeAt(index)
            return items
        } else {
            return emptyList()
        }
    }

    fun addItem(name: String): Boolean {
        for (shelf in listOfShelves) {
            if (shelf.canAccommodate(name)) {
                return shelf.addItem(name)
            }
        }
        return false
    }

    fun removeItem(name: String): Boolean {
        for (shelf in listOfShelves) {
            if (shelf.containsItem(name)) {
                return shelf.removeItem(name)
            }
        }
        return false
    }

    fun containsItem(name: String): Boolean {
        for (shelf in listOfShelves) {
            if (shelf.containsItem(name)) {
                return true
            }
        }
        return false
    }

    fun getShelves() = listOfShelves.toList()

    fun printContents() {
        for (i in listOfShelves.indices) {
            val capacity = listOfShelves[i].capacity
            val accessiblePlace = capacity - listOfShelves[i].getItems()
                .map { it.length }
                .sum()
            val meta = "$i вместимость: $capacity, доступно: $accessiblePlace"
            val items = listOfShelves[i].getItems().joinToString()
            println(meta)
            println("Предметы: $items")
        }
    }

    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in listOfShelves.indices) {
            return emptyList()
        }
        val notReplacedItems = mutableListOf<String>()
        val sortedShelves = listOfShelves.sortedByDescending { it.capacity }

        for (item in sortedShelves[index].getItems()) {
            if (sortedShelves.none { it.addItem(item) }) {
                notReplacedItems.add(item)
            }
        }
        listOfShelves.removeAt(index)
        return notReplacedItems.toList()
    }
}