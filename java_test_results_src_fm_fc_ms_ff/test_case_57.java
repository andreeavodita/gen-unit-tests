/*
OptionalTypeFixtureConverter implements FixtureConverter  @Override public Object convert(FixtureTemplate fixtureTemplate, TypeToken typeToken)  if (typeToken.getRawType()!= Optional.class)  return fixtureConverter.convert(fixtureTemplate, typeToken);  ListTypeToken?>> types = TypeTokenUtils.extractGenericTypeTokens(typeToken); if (types.isEmpty())  if (fixtureTemplate instanceof FixtureValue)  Object value = ((FixtureValue) fixtureTemplate).getValue(); return Optional.of(value);  return null;  else  return Optional.of(fixtureConverter.convert(fixtureTemplate, types.get(0)));   OptionalTypeFixtureConverter(FixtureConverter converter); @Override Object convert(FixtureTemplate fixtureTemplate, TypeToken typeToken);
*/

@Test public void testFixtureTemplate() throws Exception  OptionalTypeFixtureConverter converter = new OptionalTypeFixtureConverter(converter, fixtureTemplate, TypeToken); OptionalTypeFixtureConverter converter = new OptionalTypeFixtureConverter(converter, fixtureTemplate, typeToken); assertNull(converter.convert(false, null, null, null, null, null, null, null));