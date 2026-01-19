public class WildernessMap extends Map {
    @Override
    public Tile createTile() {
        int random = (int) (Math.random() * 10);
        if (random < 3) {
            return new SwampTile();
        } else if (random < 6) {
            return new ForestTile();
        } else if (random < 9) {
            return new WaterTile();
        } else {
            return new ForestTile();
        }
    }
}
