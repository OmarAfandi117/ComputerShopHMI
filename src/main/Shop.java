package main;

import products.Desktop;
import products.Laptop;

import java.util.ArrayList;

public class Shop {
    String name, address;
    int phoneNumber;

    ArrayList<Laptop> laptops;
    ArrayList<Desktop> desktops;

    public Shop(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        initObject();
    }

    public Shop() {
        initObject();
    }

    private void initObject(){
        this.laptops = new ArrayList<Laptop>();
        this.desktops = new ArrayList<Desktop>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public ArrayList<Desktop> getDesktops() {
        return desktops;
    }
}
