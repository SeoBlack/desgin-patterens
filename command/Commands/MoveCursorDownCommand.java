package Commands;

import Logic.PixelGrid;

public class MoveCursorDownCommand implements Command {
    private PixelGrid grid;
    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }
    public void execute() {
        grid.moveDown();
    }
}