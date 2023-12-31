package hello;

public class HelloWorld {
    public static void main(String[] args) {
        int a = 20;
        byte b = (byte) a;
        int sumNumber = sum(1, 2);
        System.out.println(sumNumber);
    }

    /**
     * @param a 整数
     * @param b 整数
     * @return 两数之和
     */
    public static int sum(int a, int b) {
        return a + b;
    }
}