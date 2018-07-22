import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile extends Filing {
    Scanner sca = null;
    
    @Override
    public void openFile() {
        try {
            sca = new Scanner(new File(path));
        }
        catch (Exception e) {
            WriteFile wf = new WriteFile();
            wf.openFile();
        }
    }
    
    
    @Override
    public void manipulateFile(ArrayList<Product> prd) {
         try {
            sca = new Scanner(new File(path));
        }
        catch (Exception e) {
            System.out.println("Error");
        }
        String name;
        int price;
        int quan;
        while(sca.hasNext()) {
            name = sca.next();
            price = sca.nextInt();
            quan = sca.nextInt();
            
            prd.add(new Product(name,price,quan));
        }
    }
        
    @Override
    public void closeFile() {
        sca.close();
    }
}
