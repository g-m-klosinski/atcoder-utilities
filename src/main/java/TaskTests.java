import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskTests {
    private final List<String[]> tests = new ArrayList<>();
    private final String[] taskCoordinates;

    public TaskTests(String[] coordinates) throws Exception {
        taskCoordinates = coordinates;

        final String taskUrl = TaskUrl.makeTaskUrl(coordinates);

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

    public void dump() throws IOException {
        final String prefix = String.format(
                "atcoder-%s%s_%s",
                taskCoordinates[0],
                taskCoordinates[1],
                taskCoordinates[2]
        );
        final Path directory = Files.createTempDirectory(prefix);

        for (int i = 0; i < tests.size(); i++) {
            Files.writeString(
                    Path.of(directory.toString(), (i + 1) + ".in"),
                    tests.get(i)[0]
            );
            Files.writeString(
                    Path.of(directory.toString(), (i + 1) + ".out"),
                    tests.get(i)[1]
            );
        }
    }
} 
