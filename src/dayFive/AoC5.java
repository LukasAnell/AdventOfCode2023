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
    public static List<int[]> seedToSoil = new ArrayList<>();
    public static List<int[]> soilToFertilizer = new ArrayList<>();
    public static List<int[]> fertilizerToWater = new ArrayList<>();
    public static List<int[]> waterToLight = new ArrayList<>();
    public static List<int[]> lightToTemperature = new ArrayList<>();
    public static List<int[]> temperatureToHumidity = new ArrayList<>();
    public static List<int[]> humidityToLocation = new ArrayList<>();
    public static List<String> input = new ArrayList<>();

    public static void main(String[] args) {
        Path path = Paths.get("src/dayFive/Day5TestInput.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AoC5::parseFile);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }
        parseMaps();
        findLowestLocation();
        // 1132132257 too high

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
        int lowestLocation = findHumidityToLocation(findTemperatureToHumidity(findLightToTemperature(findWaterToLight(findFertilizerToWater(findSoilToFertilizer(findSeedToSoilNumber(79)))))));
        for (int seed : seeds) {
            lowestLocation = Math.min(lowestLocation, findHumidityToLocation(findTemperatureToHumidity(findLightToTemperature(findWaterToLight(findFertilizerToWater(findSoilToFertilizer(findSeedToSoilNumber(seed))))))));
        }
        System.out.println(lowestLocation);
    }

    public static int findHumidityToLocation(int humidity) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> humidityToLocationTable = new HashMap<>();

        for (int[] ints : humidityToLocation) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(humidity >= sourceRangeStart && humidity <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (humidity - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                humidityToLocationTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(humidityToLocationTable.containsKey(humidity)) {
//            return humidityToLocationTable.get(humidity);
//        }
        return humidity;
    }

    public static int findTemperatureToHumidity(int temperature) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> temperatureToHumidityTable = new HashMap<>();

        for (int[] ints : temperatureToHumidity) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(temperature >= sourceRangeStart && temperature <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (temperature - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                temperatureToHumidityTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(temperatureToHumidityTable.containsKey(temperature)) {
//            return temperatureToHumidityTable.get(temperature);
//        }
        return temperature;
    }

    public static int findLightToTemperature(int light) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> lightToTemperatureTable = new HashMap<>();

        for (int[] ints : lightToTemperature) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(light >= sourceRangeStart && light <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (light - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                lightToTemperatureTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(lightToTemperatureTable.containsKey(light)) {
//            return lightToTemperatureTable.get(light);
//        }
        return light;
    }

    public static int findWaterToLight(int water) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> waterToLightTable = new HashMap<>();

        for (int[] ints : waterToLight) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(water >= sourceRangeStart && water <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (water - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                waterToLightTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(waterToLightTable.containsKey(water)) {
//            return waterToLightTable.get(water);
//        }
        return water;
    }

    public static int findFertilizerToWater(int fertilizer) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> fertilizerToWaterTable = new HashMap<>();

        for (int[] ints : fertilizerToWater) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(fertilizer >= sourceRangeStart && fertilizer <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (fertilizer - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                fertilizerToWaterTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(fertilizerToWaterTable.containsKey(fertilizer)) {
//            return fertilizerToWaterTable.get(fertilizer);
//        }
        return fertilizer;
    }

    public static int findSoilToFertilizer(int soil) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> soilToFertilizerTable = new HashMap<>();

        for (int[] ints : soilToFertilizer) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(soil >= sourceRangeStart && soil <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (soil - sourceRangeStart);
            }

//            for (int j = 0; j < rangeLength; j++) {
//                soilToFertilizerTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(soilToFertilizerTable.containsKey(soil)) {
//            return soilToFertilizerTable.get(soil);
//        }
        return soil;
    }

    public static int findSeedToSoilNumber(int seed) {
        int destinationRangeStart = 0;
        int sourceRangeStart = 0;
        int rangeLength = 0;

//        HashMap<Integer, Integer> seedToSoilTable = new HashMap<>();

        for(int[] ints : seedToSoil) {
            destinationRangeStart = ints[0];
            sourceRangeStart = ints[1];
            rangeLength = ints[2];

            if(seed >= sourceRangeStart && seed <= sourceRangeStart + rangeLength) {
                return destinationRangeStart + (seed - sourceRangeStart);
            }

//            for(int j = 0; j < rangeLength; j++) {
//                seedToSoilTable.put(sourceRangeStart + j, destinationRangeStart + j);
//            }
        }
//        if(seedToSoilTable.containsKey(seed)) {
//            return seedToSoilTable.get(seed);
//        }
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
        int[] humidityToLocationString = new int[3];
        if(!Character.isDigit(humidityToLocationStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < humidityToLocationStr.length; i++) {
            try {
                humidityToLocationString[i] = Integer.parseInt(humidityToLocationStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        humidityToLocation.add(humidityToLocationString);
    }

    public static void parseTemperatureToHumidity(String str) {
        String[] temperatureToHumidityStr = str.split(" ");
        int[] temperatureToHumidityString = new int[3];
        if(!Character.isDigit(temperatureToHumidityStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < temperatureToHumidityStr.length; i++) {
            try {
                temperatureToHumidityString[i] = Integer.parseInt(temperatureToHumidityStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        temperatureToHumidity.add(temperatureToHumidityString);
    }

    public static void parseLightToTemperature(String str) {
        String[] lightToTemperatureStr = str.split(" ");
        int[] lightToTemperatureString = new int[3];
        if(!Character.isDigit(lightToTemperatureStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < lightToTemperatureStr.length; i++) {
            try {
                lightToTemperatureString[i] = Integer.parseInt(lightToTemperatureStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        lightToTemperature.add(lightToTemperatureString);
    }

    public static void parseWaterToLight(String str) {
        String[] waterToLightStr = str.split(" ");
        int[] waterToLightString = new int[3];
        if(!Character.isDigit(waterToLightStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < waterToLightStr.length; i++) {
            try {
                waterToLightString[i] = Integer.parseInt(waterToLightStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        waterToLight.add(waterToLightString);
    }

    public static void parseFertilizerToWater(String str) {
        String[] fertilizerToWaterStr = str.split(" ");
        int[] fertilizerToWaterString = new int[3];
        if(!Character.isDigit(fertilizerToWaterStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < fertilizerToWaterStr.length; i++) {
            try {
                fertilizerToWaterString[i] = Integer.parseInt(fertilizerToWaterStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        fertilizerToWater.add(fertilizerToWaterString);
    }

    public static void parseSoilToFertilizer(String str) {
        String[] soilToFertilizerStr = str.split(" ");
        int[] soilToFertilizerString = new int[3];
        if(!Character.isDigit(soilToFertilizerStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < soilToFertilizerStr.length; i++) {
            try {
                soilToFertilizerString[i] = Integer.parseInt(soilToFertilizerStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        soilToFertilizer.add(soilToFertilizerString);
    }

    public static void parseSeedsToSoil(String str) {
        String[] seedToSoilStr = str.split(" ");
        int[] seedToSoilString = new int[3];
        if(!Character.isDigit(seedToSoilStr[0].charAt(0))) {
            return;
        }
        for(int i = 0; i < seedToSoilStr.length; i++) {
            try {
                seedToSoilString[i] = Integer.parseInt(seedToSoilStr[i]);
            } catch (NumberFormatException ignored) {
            }
        }
        seedToSoil.add(seedToSoilString);
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