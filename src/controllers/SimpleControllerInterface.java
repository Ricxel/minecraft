package controllers;

import utils.WrongCoordinatesException;

public interface SimpleControllerInterface {
    void redraw() throws WrongCoordinatesException;
    void setDummyStuff() throws WrongCoordinatesException;
}
