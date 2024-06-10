/*
@SuppressWarnings("unchecked") @Override public Object convert(Object source, TypeToken?> targetTypeToken)  if (!canHandle(source, targetTypeToken))  throw new ConverterException(source, targetTypeToken.getRawType());  Constructor constructor; try  constructor = ((Class) targetTypeToken.getType()).getConstructor(Object.class);  catch (NoSuchMethodException e)  throw new ConverterException(source, targetTypeToken.getRawType(), e);  try  return constructor.newInstance(source);  catch (Exception e)  throw new ConverterException(source, targetTypeToken.getRawType(), e);
*/

@Override public Object convert(source, targetTypeToken)  if (!canHandle("unchecked"))  if (!canHandle("unchecked"))  if (!canHandle("unchecked"))