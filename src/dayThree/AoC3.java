package dayThree;

import java.util.ArrayList;
import java.util.List;
import Utils.Reader;

public class AoC3 {
    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        List<String> lineList = Reader.readFromFile("src/dayThree/Day3Input.txt");
        assert lineList != null;
        char[][] array2D = create2DArray(lineList);
        partOne(array2D, lineList.get(0).length(), lineList.size());
        partTwo(array2D, lineList.get(0).length(), lineList.size());
    }

    public static void partTwo(char[][] arr, int columns, int rows) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(arr[i][j] == '*') {
                    sum += checkAroundPartTwo(arr, j, i);
                }
            }
        }
        System.out.println(sum);
        // 81997870 answer
    }

    public static int checkAroundPartTwo(char[][] list, int x, int y) {
        List<Integer> adjacentPartNumbers = new ArrayList<>();
        int numAdjacent = 0;

        for(int dy = -1; dy <= 1; dy++) {
            if ((y + dy >= 0) && (y + dy < list.length)) {
                for(int dx = -1; dx <= 1; dx++) {
                    if ((x + dx >= 0) && (x + dx < list[y + dy].length) && (!(dy == 0 && dx == 0))) {
                        if (Character.isDigit(list[y + dy][x + dx]) && numAdjacent < 2) {
                            int number = getFullNumber(list, x + dx, y + dy);
                            adjacentPartNumbers.add(number);
                            numAdjacent++;

                            dx++;
                            if(dx >= 0 && dx < list[y + dy].length && Character.isDigit(list[y + dy][x + dx])) {
                                break;
                            }
                        }
                    }
                }
            }
        }

        int product = 1;
        for (int i : adjacentPartNumbers) {
            product *= i;
        }

        if(adjacentPartNumbers.size() == 2) {
            return product;
        }
        return 0;
    }

    public static int getFullNumber(char[][] list, int x, int y) {
        StringBuilder output = new StringBuilder();

        int tempX = x;
        while((tempX < 140 && tempX >= 0) && Character.isDigit(list[y][tempX])) {
            output.append(list[y][tempX]);
            tempX--;
        }
        output.reverse();
        tempX = x + 1;
        while((tempX < 140 && tempX >= 0) && Character.isDigit(list[y][tempX])) {
            output.append(list[y][tempX]);
            tempX++;
        }

        if(output.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(output));
    }

    public static void partOne(char[][] arr, int columns, int rows) {
        StringBuilder number = new StringBuilder();
        boolean isValid = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Character.isDigit(arr[i][j])) {
                    number.append(arr[i][j]);
                    if (checkAround(arr, i, j)) {
                        isValid = true;
                    }
                } else {
                    if (isValid) {
                        result.add(number.toString());
                        isValid = false;
                    }
                    number = new StringBuilder();
                }
            }
        }
        int sum = 0;
        for (String s : result) {
            sum += Integer.parseInt(s);
        }
        System.out.println(sum);
        // 550934 answer
    }

    public static boolean checkAround(char[][] list, int x, int y) {
        for(int dx = -1; dx <= 1; dx++) {
            if ((x + dx >= 0) && (x + dx < list.length)) {
                for(int dy = -1; dy <= 1; dy++) {
                    if ((y + dy >= 0) && (y + dy < list[x + dx].length) && (!(dx == 0 && dy == 0))) {
                        if (Character.toString(list[x + dx][y + dy]).matches("[^0-9.]")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static char[][] create2DArray(List<String> list) {
        char[][] array2D = new char[list.get(0).length()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                array2D[i][j] = list.get(i).charAt(j);
            }
        }
        return array2D;
    }
}
