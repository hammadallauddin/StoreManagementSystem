import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
class Product implements ProductInterface {
    private String name;
    private int price, quantity;
    public static ArrayList<Product> prodF = new ArrayList<>();
    
    public Product() {
        name = "";
        price = 0;
        quantity = 0;
    }
    
    public Product(String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
    }
    
    public void SetProduct(String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public int upQuantity(int q) {
        quantity -= q;
        return quantity;
    }
    
    public static void UploadProd() {
        ReadFile rf = new ReadFile();
        rf.openFile();
        rf.manipulateFile(prodF);
        rf.closeFile();
    }
    
    public static void AddProd() throws IOException, InterruptedException {
        String name,error="";
        int price,quantity;
        char ch;
        Scanner sc = new Scanner(System.in);
        WriteFile wf = new WriteFile();
        Product prod = new Product();
        wf.openFile();
        
        do {
      	System.out.println("Enter Product name");
            try {
                name = sc.next();
            }
            catch(Exception e) {
                System.out.println("Enter Valid value");
                name="";
                error = "Error";
            }
            System.out.println("Enter Product Price");
            try {
                price = sc.nextInt();
            }
            catch(Exception e) {
                System.out.println("Enter Valid value");
                price = 0;
                error = "Error";
            }
            System.out.println("Enter Product Quantity");
            try {
                quantity = sc.nextInt();
            }
             catch(Exception e) {
                System.out.println("Enter Valid value");
                quantity = 0;
                error = "Error";
            }
            if(error.equals("Error")) {
                System.out.println("Error");
            }
            else {
                prod.SetProduct(name,price,quantity);
                wf.manipulateFile(prod);
            }
            System.out.println("Add More? (y or n)");
            ch = sc.next().charAt(0);
        }
        while(ch == 'y' || ch=='Y');
        wf.closeFile();
        prodF.clear();
        Product.UploadProd();
    }
      public static void ViewProd() {
        Scanner s = new Scanner(System.in);
        char temp;
        System.out.println("Product Name\tPrice\t\tQuantity");
        for(int i = 0; i<prodF.size(); i++)
            System.out.printf("%-12s\t%5d\t\t%5d\n",prodF.get(i).name ,prodF.get(i).price,prodF.get(i).quantity);
        	System.out.println("Press 0 to Return to Previous Screen");
        do {
            temp = s.next().charAt(0);
        }
        while(temp!='0');
        }
      	public static int SeaProd() {
        Scanner s = new Scanner(System.in);
        String temp;
        char ch;
        int i, j=-1;
        boolean flag = false;
        System.out.println("Enter Product Name: ");
        temp = s.next();
        
        for(i = 0; i<prodF.size(); i++) {
            if(temp.equalsIgnoreCase(prodF.get(i).name)) {
                flag = true;
                j = i;
                break;
            }
        }
        if(i==prodF.size() && flag==false) {
            System.out.println("Invalid Product Name");
            System.out.println("ENTER \n1- SEARCH AGAIN\n2- BACK TO PREVIOUS SCREEN");   
            do {
                ch = s.next().charAt(0);
                switch(ch) {
                    case '1':
                        j = SeaProd();
                        return j;
                    
                    case '2':
                        return -1;
                    default:
                        System.out.println("Choose a Valid Option");
                        break;
                }
            }
            while(ch!='3' || ch!='1');
        }
        return j;
    }
    public static void UpProd() {
        WriteFile ww = new WriteFile();
        Scanner s = new Scanner(System.in);
        char ch;
        int i = SeaProd();
        if(i!=-1) {
            System.out.println("Product Name\tPrice\t\tQuantity");
            System.out.printf("%-12s\t%5d\t\t%5d\n",prodF.get(i).name,prodF.get(i).price,prodF.get(i).quantity);
            System.out.println("ENTER \n1- UPDATE NAME\n2- UPDATE PRICE\n3- UPDATE QUANTITY");  
            while(true) {
                ch = s.next().charAt(0);
                if(ch<49 || ch>52)
                        System.out.println("Enter a Valid Option");
                else
                    break;
            }
            switch(ch) {
                case '1':
                    System.out.println("Enter New Name");
                    prodF.get(i).name = s.nextLine();
                    break;
                    
                case '2':
                    System.out.println("Enter New Price");
                    try {
                        prodF.get(i).price = s.nextInt();
                    }
                    catch(Exception e) {
                        System.out.println("Enter valid value");
                    }
                    break;
                        
                case '3':
                    System.out.println("Enter Added Quantity");
                    try {
                        prodF.get(i).quantity += s.nextInt();
                    }
                    catch(Exception e) {
                        System.out.println("Enter vsalid value");
                    }
                    break;
            }
        }
        
        ww.manipulateFile(prodF);
    }
    
    public static void DelProd() {
        WriteFile w = new WriteFile();
        
        int i = SeaProd();
        
        if(i!=-1) {
            prodF.remove(i);
            w.manipulateFile(prodF);
        }
    }
}
