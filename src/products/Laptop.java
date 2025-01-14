package products;

public class Laptop extends Computer{
    String ScreenResolution;
    int battery;

    public Laptop(String brand, String model, String cpu, String gpu, int ram, int storage, int price, String screenResolution, int battery, int stock) {
        super(brand, model, cpu, gpu, ram, storage, price, stock);
        ScreenResolution = screenResolution;
        this.battery = battery;
    }

    public Laptop(String screenResolution, int battery) {
        ScreenResolution = screenResolution;
        this.battery = battery;
    }

    public Laptop() {
    }

    @Override
    public String getData() {
        return getBrand() + " " + getModel() + " " + getCpu() + " " + getGpu() + " " + getRam() + "GB " + getStorage() + "GB " + getScreenResolution() + " " + getBattery() + "mah " + getPrice() + "AED";
    }

    public String getScreenResolution() {
        return ScreenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        ScreenResolution = screenResolution;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }


}
