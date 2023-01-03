package bootathon;

import java.util.ArrayList;

public class User {
    String email;
    String pass;
    Integer wallet=50000;
    ArrayList<Product> cart = new ArrayList<>();
    ArrayList<Product> yourOrders = new ArrayList<>();
    ArrayList<Product> returns = new ArrayList<>();

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public static void login(){

        System.out.println("Enter 1 for Sign Up");
        System.out.println("Enter 2 for Log in");
        System.out.println("Enter 3 to Exit");

        int n = Integer.parseInt(Main.sc.nextLine());

        if(n==1){
            userSignUp();
        }
        
        else if(n==2){
            userLogin();
        }

        else if(n==3){
            return;
        }

        else{
            System.out.println("Incorrect choice !");
            login();
        }

    }
    
    public static void userSignUp(){
        System.out.print("Enter Email ID : ");
        String email=Main.sc.nextLine();
        System.out.print("Enter Password : ");
        String password = Main.sc.nextLine();

        Main.users.add(new User(email, password));

        System.out.println("Account has been Created Successfully\n\nLogin to continue");

        login();

    }

    public static void userLogin(){
        System.out.print("Enter Email ID : ");
        String email=Main.sc.nextLine();
    
        int current = -1;
        for (int i = 0; i < Main.users.size(); i++) {
            if (Main.users.get(i).email.equals(email)) {
                current = i;
                break;
            }
        }
        if (current == -1) {
            System.out.println("User name not found");
            login();
        }
        System.out.print("Enter Password : ");
        String password = Main.sc.nextLine();

        if(Main.users.get(current).pass.equals(password)){
            userPage(current);
        }
        else{
            System.out.println("Wrong Password");
            System.out.println("Press Enter to Try again");
            Main.sc.nextLine();
            userLogin();
        }
    } 

    public static void userPage(int current){
        System.out.println("Press 1 for Search / Buy Product");
        System.out.println("Press 2 to view Cart");
        System.out.println("Press 3 to view Ordered Products");
        System.out.println("Press 4 to view Returned Products");
        System.out.println("Press 6 to view Wallet Amount");
        System.out.println("Press 6 to Logout");
        int n=Integer.parseInt(Main.sc.nextLine());
        if(n==1){
            search(current);
        }
        else if(n==2){
            viewCart(current);
        }
        else if(n==3){
            orderList(current);
        }
        else if(n==4){
            returnList(current);
        }
        else if(n==5){
            viewWalletAmount(current);
        }
        else if(n==6){
            return;
        }
        else{
            System.out.println("Invalid Input \n Enter Correct Input");
            userPage(current);
        }
    }

    private static void returnList(int current) {
        System.out.println("No item has been returned Till now");
        userPage(current);
    }

    private static void orderList(int current) {

        for(int i=0;i<Main.users.get(current).yourOrders.size();i++,System.out.println()){
            System.out.printf("Product No. %s :- \n",(i+1));
            System.out.println(Main.users.get(current).yourOrders.get(i).productName);
            System.out.println(Main.users.get(current).yourOrders.get(i).price);
        }
        userPage(current);
        

    }

    private static void viewCart(int current) {
        for(int i=0;i<Main.users.get(current).cart.size();i++,System.out.println()){
            System.out.printf("Product No. %s :- \n",(i+1));
            System.out.println(Main.users.get(current).cart.get(i).productName);
            System.out.println(Main.users.get(current).cart.get(i).price);
        }
        userPage(current);
    }

    static void viewWalletAmount(int current) {

        System.out.println("Your Wallet Amount : "+Main.users.get(current).wallet);
        System.out.println("Enter any key to Redirect to user Page");
        Main.sc.nextLine();
        userPage(current);
    }

    public static void search(int current){
        System.out.print("Enter product Name to Search : ");
        ArrayList<Product> tp=new ArrayList<>();
        String search = Main.sc.nextLine();
        for(int i=0;i<Main.prodList.size();i++){
            if(Main.prodList.get(i).productName.contains(search)){
                tp.add(Main.prodList.get(i));
            }
        }
        display(tp,current);
    }

    public static void display(ArrayList<Product> tp,int current){

        for(int i=0;i<tp.size();i++){
                System.out.printf("Product %s :-\n\n",(i+1));
                System.out.println("Product Name :- "+tp.get(i).productName);
                System.out.println("Seller Name :- "+tp.get(i).sellername);
                System.out.println("Price :- "+tp.get(i).price);
                System.out.println("Warrenty Period :- "+tp.get(i).WarrentyPeriod+" years");
                System.out.println("Return Period :- "+tp.get(i).returnPeriod+" days");
                System.out.println("Rating of Product :- "+tp.get(i).productRating);
                System.out.println("Product Description :- "+tp.get(i).ProductReview);
        }

        System.out.println("Enter 1 to buy/Add to Cart");
        System.out.println("Enter 0 to Exit");
        int n=Integer.parseInt(Main.sc.nextLine());
        if(n==1){
            buyOrAdd(tp,current);
        }
        else if(n==0){
            userPage(current);
        }
        else{
            System.out.println("Invalid Input");
            display(tp,current);
        }

    }

    public static void buyOrAdd(ArrayList<Product> tp,int current){
        System.out.println("Select the product No.");
        int n=Integer.parseInt(Main.sc.nextLine());
        --n;
        n=Main.prodList.indexOf(tp.get(n));
        System.out.println("Press 1 to buy prouct");
        System.out.println("Press 2 to add to cart");
        System.out.println("Enter 3 to choose a different product");
        System.out.println("Press 4 to Exit");
        int a = Integer.parseInt(Main.sc.nextLine());
        if(a==1){
            Product.buyProduct(n,current);
            System.out.println("Press Enter to continue");
            Main.sc.nextLine();
            userPage(current);
        }
        else if(a==2){
            Product.addToCart(n, current);
            System.out.println("Press Enter to continue");
            Main.sc.nextLine();
            userPage(current);
        }
        else if(a==3){
            display(tp,current);
        }
        else if(a==4){
            userPage(current);
        }
        else{
            System.out.println("Invalid Choice");
            buyOrAdd(tp,current);
        }
    }
}