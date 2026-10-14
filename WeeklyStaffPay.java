import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTimeStaff extends Staff {
    double salary;

    FullTimeStaff(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equalsIgnoreCase("FULLTIME")) {
                staff[i] = new FullTimeStaff(name, sc.nextDouble());
            } else if (type.equalsIgnoreCase("HOURLY")) {
                staff[i] = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
            } else if (type.equalsIgnoreCase("INTERN")) {
                staff[i] = new InternStaff(name, sc.nextDouble());
            }
        }

        for (int i = 0; i < n; i++) {
            double pay = staff[i].pay();
            System.out.printf("%s: %.2f%n", staff[i].name, pay);
            total += pay;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
