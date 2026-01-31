package IOC_BE.SS11.BaiTap04_SS11;

public class SmartPhone extends Device implements Connectable, Chargeable {

    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đã bật (SmartPhone).");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đã tắt (SmartPhone).");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đã kết nối WiFi.");
    }

    @Override
    public void charge() {
        System.out.println(name + " đang sạc pin.");
    }
}
