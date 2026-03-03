package IOC_BE.SS17.BaiTap02_SS17;


import java.util.Scanner;

public class Task {
    private int id;
    private String taskName;
    private String status;

    public Task() {
    }

    public Task(String taskName, String status) {
        this.taskName = taskName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        while (true) {
            System.out.print("Nhập tên công việc: ");
            String inputTaskName = scanner.nextLine();
            if (inputTaskName.trim().isEmpty()) {
                System.out.println("Tên công việc không được để trống. Vui lòng thử lại.");
            } else {
                this.taskName = inputTaskName;
                break;
            }
        }

        while (true) {
            System.out.print("Nhập trạng thái công việc: ");
            String inputStatus = scanner.nextLine();
            if (inputStatus.trim().isEmpty()) {
                System.out.println("Trạng thái công việc không được để trống. Vui lòng thử lại.");
            } else {
                this.status = inputStatus;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("|%-5d|%-50s|%-30s|", this.id, this.taskName, this.status));
        String trString = sb.toString();
        return trString;
    }
}