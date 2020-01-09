package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.exceptions.ComponentNotFound;
import cn.extremeprogramming.rtw.ioc.sample.Car;
import cn.extremeprogramming.rtw.ioc.sample.Engine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    private Container container;

    @Before
    public void setUp() {
        container = new Container();
    }

    @Test
    public void should_contain_components() {
        container.addComponent(1);
        container.addComponent("Hello");
        assertThat(container.getComponent(Integer.class), is(1));
        assertThat(container.getComponent(String.class), is("Hello"));
    }

    @Test
    public void should_create_components_with_classes_specified() throws Exception {
        container.addComponent("XP-xxx-xxx-xxxx");
        container.addComponent(Engine.class);
        assertThat(container.getComponent(String.class), is("XP-xxx-xxx-xxxx"));
        assertThat(container.getComponent(Engine.class).toString(), is("Engine: XP-xxx-xxx-xxxx"));
    }

    @Test(expected = ComponentNotFound.class)
    public void should_behave_gracefully_when_component_not_found() {
        container.addComponent("Hello");
        container.getComponent(Integer.class);
    }

    @Test
    public void should_inject_dependency_through_constructor() {
        Container container = new Container();
        Engine engine = new Engine("XP00001");
        container.addComponent(engine);
        container.addComponent(Car.class);
        Car car = container.getComponent(Car.class);
        assertThat(car.toString(), is("Car: \n\tEngine: XP00001"));
    }
}
