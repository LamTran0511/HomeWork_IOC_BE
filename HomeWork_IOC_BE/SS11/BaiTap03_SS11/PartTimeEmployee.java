package IOC_BE.SS11.BaiTap03_SS11;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int workingHour;

    public PartTimeEmployee(int id, String name, double hourlyRate, int workingHour) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.workingHour = workingHour;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * workingHour;
    }
}
