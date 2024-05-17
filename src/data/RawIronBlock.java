package data;

import javafx.scene.paint.Color;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
    public RawIronBlock(){
        super();
        this.content = 'I';
    }
    public Block smelt(){
        return new IronSwordBlock();
    }

    @Override
    public Color getColore() {
        return null;
    }
}
