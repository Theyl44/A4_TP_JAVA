public class Main {
    public static void question1(String[] args){
        String url = args[0];
        String user = args[1];
        String password = args[2];
        DatabaseManager dbManager = new DatabaseManager(url, user, password);
        dbManager.fetchProducts();
        dbManager.printProducts();
    }
    public static void question2(String[] args){
        String url = args[0];
        String user = args[1];
        String password = args[2];

        DatabaseManager dbManager = new DatabaseManager(url, user, password);
        dbManager.fetchProducts();

        InventoryWindow w = new InventoryWindow(dbManager.getProducts(),dbManager);
    }
    public static void main(String[] args) {
        //question1(args);
        question2(args);
    }
}
