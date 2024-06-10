/*
public static ClassLoader getDefaultClassLoader()  ClassLoader cl = null; try  cl = Thread.currentThread().getContextClassLoader();  finally  if (cl == null)  cl = ClassUtils.class.getClassLoader();  if (cl == null)  cl = ClassLoader.getSystemClassLoader();   return cl;
*/

@Test public void getDefaultClassLoader() throws Exception  ClassLoader cl = new ClassLoader(); ClassLoader cl = new ClassLoader(); ClassLoader cl = new ClassLoader(); ClassLoader cl = new ClassLoader(cl.getDefaultClassLoader());