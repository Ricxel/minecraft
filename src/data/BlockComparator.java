package data;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

    @Override
    public int compare(Block b1, Block b2) {
        return b1.get_num() - b2.get_num();
    }
}
