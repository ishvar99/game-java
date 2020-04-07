import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class Game extends StateBasedGame {
    static final String gamename="Blaster 2.0";
    static final int menu=0;
    static final int play =1;
    public Game(String gamename){
        super(gamename);
        addState(new Menu(menu));
        addState(new Play(play));
    }
    public void initStatesList(GameContainer gc) throws SlickException {
        getState(menu).init(gc,this);
        getState(play).init(gc,this);
        enterState(play);
    }
    public static void main(String[] args) throws SlickException {
        AppGameContainer a;
        try{
            a=new AppGameContainer(new Game(gamename));
            a.setDisplayMode(700,600,false);//Note that the arguments should match with the full screen resolution of the PC
           a.setVSync(true);//For tear free graphics
            a.start();
        }catch(SlickException e){
        }
    }
}