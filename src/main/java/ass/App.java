package ass; //active suborbital satellite

import ass.classes.ScreenManager;
import ass.classes.screens.MainScreen;
import processing.core.PApplet;
import processing.opengl.PJOGL;
import jssc.*;

public class App extends PApplet {

    public static void main(String[] args) {
        for (String port : SerialPortList.getPortNames()) {
            System.out.println(port);
        }
        System.out.println("Starting...");
        PApplet.main("ass.App");
    }

    @Override
    public void settings() {
        size(850, 600, P2D);
        PJOGL.setIcon("ass/resources/images/Icon.png"); // img src "https://www.computercraft.info/"

    }

    @Override
    public void setup() {
        surface.setTitle("Kontrol Center");
        ScreenManager.initialize(this);
        ScreenManager.changeScreen(new MainScreen());

    }

    @Override
    public void draw() {
        ScreenManager.run();
    }

}
