import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Matrix {

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }
    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    public static void print(double[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }

    public static double[][] sumMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            return null;
        }
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] + secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] subtractMatrix(double[][] firstMatrix, double[][] secondMatrix) {
        if(firstMatrix.length != secondMatrix.length) {
            return null;
        }
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];

        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[row].length; col++) {
                result[row][col] = firstMatrix[row][col] - secondMatrix[row][col];
            }
        }
        return result;
    }

    public static double[][] addition(double[][] matrix, double temp) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] + temp;
            }
        }
        return result;
    }

    public static double[][] subtraction(double[][] matrix, double temp) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] - temp;
            }
        }
        return result;
    }

    public static double[][] multiplyOnNumber(double[][] matrix, double temp) {
        double[][] result = new double[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * temp;
            }
        }
        return result;
    }

    public static double[][] getRandMatrix(int rows, int cols) {
        Random r = new Random();
        double[][] result = new double[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                result[i][j] = r.nextInt(10) + 1;
            }
        }
        return result;
    }

    public static double[][] getMatrixFromFile(String str) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(str)));

            List<String> lines = new ArrayList<>();
            while (br.ready()) {
                lines.add(br.readLine());
            }
            String row = lines.get(0);
            System.out.println(row);
            int rows = Integer.parseInt(row);
            double[][] result = new double[rows][rows];

            for (int i = 0; i < rows; i++) {
                String[] line = lines.get(i + 1).split(",");
                for (int j = 0; j < rows; j++) {
                    result[i][j] = Double.parseDouble(line[j]);
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println("");
            }

            return result;
        } catch (IOException e) {
            System.out.println(e.getClass());
        }
        return null;
    }
/*        try {
            String[] row = str.split("\n");
            String fileName = str;
            Optional<String> line = Files.lines(Paths.get(fileName)).findFirst();
            int rows = Integer.parseInt(line.get());
            System.out.println(rows);
            double[][] result = new double[row.length][row.length];
            for (int i = 0; i < row.length; i++) {
                String[] lines = row[i + 1].split(",");
                for (int j = 0; j < lines.length; j++) {
                    result[i][j] = Double.parseDouble(lines[j]);
                }
            }
            return result;
        } catch (IOException e) {
            System.out.println(e.getClass());
        }
        return null;
    }*/
}
