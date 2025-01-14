package products;

public abstract class Computer {
    String brand, model, cpu, gpu;
    int ram, storage, price;
    int stock;

    public Computer(String brand, String model, String cpu, String gpu, int ram, int storage, int price, int stock) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
        this.stock = stock;
    }

    public Computer() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int amount){
        this.stock = this.stock + amount;
    }

    public void removeStock(int amount){
        this.stock = this.stock - amount;
    }

    public abstract String getData();
}
