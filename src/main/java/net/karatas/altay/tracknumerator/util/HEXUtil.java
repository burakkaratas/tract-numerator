package net.karatas.altay.tracknumerator.util;

public class HEXUtil {

    public static String nextHex(String hex) {
        int intValue = Integer.parseInt(hex, 16);
        int intResult = intValue + 1;
        String hexResult = Integer.toHexString(intResult);
        return hexResult;
    }

    public static boolean isBig(){}
}
