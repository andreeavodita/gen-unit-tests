/*
ConstructHelper  @SuppressWarnings("unchecked") public static Object construct(Class?> type, FixtureMap fixtureMap, FixtureConverter fixtureConverter)  final Constructor?>[] constructs = type.getConstructors(); if (constructs.length == 0) throw new UnsupportedOperationException("can not create an instance. " + type + " does not have a constructor."); Object newInstance = null; if (fixtureMap.containsKey(CONSTRUCT_KEY))  FixtureTemplate constructorFixture = fixtureMap.get(CONSTRUCT_KEY); if (constructorFixture instanceof FixtureValue)  newInstance = constructByFixtureValue(type, (FixtureValue) constructorFixture, fixtureConverter);  else if (constructorFixture instanceof FixtureList)  newInstance = constructByFixtureList(type, (FixtureList) constructorFixture, fixtureConverter);   if (newInstance == null)  try  newInstance = type.newInstance();  catch (Exception e)  throw new FixtureMappingException(type, fixtureMap, e);   return newInstance;  @SuppressWarnings("unchecked") static Object construct(Class?> type, FixtureMap fixtureMap, FixtureConverter fixtureConverter);
*/

@Test public void testConstructors() throws Exception  FixtureTemplate fixtureMap = new FixtureMap("foo", new FixtureMap("foo", new FixtureConverter()); Object refactoring = new FixtureMap("foo", new FixtureMap("foo", new FixtureMap("foo", new FixtureConverter());