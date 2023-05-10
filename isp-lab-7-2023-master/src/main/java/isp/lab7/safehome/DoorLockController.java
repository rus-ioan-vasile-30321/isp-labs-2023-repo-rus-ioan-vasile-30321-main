package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DoorLockController implements ControllerInterface{

    private static int attempts =0;
    private final Set<Tenant> tenant;
    private final List<AccessKey> accessKey;
    private final List<AccessLog> accessLog;
    private final Door door;
    private final Map<Tenant,AccessKey> validAccess=new HashMap<>();

    public DoorLockController(Set<Tenant> tenant, List<AccessKey> accessKey, List<AccessLog> accessLog, Door door) {
        this.tenant = tenant;
        this.accessKey = accessKey;
        this.accessLog = accessLog;
        this.door = door;
    }

    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        // cautare persoane cu acest pin
        StringBuilder name= new StringBuilder();

        for(Map.Entry<Tenant, AccessKey> i:validAccess.entrySet())
            if(i.getValue().getPin().equals(pin)){
                name.append(i.getKey().getName());
            }

        if(validAccess.containsValue(new AccessKey(pin)) && attempts <3){
            if(door.getDoorStatus()==DoorStatus.OPEN)door.lookDoor();
            else door.unlockDoor();
            //punem date in log
            AccessLog accessLog1=new AccessLog(name.toString(), LocalDateTime.now(),"EnterPin",door.getDoorStatus(),"");
            accessLog.add(accessLog1);
        }
        else{
            attempts++;
            if(pin.equals(MASTER_KEY)){
                attempts =0;
                if(door.getDoorStatus()==DoorStatus.OPEN)door.lookDoor();
                else door.unlockDoor();
                AccessLog accessLog1 = new AccessLog("Admin", LocalDateTime.now(), "EnterPin", door.getDoorStatus(), "");
                accessLog.add(accessLog1);
                return door.getDoorStatus();
            }
            if(attempts >=3){
                AccessLog accessLog1 = new AccessLog("RandomPerson", LocalDateTime.now(), "EnterPin", door.getDoorStatus(), "Too many attempts!");
                accessLog.add(accessLog1);
                throw new TooManyAttemptsException();
            }
            AccessLog accessLog1 = new AccessLog("RandomPerson", LocalDateTime.now(), "EnterPin", door.getDoorStatus(), "Invalid Pin!");
            accessLog.add(accessLog1);
            throw new InvalidPinException();
        }
        return door.getDoorStatus();
    }
    public void addTenant(String pin,String tenantName)throws TenantAlreadyExistsException{

        Tenant get=new Tenant(tenantName);
        if(!this.tenant.contains(get))
        {
            tenant.add(get);
            validAccess.put(get,new AccessKey(pin));
            AccessLog accessLog1=new AccessLog(get.getName(), LocalDateTime.now(),"AddTenant",door.getDoorStatus(),"");
            accessLog.add(accessLog1);
        }
        else{
            AccessLog accessLog1=new AccessLog(get.getName(), LocalDateTime.now(),"AddTenant",door.getDoorStatus(),"Exista deja aces Tenant!");
            accessLog.add(accessLog1);
            throw new TenantAlreadyExistsException();
        }
    }
    public void removeTenant(String name)throws TenantNotFoundException{
        Tenant got=new Tenant(name);
        if(this.tenant.contains(got)){
            AccessLog accessLog1=new AccessLog(got.getName(), LocalDateTime.now(),"RemoveTenant",door.getDoorStatus(),"");
            accessLog.add(accessLog1);
            tenant.remove(got);
            validAccess.remove(got);
        }
        else {
            AccessLog accessLog1=new AccessLog(got.getName(), LocalDateTime.now(),"RemoveTenant",door.getDoorStatus(),"Tenant not found!");
            accessLog.add(accessLog1);
            throw new TenantNotFoundException();
        }
    }
    public List<AccessLog> getAccessLogs(){
        for(AccessLog i:accessLog)
            System.out.println(i.toString());

        return accessLog;
    }


}
