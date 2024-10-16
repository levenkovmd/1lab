public class MyContainer<T> {
    private T[] array;
    private int size;

    // Конструктор
    @SuppressWarnings("unchecked")
    public MyContainer() {
        array = (T[]) new Object[10];
        size = 0;
    }

    // Добавление
    public void add(T element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
    }

    // Извлечение элемента по индексу
    public T get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }

    // Удаление элемента по индексу
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null;
        } else {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }


    public int size() {
        return size;
    }

    // Увеличение массива в 2 раза
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public static void main(String[] args) {
        MyContainer<Integer> container = new MyContainer<>();

        // Добавление
        container.add(1);
        container.add(2);
        container.add(3);

        // Получение элемента
        System.out.println("Элемент с индексом 1: " + container.get(1));
        System.out.println("Текущий размер: " + container.size());

        // Удаление
        container.remove(1);
        System.out.println("Элемент с индексом 1 после удаления: " + container.get(1));
        System.out.println("Текущий размер: " + container.size());
    }
}
