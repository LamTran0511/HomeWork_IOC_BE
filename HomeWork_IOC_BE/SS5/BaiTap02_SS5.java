import java.util.Scanner;

public class BaiTap02_SS5 {
    static void main(String[] args) {


        final int n = 1000000;
        long start = System.currentTimeMillis();
        String s = "Hello";
        for (int i = 0; i < n; i++) {
            s = s + "World";
        }
        long end = System.currentTimeMillis();
        System.out.println("Thời gian với String: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < n; i++) {
            sb = sb.append("World");
        }
        end = System.currentTimeMillis();
        System.out.println("Thời gian với Stringbuilder: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < n; i++) {
            sbf = sbf.append("World");
        }
        end = System.currentTimeMillis();
        System.out.println("Thời gian với Stringbuffer: " + (end - start) + "ms");

        System.out.println("\nNhận xét:");
        System.out.println("- String: chậm khi nối nhiều lần vì String là bất biến (immutable), mỗi lần + tạo ra đối tượng mới.");
        System.out.println("- StringBuilder: nhanh, phù hợp nối chuỗi nhiều lần trong 1 luồng (single-thread).");
        System.out.println("- StringBuffer: tương tự StringBuilder nhưng có đồng bộ (thread-safe), an toàn đa luồng hơn nhưng thường chậm hơn StringBuilder.");

    }
}
