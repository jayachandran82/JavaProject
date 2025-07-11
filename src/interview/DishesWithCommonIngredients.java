package interview;

import java.util.*;

/**
 * Your input is a list of dishes, where each dish is associated with its ingredients. Write an algorithm to group the dishes together that have common ingredients.
 * Example Input:
 * {
 * "Pasta" -> ["Tomato Sauce", "Onions", "Garlic"]
 * "Chicken Curry" --> ["Chicken", "Curry Sauce"]
 * "Fried Rice" --> ["Rice", "Onions", "Nuts"]
 * "Salad" --> ["Spinach", "Nuts"]
 * "Sandwich" --> ["Cheese", "Bread"]
 * "Quesadilla" --> ["Chicken", "Cheese"]
 * }
 * Output: [("Pasta", "Fried Rice") ("Fried Rice, "Salad") ("Chicken Curry", "Quesadilla") ("Sandwich", "Quesadilla")]
 */
public class DishesWithCommonIngredients {

    static private Set<String> findDishesWithCommonIngredients(HashMap<String, List<String>> dishIngredients) {
        // Reverse map: ingredient -> list of dishes
        HashMap<String, Set<String>> ingredientsToDishes = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : dishIngredients.entrySet()) {
            String dish = entry.getKey();
            for (String ingredient : entry.getValue()) {
                ingredientsToDishes.computeIfAbsent(ingredient, k -> new HashSet<>()).add(dish);
            }
        }

        //Store unique pairs
        Set<String> resultPairs = new HashSet<>();
        for (Set<String> dishes : ingredientsToDishes.values()) {
            if (dishes.size() > 1) {
                List<String> dishList = new ArrayList<>(dishes);
                Collections.sort(dishList);
                for (int i = 0; i < dishList.size(); i++) {
                    for (int j = i + 1; j < dishList.size(); j++) {
                        resultPairs.add("(" + dishList.get(i) + "," + dishList.get(j) + ")");
                    }
                }

            }

        }
        return resultPairs;

    }

    public static void main(String[] args) {
        HashMap<String, List<String>> dishIngredients = new HashMap<>();
        dishIngredients.put("Pasta", Arrays.asList("Tomato Sauce", "Onions", "Garlic"));
        dishIngredients.put("Chicken Curry", Arrays.asList("Chicken", "Curry Sauce"));
        dishIngredients.put("Fried Rice", Arrays.asList("Rice", "Onions", "Nuts"));
        dishIngredients.put("Salad", Arrays.asList("Spinach", "Nuts"));
        dishIngredients.put("Sandwich", Arrays.asList("Cheese", "Bread"));
        dishIngredients.put("Quesadilla", Arrays.asList("Chicken", "Cheese"));

        Set<String> result = findDishesWithCommonIngredients(dishIngredients);
        for (String values : result) {
            System.out.println("Pair Value : " + values);
        }
    }
}
