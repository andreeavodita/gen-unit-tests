/*
NetUtil  public static OptionalString> serviceName(int port)  if (!ValidationUtil.port(port)) throw new IllegalArgumentException("Invalid port: " + port); if (!serviceResolutionEnabled) return Optional.empty(); if (port >= 49152) return Optional.empty(); if (serviceCache.containsKey(port)) return Optional.of(serviceCache.get(port)); try  var serviceName = serviceName0(port); if (serviceName!= null)  serviceCache.put(port, serviceName); return Optional.of(serviceName);  else  return Optional.empty();   catch (Exception e)  serviceResolutionEnabled = false; return Optional.empty();   private NetUtil(); static boolean checkPort(String host, int port); static byte[] download(String url); static void download(String url, File file); static byte[] download(URL url); static void download(URL url, File file); static OptionalString> serviceName(int port);
*/

@Test public void testServiceName() throws Exception  NetUtil.put(port, 49152); OptionalString> serviceName = serviceName(new IntegerPort("/foo/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar.of("foo", "foo", "foo", "foo", "bar")); assertEquals("Invalid port: " + port); assertEquals("Port: " + port); assertEquals("Port: " + port); assertEquals("Port: " + port); assertEquals("Port: " + port); assertEquals("Port: " + port); assertEquals("Port: " + port); assertEquals("foo", Optional.of("foo", Optional.of("bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar/bar