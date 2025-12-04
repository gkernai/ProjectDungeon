public class MonsterFactory{//this class helps us to create monster objects with constant stats so that means each Demon etc. have same stat.

    public static Monster createMonster(String m){
        Monster monster=new Monster();
        if(m.equalsIgnoreCase("demon")){
            monster.isDemon=true;
            monster.health=150;
            monster.damage=60;
            monster.name=m;
            monster.isWrathmeterFull=false;
        }
        if(m.equalsIgnoreCase("CorruptedHavensGuard")){
            monster.isCorHavensGuard =true;
            monster.damage=50;
            monster.health=200;
            monster.name =m;
            monster.isWrathmeterFull=false;
        }
        if(m.equalsIgnoreCase("Lucifer")){
            monster.isLucifer=true;
            monster.name=m;
            monster.damage=200;
            monster.health=600;
            monster.isWrathmeterFull=false;
        }
        if(m.equalsIgnoreCase("HellHound")){
            monster.isHellHound=true;
            monster.health=50;
            monster.damage=20;
            monster.name=m;
            monster.isWrathmeterFull=false;
        }
        return monster;
    }




































}
