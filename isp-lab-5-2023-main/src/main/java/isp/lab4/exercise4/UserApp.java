package isp.lab4.exercise4;

public class UserApp implements App {
    private String userId;
    private String userPassword;
    private boolean logged;
    private TicketsManager ticketsManager=new TicketsManager();
    private float credit;

    UserApp(){
        this.logged=false;
    }
    @Override
    public void authentication(String id, String password) {
        this.userId=id;
        this.userPassword=password;
       // this.logged=true;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public void login(String id, String password) {
        if(this.logged==false)
            if(checkCredential(id,password)==false) System.out.println("Date incorecte");
            else {
                System.out.println("Sunteti logat cu id-ul: "+this.userId);
                this.logged=true;
            }
        else System.out.println("Sunteti deja logat cu id-ul:"+this.userId);
    }

    @Override
    public boolean checkCredential(String id, String password) {
        // ar trebui sa citesc dintr-un fisier dar e ok si asa mai simply
        if(this.userId==id && this.userPassword==password )return true;
        else return false;
    }
    public void addCredit(float credit){
        this.credit=credit;
    }
    public void buyTicket(TicketType ticketType){
        if(ticketType.getPrice()>this.credit) System.out.println("Insufficient sold, please add: "+(ticketType.getPrice()-this.credit));
        else {
                this.ticketsManager.generateTicket(ticketType,this.userId);
        }
    }

}
