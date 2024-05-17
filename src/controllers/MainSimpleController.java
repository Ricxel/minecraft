package controllers;

import Main.MainGUI;
import Main.MainGUIold;
import Main.MainView;
import data.Furnace;
import javafx.scene.layout.Pane;
import utils.WrongCoordinatesException;
import visual.*;

import java.util.ArrayList;
import java.util.Collection;

public class MainSimpleController implements SimpleControllerInterface{

    MainView mainView;
    MainGUI mainGUI;
    ArrayList<SimpleControllerInterface> controllersList;
    FurnaceSimpleController furnaceController;
    InventorySimpleController inventoryController;
    MapSimpleController mapController;
    public MainSimpleController(MainView mv) throws WrongCoordinatesException {
        this.mainView = mv;
        this.mainGUI = new MainGUI(this);

        controllersList = new ArrayList<>();
    }
    public void setControllers(Map m, MapPane mPane, Furnace f, FurnacePane fPane, Inventory i, InventoryPane iPane){
        mapController = new MapSimpleController(mPane, m);
        furnaceController = new FurnaceSimpleController(fPane, f);
        inventoryController = new InventorySimpleController(iPane, i);
    }
    public Pane getMainGUI(){
        return mainGUI.getGUI();
    }
    public void setDummyStuff() throws WrongCoordinatesException {
        furnaceController.setDummyStuff();
        mapController.setDummyStuff();
        inventoryController.setDummyStuff();
        this.redraw();
    }
    @Override
    public void redraw() throws WrongCoordinatesException {
        furnaceController.redraw();
        inventoryController.redraw();
        mapController.redraw();

    }
}
