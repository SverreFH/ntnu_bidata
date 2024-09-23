public class StockCalculator {
    final private int[] stockArray;
    private int buyDate;
    private int sellDate;

    /**
     * Initializes the stockCalculator with the necessary array of changes
     * in stock value
     * @param stockArray an array containing the change in stock value per day
     */
    StockCalculator(int[] stockArray) {
        this.stockArray = stockArray;
    }

    /**
     * Calculates witch day one should buy and sell stocks in order to
     * maximise profits. Does this by taking a day in the list of stock
     * value changes and then checks with the remaining days when to sell
     * for maximum profit. If this is the highest calculated stock value
     * so far then the stock value is updates to this value, and the buy
     * and sell days are updated. This process is repeated for every day
     * in the stock array
     */
    public void calculate(){
        int stockValue = 0;
        for(int i = 0; i < stockArray.length; i++){
            int calculatedStockValue = 0;

            for(int j = i; j < stockArray.length; j++){
                calculatedStockValue += stockArray[j];

                if(calculatedStockValue > stockValue){
                    stockValue = calculatedStockValue;
                    this.buyDate = i;
                    this.sellDate = j + 1;
                }
            }
        }
    }
    /**
     * Gets the buy date
     * @return the buy date
     */
    public int getBuyDate(){
        return this.buyDate;
    }

    /**
     * Gets the sell date
     * @return the sell date
     */
    public int getSellDate(){
        return this.sellDate;
    }
}


