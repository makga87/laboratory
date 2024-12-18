package proxy;


import proxy.inter.Ticket;

public class GeneralTicket implements Ticket {
	@Override
	public Long getTicketNo() {
		return 0L;
	}

	@Override
	public String getTicketType() {
		return "GENERAL";
	}

	@Override
	public void changeStatus() {

	}

	@Override
	public void enter() {
		System.out.println("General ticket entered");
	}

	@Override
	public void issue(int ticketNo) {
		System.out.println("General ticket issued");
	}
}
