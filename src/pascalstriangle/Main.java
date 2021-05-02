package pascalstriangle;

public class Main {

    public static void main(String[] args) {
        var number = findNumberInPascalTriangle(5,3);
        System.out.println(number);
    }

    private static int findNumberInPascalTriangle(int row, int column) {
        if (column == 1 || column == row) {
            return 1;
        }
        return findNumberInPascalTriangle(row - 1, column - 1) +
                findNumberInPascalTriangle(row - 1, column);
    }

}
