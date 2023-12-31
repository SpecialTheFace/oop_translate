package Movie;

public class MovieOperator {
    // 电影有多部,而每部电影都是一个 Movie 对象
    // 所以这里需要一个可以存放 Movie 对象的数组，也就是 Movie 类型的数组
    private Movie[] movies;

    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    /**
     * 展示系统中全部电影的信息
     */
    public void printAllMovies() {
        System.out.println("-----系统全部电影信息如下：-------");
        for (int i = 0; i < movies.length; i++) {
            // 循环遍历并打印
            Movie m = movies[i];
            System.out.println("编号：" + m.getId());
            System.out.println("名称：" + m.getName());
            System.out.println("价格：" + m.getPrice());
            System.out.println("------------------------");
        }
    }

    /**
     * 根据电影的编号查询出该电影的详细信息并展示
     */
    public void searchMovieById(int id) {
        for (int i = 0; i < movies.length; i++) {
            Movie m = movies[i];
            if (m.getId() == id) {
                // 说明电影已找到
                System.out.println("该电影详情如下：");
                System.out.println("编号：" + m.getId());
                System.out.println("名称：" + m.getName());
                System.out.println("价格：" + m.getPrice());
                System.out.println("得分：" + m.getScore());
                System.out.println("导演：" + m.getDirector());
                System.out.println("主演：" + m.getActor());
                System.out.println("其他信息：" + m.getInfo());
                return; // 已经找到了电影信息，没有必要再执行了
            }
        }
        System.out.println("没有该电影信息~");
    }
}
