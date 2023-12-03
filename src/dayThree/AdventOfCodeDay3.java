package dayThree;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AdventOfCodeDay3 {
    public static char[][] arr = new char[140][167];
    public static int i = 0;
    public static int sum = 0;
    public static void main(String[] args) {
        Path path = Paths.get("src/dayThree/Day3Input.txt");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEachOrdered(AdventOfCodeDay3::createArray);
        } catch (IOException e) {
            System.out.println("Error happened");
            throw new RuntimeException(e);
        }
        partOne(arr);
        System.out.println(sum);
    }

    public static void createArray(String str) {
        char[] arr2 = new char[167];
        for(int j = 0; j < str.length(); j++) {
            arr2[j] = str.charAt(j);
        }
        arr[i] = arr2;
        i++;
    }

    public static int row = 0;
    public static int column = 0;
    public static void partOne(char[][] arr) {
        for(row = 0; row < 140; row++) {
            for(column = 0; column < 167; column++) {
                if(Character.isDigit(arr[row][column])) {
                    checkAround(row, column);
                }
            }
        }
    }

    public static void checkAround(int row, int col) {
        boolean willWork = false;

        int iMin = Math.max(0, row - 1);
        int iMax = Math.min(140 - 1, row + 1);
        int jMin = Math.max(0, col - 1);
        int jMax = Math.min(167 - 1, col + 1);

        int breakCol = 0;

        for(int i = iMin; i < iMax; i++) {
            for(int j = jMin; j < jMax; j++) {
                if(i == row && j == col) {
                    continue;
                }
                if (!(arr[i][j] == '.') && !Character.isDigit(arr[i][j])) {
                    willWork = true;
                    breakCol = col;
                    break;
                }
            }
        }
        if(willWork) {
            int[] temp = fullNumber(row, col);
            int num = temp[0];
            sum += num;
            column += temp[1] - breakCol;
        }
    }

    public static int[] fullNumber(int row, int col) {
        String fullNum = "";

        int tempCol = col;

        while (Character.isDigit(arr[row][tempCol])) {
            fullNum += arr[row][tempCol];
            tempCol--;
        }

        fullNum = new StringBuilder(fullNum).reverse().toString();

        tempCol = col + 1;
        while (Character.isDigit(arr[row][tempCol])) {
            fullNum += arr[row][tempCol];
            tempCol++;

        }

        fullNum = fullNum.replaceAll("[^0-9]", "");
        fullNum = fullNum.replaceAll("\\s+", "");

        System.out.println(fullNum);

        return new int[]{Integer.parseInt(fullNum), tempCol};
    }
}
