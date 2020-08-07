//package widgets;
public class Button extends Widget implements MouseWatcher
{
    private boolean state=false;
    public Button(int iw,int ih,int ix,int iy)
    {
        super(iw,ih,ix,iy);
    }
    @Override
    public void onEnter()
    {
        state=true;
    }
    @Override
    public void onExit()
    {
        state=false;
    }
    @Override
    public void moveTo(int ix, int iy)
    {
        if((ix>=this.x)&&(iy>=this.y)&&(ix<=this.x+this.w)&&(iy<=this.y+this.h))
            this.onEnter();
        else
            this.onExit();;
    }
    @Override
    public void onClick(int ix, int iy)
    {
        if(state)
        {
            System.out.println("Selected point: "+(ix-this.x)+" "+(iy-this.y));
        }
    }
    @Override
    public Widget getWidget()
    {
        return this;
    }

}