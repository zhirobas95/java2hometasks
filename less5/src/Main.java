public class Main {
    static final int size = 10000000;
    static final int half = size / 2;

    public static void main(String[] args) {
        //запускаем первую часть задания (без дробления пополам)
        System.out.println("Без дробления:");
        computeEntireArray();

        System.out.println("*********************************************");

        //запускаем вторую часть задания
        System.out.println("С дроблением:");
        computeSplitArray();
    }

    static void computeEntireArray() {
        //создаем массив
        float[] arr = new float[size];

        //заполняем единицами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        //засекаем время
        System.out.println("Начинаем пересчитывать массив");
        long a = System.currentTimeMillis();

        //пересчитываем значения
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        //выводим затраченное время
        System.out.println(System.currentTimeMillis() - a + " миллисекунд затрачено на пересчет целого массива.");
    }

    static void computeSplitArray() {
        //создаем массив
        float[] arr = new float[size];
        float[] a1 = new float[half], a2 = new float[half];
        Object monitor = new Object();

        //заполняем единицами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        //засекаем время
        System.out.println("Начинаем пересчитывать массив");
        long a = System.currentTimeMillis();

        //дробим массив на две половины
        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);

        //поток для пересчета первой половины
        Thread firstHalfThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Пошла первая половина массива.");
                for (int i = 0; i < a1.length; i++) {
                    if (i % (a1.length / 4) == 0)
                        System.out.println("Идет " + (i / (a1.length / 4) + 1) + " четверть от 1 половины массива...");
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        //поток для пересчета второй половины
        Thread secondHalfThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Пошла вторая половина массива.");
                for (int i = 0; i < a2.length; i++) {
                    if (i % (a2.length / 4) == 0)
                        System.out.println("Идет " + (i / (a2.length / 4) + 1) + " четверть от 2 половины массива...");
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        //запускаем потоки
        firstHalfThread.start();
        secondHalfThread.start();

        //ждем завершения пересчета
        try {
            firstHalfThread.join();
            secondHalfThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Склейка половин...");
        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, half);

        System.out.println(System.currentTimeMillis() - a + " миллисекунд затрачено на пересчет целого массива.");

    }
}
