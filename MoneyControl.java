import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MoneyControl {
    public static void incrementAmount(HashMap<String, List<Object>> map, String name, double increment) {
        List<Object> values = map.get(name);
        if (values != null) {
            double individual = (double) values.get(0);
            individual += increment;
            values.set(0, individual); 
        } else {
            System.out.println("Name not found in the map.");
        }
    }

    public static void distributeToAll(HashMap<String, List<Object>> map, double increment) {
        for (String key : map.keySet()) {
            List<Object> values = map.get(key);
            if (values != null) {
                double currentAnotherValue = (double) values.get(1);
                currentAnotherValue += increment;
                values.set(1, currentAnotherValue); 
            }
        }
    }

    public static void settleBalances(HashMap<String, List<Object>> map) {
        HashMap<String, Double> netBalance = new HashMap<>();
        
       
        for (String name : map.keySet()) {
            List<Object> values = map.get(name);
            double individual = (double) values.get(0);
            double distribute = (double) values.get(1);
            netBalance.put(name, individual - distribute);
        }

        List<Map.Entry<String, Double>> positiveBalances = new ArrayList<>();
        List<Map.Entry<String, Double>> negativeBalances = new ArrayList<>();

        for (Map.Entry<String, Double> entry : netBalance.entrySet()) {
            if (entry.getValue() > 0) {
                positiveBalances.add(entry);
            } else if (entry.getValue() < 0) {
                negativeBalances.add(entry);
            }
        }

        int i = 0, j = 0;
        while (i < positiveBalances.size() && j < negativeBalances.size()) {
            double amount = Math.min(positiveBalances.get(i).getValue(), -negativeBalances.get(j).getValue());
            System.out.println(negativeBalances.get(j).getKey().toUpperCase() + " has to pay " + amount + " to " + positiveBalances.get(i).getKey().toUpperCase());

            positiveBalances.get(i).setValue(positiveBalances.get(i).getValue() - amount);
            negativeBalances.get(j).setValue(negativeBalances.get(j).getValue() + amount);

            if (positiveBalances.get(i).getValue() == 0) {
                i++;
            }
            if (negativeBalances.get(j).getValue() == 0) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<Object>> nameToValuesMap = new HashMap<>();

        System.out.println("Enter the number of people who are involved in the transactions.");
        int people = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= people; i++) {
            System.out.println("Enter the name - " + i);
            String name = sc.nextLine();
            name = name.toLowerCase();
            double individual = 0.0;
            double distribute = 0.0;

            List<Object> values = new ArrayList<>();
            values.add(individual);
            values.add(distribute);
            nameToValuesMap.put(name, values);
        }

        int amount = 9;
        while (amount >= 0) {
            System.out.println("Enter the amount to be split or a negative number to calculate the bill.");
            amount = sc.nextInt();
            sc.nextLine();
            if (amount < 0) {
                break;
            } else {
                System.out.println("This " + amount + " was paid by whom?");
                String payer = sc.nextLine();
                incrementAmount(nameToValuesMap, payer, amount);
                distributeToAll(nameToValuesMap, amount / (double) people); 
            }
        }

        for (String name : nameToValuesMap.keySet()) {
            List<Object> values = nameToValuesMap.get(name);
            System.out.println(name + ": Paid a total of: " + values.get(0) + ", and individual expenditure was: " + values.get(1));
        }

        System.out.println("\nTo settle the balances finally :- ");
        settleBalances(nameToValuesMap);

        sc.close();
    }
}
