public class RoadTile extends Tile {
    @Override
    public String getCharacter() {
        return "R";
    }
    @Override
    public String getDescription() {
        return "Road Tile";
    }
    @Override
    public void action() {
        System.out.println("Road Tile");
    }
    
}
