import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MonteCarlo {
    public static void main(String[] args) {

        /*
         * Open input and output streams
         */
        Scanner scanner = new Scanner(System.in);
        /*
         * Ask user for number of points to generate
         */
        System.out.print("Number of points: ");
        int n = Integer.parseInt(scanner.nextLine());
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = 0, ptsInSubinterval = 0;
        /*
         * Create pseudo-random number generator
         */
        Random random = new Random();
        /*
         * Generate points and count how many fall in [0.0,0.5) interval
         */
        while (ptsInInterval < n) {
            /*
             * Generate pseudo-random number in [0.0,1.0) interval
             */
            double x = random.nextDouble() * 2.0;
            double y = random.nextDouble() * 2.0;

            // calculate the distance between point(x,y) and center(1.0, 1.0)
            double distanceX = Math.pow((x - 1.0), 2);
            double distanceY = Math.pow((y - 1.0), 2);
            double distance = Math.sqrt(distanceX + distanceY);

            /*
             * Increment total number of generated points
             */
            ptsInInterval++;

            if (distance < 1.0) {
                ptsInSubinterval++;
            }
        }
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        double estimate = (1.0 * ptsInSubinterval) / ptsInInterval;

        double areaOfCircle = estimate * 4.0;
        //output.println("Estimate of percentage: " + estimate + "%");
        System.out.println("the area of a circle of radius 1: " + areaOfCircle);

        /*
         * Close input and output streams
         */
        scanner.close();

    }
}
