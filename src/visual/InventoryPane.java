package visual;

import com.sun.media.jfxmedia.events.PlayerTimeListener;
import data.Block;
import data.WaterBlock;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import visual.BlockPane;
import visual.Inventory;

import java.util.ArrayList;
import java.util.Iterator;

public class InventoryPane extends HBox {
    Text text;
    HBox layout;
    ArrayList<BlockPane> inv = new ArrayList<>();
    public InventoryPane(){
        text = new Text();
        layout = new HBox();
        layout.setSpacing(4);
        layout.setPadding(new Insets(4));

        this.getChildren().add(text);
        this.getChildren().add(layout);
    }
    public void refresh(Iterator<Block> it){
        layout.getChildren().removeAll();
        layout.getChildren().add(new Text());
        while(it.hasNext()){
            layout.getChildren().add(new BlockPane(it.next()));
        }
    }
}
