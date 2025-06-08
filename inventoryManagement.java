import java.util.*;
import java.io.FileWriter;

class inventoryManagement{
    static ArrayList<String> productNames=new ArrayList<>();
    static ArrayList<Integer> productQuantities=new ArrayList<>();
    static ArrayList<Float> productPrices=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);

    public static void addProduct(){
        System.out.println("Enter product name: ");
        String name=sc.nextLine().trim();

        System.out.println("Enter product quantity: ");
        int quantity=Integer.parseInt(sc.nextLine());

        System.out.println("Enter price per unit: ");
        float price=Float.parseFloat(sc.nextLine());

        for(int i=0;i<productNames.size();i++){
            if(productNames.get(i).equalsIgnoreCase(name)){
                productQuantities.set(i,productQuantities.get(i)+quantity);
                System.out.println("Product '" + name + "' updated successfully!\n");
                return;
            }
        }
        productNames.add(name);
        productQuantities.add(quantity);
        productPrices.add(price);
        System.out.println("Product '" + name + "' added successfully!\n");

    }

    public static void viewInventory(){
         if(productNames.isEmpty()){
            System.out.println("Inventory is empty.\n");
            return;
        }
        System.out.println("Current Inventory:");
        System.out.println("Name\tQuantity\tPrice");
        for (int i = 0; i < productNames.size(); i++) {
            System.out.println(productNames.get(i) + "\t" + productQuantities.get(i) + "\t\t$" + productPrices.get(i));
        }
        System.out.println();
    }

    public static void updateProduct(){
        System.out.println("Enter product name to update: ");
        String name=sc.nextLine().trim();
        for(int i=0;i<productNames.size();i++){
            if(productNames.get(i).equalsIgnoreCase(name)){            
                System.out.println("Enter product quantity to update: ");
                int quantity=Integer.parseInt(sc.nextLine());
                productQuantities.set(i,quantity);
                System.out.println("Update "+name+" stock to "+quantity+"\n");
                return;
            }
        }
        System.out.println("Product not found!\n");
    }

    public static void deleteProduct(){
        System.out.println("Enter product name to delete: ");
        String name=sc.nextLine().trim();
        for(int i=0;i<productNames.size();i++){
            if(productNames.get(i).equalsIgnoreCase(name)){
                productNames.remove(i);
                productPrices.remove(i);
                productQuantities.remove(i);
                System.out.println("Deleted "+name+" from inventory.\n");
            }
        }
         System.out.println("Product not found!\n");
    }

    public static void searchProduct(){
        System.out.println("Enter product name to search: ");
        String sProd=sc.nextLine().trim();
        for(int i=0;i<productNames.size();i++){
            if(productNames.get(i).equalsIgnoreCase(sProd)){
                System.out.println(sProd+": Quantity = "+productQuantities.get(i)+", Price = $"+productPrices.get(i)+"\n");
            return;
            }
        }
        System.out.println("Product not found!\n");
    }

    public static void saveInventory() throws Exception{
        FileWriter writer=new FileWriter("inventory.csv");
        writer.write("Product Name,Quantity,Price\n");
        for (int i = 0; i < productNames.size(); i++) {
            writer.write(productNames.get(i) + "," + productQuantities.get(i) + "," + productPrices.get(i) + "\n");
        }

        writer.close();
        System.out.println("Inventory saved to inventory.csv\n");
    }
    public static void main(String[] args) throws Exception{
        while(true){
            System.out.println("Inventory Management System\n");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Product");
            System.out.println("6. Save & Exit");

            System.out.println("\nEnter your choice: ");
            int choice=Integer.parseInt(sc.nextLine());

            if(choice==1){
                addProduct();
            }else if(choice==2){
                viewInventory();
            }else if(choice==3){
                updateProduct();
            }else if(choice==4){
                deleteProduct();
            }else if(choice==5){
                searchProduct();
            }else if(choice==6){
                saveInventory();
                System.out.println("Exiting program....");
                break;
            }else{
                System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}