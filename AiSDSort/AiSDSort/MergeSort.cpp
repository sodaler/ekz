#include <iostream>

void merge(int array[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int* L = new int[n1];
    int* R = new int[n2];

    for (int i = 0; i < n1; i++)
        L[i] = array[left + i];
    for (int j = 0; j < n2; j++)
        R[j] = array[mid + 1 + j];

    int i = 0, j = 0;
    int k = left;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        }
        else {
            array[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }

    delete[] L;
    delete[] R;
}

void mergeSort(int array[], int left, int right) {
    if (left >= right)
        return;

    int mid = left + (right - left) / 2;

    mergeSort(array, left, mid);
    mergeSort(array, mid + 1, right);

    merge(array, left, mid, right);
}

int main() {
    int array[] = { 12, 11, 13, 5, 6, 7 };
    int arraySize = sizeof(array) / sizeof(array[0]);

    std::cout << "Original array: ";
    for (int i = 0; i < arraySize; i++)
        std::cout << array[i] << " ";
    std::cout << std::endl;

    mergeSort(array, 0, arraySize - 1);

    std::cout << "Sorted array: ";
    for (int i = 0; i < arraySize; i++)
        std::cout << array[i] << " ";
    std::cout << std::endl;

    return 0;
}
