package dayFive;


import java.math.BigInteger;
import java.util.*;
import Utils.Reader;

public class AoC5 {
    public static List<List<BigInteger[]>> mappings = new ArrayList<>();
    public static List<BigInteger> seeds = new ArrayList<>();

    public static void main(String[] args) {
        List<String> lines = Reader.readFromFile("src/dayFive/Day5TestInput.txt");
        assert lines != null;

        makeMappings(lines);
        partOne();
        // 174137457 answer

        System.out.println();

        partTwo();
        // 258258278 too high
    }

    public static void partTwo() {
        Map<BigInteger, BigInteger[]> seedRangeMap = new HashMap<>();
        List<BigInteger[]> seedRanges = new ArrayList<>();
        for(int i = 0; i < seeds.size() - 1; i += 2) {
            BigInteger currentSeed = seeds.get(i);
            BigInteger[] range = new BigInteger[]{currentSeed, currentSeed.add(seeds.get(i + 1))};
            seedRanges.add(range);
            seedRangeMap.put(currentSeed, range);
            seedRangeMap.put(currentSeed.add(seeds.get(i + 1)), range);
        }

        BigInteger minSeed = BigInteger.valueOf(Integer.MAX_VALUE);
        for(BigInteger[] range: seedRanges) {
            minSeed = minSeed.min(checkRangeBounds(range));
        }
        System.out.println(minSeed);
        System.out.println(seedRangeMap);

        BigInteger minLocation = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        BigInteger[] range = seedRangeMap.get(minSeed);
        System.out.println(Arrays.toString(range));
        for(BigInteger i = range[0]; i.compareTo(range[1]) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger seed = i;
            for(List<BigInteger[]> map: mappings) {
                for(BigInteger[] mapping: map) {
                    BigInteger destinationStart = mapping[0];
                    BigInteger sourceStart = mapping[1];
                    BigInteger length = mapping[2];
                    if (seed.compareTo(sourceStart) >= 0 && seed.compareTo(sourceStart.add(length)) < 0) {
                        seed = destinationStart.add(seed.subtract(sourceStart));
                        break;
                    }
                }
            }
            minLocation = minLocation.min(seed);
        }
        System.out.println(minLocation);
    }

    public static BigInteger checkRangeBounds(BigInteger[] range) {
        BigInteger minSeed = range[0];
        for(BigInteger seed : range) {
            for(List<BigInteger[]> map: mappings) {
                for(BigInteger[] mapping: map) {
                    BigInteger destinationStart = mapping[0];
                    BigInteger sourceStart = mapping[1];
                    BigInteger length = mapping[2];
                    if(seed.compareTo(sourceStart) >= 0 && seed.compareTo(sourceStart.add(length)) < 0) {
                        seed = destinationStart.add(seed.subtract(sourceStart));
                        break;
                    }
                }
            }
            minSeed = minSeed.min(seed);
        }
        return minSeed;
    }

    public static void partOne() {
        BigInteger minLocation = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        for(BigInteger seed: seeds) {
            BigInteger location = seed;
            for(List<BigInteger[]> map: mappings) {
                for(BigInteger[] mapping: map) {
                    BigInteger destinationStart = mapping[0];
                    BigInteger sourceStart = mapping[1];
                    BigInteger length = mapping[2];
                    if (location.compareTo(sourceStart) >= 0 && location.compareTo(sourceStart.add(length)) < 0) {
                        location = destinationStart.add(location.subtract(sourceStart));
                        break;
                    }
                }
            }
            minLocation = minLocation.min(location);
        }

        System.out.println(minLocation);
    }

    public static void makeMappings(List<String> lines) {
        for(int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("seeds:")) {
                String[] seedStrings = line.split(":")[1].trim().split(" ");
                for (String seedString: seedStrings) {
                    seeds.add(new BigInteger(seedString));
                }
            } else if (line.contains("map:")) {
                i++;
                List<BigInteger[]> map = new ArrayList<>();
                while (i < lines.size() && !lines.get(i).isEmpty()) {
                    String[] parts = lines.get(i).split(" ");
                    BigInteger destinationStart = new BigInteger(parts[0]);
                    BigInteger sourceStart = new BigInteger(parts[1]);
                    BigInteger length = new BigInteger(parts[2]);
                    map.add(new BigInteger[]{destinationStart, sourceStart, length});
                    i++;
                }
                mappings.add(map);
            }
        }
    }
}