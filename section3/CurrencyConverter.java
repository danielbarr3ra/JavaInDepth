public class CurrencyConverter {
  double[] exchangeRates = new double[] {63.0, 3.0, 3.0, 595.5, 18.0, 107.0, 2.0};

  void setExchageRates(double[] rates){
    exchangeRates =  rates;
  }

  void updateExchangeRates(int arrayIndex, double newValue){
    exchangeRates[arrayIndex] = newValue;
  }
  
  double getExchangeRate(int arrayIndex){
    return exchangeRates[arrayIndex];
  }

  double computeTransferAmount(int arrayIndex, double amount) {
    return amount * getExchangeRate(arrayIndex);
  }

  void printCurrencies() {
    System.out.println("\nruppe: " + exchangeRates[0]);
    System.out.println("dirhams: " + exchangeRates[1]);
    System.out.println("real: " + exchangeRates[2]);
    System.out.println("chilean_peso: " + exchangeRates[3]);
    System.out.println("mexican_peso: " + exchangeRates[4]);
    System.out.println("_yen: " + exchangeRates[5]);
    System.out.println("$australian: " + exchangeRates[exchangeRates.length - 1]);
  }

  /*public static void main (String[] args){
    CurrencyConverter cc = new CurrencyConverter();

    // Jan 1st
    double[] rates = new double[] {63.0, 3.0, 3.0, 595.5, 18.0, 107.0, 2.0};
    cc.setExchageRates(rates);
    cc.printCurrencies();
    // Jan 2nd
    rates = new double[] {65.0, 5.0, 3.0, 595.5, 18.0, 107.0, 2.0};
    cc.setExchageRates(rates);
    cc.printCurrencies();
    // Jan 3rd
    cc.updateExchangeRates(0, 66.0);
 
    double amount = cc.computeTransferAmount(0, 1000);
    System.out.println("Transferred amount: " + amount);

  }*/

}