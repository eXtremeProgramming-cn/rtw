package cn.extremeprogramming.rtw.ioc.sample;

public class Car {
    private final Engine engine;
    private String name;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car: \n" +
                "\t" + engine;
    }

    public String getName() {
        return name;
    }
}
