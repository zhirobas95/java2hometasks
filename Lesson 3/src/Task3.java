import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class Task3 {
    public static void main(String[] args) {
        /*
        Задание 1.
         */

        //пусть массив может включать одно из 3 слов
        String[] words = {"Раз", "Два", "Три"};

        //создадим массив
        ArrayList<String> wordsList = new ArrayList<>();

        //заполним 10-ю словами
        for (int i = 0; i < 10; i++) {
            wordsList.add(words[(int) (Math.random() * words.length)]);
        }
        System.out.print("Исходный массив: ");
        System.out.println(wordsList);

        //вычленим уникальные слова
        HashSet<String> uniqueWords = new HashSet<>(wordsList);
        System.out.print("Массив содержит следующие слова: ");
        System.out.println(uniqueWords);

        //подсчитаем для каждого слова частоту
        for (String str : uniqueWords) {
            System.out.print("Число вхождений слова " + str + ": ");
            System.out.println(Collections.frequency(wordsList, str));
        }


        System.out.println();


        /*
        Задание 2
         */
        //создаем записную книжку
        PhoneBook phonebook = new PhoneBook();

        //добавим 2 человека
        phonebook.add("Сидоров", "+7-(931)-777-77-77");
        phonebook.add("Петров", "+7-(931)-888-888-88");
        phonebook.add("Петров", "+7-(931)-222-11-32");

        //получим номера
        phonebook.get("Петров");
        phonebook.get("Иванов");
        phonebook.get("Сидоров");
    }
}