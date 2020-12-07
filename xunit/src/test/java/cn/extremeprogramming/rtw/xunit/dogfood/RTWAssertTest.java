package cn.extremeprogramming.rtw.xunit.dogfood;

import cn.extremeprogramming.rtw.xunit.RTWTestCase;
import cn.extremeprogramming.rtw.xunit.exception.RTWAssertionError;
import cn.extremeprogramming.rtw.xunit.result.RTWTestCaseResult;

import static cn.extremeprogramming.rtw.xunit.RTWAssert.fail;

public class RTWAssertTest extends RTWTestCase {
    @Override
    protected void registerTestMethods() {
        addTestMethod(this::fail_method_should_break_test);
    }

    private void fail_method_should_break_test() {
        RTWTestCaseResult testCaseResult = new TestCaseWithFailAssertion().execute();
        if(testCaseResult.isSuccessful()) {
            throw new RTWAssertionError("This test case should fail");
        }
    }
}

class TestCaseWithFailAssertion extends RTWTestCase {
    @Override
    protected void registerTestMethods() {
        addTestMethod(this::failed_test_method);
    }

    private void failed_test_method() {
        fail();
    }
}