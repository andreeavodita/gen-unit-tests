/*
AbstractBeanMother implements BeanMother  @Override public T> T bear(String fixtureName, T target)  return bear(fixtureName, target, null);  protected AbstractBeanMother(); FixturesStore getFixturesStore(); @Override T bear(String fixtureName, T target); @Override T bear(String fixtureName, ClassT> targetClass); @Override T bear(String fixtureName, T target, PostProcessorT> postProcessor); @Override T bear(String fixtureName, ClassT> targetClass, PostProcessorT> postProcessor); @Override ListT> bear(String fixtureName, ClassT> targetClass, int size); @Override ListT> bear(String fixtureName, ClassT> targetClass, int size, PostProcessorT> postProcessor); @Override BeanMother addFixtureLocation(String path);
*/

@Test public void testBir()  assertEquals("Bird", bear("Bird", bear("Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "foo", "abc"), "b", "b", "b", "Bird", "Bird")); assertEquals("Bird", bear("Bird", bear("Bird", bear("Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird")); assertEquals("Bird", bear("Bird", bear("Bird", bear("Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird")); assertEquals("Bird", bear("Bird", bear("Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird", "Bird")); assertE