/*
@SuppressWarnings("unchecked") @Override public MapString, FixtureMap> parse(String fixture)  MapString,? extends Object> fixtures = buildYaml().loadAs(fixture, Map.class);; MapString, FixtureMap> fixtureMaps = new HashMap>(); for (String key : fixtures.keySet())  if (fixtures.get(key) instanceof Map)  FixtureMap fixtureMap = FixtureTemplateWrapper.wrap((Map) fixtures.get(key), key, null); fixtureMap.setRoot(true); fixtureMaps.put(key, fixtureMap);  else  throw new FixtureFormatException(key, " the root of fixture data should be key - value");   return fixtureMaps;
*/

@SuppressWarnings("unchecked") @Override public void testFilterView() throws Exception  FixtureMap fixtureMap = new FixtureMap(key, null);