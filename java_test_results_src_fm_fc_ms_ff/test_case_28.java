/*
TextUtil  public static String formatByteCount(long bytes)  long b = bytes == Long.MIN_VALUE? Long.MAX_VALUE : Math.abs(bytes); return b  1024L? bytes + " B" : b = 0xfffccccccccccccL >> 40? String.format("%.1f KiB", bytes / 0x1p10) : b = 0xfffccccccccccccL >> 30? String.format("%.1f MiB", bytes / 0x1p20) : b = 0xfffccccccccccccL >> 20? String.format("%.1f GiB", bytes / 0x1p30) : b = 0xfffccccccccccccL >> 10? String.format("%.1f TiB", bytes / 0x1p40) : b = 0xfffccccccccccccL? String.format("%.1f PiB", (bytes >> 10) / 0x1p40) : String.format("%.1f EiB", (bytes >> 20) / 0x1p40);  static String formatByteCount(long bytes); static String formatByteCountSI(long bytes); static long unformatByteCount(String count);
*/

@Test public void testFormatByteCountSI()  TextUtil.formatByteCount(long bytes)); TextUtil.formatByteCount(long bytes) : TextUtil.formatByteCount(long bytes).MIN_VALUE : Math.abs(bytes).abs(bytes).abs(bytes).abs(bytes).abs(bytes).formatByteCount(long bytes).formatByteCount(long).MIN_VALUE? Math.abs(bytes).size()); assertEquals("%.1f PiB", String.formatByteCount(long bytes)); assertEquals("%.1f PiB", String.formatByteCount(long bytes).formatByteCount(long).MAX_VALUE : Math.abs(bytes).abs(bytes).abs(bytes).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).formatByteCount(long).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).formatByteCount(long).MAX_VALUE : Math.abs(bytes).formatByteCount(long).formatByteCount(long).formatByteCount(long).MAX_VALUE : Math