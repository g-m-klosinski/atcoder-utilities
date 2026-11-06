import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class TaskTests {
  public List<String[]> tests;

  public TaskTests(String taskUrl) throws IOException {
    Document document = Jsoup.connect(taskUrl).get();
    System.out.println("HTML document parsed.");
  }

  public void dump() {}
} 
