public class MoneyTransferService{
  CurrencyConverter cc = new CurrencyConverter();
  
  double computeTransferAmount(int index,double amount){
    return cc.computeTransferAmount(index,amount);
  }

  double computetransferFee(int index, double amount){
    return 0.02 * computeTransferAmount(index, amount);
  }

  public static void main(String[] args){
    MoneyTransferService transferService = new MoneyTransferService();

    double transferAmount = transferService.computeTransferAmount(0,100);

    double transferFee = transferService.computetransferFee(0,1000);

    System.out.println("Transfer Amount: " + transferAmount);
    System.out.println("Transfer Fee: " + transferFee);
  }
}