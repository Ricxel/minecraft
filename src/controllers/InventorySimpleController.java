package controllers;

import data.SandBlock;
import data.TorchBlock;
import visual.InventoryPane;
import visual.Inventory;

public class InventorySimpleController implements SimpleControllerInterface{
    private InventoryPane layout;
    private Inventory inventory;
    public InventorySimpleController(InventoryPane p, Inventory inv){
        this.layout = p;
        this.inventory = inv;
    }

    @Override
    public void redraw() {
        layout.refresh(inventory.get_iterator());
    }

    @Override
    public void setDummyStuff() {
        inventory.add_block(new SandBlock());
    }

}
