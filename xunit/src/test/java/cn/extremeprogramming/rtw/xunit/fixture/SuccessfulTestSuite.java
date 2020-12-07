package cn.extremeprogramming.rtw.xunit.fixture;

import cn.extremeprogramming.rtw.xunit.RTWTestSuite;

public class SuccessfulTestSuite extends RTWTestSuite {
    @Override
    protected void registerTestCases() {
        addTestCase(new EmptyTestCase());
        addTestCase(new TestCaseWithSingleMethod());
    }
}
