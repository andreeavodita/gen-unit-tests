/*
SequenceScriptRunner implements ScriptRunner  @Override public Object run(ScriptFragment scriptFragment)  if (!canHandle(scriptFragment)) throw new ScriptOperationException(scriptFragment.getMethodName() + " is not support."); if (scriptFragment.getNext() == null || scriptFragment.getNext().getMethodName().equals(NUMBER_SEQUENCE_METHOD_NAME))  return longSequence.addAndGet(1l);  else  throw new ScriptOperationException(scriptFragment.getMethodName() + " is not support.");   @Override Object run(ScriptFragment scriptFragment); @Override boolean canHandle(ScriptFragment scriptFragment);
*/

@Test public void testScriptFragment() throws Exception  scriptFragment scriptFragment = new SequenceScriptRunner(ScriptFragment.getMethodName()); SequenceScriptRunner scriptFragment = new SequenceScriptRunner(ScriptFragment.getMethodName()); scriptFragment.run(ScriptFragment); assertEquals(1l, scriptFragment);