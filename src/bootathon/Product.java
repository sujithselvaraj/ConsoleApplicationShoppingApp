package bootathon;

import java.util.ArrayList;

public class Product {
    String productName;
    Integer quantity;
    String sellername;
    String ProductReview;
    Integer productRating;
    Integer price;
    Integer WarrentyPeriod;
    Integer returnPeriod;

    public Product(String productName, Integer quantity, String productReview,
            Integer productRating, Integer price, Integer warrentyPeriod, Integer returnPeriod, String sellername) {
        this.productName = productName;
        this.quantity = quantity;
        this.ProductReview = productReview;
        this.productRating = productRating;
        this.price = price;
        WarrentyPeriod = warrentyPeriod;
        this.returnPeriod = returnPeriod;
        this.sellername = sellername;
    }

    public static void addProduct(Merchant merchant) {
        int i = 1;
        while (i != 0) {
            System.out.print("Enter Product Name : ");
            String productName = Main.sc.nextLine();
            System.out.print("Enter Quantity :");
            Integer quantity = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Product Description :");
            String productReview = Main.sc.nextLine();
            System.out.print("Enter Prouct Rating : ");
            Integer productRating = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Price : ");
            Integer price = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Warrenty Period : ");
            Integer warrentyPeriod = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Return Period :");
            Integer returnPeriod = Integer.parseInt(Main.sc.nextLine());
            Main.prodList.add(new Product(productName, quantity, productReview, productRating, price, warrentyPeriod,
                    returnPeriod, merchant.username));
            System.out.print("Do you want to add one more product \n\n press 1 if yes else 0");
            i = Integer.parseInt(Main.sc.nextLine());
        }
        Merchant.merchantChoice(merchant);
    }

    public static void viewProductDetails(Merchant merchant) {

        ArrayList<Product> tp = new ArrayList<>();

        for (int i = 0; i < Main.prodList.size(); i++) {
            if (Main.prodList.get(i).sellername.equals(merchant.username)) {
                tp.add(Main.prodList.get(i));
            }
        }

        if (tp.isEmpty()) {
            System.out.println("You Don't have any product Selling on Amazon\n\nPress enter to continue");
            Main.sc.nextLine();
        }

        else {
            System.out.println("-----Your Products-----");
            for (int i = 0; i < tp.size(); i++, System.out.println()) {
                System.out.println("Product name : " + tp.get(i).productName);
                System.out.println("Quantity Available : " + tp.get(i).quantity);
                System.out.println("Product Rating : " + tp.get(i).productRating);
                System.out.println("Product Price: " + tp.get(i).price);
                System.out.println("Product Warrenty Period : " + tp.get(i).WarrentyPeriod);
                System.out.println("Product Product Return period : " + tp.get(i).returnPeriod);
                System.out.print("Press 1 to Edit the above Product or 0 to continue");
                int choice = Integer.parseInt(Main.sc.nextLine());
                if (choice == 1) {
                    editProductDetails(i, merchant);
                } else {
                    continue;
                }
            }
        }

        Merchant.merchantChoice(merchant);
    }

    public static void editProductDetails(int i, Merchant m) {
        System.out.println("Press 1 to Edit Price");
        System.out.println("Press 2 to Edit Quantity");
        System.out.println("Press 3 to Edit Description");
        System.out.println("Press 4 to Edit Warrenty");
        System.out.println("Press 5 to Edit return period");
        System.out.println("Press 6 to exit");
        int a = Integer.parseInt(Main.sc.nextLine());
        if (a == 1) {
            editPrice(i, m);
        } else if (a == 2) {
            editQuantity(i, m);
        } else if (a == 3) {
            editDescription(i, m);
        } else if (a == 4) {
            editWarrenty(i, m);
        } else if (a == 5) {
            editReturnPeriod(i, m);
        } else if (a == 6) {
            Merchant.merchantChoice(m);
        } else {
            System.out.println("Incorrect Option\n\nSelect the correct Option");
            editProductDetails(i, m);
        }
    }

    public static void editPrice(int i, Merchant m) {
        System.out.print("Enter new Price of the Product : ");
        int np = Integer.parseInt(Main.sc.nextLine());
        Main.prodList.get(i).price = np;
        System.out.println("Price Updated Successfully");
        System.out.println("Press 1 if you need to update the same product Details else 0");
        np = Integer.parseInt(Main.sc.nextLine());
        if (np == 1) {
            editProductDetails(i, m);
        } else {
            Merchant.merchantChoice(m);
        }
    }

    public static void editQuantity(int i, Merchant m) {
        System.out.print("Enter Available Quantity : ");
        int np = Integer.parseInt(Main.sc.nextLine());
        Main.prodList.get(i).quantity = np;
        System.out.println("Quantity Updated Successfully");
        System.out.println("Press 1 if you need to update the same product Details else 0");
        np = Integer.parseInt(Main.sc.nextLine());
        if (np == 1) {
            editProductDetails(i, m);
        } else {
            Merchant.merchantChoice(m);
        }
    }

