package Week11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class FindMedian {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> result = new ArrayList<Double>();
        TreeSet<Integer> tree = new TreeSet<Integer>();
        for(Integer x: a){
            tree.add(x);
            result.add(getMedian(tree));
        }
        return result;
    }
    private static double getMedian(TreeSet<Integer> sortedSet) {
        int size = sortedSet.size();
        int middle = size / 2;

        if (size % 2 != 0) {
            return sortedSet.stream().skip(middle).findFirst().orElse(0);
        } else {
            Iterator<Integer> iterator = sortedSet.iterator();
            for (int i = 0; i < middle - 1; i++) {
                iterator.next();
            }
            int firstMiddle = iterator.next();
            int secondMiddle = iterator.next();
            return (double) (firstMiddle + secondMiddle) / 2.0;
        }
    }
}
