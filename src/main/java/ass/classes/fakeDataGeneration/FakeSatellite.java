package ass.classes.fakeDataGeneration;

public class FakeSatellite {

    public FakeSensor[] sensors;

    public FakeSatellite(){

        sensors = new FakeSensor[3];

        sensors[0] = new FakeSensor(-10, 10, "°C"); // thermometer (temperature)
        sensors[1] = new FakeSensor(101275, 101325, "Pa"); // barometer (pressure)
        sensors[2] = new FakeSensor(0, 100, "m/s"); // speedometer (velocity)

    }

    public void update(){
        for(FakeSensor fs : sensors){
            fs.generateData();
        }
    }

}