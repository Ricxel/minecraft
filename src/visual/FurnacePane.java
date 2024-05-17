package visual;

import data.Block;
import data.NullBlock;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import visual.BlockPane;

public class FurnacePane extends VBox {
    BlockPane input;
    BlockPane output;
    Text t = new Text("Furnace");
    Text arrow = new Text("-->");
//    public FurnacePane(Block in, Block out){
//        this.furnace = new Furnace();
//        input = new BlockPane(in);
//        output = new BlockPane(out);
//        arrow.setRotate(90);
//        arrow.setFont(Font.font("Arial",30));
//        arrow.prefHeight(50);
//        arrow.prefWidth(50);
//        this.getChildren().add(t);
//        this.getChildren().add(input);
//        this.getChildren().add(arrow);
//        this.getChildren().add(output);
//    }
    public FurnacePane(){
        arrow.setRotate(90);
        arrow.setFont(Font.font("Arial",30));
        this.input = new BlockPane(new NullBlock());
        this.output = new BlockPane(new NullBlock());
        this.getChildren().add(t);
        this.getChildren().add(input);
        this.getChildren().add(arrow);
        this.getChildren().add(output);
    }

    public void setInput(Block input) {
        this.input.changeBlock(input);
    }

    public void setOutput(Block output) {

        this.output.changeBlock(output);
    }
    public void clear(){
        this.input.changeBlock(new NullBlock());
        this.output.changeBlock(new NullBlock());
    }
}
