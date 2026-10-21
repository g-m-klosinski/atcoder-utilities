import java.util.Optional;

public class App {
  public final static String usageInstruction = """
    Usage: atcoder-utilities <contest type abbreviation> <number> <task letter>

    For example: atcoder-utilities abc 150 g""";

  public static void main(String[] args) {
    Optional<String> errorMessage = checkTaskValidity(args);

    if (errorMessage.isPresent()) {
      System.out.println(errorMessage.get());
      return;
    }
    
    var taskUrl = makeTaskUrl(args);
    var tests = new TaskTests(taskUrl); 

    tests.dump();
  }

  public static Optional<String> checkTaskValidity(String[] coordinates) {
    // todo: develop this stub
    return Optional.empty();
  }

  public static String makeTaskUrl(String[] coordinates) {
    // todo: develop this stub
    return "";
  }
}
