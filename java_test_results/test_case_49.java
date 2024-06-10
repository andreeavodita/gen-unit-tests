/*
@Handler(auth = false) public static MessageOrBuilder rq_ping(RQ_Ping rq)  return RS_Ping.newBuilder();
*/

@Handler(auth = false) public MessageOrBuilder rq_ping(RQ_Ping rq)  assertEquals(RS_Ping.newBuilder());