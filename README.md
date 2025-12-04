# ⚔️ Simple Dungeon Adventure: Echoes of Darksiders

This project is a final term assignment developed for the **Computer Programming 1** course. Its primary goal is to apply the fundamental **Object-Oriented Programming (OOP)** principles learned throughout the semester.

The game is a simple text-based (console) dungeon adventure written in **Java**.

## 📜 Game Theme and Lore

The theme of this universe is largely drawn from the mythology of the **Darksiders** universe. This mythology also incorporates biblical references.

## 💻 Applied Core OOP Concepts

The project strongly emphasizes the practical application of OOP principles, particularly **Inheritance** in its level design:

* **Room Content Hierarchy:** Classes such as `Mimic Room` (trap room) and `Hollowsgifts Room` (treasure rooms) are consolidated under the superclass `RoomContent.java` through inheritance.
* **Entity Definitions:**
    * The `Player` class defines the player's creation and abilities.
    * The `Monster` class contains the basic characteristics of the monsters encountered.
    * The `MonsterFactory` class is responsible for quickly generating monster objects with constant stats (e.g., all Demons have the same stats).
    * `MonsterEncounter` is a utility class used to simplify monster placement within rooms.

## 🎮 Core Game Mechanics

The game progresses with a simple mechanism. The `Player` class contains basic instance values like name, health, and attack power.

### 1. Player Abilities

The player's abilities are sufficient for effective gameplay:

* **`isChaosFull`:** This signature design is linked to the Darksiders universe and functions similarly to a 'wrath meter' found in monsters.
* **`chaosform`:** This form activates to multiply the player's damage by 4.
* **`divinesunderer`:** Using this blade grants a damage boost against celestial creatures (demonic and angelic).
* **Consumable Items:** The player can use items like `nephilim's respite` (a healing potion) and a `strength shard` (which provides double damage).

### 2. Map and Room Structure

The map design uses arrays, as required by the project specifications.

* The map is a **5x5** grid, comprising 25 rooms.
* Rooms can contain valuable items, be clean (unaffected by Lucifer's corruption), or contain a trap.
* An `Empty room` is, as its name suggests, a room without content.
* One room on the map holds the **DivineSunderer** sword, an item that significantly increases the player's damage.

### 3. Special Encounter: The Mimic

Some rooms contain a Mimic creature disguised as a chest, which acts as a deadly trap.

* The Mimic ambushes the player instantly, resulting in a loss of 15 HP.
* Due to the instantaneous nature of the attack, no combat mechanics can be activated or countered.
* The ambush succeeds because the player character has never encountered such a treacherous creature before.
