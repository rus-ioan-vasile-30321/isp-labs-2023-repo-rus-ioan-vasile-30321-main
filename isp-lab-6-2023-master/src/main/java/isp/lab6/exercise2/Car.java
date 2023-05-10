package isp.lab6.exercise2;

import java.util.Date;

public class Car {
    private String VIN;
    private String license_plate;
    private String make;
    private String model;
    private String year;


    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", license_plate='" + license_plate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getVIN() {
        return VIN;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            Car p = (Car) obj;
            return p.VIN.equalsIgnoreCase(this.VIN);
            // ma gandeam sa adaug || p.license_plate.equals(this.license_plate) in caz
            //in care exista si aceeasi license plate
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int result=10;
        if(this.VIN!=null) {
            result= Integer.parseInt(this.VIN);
            //cum sa fac hash code ca sa respecte legea din comentariu
            // cu license plate
        }
        return result;
    }
}
