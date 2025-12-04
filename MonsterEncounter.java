public class MonsterEncounter extends RoomContent {
    Monster monster;
    MonsterEncounter(Monster monster){
        this.monster = monster;}
    public Monster getMonster() {
        return this.monster;
    }
}

