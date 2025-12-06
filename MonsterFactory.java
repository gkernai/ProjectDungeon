
public class MonsterFactory{//this class helps us to create monster objects with constant stats so that means each Demon etc. have same stat.
    public enum Difficulty{Easy, Medium, Hard,MAYHEM};

    public static Monster createMonster(String m,Difficulty diff){
        Monster monster=new Monster();
        if(diff==Difficulty.Medium){
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
        }}
        if(diff==Difficulty.Easy){
            if(m.equalsIgnoreCase("demon")){
                monster.isDemon=true;
                monster.health=75;
                monster.damage=30;
                monster.name=m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("CorruptedHavensGuard")){
                monster.isCorHavensGuard =true;
                monster.damage=25;
                monster.health=100;
                monster.name =m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("Lucifer")){
                monster.isLucifer=true;
                monster.name=m;
                monster.damage=100;
                monster.health=300;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("HellHound")){
                monster.isHellHound=true;
                monster.health=25;
                monster.damage=10;
                monster.name=m;
                monster.isWrathmeterFull=false;
        }}
        if(diff==Difficulty.Hard){
            if(m.equalsIgnoreCase("demon")){
                monster.isDemon=true;
                monster.health=200;
                monster.damage=80;
                monster.name=m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("CorruptedHavensGuard")){
                monster.isCorHavensGuard =true;
                monster.damage=75;
                monster.health=250;
                monster.name =m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("Lucifer")){
                monster.isLucifer=true;
                monster.name=m;
                monster.damage=250;
                monster.health=700;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("HellHound")){
                monster.isHellHound=true;
                monster.health=75;
                monster.damage=30;
                monster.name=m;
                monster.isWrathmeterFull=false;
        }}
        if(diff==Difficulty.MAYHEM){
            if(m.equalsIgnoreCase("demon")){
                monster.isDemon=true;
                monster.health=300;
                monster.damage=160;
                monster.name=m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("CorruptedHavensGuard")){
                monster.isCorHavensGuard =true;
                monster.damage=125;
                monster.health=400;
                monster.name =m;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("Lucifer")){
                monster.isLucifer=true;
                monster.name=m;
                monster.damage=450;
                monster.health=1000;
                monster.isWrathmeterFull=false;
            }
            if(m.equalsIgnoreCase("HellHound")){
                monster.isHellHound=true;
                monster.health=150;
                monster.damage=75;
                monster.name=m;
                monster.isWrathmeterFull=false;
        }}
        return monster;
    }




































}
