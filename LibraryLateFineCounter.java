import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LibraryItem[] items = new LibraryItem[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if (type.equalsIgnoreCase("BOOK")) {
                items[i] = new BookItem(title, days);
            } else if (type.equalsIgnoreCase("DVD")) {
                items[i] = new DVDItem(title, days);
            } else if (type.equalsIgnoreCase("MAGAZINE")) {
                items[i] = new MagazineItem(title, days);
            }
        }

        for (int i = 0; i < n; i++) {
            double fine = items[i].fine();
            System.out.printf("%s: %.2f%n", items[i].title, fine);
            total += fine;
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
