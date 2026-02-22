public abstract class State {
    protected Character character;
    public  State(Character character){
        this.character = character;
    }
    abstract public void train();
    abstract public void meditate();
    abstract public void fight();
}
