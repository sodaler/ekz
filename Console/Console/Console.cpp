#include <iostream>
#include <string>

class AirplaneList {
private:
    struct Airplane {
        int tailNumber;
        std::string type;
        std::string model;
        int capacity;
        int range;

        Airplane* prev;
        Airplane* next;

        Airplane(int tNum, std::string t, std::string m, int cap, int rng) :
            tailNumber(tNum), type(t), model(m), capacity(cap), range(rng), prev(nullptr), next(nullptr) {}
    };

    Airplane* head;
    Airplane* tail;

public:
    AirplaneList() : head(nullptr), tail(nullptr) {}

    void addAirplane(int tailNumber, std::string type, std::string model, int capacity, int range) {
        Airplane* newAirplane = new Airplane(tailNumber, type, model, capacity, range);
        if (!head) {
            head = tail = newAirplane;
        }
        else {
            Airplane* current = head;
            Airplane* previous = nullptr;
            while (current && current->tailNumber < tailNumber) {
                previous = current;
                current = current->next;
            }
            if (!previous) {
                newAirplane->next = head;
                head->prev = newAirplane;
                head = newAirplane;
            }
            else {
                newAirplane->next = previous->next;
                newAirplane->prev = previous;
                previous->next = newAirplane;
                if (current) {
                    current->prev = newAirplane;
                }
                else {
                    tail = newAirplane;
                }
            }

        }
    }

    void display() const {
        Airplane* current = head;
        while (current) {
            std::cout << "Tail Number: " << current->tailNumber
                << ", Type: " << current->type
                << ", Model: " << current->model
                << ", Capacity: " << current->capacity
                << ", Range: " << current->range
                << std::endl;
            current = current->next;
        }
    }

    void userInput() {
        char choice;
        do {
            int tailNumber, capacity, range;
            std::string type, model;

            std::cout << "Enter Tail Number: ";
            std::cin >> tailNumber;
            std::cin.ignore();

            std::cout << "Enter Type (Passenger/Cargo/etc): ";
            std::getline(std::cin, type);

            std::cout << "Enter Model: ";
            std::getline(std::cin, model);

            std::cout << "Enter Capacity: ";
            std::cin >> capacity;

            std::cout << "Enter Range: ";
            std::cin >> range;

            addAirplane(tailNumber, type, model, capacity, range);

            std::cout << "Do you want to add another airplane? (y/n): ";
            std::cin >> choice;
        } while (choice == 'y' || choice == 'Y');
    }
};

int main() {
    AirplaneList airplaneList;

    airplaneList.addAirplane(123, "Passenger", "Boeing 747", 500, 10000);
    airplaneList.addAirplane(456, "Cargo", "Airbus A380", 1000, 8000);

    std::cout << "List of airplanes:\n";
    airplaneList.display();

    std::cout << "\nAdd new airplanes:\n";
    airplaneList.userInput();

    std::cout << "\nUpdated list of airplanes:\n";
    airplaneList.display();

    return 0;
}

