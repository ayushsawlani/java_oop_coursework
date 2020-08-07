//package widgets;
import java.util.*;

public class Panel extends Widget implements MouseWatcher,KeyboardWatcher
{
    private ArrayList <Widget> wlist=new ArrayList <Widget>();
    private ArrayList <MouseWatcher> mlist=new ArrayList <MouseWatcher>();
    private ArrayList <KeyboardWatcher> klist=new ArrayList <KeyboardWatcher>();
    public Panel(int iw,int ih)
    {
        super(iw,ih,0,0);
    }
    public void addMouseWatcher(MouseWatcher m)
    {
        mlist.add(m);
    }
    public void addKeyboardWatcher(KeyboardWatcher k)
    {
        klist.add(k);
    }
    public void addWidget(Widget w)
    {
        wlist.add(w);
    }
    @Override
    public void onKbdEvent(char x)
    {
        for(int i=0;i<klist.size();i++)
        {
            klist.get(i).onKbdEvent(x);
        }
    }
    @Override
    public Widget getWidget(){
        return this;
    }
    @Override
    public void onEnter(){}
    @Override
    public void onExit(){}
    @Override
    public void moveTo(int x, int y)
    {
        for(int i=0;i<mlist.size();i++)
        {
            mlist.get(i).moveTo(x, y);
        }
    }
    @Override
    public void onClick(int x, int y)
    {
        for(int i=0;i<mlist.size();i++)
        {
            mlist.get(i).onClick(x,y);
        }
    }
}