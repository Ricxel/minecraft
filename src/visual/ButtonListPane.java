package visual;

import data.BlockFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ButtonListPane extends VBox {
    Button btn;
    MapPane mp;
    BlockFactory blockFactory;
    public ButtonListPane(MapPane m){
        this.mp = m;
        this.blockFactory = new BlockFactory();

//        btn = new Button("ListPane");
//        btn.setOnAction((ActionEvent e)->{
//            mp.setCell(new MapCoordinates(), blockFactory.random_block());
//        });
//        this.getChildren().add(btn);
        HBox row1 = new HBox();
        row1.getChildren().add(new TextField());
        row1.getChildren().add(new TextField());
        row1.getChildren().add(new Button("Pick"));

        HBox row2 = new HBox();
        row2.getChildren().add(new TextField());
        row2.getChildren().add(new Button("Move to Furnace"));

        HBox row3 = new HBox();
        row3.getChildren().add(new Button("Smelt"));

        HBox row4 = new HBox();
        row4.getChildren().add(new Button("Move Back"));

        HBox row5 = new HBox();
        row5.getChildren().add(new Button("Toggle Inventory Sorting"));

        this.getChildren().add(row1);
        this.getChildren().add(row2);
        this.getChildren().add(row3);
        this.getChildren().add(row4);
        this.getChildren().add(row5);


    }
}
