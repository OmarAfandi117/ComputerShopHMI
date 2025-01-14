package utilities;

import main.Shop;
import products.Desktop;
import products.Laptop;

public class ShopServices {
    Shop shop;

    public ShopServices(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void addLaptop(Laptop laptop){
        this.shop.getLaptops().add(laptop);
    }

    public void addDesktop(Desktop desktop){
        this.shop.getDesktops().add(desktop);
    }

    public void removeLaptop(Laptop laptop){
        this.shop.getLaptops().remove(laptop);
    }

    public void removeDesktop(Desktop desktop){
        this.shop.getDesktops().remove(desktop);
    }

    public void clearLaptops(){
        System.out.println(shop.getLaptops().size() + " laptops has been cleared from list");
        this.shop.getLaptops().clear();
    }

    public void clearDesktops(){
        System.out.println(shop.getDesktops().size() + " desktops has been cleared from list");
        this.shop.getDesktops().clear();
    }

    public String getLaptopByModel(String model){
        String a = null;
        for (Laptop laptop : this.shop.getLaptops()){
            if (laptop.getModel().toUpperCase().equals(model.toUpperCase())){
                a = laptop.getData();
                break;
            }
        }
        return a;
    }

    public String getDesktopByModel(String model){
        String a = null;
        for (Desktop desktop : this.shop.getDesktops()){
            if (desktop.getModel().toUpperCase().equals(model.toUpperCase())){
                a = desktop.getData();
                break;
            }
        }
        return a;
    }


}
