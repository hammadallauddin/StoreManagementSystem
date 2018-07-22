import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class WriteFile extends Filing {
    PrintWriter pr;
    Formatter f;
//    String path = "d:/product.xls";
    Scanner sc = new Scanner(System.in);
     
    @Override
    void openFile() {
    try {
    	pr = new PrintWriter(new FileWriter(path,true));
    } 
    catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
    	}
    }
    
    void manipulateFile(Product p) {           
    	pr.printf("%s\t%d\t%d\n",p.getName(),p.getPrice(),p.getQuantity());
        System.out.println("Product Added Successfully");            
    }
    
    @Override
    void closeFile() {
        pr.close();
    }
    
    @Override
    public void manipulateFile(ArrayList<Product> a) {
        String name;
        int price,quantity;
         try {  
            f = new Formatter(path);
         }
         catch(Exception e) {
             System.out.println("Error");
         }
        
        for(int i=0;i<a.size();i++) {
            f.format("%s\t%d\t%d\n",a.get(i).getName() ,a.get(i).getPrice(),a.get(i).getQuantity());
        }
        
        f.close();    
    }
}
