package cn.extremeprogramming.rtw.ioc;

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
}
