package isp.lab7.safehome;

public class Door {
    private DoorStatus doorStatus;

    public Door(){
        this.doorStatus=DoorStatus.CLOSE;
    }
    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    void lookDoor(){
        this.doorStatus=DoorStatus.CLOSE;
    }
    void unlockDoor(){
        this.doorStatus=DoorStatus.OPEN;
    }
}
