
public class CashRegister {

    private int cashOnHand;   

    public CashRegister() {
       
        cashOnHand = 0;
    }

  
    public CashRegister(int cashIn) {
       
        if (cashIn >= 0) {
            cashOnHand = cashIn;
        } else {
            cashOnHand = 0;
        }
    }

  
    public int currentBalance() {
       
        return cashOnHand;
    }


    public void acceptAmount(int amountIn) {
  
        cashOnHand = cashOnHand + amountIn;
    }

  
    public void deductAmount(int amountCost) {
      
        cashOnHand = cashOnHand - amountCost;
    }
}