    public static void editDescription(int i, Merchant m) {
        System.out.print("Enter Available Quantity : ");
        String np = Main.sc.nextLine();
        Main.prodList.get(i).ProductReview = np;
        System.out.println("Description Updated Successfully");
        System.out.println("Press 1 if you need to update the same product Details else 0");
        int ch = Integer.parseInt(Main.sc.nextLine());
        if (ch == 1) {
            editProductDetails(i, m);
        } else {
            Merchant.merchantChoice(m);
        }
    }

    public static void editWarrenty(int i, Merchant m) {
        System.out.print("Enter Available Quantity : ");
        int np = Integer.parseInt(Main.sc.nextLine());
        Main.prodList.get(i).WarrentyPeriod = np;
        System.out.println("Warrenty Updated Successfully");
        System.out.println("Press 1 if you need to update the same product Details else 0");
        int ch = Integer.parseInt(Main.sc.nextLine());
        if (ch == 1) {
            editProductDetails(i, m);
        } else {
            Merchant.merchantChoice(m);
        }
    }

    public static void editReturnPeriod(int i, Merchant m) {
        System.out.print("Enter Available Quantity : ");
        int np = Integer.parseInt(Main.sc.nextLine());
        Main.prodList.get(i).returnPeriod = np;
        System.out.println("Return period Updated Successfully");
        System.out.println("Press 1 if you need to update the same product Details else 0");
        int ch = Integer.parseInt(Main.sc.nextLine());
        if (ch == 1) {
            editProductDetails(i, m);
        } else {
            Merchant.merchantChoice(m);
        }
    }
    public static void removeAProduct(Merchant merchant){
        System.out.print("Enter name of the Product to remove or 0 to exit");
        String rem=Main.sc.nextLine();
        if(rem.equals("0"))Merchant.merchantChoice(merchant);
        boolean isRemoved = false;
        for(int i=0;i<Main.prodList.size();i++){
            if(Main.prodList.get(i).sellername.equals(merchant.username)){
                Main.prodList.remove(i);isRemoved=true;
            }
        }
        if(isRemoved){
            System.out.println("Product Successfully Removed.\npress Enter to continue");
            Main.sc.nextLine();
            Merchant.merchantChoice(merchant);
        }
        else{
            System.out.printf("No product with name %s found\n",rem);
            removeAProduct(merchant);
        }
    }

    public static void compareProduct(Merchant m){
        ArrayList<Product> same = new ArrayList<>();
        ArrayList<Product> diff = new ArrayList<>();
        System.out.println("Enter namme of Product to compare : ");
        String search = Main.sc.nextLine();
        for(int i=0;i<Main.prodList.size();i++){
            if(Main.prodList.get(i).productName.contains(search)){
                if(Main.prodList.get(i).sellername.equals(m.username)){
                    same.add(Main.prodList.get(i));
                }
                else{
                    diff.add(Main.prodList.get(i));
                }
            }
        }

        showComparedProduct(same,diff,search,m);

    }

    public static void showComparedProduct(ArrayList<Product> same,ArrayList<Product> diff,String search,Merchant m){
        
        if(same.size()<=0){
            System.out.println("No product found with name "+search);Merchant.merchantChoice(m);
        }

        System.out.println("Your product named "+search);
        System.out.println();
        System.out.printf("%-20s || %-20s || %-20s || %-20s\n","Name","Price","Rating","Return Period");

        for(int i=0;i<same.size();i++){
            System.out.printf("%-20s || %-20s || %-20s || %-20s\n",same.get(i).productName,same.get(i).price,same.get(i).productRating,same.get(i).returnPeriod);
        }

        System.out.println("Others product named "+search);
        System.out.println();

        for(int i=0;i<diff.size();i++){
            System.out.printf("%-20s || %-20s || %-20s || %-20s\n",diff.get(i).productName,diff.get(i).price,diff.get(i).productRating,diff.get(i).returnPeriod);
        }

        System.out.println("Successfully compared\n Press Enter to continue");
        Main.sc.nextLine();

        Merchant.merchantChoice(m);

    }
    public static void buyProduct(int n,int current){
        if(Main.users.get(current).wallet>=Main.prodList.get(n).price){
            if(Main.prodList.get(n).quantity>0){
            System.out.println("Product Bought successfully !");
            Main.prodList.get(n).quantity-=1;
            Main.users.get(current).yourOrders.add(Main.prodList.get(n));
            System.out.println(Main.users.get(current).yourOrders.get(Main.users.get(current).yourOrders.size()-1).productName);
            }
            else{
                System.out.println("Product Out of stock");
                User.userPage(n);
            }
        }
        else{
            System.out.println("Insufficient Wallet Amount ! \n Please add Money To purchase Product");
        }
    }

    public static void addToCart(int n,int current){
        if(Main.users.get(current).wallet>=Main.prodList.get(n).price){
            System.out.println("Product Added to Cart !");
            Main.users.get(current).cart.add(Main.prodList.get(n));
        }
        System.out.println(Main.users.get(current).cart.get(Main.users.get(current).cart.size()-1).productName);
    }
}
