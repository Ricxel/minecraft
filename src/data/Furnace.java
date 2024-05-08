package data;

import visual.Inventory;

public class Furnace {
    private SmeltableBlock input;
    private Block output;
    public Furnace(){
        this.input = new NullBlock();
        this.output = new NullBlock();
    }
    public void display_on_out(){
        System.out.println(this.input.display() + "-->" + this.output.display());
    }
    public void smelt(){
        this.output = this.input.smelt();
        this.input = new NullBlock();
    }
    public void setInput(SmeltableBlock b){
        this.input = b;
//        smelt();
        this.output = this.input.smelt();
    }
    public Block getOutput(){
        return output;
    }
    public void move_output_to_inventory(Inventory inv){
        inv.add_block(output);
        this.output = new NullBlock();
    }
    public Block get_input(){
        return input;
    }


}
