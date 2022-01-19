import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean flag = true;
    public static Map<String, Phone> phoneMap = new HashMap<>();
    public static Map<Integer, Matrix> matrixMap = new HashMap<>();

    public static void main(String[] args) {
        phoneMap.put("+79771440678", (new Phone("+79771440678", "Samsung", 100)));
        phoneMap.put("+79771440679", (new Phone("+79771440679", "Honor", 80)));
        phoneMap.put("+79771440680", (new Phone("+79771440680", "iPhone", 120)));
        menu();
        System.out.println("Увидимся");
    }

    public static void menu() {
        while (flag) {
            System.out.println("""
                    1.  Создать объект класса Phone с тремя полями
                    2.  Создать объект класса Phone с двумя полями
                    3.  Вывести на экран объект класса Phone с тремя полями
                    4.  Вывести на экран объект класса Phone с двумя полями
                    5.  Вывести на экран звонок без номера
                    6.  Вывести на экан звонок с номером
                    7.  Отправить сообщения на номера
                    8.  Создать матрицу
                    9.  Сложить матрицы
                    10. Умножить матрицу на число
                    11. Вывести на экран матрицу
                    0. Выход""");
            try {
                byte i = Byte.parseByte(stringScanner());
                if (i == 1) createPhone3();
                if (i == 2) createPhone2();
                if (i == 3) {
                    if (phoneMap.size() > 0) {
                        printPhone3();
                    } else System.out.println("Выводить нечего");
                }
                if (i == 4) {
                    if (phoneMap.size() > 0) {
                        printPhone2();
                    } else System.out.println("Выводить нечего");
                }
                if (i == 5) callWithNoNumber();
                if (i == 6) callWithNumber();
                if (i == 7) sendMessage();
                if (i == 8) Matrix.createMatrix();
                if (i == 9) {
                    if (matrixMap.size() > 0) {
                        if (matrixMap.size() == 1) {
                            System.out.println("Доступно только сложение матрицы с самой собой");
                            int index = Matrix.chooseForMatrix();
                            matrixMap.get(index).sumOfArrays(matrixMap.get(index));
                        } else {
                            System.out.println("Определим 2 матрицы к сложению:");
                            matrixMap.get(Matrix.chooseForMatrix()).sumOfArrays(matrixMap.get(Matrix.chooseForMatrix()));
                        }
                    } else System.out.println("Сложение недоступно");
                }
                if (i == 10) {
                    if (matrixMap.size() > 0) {
                        System.out.print("Введите число, на которое нужно умножить матрицу(так, на всякий случай, число вещественное): ");
                        double number = Double.parseDouble(stringScanner());
                        System.out.println("Выбор матрицы по индексу к умножению:");
                        matrixMap.get(Matrix.chooseForMatrix()).multiplyOfArrays(number);
                    } else System.out.println("Умножение недоступно");
                }
                if (i == 11) {
                    if (matrixMap.size() > 0) {
                        System.out.print("Введите индекс матрицы: ");
                        int index = Integer.parseInt(stringScanner());
                        matrixMap.get(index).printArrays();
                    } else System.out.println("Выводить нечего");
                }
                if (i == 0) flag = false;
            } catch (NumberFormatException ne) {
                System.out.println("Caught NumberFormatException " + ne.getMessage());
            }
        }
    }

    public static void createPhone3() {
        System.out.print("Введите номер телефона: ");
        String number = stringScanner();
        System.out.print("Введите модель телефона: ");
        String model = stringScanner();
        System.out.print("Введите вес телефона: ");
        int weight = Integer.parseInt(stringScanner());
        phoneMap.put(number, (new Phone(number, model, weight)));
    }

    public static void createPhone2() {
        System.out.print("Введите номер телефона: ");
        String number = stringScanner();
        System.out.print("Введите модель телефона: ");
        String model = stringScanner();
        phoneMap.put(number, (new Phone(number, model)));
    }

    public static String stringScanner() {
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }

    public static void printPhone3() {
        System.out.println("Данные телефона по какому номеру нужно вывести?");
        String number = stringScanner();
        System.out.println("Данные по номеру " + phoneMap.get(number).getNumber() + " : " + "модель - " + phoneMap.get(number).getModel() + ", вес - " + phoneMap.get(number).getWeight());
    }

    public static void printPhone2() {
        System.out.println("Данные телефона по какому номеру нужно вывести?");
        String number = stringScanner();
        System.out.println("Данные по номеру " + phoneMap.get(number).getNumber() + " : " + "модель - " + phoneMap.get(number).getModel());
    }

    public static void callWithNoNumber() {
        System.out.print("Имя, пожалуйста: ");
        String name = stringScanner();
        Phone.receiveCall(name);
    }

    public static void callWithNumber() {
        System.out.print("Имя, пожалуйста: ");
        String name = stringScanner();
        System.out.print("Номер, пожалуйста: ");
        String number = stringScanner();
        Phone.receiveCall(name, number);
    }

    public static void sendMessage() {
        System.out.println("На какое количество номеров нужно вывести сообщение?");
        try {
            int count = Integer.parseInt(stringScanner());
            String[] array = new String[count];
            for (int i = 0; i < count; i++) {
                System.out.println("Введите телефон:");
                array[i] = stringScanner();
            }
            Phone.sendMessage(array);
        } catch (NumberFormatException ne) {
            System.out.println("Caught NumberFormatException" + ne.getMessage());
        }
    }
}