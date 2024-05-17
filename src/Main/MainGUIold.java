package Main;

import controllers.FurnaceSimpleController;
import controllers.InventorySimpleController;
import controllers.MapSimpleController;
import data.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.WrongCoordinatesException;
import visual.*;

public class MainGUIold extends Application {
    public void start(Stage primaryStage) throws WrongCoordinatesException {
        BorderPane bp = new BorderPane();
//        bp.setStyle("-fx-background-color: lightblue;");
        bp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        bp.setPadding(new Insets(5));
        Scene scene = new Scene(bp, 1200, 800);
        BlockFactory bf = new BlockFactory();

        Block[][] m = new Block[Map.DIMENSION_ROWS][Map.DIMENSION_COLUMNS];
        for(int i = 0; i < Map.DIMENSION_ROWS; i++){
            for(int j = 0; j < Map.DIMENSION_COLUMNS; j++){
                m[i][j] = bf.random_block();
            }
        }
        MapPane mp = new MapPane();
        BorderPane.setMargin(mp, new Insets(10));
        mp.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        mp.setMaxWidth(Map.DIMENSION_COLUMNS*50+(Map.DIMENSION_COLUMNS-1)*3);
        mp.setMaxHeight(Map.DIMENSION_ROWS*50+(Map.DIMENSION_ROWS-1)*3);
        mp.setVgap(3);
        mp.setHgap(3);
        ButtonListPane btnListPane = new ButtonListPane(mp);
        FurnacePane frnPane = new FurnacePane();
        Furnace furnace = new Furnace();
        furnace.setInput(new SandBlock());
        FurnaceSimpleController furnaceController = new FurnaceSimpleController(frnPane, furnace);
        furnaceController.redraw();

        InventoryPane invPane = new InventoryPane();
        invPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        invPane.setBorder(new Border(new BorderStroke(Color.BLACK, null, null,null)));
        Inventory inv = new Inventory();
        InventorySimpleController invController = new InventorySimpleController(invPane, inv);

        Map map;
        map = new Map(true);

        MapSimpleController mapController = new MapSimpleController(mp, map);
        try {
            mapController.redraw();
        } catch (WrongCoordinatesException e) {
//            throw new RuntimeException(e);
            System.out.print(e.getMessage());
        }

        inv.add_block(new SandBlock());
        invController.redraw();
        bp.setCenter(mp);
        bp.setLeft(btnListPane);
        bp.setRight(frnPane);
        bp.setBottom(invPane);

        primaryStage.setTitle("MainGUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch();
    }
}
