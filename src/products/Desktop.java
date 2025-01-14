package products;

public class Desktop extends Computer{
    String casebox;
    int psu;

    public Desktop(String brand, String model, String cpu, String gpu, int ram, int storage, int price, String casebox, int psu, int stock) {
        super(brand, model, cpu, gpu, ram, storage, price, stock);
        this.casebox = casebox;
        this.psu = psu;
    }

    public Desktop(String casebox, int psu) {
        this.casebox = casebox;
        this.psu = psu;
    }

    public Desktop() {
    }

    @Override
    public String getData() {
        return getBrand() + " " + getModel() + " " + getCpu() + " " + getGpu() + " " + getRam() + "GB " + getStorage() + "GB " + getCasebox() + " " + getPsu() + "w "  + getPrice() + "AED";
    }

    public String getCasebox() {
        return casebox;
    }

    public void setCasebox(String casebox) {
        this.casebox = casebox;
    }

    public int getPsu() {
        return psu;
    }

    public void setPsu(int psu) {
        this.psu = psu;
    }
}
