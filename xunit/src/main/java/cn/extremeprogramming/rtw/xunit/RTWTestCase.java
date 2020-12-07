package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.result.RTWTestCaseResult;
import cn.extremeprogramming.rtw.xunit.result.RTWTestMethodResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public abstract class RTWTestCase {
    private final List<Runnable> testMethods = new ArrayList<>();

    protected RTWTestCase() {
        registerTestMethods();
    }

    public int numberOfTestMethods() {
        return testMethods.size();
    }

    protected void addTestMethod(Runnable testMethod) {
        testMethods.add(testMethod);
    }

    abstract protected void registerTestMethods();

    public RTWTestCaseResult execute() {
        List<RTWTestMethodResult> testMethodResults = testMethods.stream().map(this::runSingleTestMethod).collect(toList());
        return new RTWTestCaseResult(getClass(), testMethodResults);
    }

    private RTWTestMethodResult runSingleTestMethod(Runnable testMethod) {
        try {
            testMethod.run();
        } catch (Throwable e) {
            return new RTWTestMethodResult(e);
        }
        return new RTWTestMethodResult();
    }
}
