package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.Random;

/**
 * Objekt zum Sortieren
 */
public class Token extends GraphicalObject {

    //Attribute
    private double x, y;
    private int radius;
    private int primaryKey;
    private char secondaryKey;
    private boolean highlighted;

    //Referenzen
    /**
     * Erzeugt ein neues Token
     * @param x
     * @param y
     * @param radius
     * @param maxPrimaryKey
     */
    public Token(int x, int y, int radius, int maxPrimaryKey){
        this.x = x;
        this.y = y;
        this.radius = radius;
        highlighted = false;
        Random r = new Random();
        primaryKey = r.nextInt(maxPrimaryKey);
        secondaryKey = (char)(r.nextInt('z'-'a') + 'a');
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(highlighted){
            drawTool.setCurrentColor(0, 255, 0, 255);
        }else {
            drawTool.setCurrentColor(255, 0, 0, 255);
        }
        drawTool.drawFilledCircle(x-radius/2,y-radius/2,radius);
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x-radius/2,y-radius/2,radius);
        drawTool.drawText(x-radius*0.22,y+5,""+primaryKey+secondaryKey);
    }

    @Override
    public void update(double dt) {

    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public int getRadius() {
        return radius;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
}
