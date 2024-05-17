package data;

import javafx.scene.paint.Color;

public class WaterBlock extends AbstractBlock{
    public WaterBlock(){
        super();
        this.falls_with_gravity = true;
        this.fall_through = true;
        this.content = 'W';
        this.colore = Color.BLUE;
    }

    @Override
    public Color getColore() {
        return colore;
    }
}
