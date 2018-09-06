public class MyArrayDataException extends Exception {
    private int x;
    private int y;

    public MyArrayDataException(int x, int y) {
        super(String.format("Ошибка преобразования String в int в ячейке [%d][%d]", x, y));
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
