package net.karatas.altay.tracknumerator.util;

public class HEXUtil {

  public static String nextHex(String hex, int offset) {
    Integer intValue = Integer.parseInt(hex, 16);
    Integer intResult = intValue + offset;
    String hexResult = Integer.toHexString(intResult);
    return hexResult;
  }

  public static Integer getRangeBetweenTwos(String hex1, String hex2) {
    Integer intValue1 = Integer.parseInt(hex1, 16);
    Integer intValue2 = Integer.parseInt(hex2, 16);
    return Math.abs(Math.subtractExact(intValue1, intValue2));
  }

}
