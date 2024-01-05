/***
 * 砍价的用户
 */
public class KUser {
    private String name;
    private int kMoney;

    public KUser(String name, int kMoney) {
        this.name = name;
        this.kMoney = kMoney;
    }

    public KUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getkMoney() {
        return kMoney;
    }

    public void setkMoney(int kMoney) {
        this.kMoney = kMoney;
    }


}
