package IOC_BE.SS11.BaiTap03_SS11;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new FullTimeEmployee(1, "An", 12000000),
                new PartTimeEmployee(2, "Bình", 50000, 80),
                new FullTimeEmployee(3, "Chi", 15000000),
                new PartTimeEmployee(4, "Dũng", 60000, 60)
        };

        for (Employee e : employees) {
            System.out.println("----- NHÂN VIÊN -----");
            e.showInfo();

            double salary = e.calculateSalary();
            System.out.printf("Lương: %.0f%n", salary);

            // Nếu có thưởng -> in thưởng
            if (e instanceof BonusEligible) {
                double bonus = ((BonusEligible) e).calculateBonus();
                System.out.printf("Thưởng: %.0f%n", bonus);
            } else {
                System.out.println("Thưởng: Không có");
            }

            System.out.println();
        }
    }
}
