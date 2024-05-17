package visual;

import data.*;
import utils.BlockErrorException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

public class Inventory {
    private ArrayList<Block> l;
    private Comparator<Block> comparator;
    private boolean sorted;
    public Inventory(){
        l = new ArrayList<>();
        comparator = new AlphabeticalBlockComparator();
        sorted = false;
    }
    public String display_inventory(){
        StringBuilder ris = new StringBuilder();
        if(!this.sorted)l.sort(comparator);
        for (Block block : l) ris.append(block.toString());
        return ris.toString();

    }
    public void add_block(Block b){
        l.add(b);
    }
    public boolean is_smeltable(int index){
        return l.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable_item(int index) throws BlockErrorException {
        if(is_smeltable(index)){
            SmeltableBlock ris = (SmeltableBlock)l.get(index);
            l.remove(index);
            return ris;
        }
        else throw new BlockErrorException();
    }
    public void move_to_furnace(int index, Furnace fur){
        try {
            fur.setInput(get_smeltable_item(index));
        } catch (BlockErrorException e) {
            System.out.println("Eccezione generata");
        }
    }
    public void switch_comparator(){
        if(this.comparator instanceof AlphabeticalBlockComparator)
            this.comparator = new BlockComparator();
        else this.comparator = new AlphabeticalBlockComparator();
    }
    public void toggle_sorting(){
        this.sorted = !this.sorted;
    }

    public Iterator<Block> get_iterator() {
        return l.iterator();
    }
}
