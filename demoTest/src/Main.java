import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// TeacherManagement
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rm = new Random();
        // 将砍价的用户装入集合中
        ArrayList<KUser> lists = new ArrayList<>();
        //模拟一个被砍用户
        UserInfo bkUser = new UserInfo("光头强", 80, 0);
        while (true) {
            // 还应再砍的金额
            int sMoney = bkUser.getSumMoney() - bkUser.getBkMoney();
            if (sMoney <= 0) {
                System.out.println("砍价结束.....");
                break;
            }
            //图形界面模拟
            System.out.println("****************************************");
            System.out.println("****************************************");
            System.out.println("已砍" + bkUser.getBkMoney() + ",还差" + sMoney + "元");
            System.out.println("------------------>砍价帮<-------------------");

            // 展示已经参与砍价的用户
            for (KUser Kuser : lists) {
                System.out.println(Kuser.getName() + "-----砍掉" + Kuser.getkMoney());
            }

            System.out.println("是否砍价(输入砍价得用户名):");
            //获得砍价得用户名
            String name = scanner.next();
            //判断是否砍过了。
            boolean flag = false;
            for (KUser Kuser : lists) {
                if (name.equals(Kuser.getName())) {
                    //这个用户已经砍过价格了
                    System.out.println("已经砍过价格了");
                    flag = true;
                }
            }
            //这个用户已经砍过价格了 进入到下一次砍价
            if (flag) {
                //进入到下一次砍价
                continue;
            }
            //如果砍价得人到10了。那么就直接砍完
            int kMoney;
            if (lists.size() + 1 == 10) {
                //如果判断成功，代表此人就是最后一个
                // 那么应被砍用户剩余的钱 直接当做当前用户的 应砍价格
                kMoney = sMoney;
            } else {
                //4.生成砍价得金额  生成得金额，是从0开始，所以保证不能出现0得问题
                kMoney = rm.nextInt(sMoney) + 1;
            }
            // 更新被砍用户的砍价总额
            bkUser.setBkMoney(bkUser.getBkMoney() + kMoney);
            // 将当前砍价用户加入 ArrayList 集合中进行存储
            lists.add(new KUser(name, kMoney));
            System.out.println("砍价成功:" + name + "为" + bkUser.getName() + "砍掉" + kMoney + "元");
        }
    }
}