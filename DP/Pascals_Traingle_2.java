package DP;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Traingle_2 {
    public List<Integer> getRow(int rowIndex) {
         List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            ans.add(0, 1);
            for (int j = 1; j < i; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
            System.out.println(ans);
        }
        return ans;
    }
}
