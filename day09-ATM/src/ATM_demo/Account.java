package ATM_demo;

/**
 * 用户类
 */
public class Account {
    private String cardId; //卡号
    private String userName; //用户名
    private char sex; //性别
    private String passWord;//密码
    private double money; //余额
    private double limit; // 限额

    public Account() {
    }

    public Account(String cardId, String userName, char sex, String passWord, double money, double limit) {
        this.cardId = cardId;
        this.userName = userName;
        this.sex = sex;
        this.passWord = passWord;
        this.money = money;
        this.limit = limit;
    }

    /**
     * 获取
     *
     * @return cardId
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置
     *
     * @param cardId
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取
     *
     * @return userName
     */
    public String getUserName() {
        return userName + (sex == '男' ? "先生" : "女士");
    }

    /**
     * 设置
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public char getSex() {
        return sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(char sex) {
        this.sex = sex;
    }

    /**
     * 获取
     *
     * @return passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置
     *
     * @param passWord
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取
     *
     * @return money
     */
    public double getMoney() {
        return money;
    }

    /**
     * 设置
     *
     * @param money
     */
    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 获取
     *
     * @return limit
     */
    public double getLimit() {
        return limit;
    }

    /**
     * 设置
     *
     * @param limit
     */
    public void setLimit(double limit) {
        this.limit = limit;
    }

}
