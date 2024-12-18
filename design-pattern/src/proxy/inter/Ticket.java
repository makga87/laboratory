package proxy.inter;


public interface Ticket extends Issuable, Enterable {

	Long getTicketNo();
	String getTicketType();
	void changeStatus();

}
