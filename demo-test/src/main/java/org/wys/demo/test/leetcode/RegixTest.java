package org.wys.demo.test.leetcode;

import io.swagger.models.auth.In;
import org.springframework.boot.actuate.endpoint.web.Link;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static java.math.BigDecimal.ROUND_DOWN;
import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * ClassName RegixTest
 * Package org.wys.demo.test.leetcode
 * Description
 *
 * @author wys
 * @date 2022/5/29 9:44
 */
public class RegixTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11};
        System.out.println(solution.totalSteps(nums));
    }

    static class Solution {
        public int totalSteps(int[] nums) {
            int res = 0;
            Set<Integer> set = new HashSet<>();
            List<Integer> lk = new LinkedList<>();
            for (int num : nums) {
                lk.add(num);
            }
            while (!lk.isEmpty()) {
                boolean ok = true;
                for (int i = lk.size()-1; i>=1; i--) {
                    if (lk.get(i) < lk.get(i-1)) {
                        ok = false;
                        lk.remove(i);
                    }
                    if(ok) {
                        break;
                    }
                }
                res++;
            }
            return res;
        }
    }

}
