package ass.classes.screens;

import ass.classes.Screen;
import ass.classes.ScreenManager;
import ass.classes.fakeDataGeneration.FakeSatellite;
import ass.classes.screenObjects.BarMeter;
import ass.classes.screenObjects.OMeter;
import processing.core.PApplet;

public class MainScreen extends Screen {

    private PApplet p;

    private OMeter thermOMeter, barOMeter, speedOMeter;

    private BarMeter heightBarMeter;

    private FakeSatellite satellite;

    public MainScreen() {
        this.p = ScreenManager.p;

        satellite = new FakeSatellite();

        thermOMeter = new OMeter(0, 0, 250);
        barOMeter = new OMeter(250, 0, 250);
        speedOMeter = new OMeter(500, 0, 250);

        heightBarMeter = new BarMeter(775, 0, 50, 600);

        setupMeters();
    }

    private void setupMeters() {
        thermOMeter.min = satellite.sensors[0].min;
        thermOMeter.max = satellite.sensors[0].max;
        thermOMeter.unit = satellite.sensors[0].unit;

        barOMeter.min = satellite.sensors[1].min;
        barOMeter.max = satellite.sensors[1].max;
        barOMeter.unit = satellite.sensors[1].unit;

        speedOMeter.min = satellite.sensors[2].min;
        speedOMeter.max = satellite.sensors[2].max;
        speedOMeter.unit = satellite.sensors[2].unit;

        heightBarMeter.min = 0;
        heightBarMeter.max = 500;
        heightBarMeter.unit = "m";
    }

    @Override
    public void update() {

        satellite.update();

        thermOMeter.value = satellite.sensors[0].dataPoint;
        barOMeter.value = satellite.sensors[1].dataPoint;
        speedOMeter.value = satellite.sensors[2].dataPoint;

        heightBarMeter.value = (101325f - barOMeter.value)*8.5f;

    }

    @Override
    public void render() {
        p.background(42);
        thermOMeter.render(p);
        barOMeter.render(p);
        speedOMeter.render(p);
        heightBarMeter.render(p);
    }

}
