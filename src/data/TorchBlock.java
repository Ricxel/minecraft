package data;

import javafx.scene.paint.Color;

public class TorchBlock extends AbstractSolidBlock{
    public TorchBlock(){
        super();
        this.content = 'T';
        this.fall_through = true;
    }

    @Override
    public Color getColore() {
        return null;
    }
}
