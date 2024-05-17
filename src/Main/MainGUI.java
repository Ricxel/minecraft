package Main;

import controllers.FurnaceSimpleController;
import controllers.InventorySimpleController;
import controllers.MainSimpleController;
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

public class MainGUI {
    Furnace furnace;
    Map map;
    Inventory inventory;
    ButtonListPane btnListPane;
    FurnacePane furnacePane;
    InventoryPane inventoryPane;
    MapPane mapPane;
    BorderPane root;
    BlockFactory blockFactory;
    MainSimpleController mainController;
    public MainGUI(MainSimpleController main) throws WrongCoordinatesException {
        furnace = new Furnace();
        map = new Map(true);
        inventory =  new Inventory();
        btnListPane = new ButtonListPane(mapPane);
        furnacePane = new FurnacePane();
        inventoryPane = new InventoryPane();
        mapPane = new MapPane();
        root = new BorderPane();
        blockFactory = new BlockFactory();
        mainController = main;
        mainController.setControllers(map, mapPane, furnace, furnacePane, inventory, inventoryPane);
        mainController.setDummyStuff();
        initializeVisualComponents();

    }
    private void initializeVisualComponents(){
        //MapPane
        BorderPane.setMargin(mapPane, new Insets(10));
        mapPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        mapPane.setMaxWidth(Map.DIMENSION_COLUMNS*50+(Map.DIMENSION_COLUMNS-1)*3);
        mapPane.setMaxHeight(Map.DIMENSION_ROWS*50+(Map.DIMENSION_ROWS-1)*3);
        mapPane.setVgap(3);
        mapPane.setHgap(3);

        //ButtonListPane
        inventoryPane.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        inventoryPane.setBorder(new Border(new BorderStroke(Color.BLACK, null, null,null)));

        //BorderPane (root)
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
        root.setPadding(new Insets(5));
        root.setBottom(inventoryPane);
        root.setRight(furnacePane);
        root.setCenter(mapPane);
        root.setLeft(btnListPane);
    }
    public Pane getGUI(){
        return root;
    }
}
