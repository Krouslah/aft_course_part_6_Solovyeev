
public class Matrix {
    private double[][] array;
    private final int lines;
    private final int columns;

    public Matrix(double[][] array, int lines, int columns) {
        this.array = array;
        this.lines = lines;
        this.columns = columns;
    }

    public double[][] getArray() {
        return array;
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setArray(double[][] array) {
        this.array = array;
    }

    public void sumOfArrays(Matrix matrix2) {
        double[][] array = new double[this.lines][this.columns];
        try {
            if (matrix2.getLines() == this.lines && matrix2.getColumns() == this.columns) {
                for (int i = 0; i < matrix2.getLines(); i++) {
                    for (int j = 0; j < matrix2.getColumns(); j++) {
                        array[i][j] = matrix2.getArray()[i][j] + this.array[i][j];
                    }
                }
                this.setArray(array);
            } else
                throw new MatrixException("Пытаешься сложить 2 разноразмерные матрицы");
        }
        catch (MatrixException me){
            System.out.println(me.getMessage());
        }
    }

    public void multiplyOfArrays(double index) {
        double[][] array = new double[this.lines][this.columns];
        for (int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                array[i][j] = this.array[i][j] * index;
            }
        }
        this.setArray(array);
    }
    public void printArrays() {
        for (int i = 0; i < this.getLines(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                System.out.print(this.getArray()[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void createMatrix(){
        System.out.print("Введите количество строк: ");
        int lines = Integer.parseInt(Main.stringScanner());
        System.out.print("Введите количество столбцов: ");
        int columns = Integer.parseInt(Main.stringScanner());
        double[][] array = new double[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Введите значение для ячеки: " + i + "-" + j);
                array[i][j] = Double.parseDouble(Main.stringScanner());
            }
        }
        Main.matrixMap.put((Main.matrixMap.size() + 1), new Matrix(array, lines, columns));
    }
    public static int chooseForMatrix(){
        System.out.println("Индекс матрицы:");
        return Integer.parseInt(Main.stringScanner());
    }
}
class MatrixException extends RuntimeException{
    public MatrixException(String message) {
        super(message);
    }
}