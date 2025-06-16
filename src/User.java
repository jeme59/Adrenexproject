public class User {
    private String email;
    private String password;
    private int days;
    private String goal;

    public User(String email, String password, int days, String goal) {
        this.email = email;
        this.password = password;
        this.days = days;
        this.goal = goal;
    }

    public String getEmail() {
        return email; }
    public String getPassword() {
        return password; }
    public int getDays() {
        return days; }
    public String getGoal() {
        return goal; }

    @Override
    public String toString() {
        return email + "," + password + "," + days + "," + goal;
    }
}
