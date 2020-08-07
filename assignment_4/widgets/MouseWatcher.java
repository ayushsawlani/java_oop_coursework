//package widgets;
public interface MouseWatcher
{
    void onEnter();
    void onExit();
    void moveTo(int x, int y);
    void onClick(int x, int y);
    Widget getWidget();
}