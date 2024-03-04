package ass.classes.screenObjects;

import processing.core.PApplet;
import processing.core.PImage;

public class BarMeter {
    
    public PImage image = null;

    public float x = 0, y = 0, w = 50, h = 400;
    public float min = 0, max = 100;

    public float value = 0;

    public String unit = "m"; 

    public BarMeter(float x, float y, float w, float h){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

    }

    public void render(PApplet p){
        p.noStroke();
        float barHeight = PApplet.map(value, min, max, 0, h);
        p.fill(0, 255, 0);
        p.rect(x, y + h - barHeight, w, barHeight);

        p.fill(255);
        p.textAlign(PApplet.CENTER, PApplet.BOTTOM);
        p.text(value + " " + unit, x + w / 2, y + h - barHeight - 5);

    }

}
