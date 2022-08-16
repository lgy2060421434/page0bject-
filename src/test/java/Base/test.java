package Base;

public class test {
    String name;
    public static  String te;

    public void setName(String name) {
        this.name = name;
        System.out.println("setname:" + this.name);
    }

    public void setName1(String name) {
        this.setName("ces1");
        System.out.println("test:" + this.name);
    }
    public static void tese(){
        System.out.println(te);
    }

    public static void main(String[] args) {
        test test = new test();
        test.setName("ceshi1");
        test.setName1("ssss");
    }


}
