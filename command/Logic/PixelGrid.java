package Logic;

public class PixelGrid {
    private final int SIZE = 8;
    private int[][] grid = new int[SIZE][SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public int[][] getGrid() {
        return grid;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    // Movement logic
    public void moveUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    // Toggle pixel
    public void togglePixel() {
        grid[cursorRow][cursorCol] =
                (grid[cursorRow][cursorCol] == 0) ? 1 : 0;
    }

    // Generate Java code
    public String generateCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");

        for (int i = 0; i < SIZE; i++) {
            sb.append("    {");
            for (int j = 0; j < SIZE; j++) {
                sb.append(grid[i][j]);
                if (j < SIZE - 1) sb.append(", ");
            }
            sb.append("}");
            if (i < SIZE - 1) sb.append(",");
            sb.append("\n");
        }

        sb.append("};");
        return sb.toString();
    }
}