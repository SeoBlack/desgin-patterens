public class Character {
    protected int health = 50;
    protected int xp = 0;
    protected String name;
    protected int level = 0;
    State state ;
    public Character(String name) {
        this.name = name;
        this.state = new NoviceState(this);
    }
    public void setState(State state) {
        this.state = state;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = Math.min(health, 100);
    }
    public int getXp() {
        return xp;
    }
    public void setXp(int xp) {
        this.xp = xp;

    }
    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLevel() {

        return level;

    }
    public void setLevel(int level) {
        this.level = level;

    }


}
