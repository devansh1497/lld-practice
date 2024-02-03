import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Check {

    static class Node {
        int index;
        int val;

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Node> set = new TreeSet<>((a, b) -> {
            if(a.val == b.val) return a.index - b.index;
            return b.val - a.val;
        });

        for(int i = 0 ; i < n ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            set.add(new Node(i, nums[i]));
        }

        int moves = 0;

        while(map.size() > 1) {
            Node curr = set.first();
            set.remove(curr);
            Node next = set.ceiling(new Node(curr.index, curr.val-1));
            set.add(new Node(curr.index, next.val));
            map.put(curr.val, map.get(curr.val)-1);
            map.put(next.val, map.getOrDefault(next.val, 0)+1);
            if(map.get(curr.val) == 0) map.remove(curr.val);
            moves++;
        }
        return moves;
    }

    public static void main(String[] args) {
        Check check = new Check();
       System.out.println(check.reductionOperations(new int []{1,1,2,2,3}));
    }
}
