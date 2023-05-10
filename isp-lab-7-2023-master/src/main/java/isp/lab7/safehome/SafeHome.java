package isp.lab7.safehome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SafeHome {
    static Set<Tenant> tenants=new HashSet<>();

    static List<AccessKey> accessKeys=new ArrayList<>();
    static List<AccessLog> accessLogs=new ArrayList<>();
    static Door door= new Door();
    static DoorLockController doorLockController=new DoorLockController(tenants,accessKeys,accessLogs,door);
    public static void main(String[] args) throws IOException {



        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu Login");
            System.out.println("1-Admin");
            System.out.println("2-Tenant");
            System.out.println("e-exit");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer){
                case '1':
                    System.out.println("Key: ");
                    String key= fluxIn.readLine();
                    if(key.equals("MasterKeyValue"))
                        adminCaseInterface();
                    else System.out.println("Wrong Key!");
                    break;
                case '2':
                    tenantCaseInterface();
                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");
    }
    //admin case
    public static void adminCaseInterface() throws IOException {
            char answer;
            String line;
            BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.println("Menu Login");
                System.out.println("1-AddTenant");
                System.out.println("2-RemoveTenant");
                System.out.println("3-ViewAccessLog");
                System.out.println("e-exit");

                line=fluxIn.readLine();
                answer=line.charAt(0);

                switch (answer){
                    case '1':
                        String name,pin;
                        System.out.println("Tenant name: ");
                        name=fluxIn.readLine();
                        System.out.println("Tenant pin: ");
                        pin=fluxIn.readLine();
                        try {
                            doorLockController.addTenant(pin,name);
                        } catch (TenantAlreadyExistsException e) {

                        }
                        break;
                    case '2':

                        System.out.println("Tenant name: ");
                        name=fluxIn.readLine();

                        try {
                            doorLockController.removeTenant(name);
                        } catch (TenantNotFoundException e) {

                        }
                        break;
                    case '3':
                        doorLockController.getAccessLogs();
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }


            }while (answer!='e' && answer!='E');
            System.out.println("Program Finish!");
        }


    public static void tenantCaseInterface() throws IOException {
        char answer;
        String line;
        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu Login");
            System.out.println("1-EnterPin");
            System.out.println("e-exit");

            line=fluxIn.readLine();
            answer=line.charAt(0);

            if (answer == '1') {
                String pin;
                System.out.println("Pin : ");
                pin = fluxIn.readLine();

                try {
                    doorLockController.enterPin(pin);
                } catch (InvalidPinException e) {

                } catch (TooManyAttemptsException e) {
                }
            } else {
                System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");
    }
}
