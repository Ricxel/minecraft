package data;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock{
    public RawIronBlock(){
        super();
        this.content = 'I';
    }
    public Block smelt(){
        return new IronSwordBlock();
    }
}
