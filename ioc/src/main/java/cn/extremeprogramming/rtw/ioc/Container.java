package cn.extremeprogramming.rtw.ioc;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<Object> components = new ArrayList<>();

    public void addComponent(Object component) {
        components.add(component);
    }

    public <T> T getComponent(Class<T> clazz) {
        return (T) components.stream().filter(clazz::isInstance).findFirst().get();
    }
}
