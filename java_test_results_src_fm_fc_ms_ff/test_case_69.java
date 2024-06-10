/*
DefaultScriptHandler implements ScriptHandler  @Override public void register(ScriptRunnerModule scriptRunnerModule)  IteratorScriptRunner> elements = scriptRunnerModule.getScriptRunners().iterator(); while (elements.hasNext())  register(elements.next());   DefaultScriptHandler(); @Override Object runScript(ScriptFragment scriptFragment); @Override void register(ScriptRunnerModule scriptRunnerModule); @Override void register(ScriptRunner scriptRunner); ScriptRunner get(ScriptFragment scriptFragment);
*/

@Test public void register()  scriptRunnerModule scriptRunnerModule = scriptRunnerModule.getScriptRunners(); defaultScriptHandler.register(ScriptRunnerModule); assertEquals("ScriptRunnerModule");