public class WaterTile extends Tile {
    @Override
    public String getCharacter() {
        return "W";
    }
    @Override
    public String getDescription() {
        return "Water Tile";
    }
    @Override
    public void action() {
        System.out.println("Water Tile");
    }
}
