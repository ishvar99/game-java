import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Enemy {
    private Vector2f pos;
    private Vector2f speed;
    public Enemy(Vector2f pos,Vector2f speed){
        this.pos=pos;
        this.speed=speed;
    }
    public void render(GameContainer gc, Graphics g) {
            g.setColor(Color.red);
            g.fillRect(pos.getX(), pos.getY(), 30, 30);
    }
    public void update(int t){
        pos.add(speed.copy().scale(t/500f));
        if(pos.getX()>400){
                pos.add(speed.copy().scale(t/500f));
                }
        }
    }
