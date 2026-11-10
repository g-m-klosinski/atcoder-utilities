import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTests {
    public List<String[]> tests = new ArrayList<>();

    public TaskTests(String taskUrl) throws IOException {
      final Document document = Jsoup.connect(taskUrl).get();

      final String testPattern =
              "h3:contains(Sample %s) + pre";

      final Elements inputBlocks = document.select(
              String.format(testPattern, "Input")
      );
      final Elements outputBlocks = document.select(
              String.format(testPattern, "Output")
      );

      for (int i = 0; i < inputBlocks.size(); i++) {
        tests.add(
                new String[]{
                        inputBlocks.get(i).text(),
                        outputBlocks.get(i).text()
                });
      }
    }

    public void dump() {
    }
} 
