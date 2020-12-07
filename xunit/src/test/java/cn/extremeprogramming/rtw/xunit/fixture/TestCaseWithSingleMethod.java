package cn.extremeprogramming.rtw.xunit.fixture;

import cn.extremeprogramming.rtw.xunit.RTWTestCase;

public class TestCaseWithSingleMethod extends RTWTestCase {
    public void test_method_that_should_always_pass() {

    }

    @Override
    protected void registerTestMethods() {
        addTestMethod(this::test_method_that_should_always_pass);
    }
}
