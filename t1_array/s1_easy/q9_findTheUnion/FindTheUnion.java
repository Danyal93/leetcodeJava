package t1_array.s1_easy.q9_findTheUnion;

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int n1 = a.length;
        int n2 = b.length;
        int pointer = -1, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] == b[j]) {
                if (pointer == -1 || ans.get(pointer) != a[i]) {
                    ans.add(a[i]);
                    pointer++;
                }
                i++;
                j++;
            } else if (a[i] > b[j]) {
                if (pointer == -1 || ans.get(pointer) != b[j]) {
                    ans.add(b[j]);
                    pointer++;
                }
                j++;
            } else {
                if (pointer == -1 || ans.get(pointer) != a[i]) {
                    ans.add(a[i]);
                    pointer++;
                }
                i++;
            }
        }
        while (i < n1) {
            if (pointer == -1 || ans.get(pointer) != a[i]) {
                ans.add(a[i]);
                pointer++;
            }
            i++;
        }
        while (j < n2) {
            if (pointer == -1 || ans.get(pointer) != b[j]) {
                ans.add(b[j]);
                pointer++;
            }
            j++;
        }
        return ans;
    }
}

public class FindTheUnion {
    public static void main(String[] args) {
        int[] a = { -5, -4, -1, 1, 7 };
        int[] b = { -3, 0, 1, 8 };
        Solution.findUnion(a, b);
    }

}
