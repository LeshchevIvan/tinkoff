package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MoscowMarket implements StockMarket {

    private PriorityQueue<Stock> stockList = new PriorityQueue<>(new StockComparator());

    public PriorityQueue<Stock> getStockList() {
        return stockList;
    }

    private static class StockComparator implements Comparator<Stock> {

        @Override
        public int compare(Stock o1, Stock o2) {

            return Double.compare(o1.getPrice(),o2.getPrice());

        }
    }


    @Override
    public void add(Stock stock) {
        stockList.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockList.remove(stock);

    }

    @Override
    public Stock mostValuableStock() {
        return stockList.peek();
    }
}
