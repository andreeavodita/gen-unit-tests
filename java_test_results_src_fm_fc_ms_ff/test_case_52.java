/*
LoginExe extends Exelet  @Handler(auth = false, instances = VIEWER) public static MessageOrBuilder rq_login(ExeletContext context, RQ_Login rq)  log.debug("Processing login request from: ", context.connector.getRemoteAddress()); var outcome = begin(); String username = rq.getUsername(); if (!ValidationUtil.username(username))  log.debug("The username () is invalid", username); return failure(outcome, INVALID_USERNAME);  User user = UserStore.getByUsername(username).orElse(null); if (user == null)  log.debug("The user () does not exist", username); return failure(outcome, ACCESS_DENIED);  if (user.isExpired())  log.debug("The user () is expired", username); return failure(outcome, ACCESS_DENIED);  if (user.totpSecret().isPresent())  var key = new SecretKeySpec(user.getTotpSecret(), TOTP.getAlgorithm()); try  if (rq.getTotp()!= TOTP.generateOneTimePassword(key, Instant.now()))  log.debug("OTP validation failed", username); return failure(outcome, ACCESS_DENIED);   catch (InvalidKeyException e)  log.error("Invalid TOTP secret", e); return failure(outcome, ACCESS_DENIED);  finally  try  key.destroy();  catch (DestroyFailedException e)  log.error("Failed to destroy TOTP secret", e); return failure(outcome, ACCESS_DENIED);    if
*/

@Test public void testRQ_login() throws Exception  LoginExe rq_login = new LoginExe(); context.connector = createMock(ExeletContext.class); assertEquals("Processing login request from: "Processing login request from: "Processing login request from: "Processing login request from: "Processing login request from: "Processing login error message");