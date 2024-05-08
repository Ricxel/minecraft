package data;
public interface Block extends InventoryBlock{
    char display();
    boolean isFalls_with_gravity();
    boolean isFall_through();
    boolean isDefault();
    boolean is_pickable();
    int get_num();
}