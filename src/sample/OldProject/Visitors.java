package sample.OldProject;

import java.util.ArrayList;

public class Visitors{

    public static void main(String[] args) {

        ArrayList<String> people = new ArrayList<String>();
        // добавим в список ряд элементов
        people.add("Илья Муромец");
        people.add("Бова Королевич");
        people.add("Алеша Попович");
        people.add("Добрыня Никитич");
        people.add(1, "Вольга Святославович"); // добавляем элемент по индексу 1

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Василий Буслаев"); // установка нового значения для 2-го объекта

        System.out.printf("ArrayList has %d elements \n", people.size());
        for(String person : people){

            System.out.println(person);
        }
        // проверяем наличие элемента
        if(people.contains("Илья Муромец")){

            System.out.println("ArrayList contains Илья Муромец");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Василий Буслаев");
        // удаление по индексу
        people.remove(0);

        Object[] peopleArray = people.toArray();
        for(Object person : peopleArray){

            System.out.println(person);
        }
    }
}