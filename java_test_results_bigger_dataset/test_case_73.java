/*
public static ScriptFragment of(FixtureValue fixtureValue)  if (fixtureValue.getValue() instanceof String)  Matcher matcher = FIXTURE_VALUE_SCRIPT_PATTERN.matcher((CharSequence) fixtureValue.getValue()); if (matcher.find())  String script = matcher.group(0); return of(script);   throw new IllegalArgumentException(fixtureValue.toString() + " is not a script");
*/

@Test public void testScriptFragment() throws Exception  String std = "ntntntntntntntntntntntntntntntntntntntntntntrntntntntntrntrntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntntnt