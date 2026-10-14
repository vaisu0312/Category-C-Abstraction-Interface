import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    String shape() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class CirclePlot extends Plot {
    double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class RectanglePlot extends Plot {
    double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class TrianglePlot extends Plot {
    double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equalsIgnoreCase("CIRCLE")) {
                plots[i] = new CirclePlot(owner, sc.nextDouble());
            } else if (type.equalsIgnoreCase("RECTANGLE")) {
                plots[i] = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            } else if (type.equalsIgnoreCase("TRIANGLE")) {
                plots[i] = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            }
        }

        for (int i = 0; i < n; i++) {
            double area = plots[i].area();
            System.out.printf("%s (%s): %.2f%n", plots[i].owner, plots[i].shape(), area);
            total += area;
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
