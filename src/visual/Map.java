package visual;

import data.*;
import utils.BlockErrorException;
import utils.MapCoordinates;
import utils.WrongCoordinatesException;

import java.util.Random;

public class Map {
    public static final int DIMENSION_COLUMNS = 10;
    public static final int DIMENSION_ROWS = 5;

    private Block[][] content;
    private BlockFactory bf;

    // the default map is a random one
    public Map() throws WrongCoordinatesException {
        this(true);
    }

    // create a Map, and tell it whether it needs to be made of random blocks or not
    public Map(boolean random) throws WrongCoordinatesException {
        content = new Block[DIMENSION_ROWS][DIMENSION_COLUMNS];
//        bf = new BlockFactory();
//        for (int i = 0 ; i < DIMENSION_ROWS; i++){
//            for (int k = 0 ; k < DIMENSION_COLUMNS; k++){
//                Block b = null;
//                if (random) {
//                    b = bf.random_block();
//                } else {
//                    b = bf.default_block();
//                }
//                this.insert_block_at_coords(b,i,k,false);
//            }
//        }
//        this.addRiver();
        for(int i = 0; i < DIMENSION_ROWS; i++){
            for(int j = 0; j < DIMENSION_COLUMNS; j++){
                content[i][j] = new AirBlock();
            }
        }
        this.randomize(20);
    }
    private void randomize(final int RANDOM_BLOCKS_TO_ADD) throws WrongCoordinatesException {
        Random rand = new Random();
        Block b;
        for (int i = 0 ; i < RANDOM_BLOCKS_TO_ADD; i++){
            int row = rand.nextInt(DIMENSION_ROWS);
            int col = rand.nextInt(DIMENSION_COLUMNS);
            BlockFactory bf = new BlockFactory();
            b = bf.random_block();
            // inserite b a row-col
            this.insert_block_at_coords(b, new MapCoordinates(row,col), true);
        }
    }

    // this is a centralised insertion, to be done at allocation,
    // and in change cell, when we change the insertion policy with stackable
    private void insert_block_at_coords(Block b, MapCoordinates c, boolean consider_stackeble) throws WrongCoordinatesException {
        this.content[c.get_row()][c.get_col()] = b;
        if (consider_stackeble) {
            this.move(c);
        }
    }

    private void move(MapCoordinates c) throws WrongCoordinatesException {
//        move_rec(row, col);
//        move_iter_for(row,col);
        move_iter_while(c.get_row(),c.get_col());
        // until row is less than row
        // if the row-col falls with gravity
        // and the row+1-col is fall through
        // swap row-col and row+1-col
    }
    private void move_rec(int row, int col) throws WrongCoordinatesException {
        if (row == Map.DIMENSION_ROWS-1){
            return;
        }
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        if (!this.content[row+1][col].isFall_through()){
            return;
        }
        this.swap(new MapCoordinates(row, col));
        this.move_rec(row+1,col);
    }

    private void move_iter_for(int row, int col) throws WrongCoordinatesException {
        if (!this.content[row][col].isFalls_with_gravity()){
            return;
        }
        for (int i = row; i < DIMENSION_ROWS-1 ; i++){
            if (!this.content[i+1][col].isFall_through()){
                break;
            }
            this.swap(new MapCoordinates(i, col));
        }
    }
    private void move_iter_while(int row, int col) throws WrongCoordinatesException {
        int indx = row;
        while (this.content[indx][col].isFalls_with_gravity()
                && indx+1 < DIMENSION_ROWS
                && this.content[indx+1][col].isFall_through()){
            this.swap(new MapCoordinates(indx, col));
            indx++;
        }
    }

    // precondition: row and col are valid, and so are for the next
    private void swap(MapCoordinates c) throws WrongCoordinatesException {
        Block b = null;
        b = this.content[c.get_row()][c.get_col()];
        if(b instanceof BreakWhenFallOnATorchIntefarce
                && this.content[c.get_row()+1][c.get_col()] instanceof TorchBlock)
            this.change_cell_with_air(c.get_row(),c.get_col());
        else{
            this.content[c.get_row()][c.get_col()] = this.content[c.get_row()+1][c.get_col()];
            this.content[c.get_row()+1][c.get_col()] = b;
        }

    }

    // display the map
    public void display_on_out(){
        System.out.println("______________");
        System.out.println("|============|");
        for (int i = 0 ; i < DIMENSION_ROWS; i++){
            System.out.print("||");
            for (int k = 0 ; k < DIMENSION_COLUMNS; k++){
                System.out.print(this.content[i][k].display());
            }
            System.out.print("||");
            System.out.println();
        }
        System.out.println("|============|");
    }

    // change a cell with a fixed block 'A'
    public void change_cell_with_air(int row, int col) throws WrongCoordinatesException {
        if (row >= DIMENSION_ROWS || col >= DIMENSION_COLUMNS){
            return;
        }
        this.insert_block_at_coords(new AirBlock(),new MapCoordinates(row,col),true);
        for(int r = row; r >= 0; r--){
            move(new MapCoordinates(r, col));
        }
    }
    private void addRowsOfWater() throws WrongCoordinatesException {
        //aggiungere i blocchi d'acqua in cima:
        for(int c = 0; c < DIMENSION_COLUMNS; c++){
            insert_block_at_coords(new WaterBlock(), new MapCoordinates(0,c), true);
        }
    }
    //aggiunge una riga d'acqua
    public void addRiver() throws WrongCoordinatesException {
        addRowsOfWater();
    }
    //aggiunge 3 righe d'acqua
    public void addSea() throws WrongCoordinatesException {
        for(int i = 0; i < 3; i++)
            addRowsOfWater();
    }
    private boolean isSmeltable(MapCoordinates c){
        return content[c.get_row()][c.get_col()] instanceof SmeltableBlock;
    }
    public SmeltableBlock getSmeltableBlock(int r, int c) throws BlockErrorException, WrongCoordinatesException {
        if(isSmeltable(new MapCoordinates(r,c)) && r < DIMENSION_ROWS && c < DIMENSION_COLUMNS){
            return (SmeltableBlock) content[r][c];
        }
        else throw new BlockErrorException();
    }
    private boolean is_pickable(int r, int c) throws BlockErrorException{
        return content[r][c].is_pickable();
    }
    public Block gimme_pickable(int r, int c) throws BlockErrorException{
        if(is_pickable(r,c))
            return content[r][c];
        else return new NullBlock();
    }
}