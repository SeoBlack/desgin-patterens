public class CityMap extends Map {
    @Override
    public Tile createTile() {
        int random = (int) (Math.random() * 10);
        if (random < 3) {
            return new RoadTile();
        } else if (random < 6) {
            return new ForestTile();
        } else if (random < 9) {
            return new BuildingTile();
        } else {
            return new BuildingTile();
        }
    }
}
