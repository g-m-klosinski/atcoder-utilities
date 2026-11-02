import java.util.Optional;

public class App {
  public static void main(String[] args) {
    Optional<String> errorMessage = TaskUrl.checkTaskValidity(args);

    if (errorMessage.isPresent()) {
      System.out.println(errorMessage.get());
      return;
    }
    
    var taskUrl = TaskUrl.makeTaskUrl(args);
    var tests = new TaskTests(taskUrl); 

    tests.dump();
  }
}
