
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WorkoutGenerator {

    public static List<String> generateWorkout(int days, String goal) {
        List<String> plan = new ArrayList<>();
        plan.add("الهدف: " + goal);

        Map<String, String> workoutLinks = new LinkedHashMap<>();

        switch (days) {
            case 1:
                workoutLinks.put("Full Body", "https://example.com/fullbody");
                break;
            case 2:
                workoutLinks.put("Upper Body", "https://example.com/upper");
                workoutLinks.put("Lower Body", "https://example.com/lower");
                break;
            case 3:
                workoutLinks.put("Push", "https://youtube.com/shorts/JCIfrvMhbTg");
                workoutLinks.put("Pull", "https://youtube.com/shorts/4Ih7M2jM4nw?feature=share");
                workoutLinks.put("Legs", "https://example.com/legs");
                break;
            case 4:
                workoutLinks.put("Legs", "https://example.com/legs");
                workoutLinks.put("Chest", "https://example.com/chest");
                workoutLinks.put("Back", "https://example.com/back");
                workoutLinks.put("Shoulders", "https://example.com/shoulders");
                break;
            case 5:
                workoutLinks.put("Chest & Back", "https://example.com/chest-back");
                workoutLinks.put("Legs", "https://example.com/legs");
                workoutLinks.put("Shoulder & Arms", "https://example.com/shoulder-arms");
                workoutLinks.put("Rest", "https://example.com/rest");
                workoutLinks.put("Lower Body", "https://example.com/lower");
                workoutLinks.put("Upper Body", "https://example.com/upper");
                break;
            case 6:
                workoutLinks.put("Push", "https://youtube.com/shorts/JCIfrvMhbTg");
                workoutLinks.put("Pull", "https://youtube.com/shorts/4Ih7M2jM4nw?feature=share");
                workoutLinks.put("Legs", "https://example.com/legs");
                workoutLinks.put("Rest", "https://example.com/rest");
                workoutLinks.put("Upper Body", "https://example.com/upper");
                workoutLinks.put("Lower Body", "https://example.com/lower");
                break;
            case 7:
                workoutLinks.put("Push", "https://youtube.com/shorts/JCIfrvMhbTg");
                workoutLinks.put("Pull", "https://youtube.com/shorts/4Ih7M2jM4nw?feature=share");
                workoutLinks.put("Legs", "https://example.com/legs");
                workoutLinks.put("Chest", "https://example.com/chest");
                workoutLinks.put("Back", "https://example.com/back");
                workoutLinks.put("Shoulders", "https://example.com/shoulders");
                workoutLinks.put("Cardio + Abs", "https://example.com/cardio-abs");
                break;
            default:
                plan.add("الرجاء إدخال عدد أيام بين 1 و 7.");
                return plan;
        }

        int day = 1;
        for (Map.Entry<String, String> entry : workoutLinks.entrySet()) {
            plan.add("Day " + day + ": " + entry.getKey() + " - " + entry.getValue());
            day++;
        }

        return plan;
    }
}
