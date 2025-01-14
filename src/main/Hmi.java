package main;

import products.Computer;
import products.Desktop;
import products.Laptop;
import utilities.Actions;
import utilities.ShopServices;
import java.util.Scanner;

public class Hmi {
    private static ShopServices shopServices;
    static Shop shop;

    public static void start(){
        Scanner reader = new Scanner(System.in);
        shop = Hmi.createShop();

        String command;

        System.out.println("Welcome to "+shop.getName()+" shop in "+shop.getAddress());

        do {
            System.out.println("What you want to do?");
            command = reader.nextLine();

            switch (command){
                case "addLaptop", "addlaptop", "add laptop":
                    Hmi.addLaptop();
                    break;
                case "addDesktop", "adddesktop", "add desktop":
                    Hmi.addDesktop();
                    break;
                case "getLaptop", "getlaptop", "get laptop", "getLaptops", "getlaptops", "get laptops":
                    Hmi.printAllLaptop();
                    break;
                case "getDesktop", "getdesktop", "get desktop", "getDesktops", "getdesktops", "get desktops":
                    Hmi.printAllDesktop();
                    break;
                case "removeLaptop", "removelaptop", "remove laptop":
                    Hmi.removeLaptop();
                    break;
                case "removeDesktop", "removedesktop", "remove desktop":
                    Hmi.removeDesktop();
                    break;
                case "find laptop":
                    Hmi.findComputerByModel(Actions.LAPTOP);
                    break;
                case "find desktop":
                    Hmi.findComputerByModel(Actions.DESKTOP);
                    break;
                case "addStockLaptop", "addstocklaptop", "add stock laptop", "addStocksLaptop", "addstockslaptop", "add stocks laptop", "addLaptopStock", "addlaptopstock", "add laptop stock", "addLaptopStocks", "addlaptopstocks", "add laptop stocks":
                    Hmi.addLaptopStocks();
                    break;
                case "addStockDesktop", "addstockdesktop", "add stock desktop", "addStocksDesktop", "addstocksdesktop", "add stocks desktop", "addDesktopStock", "adddesktopstock", "add desktop stock", "addDesktopStocks", "adddesktopstocks", "add desktop stocks":
                    Hmi.addDesktopStocks();
                    break;
                case "stocksLaptops", "stockslaptops", "stocks laptops", "laptopsStocks", "laptopsstocks", "laptops stocks", "LaptopStocks", "laptopstocks", "laptop stocks":
                    Hmi.printAllLaptopStocks();
                    break;
                case "stocksDesktops", "stocksdesktops", "stocks desktops", "desktopsStocks", "desktopsstocks", "desktops stocks", "DesktopStocks", "desktopstocks", "desktop stocks":
                    Hmi.printAllDesktopStocks();
                    break;
                case "sellLaptop", "selllaptop", "sell laptop", "Laptopsell", "laptopsell", "laptop sell", "sellLaptops", "selllaptops", "sell laptops":
                    Hmi.removeLaptopStocks();
                    break;
                case "sellDesktop", "selldesktop", "sell desktop", "Desktopsell", "desktopsell", "desktop sell", "sellDesktops", "selldesktops", "sell desktops":
                    Hmi.removeDesktopStocks();
                    break;
                case "editLaptop", "editlaptop", "edit laptop":
                    Hmi.editDataComputer();
                    break;
                case "editDesktop", "editdesktop", "edit desktop":
                    Hmi.editDataComputer();
                    break;
                case "clearLaptops", "clearlaptops", "clear laptops":
                    shopServices.clearLaptops();
                    break;
                case "clearDesktops", "cleardesktops", "clear desktops":
                    shopServices.clearDesktops();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Error 404 : command not found \n");
                    break;
            }

        }while(!command.equals("exit"));
    }

    private static Shop createShop(){
        Shop shop = new Shop();
        shop.setName("Myshop");
        shop.setAddress("USA");
        shop.setPhoneNumber(05050505050);
        Hmi.shopServices = new ShopServices(shop);
        return shop;
    }

    public static void addLaptop(){
        Laptop laptop = new Laptop();
        Hmi.setDataComputer(laptop);
        Hmi.shopServices.addLaptop(laptop);
    }

