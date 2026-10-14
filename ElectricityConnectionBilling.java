import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(int units) {
        super(units);
    }

    double bill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) {
        super(units);
    }

    double bill() {
        return units * 8.0 + 100;
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equalsIgnoreCase("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }

        for (int i = 0; i < n; i++) {
            double bill = connections[i].bill();
            System.out.printf("%s: %.2f%n", connections[i].getClass().getSimpleName().replace("Connection", "").toUpperCase(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
