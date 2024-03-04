package ass.classes.screenObjects;

import processing.core.PApplet;
import processing.core.PConstants;

public class OMeter {

    public float x = 0, y = 0, size = 100;
    public float min = 0, max = 10000, stepSize = max / 8.0f;

    public float value = 0;

    public String unit = "km/h";

    public OMeter(float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void render(PApplet p) {

        stepSize = (max-min) / 8.0f;

        // System.out.println("OMeter rendering");

        // value = (value>max)?min:(value + 1);
        // value++;

        p.pushMatrix();

        p.translate(x + size / 2, y + size / 2);

        p.ellipseMode(PConstants.CENTER);
        p.fill(0);
        p.noStroke();
        p.ellipse(0, 0, size, size);

        // float incrementAngle = 270 / ((max - min) / stepSize);
        // int amountOfSteps = (int) ((max - min) / stepSize);
        int amountOfSteps = 8;

        for (int i = 0; i <= amountOfSteps; i++) {

            float tempAngle = PApplet.map(i, 0, amountOfSteps, -225, 45);

            int x = (int) (PApplet.cos(PApplet.radians(tempAngle)) * size / 2 * 0.8f);
            int y = (int) (PApplet.sin(PApplet.radians(tempAngle)) * size / 2 * 0.8f);

            if (i == 0) {
                p.stroke(255, 0, 0);
            } else {
                p.stroke(255);
            }
            // p.line(0, 0, x, y);

            p.pushMatrix();

            p.translate(x, y);
            // p.rotate(PApplet.radians(tempAngle));
            p.textAlign(PApplet.CENTER, PApplet.CENTER);
            p.fill(255);
            p.text((int) (min + i * stepSize), 0, 0);

            p.popMatrix();

        }

        // draw the needle
        p.pushMatrix();
        p.rotate(PApplet.radians(PApplet.map(value, min, max, -225, 45)));
        p.stroke(255, 0, 0);
        p.strokeWeight(3);
        p.line(0, 0, size / 2 * 0.8f, 0);
        p.popMatrix();

        // show the value at the bottom of the meter
        p.fill(255);
        p.textAlign(PApplet.CENTER, PApplet.BOTTOM);
        p.text((int) value + "\n" + unit, 0, size / 2 * 0.8f);

        p.popMatrix();

    }

}
