package utils;

import utils.WrongCoordinatesException;

public class MapCoordinates {
    private final int DIMENSIONS_ROW = 10;
    private final int DIMENSIONS_COL = 10;
    private int row;
    private int col;

    public MapCoordinates(int r, int c)throws WrongCoordinatesException {
        if(r < DIMENSIONS_ROW && c < DIMENSIONS_COL){
            this.row = r;
            this.col = c;
        }
        else throw new WrongCoordinatesException();
    }
    public int get_row(){
        return row;
    }
    public int get_col(){
        return col;
    }

}
