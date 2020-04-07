import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.*;
public class Play extends BasicGameState {
    Image world;
    private Bullet bullets[];
    private Enemy e;
    private int current=0;
    private int Fire_Rate = 250;
    private int t=0;
    int xpos=0,ypos=0,x=0,y=0;
    int movedown=0,moveup=0,moveright=0,moveleft=0;
    Animation up,down,left,right,bucky;
    int [] duration={100,100};
    public Play(int state){
    }
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        e=new Enemy(new Vector2f(200,100),new Vector2f(100,0));
        bullets=new Bullet[8];
        for(int i=0;i<bullets.length;i++) {
            bullets[i] = new Bullet();
        }
        world=new Image("res/world.png");
        Image[] mup={new Image("res/buckysBack.png"),new Image("res/buckysBack.png")};
        Image[] mdown={new Image("res/buckysFront.png"),new Image("res/buckysFront.png")};
        Image[] mleft={new Image("res/buckysLeft.png"),new Image("res/buckysLeft.png")};
        Image[] mright={new Image("res/buckysRight.png"),new Image("res/buckysRight.png")};
        up=new Animation(mup,duration,false);
        down=new Animation(mdown,duration,false);
        left=new Animation(mleft,duration,false);
        right=new Animation(mright,duration,false);
        bucky=down;
    }
    public void render(GameContainer gc, StateBasedGame sbg , Graphics g) throws SlickException {
        g.drawImage(world, x, y);
        g.setColor(Color.red);
        bucky.draw(gc.getWidth() / 2 + xpos, gc.getHeight() / 2 + ypos);
        e.render(gc, g);
        for(Bullet b:bullets) {
            b.render(gc, g);
                              }
        }
    public void update(GameContainer gc, StateBasedGame sbg, int  delta) throws SlickException {
        t+=delta;
        Input i = gc.getInput();
        if(x>0){
            x=0;
            xpos-=delta*.2f;
        }
        else if(x<gc.getWidth()-world.getWidth()){
            x=gc.getWidth()-world.getWidth();
            xpos+=delta*.2f;
        }
        if(y>0){
            y=0;
            ypos-=delta*.2f;
        }
        else if(y<gc.getHeight()-world.getHeight()){
            y=gc.getHeight()-world.getHeight();
            ypos+=delta*.2f;
        }
        if(i.isKeyDown(Input.KEY_UP)){
            bucky=up;
            y+=delta*.2f;
            ypos-=delta *.1f;
            if(ypos<-300){
                ypos+=delta *.2f;
            }
        }
        else if(i.isKeyDown(Input.KEY_DOWN)){
            bucky=down;
            y-=delta *.2f;
            ypos+=delta *.1f;
            if(ypos>260){
                ypos-=delta *.2f;
            }
        }
        else if(i.isKeyDown(Input.KEY_LEFT)){
            bucky=left;
            x+=delta *.2f;
            xpos-=delta *.1f;
            if(xpos<-350){
                xpos+=delta*.2f;
            }
        }
        else if(i.isKeyDown(Input.KEY_RIGHT)){
            bucky=right;
            x-=delta *.2f;
            xpos+=delta *.1f;
            if(xpos>310){
                xpos-=delta *.2f;
            }
        }
        e.update(delta);
        if(t>Fire_Rate && i.isKeyPressed(Input.KEY_SPACE)) {
            if(bucky==down)
            bullets[current]=new Bullet(new Vector2f(gc.getWidth() / 2 + xpos + 25, gc.getHeight() / 2 + ypos + 20), new Vector2f(0, 200));
            if(bucky==up)
                bullets[current]=new Bullet(new Vector2f(gc.getWidth() / 2 + xpos + 25, gc.getHeight() / 2 + ypos + 20), new Vector2f(0, -200));
            if(bucky==left)
                bullets[current]=new Bullet(new Vector2f(gc.getWidth() / 2 + xpos + 25, gc.getHeight() / 2 + ypos + 20), new Vector2f(-200, 0));
            if(bucky==right)
                bullets[current]=new Bullet(new Vector2f(gc.getWidth() / 2 + xpos + 25, gc.getHeight() / 2 + ypos + 20), new Vector2f(200, 0));
            current++;
            if(current>=bullets.length){
              current=0;
              t=0;
            }
        }
            for (Bullet b:bullets) {
                b.Update(delta);
            }
        }
    public int getID() {
        return 1;
    }
}