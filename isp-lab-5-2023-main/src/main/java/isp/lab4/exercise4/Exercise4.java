package isp.lab4.exercise4;

public class Exercise4 {

    public static void main(String[] args) {
        UserApp andreiApp=new UserApp();
        andreiApp.authentication("ioan","vasi");
        andreiApp.login("ioan","vasi");
        andreiApp.login("ioan","vasi");

        andreiApp.buyTicket(TicketType.VIP);
        andreiApp.addCredit(50f);
        andreiApp.buyTicket(TicketType.VIP);

        OrganizerApp eSportF1= new OrganizerApp();
        eSportF1.authentication("admin","admin");
        eSportF1.login("admin","admin");
        //verificare daca a pus ticket in memorie
        TicketsManager ticketsManager = new TicketsManager();
        ticketsManager.getAllTickets();
        //verificare ticket
        eSportF1.checkIn(andreiApp.getUserId());

    }
}
