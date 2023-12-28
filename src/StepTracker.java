import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int month;
    int day;
    int steps;
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца от 1 до 12 (включительно)");
        while (true) {
            month = scanner.nextInt();
            if (month > 12 || month < 1) {
                System.out.println("Номер вводимого месяца должен быть от 1 до 12 включительно");
            } else {
                break;
            }
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        while (true) {
            day = scanner.nextInt();
            if (day > 30 || day < 1) {
                System.out.println("Номер вводимого дня должен быть от 1 до 30 включительно");
            } else {
                break;
            }
        }

        System.out.println("Введите количество шагов");
        while (true) {
            steps = scanner.nextInt();
            if (steps < 0) {
                System.out.println("Количество шагов должно быть положительным числом");
            } else {
                break;
            }
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
    }

    public void changeStepGoal() {
        System.out.println("Введите новую цель шагов в день");
        while (true) {
            goalByStepsPerDay = scanner.nextInt();
            if (goalByStepsPerDay < 0) {
                System.out.println("Количество шагов должно быть положительным числом");
            } else {
                break;
            }
        }
    }

    public void printStatistic() {
        System.out.println("Введите номер месяца");
        MonthData monthData;
        while (true) {
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Номер должен соответствовать месяцу, например: 1 - явнарь, 2 - февраль");
            } else {
                monthData = monthToData[month - 1];
                break;
            }
        }

        monthData.printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
        System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
        System.out.println("Cреднее количество шагов: " + (monthData.sumStepsFromMonth() / 30));
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(monthData.sumStepsFromMonth()));
        System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
        System.out.println("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого." + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
