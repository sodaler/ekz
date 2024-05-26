#include <iostream>
#include <vector>

// Функция для обмена элементов
void swap(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
}

// Функция для разделения массива
int partition(std::vector<int>& arr, int low, int high) {
    int pivot = arr[high];  // Выбираем последний элемент как опорный (pivot)
    int i = (low - 1);      // Индекс меньшего элемента, начальное значение -1 от low

    // Перебираем элементы массива с индекса low до high - 1
    for (int j = low; j < high; j++) {
        // Если текущий элемент меньше опорного
        if (arr[j] < pivot) {
            i++;                // Увеличиваем индекс меньшего элемента
            swap(arr[i], arr[j]); // Меняем местами элементы arr[i] и arr[j]
        }
    }
    // Меняем местами элемент после последнего меньшего и опорный элемент
    swap(arr[i + 1], arr[high]);
    return (i + 1); // Возвращаем индекс опорного элемента
}


// Функция быстрой сортировки
void quickSort(std::vector<int>& arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);  // Индекс разделения

        // Рекурсивно сортируем элементы до и после разделения
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Функция для вывода массива
void printArray(const std::vector<int>& arr) {
    for (int i : arr) {
        std::cout << i << " ";
    }
    std::cout << std::endl;
}

int main() {
    // Инициализация вектора
    std::vector<int> arr = { 10, 7, 8, 9, 1, 5 };

    std::cout << "Initial array: ";
    printArray(arr);

    // Вызов функции быстрой сортировки
    quickSort(arr, 0, arr.size() - 1);

    std::cout << "Sorted array: ";
    printArray(arr);

    return 0;
}
