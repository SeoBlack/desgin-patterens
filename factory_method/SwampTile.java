public class SwampTile extends Tile {
    @Override
    public String getCharacter() {
        return "S";
    }
    @Override
    public String getDescription() {
        return "Swamp Tile";
    }
    @Override
    public void action() {
        System.out.println("Swamp Tile");
    }
}
