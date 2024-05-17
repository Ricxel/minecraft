package data;

import javafx.scene.paint.Color;

public interface Block extends InventoryBlock{
    Color getColore();
    char display();
    boolean isFalls_with_gravity();
    boolean isFall_through();
    boolean isDefault();
    boolean is_pickable();
    int get_num();
}