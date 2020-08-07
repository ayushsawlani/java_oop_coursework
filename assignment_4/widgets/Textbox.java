//package widgets;
public class Textbox extends Widget implements MouseWatcher,KeyboardWatcher
{
    private boolean state=false;
    private StringBuffer s=new StringBuffer();
    public Textbox(int iw,int ih,int ix,int iy)
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
    public void onClick(int ix, int iy){}
    @Override
    public Widget getWidget()
    {
        return this;
    }
    @Override
    public void onKbdEvent(char x)
    {
        if(state)
        {
            s.append(x);
            System.out.println(s);
        }
    }
}