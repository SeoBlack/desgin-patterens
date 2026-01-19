public class ForestTile extends Tile {
    @Override
    public String getCharacter() {
        return "F";
    }
    @Override
    public String getDescription() {
        return "Forest Tile";
    }
    @Override
    public void action() {
        System.out.println("Forest Tile");
    }
    
}
