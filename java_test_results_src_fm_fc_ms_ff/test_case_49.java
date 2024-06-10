/*
BannerExe extends Exelet  @Handler(auth = false) public static MessageOrBuilder rq_ping(RQ_Ping rq)  return RS_Ping.newBuilder();  private BannerExe(); @Handler(auth = false) static MessageOrBuilder rq_server_banner(RQ_ServerBanner rq); @Handler(auth = false) static MessageOrBuilder rq_ping(RQ_Ping rq);
*/

@Test public void testRq_ping()  BannerExe bannerExe = new BannerExe(); assertEquals("rq_ping", rq_ping(RQ_Ping));