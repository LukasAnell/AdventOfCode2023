package dayFive;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class AoC5 {
    public static List<Integer> seeds = new ArrayList<>();
    public static List<BigInteger[]> seedToSoil = new ArrayList<>();
    public static List<BigInteger[]> soilToFertilizer = new ArrayList<>();
    public static List<BigInteger[]> fertilizerToWater = new ArrayList<>();
    public static List<BigInteger[]> waterToLight = new ArrayList<>();
    public static List<BigInteger[]> lightToTemperature = new ArrayList<>();
    public static List<BigInteger[]> temperatureToHumidity = new ArrayList<>();
    public static List<BigInteger[]> humidityToLocation = new ArrayList<>();
    public static List<String> input = new ArrayList<>();

    public static void main(String[] args) {
        Path path = Paths.get("src/dayFive/Day5Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC5::parseFile);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }
        parseMaps();
        // findLowestLocation();

        System.out.println(seeds);
        System.out.println(Arrays.deepToString(seedToSoil.toArray()));
        System.out.println(Arrays.deepToString(soilToFertilizer.toArray()));
        System.out.println(Arrays.deepToString(fertilizerToWater.toArray()));
        System.out.println(Arrays.deepToString(waterToLight.toArray()));
        System.out.println(Arrays.deepToString(lightToTemperature.toArray()));
        System.out.println(Arrays.deepToString(temperatureToHumidity.toArray()));
        System.out.println(Arrays.deepToString(humidityToLocation.toArray()));

    }

    public static void findLowestLocation() {
        BigInteger lowestLocation = findHumidityToLocation(findTemperatureToHumidity(findLightToTemperature(findWaterToLight(findFertilizerToWater(findSoilToFertilizer(findSeedToSoilNumber(BigInteger.valueOf(1132132257))))))));
        for (int seed : seeds) {
            lowestLocation = lowestLocation.min(findHumidityToLocation(findTemperatureToHumidity(findLightToTemperature(findWaterToLight(findFertilizerToWater(findSoilToFertilizer(findSeedToSoilNumber(BigInteger.valueOf(seed)))))))));
        }
        System.out.println(lowestLocation);
    }

    public static BigInteger findHumidityToLocation(BigInteger humidity) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> humidityToLocationTable = new HashMap<>();

        for (BigInteger[] bigIntegers : humidityToLocation) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            if(humidity.compareTo(destinationRangeStart) >= 0 && ) {

            }

            for (int j = 0; j < rangeLength; j++) {
                humidityToLocationTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(humidityToLocationTable.containsKey(humidity)) {
                    return humidityToLocationTable.get(humidity);
                }
            }
        }
        if(humidityToLocationTable.containsKey(humidity)) {
            BigInteger out = humidityToLocationTable.get(humidity);
            humidityToLocationTable = null;
            return out;
        }
        return humidity;
    }

    public static BigInteger findTemperatureToHumidity(BigInteger temperature) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> temperatureToHumidityTable = new HashMap<>();

        for (BigInteger[] bigIntegers : temperatureToHumidity) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                temperatureToHumidityTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(temperatureToHumidityTable.containsKey(temperature)) {
                    return temperatureToHumidityTable.get(temperature);
                }
            }
        }
        if(temperatureToHumidityTable.containsKey(temperature)) {
            BigInteger out = temperatureToHumidityTable.get(temperature);
            temperatureToHumidityTable = null;
            return out;
        }
        return temperature;
    }

    public static BigInteger findLightToTemperature(BigInteger light) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> lightToTemperatureTable = new HashMap<>();

        for (BigInteger[] bigIntegers : lightToTemperature) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                lightToTemperatureTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(lightToTemperatureTable.containsKey(light)) {
                    return lightToTemperatureTable.get(light);
                }
            }
        }
        if(lightToTemperatureTable.containsKey(light)) {
            BigInteger out = lightToTemperatureTable.get(light);
            lightToTemperatureTable = null;
            return out;
        }
        return light;
    }

    public static BigInteger findWaterToLight(BigInteger water) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> waterToLightTable = new HashMap<>();

        for (BigInteger[] bigIntegers : waterToLight) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                waterToLightTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(waterToLightTable.containsKey(water)) {
                    return waterToLightTable.get(water);
                }
            }
        }
        if(waterToLightTable.containsKey(water)) {
            BigInteger out = waterToLightTable.get(water);
            waterToLightTable = null;
            return out;
        }
        return water;
    }

    public static BigInteger findFertilizerToWater(BigInteger fertilizer) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> fertilizerToWaterTable = new HashMap<>();

        for (BigInteger[] bigIntegers : fertilizerToWater) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                fertilizerToWaterTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(fertilizerToWaterTable.containsKey(fertilizer)) {
                    return fertilizerToWaterTable.get(fertilizer);
                }
            }
        }
        if(fertilizerToWaterTable.containsKey(fertilizer)) {
            BigInteger out = fertilizerToWaterTable.get(fertilizer);
            fertilizerToWaterTable = null;
            return out;
        }
        return fertilizer;
    }

    public static BigInteger findSoilToFertilizer(BigInteger soil) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> soilToFertilizerTable = new HashMap<>();

        for (BigInteger[] bigIntegers : soilToFertilizer) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                soilToFertilizerTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(soilToFertilizerTable.containsKey(soil)) {
                    return soilToFertilizerTable.get(soil);
                }
            }
        }
        if(soilToFertilizerTable.containsKey(soil)) {
            BigInteger out = soilToFertilizerTable.get(soil);
            soilToFertilizerTable = null;
            return out;
        }
        return soil;
    }

    public static BigInteger findSeedToSoilNumber(BigInteger seed) {
        BigInteger destinationRangeStart;
        BigInteger sourceRangeStart;
        long rangeLength = 0;

        HashMap<BigInteger, BigInteger> seedToSoilTable = new HashMap<>();

        for (BigInteger[] bigIntegers : seedToSoil) {
            destinationRangeStart = bigIntegers[0];
            sourceRangeStart = bigIntegers[1];
            rangeLength = bigIntegers[2].longValue();

            for (int j = 0; j < rangeLength; j++) {
                seedToSoilTable.put(sourceRangeStart.add(BigInteger.valueOf(j)), destinationRangeStart.add(BigInteger.valueOf(j)));
                if(seedToSoilTable.containsKey(seed)) {
                    return seedToSoilTable.get(seed);
                }
            }
        }
        if(seedToSoilTable.containsKey(seed)) {
            BigInteger out = seedToSoilTable.get(seed);
            seedToSoilTable = null;
            return out;
        }
        return seed;
    }

    public static void parseMaps() {
        boolean seedToSoil = false;
        boolean soilToFertilizer = false;
        boolean fertilizerToWater = false;
        boolean waterToLight = false;
        boolean lightToTemperature = false;
        boolean temperatureToHumidity = false;
        boolean humidityToLocation = false;

        int row = 0;
        for (String str : input) {
            if (str.contains("seeds:")) {
                parseSeeds(str);
            }
            if (str.contains("seed-to-soil") || seedToSoil) {
                seedToSoil = true;
                if (str.isEmpty()) {
                    seedToSoil = false;
                    row = 0;
                    continue;
                }
                parseSeedsToSoil(str);
                row++;
            }
            if (str.contains("soil-to-fertilizer") || soilToFertilizer) {
                soilToFertilizer = true;
                if (str.isEmpty()) {
                    soilToFertilizer = false;
                    row = 0;
                    continue;
                }
                parseSoilToFertilizer(str);
                row++;
            }
            if (str.contains("fertilizer-to-water") || fertilizerToWater) {
                fertilizerToWater = true;
                if (str.isEmpty()) {
                    fertilizerToWater = false;
                    row = 0;
                    continue;
                }
                parseFertilizerToWater(str);
                row++;
            }
            if (str.contains("water-to-light") || waterToLight) {
                waterToLight = true;
                if (str.isEmpty()) {
                    waterToLight = false;
                    row = 0;
                    continue;
                }
                parseWaterToLight(str);
                row++;
            }
            if (str.contains("light-to-temperature") || lightToTemperature) {
                lightToTemperature = true;
                if (str.isEmpty()) {
                    lightToTemperature = false;
                    row = 0;
                    continue;
                }
                parseLightToTemperature(str);
                row++;
            }
            if (str.contains("temperature-to-humidity") || temperatureToHumidity) {
                temperatureToHumidity = true;
                if (str.isEmpty()) {
                    temperatureToHumidity = false;
                    row = 0;
                    continue;
                }
                parseTemperatureToHumidity(str);
                row++;
            }
            if (str.contains("humidity-to-location") || humidityToLocation) {
                humidityToLocation = true;
                if (str.isEmpty()) {
                    humidityToLocation = false;
                    row = 0;
                    continue;
                }
                parseHumidityToLocation(str);
                row++;
            }
        }
    }

    public static void parseHumidityToLocation(String str) {
        String[] humidityToLocationStr = str.split(" ");
        BigInteger[] humidityToLocationBigInt = new BigInteger[3];
        if(!Character.isDigit(humidityToLocationStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < humidityToLocationStr.length; i++) {
            try {
                humidityToLocationBigInt[i] = new BigInteger(humidityToLocationStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        humidityToLocation.add(humidityToLocationBigInt);
    }

    public static void parseTemperatureToHumidity(String str) {
        String[] temperatureToHumidityStr = str.split(" ");
        BigInteger[] temperatureToHumidityBigInt = new BigInteger[3];
        if(!Character.isDigit(temperatureToHumidityStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < temperatureToHumidityStr.length; i++) {
            try {
                temperatureToHumidityBigInt[i] = new BigInteger(temperatureToHumidityStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        temperatureToHumidity.add(temperatureToHumidityBigInt);
    }

    public static void parseLightToTemperature(String str) {
        String[] lightToTemperatureStr = str.split(" ");
        BigInteger[] lightToTemperatureBigInt = new BigInteger[3];
        if(!Character.isDigit(lightToTemperatureStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < lightToTemperatureStr.length; i++) {
            try {
                lightToTemperatureBigInt[i] = new BigInteger(lightToTemperatureStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        lightToTemperature.add(lightToTemperatureBigInt);
    }

    public static void parseWaterToLight(String str) {
        String[] waterToLightStr = str.split(" ");
        BigInteger[] waterToLightBigInt = new BigInteger[3];
        if(!Character.isDigit(waterToLightStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < waterToLightStr.length; i++) {
            try {
                waterToLightBigInt[i] = new BigInteger(waterToLightStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        waterToLight.add(waterToLightBigInt);
    }

    public static void parseFertilizerToWater(String str) {
        String[] fertilizerToWaterStr = str.split(" ");
        BigInteger[] fertilizerToWaterBigInt = new BigInteger[3];
        if(!Character.isDigit(fertilizerToWaterStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < fertilizerToWaterStr.length; i++) {
            try {
                fertilizerToWaterBigInt[i] = new BigInteger(fertilizerToWaterStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        fertilizerToWater.add(fertilizerToWaterBigInt);
    }

    public static void parseSoilToFertilizer(String str) {
        String[] soilToFertilizerStr = str.split(" ");
        BigInteger[] soilToFertilizerBigInt = new BigInteger[3];
        if(!Character.isDigit(soilToFertilizerStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < soilToFertilizerStr.length; i++) {
            try {
                soilToFertilizerBigInt[i] = new BigInteger(soilToFertilizerStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        soilToFertilizer.add(soilToFertilizerBigInt);
    }

    public static void parseSeedsToSoil(String str) {
        String[] seedToSoilStr = str.split(" ");
        BigInteger[] seedToSoilBigInt = new BigInteger[3];
        if(!Character.isDigit(seedToSoilStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < seedToSoilStr.length; i++) {
            try {
                seedToSoilBigInt[i] = new BigInteger(seedToSoilStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        seedToSoil.add(seedToSoilBigInt);
    }

    public static void parseSeeds(String str) {
        str = str.substring(str.indexOf(":") + 2);
        String[] seedsStr = str.split(" ");
        for(String seed: seedsStr) {
            try {
                seeds.add(Integer.parseInt(seed));
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public static void parseFile(String str) {
        input.add(str);
    }
}