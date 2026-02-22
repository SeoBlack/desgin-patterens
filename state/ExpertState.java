public class ExpertState extends State {
    public ExpertState(Character character) {
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
        //decrease health
        int current = this.character.getHealth();
        this.character.setHealth(current - 10);
        //increase xp
        int currentXp = this.character.getXp();
        this.character.setXp(currentXp + 10);
        System.out.println("fought for 10 XP and lost 10 health");
    }
}
