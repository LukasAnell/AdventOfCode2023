package daySix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import Utils.Reader;
public class AoC6 {
    public static List<Long> times = new ArrayList<>();
    public static List<Long> distances = new ArrayList<>();

    public static void main(String[] args) {
        List<String> lineList = Reader.readFromFile("src/daySix/Day6Input.txt");
        assert lineList != null;

        parseFile(lineList);
        numberOfWays();
        // 138915 answer

        System.out.println();


        partTwo();
        numberOfWays();
    }

    public static void partTwo() {
        String timesConcat = times.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
        String distancesConcat = distances.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));

        times = new ArrayList<>();
        times.add(Long.valueOf(timesConcat));
        distances = new ArrayList<>();
        distances.add(Long.valueOf(distancesConcat));
    }

    public static void numberOfWays() {
        long totalWays = 1;
        for (int i = 0; i < times.size(); i++) {
            long time = times.get(i);
            long distance = distances.get(i);
            int ways = 0;
            for (int j = 0; j < time; j++) {
                long possibleDistance = j * (time - j);
                if (possibleDistance > distance) {
                    ways++;
                }
            }
            totalWays *= ways;
        }

        System.out.println(totalWays);
    }

    public static void parseFile(List<String> file) {
        String timeLine = file.get(0);
        String distanceLine = file.get(1);

        times = Arrays.stream(timeLine.split(":")[1].split(" "))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());

        distances = Arrays.stream(distanceLine.split(":")[1].split(" "))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
