public abstract class Map {
    //I don't know if this is the best way to do it !!! 
    private Tile[][] tiles;
    public Map() {
        tiles = new Tile[10][10];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = createTile();
            }
        }
    }
    public abstract Tile createTile();
    public void display() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