    public static void addDesktop(){
        Desktop desktop = new Desktop();
        Hmi.setDataComputer(desktop);
        Hmi.shopServices.addDesktop(desktop);
    }

    public static void removeLaptop() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter laptop model only : ");
        String model = reader.nextLine();

        for (Laptop laptop : shop.getLaptops()){
            if (laptop.getModel().toUpperCase().equals(model.toUpperCase())){
                shopServices.removeLaptop(laptop);
                System.out.println("Laptop "+model+" removed successfully \n");
                break;
            }
        }
    }

    public static void removeDesktop() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter desktop model only : ");
        String model = reader.nextLine();

        for (Desktop desktop : shop.getDesktops()){
            if (desktop.getModel().toUpperCase().equals(model.toUpperCase())){
                shopServices.removeDesktop(desktop);
                System.out.println("Desktop "+model+" removed successfully \n");
                break;
            }
        }
    }

    public static void printAllLaptop(){
        for (Laptop laptop : Hmi.shopServices.getShop().getLaptops()){
            System.out.println(laptop.getData() +" : stocks "+ laptop.getStock());
        }
        System.out.println("\n");
    }

    public static void printAllDesktop(){
        for (Desktop desktop : Hmi.shopServices.getShop().getDesktops()){
            System.out.println(desktop.getData() +" : stocks "+ desktop.getStock());
        }
        System.out.println("\n");
    }

    public static void setDataComputer(Computer computer){
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter brand : ");
        computer.setBrand(reader.nextLine());
        System.out.print("Enter model : ");
        computer.setModel(reader.nextLine());
        System.out.print("Enter CPU : ");
        computer.setCpu(reader.nextLine());
        System.out.print("Enter GPU : ");
        computer.setGpu(reader.nextLine());
        System.out.print("Enter RAM capacity (GB) : ");
        computer.setRam(reader.nextInt());
        System.out.print("Enter storage capacity (GB) : ");
        computer.setStorage(reader.nextInt());
        System.out.print("Enter price (AED) : ");
        computer.setPrice(reader.nextInt());
        reader.nextLine();

        if (computer instanceof Laptop){
            System.out.print("Enter screen resolution : ");
            ((Laptop) computer).setScreenResolution(reader.nextLine());
            System.out.print("Enter battery capacity (Wh) : ");
            ((Laptop) computer).setBattery(reader.nextInt());
            reader.nextLine();
            System.out.print("Enter how many laptop stocks : ");
            ((Laptop) computer).setStock(reader.nextInt());
            reader.nextLine();
            System.out.println("Laptop "+computer.getBrand()+" "+computer.getModel()+" has added successfully \n");
        }
        if (computer instanceof Desktop){
            System.out.print("Enter case name : ");
            ((Desktop) computer).setCasebox(reader.nextLine());
            System.out.print("Enter power supply (w) : ");
            ((Desktop) computer).setPsu(reader.nextInt());
            reader.nextLine();
            System.out.print("Enter how many desktop stocks : ");
            ((Desktop) computer).setStock(reader.nextInt());
            System.out.println("Desktop "+computer.getBrand()+" "+computer.getModel()+" has added successfully \n");
        }
    }

    public static void findComputerByModel(Actions action){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter device model : ");
        String model = reader.nextLine();
        String c;

        if (action == Actions.LAPTOP){
            System.out.println(c = Hmi.shopServices.getLaptopByModel(model) + "\n");
        }else {
            System.out.println(c = String.valueOf(Hmi.shopServices.getDesktopByModel(model)));
        }
    }

    public static void addLaptopStocks(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter laptop model : ");
        String model = reader.nextLine();
        System.out.print("Stock amount : ");
        int amount = reader.nextInt();

        for (Laptop laptop : shop.getLaptops()){
            if (laptop.getModel().toUpperCase().equals(model.toUpperCase())){
                laptop.addStock(amount);
                System.out.println(amount+" stocks has been added to "+laptop.getBrand()+" "+laptop.getModel()+" laptop");
                break;
            }
        }
    }

    public static void addDesktopStocks(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter desktop model : ");
        String model = reader.nextLine();
        System.out.print("Stock amount : ");
        int amount = reader.nextInt();

        for (Desktop desktop : shop.getDesktops()){
            if (desktop.getModel().toUpperCase().equals(model.toUpperCase())){
                desktop.addStock(amount);
                System.out.println(amount+" stocks has been added to "+desktop.getBrand()+" "+desktop.getModel()+" desktop");
                break;
            }
        }
    }

    public static void removeLaptopStocks(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter laptop model : ");
        String model = reader.nextLine();
        System.out.print("Stock amount : ");
        int amount = reader.nextInt();

        for (Laptop laptop : shop.getLaptops()){
            if (laptop.getModel().toUpperCase().equals(model.toUpperCase())){
                laptop.removeStock(amount);
                System.out.println(amount+" stocks has been sold for "+laptop.getBrand()+" "+laptop.getModel()+" laptop");
                break;
            }
        }
    }

    public static void removeDesktopStocks(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter Desktop model : ");
        String model = reader.nextLine();
        System.out.print("Stock amount : ");
        int amount = reader.nextInt();

        for (Desktop desktop : shop.getDesktops()){
            if (desktop.getModel().toUpperCase().equals(model.toUpperCase())){
                desktop.removeStock(amount);
                System.out.println(amount+" stocks has been sold for "+desktop.getBrand()+" "+desktop.getModel()+" desktop");
                break;
            }
        }
    }

    public static void printAllLaptopStocks(){
        for (Laptop laptop : Hmi.shopServices.getShop().getLaptops()){
            System.out.println(laptop.getBrand()+" "+laptop.getModel()+" : stocks "+laptop.getStock());
        }
        System.out.println("\n");
    }

    public static void printAllDesktopStocks(){
        for (Desktop desktop : Hmi.shopServices.getShop().getDesktops()){
            System.out.println(desktop.getBrand()+" "+desktop.getModel()+" : stocks "+desktop.getStock());
        }
        System.out.println("\n");
    }

    public static void editDataComputer(){
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter current computer model : ");
        String cmodel = reader.nextLine();

        for (Laptop laptop : shop.getLaptops()){
            if (laptop.getModel().toUpperCase().equals(cmodel.toUpperCase())){
                System.out.print("Enter brand : ");
                laptop.setBrand(reader.nextLine());
                System.out.print("Enter model : ");
                laptop.setModel(reader.nextLine());
                System.out.print("Enter CPU : ");
                laptop.setCpu(reader.nextLine());
                System.out.print("Enter GPU : ");
                laptop.setGpu(reader.nextLine());
                System.out.print("Enter RAM capacity (GB) : ");
                laptop.setRam(reader.nextInt());
                System.out.print("Enter storage capacity (GB) : ");
                laptop.setStorage(reader.nextInt());
                System.out.print("Enter price (AED) : ");
                laptop.setPrice(reader.nextInt());
                reader.nextLine();
                System.out.print("Enter screen resolution : ");
                laptop.setScreenResolution(reader.nextLine());
                System.out.print("Enter battery capacity (Wh) : ");
                laptop.setBattery(reader.nextInt());
                reader.nextLine();
                System.out.println("Laptop "+cmodel+" has been modified successfully \n");
                break;
            }
        }
        for (Desktop desktop : shop.getDesktops()){
            if (desktop.getModel().toUpperCase().equals(cmodel.toUpperCase())){
                System.out.print("Enter brand : ");
                desktop.setBrand(reader.nextLine());
                System.out.print("Enter model : ");
                desktop.setModel(reader.nextLine());
                System.out.print("Enter CPU : ");
                desktop.setCpu(reader.nextLine());
                System.out.print("Enter GPU : ");
                desktop.setGpu(reader.nextLine());
                System.out.print("Enter RAM capacity (GB) : ");
                desktop.setRam(reader.nextInt());
                System.out.print("Enter storage capacity (GB) : ");
                desktop.setStorage(reader.nextInt());
                System.out.print("Enter price (AED) : ");
                desktop.setPrice(reader.nextInt());
                reader.nextLine();
                System.out.print("Enter case name : ");
                desktop.setCasebox(reader.nextLine());
                System.out.print("Enter power supply (w) : ");
                desktop.setPsu(reader.nextInt());
                reader.nextLine();
                System.out.println("Desktop "+cmodel+" has been modified successfully \n");
                break;
            }
        }

    }

}
