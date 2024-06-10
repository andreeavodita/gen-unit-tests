/*
public static boolean resourceExists(Path file, String resource) throws IOException  checkNotNull(resource); checkNotNull(file); if (!Files.exists(file)) throw new FileNotFoundException(); if (!resource.startsWith("/")) resource = "/" + resource; try (FileSystem fs = FileSystems.newFileSystem(file, (ClassLoader) null))  return Files.exists(fs.getPath(resource));  catch (ProviderNotFoundException e)  throw new IOException("Illegal file type");
*/

@Test public void testFileSystemExists(file, String resource) throws IOException  checkNotNull(resource); checkNotNull(resource);