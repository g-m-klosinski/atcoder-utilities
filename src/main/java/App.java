import java.util.Optional;

public class App {
  public final static String usageInstruction = """
    Usage: atcoder-utilities <contest type abbreviation> <number> <task letter>

    For example: atcoder-utilities abc 150 g""";

  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println(usageInstruction);
      return;
    }
    
    var taskUrl = makeTaskUrl(args);

    if (!taskUrl.isPresent()) {
      System.out.println(usageInstruction);
      return;
    }
    
    var tests = new TaskTests(taskUrl.get()); 

    tests.dump();
  }

  public static Optional<String> makeTaskUrl(String[] coordinates) {
    return Optional.empty();
  }
}
