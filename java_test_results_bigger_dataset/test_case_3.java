/*
public static OptionalInteger> getPort(String server) throws InterruptedException, ExecutionException  Objects.requireNonNull(server); DnsQuestion question = new DefaultDnsQuestion(server, DnsRecordType.SRV); DnsResponse response = RESOLVER.query(question).get().content(); DnsRawRecord record = response.recordAt(DnsSection.ANSWER); if (record == null) return Optional.empty(); ByteBuf buffer = record.content(); buffer.readShort(); buffer.readShort(); int port = buffer.readShort(); if (!ValidationUtil.port(port)) return Optional.empty(); return Optional.of(port);
*/

@Test public void getPort() throws InterruptedException  OptionalInteger> port = new DnsQuestion(server, DnsRecordType.SRV); OptionalInteger> port = port.getPort(port); DnsQuestion question = DnsQuestion.getPort(server, DnsRecordType.SRV); DnsQuestion response = DnsQuestion.getPort(server, DnsResponse.getPort(port); DnsQuestion question = new DnsQuestion(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse); DnsResponse response = response.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.RTV); DnsResponse.getPort(server, DnsResponse.RTV); DnsResponse response = response.getPort(server, DnsResponse.RTV); DnsResponse.getPort(server, DnsResponse.RTV); DnsResponse.getPort(server, DnsResponse.getPort(server, DnsResponse.RTV); DnsResponse.getPort(server, DnsResponse.RTV); DnsResponse response = response.getPort(server, DnsResponse.RTV); DnsResponse.getPort(server, DnsResponse.RT