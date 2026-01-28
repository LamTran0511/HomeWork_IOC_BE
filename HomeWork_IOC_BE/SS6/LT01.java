package SS6;

import java.util.Scanner;

public class LT01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        boolean flagListPoint = false;

        int n = 0;
        float[] ListPoint = new float[10000];

        // biến đếm sinh viên
        int count = 0;
//        // điểm cao, thấp nhất, trung bình, tổng
        float point = 0f;
        float maxPoint = 0f;
        float minPoint = 10f;
        float totalPoint = 0f;

//        đạt và trượt
        int pass = 0;
        int slip = 0;

//        giỏi và xuất sắc
        int good = 0;
        int excellent = 0;


        do {
            System.out.println("""
                    \n********************************** MENU **********************************
                    1. Nhập danh sách điểm sinh viên
                    2. In danh sách điểm
                    3. Tìm điểm trung bình của các sinh viên
                    4. Tìm điểm cao nhất và thấp nhất
                    5. Đếm số lượng sinh viên đạt và trượt
                    6. Sắp xếp điểm tăng dần
                    7. Thống kê số lượng sinh viên giỏi và xuất sắc
                    8. Thoát
                    """);

            System.out.print("Nhập lựa chọn: ");
            choice = sc.nextInt();

            // kiểm tra nhập lựa chọn
            while (choice < 1 || choice > 8) {
                System.out.print("Lựa chọn sai vui lòng nhập lại: ");
                choice = sc.nextInt();
            }

            switch (choice) {
                case 1: {
                    System.out.print("Nhập tổng số danh sách điểm: ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.printf("\n Nhập điểm thứ %d: ", i);
                        ListPoint[i] = sc.nextInt();
                        totalPoint += ListPoint[i];
                        count++;

                        if(maxPoint < ListPoint[i]) {
                            maxPoint = ListPoint[i];
                        }
                        if(minPoint > ListPoint[i]) {
                            minPoint = ListPoint[i];
                        }

                        if (ListPoint[i] >= 5) {
                            pass++;
                            if (ListPoint[i] == 8) {
                                good++;
                            } else if (ListPoint[i] > 8) {
                                excellent++;
                            }
                        } else {
                            slip++;
                        }
                    }
                    flagListPoint = true;
                }
                break;
                case 2: {
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        PrintListPoint(ListPoint, n);
                    }
                }
                break;
                case 3: {
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        float averageScore = totalPoint / count;
                        System.out.printf("Điểm trung bình của %d sinh viên là: %f.2", count, averageScore);
                    }
                }
                break;
                case 4:
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        System.out.printf("Điểm số cao nhất là: %f", maxPoint);
                        System.out.printf("\nĐiểm số thấp nhất là: %f", minPoint);
                    }
                    break;
                case 5:
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        System.out.printf("Số lượng sinh viên đạt: %d", pass);
                        System.out.printf("\nSố lượng sinh viên trượt: %d", slip);
                    }
                    break;
                case 6:
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        arrangeListPoint(ListPoint, n);
                        System.out.println("Danh sách đã được sắp xêp");
                    }
                    break;
                case 7:
                    if (!flagListPoint) {
                        CheckFlagListPoint();
                    } else {
                        System.out.printf("Số lượng sinh viên giỏi: %d", good);
                        System.out.printf("\nSố lượng sinh viên xuất sắc: %d", excellent);
                    }
                    break;
                case 8:
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.out.println("Lỗi! không có lựa chọn");
            }

        } while (choice != 8);
    }

    public static void CheckFlagListPoint() {
        System.out.println("Chưa có danh sách sinh viên");
    }

    public static void PrintListPoint(float [] ListPoint, int n) {
        System.out.printf("+%s+%s+\n", "-".repeat(5), "-".repeat(12));
        System.out.printf("| %-3s | %-10s |\n", "STT","Điểm");
        System.out.printf("+%s+%s+\n", "-".repeat(5), "-".repeat(12));
        for (int i = 0; i < n; i++) {
            System.out.printf("| %-3s | %-10s |\n", i+1, ListPoint[i]);
            System.out.printf("+%s+%s+\n", "-".repeat(5), "-".repeat(12));
        }
    }

    public static void arrangeListPoint(float [] ListPoint, int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (ListPoint[j] >  ListPoint[j + 1]) {
                    float temp = ListPoint[j];
                    ListPoint[j] = ListPoint[j + 1];
                    ListPoint[j + 1] = temp;
                }
            }
        }
    }
}