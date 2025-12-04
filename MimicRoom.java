public class MimicRoom extends RoomContent{
    public MimicRoom(){}
    public void Trap(Player player){
        int trapDamage=15;
        System.out.println("A fancy chest catches your eye, and you head over to open it... ");
        System.out.println("When you try to open the chest, you hear a disgusting laugh.");
        System.out.println("You realise it's a monster(Mimic), but you're immediately attacked.");
        player.takeDamage(trapDamage);
        System.out.println("The trickster creature attacks you and then vanishes into thin air...");
        if(player.currentHealth<=0){
            System.out.println("The mimic's trap proved fatal...");

        }
    }
}
