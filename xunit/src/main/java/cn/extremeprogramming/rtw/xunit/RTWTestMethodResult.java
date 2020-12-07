package cn.extremeprogramming.rtw.xunit;

public class RTWTestMethodResult {
    final boolean isSuccessful;

    public RTWTestMethodResult(Throwable e) {
        isSuccessful = false;
    }

    public RTWTestMethodResult() {
        isSuccessful = true;
    }
}
