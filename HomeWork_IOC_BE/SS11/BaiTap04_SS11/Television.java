package IOC_BE.SS11.BaiTap04_SS11;

public class Television extends Device implements Connectable {

    public Television(int id, String name) {
        super(id, name);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " đã bật (Television).");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " đã tắt (Television).");
    }

    @Override
    public void connectWifi() {
        System.out.println(name + " đã kết nối WiFi.");
    }
}

