package cn.extremeprogramming.rtw.xunit.fixture;

import cn.extremeprogramming.rtw.xunit.RTWTestCase;

public class TestCaseWithFailedMethod extends RTWTestCase {
    public void test_method_that_should_always_fail() {
        throw new RuntimeException("fail!");
    }

    @Override
    protected void registerTestMethods() {
        addTestMethod(this::test_method_that_should_always_fail);
    }
}
