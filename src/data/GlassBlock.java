package data;

import data.AbstractSolidBlock;
import javafx.scene.paint.Color;

public class GlassBlock extends AbstractSolidBlock {
    public GlassBlock(){
        super();
        this.content = 'G';
    }

    @Override
    public Color getColore() {
        return colore;
    }
}
