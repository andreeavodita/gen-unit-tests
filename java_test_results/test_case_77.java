/*
@Override public Object run(ScriptFragment scriptFragment)  if (!canHandle(scriptFragment)) throw new ScriptOperationException(scriptFragment.getMethodName() + " is not support."); if (scriptFragment.getNext() == null || scriptFragment.getNext().getMethodName().equals(NUMBER_SEQUENCE_METHOD_NAME))  return longSequence.addAndGet(1l);  else  throw new ScriptOperationException(scriptFragment.getMethodName() + " is not support.");
*/

@Override public Object run(ScriptFragment scriptFragment)  if (!canHandle(scriptFragment)) throws new ScriptOperationException(scriptFragment.getMethodName(1l)); assertEquals(1l));