/*
StringToJodaTimeBaseLocalConverter extends AbstractConverter  @Override public Object convert(Object source, TypeToken?> targetTypeToken)  if (!canHandle(source, targetTypeToken))  throw new ConverterException(source, targetTypeToken.getRawType());  Date date = stringToDateConverter.convert(String.valueOf(source)); return dateToJodaTimeBaseLocalConverter.convert(date, targetTypeToken);  @Override Object convert(Object source, TypeToken?> targetTypeToken); @Override boolean canHandle(Object source, TypeToken?> targetTypeToken);
*/

@Test public void testCanHandle() throws Exception  StringToJodaTimeBaseLocalConverter convert(new StringToJodaTimeBaseLocalConverter().convert(new TypeToken?>("date", targetTypeToken)); assertEquals(convert(new StringToJodaTimeBaseLocalConverter().convert(new StringToJodaTimeBaseLocalConverter().convert(new StringToken?>("date", "date"));