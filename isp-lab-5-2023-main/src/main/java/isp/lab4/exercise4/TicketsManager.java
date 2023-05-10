package isp.lab4.exercise4;

import java.util.ArrayList;

public class TicketsManager {
    static private ArrayList<String> tickets=new ArrayList<>();
    PaymentGateway paymentGateway=new PaymentGateway();
    void generateTicket(TicketType ticketType,String userId){
        this.tickets.add(ticketType.name()+userId+this.tickets.size());
        paymentGateway.validateUserPayment();
    }
    void validateTicket(String tickedScanned){
        for(int i=0;i<tickets.size();i++){
            if(tickets.get(i).equals(tickedScanned)) {
                System.out.println("Ticket-ul "+tickedScanned + " este VALID.");
                return;
            }}
        System.out.println("Ticket-ul "+tickedScanned + " nu a fost gasit.");
    }
    void getAllTickets(){
        for(int i=0;i<tickets.size();i++)
            System.out.println("Ticket"+i+": "+tickets.get(i));
    }

}
