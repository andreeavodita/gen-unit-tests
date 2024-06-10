/*
public static OptionalString> serviceName(int port)  if (!ValidationUtil.port(port)) throw new IllegalArgumentException("Invalid port: " + port); if (!serviceResolutionEnabled) return Optional.empty(); if (port >= 49152) return Optional.empty(); if (serviceCache.containsKey(port)) return Optional.of(serviceCache.get(port)); try  var serviceName = serviceName0(port); if (serviceName!= null)  serviceCache.put(port, serviceName); return Optional.of(serviceName);  else  return Optional.empty();   catch (Exception e)  serviceResolutionEnabled = false; return Optional.empty();
*/

@Test public void testServiceName() throws Exception  OptionalString> serviceName(port); assertEquals(optional.empty(), Optional.of("invalid port: ");