/*
ValidationUtil  public static boolean port(String port)  try  return port(Integer.parseInt(port));  catch (Throwable t)  return false;   private ValidationUtil(); static boolean username(String user); static boolean group(String group); static boolean password(String password); static boolean privateIP(String ip); static boolean address(String address); static boolean port(String port); static boolean port(int port); static boolean path(String path); static boolean version(String version); static boolean email(String email); static boolean ipv4(String ipv4); static final int USER_MAX; static final int USER_MIN; static final int GROUP_MAX; static final int GROUP_MIN; static final int PASSWORD_MAX; static final int PASSWORD_MIN;
*/

@Test public void testPort() throws Exception  assertFalse(validationUtil.parseInt(Port));