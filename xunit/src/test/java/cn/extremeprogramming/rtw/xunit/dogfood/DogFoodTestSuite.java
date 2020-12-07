package cn.extremeprogramming.rtw.xunit.dogfood;

import cn.extremeprogramming.rtw.xunit.RTWTestSuite;
import cn.extremeprogramming.rtw.xunit.fixture.EmptyTestCase;
import cn.extremeprogramming.rtw.xunit.fixture.TestCaseWithSingleMethod;

public class DogFoodTestSuite extends RTWTestSuite {
    @Override
    protected void registerTestCases() {
        addTestCase(new EmptyTestCase());
        addTestCase(new TestCaseWithSingleMethod());
//        addTestCase(new TestCaseWithFailedMethod());
        addTestCase(new RTWAssertTest());
    }
}
