public class NoviceState extends State {
    public NoviceState(Character character) {
        super(character);
    }
     public void train(){
        //increase xp
         int current = this.character.getXp();
         this.character.setXp(current + 10);
         System.out.println("trained for 10 XP");
     }
     public void meditate(){
         System.out.println("You can't perform this action");
     }
     public void fight(){
         System.out.println("You can't perform this action");
     }
}
