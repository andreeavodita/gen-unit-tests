/*
PrimitiveTypeUtils  public static Class?> toWrapper(final TypeToken?> primitiveTypeToken)  return toWrapper((Class?>) primitiveTypeToken.getType());  static Class?> toWrapper(final TypeToken?> primitiveTypeToken); static TypeToken?> toWrapperTypeToken(final TypeToken?> primitiveTypeToken); static Class?> toWrapper(final Class?> primitiveType); static Object toWrapperListToPrimitiveArray(final List wrapperList, Class?> primitiveType);
*/

@Test public void testToWrapper()  PrimitiveTypeUtils.toWrapper("foo"); assertEquals(toWrapper("foo");