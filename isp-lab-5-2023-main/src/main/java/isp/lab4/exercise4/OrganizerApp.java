package isp.lab4.exercise4;

public class OrganizerApp implements App {
    private String organizerId;
    private String organizerPassword;
    private boolean logged;
    private TicketsManager ticketsManager=new TicketsManager();
    @Override
    public void authentication(String id, String password) {
        this.organizerId=id;
        this.organizerPassword=password;
        //this.logged=true;
    }

    @Override
    public void login(String id, String password) {
        if(!this.logged )
            if(!checkCredential(id, password)) System.out.println("Date incorecte");
            else {
                System.out.println("Sunteti logat cu id-ul: "+this.organizerId);
                this.logged=true;
            }
        else System.out.println("Sunteti deja logat cu id-ul:"+this.organizerId);
    }

    @Override
    public boolean checkCredential(String id, String password) {
        // ar trebui sa citesc dintr-un fisier dar e ok si asa mai simply
        String id_test="admin";
        String password_test="admin";
        if(id_test.equals(id) && password_test.equals(password))return true;
        else return false;
    }
    public void checkIn(String userId){
    //after scaning the ticket we get
        //scanticket();
        String ticketScanned=TicketType.VIP.name()+userId+0;
        ticketsManager.validateTicket(ticketScanned);
    }
}
