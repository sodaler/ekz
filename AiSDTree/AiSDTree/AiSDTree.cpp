#include <iostream>

using namespace std;

class Tree {
private:
    struct Node {
        int data;
        Node* left;
        Node* right;
    };

    Node* root;

    Node* createNode(int data) {
        Node* newNode = new Node();
        newNode->data = data;
        newNode->left = newNode->right = nullptr;
        return newNode;
    }

    Node* insertNodeRec(Node* root, int data) {
        if (root == nullptr) {
            root = createNode(data);
        }
        else if (data <= root->data) {
            root->left = insertNodeRec(root->left, data);
        }
        else {
            root->right = insertNodeRec(root->right, data);
        }
        return root;
    }

    void printInOrderRec(Node* root) {
        if (root == nullptr) return;
        printInOrderRec(root->left);
        cout << root->data << " ";
        printInOrderRec(root->right);
    }

    Node* findMin(Node* root) {
        while (root->left != nullptr) {
            root = root->left;
        }
        return root;
    }

    Node* deleteNodeRec(Node* root, int data) {
        if (root == nullptr) return root;
        else if (data < root->data) root->left = deleteNodeRec(root->left, data);
        else if (data > root->data) root->right = deleteNodeRec(root->right, data);
        else {
            // Узел с одним или без детей
            if (root->left == nullptr) {
                Node* temp = root->right;
                delete root;
                return temp;
            }
            else if (root->right == nullptr) {
                Node* temp = root->left;
                delete root;
                return temp;
            }

            // Узел с двумя детьми: получить наименьший узел в правом поддереве
            Node* temp = findMin(root->right);
            root->data = temp->data;
            // Удалить наименьший узел в правом поддереве
            root->right = deleteNodeRec(root->right, temp->data);
        }
        return root;
    }

public:
    Tree() {
        root = nullptr;
    }

    void addNode(int data) {
        root = insertNodeRec(root, data);
    }

    void printInOrder() {
        cout << "Print tree: ";
        printInOrderRec(root);
        cout << endl;
    }

    void removeNode(int data) {
        root = deleteNodeRec(root, data);
    }
};

int main() {
    Tree tree;

    // Добавление элементов
    string choice;
    int value;
    do {
        cout << "Insert value to add: ";
        cin >> value;
        tree.addNode(value);

        cout << "Add new?: ";
        cin >> choice;
    } while (choice == "y" || choice == "Y");

    // Вывод на экран в порядке восходящего обхода
    cout << "After: ";
    tree.printInOrder();

    do {
        cout << "Insert value to delete: ";
        cin >> value;
        tree.removeNode(value);

        cout << "Add new?: ";
        cin >> choice;
    } while (choice == "y" || choice == "Y");
    // Удаление элемента
   
    cout << "Before: ";
    tree.printInOrder();

    return 0;
}
