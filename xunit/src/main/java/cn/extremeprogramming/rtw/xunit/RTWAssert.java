package cn.extremeprogramming.rtw.xunit;

import cn.extremeprogramming.rtw.xunit.exception.RTWAssertionError;

public class RTWAssert {
    public static void fail() {
        throw new RTWAssertionError("Intentional failure");
    }
}
