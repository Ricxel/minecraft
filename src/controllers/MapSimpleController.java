package controllers;

import utils.MapCoordinates;
import utils.WrongCoordinatesException;
import visual.MapPane;
import visual.Map;

public class MapSimpleController implements SimpleControllerInterface{
    private MapPane layout;
    private Map map;

    public MapSimpleController(MapPane p, Map m){
        this.layout = p;
        this.map = m;
    }
    @Override
    public void redraw() throws WrongCoordinatesException {
        for(int i = 0; i < Map.DIMENSION_ROWS; i++){
            for(int j = 0; j < Map.DIMENSION_COLUMNS; j++){
                MapCoordinates coords = new MapCoordinates(i,j);
                layout.setCell(coords, map.get_cell(coords));
            }
        }
    }

    @Override
    public void setDummyStuff() {

    }
}

