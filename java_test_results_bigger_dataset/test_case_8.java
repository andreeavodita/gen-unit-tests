/*
public static Path download(Path directory, String gav) throws IOException  checkNotNull(directory); checkNotNull(gav); var coordinate = ParsedCoordinate.fromCoordinate(gav); String url = MAVEN_HOST + "/maven2/" + coordinate.groupId.replaceAll(".", "/") + "/" + coordinate.artifactId + "/" + coordinate.version + "/" + coordinate.filename; log.debug("Downloading artifact: ", url); Path output = directory.resolve(coordinate.filename); NetUtil.download(url, output.toFile()); return output;
*/

@Test public void testDownloadPathFinder() throws IOException  Path path = path.download(directory, String gav); String gav = "/maven2/"; String gav = "/maven2/"; String gav = "/maven2/"; String gav = "/maven2/"; String gav = "/maven2/"; String gav = "/maven2/"; path output = path.download(directory, String gav);