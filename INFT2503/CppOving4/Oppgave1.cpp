#include <iostream>
#include "vector"
#include "algorithm"

using namespace std;

int main() {

    vector<double> doubleValues = {1.1, 2.2, 3.3, 4.4, 5.5};
    cout << "Testing front(): " << doubleValues.front() << endl;
    cout << "Testing back(): " << doubleValues.back() << endl;

    doubleValues.emplace(doubleValues.begin() + 1, 6.6);
    //Not sure what the task was hoping to show here, as the new element is at index 1 whilst
    //the element we get by using front() is at index 0. We can add a statement for printing
    //the element at index 1 to show that the update has happened.
    cout << "Front after emplace: " << doubleValues.front() << endl;
    cout << "Element at index 1 after emplace: " << doubleValues[1] << endl;

    cout << "Looking for value using find()" << endl;
    auto iterator = find(doubleValues.begin(), doubleValues.end(), 3.3);
    if(iterator != doubleValues.end()){
        cout << "Value found: " << *iterator << endl;
    } else {
        cout << "Value not found" << endl;
    }

    return 0;
}
