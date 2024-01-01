package ArrayListDemo2;

public class Food {
    private String name;
    private double originalPrice;
    private double specialPrice;
    private String info;

    public Food() {
    }

    public Food(String name, double originalPrice, double specialPrice, String info) {
        this.name = name;
        this.originalPrice = originalPrice;
        this.specialPrice = specialPrice;
        this.info = info;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return originalPrice
     */
    public double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置
     *
     * @param originalPrice
     */
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取
     *
     * @return specialPrice
     */
    public double getSpecialPrice() {
        return specialPrice;
    }

    /**
     * 设置
     *
     * @param specialPrice
     */
    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    /**
     * 获取
     *
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置
     *
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

}
