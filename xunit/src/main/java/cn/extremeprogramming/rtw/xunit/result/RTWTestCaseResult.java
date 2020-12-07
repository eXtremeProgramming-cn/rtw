package cn.extremeprogramming.rtw.xunit.result;

import cn.extremeprogramming.rtw.xunit.RTWTestCase;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class RTWTestCaseResult {
    private final Class<? extends RTWTestCase> testCaseClass;
    private final List<RTWTestMethodResult> testMethodResults;

    public RTWTestCaseResult(Class<? extends RTWTestCase> aClass, List<RTWTestMethodResult> testMethodResults) {
        testCaseClass = aClass;
        this.testMethodResults = testMethodResults;
    }

    public boolean isSuccessful() {
        return testMethodResults.stream().allMatch(result -> result.isSuccessful);
    }

    public int numberOfTestMethods() {
        return testMethodResults.size();
    }

    @Override
    public String toString() {
        return testMethodResults.stream().map(Object::toString).collect(joining());
    }

    public String testCaseName() {
        return testCaseClass.getCanonicalName();
    }
}
