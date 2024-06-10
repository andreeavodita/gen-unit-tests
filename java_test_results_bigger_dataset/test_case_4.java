/*
void handshake(Channel channel, InstanceType instance, InstanceFlavor flavor, String uuid)  log.debug("Initiating CVID handshake"); channel.writeAndFlush( MsgUtil.rq(RQ_Cvid.newBuilder().setInstance(instance).setInstanceFlavor(flavor).setUuid(uuid)).build());
*/

@Test(expectedExceptions = NullPointerException.class) void handshake(Channel channel, InstanceType instance, InstanceType instance, InstanceType, String uuid);