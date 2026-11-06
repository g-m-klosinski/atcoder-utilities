import java.util.Optional;

public class App {
    public static void main(String[] args) {
        try {
            var taskUrl = TaskUrl.makeTaskUrl(args);

            var tests = new TaskTests(taskUrl);
            tests.dump();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
