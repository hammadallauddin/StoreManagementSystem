import java.io.IOException;
import java.util.Scanner;
public class Store {
public static void main(String args[]) throws IOException, InterruptedException {
        char ch, choice;
        Scanner sca = new Scanner(System.in);
        Product.UploadProd();
        while(true) {
            System.out.println("HIZ GROCERY STORE");
            System.out.println("------------------------");
            System.out.println("ENTER \n1- PRODUCT SECTION\n2- BILLING SECTION\n3- EXIT");
            while(true) {
                choice = sca.next().charAt(0);
                if(choice<49 || choice>51)
                    System.out.println("Choose a Valid Option");
                else
                    break;
            }
            if(choice=='1') {
                do {
                    System.out.println("ENTER \n1- ADD PRODUCT\n2- VIEW PRODUCT LIST\n3- UPDATE            PRODUCT\n4- DELETE PRODUCT\n5- RETURN TO PREVIOUS SCREEN");
                    while(true) {
                        ch = sca.next().charAt(0);
                        if(ch<49 || ch>53)
                            System.out.println("Enter a Valid Option");
                        else {
                            break;
                        }
                    }
                    switch(ch) {
                        case '1':
                            Product.AddProd();
                            break;
                        case '2':
                            Product.ViewProd();
                            break;
                        case '3':
                            Product.UpProd();
                            break;
                        case '4':
                            Product.DelProd();
                            break;
                    }
                }
                while(ch!='5');
            }
        	else if(choice=='2') {
                do {
                    while(true) {
                        System.out.println("ENTER \n1- NEW BILL\n2- VIEW PREVIOUS BILL\n3- RETURN TO PREVIOUS SCREEN");
                        ch = sca.next().charAt(0);
                        if(ch<49 || ch>51)
                            System.out.println("Enter a Valid Option");
                        else {
                            break;
                        }
                    }
                    switch(ch) {
                        case '1':
                            Bill b = new Bill();
                            break;
                        case '2':
                            System.out.println("N/A Right Now");
                            break;
                    }
                }
                while(ch!='3');
            }
            else
                System.exit(0);
        }
    }
}
