/*
@Override public Object convert(Object source, TypeToken?> targetTypeToken)  if (!canHandle(source, targetTypeToken))  throw new ConverterException(source, targetTypeToken.getRawType());  Date date = stringToDateConverter.convert(String.valueOf(source)); return dateToJodaTimeBaseLocalConverter.convert(date, targetTypeToken);
*/

@Override public void convert(Object source, TypeToken)  if (!canHandle(source, targetTypeToken))  thrown new ConverterException(source, targetTypeToken);