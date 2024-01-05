/*
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bargain {
    private static final int THRESHOLD = 10;
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        // 模拟初始需要砍价的用户信息
        UserInfo userToBeKan = new UserInfo("光头强", 100);

        // 用集合存储砍价用户信息
        ArrayList<UserInfo> kanchaUsers = new ArrayList<>();

        // 模拟砍价过程
        for (int i = 0; i < THRESHOLD; i++) {
            displayKanchaInfo(userToBeKan, kanchaUsers);
            // 随机生成砍价金额（整数）
            int kanchaAmount = random.nextInt(20) + 1;
            ;

            // 添加砍价用户信息到集合
            System.out.println("请输入砍价人：");
            String name = sc.next();
            UserInfo user = new UserInfo(name, kanchaAmount);
            kanchaUsers.add(user);
            // 减少被砍价用户的金额
            userToBeKan.reduceAmount(kanchaAmount);


            // 如果砍价金额为0，砍价成功，结束循环
            if (userToBeKan.getCurrentAmount() == 0) {
                System.out.println("砍价成功！");
                break;
            }
        }

        // 展示砍价信息
        displayKanchaInfo(userToBeKan, kanchaUsers);
    }


    private static void displayKanchaInfo(UserInfo userToBeKan, ArrayList<UserInfo> kanchaUsers) {
        // 展示砍价信息
        System.out.println("被砍人：" + userToBeKan.getUserName());
        System.out.println("初始金额：" + userToBeKan.getOriginalAmount());
        System.out.println("剩余金额：" + userToBeKan.getCurrentAmount());
        System.out.println("砍价人数：" + kanchaUsers.size());

        System.out.println("砍价详情：");
        for (UserInfo kanchaUser : kanchaUsers) {
            System.out.println(kanchaUser.getUserName() + " 砍了 " + kanchaUser.getOriginalAmount() + "，剩余 " + userToBeKan.getCurrentAmount());
        }
    }
}
*/
