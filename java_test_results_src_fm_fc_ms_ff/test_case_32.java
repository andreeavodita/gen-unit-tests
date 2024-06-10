/*
RandUtil  public static String nextAlphabetic(int characters)  StringBuffer buffer = new StringBuffer(); for (int i = 0; i  characters; i++)  if (nextBoolean()) buffer.append((char) nextInt('A', 'Z')); else buffer.append((char) nextInt('a', 'z'));  return buffer.toString();  private RandUtil(); static boolean nextBoolean(); static int nextInt(); static int nextInt(int lower, int upper); static long nextLong(long n); static long nextLong(long lower, long upper); static long nextLong(); static String nextAlphabetic(int characters); static String nextNumeric(int digits); static E nextItem(E[] array);
*/

@Test public void testNextAlphabetic()  assertEquals("a", RandUtil.nextAlphabetic(int 0);