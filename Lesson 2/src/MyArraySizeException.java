public class MyArraySizeException extends Exception {
    private int size;

    public MyArraySizeException(int size) {
        super(String.format("Попытка создать массив размером %d", size));
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
