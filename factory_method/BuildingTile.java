public class BuildingTile extends Tile {
    @Override
    public String getCharacter() {
        return "B";
    }
    @Override
    public String getDescription() {
        return "Building Tile";
    }
    @Override
    public void action() {
        System.out.println("Building Tile");
    }
    
}
