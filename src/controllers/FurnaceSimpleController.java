package controllers;

import data.Furnace;
import data.SandBlock;
import visual.FurnacePane;

public class FurnaceSimpleController implements SimpleControllerInterface{

    private FurnacePane layout;
    private Furnace furnace;
    public FurnaceSimpleController(FurnacePane p, Furnace furnace){
        this.layout = p;
        this.furnace = furnace;
    }
    @Override
    public void redraw() {
        //setto l'input
        layout.clear();
        layout.setInput(furnace.get_input());
        layout.setOutput(furnace.getOutput());
    }

    @Override
    public void setDummyStuff() {
        SandBlock b = new SandBlock();
        furnace.setInput(b);
        layout.setInput(b);
    }
}
