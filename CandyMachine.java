
import java.util.*;

public class CandyMachine {
    

    CashRegister cashRegister;
    Dispenser candy;
    Dispenser chips;
    Dispenser gum;
    Dispenser cookies;

    public CandyMachine() {
        cashRegister = new CashRegister();
        candy = new Dispenser();
        
        chips = new Dispenser(100, 65);
        gum = new Dispenser(75, 45);
        cookies = new Dispenser(100, 85);
    }

    public CandyMachine(Scanner console) {
       
    
        cashRegister = new CashRegister(console.nextInt());

        System.out.println("Set Cost of the item[Chips]");
        int chpCost = console.nextInt();
        System.out.println("Number Of Items:");
        int items = console.nextInt();
        chips = new Dispenser(items, chpCost);

        System.out.println("Set Cost of the item[Gum]");
        int gumCost = console.nextInt();
        System.out.println("Number Of Items:");
        items = console.nextInt();
        gum = new Dispenser(items, gumCost);

        System.out.println("Set Cost of the item[Cookies]");
        int cookiesCost = console.nextInt();
        System.out.println("Number Of Items:");
        items = console.nextInt();
        cookies = new Dispenser(items, cookiesCost);

        cashRegister = new CashRegister();
        candy = new Dispenser();
  

    }


    public void On() {
        Scanner input = new Scanner(System.in);
        int choice;                    
        showSelection();              
        choice = input.nextInt();     

     
        while (choice != 9) 
        {
            switch (choice) 
            {
                case 1:
                    sellProduct(candy, cashRegister);
                    break;

                case 2:
                    sellProduct(chips, cashRegister);
                    break;

                case 3:
                    sellProduct(gum, cashRegister);
                    break;

                case 4:
                    sellProduct(cookies, cashRegister);
                    break;

                default:
                    System.out.println("Invalid Selection");
            }

            showSelection();
            choice = input.nextInt();

        }
    }
   

    private void showSelection() {
        System.out.println("*** Welcome ***");
   
        System.out.println("To select an item, enter ");
        System.out.println("0 for Adding more cash");
        System.out.println("1 for Candy");
        System.out.println("2 for Chips");
        System.out.println("3 for Gum");
        System.out.println("4 for Cookies");
        System.out.println("9 to exit");
    }


    private void sellProduct(Dispenser product, CashRegister cRegister) {
        
        int price;       
        int coinsInserted;  
        int coinsRequired; 
      
        Scanner input = new Scanner(System.in);

        if (product.getCount() > 0) {
            price = product.getProductCost();
            coinsRequired = price;
            coinsInserted = 0;

            while (coinsRequired > 0) {
                System.out.print("Please deposit "
                        + coinsRequired
                        + " cents: ");

                coinsInserted = coinsInserted + input.nextInt();

                coinsRequired = price - coinsInserted;
            }

            System.out.println();

            cRegister.acceptAmount(coinsInserted);
            product.makeSale();

            System.out.println("Collect your item "
                    + "at the bottom and "
                    + "enjoy.\n");
        } else {
            System.out.println("Sorry this item "
                    + "is sold out.\n");
        }
    }
}
