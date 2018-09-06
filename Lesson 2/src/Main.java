public class Main {
    static int nominalX = 4;
    static int nominalY = 4;
    static int sum = 0;

    public static void main(String[] args) {
        //три массива для проверки: верный, с неверным размером, с неверными данными
        String[][] arr1 = new String[nominalX][nominalY];

        //корректный массив
        System.out.println("Массив, удовлетворяющий условию");
        fillArray(arr1);
        printArray(arr1);
        computeArray(arr1);

        System.out.println();

        //массив с неверным размером
        System.out.println("Попробуем подменить 2й по индексу массив на массив размером 3");
        String[][] arr2 = new String[nominalX][];
        arr2[0] = new String[nominalY];
        arr2[1] = new String[nominalY];
        arr2[2] = new String[3];
        arr2[3] = new String[nominalY];
        fillArray(arr2);
        printArray(arr2);
        computeArray(arr2);

        System.out.println();

        //испортим данным в корректном массиве
        arr1[(int) (Math.random() * nominalX)][(int) (Math.random() * nominalY)] = "bad data";
        printArray(arr1);
        computeArray(arr1);
    }

    public static void method4Task(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != nominalX) {
            throw new MyArraySizeException(arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != nominalY) {
                throw new MyArraySizeException(arr[i].length);
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
    }

    public static void fillArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf(i * arr.length + j + 1);
            }
        }
    }

    public static void computeArray(String[][] arr) {
        try {
            sum = 0;
            method4Task(arr);
            System.out.println("Сумма равна: " + sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Размер " + e.getSize() + " не удовлетворяет условию");
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Не удалось преобразовать [" + e.getX() + "][" + e.getY() + "] строку в число");
        }
    }

    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
