package edu.hw3.Task6;

public class Main {

    public static void main(String[] args) {
        MoscowMarket market = new MoscowMarket();
        Stock SBER = new Stock();
        Stock TCSgroup = new Stock("TCS", 1934.3);
        Stock ABC = new Stock("ABC", 124.21);

        market.add(SBER);
        market.add(TCSgroup);
        market.add(ABC);

        System.out.println(market.getStockList());
        System.out.println(market.mostValuableStock().getName());
    }


}
