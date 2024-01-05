package Management;

import java.util.Scanner;

public class TeacherManagementSystem {
    // 定义老师数组，最多存储5名老师信息
    private static Teacher[] teachers = new Teacher[5];
    // 记录当前老师数量
    private static int teacherCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 展示欢迎页面
            showMenu();

            // 获取用户的选择
            int choice = scanner.nextInt();

            // 根据用户的选择执行对应的操作
            switch (choice) {
                case 1:
                    addTeacher(scanner);
                    break;
                case 2:
                    deleteTeacher(scanner);
                    break;
                case 3:
                    modifyTeacher(scanner);
                    break;
                case 4:
                    queryTeachers();
                    break;
                case 5:
                    System.out.println("感谢使用，程序结束！");
                    return;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    // 展示欢迎页面
    private static void showMenu() {
        System.out.println("========== 教师管理系统 ==========");
        System.out.println("1. 添加老师");
        System.out.println("2. 删除老师");
        System.out.println("3. 修改老师");
        System.out.println("4. 查询老师");
        System.out.println("5. 退出");
        System.out.println("请输入您的选择：");
    }

    // 添加老师
    private static void addTeacher(Scanner scanner) {
        if (teacherCount < 5) {
            System.out.println("请输入老师信息：(id name age birthday)");
            System.out.println("请输入 ID：");
            int id = scanner.nextInt();
            System.out.println("请输入 name：");
            String name = scanner.next();
            System.out.println("请输入 age：");
            int age = scanner.nextInt();
            System.out.println("请输入 birthday：");
            String birthday = scanner.next();

            // 检查是否存在相同id的老师
            if (isIdExist(id)) {
                System.out.println("已存在相同id的老师，添加失败！");
                return;
            }

            // 创建老师对象并存入数组
            teachers[teacherCount++] = new Teacher(id, name, age, birthday);
            System.out.println("添加成功！");
        } else {
            System.out.println("老师信息已满，无法添加！");
        }
    }

    // 删除老师
    private static void deleteTeacher(Scanner scanner) {
        System.out.println("请输入要删除老师的id：");
        int id = scanner.nextInt();

        // 检查数组中是否存在此 ID,存在就返回其在数组中数组中的索引
        int index = findTeacherIndexById(id);

        if (index != -1) {
            // 找到老师，进行删除操作
            for (int i = index; i < teacherCount - 1; i++) {
                // 在 index 处后续元素前移
                teachers[i] = teachers[i + 1];
            }
            teachers[teacherCount - 1] = null; // 将最后一个位置置为null
            // 跟新老师人数
            teacherCount--;

            System.out.println("删除成功！");
        } else {
            System.out.println("未找到对应id的老师，删除失败！");
        }
    }

    // 修改老师信息
    private static void modifyTeacher(Scanner scanner) {
        System.out.println("请输入要修改老师的id：");
        int id = scanner.nextInt();

        int index = findTeacherIndexById(id);

        if (index != -1) {
            // 找到老师，进行修改操作
            System.out.println("老师已找到");
            System.out.println("请输入修改后的老师信息：(name age birthday)");
            System.out.println("请输入 name：");
            String name = scanner.next();
            System.out.println("请输入 age：");
            int age = scanner.nextInt();
            System.out.println("请输入 birthday：");
            String birthday = scanner.next();

            teachers[index].setName(name);
            teachers[index].setAge(age);
            teachers[index].setBirthday(birthday);

            System.out.println("修改成功！");
        } else {
            System.out.println("未找到对应id的老师，修改失败！");
        }
    }

    // 查询所有老师信息
    private static void queryTeachers() {
        if (teacherCount == 0) {
            System.out.println("改系统中暂无老师的任何信息~~");
            return;
        }
        System.out.println("所有老师信息如下：");
        for (int i = 0; i < teacherCount; i++) {
            System.out.println(teachers[i].toString());
        }
    }

    // 根据id查找老师在数组中的索引
    private static int findTeacherIndexById(int id) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getId() == id) {
                return i; // 找到了对应id的老师，返回索引
            }
        }
        return -1; // 未找到对应id的老师
    }

    // 检查是否存在相同id的老师
    private static boolean isIdExist(int id) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getId() == id) {
                // 存在相同id的老师
                return true;
            }
        }
        // 不存在相同id的老师
        return false;
    }
}
