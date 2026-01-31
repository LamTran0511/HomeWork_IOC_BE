package IOC_BE.SS11.BaiTap04_SS11;

public class Main {
    public static void main(String[] args) {
        Device[] devices = new Device[] {
                new SmartPhone(1, "iPhone 15"),
                new Laptop(2, "Dell XPS"),
                new Television(3, "Samsung TV")
        };

        for (Device d : devices) {
            System.out.println("----- THIẾT BỊ -----");
            d.showInfo();

            // Bật / tắt thiết bị
            d.turnOn();

            // Nếu hỗ trợ wifi -> kết nối
            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            } else {
                System.out.println(d.name + " không hỗ trợ WiFi.");
            }

            // Nếu sạc được -> sạc
            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            } else {
                System.out.println(d.name + " không hỗ trợ sạc.");
            }

            d.turnOff();
            System.out.println();
        }
    }
}
