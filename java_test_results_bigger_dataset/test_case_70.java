/*
@Override public Object runScript(ScriptFragment scriptFragment)  ScriptRunner process = get(scriptFragment); if (process == null)  throw new IllegalArgumentException("can not find ScriptRunner for " + scriptFragment.toScriptString());  return process.run(scriptFragment);
*/

@Override public Object runScript(ScriptFragment scriptFragment); Object refactored = new Object(); refactored.runScript(ScriptFragment scriptFragment); refactored.runScript(scriptFragment); refactored.runScript(scriptFragment); refactored.runScript(scriptFragment); refactored.runScript(scriptFragment); refactored.runScript(scriptFragment);