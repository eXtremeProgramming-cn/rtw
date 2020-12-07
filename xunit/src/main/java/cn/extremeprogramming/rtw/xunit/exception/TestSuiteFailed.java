package cn.extremeprogramming.rtw.xunit.exception;

import cn.extremeprogramming.rtw.xunit.result.RTWTestSuiteResult;

public class TestSuiteFailed extends RTWException {
    public TestSuiteFailed(RTWTestSuiteResult testSuiteResult) {
        super("Some tests failed.\nFailed test cases are:\n" + testSuiteResult.failedTestCaseNames());
    }
}
