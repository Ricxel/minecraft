package data;
public abstract class AbstractBlock implements Block{
    protected char content;
    protected int number;
    protected boolean falls_with_gravity;
    protected boolean fall_through;
    protected String blockname;
    protected boolean pickable;
    protected static final char DEFAULT_CONTENT = '.';
    protected static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    public AbstractBlock(){
        this.pickable = false;
        this.number = 1;
    }

    private void set_fall_through(){
        this.fall_through = this.isDefault();
    }
    public char display(){
        return this.content;
    }
    public boolean isFalls_with_gravity(){
        return this.falls_with_gravity;
    }
    public boolean isFall_through(){
        return this.fall_through;
    }
    public boolean isDefault(){
        return this.content == AbstractBlock.DEFAULT_CONTENT;
    }
    public String ToString(){
        return "Nome: " + this.blockname + "; Contenuto:" + this.content;
    }

    @Override
    public void display_in_inventory() {
        System.out.println(this.content);
    }

    @Override
    public boolean is_pickable() {
        return pickable;
    }
    @Override
    public int get_num(){
        return this.number;
    }
}