package ass.classes.fakeDataGeneration;

import ass.classes.ScreenManager;

public class FakeSensor {
    
    private final float myRand = (float)Math.random();

    public float min, max, dataPoint;

    public String unit = "";

    public FakeSensor(float min, float max, String unit){
        this.min = min;
        this.max = max;
        this.unit = unit;
        dataPoint = (min+max)/2;
    }

    public void generateData(){

        dataPoint += ScreenManager.p.noise(myRand*100 + ScreenManager.p.frameCount*0.01f)-0.5f;

        dataPoint = dataPoint > max ? max : (dataPoint < min) ? min : dataPoint;

    }

    public float getData(){

        return dataPoint;

    }

    public String getUnit(){
        return unit;
    }

}
