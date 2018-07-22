import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Bill {
	Date date;
	ArrayList<Product> prodB = new ArrayList<>();
    int total = 0;
    char temp = 'r';
    
    public Bill() throws IOException, InterruptedException {
        int i=0, q, p, e;
        char ch;
        date = new Date();
        Scanner s = new Scanner(System.in);
        WriteFile w = new WriteFile();
        do {
        	i = Product.SeaProd();
            if(i!=0) {
                System.out.println("Enter Quantity");
                q = s.nextInt();
                p = Product.prodF.get(i).getPrice();
                e = Product.prodF.get(i).upQuantity(q);
                if(e>10) {
                    prodB.add(new Product(Product.prodF.get(i).getName(), p, q));
                }
                else if(e<=10&&e>0) {
                    System.out.printf("\n%d pieces are left.",e);
                    prodB.add(new Product(Product.prodF.get(i).getName(), p, q));
                }   
                else if(e<1) {
                    System.out.println("Product ended.");
                }
                System.out.println("Add Another Product?\nPress Y for Yes or N for No");
                while(true) {
                    ch = s.next().charAt(0);
                    if( ch=='Y' || ch=='y' || ch=='N' || ch=='n')
                        break;
                    else
                        System.out.println("\nChoose a Valid Option");
                }
                if(ch=='N' || ch=='n')
                    break;
            }
            else
                break;
        }
        while(true);
        System.out.println(date.toGMTString());
        System.out.println("Product Name\t\tQuantity\t\tPrice\t\tTotal");
        for(int j = 0; j<prodB.size(); j++) {
            total += prodB.get(j).getPrice() * prodB.get(j).getQuantity();
            System.out.printf("%-12s\t\t%8d\t\t%5d\t\t%5d\n",prodB.get(j).getName() ,prodB.get(j).getQuantity(),prodB.get(j).getPrice(),prodB.get(j).getPrice()*prodB.get(j).getQuantity());
        }
        System.out.println("\nGross Total = "+total);
        System.out.println("Press 0 to return");
        do {
            temp = s.next().charAt(0);
        }
        while(temp!='0');
        w.manipulateFile(Product.prodF);    
    }
}
