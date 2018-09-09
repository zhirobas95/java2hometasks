import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> numbers;

    public PhoneBook(HashMap<String, ArrayList<String>> numbers) {
        this.numbers = numbers;
    }

    public PhoneBook() {
        this.numbers = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        //проверим, есть ли имя в справочнике
        if (numbers.containsKey(secondName)) {
            numbers.get(secondName).add(phoneNumber);
        } else {
            ArrayList<String> newList = new ArrayList();
            newList.add(phoneNumber);
            numbers.put(secondName, newList);
        }
    }

    public void get(String secondName) {
        if (numbers.get(secondName) != null) {
            System.out.println("Номера по фамилии " + secondName + ": " + numbers.get(secondName));
        } else {
            System.out.println("Записи по фамилии " + secondName + " не найдено.");
        }
    }
}