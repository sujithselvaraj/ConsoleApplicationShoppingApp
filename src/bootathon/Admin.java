package bootathon;

public class Admin {
    static void login() {
        System.out.print("Enter Username : ");
        String uname = Main.sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = Main.sc.nextLine();
        if (uname.equals("admin") && pass.equals("12345")) {
            adminpage();
        }
        else{
            System.out.println("Invalid credentials !");
            System.out.println("Press Enter to continue");
            Main.sc.nextLine();
            login();
        }
    }

    static void adminpage() {
        System.out.println("Enter 1 for Approval/Rejection");
        System.out.println("Enter 2 for Add/Remove Merchant");
        int n = Integer.parseInt(Main.sc.nextLine());
        if (n == 1) {
            approval();
        } else if (n == 2) {
            addOrrem();
        }
        else{
            System.out.println("Invalid choice \n\n Enter 1 OR 2");
            adminpage();
        }
    }

    public static void approval() {
        for (int i = 0; i < Main.merchantList.size(); i++, System.out.print("\033[H\033[2J")) {
            if (Main.merchantList.get(i).status.equals("Pending")) {
                System.out.println("User : " + Main.merchantList.get(i).username);
                System.out.println("Enter 1 for Approval OR any other number for Rejection :");
                int n = Integer.parseInt(Main.sc.nextLine());
                if (n == 1) {
                    Main.merchantList.get(i).status = "Approved";
                    System.out.printf("Merchant \"%s\" has been Approved\n", Main.merchantList.get(i).username);
                    System.out.println("Press enter to continue");
                    Main.sc.nextLine();
                    continue;
                } else {
                    Main.merchantList.get(i).status = "Rejected";
                    System.out.println("User Rejected");
                    System.out.println("Press enter to continue");
                    Main.sc.nextLine();
                }
            }
        }
        System.out.println("Merchants Waiting for Approval :- 0");
        adminpage();
    }

    public static void addOrrem() {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter 1 to add a vendor");
        System.out.println("Enter 2 to remove a vendor");
        System.out.println("Enter 3 to Exit");
        int opt = Integer.parseInt(Main.sc.nextLine());
        if (opt == 1) {
            addAvendor();
        } else if (opt == 2) {
            removeAvendor();
        } else if (opt == 3) {
            return;
        } else {
            System.out.println("Incorrect Choice");
            addOrrem();
        }
    }

    public static void addAvendor() {
        System.out.print("Enter Username : ");
        String username = Main.sc.nextLine();
        System.out.print("Enter Password :  ");
        String password = Main.sc.nextLine();
        Main.merchantList.add(new Merchant(username, password, "Approved"));
        addOrrem();
    }

    public static void removeAvendor() {
        System.out.println("Enter Username of the User to be Blocked");
        String s = Main.sc.nextLine();
        for (int i = 0; i < Main.merchantList.size(); i++) {
            if (Main.merchantList.get(i).username.equals(s)) {
                Main.merchantList.get(i).status = "Deactivated\nContact Admin";
            }
        }
        addOrrem();
    }

}
