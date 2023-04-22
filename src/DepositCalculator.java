import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculatePercent();
    }

    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount + depositAmount * yearRate * depositPeriod;
        return round(pay, 2);
    }

    double round(double pay, int places) {
        double scale = Math.pow(10, places);
        return Math.round(pay * scale ) / scale;
    }

    void calculatePercent() {
        int depositAmount;
        int depositPeriod;
        int action;
        double outAmount = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            outAmount = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (action == 2) {
            outAmount = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в "
            + outAmount);
    }
}