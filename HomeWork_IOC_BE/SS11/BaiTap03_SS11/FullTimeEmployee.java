package IOC_BE.SS11.BaiTap03_SS11;

public class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }

    @Override
    public double calculateBonus() {
        // Ví dụ: thưởng 10% lương cơ bản (bạn có thể đổi theo đề/ý bạn)
        return baseSalary * 0.10;
    }
}
