package proxy;


import proxy.inter.Ticket;

public class TicketProxy implements Ticket {

	private GeneralTicket generalTicket;

	public TicketProxy(GeneralTicket generalTicket) {
		this.generalTicket = generalTicket;
	}

	@Override
	public Long getTicketNo() {
		return generalTicket.getTicketNo();
	}

	@Override
	public String getTicketType() {
		System.out.println("It is proxy");
		return generalTicket.getTicketType();
	}

	@Override
	public void changeStatus() {
		generalTicket.changeStatus();
	}

	@Override
	public void enter() {
		System.out.println("Check, before enter");
		generalTicket.enter();
	}

	@Override
	public void issue(int ticketNo) {
		System.out.println("Check, before issue");
		generalTicket.issue(ticketNo);
	}
}
