import java.util.Random;
import java.util.Arrays;

public class Player {
    boolean isChaosFull;
    String name;
    int currentHealth;
    int maxHealth;
    int attackPower;
    String[] inventory;
    boolean isDefending;

    public void takeDamage(int damage){
        if(isDefending){
            currentHealth-=damage/2;//This section ensures that damage is reduced by half when defending.
        }else{
            currentHealth-=damage;
        }
        Random rand = new Random();
        int random = 1+rand.nextInt(100);//There is a 1% chance of filling the chaos.
        if(random==1){isChaosFull=true;}
        }
    public void heal(int amount){
        currentHealth+=amount;
        if(currentHealth>maxHealth){
            currentHealth=maxHealth;}//This control mechanism prevents your current health from exceeding your maximum health when you are hit.
    }

    public void printStatus(){
        System.out.printf("YOUR HP:%s%n",currentHealth);
        for(int i=0;i<inventory.length;i++){
            System.out.println((i+1)+"-"+inventory[i]);}}
    public static Player createCharacter(String name){
        Player newplayer=new Player();
        newplayer.name=name;
        newplayer.attackPower=15;
        newplayer.inventory=new String[5];
        Arrays.fill(newplayer.inventory,"Empty");
        newplayer.isChaosFull=false;
        newplayer.isDefending=false;
        newplayer.maxHealth=100;
        newplayer.currentHealth=100;

        return newplayer;
    }
    public int chaosForm(){
            return this.attackPower*4;}
    public boolean useHealingPotion(){
        String potionName="Nephilim's respite";
        int healamount=25;
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].equals(potionName)){//
                heal(healamount);
                System.out.printf("%s used %s now current hp is:%d",name,potionName,currentHealth);
                inventory[i]="empty";
                return true;}}
        System.out.println("There is no "+potionName+" left!");
        return false;
    }
    public boolean useShard(){
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].equals("Strength Shard")){
                this.attackPower=attackPower*2;
                inventory[i]="Empty";
                return true;}}
            System.out.println("There is no Strength shard left!");
            return false;}
    public boolean useDivineSunderer(){
        int x=0;
        for(int i=0;i<inventory.length;i++){
            if(inventory[i].equals("Divine sunderer")){
                this.attackPower+=125;
                inventory[i]="Empty";
                i=x;
                return true;}}
        System.out.println("You don't have Divine Sunderer");
        return false;}}

