#include <iostream>
#include <vector>
#include <algorithm> // для std::move

// Шаблонная функция сортировки
template <typename Comparable>
void SORT(std::vector<Comparable>& items) {
    if (items.size() > 1) {
        std::vector<Comparable> smaller;
        std::vector<Comparable> same;
        std::vector<Comparable> larger;

        auto chosenItem = items[items.size() / 2];

        for (auto& i : items) {
            if (i < chosenItem)
                smaller.push_back(std::move(i));
            else if (chosenItem < i)
                larger.push_back(std::move(i));
            else
                same.push_back(std::move(i));
        }

        SORT(smaller); // Рекурсивный вызов для меньших элементов
        SORT(larger);  // Рекурсивный вызов для больших элементов

        std::move(smaller.begin(), smaller.end(), items.begin());
        std::move(same.begin(), same.end(), items.begin() + smaller.size());
        std::move(larger.begin(), larger.end(), items.begin() + smaller.size() + same.size());
    }
}

int main() {
    // Пример использования функции SORT
    std::vector<int> items = { 34, 7, 23, 32, 5, 62, 32, 45, 32 };

    std::cout << "Исходный массив: ";
    for (const auto& item : items)
        std::cout << item << " ";
    std::cout << std::endl;

    // Вызов функции SORT
    SORT(items);

    std::cout << "Отсортированный массив: ";
    for (const auto& item : items)
        std::cout << item << " ";
    std::cout << std::endl;

    return 0;
}
