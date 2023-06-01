import java.util.Arrays;
import java.util.Scanner;

public class Matrix35 {
    private final int sizeX;
    private final int sizeY;
    private final double[][] matrix;

    public Matrix35(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.matrix = new double[sizeX][sizeY];
    }

    public void display() {
        System.out.println(Arrays.deepToString(this.matrix));
    }

    public void inputMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                System.out.println("Введите элемент матрицы распологающийся по координатам " + i + " " + j);
                this.matrix[i][j] = sc.nextDouble();
            }
        }
    }

    public Matrix35 add(Matrix35 other) {
        if (this.sizeX != other.sizeX || this.sizeY != other.sizeY) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для сложения!");
        }

        Matrix35 result = new Matrix35(this.sizeX, this.sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix35 subtract(Matrix35 other) {
        if (this.sizeX != other.sizeX || this.sizeY != other.sizeY) {
            throw new IllegalArgumentException("Матрицы должны быть одного размера для вычитания!");
        }

        Matrix35 result = new Matrix35(this.sizeX, this.sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix35 multiplyByScalar(double scalar) {
        Matrix35 result = new Matrix35(this.sizeX, this.sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                result.matrix[i][j] = this.matrix[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix35 multiply(Matrix35 other) {
        if (this.sizeY != other.sizeX) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть равно количеству строк второй матрицы для умножения!");
        }

        Matrix35 result = new Matrix35(this.sizeX, other.sizeY);
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < other.sizeY; j++) {
                for (int k = 0; k < this.sizeY; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Matrix35 transpose() {
        Matrix35 result = new Matrix35(this.sizeY, this.sizeX);
        for (int i = 0; i < this.sizeX; i++) {
            for (int j = 0; j < this.sizeY; j++) {
                result.matrix[j][i] = this.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix35 power(int exponent) {
        if (this.sizeX != this.sizeY) {
            throw new IllegalArgumentException("Матрица должна быть квадратной для возведения в степень!");
        }

        Matrix35 result = new Matrix35(this.sizeX, this.sizeY);
        for (int i = 0; i < this.sizeX; i++) {
            result.matrix[i][i] = 1;
        }

        for (int n = 0; n < exponent; n++) {
            result = result.multiply(this);
        }

        return result;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите размерность матрицы по оси координат: ");
        int sizeX1 = sc.nextInt();
        System.out.println("Введите размерность матрицы по оси ординат: ");
        int sizeY1 = sc.nextInt();

        Matrix35 matrix1 = new Matrix35(sizeX1, sizeY1);
        System.out.println("Введите элементы первой матрицы: ");
        matrix1.inputMatrix();

        System.out.println("Первая матрица: ");
        matrix1.display();

        System.out.println("Введите размерность матрицы по оси координат: ");
        int sizeX2 = sc.nextInt();
        System.out.println("Введите размерность матрицы по оси ординат: ");
        int sizeY2 = sc.nextInt();

        Matrix35 matrix2 = new Matrix35(sizeX2, sizeY2);
        System.out.println("Введите элементы второй матрицы: ");
        matrix2.inputMatrix();

        System.out.println("Вторая матрица: ");
        matrix2.display();

        try {
            Matrix35 sum = matrix1.add(matrix2);
            System.out.println("Результат сложения двух матриц: ");
            sum.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Матрицы разного размера, невозможно выполнить сложение!");
        }

        try {
            Matrix35 difference = matrix1.subtract(matrix2);
            System.out.println("Результат вычитания двух матриц: ");
            difference.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Матрицы разного размера, невозможно выполнить вычитание!");
        }

        try {
            Matrix35 product = matrix1.multiply(matrix2);
            System.out.println("Результат умножения двух матриц: ");
            product.display();
        } catch (IllegalArgumentException e) {
            System.out.println("Количество столбцов первой матрицы не равно количеству строк второй матрицы, невозможно выполнить умножение!");
        }

        System.out.println("Транспонированная первая матрица: ");
        Matrix35 transposedMatrix1 = matrix1.transpose();
        transposedMatrix1.display();

        System.out.println("Первая матрица, умноженная на 3: ");
        Matrix35 scaledMatrix1 = matrix1.multiplyByScalar(3);
        scaledMatrix1.display();

        if (sizeX1 == sizeY1) {
            System.out.println("Введите степень, в которую хотите возвести первую матрицу: ");
            int exponent = sc.nextInt();
            try {
                Matrix35 poweredMatrix1 = matrix1.power(exponent);
                System.out.println("Первая матрица, возведенная в степень " + exponent + ": ");
                poweredMatrix1.display();
            } catch (IllegalArgumentException e) {
                System.out.println("Матрица не является квадратной, невозможно возвести ее в степень!");
            }
        }
    }
}
