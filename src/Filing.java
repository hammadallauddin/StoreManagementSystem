import java.util.ArrayList;
abstract class Filing {
    String path = "d:/product.xls";
    abstract void openFile();
    abstract void manipulateFile(ArrayList<Product> a);
    abstract void closeFile();
}
