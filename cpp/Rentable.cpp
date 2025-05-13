#include <iostream>
#include <string>
#include <chrono>
#include <ctime>
#include <iomanip>
#include <sstream>

using namespace std;
using namespace std::chrono;

class Rentable {
private:
    system_clock::time_point returnDate;  

    string countDays(double numDays) {
        auto now = system_clock::now();
        auto addedDuration = duration_cast<system_clock::duration>(
            duration<double, std::ratio<86400>>(numDays));
        auto futureTime = now + addedDuration;
        returnDate = futureTime;  

        time_t futureTimeT = system_clock::to_time_t(futureTime);
        stringstream ss;
        ss << put_time(localtime(&futureTimeT), "%Y-%m-%d");
        return ss.str();
    }

public:
    string name;
    bool rented;
    Rentable(string n) : name(n), rented(false) {}

    void setName(string n) {
        if (n.empty()) {
            cout << "Name cannot be empty, please enter a name" << endl;
        } else {
            name = n;
        }
    }

    string getName() const {
        return name;
    }

    bool getRented() const {
        return rented;
    }

    void rent(double duration) {
        if (duration <= 0) {
            cout << "Please enter a positive duration" << endl;
            return;
        }

        if (!rented) {
            rented = true;
            cout << "You rented a " << name << " for " << duration << " days." << endl;
            string availableDate = countDays(duration);
            cout << "The rental will be terminated on " << availableDate << endl;
        } else {
            cout << "This item is already rented." << endl;
        }
    }

    string getAvailabilityDate() const {
        if (!rented) {
            return "This item is currently available.";
        }

        time_t returnTimeT = system_clock::to_time_t(returnDate);
        stringstream ss;
        ss << "This item will be available on " << put_time(localtime(&returnTimeT), "%Y-%m-%d");
        return ss.str();
    }
};

int main() {
    string name;
    float duration;

    cout << "What would you want to rent? ";
    cin >> name;
    cout << "How many days would be the rental? ";
    cin >> duration;

    Rentable rentable(name);
    rentable.rent(duration);

    cout << rentable.getAvailabilityDate() << endl;

    return 0;
}

