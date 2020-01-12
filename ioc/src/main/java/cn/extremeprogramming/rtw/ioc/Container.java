package cn.extremeprogramming.rtw.ioc;

public class Container {
    private final Components components = new Components();

    public void addComponent(Object component) {
        components.add(component);
    }

    public void addComponent(Class clazz) {
        ConstructorExecutable constructorExecutable = new ConstructorResolver(clazz).resolve(components);
        Object component = constructorExecutable.instantiate();
        addComponent(component);
    }

    public <T> T getComponent(Class<T> clazz) {
        T component = components.findByType(clazz);
        Setters setters = new Setters(clazz);
        setters.invoke(component, components);
        return component;
    }

}
