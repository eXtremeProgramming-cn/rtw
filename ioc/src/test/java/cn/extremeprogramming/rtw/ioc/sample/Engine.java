package cn.extremeprogramming.rtw.ioc.sample;

public class Engine {
    private final String id;

    public Engine(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Engine: " + id;
    }
}
