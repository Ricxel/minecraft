package data;

import javafx.scene.paint.Color;

class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface{
    public IronSwordBlock(){
        super();
        this.content = 'S';
    }

    @Override
    public Color getColore() {
        return null;
    }
}
