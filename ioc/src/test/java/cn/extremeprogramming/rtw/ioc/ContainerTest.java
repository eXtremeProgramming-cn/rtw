package cn.extremeprogramming.rtw.ioc;

import cn.extremeprogramming.rtw.ioc.sample.Engine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {
    @Test
    public void should_contain_components() {
        Container container = new Container();
        container.addComponent(1);
        container.addComponent("Hello");
        assertThat(container.getComponent(Integer.class), is(1));
        assertThat(container.getComponent(String.class), is("Hello"));
    }

    @Test
    public void should_create_components_with_classes_specified() throws Exception {
        Container container = new Container();
        container.addComponent(String.class);
        container.addComponent(Engine.class);
        assertThat(container.getComponent(String.class), is(""));
        assertThat(container.getComponent(Engine.class).toString(), is("Engine: XP-xxx-xxx-xxxx"));
    }

//    @Test
//    public void should_inject_dependency_through_constructor() {
//        Container container = new Container();
//        Engine engine = new Engine("XP00001");
//        container.addComponent(engine);
//    }
}
