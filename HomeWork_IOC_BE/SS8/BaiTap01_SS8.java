public class BaiTap01_SS8 {
    private int id;
    private String name;
    private int age;

    public BaiTap01_SS8() {

    }

    public BaiTap01_SS8( int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        BaiTap01_SS8 s1 = new BaiTap01_SS8(1,"Nguyen Van A",20);
        System.out.println("Id: "+ s1.id + ", Name: "+ s1.name + ", Age: "+ s1.age);
    }
}
