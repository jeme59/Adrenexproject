import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // اختيار اللغة
        System.out.println("اختر اللغة / Choose language:");
        System.out.println("1 - العربية");
        System.out.println("2 - English");

        int langChoice = scan.nextInt();
        scan.nextLine(); // consume newline
        LanguageManager.setLanguage(langChoice);

        // واجهة البداية
        System.out.println(LanguageManager.get("welcome"));
        System.out.println(LanguageManager.get("new_user"));
        System.out.println(LanguageManager.get("existing_user"));
        System.out.print(LanguageManager.get("choose"));

        int option = scan.nextInt();
        scan.nextLine(); // consume newline

        if (option == 1) {
            System.out.print(LanguageManager.get("enter_email"));
            String email = scan.nextLine();
            if (!email.contains("@")) {
                if (langChoice ==1){
                    System.out.println("البريد الإلكتروني غير صالح. يجب أن يحتوي على @");
                }
                else {
                    System.out.println("Invalid email. It must contain '@'.");
                }
                return;
            }

            if (UserManager.isEmailTaken(email)) {
                System.out.println(LanguageManager.get("email_exists"));
                return;
            }

            System.out.print(LanguageManager.get("enter_password"));
            String password = scan.nextLine();

            System.out.print(LanguageManager.get("enter_days"));
            int days = scan.nextInt();
            scan.nextLine();

            System.out.print(LanguageManager.get("enter_goal"));
            String goal = scan.nextLine();

            User newUser = new User(email, password, days, goal);
            UserManager.saveUser(newUser);

            System.out.println(LanguageManager.get("account_created"));
            displayWorkoutPlan(days, goal);

        } else if (option == 2) {
            System.out.print(LanguageManager.get("enter_email"));
            String email = scan.nextLine();
            if (!email.contains("@")) {
                System.out.println("البريد الإلكتروني غير صالح. يجب أن يحتوي على @");
                System.out.println("Invalid email. It must contain '@'.");
                return;
            }
            System.out.print(LanguageManager.get("enter_password"));
            String password = scan.nextLine();

            User found = UserManager.findUser(email, password);
            if (found != null) {
                System.out.println(LanguageManager.get("login_success"));

                boolean running = true;
                while (running) {
                    System.out.println("\n" + LanguageManager.get("menu_prompt"));
                    System.out.println("1 - " + LanguageManager.get("menu_view_plan"));
                    System.out.println("2 - " + LanguageManager.get("menu_change_days"));
                    System.out.println("3 - " + LanguageManager.get("menu_change_goal"));
                    System.out.println("4 - " + LanguageManager.get("menu_delete_account"));
                    System.out.println("5 - " + LanguageManager.get("menu_logout"));

                    System.out.print(LanguageManager.get("choose"));
                    int choice = scan.nextInt();
                    scan.nextLine();

                    switch (choice) {
                        case 1:
                            displayWorkoutPlan(found.getDays(), found.getGoal());
                            break;
                        case 2:
                            System.out.print(LanguageManager.get("enter_new_days"));
                            int newDays = scan.nextInt();
                            scan.nextLine();
                            found = new User(found.getEmail(), found.getPassword(), newDays, found.getGoal());
                            UserManager.updateUser(found);
                            System.out.println(LanguageManager.get("days_updated"));
                            break;
                        case 3:
                            System.out.print(LanguageManager.get("enter_new_goal"));
                            String newGoal = scan.nextLine();
                            found = new User(found.getEmail(), found.getPassword(), found.getDays(), newGoal);
                            UserManager.updateUser(found);
                            System.out.println(LanguageManager.get("goal_updated"));
                            break;
                        case 4:
                            UserManager.deleteUser(found);
                            System.out.println(LanguageManager.get("account_deleted"));
                            running = false;
                            break;
                        case 5:
                            System.out.println(LanguageManager.get("logged_out"));
                            running = false;
                            break;
                        default:
                            System.out.println(LanguageManager.get("invalid_option"));
                    }
                }
            } else {
                System.out.println(LanguageManager.get("login_fail"));
            }
        } else {
            System.out.println(LanguageManager.get("invalid_option"));
        }
    }

    public static void displayWorkoutPlan(int days, String goal) {
        List<String> plan = WorkoutGenerator.generateWorkout(days, goal);
        System.out.println("\n" + LanguageManager.get("plan_title"));
        for (String day : plan) {
            System.out.println(day);
        }
    }
}
