package com.innocsnt.gestalt.data.local

import com.innocsnt.gestalt.data.model.Class
import com.innocsnt.gestalt.data.model.Construct
import com.innocsnt.gestalt.data.model.Element
import com.innocsnt.gestalt.data.model.ElementDistribution
import com.innocsnt.gestalt.data.model.Memories
import com.innocsnt.gestalt.data.model.MemoryPosition

class DataManager {
    val constructList = ArrayList<Construct>()
    val classList = ArrayList<Class>()
    private val elementList = ArrayList<Element>()
    private val memoryList = ArrayList<Memories>()

    private val classMap = mutableMapOf<Int, Class>()
    private val elementMap = mutableMapOf<Int, Element>()
    private val memoryMap = mutableMapOf<Int, Memories>()

    fun loadData() {
        loadClassList()
        loadEleList()
        loadMemoList()
        loadCons()
    }

    private fun loadCons() {
        constructList.addAll(
            listOf(
                Construct(
                    "Lucia",
                    "Lotus",
                    "https://static.wikia.nocookie.net/punishing-gray-raven/images/f/f6/Character-Lotus-Portrait.png/revision/latest?cb=20210910123405",
                    "https://static.wikia.nocookie.net/punishing-gray-raven/images/a/aa/Coating-Lotus-Generic.png/revision/latest?cb=20210903045300",
                    "https://static.miraheze.org/pgrwiki/8/87/Dialogue-Lotus-Awaken-Icon.png",
                    "https://static.miraheze.org/pgrwiki/d/d4/Dialogue-Lotus-Chibi-Icon.png",
                    "https://static.miraheze.org/pgrwiki/f/f1/Dialogue-Lotus-Icon.png",
                    "B",
                    "Leader of Gray Raven. Brave and selfless, she is ever at the frontline of the war against the Corrupted.",
                    "Duel - Has strong single attack ability\n" + "Dual Blades - Attack DMG boosting skill",
                    "1113",
                    "159",
                    "223",
                    "101",
                    "17",
                    "15 june",
                    "165kg",
                    "48kg",
                    "A",
                    getClassById(1),
                    listOf(
                        ElementDistribution(
                            getElementById(1),
                            80.0
                        ),
                        ElementDistribution(
                            getElementById(2),
                            20.0
                        )
                    ),
                    listOf(
                        MemoryPosition(
                            getMemoryById(1),
                            4
                        ),
                        MemoryPosition(
                            getMemoryById(2),
                            2
                        )
                    )
                ),


            )
        )
    }

    private fun loadClassList() {
        with(classList) {
            addAll(
                listOf(
                    Class(
                        1,
                        "Attacker",
                        "https://static.wikia.nocookie.net/punishing-gray-raven/images/e/e0/Assault.png/revision/latest/scale-to-width-down/40?cb=20200830032602"
                    ),
                    Class(
                        2,
                        "Support",
                        "https://static.wikia.nocookie.net/punishing-gray-raven/images/a/ab/Support.png/revision/latest/scale-to-width-down/40?cb=20200830032550"
                    ),
                    Class(
                        3,
                        "Tank",
                        "https://static.wikia.nocookie.net/punishing-gray-raven/images/9/9d/Tank.png/revision/latest/scale-to-width-down/40?cb=20200830032537"
                    ),

                    )
            )
        }
        classList.forEach { classMap[it.classId] = it }
    }

    private fun loadEleList() {
        with(elementList) {
            addAll(
                listOf(
                    Element(
                        1,
                        "Physical",
                        "https://static.miraheze.org/pgrwiki/thumb/7/70/Element-Physical-Icon-White.png/25px-Element-Physical-Icon-White.png",
                    ),
                    Element(
                        2,
                        "Fire",
                        "https://static.miraheze.org/pgrwiki/thumb/3/31/Element-Fire-Icon-White.png/25px-Element-Fire-Icon-White.png"
                    )
                )
            )
        }
        elementList.forEach { elementMap[it.elementId] = it }
    }

    private fun loadMemoList() {
        with(memoryList) {
            addAll(
                listOf(
                    Memories(
                        1,
                        "Patton",
                        "https://static.miraheze.org/pgrwiki/9/90/Memory-Patton-Icon-1.png"
                    ),
                    Memories(
                        2,
                        "Frederick",
                        "https://static.miraheze.org/pgrwiki/f/f1/Memory-Frederick-Icon-1.png"
                    )
                )
            )
        }
        memoryList.forEach { memoryMap[it.memoryId] = it }
    }

    private fun getClassById(id: Int): Class =
        classMap[id] ?: throw NoSuchElementException("Class with ID $id not found")

    private fun getElementById(id: Int): Element {
        return elementList.find { it.elementId == id }
            ?: throw NoSuchElementException("Element with ID $id not found")
    }

    private fun getMemoryById(id: Int): Memories {
        return memoryList.find { it.memoryId == id }
            ?: throw NoSuchElementException("Memory with ID $id not found")
    }
}


