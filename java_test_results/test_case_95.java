/*
public FixtureMap reproduce()  try  ByteArrayOutputStream bos = new ByteArrayOutputStream(1024 * 2); ObjectOutputStream oos = new ObjectOutputStream(bos); oos.writeObject(this); oos.flush(); oos.close(); ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray())); Object obj = ois.readObject(); FixtureMap dup = (FixtureMap) obj; dup.setParent(getParent()); dup.setRoot(isRoot()); dup.setFixtureName(getFixtureName()); return dup;  catch (Exception e)  throw new FixtureFormatException(getFixtureName(), e);
*/

@Test public void reproduce() throws Exception  try  ByteArrayOutputStream bos = new ByteArrayOutputStream(1024 * 2); ByteArrayOutputStream oo = new ByteArrayOutputStream(1024 * 2);