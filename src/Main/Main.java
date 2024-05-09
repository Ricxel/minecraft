package Main;
import data.IronSwordInterface;
import data.SandBlock;
import utils.MapCoordinates;
import utils.WrongCoordinatesException;
import visual.Map;

import java.util.Scanner;

public class Main {
//    private static Map m;
    private static final int INTERACTIONS = 6;

    public static void main(String[] args){
        MainView m = new MainView();
        m.display_on_out();
        for (int i = 0 ; i < INTERACTIONS ; i++){
            m.inv.display_inventory();
            System.out.println("Enter row and then column to pick that block");
            System.out.println("Enter '9' and the item number to move the item to the furnace");
            System.out.println("Enter '99' and then '9' to smelt");
            System.out.println("Enter '99' and then '0' to toggle the inventory sorting");
            System.out.println("Enter '99' and then any number to take from the furnace into the inventory");
            Scanner myObj = new Scanner(System.in);
            int row = myObj.nextInt();
            int col = myObj.nextInt();
            if (row == 9){
                m.move_into_furnace_from_inventory(col);
            }else if( row == 99 ){
                if (col == 9) {
                    m.smelt();
                }else if (col == 0){
                    m.toggle_inventory_comparator();
                }else {
                    m.move_into_inventory_from_furnace();
                }
            } else{
                MapCoordinates c = null;
                try {
                    c = new MapCoordinates(row,col);
                } catch (WrongCoordinatesException e) {
                    System.out.println(e.getMessage());
                }
                m.pick_up_block(c);
            }
            m.display_on_out();
        }


    }

//     ask for user input to change specific coordinates to a block 'A'
//    private static void change_at_coords(){
//        m = new Map();
//        m.display_on_out();
//        for (int i = 0 ; i < INTERACTIONS ; i++){
//            System.out.print("Enter row: ");
//            Scanner myObj = new Scanner(System.in);
//            int row = myObj.nextInt();
//
//            System.out.print("Enter column: ");
//            int col = myObj.nextInt();
//
//            System.out.println("Setting default for: "+row+" - "+col);
//            m.change_cell_with_A(row,col);
//
//            m.display_on_out();
//        }
//    }

//    private static void test_gravity(){
//        m = new Map(false);
//        m.display_on_out();
//        for (int i = 0 ; i < INTERACTIONS ; i++){
//            System.out.print("Enter column where to drop a block: ");
//            Scanner myObj = new Scanner(System.in);
//            int col = myObj.nextInt();
//
//            System.out.println("Dropping a new block in column: "+col);
//            m.change_cell_with_A(0,col);
//
//            m.display_on_out();
//        }
//    }
}