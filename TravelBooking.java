import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50.0;
    double distance;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equalsIgnoreCase("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s: %.2f%n",
                    bookings[i].getClass().getSimpleName().replace("Booking", "").toUpperCase(),
                    bookings[i].totalFare());
        }
    }
}
