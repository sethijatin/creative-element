import org.openqa.selenium.Point;

import java.awt.*;

class CyclicQuad {

    private Point Point_A;
    private Point Point_B;
    private Point Point_C;
    private Point Point_D;
    private Rectangle rectangle;

    public CyclicQuad(Point location, int height, int width){

        int x = location.getX();
        int y = location.getY();

        //Set the selenium points
        this.Point_A = new Point(x,y);
        this.Point_B = new Point(x + width, y );
        this.Point_C = new Point(x + width, y + height);
        this.Point_D = new Point(x , y + height);

        //Set the polygon
        this.rectangle = new Rectangle(x,y,width,height);
    }

    public Point getPoint_A(){
        return this.Point_A;
    }

    public Point getPoint_B(){
        return this.Point_B;
    }

    public Point getPoint_C(){
        return this.Point_C;
    }

    public Point getPoint_D(){
        return this.Point_D;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }
}
