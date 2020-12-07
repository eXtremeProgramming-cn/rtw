package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.exception.TestSuiteFailed;
import cn.extremeprogramming.rtw.xunit.result.RTWTestSuiteResult;

public class RTWTestRunner {
    public void execute(Class<? extends RTWTestSuite> testSuiteClass) throws Exception {
        RTWTestSuite testSuite = testSuiteClass.getConstructor().newInstance();
        RTWTestSuiteResult testSuiteResult = testSuite.execute();
        System.out.println(testSuiteResult);
        if (!testSuiteResult.isSuccessful()) {
            throw new TestSuiteFailed(testSuiteResult);
        }
    }

    public static void main(String... args) throws Exception {
        String testSuiteClassName = args[0];
        Class<RTWTestSuite> testSuiteClass = (Class<RTWTestSuite>) RTWTestRunner.class.getClassLoader().loadClass(testSuiteClassName);
        new RTWTestRunner().execute(testSuiteClass);
    }
}
