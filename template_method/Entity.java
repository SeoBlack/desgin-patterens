import java.util.Random;

public class Entity {
    private int health;
    private String name;

    public Entity(String name) {
        this.health = 100;
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public void takeDamage(int damage) {
        this.health -= damage;
    }
    public boolean isDead() {
        return this.health <= 0;

    }
    public int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

}
