package t1_array.s2_medium.q17_rankTeamsByVotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String rankTeams(String[] votes) {
        String ans = "";
        int numberOfTeams = votes[0].length();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            String vote = votes[i];
            for (int j = 0; j < vote.length(); j++) {
                char c = vote.charAt(j);
                if (!map.containsKey(c)) {
                    map.put(c, new ArrayList<Integer>(Collections.nCopies(numberOfTeams, 0)));
                }
                map.get(c).set(j, map.get(c).get(j) + 1);
            }
        }
        List<Character> voteBank = new ArrayList<>(map.keySet());

        Collections.sort(voteBank, (a, b) -> {
            for (int i = 0; i < numberOfTeams; i++) {
                if (map.get(a).get(i) != map.get(b).get(i)) {
                    return Integer.compare(map.get(b).get(i), map.get(a).get(i));
                }
            }

            return Character.compare(a, b);
        });

        for (int i = 0; i < voteBank.size(); i++) {
            Character word = voteBank.get(i);
            ans += word;
        }
        return ans;
    }
}

public class RankTeamsByVotes {
    public static void main(String[] args) {
        String[] votes = { "XYZW", "WXYZ" };
        Solution solution = new Solution();
        solution.rankTeams(votes);
    }
}
