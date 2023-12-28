public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        int sum = 0;
        for (int steps : days) {
            sum += steps;
        }
        return sum;
    }

    int maxSteps() {
        int max = 0;
        for (int steps : days) {
            if (steps > max) {
                max = steps;
            }
        }
        return max;
    }

    int bestSeries(int goalByStepsPerDay) {
        int goal = 0;
        int maxGoal = 0;
        for (int steps : days) {
            if (steps >= goalByStepsPerDay) {
                goal++;
            } else {
                if (goal > maxGoal) {
                    maxGoal = goal;
                }
                goal = 0;
            }
        }
        return maxGoal;
    }
}
