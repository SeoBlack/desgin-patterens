public class IntermediateState extends State {
    public IntermediateState(Character character) {
        super(character);
    }
    public void train(){
        //increase xp
        int current = this.character.getXp();
        this.character.setXp(current + 10);
        System.out.println("trained for 10 XP");
    }
    public void meditate(){
        //increase health
        int current = this.character.getHealth();
        this.character.setHealth(current + 10);
        System.out.println("Meditated for 10 Health");
    }
    public void fight(){
        System.out.println("You can't perform this action");
    }
}
