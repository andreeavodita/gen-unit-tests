/*
RandUtil  public static int nextInt()  return insecureRandom.nextInt();  private RandUtil(); static boolean nextBoolean(); static int nextInt(); static int nextInt(int lower, int upper); static long nextLong(long n); static long nextLong(long lower, long upper); static long nextLong(); static String nextAlphabetic(int characters); static String nextNumeric(int digits); static E nextItem(E[] array);
*/

@Test public void testNextInt()  assertEquals("insecureRandom.nextInt()", nextInt());