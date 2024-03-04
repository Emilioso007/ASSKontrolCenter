package ass.classes;

import processing.core.PApplet;

public class ScreenManager {
    
    public static PApplet p;

    private static Screen currentScreen;

    private ScreenManager(){

    }

    public static void initialize(PApplet pIn){
        p = pIn;
    }

    public static void changeScreen(Screen newScreen){
        currentScreen = newScreen;
    }

    public static void run(){
        currentScreen.update();
        currentScreen.render();
    }

}
