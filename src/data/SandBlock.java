package data;

public class SandBlock extends AbstractBlock implements SmeltableBlock,BreakWhenFallOnATorchIntefarce{
    public SandBlock(){
        super();
        this.falls_with_gravity = true;
        this.fall_through = false;
        this.content = 'A';
        this.pickable = true;
    }
    public Block smelt(){
        return new GlassBlock();
    }
}
