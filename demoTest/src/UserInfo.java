public class UserInfo {
    private String name;

    private int sumMoney; //总待砍价的金额

    private int bkMoney; //已砍金额



    public UserInfo() {
    }

    public UserInfo(String name, int sumMoney, int bkMoney) {
        this.name = name;
        this.sumMoney = sumMoney;
        this.bkMoney = bkMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public int getBkMoney() {
        return bkMoney;
    }

    public void setBkMoney(int bkMoney) {
        this.bkMoney = bkMoney;
    }


}
