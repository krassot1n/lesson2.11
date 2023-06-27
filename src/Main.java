public class Main {
    public static void main(String[] args) {
        StringListImpl list = new StringListImpl(5);
        // Добавление элементов
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Вывод размера списка
        System.out.println("Size: " + list.size()); // Ожидаемый результат: 3

        // Получение элемента по индексу
        System.out.println("Element at index 1: " + list.get(1)); // Ожидаемый результат: "Banana"

        // Проверка наличия элемента
        System.out.println("Contains 'Apple': " + list.contains("Apple")); // Ожидаемый результат: true

        // Изменение элемента по индексу
        String replacedItem = list.set(2, "Grapefruit");
        System.out.println("Replaced item: " + replacedItem); // Ожидаемый результат: "Orange"
        System.out.println("Updated list: " + list); // Ожидаемый результат: ["Apple", "Banana", "Grapefruit"]

        // Удаление элемента по значению
        String removedItem = list.remove("Banana");
        System.out.println("Removed item: " + removedItem); // Ожидаемый результат: "Banana"
        System.out.println("Updated list: " + list); // Ожидаемый результат: ["Apple", "Grapefruit"]

        // Удаление элемента по индексу
        String removedItemAtIndex = list.remove(0);
        System.out.println("Removed item at index 0: " + removedItemAtIndex); // Ожидаемый результат: "Apple"
        System.out.println("Updated list: " + list); // Ожидаемый результат: ["Grapefruit"]

        // Очистка списка
        list.clear();
        System.out.println("Is list empty? " + list.isEmpty()); // Ожидаемый результат: true
    }
}