package data;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    public NullBlock(){
        super();
        this.pickable = false;
    }

    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
