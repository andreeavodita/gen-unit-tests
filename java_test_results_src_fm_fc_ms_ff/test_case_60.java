/*
TypeTokenUtils  public static TypeToken?> extractElementTypeToken(TypeToken?> typeToken)  if (typeToken.isSubtypeOf(Collection.class))  ListTypeToken?>> genericTypeTokens = TypeTokenUtils.extractGenericTypeTokens(typeToken); if (genericTypeTokens.size() == 0)  return TypeToken.of(Object.class);  else  return genericTypeTokens.get(0);   else if (typeToken.isArray())  return typeToken.getComponentType();  else  throw new IllegalArgumentException("typeToken must be from List or array");   static TypeToken?> extractElementTypeToken(TypeToken?> typeToken); static ListTypeToken?>> extractGenericTypeTokens(TypeToken?> typeToken);
*/

@Test public void extractElementTypeToken() throws Exception  TypeToken?> typeToken = new TypeToken?>(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeTokenUtils.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeTokenUtils.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken?> typeToken = TypeToken.extractElementTypeToken(TypeToken.of(Collection.class)); TypeToken