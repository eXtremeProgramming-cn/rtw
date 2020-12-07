package cn.extremeprogramming.rtw.xunit;

import java.util.List;

public class RTWTestCaseResult {
    private final List<RTWTestMethodResult> testMethodResults;

    public RTWTestCaseResult(List<RTWTestMethodResult> testMethodResults) {
        this.testMethodResults = testMethodResults;
    }

    public boolean isSuccessful() {
        return testMethodResults.stream().allMatch(result -> result.isSuccessful);
    }

    public int size() {
        return testMethodResults.size();
    }
}
