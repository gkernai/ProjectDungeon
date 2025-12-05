import java.util.Random;
import java.util.Scanner;

public class DungeonGame {
    static int playerRow;
    static int playerCol;
    static boolean gamewon=false;
    static Player player;
    static RoomContent[][] map=new RoomContent[5][5];
    public static void setGameWon(boolean is){
        if( is==true || is==false){
            gamewon=is;}
    }
public static void printMap() {
    System.out.println("====== MAP ======");
   
    System.out.print("  ");
    for (int col = 0; col < map[0].length; col++) {
        System.out.printf(" %d ", col);
    }
    System.out.println(); 
	for (int row = 0; row < map.length; row++) {
     
        System.out.printf("%d ", row);

        for (int col = 0; col < map[row].length; col++) {
            String symbol = " E "; 
			if (row == playerRow && col == playerCol) {
                symbol = " P "; 
            } else if (map[row][col] instanceof MonsterEncounter) {
            	MonsterEncounter me = (MonsterEncounter) map[row][col];
                if (me.getMonster().name.equals("Lucifer")) {
                    symbol = " L "; 
                } else {
                    symbol = " M "; 
                }
            } else if (map[row][col] instanceof HollowsGift) {
                symbol = " H "; 
            } else if (map[row][col] instanceof MimicRoom) {
                symbol = " T "; 
            }

            System.out.print(symbol);
        }
        System.out.println(); 
    }
    System.out.println("=================");
    System.out.println("P:player, M:monster, H:Treasure, T:trap, E:empty, L:Boss");
}
			

public static void startCombat(Player player,Monster monster){
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println("=========================================");
        System.out.printf("War begins!you encountered! %s(%d hp) %n",monster.name,monster.health);
        System.out.println("=========================================");
        System.out.printf("CurrentHP:%d%n",player.currentHealth);
        while(player.currentHealth>0 && monster.health>0){
            player.isDefending=false;

            System.out.printf("%s's turn!%n",monster.name);
            player.printStatus();
            System.out.printf("%s's hp:%d Damage:%d%n",monster.name,monster.health,monster.damage);
            System.out.println("What do you want to do?");
            System.out.println("1-Attack\n2-Defence\n3-Heal\n4-Use Shard\n5-Use Divine Sunderer\n6-Use Chaosform");
            String choice = input.nextLine();
            switch (choice){
                case "1":
                    int baseDamage=player.attackPower;
                    int rand=1+random.nextInt(10);
                    if(rand==1){
                    monster.takeDamage(baseDamage*2);
                        if(monster.isDefeated()){
                            System.out.printf("%s is defeated!%n",monster.name);

                            break;
                        }else{
                            System.out.printf("%s's current hp is:%d%n",monster.name,monster.health);
                            break;}
                    }else{
                        monster.takeDamage(baseDamage);
                        System.out.printf("%s's current hp is:%d%n",monster.name,monster.health);
                        break;}
                case "2":
                    player.isDefending=true;
                    break;
                case "3":
                    player.useHealingPotion();
                    break;
                case "4":
                    player.useShard();
                    break;
                case "5":
                    player.useDivineSunderer();
                    break;
                case "6":
                    if(player.isChaosFull){
                        player.chaosForm();}
                    else{System.out.println("Your chaos is not ready yet!");}
                default:
                    System.out.println("Invalid choice.");
                    break;}
            System.out.printf("%s's turn!",monster.name);
             int monsterat=1+random.nextInt(2);
             switch(monsterat){
                 case 1:
                     int critrandommonster=1+random.nextInt(10);
                     if(critrandommonster==1) {
                         player.takeDamage(monster.damage * 2);}
                     else{player.takeDamage(monster.damage);}
                     break;
                case 2:
                    monster.performSpecialAction();
                    break;}
        }
            if(player.currentHealth<=0){System.out.println("You lost!");}
            else{System.out.println("You won!!");}}



