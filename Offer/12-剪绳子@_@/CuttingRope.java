import org.junit.Test;

import java.util.HashMap;

public class CuttingRope {

    HashMap<Integer, Integer> map = new HashMap<>();

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        int res = -1;
        for (int i = 1; i < n; i++) {
            if (map.containsKey(n)) return map.get(n);
            int subres = i * cuttingRope(n - i);
            res = Math.max(res, Math.max(subres, i * (n - i)));
        }
        map.put(n, res);
        return res;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(10));
    }

}
