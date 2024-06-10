/*
RandUtil  public static String nextNumeric(int digits)  StringBuffer buffer = new StringBuffer(); for (int i = 0; i  digits; i++)  buffer.append((char) nextInt('0', '9'));  return buffer.toString();  private RandUtil(); static boolean nextBoolean(); static int nextInt(); static int nextInt(int lower, int upper); static long nextLong(long n); static long nextLong(long lower, long upper); static long nextLong(); static String nextAlphabetic(int characters); static String nextNumeric(int digits); static E nextItem(E[] array);
*/

@Test public void testNegativeNumeric()  assertEquals("0", nextNumeric("0", nextNumeric("0", "9"));