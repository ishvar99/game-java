import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import java.awt.*;
public class Bullet {
private Vector2f pos;
private Vector2f speed;
private int lived=0;
boolean alive=true;
private static int Max_LifeTime=4000;
public Bullet(Vector2f pos,Vector2f speed){
    this.pos=pos;
    this.speed=speed;
}
public Bullet(){
    alive=false;
}
public void Update(int delta ){
    if(alive){
        Vector2f realSpeed=speed.copy();
        realSpeed.scale(delta/500f);
        pos.add(realSpeed);
        lived+=delta;
        if(lived>Max_LifeTime){
            alive=false;
        }
    }
}
public void render(GameContainer gc, Graphics g) throws SlickException{
    if(alive) {
        g.setColor(Color.white);
        g.fillOval(pos.getX()-10, pos.getY()-10, 10, 10);
    }
}
public Boolean isActive(){
    return alive;
}
}
