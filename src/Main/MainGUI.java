package Main;

import com.sun.javafx.scene.paint.GradientUtils;
import data.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import visual.BlockPane;
import visual.Map;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainGUI extends Application {
    public void start(Stage primaryStage){
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);

        Pane hLayout = new HBox();
        BlockPane bp = new BlockPane(new SandBlock());
        hLayout.getChildren().add(bp);

        Button btn = new Button("Change block");
        btn.setOnAction((ActionEvent e)->{
            bp.changeBlock(new WaterBlock());
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(btn);
        borderPane.setTop(hLayout);

        InventoryPane inventoryPane = new InventoryPane();
        borderPane.setBottom(inventoryPane);

        //popolamento inventario
//        ArrayList<Block> l = new ArrayList<>();
//        l.add(new WaterBlock());
//        l.add(new SandBlock());
//        l.add(new AirBlock());
//        for(Block b : l) inventoryPane.addBlock(b);

        //map
        BlockFactory bf = new BlockFactory();
        Block[][] m = new Block[5][10];
        for(int i = 0; i < Map.DIMENSION_ROWS; i++){
            for(int j = 0; j < Map.DIMENSION_COLUMNS; j++){
                m[i][j] = bf.random_block();
            }
        }
        MapPane mp = new MapPane(m);
        borderPane.setCenter(mp);


        root.getChildren().add(borderPane);
        primaryStage.setTitle("Prova");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
