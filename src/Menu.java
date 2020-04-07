import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
    Image pg,eg;
    Mouse mouse;
    public Menu(int state){
    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        pg=new Image("res/playNow.png");
        eg=new Image("res/exitGame.png");
    }
    public void render(GameContainer gc, StateBasedGame sbg , Graphics g) throws SlickException {
        g.drawString("Welcome to Ishan's Land!",525,100);
        g.drawImage(pg,530,200);
        g.drawImage(eg,530,300);
    }
    public void update(GameContainer gc, StateBasedGame sbg, int yield) throws SlickException {
        int Xpos=mouse.getX();
        int Ypos=mouse.getY();
        int n=(768-(200+pg.getHeight()));
        int m=(768-(300+eg.getHeight()));
        if((Xpos>530 && Xpos<730)&&(Ypos>n&& Ypos<n+pg.getHeight())){
            if(mouse.isButtonDown(0)){
                sbg.enterState(Game.play);
            }
        }
        if((Xpos>530 && Xpos<730)&&(Ypos>m&& Ypos<m+pg.getHeight())){
            if(mouse.isButtonDown(0)){
                System.exit(0);
            }
        }
    }
    public int getID() {
        return 0;
    }
}
