package data;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import visual.BlockPane;
import visual.Inventory;

public class InventoryPane extends HBox {
    Text text;
    HBox layout;
    Inventory inventory;
    public InventoryPane(){
        text = new Text();
        layout = new HBox();

        this.getChildren().add(text);
        this.getChildren().add(layout);
        layout.getChildren().add(new BlockPane(new WaterBlock()));

    }
    public void addBlock(Block b){
        this.inventory.add_block(b);
        this.layout.getChildren().add(new BlockPane(b));
        this.text.setText(this.inventory.display_inventory());
    }

}
