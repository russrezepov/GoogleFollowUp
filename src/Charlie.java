import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Charlie {
    public static class Stock {
        String name;    //name of a stock
        int noi;        //number of impressions per stock
        int nou;        //number of updates per stock wothon a day

        Stock(String name, int noi, int nou) {
            this.name = name;
            this.noi = noi;
            this.nou = nou;
        }


        public static int maxUpdates(int[] noiArr, int[] nouArr,
                                     int noiLength, int budget)
        // Number of impressions (stored in array v)
        // Number of updates (stored in array w)
        // Total number of number of impressions noiLength
        // Max budget
        {
            // base case: Negative capacity
            if (budget < 0) {
                return Integer.MIN_VALUE;
            }

            // base case: no items left or capacity becomes 0
            if (noiLength < 0 || budget == 0) {
                return 0;
            }

            // Including current noi item noi[n] in the set of stocks and recur for
            // remaining items noiLength-1 with decreased capacity budget-nou[noiLength]

            int include = noiArr[noiLength] + maxUpdates(noiArr, nouArr, noiLength - 1, budget - nouArr[noiLength]);

            // Excluding current item noi[noiLength] from the budget and recur for
            // remaining items noiLength-1

            int exclude = maxUpdates(noiArr, nouArr, noiLength - 1, budget);

            // return maximum value we get by including or excluding the current item
            return Integer.max(include, exclude);
        }
    }

        public static void main(String[] args) {
            //Creating stock objects of type Stock
            Stock apple = new Stock("AAPL", 30, 2);
            Stock google = new Stock("GOGL", 5, 3);
            Stock amazon = new Stock("AMZN", 5, 5);

            Set<Stock> stocks = new HashSet<Stock>();

            stocks.add(apple);
            stocks.add(google);
            stocks.add(amazon);

            int budget = 4; //The budget given

            ArrayList<Integer> noiArrList = new ArrayList<>(); //Saving Number of impressions from Set objects of type Stock
            ArrayList<Integer> nouArrList = new ArrayList<>(); //Saving Number of updates from Set objects of type Stock

            for (Stock entry : stocks) {
                noiArrList.add(entry.noi);
                nouArrList.add(entry.nou);
            }

            int[] noiArrInt = noiArrList.stream().mapToInt(i -> i).toArray(); //Converting ArrayList to int Array
            int[] nouArrInt = nouArrList.stream().mapToInt(i -> i).toArray(); //

            System.out.println("Max number of updates is " +
                    Stock.maxUpdates(noiArrInt, nouArrInt, nouArrInt.length - 1, budget));
        }

    }





