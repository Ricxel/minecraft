package data;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import utils.MapCoordinates;
import visual.BlockPane;
import visual.Map;

public class MapPane extends GridPane {
    BlockFactory factory;
    public MapPane(){
        factory = new BlockFactory();
    }
    public MapPane(Block[][] m){
        super();
        initialize_with_block(m);
    }
    private void initialize_with_block(Block[][] m){
        for(int r = 0; r < Map.DIMENSION_ROWS; r++){
            for(int c = 0; c < Map.DIMENSION_COLUMNS; c++){
                this.add(new BlockPane(m[r][c]), c, r);
            }
        }
    }
    public void initialize_air(){
        for(int r = 0; r < Map.DIMENSION_ROWS; r++){
            for(int c = 0; c < Map.DIMENSION_COLUMNS; c++){
                this.add(new BlockPane(factory.default_block()), c, r);
            }
        }
    }
    public static Node getElementAt(GridPane gp, int i, int j) {
        for (Node x :gp. getChildren()) {
            if ((GridPane.getRowIndex(x) == i) && (GridPane.getColumnIndex(x) == j)) {
                return x;
            }
        }
        return null;
    }
    public BlockPane get_block_at_coord(MapCoordinates coord){
        return (BlockPane) getElementAt(this, coord.get_row(), coord.get_col());
    }
    public void setCell(MapCoordinates coord, Block b){
        BlockPane mapBlock = get_block_at_coord(coord);
        if(mapBlock != null)
            mapBlock.changeBlock(b);
        else this.add(new BlockPane(b), coord.get_col(), coord.get_row());
    }
}
