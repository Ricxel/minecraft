package data;

import java.util.Comparator;

public class AlphabeticalBlockComparator implements Comparator<Block> {


    @Override
    public int compare(Block b1, Block b2) {
        return b1.toString().compareTo(b2.toString());
    }
}
