package utils;

import utils.WrongCoordinatesException;

import java.util.Random;
import visual.Map;
public class MapCoordinates {
    private int row;
    private int col;

    public MapCoordinates(int r, int c)throws WrongCoordinatesException {
        if(r < Map.DIMENSION_ROWS && c < Map.DIMENSION_COLUMNS){
            this.row = r;
            this.col = c;
        }
        else throw new WrongCoordinatesException();
    }
    public MapCoordinates(){
        Random rnd = new Random();
        this.row = rnd.nextInt(Map.DIMENSION_ROWS);
        this.col = rnd.nextInt(Map.DIMENSION_COLUMNS);
    }
    public int get_row(){
        return row;
    }
    public int get_col(){
        return col;
    }

}
