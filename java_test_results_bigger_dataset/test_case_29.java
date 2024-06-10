/*
public static String formatByteCountSI(long bytes)  long b = bytes == Long.MIN_VALUE? Long.MAX_VALUE : Math.abs(bytes); return b  1000L? bytes + " B" : b  999_950L? String.format("%.1f kB", b / 1e3) : (b /= 1000)  999_950L? String.format("%.1f MB", b / 1e3) : (b /= 1000)  999_950L? String.format("%.1f GB", b / 1e3) : (b /= 1000)  999_950L? String.format("%.1f TB", b / 1e3) : (b /= 1000)  999_950L? String.format("%.1f PB", b / 1e3) : String.format("%.1f EB", b / 1e6);
*/

@Test public void testFormatByteCountSIBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesBytesB", b :