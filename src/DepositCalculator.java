import java.util.Scanner;


public class DepositCalculator {
    Math math;
    double calculateComplexPercentFunction(double a, double y, int d) {
        double pay = a * math.pow((1 + y / 12), 12 * d);
        return countAmount(pay, 2);
    }

    double calculateSimplePercentFunction(double amount, double yearRate, int deposit_period) {
        return countAmount(amount + amount * yearRate * deposit_period, 2);
    }

    double countAmount(double value, int places) {
        double scaLe = math.pow(10, places);
        return math.round(value * scaLe) / scaLe;
    }

    void doDeposit() {
        int period;
        int action;
        Scanner sumDeposit = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        
        int amount = sumDeposit.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = sumDeposit.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = sumDeposit.nextInt();
        double outDoubleVar = 0;

        if (action == 1) outDoubleVar = calculateSimplePercentFunction(amount, 0.06, period);
        else if (action == 2) {
            outDoubleVar = calculateComplexPercentFunction(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }

    public static void main(String[] args) {

        new DepositCalculator().doDeposit();
    }


}