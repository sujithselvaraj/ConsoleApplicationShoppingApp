package bootathon;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Merchant> merchantList = new ArrayList<>();

    static ArrayList<Product> prodList = new ArrayList<>();


    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        int n = 0;
        do {
            System.out.println("-----Welcome To Application-----");
            System.out.println("Enter 1 for Merchant Login");
            System.out.println("Enter 2 for Admin Login");
            System.out.println("Enter 3 for Customer Login");
            System.out.println("Enter 4 to Exit");
            n = Integer.parseInt(sc.nextLine());
            if (n == 1) {
                Merchant.login();
            } else if (n == 2) {
                Admin.login();
            } else if (n == 3) {
                User.login();

            } else if (n == 4) {
                System.exit(404);
            }
        } while (n != 4);
    }
}
