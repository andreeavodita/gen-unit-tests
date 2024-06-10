/*
FsHandle implements Closeable  public void addUpdateCallback(ConsumerEV_FileListing> callback)  if (callback == null) throw new IllegalArgumentException(); callbacks.add(callback);  FsHandle(); FsHandle(String start); FsHandle(String start, FsHandleOptions options); FsHandle(FileSystem fs, String start, FsHandleOptions options); int getId(); String pwd(); void addUpdateCallback(ConsumerEV_FileListing> callback); boolean up(); boolean down(String directory); boolean setPath(String path); ListFileListlet> list(); @Override void close();
*/

@Test public void testAddUpdateCallback() throws Exception  FsHandle fs = new FsHandle(fs, start, options); assertEquals(fs, fs, start, options);