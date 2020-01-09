package cn.extremeprogramming.rtw.ioc.sample;

public class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car: \n" +
                "\t" + engine;
    }
}