    private static RoomContent[][] createMap(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                map[i][j]=new EmptyRoom();}}
        map[1][0]=new HollowsGift("Strength Shard");
        map[2][0]=new HollowsGift("Nephilim's respite");
        map[3][0]=new HollowsGift("Nephilim's respite");
        map[4][0]=new HollowsGift("Divine Sunderer");
        map[3][4]=new HollowsGift("Nephilim's respite");
        map[1][4]=new HollowsGift("Strength Shard");
        map[0][4]=new MimicRoom();
        map[2][4]=new MimicRoom();
        map[1][1]=new MonsterEncounter(MonsterFactory.createMonster("HellHound"));
        map[1][2]=new MonsterEncounter(MonsterFactory.createMonster("HellHound"));
        map[1][3]=new  MonsterEncounter(MonsterFactory.createMonster("HellHound"));
        map[2][1]=new MonsterEncounter(MonsterFactory.createMonster("Demon"));
        map[2][2]=new MonsterEncounter(MonsterFactory.createMonster("CorruptedHavensGuard"));
        map[2][3]=new  MonsterEncounter(MonsterFactory.createMonster("Demon"));
        map[3][2]=new  MonsterEncounter(MonsterFactory.createMonster("CorruptedHavensGuard"));
        map[4][2]=new  MonsterEncounter(MonsterFactory.createMonster("Lucifer"));
            return map;}
    public static void main(String[] args){
        RoomContent[][]  map=createMap();       
        Player player=Player.createCharacter("Chemax");
        playerCol=0;
        playerRow=0;
        RoomContent currentroom =map[playerRow][playerCol];
        System.out.println("===Welcome to the Dungeon Game!===");
        System.out.println("You are in mysterious fortress and you feeling...suppresed some voices comes to your ears and says OBEY!");
        System.out.println("What do you want to do?");
		printMap();
        player.printStatus();
        do{
            Scanner input=new Scanner(System.in);
            System.out.println("Guide:For moving around you need to use N,E,W,S keys,for checking the player status press I");
            String movement=input.nextLine();
            switch (movement){
                    case "N":
                        if(playerRow-1<0){
                            System.out.println("Çıkmaz bir yol....");
								printMap();
                            break;}
                        else{
                            playerRow-=1;
                            System.out.println("Current location is Row:"+playerRow+" Col:"+playerCol);
                            currentroom =map[playerRow][playerCol];
							printMap();}
                            break;
                    case "S":
                        if(playerRow+1>4){
                            System.out.println("Çıkmaz bir yol....");
								printMap();
                            break;}
                        else{
                            playerRow+=1;
                            System.out.println("Current location is Row:"+playerRow+" Col:"+playerCol);
                            currentroom =map[playerRow][playerCol];
							printMap();}
                            break;
                    case "W":
                        if(playerCol-1<0){
                            System.out.println("Deadend....");
								printMap();
                            break;}
                        else{
                            playerCol-=1;
                            System.out.println("Current location is Row:"+playerRow+" Col:"+playerCol);
                            currentroom =map[playerRow][playerCol];
							printMap();}
                            break;
                    case "E":
                        if(playerCol+1>4){System.out.println("Deadend....");
								printMap();
                            break;}
                        else{
                            playerCol+=1;
                            System.out.println("Current location is Row:"+playerRow+" Col:"+playerCol);
                            currentroom =map[playerRow][playerCol];
								printMap();}
                            break;
                    case "I":
                    player.printStatus();
                    break;

                    default:
                        System.out.println("Guide:For moving around you need to use N,E,W,S keys ");
                        break;}

                    if(currentroom instanceof MonsterEncounter){
                        MonsterEncounter encounter=(MonsterEncounter)currentroom;
                        Monster encounteredMonster=encounter.getMonster();
                        startCombat(player,encounteredMonster);
                        if(encounteredMonster.health<=0){
                            System.out.printf("%s is killed! room cleansed%n",encounteredMonster.name);
                            map[playerRow][playerCol] = new EmptyRoom();}}
                    else if(currentroom instanceof HollowsGift){
                        HollowsGift gift=(HollowsGift)currentroom;
                        String item=gift.getItem();
                        boolean added=false;
                        for(int i=0;i<player.inventory.length;i++){
                            if(player.inventory[i].equals("Empty")){
                                player.inventory[i]=item;
                                System.out.println(item+" has found!!");
                                added=true;
                                map[playerRow][playerCol] = new EmptyRoom();
                                break;}}
                        if(!added) {
                            System.out.println("There's no room for " + item);
                        }}
                    else if(currentroom instanceof MimicRoom){
                        MimicRoom mimicroom=(MimicRoom)currentroom;
                        mimicroom.Trap(player);
                        if(player.currentHealth<=0){
                            setGameWon(false);}
                    }






            }while(!gamewon && player.currentHealth>0);


    }}
