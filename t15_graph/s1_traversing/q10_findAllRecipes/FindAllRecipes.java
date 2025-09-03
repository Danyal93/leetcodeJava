//revision

package t15_graph.s1_traversing.q10_findAllRecipes;

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> ans = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[i]);
                inDegree.put(recipes[i], inDegree.getOrDefault(recipes[i], 0) + 1);
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }
        while (!queue.isEmpty()) {
            String node = queue.poll();
            for (String child : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.offer(child);
                    ans.add(child);
                }
            }
        }
        return ans;
    }
}

public class FindAllRecipes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] recipes = { "bread", "sandwich", "burger" };
        List<List<String>> ingredients = new ArrayList<>();
        ingredients.add(Arrays.asList("yeast", "flour"));
        ingredients.add(Arrays.asList("bread", "meat"));
        ingredients.add(Arrays.asList("sandwich", "meat", "bread"));
        String[] supplies = { "yeast", "flour", "meat" };
        System.out.println(solution.findAllRecipes(recipes, ingredients, supplies));
    }
}
