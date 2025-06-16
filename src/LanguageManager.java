public class LanguageManager {
    private static int lang = 1; // 1 = Arabic (default), 2 = English

    public static void setLanguage(int choice) {
        lang = choice;
    }

    public static String get(String key) {
        if (lang == 1) {
            // اللغة العربية
            switch (key) {
                case "welcome": return "أهلاً بك في مدرب اللياقة 💪";
                case "new_user": return "1 - مستخدم جديد";
                case "existing_user": return "2 - تسجيل دخول";
                case "choose": return "اختر: ";
                case "enter_email": return "أدخل بريدك الإلكتروني: ";
                case "email_exists": return "هذا البريد مستخدم بالفعل. حاول بريدًا آخر.";
                case "enter_password": return "أدخل كلمة السر: ";
                case "enter_days": return "كم عدد أيام التمرين في الأسبوع؟ (1-7): ";
                case "enter_goal": return "ما هو هدفك؟ (عضل / تنحيف / لياقة): ";
                case "account_created": return "تم إنشاء حسابك بنجاح 🎉";
                case "login_success": return "تم تسجيل الدخول بنجاح 🎯";
                case "login_fail": return "البريد الإلكتروني أو كلمة السر غير صحيحة ❌";
                case "plan_title": return "📅 جدولك التدريبي:";
                case "menu_prompt": return "ماذا تريد أن تفعل؟";
                case "menu_view_plan": return "عرض الجدول";
                case "menu_change_days": return "تغيير عدد أيام التمرين";
                case "menu_change_goal": return "تغيير الهدف";
                case "menu_delete_account": return "حذف الحساب";
                case "menu_logout": return "تسجيل الخروج";
                case "enter_new_days": return "أدخل عدد الأيام الجديد (1-7): ";
                case "enter_new_goal": return "أدخل الهدف الجديد (عضل / تنحيف / لياقة): ";
                case "days_updated": return "تم تحديث عدد الأيام ✅";
                case "goal_updated": return "تم تحديث الهدف ✅";
                case "account_deleted": return "تم حذف الحساب بنجاح 🗑️";
                case "logged_out": return "تم تسجيل الخروج. 👋";
                case "invalid_option": return "خيار غير صحيح ❌";
            }
        } else {
            // اللغة الإنجليزية
            switch (key) {
                case "welcome": return "Welcome to your personal fitness coach 💪";
                case "new_user": return "1 - New User";
                case "existing_user": return "2 - Existing User";
                case "choose": return "Choose: ";
                case "enter_email": return "Enter your email: ";
                case "email_exists": return "This email is already used. Try another.";
                case "enter_password": return "Enter your password: ";
                case "enter_days": return "How many workout days per week? (1-7): ";
                case "enter_goal": return "What is your goal? (Muscle / Fat Loss / Fitness): ";
                case "account_created": return "Account created successfully 🎉";
                case "login_success": return "Login successful 🎯";
                case "login_fail": return "Incorrect email or password ❌";
                case "plan_title": return "📅 Your Weekly Plan:";
                case "menu_prompt": return "What do you want to do?";
                case "menu_view_plan": return "View Plan";
                case "menu_change_days": return "Change Number of Days";
                case "menu_change_goal": return "Change Goal";
                case "menu_delete_account": return "Delete Account";
                case "menu_logout": return "Log Out";
                case "enter_new_days": return "Enter new number of workout days (1-7): ";
                case "enter_new_goal": return "Enter your new goal (Muscle / Fat Loss / Fitness): ";
                case "days_updated": return "Workout days updated ✅";
                case "goal_updated": return "Goal updated ✅";
                case "account_deleted": return "Account deleted successfully 🗑️";
                case "logged_out": return "Logged out 👋";
                case "invalid_option": return "Invalid option ❌";
            }
        }

        // في حال مفتاح غير معروف
        return key;
    }
}
