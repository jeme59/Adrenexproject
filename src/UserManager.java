import java.io.*;
import java.util.*;

public class UserManager {
    private static final String FILE_NAME = "users.txt";

    // حفظ مستخدم جديد في الملف
    public static void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // قراءة جميع المستخدمين
    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String email = parts[0];
                    String password = parts[1];
                    int days = Integer.parseInt(parts[2]);
                    String goal = parts[3];
                    users.add(new User(email, password, days, goal));
                }

            }
        } catch (IOException e) {
            System.out.println("ملف المستخدمين غير موجود، سيتم إنشاؤه لاحقًا.");
        }
        return users;
    }

    // التأكد هل الإيميل مسجل مسبقًا
    public static boolean isEmailTaken(String email) {
        for (User user : loadUsers()) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    // البحث عن مستخدم لتسجيل الدخول
    public static User findUser(String email, String password) {
        for (User user : loadUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public static void updateUser(User updatedUser) {
        List<User> users = loadUsers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                if (user.getEmail().equals(updatedUser.getEmail())) {
                    writer.write(updatedUser.toString());
                } else {
                    writer.write(user.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(User userToDelete) {
        List<User> users = loadUsers();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                if (!user.getEmail().equals(userToDelete.getEmail())) {
                    writer.write(user.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
