/*
AbstractGenericConverter extends AbstractConverter  @Override public boolean canHandle(Object source, TypeToken?> typeToken)  return sourceTypeToken.getRawType().equals(source.getClass()) && this.targetTypeToken.equals(typeToken);  AbstractGenericConverter(); AbstractGenericConverter(int priority); @SuppressWarnings("unchecked") @Override Object convert(Object source, TypeToken?> typeToken); abstract D convert(S source); @Override boolean canHandle(Object source, TypeToken?> typeToken); TypeTokenS> getSourceTypeToken(); TypeTokenD> getTargetTypeToken();
*/

@Test public void canHandle()  assertEquals(canHandle(Source, TypeToken?> typeToken, new AbstractGenericConverter().canHandle(Source, TypeToken?>>());