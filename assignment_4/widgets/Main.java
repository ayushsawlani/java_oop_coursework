import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        Panel p=new Panel(600,800);
        Textbox t=new Textbox(400,200,100,300);
        Label l=new Label(200,100,50,500,"hello world");
        Button b=new Button(200,100,250,100);
        p.addWidget(t);
        p.addWidget(l);
        p.addWidget(b);
        p.addMouseWatcher(t);
        p.addMouseWatcher(b);
        p.addKeyboardWatcher(t);
        Scanner input = new Scanner(System.in);
        String[] temp;
        temp=input.nextLine().split(" ");
        int x=0;
        int y=0;
        while(!(temp[0].equals("End")))
        {
            if(temp[0].equals("MoveTo"))
            {
                x=Integer.valueOf(temp[1]);
                y=Integer.valueOf(temp[2]);
                p.moveTo(x,y);
            }
            else if(temp[0].equals("MouseClick"))
            {
                p.onClick(x,y);
            }
            else if(temp[0].equals("KeyPressed"))
            {
                char s=temp[1].charAt(0);
                p.onKbdEvent(s);
            }
            temp=input.nextLine().split(" ");
        }
    }
}