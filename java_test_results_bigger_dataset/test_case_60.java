/*
public static TypeToken?> extractElementTypeToken(TypeToken?> typeToken)  if (typeToken.isSubtypeOf(Collection.class))  ListTypeToken?>> genericTypeTokens = TypeTokenUtils.extractGenericTypeTokens(typeToken); if (genericTypeTokens.size() == 0)  return TypeToken.of(Object.class);  else  return genericTypeTokens.get(0);   else if (typeToken.isArray())  return typeToken.getComponentType();  else  throw new IllegalArgumentException("typeToken must be from List or array");
*/

@Test public void extractElementTypeTokens() throws Exception  TypeToken?>> refactoring = new TypeToken("test"); TypeToken?> refactoring = new TypeToken("test");