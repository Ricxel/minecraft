package data;

import javafx.scene.paint.Color;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    public NullBlock(){
        super();
        this.pickable = false;
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }

    @Override
    public Color getColore() {
        return null;
    }
}
