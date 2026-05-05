
import Commands.*;
import Logic.PixelGrid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;

public class CommandApp extends Application {

        private PixelGrid grid = new PixelGrid();
        private final int CELL_SIZE = 40;
        Command up = new MoveCursorUpCommand(grid);
        Command down = new MoveCursorDownCommand(grid);
        Command left = new MoveCursorLeftCommand(grid);
        Command right = new MoveCursorRightCommand(grid);
        Command toggle = new TogglePixelCommand(grid);

        @Override
        public void start(Stage stage) {
            Canvas canvas = new Canvas(8 * CELL_SIZE, 8 * CELL_SIZE);
            canvas.setFocusTraversable(true);
            canvas.setOnMouseClicked(e -> canvas.requestFocus());
            GraphicsContext gc = canvas.getGraphicsContext2D();

            Button generateBtn = new Button("Generate Code");
            generateBtn.setFocusTraversable(false);

            Label cursorPosLabel = new Label();
            cursorPosLabel.setStyle("-fx-font-family: monospace; -fx-font-size: 13px;");

            generateBtn.setOnAction(e -> {
                Command cmd = new GenerateCodeCommand(grid);
                cmd.execute();
                canvas.requestFocus();
            });

            Scene scene = new Scene(new VBox(8, canvas, cursorPosLabel, generateBtn));

            scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
                KeyCode key = e.getCode();
                switch (key) {
                    case UP:
                        up.execute();
                        break;
                    case DOWN:
                        down.execute();
                        break;
                    case LEFT:
                        left.execute();
                        break;
                    case RIGHT:
                        right.execute();
                        break;
                    case SPACE:
                        toggle.execute();
                        break;
                    default:
                        return;
                }
                e.consume();
                draw(gc, cursorPosLabel);
            });

            draw(gc, cursorPosLabel);

            stage.setScene(scene);
            stage.setTitle("Pixel Art Editor");
            stage.show();
            Platform.runLater(() -> canvas.requestFocus());

        }

        private void draw(GraphicsContext gc, Label cursorPosLabel) {
            int[][] data = grid.getGrid();
            int row = grid.getCursorRow();
            int col = grid.getCursorCol();

            cursorPosLabel.setText(String.format("Cursor: row %d, col %d", row + 1, col + 1));

            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {

                    if (data[r][c] == 1) {
                        gc.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    } else {
                        gc.clearRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }

                    gc.setStroke(Color.LIGHTGRAY);
                    gc.setLineWidth(1);
                    gc.strokeRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }

            gc.save();
            gc.setStroke(Color.DODGERBLUE);
            gc.setLineWidth(3);
            double inset = 1.5;
            gc.strokeRect(
                    col * CELL_SIZE + inset,
                    row * CELL_SIZE + inset,
                    CELL_SIZE - 2 * inset,
                    CELL_SIZE - 2 * inset);
            gc.restore();
        }
    public static void main(String[] args) {
        launch();
    }
    }
