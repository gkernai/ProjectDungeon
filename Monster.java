import java.util.Random;

public class Monster {
    String name;
    int health;
    int damage;
    boolean isDemon;
    boolean isCorHavensGuard;
    boolean isLucifer;
    boolean isHellHound;
    boolean isWrathmeterFull; //This value exists to prevent the constant use of special actions; the condition for filling this bar is when your health falls below 30%.
    public void takeDamage(int damage){
        health-=damage;
        if(health<=health*30/100){ //When monsters' health falls below 30%, their wrath bars will automatically fill up.
            isWrathmeterFull =true;}}
    public boolean isDefeated(){return (health<=0);}
    public void performSpecialAction(){
        if(isWrathmeterFull){
            if(isDemon){
                System.out.println("The blades of hell's are burning!");
                isWrathmeterFull=false;
                this.damage+=20;}
            else if(isCorHavensGuard){
                System.out.println("The guard of the haven ascended!");
                isWrathmeterFull=false;
                this.damage=damage+10;
                this.health+=50;}
            else if(isLucifer){
                System.out.println("The rituel is complete Lucifer's plan worked!(Lucifer gained bonus stats!)");
                isWrathmeterFull=false;
                this.damage+=50;
                this.health+=50;}
            else if(isHellHound){
                System.out.println("HellHound... Never mind, it's just a burning dog, nothing happened.");
                isWrathmeterFull=false;}
        }else{
            System.out.println("Wrathmeter must be full for special action");
        }}




    }

