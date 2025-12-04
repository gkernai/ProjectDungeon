public class MonsterEncounter extends RoomContent {//This super class holds other room classes such as mimic room.
    Monster monster;
    MonsterEncounter(Monster monster){
        this.monster = monster;}
    public Monster getMonster() {
        return this.monster;
    }
}


