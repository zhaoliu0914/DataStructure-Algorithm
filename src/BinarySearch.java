public class BinarySearch {

    public static void main(String[] args) {
        int[] list = {-1, 0, 1, 2, 4, 8, 16, 32, 64};

        int value = 2;

        int lowIndex = 0;
        int highIndex = list.length - 1;
        int midIndex = 0;

        int tempValue = 0;
        while (lowIndex <= highIndex) {

            midIndex = (lowIndex + highIndex) / 2;
            tempValue = list[midIndex];

            if (value < tempValue) {
                highIndex = midIndex - 1;
            } else if (value > tempValue) {
                lowIndex = midIndex + 1;
            } else {
                System.out.println("index = " + midIndex);
                break;
            }

        }
    }

}
