/*
CertUtil  public static X509Certificate parseCert(String cert) throws CertificateException  return parseCert(Base64.getDecoder().decode(Objects.requireNonNull(cert)));  private CertUtil(); static X509Certificate getServerRoot(); static X509Certificate getPluginRoot(); static X509Certificate getDefaultCert(); static PrivateKey getDefaultKey(); static boolean checkValidity(X509Certificate cert); static boolean checkHostname(X509Certificate cert, String hostname); static X509Certificate parseCert(String cert); static X509Certificate parseCert(File cert); static X509Certificate parseCert(byte[] cert); static PrivateKey parseKey(byte[] key); static String getInfoString(String cert); static String getInfoString(X509Certificate cert); static String getInfoHtml(X509Certificate cert);
*/

@Test public void testParseCert() throws CertificateException  assertEquals(CertUtil.parseCert("test");