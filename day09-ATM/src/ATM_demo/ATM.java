package ATM_demo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Scanner sc = new Scanner(System.in);
    // 记录当前登录的用户
    private Account loginAcc;

    /**
     * 启动
     */
    public void start() {
        while (true) {
            System.out.println("===欢迎您进入到了ATM系统===");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    // 用户登录
                    System.out.println("进入登录功能");
                    login();
                    break;
                case 2:
                    // 用户开户
                    System.out.println("进入开户功能");
                    createAccount();
                    break;
                default:
                    System.out.println("没有该操作~~");
            }
        }
    }

    /**
     * 开户
     */
    private void createAccount() {
        System.out.println("==系统开户操作==");
        // 新建用户 Account 对象
        Account account = new Account();

        // 账户名录入
        System.out.println("请您输入您的账户名称：");
        String name = sc.next();
        account.setUserName(name);

        // 性别录入
        while (true) {
            System.out.println("请您输入您的性别：");
            char sex = sc.next().charAt(0);
            // 确保用户所输入的性别在正确范围之内
            if (sex == '男' || sex == '女') {
                // 范围正确
                account.setSex(sex);
                break;
            } else {
                System.out.println("您输入的性别有误~只能是男或者女~");
            }
        }

        // 密码设置
        while (true) {
            System.out.println("请您输入您的账户密码：");
            String password = sc.next();
            System.out.println("请您输入您的确认密码：");
            String okPassword = sc.next();
            // 判断密码是否相同
            if (okPassword.equals(password)) {
                // 验证通过
                account.setPassWord(okPassword);
                break;
            } else {
                System.out.println("您输入的2次密码不一致，请您确认~~");
            }
        }

        System.out.println("请您输入您的取现额度：");
        double limit = sc.nextDouble();
        account.setLimit(limit);

        // 我们需要为这个账户生成一个卡号（由系统自动生成。8位数字表示，不能与其他账户的卡号重复）
        String cardId = createCardId();
        account.setCardId(cardId);

        // 将当前用户存入 ArrayList
        accounts.add(account);
        System.out.println("恭喜您，" + account.getUserName() + "开户成功，您的卡号是：" + account.getCardId());
    }

    /**
     * @param cardId 用户的卡号
     * @return 返回和卡号与之对应的用户对象，如果没有则返回 null
     */
    private Account getAccountByCardId(String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getCardId().equals(cardId)) {
                // 说明用户存在
                return account;
            }
        }
        // 遍历结束后如果没有找到说明用户不存在，返回 null
        return null;
    }

    /**
     * @return 制作一个 cardId
     */
    private String createCardId() {
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId += data;
            }
            Account account = getAccountByCardId(cardId);
            if (account == null) {
                // 说明这个用户不存在，也就是卡号唯一
                return cardId;
            }
        }
    }

    /**
     * 用户登录
     */
    private void login() {
        System.out.println("==系统登录==");
        // 判断系统中是否存在账户
        if (accounts.size() == 0) {
            // 说明还没有账户，此时需要退出登录，先去开户
            System.out.println("当前系统中无任何账户，请先开户再来登录~~");
            return; // 跳出登录操作。
        }

        // 系统中存在账户
        while (true) {
            System.out.println("请您输入您的登录卡号：");
            String cardId = sc.next();
            // 调用 getAccountByCardId 方法查询此账户是否存在
            Account account = getAccountByCardId(cardId);
            if (account == null) {
                // 账户不存在 ,重新输入
                System.out.println("您输入的登录卡号不存在，请确认~~");
            } else {
                // 存在此账户
                loginAcc = account;
                while (true) {
                    System.out.println("请您输入登录密码：");
                    String password = sc.next();
                    if (password.equals(account.getPassWord())) {
                        // 说明密码正确
                        System.out.println("恭喜您，" + account.getUserName() + "成功登录了系统，您的卡号是：" + account.getCardId());
                        // 展示登录后系统操作界面
                        showUserCommand();
                        return;
                    } else {
                        // 密码错误，重新输入
                        System.out.println("您输入的密码不正确，请确认~~");
                    }
                }
            }
        }
    }

    /**
     * 展示登录后系统操作界面
     */
    private void showUserCommand() {
        while (true) {
            System.out.println(loginAcc.getUserName() + "您可以选择如下功能进行账户的处理====");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、密码修改");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showLoginAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    drawMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    updatePassWord();
                    return;// 跳出并结束当前方法
                case 6:
                    System.out.println(loginAcc.getUserName() + "您退出系统成功！");
                    return; // 跳出并结束当前方法
                case 7:
                    if (deleteAccount()) {
                        return;
                    }
                    break;
                default:
                    System.out.println("您当前选择的操作是不存在的，请确认~~");
            }
        }
    }

    /**
     * 密码修改
     */
    private void updatePassWord() {
        System.out.println("==账户密码修改操作==");
        while (true) {
            // 1、提醒用户认证当前密码
            System.out.println("请您输入当前账户的密码：");
            String passWord = sc.next();

            // 2、认证当前密码是否正确啊
            if (loginAcc.getPassWord().equals(passWord)) {
                // 认证通过
                while (true) {
                    // 3、真正开始修改密码了
                    System.out.println("请您输入新密码：");
                    String newPassWord = sc.next();

                    System.out.println("请您再次输入密码：");
                    String okPassWord = sc.next();

                    // 4、判断2次 密码是否一致
                    if (okPassWord.equals(newPassWord)) {
                        // 可以真正开始修改密码了
                        loginAcc.setPassWord(okPassWord);
                        System.out.println("恭喜您，您的密码修改成功~~~");
                        return;
                    } else {
                        System.out.println("您输入的2次密码不一致~~");
                    }
                }
            } else {
                System.out.println("您当前输入的密码不正确~~");
            }
        }
    }

    /**
     * 注销当前登录的账户
     */
    private boolean deleteAccount() {
        System.out.println("==进行销户操作==");
        // 1、问问用户是否确定要销户啊
        System.out.println("请问您确认销户吗？y/n");
        String command = sc.next();
        switch (command) {
            case "y":
                if (loginAcc.getMoney() == 0) {
                    accounts.remove(loginAcc);
                    System.out.println("您好，您的账户已经成功销户~~");
                    return true;
                } else {
                    System.out.println("对不起，您的账户中存钱金额，不允许销户~~");
                    return false;
                }
            default:
                System.out.println("好的，您的账户保留！！");
                return false;
        }
    }

    /**
     * 转账
     */
    private void transferMoney() {
        System.out.println("==用户转账==");
        // 1、判断系统中是否存在其他账户。
        if (accounts.size() < 2) {
            System.out.println("当前系统中只有你一个账户，无法为其他账户转账~~");
            return;
        }
        if (loginAcc.getMoney() == 0) {
            System.out.println("您自己都没钱，就别转了~~");
            return;
        }

        while (true) {
            System.out.println("请您输入对方的卡号：");
            String cardId = sc.next();
            Account account = getAccountByCardId(cardId);
            if (account == null) {
                System.out.println("您输入的对方的卡号不存在~~");
            } else {
                while (true) {
                    String name = "*" + account.getUserName().substring(1); // * + 马刘德华
                    System.out.println("请您输入【" + name + "】的姓氏：");
                    String preName = sc.next();
                    // 5、判断这个姓氏是否正确啊
                    if (account.getUserName().startsWith(preName)) {
                        // 认证通过了：真正转账了
                        System.out.println("请您输入转账给对方的金额：");
                        double money = sc.nextDouble();
                        if (loginAcc.getMoney() < money) {
                            System.out.println("您余额不足，无法给对方转这么多钱，最多可转：" + loginAcc.getMoney());
                        } else {
                            loginAcc.setMoney(loginAcc.getMoney() - money);
                            account.setMoney(account.getMoney() + money);
                            System.out.println("您转账成功了~~~");
                            return; // 跳出转账方法。
                        }
                    } else {
                        System.out.println("对不起，您认证的姓氏有问题~~");
                    }
                }
            }
        }

    }

    /**
     * 取款
     */
    private void drawMoney() {
        System.out.println("==取钱操作==");
        if (loginAcc.getMoney() < 100) {
            System.out.println("您的账户余额不足100元，不允许取钱~~");
            return;
        }
        while (true) {
            System.out.println("请您输入取款金额：");
            double money = sc.nextDouble();
            if (loginAcc.getMoney() >= money) {
                // 说明余额够，可以取
                if (money > loginAcc.getLimit()) {
                    System.out.println("您当前取款金额超过了每次限额，您每次最多可取：" + loginAcc.getLimit());
                } else {
                    // 不超过一次最多可存储的金额
                    loginAcc.setMoney(loginAcc.getMoney() - money);
                    System.out.println("您取款：" + money + "成功，取款后您剩余：" + loginAcc.getMoney());
                    return;
                }
            } else {
                System.out.println("余额不足，您的账户中的余额是：" + loginAcc.getMoney());
            }
        }
    }

    /**
     * 存款
     */
    private void depositMoney() {
        System.out.println("==存钱操作==");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();

        // 更新当前登录的账户的余额。
        loginAcc.setMoney(loginAcc.getMoney() + money);
        System.out.println("恭喜您，您存钱：" + money + "成功，存钱后余额是：" + loginAcc.getMoney());
    }

    /**
     * 查询当前账户
     */
    private void showLoginAccount() {
        System.out.println("==当前您的账户信息如下：==");
        System.out.println("卡号：" + loginAcc.getCardId());
        System.out.println("户主：" + loginAcc.getUserName());
        System.out.println("性别：" + loginAcc.getSex());
        System.out.println("余额：" + loginAcc.getMoney());
        System.out.println("每次取现额度：" + loginAcc.getLimit());
    }
}
