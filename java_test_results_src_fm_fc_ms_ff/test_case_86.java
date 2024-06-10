/*
StringToJodaTimeBaseLocalConverter extends AbstractConverter  @Override public boolean canHandle(Object source, TypeToken?> targetTypeToken)  return targetTypeToken.isSubtypeOf(BaseLocal.class) && stringToDateConverter.canHandle(source, TypeToken.of(Date.class));  @Override Object convert(Object source, TypeToken?> targetTypeToken); @Override boolean canHandle(Object source, TypeToken?> targetTypeToken);
*/

@Test public void testCanHandle()  assertEquals(canHandle(Object, TypeToken.of(Date.class));