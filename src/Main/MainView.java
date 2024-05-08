package Main;

import data.Furnace;
import data.NullBlock;
import data.SandBlock;
import data.SmeltableBlock;
import utils.BlockErrorException;
import utils.MapCoordinates;
import utils.WrongCoordinatesException;
import visual.Inventory;
import visual.Map;

public class MainView {
    private Map map;
    public Furnace furn;
    public Inventory inv;
    public MainView(){
        try {
            map = new Map();
        } catch (WrongCoordinatesException e) {
            System.out.println(e.getMessage());
        }
        furn = new Furnace();
        inv = new Inventory();
    }
    public void display_on_out(){
        this.map.display_on_out();
        this.furn.display_on_out();
    }
    public void move_into_furnace(int r, int c){
        SmeltableBlock b = null;
        try {
            try {
                b = map.getSmeltableBlock(r,c);
            } catch (WrongCoordinatesException e) {
                System.out.println(e.getMessage());
            }
            furn.setInput(b);
        } catch (BlockErrorException e) {
            throw new RuntimeException(e);
        }
    }
    public void smelt(){
        this.furn.smelt();
        this.furn.move_output_to_inventory(inv);
    }
    public void move_into_furnace_from_inventory(int index){
        inv.move_to_furnace(index, furn);
    }
    public void move_into_inventory_from_furnace(){
        inv.add_block(furn.get_input());
        furn.setInput(new NullBlock());
    }
    public void pick_up_block(MapCoordinates c){
        try {
            inv.add_block(map.gimme_pickable(c.get_row(),c.get_col()));
        } catch (BlockErrorException e) {
            System.out.println("Eccezione generata");
        }
        try {
            map.change_cell_with_air(c.get_row(),c.get_col());
        } catch (WrongCoordinatesException e) {
            System.out.println(e.getMessage());
        }
    }
    public void toggle_inventory_comparator(){
        inv.toggle_sorting();
    }
}
