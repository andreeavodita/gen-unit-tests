/*
public static String getLatestVersion(String gav) throws IOException  checkNotNull(gav); var coordinate = ParsedCoordinate.fromCoordinate(gav); String url = MAVEN_HOST + "/maven2/" + coordinate.groupId.replaceAll(".", "/") + "/" + coordinate.artifactId + "/maven-metadata.xml"; try (var in = new URL(url).openStream())  return XPathFactory.newDefaultInstance().newXPath().evaluate("/metadata/versioning/latest", DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in));  catch (XPathExpressionException | SAXException | ParserConfigurationException e)  throw new IOException(e);
*/

@Test public void getLatestVersion() throws IOException  checkNotNull("/maven2/"); String url = new IOException("/maven2/"); assertEquals("/maven2/");