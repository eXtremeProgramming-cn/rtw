package cn.extremeprogramming.rtw.ioc;

public class ConstructorResolver {
    private final Class clazz;

    public ConstructorResolver(Class clazz) {
        this.clazz = clazz;
    }

    public ConstructorExecutable resolve(Components dependencies) {
        Constructors constructors = new Constructors(clazz);
        return constructors.satisfy(dependencies);
    }
}
