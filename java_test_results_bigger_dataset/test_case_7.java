/*
public static void dispatch(Class?> main, String[] args, InstanceType instance, InstanceFlavor flavor)  if (MainDispatch.main!= null) throw new IllegalStateException("Dispatch cannot be called more than once"); MainDispatch.main = Objects.requireNonNull(main); MainDispatch.instance = Objects.requireNonNull(instance); MainDispatch.flavor = Objects.requireNonNull(flavor); final long timestamp = System.currentTimeMillis(); final Logger log = LoggerFactory.getLogger(MainDispatch.class); Thread.setDefaultUncaughtExceptionHandler((thread, throwable) ->  log.error("An unexpected exception has occurred", throwable); ); Runtime.getRuntime().addShutdownHook(new Thread(() ->  shutdown.forEach(task ->  try  task.execute(new TaskOutcome(task.toString()));  catch (Exception e)  log.error("Failed to execute shutdown task", e);  ); )); try  main.getDeclaredMethod("main", String[].class).invoke(null, (Object) args);  catch (Exception e)  throw new RuntimeException("Failed to invoke main method in class: " + main.getName(), e);  for (Task task : tasks)  if (task.initMetadata == null) throw new RuntimeException("Unregistered initialization task class"); TaskOutcome outcome = new TaskOutcome(task.initMetadata.name()); try  task.outcome = task.execute(outcome);  catch (Exception e)  task.outcome = outcome.failure(e);  if (!task.outcome.isSkipped() &&
*/

@Test public void dispatch(MainDispatch.main, String[] args, InstanceType instance, InstanceFlavor flavor); assertEquals(Exception e.getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstance().getInstance().getInstance().getInstance().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType().getInstanceType