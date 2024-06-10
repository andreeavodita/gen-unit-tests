/*
@Override public Object runScript(ScriptFragment scriptFragment)  ScriptRunner process = get(scriptFragment); if (process == null)  throw new IllegalArgumentException("can not find ScriptRunner for " + scriptFragment.toScriptString());  return process.run(scriptFragment);
*/

@Override public void runScript(scriptFragment scriptFragment)  ScriptRunner process = get(scriptFragment); if (process == null)  ScriptRunner process = get(scriptFragment);