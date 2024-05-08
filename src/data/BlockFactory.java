package data;

import java.util.Random;

public class BlockFactory {
    private static final int RAND_UPPERBOUND = 5;
    public BlockFactory(){}

    // create a random block
    public Block random_block(){
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        return new AirBlock(r);
    }
    // create a default block
    public Block default_block(){
        return new AirBlock();
    }
    // create a fixed block 'A'
    public Block block_to_A(){
        return new SandBlock();
    }
    public SandBlock sandBlock(){
        return new SandBlock();
    }
    public WaterBlock waterBlock(){
        return new WaterBlock();
    }

    // TODO at some point make AirBlock private and expose its interface
}
