package proxy;


public class ProxyMain {

	public static void main(String[] args) {
		TicketProxy proxy = new TicketProxy(new GeneralTicket());

		proxy.issue(3);
		proxy.enter();
	}
}
