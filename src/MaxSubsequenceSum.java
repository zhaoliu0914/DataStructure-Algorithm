import java.util.ArrayList;
import java.util.List;

public class MaxSubsequenceSum {

    public static void main(String[] args) {

        List<Integer> sequenceList = new ArrayList<>();
        sequenceList.add(4);
        sequenceList.add(-3);
        sequenceList.add(5);
        sequenceList.add(-2);
        sequenceList.add(-1);
        sequenceList.add(2);
        sequenceList.add(6);
        sequenceList.add(-2);

        /**
         * First method,
         * O(N)
         * but not available for all negative elements.
         */
        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < sequenceList.size(); i++) {

            currentSum = currentSum + sequenceList.get(i);

            if (currentSum > maxSum) {
                maxSum = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.println("maxSum = " + maxSum);


        /**
         * Second method,
         * O(N^2)
         * available for any elements.
         */
        currentSum = 0;
        maxSum = sequenceList.get(0);
        for (int i = 0; i < sequenceList.size(); i++) {

            currentSum = 0;
            for (int j = i; j < sequenceList.size(); j++) {

                currentSum = currentSum + sequenceList.get(j);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    System.out.println("i = " + i + " j = " + j);
                }
            }
        }

        System.out.println("maxSum = " + maxSum);
    }

}
