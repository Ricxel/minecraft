package visual;

import data.Block;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

public class BlockPane extends StackPane {
    Block b;
    public static final int DIM_SQUARE = 50;
    private static final String FONT_NAME = "Verdana";
    private static final int FONT_SIZE = 18;
    private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
    private static final Color BLOCK_BORDER = Color.BLACK;
    private static final Color FONT_FILL = Color.BLACK;
    private static final Color FONT_BORDER = Color.BLACK;
    Rectangle rec;
    public BlockPane(Block b){
        this.b = b;
        initialize();
    }
    private void initialize(){
        Text t = new Text("" + b.display());
        t.setFont(new Font(FONT_NAME, FONT_SIZE));
        rec = new Rectangle(DIM_SQUARE, DIM_SQUARE, Color.RED);
        this.getChildren().add(rec);
        this.getChildren().add(t);
    }
    public void changeBlock(Block b){
        this.b = b;
        initialize();
    }

}
