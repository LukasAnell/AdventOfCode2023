package dayEight;

import Utils.Reader;

import java.util.*;

public class AoC8 {
    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/dayEight/Day8TestInputPart2.txt");
        assert lines != null;

        // partOne(lines);

        System.out.println();

        partTwo(lines);
    }

    public static void partTwo(List<String> lines) {
        List<String> startingNodes = new ArrayList<>();
        Map<String, String[]> nodeMap = new HashMap<>();
        List<String> instructions = lines.get(0).chars().mapToObj(c -> (char) c).map(String::valueOf).toList();

        for(int i = 2; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] splitLine = line.split("=");
            String key = splitLine[0].trim();
            String lookup = splitLine[1].trim();

            String[] value = Arrays.stream(lookup.split(", ")).map(s -> s.replace("(", "").replace(")", "")).toArray(String[]::new);

            nodeMap.put(key, value);

            if(key.endsWith("A")) {
                startingNodes.add(key);
            }
        }

        int steps = 0;
        for(String startingNode : startingNodes) {
            String key = startingNode;
            String[] values = nodeMap.get(key);
            String currentInstruction = instructions.get(0);
            int instructionStep = 0;
            for (int i = 0; !(values[0].endsWith("Z") || values[1].endsWith("Z")); i++) {
                if(key.endsWith("Z")) {
                    currentInstruction = instructions.get(instructionStep);
                    instructionStep++;
                }
                String[] node = nodeMap.get(key);
                key = currentInstruction.equals("L") ? node[0] : node[1];

                System.out.println(key);

                if(i == instructions.size() - 1) {
                    i = -1;
                }
                steps++;
            }
        }
    }

    public static void partOne(List<String> lines) {
        List<String> instructions = lines.get(0).chars().mapToObj(c -> (char) c).map(String::valueOf).toList();
        Map<String, String[]> nodeMap = new HashMap<>();

        for(int i = 2; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] splitLine = line.split("=");
            String key = splitLine[0].trim();
            String lookup = splitLine[1].trim();

            String[] value = Arrays.stream(lookup.split(", ")).map(s -> s.replace("(", "").replace(")", "")).toArray(String[]::new);

            nodeMap.put(key, value);
        }

        int steps = 0;
        String key = "AAA";
        for (int i = 0; !key.equals("ZZZ"); i++) {
            String currentInstruction = instructions.get(i);
            String[] node = nodeMap.get(key);
            key = currentInstruction.equals("L") ? node[0] : node[1];

            if(i == instructions.size() - 1) {
                i = -1;
            }
            steps++;
        }
        System.out.println(steps);
    }
}
