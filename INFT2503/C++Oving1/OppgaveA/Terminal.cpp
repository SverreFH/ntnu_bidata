#include <iostream>

using namespace std;

int main() {
    const int length = 5;
    double num;

    int subTen = 0;
    int tenToTwenty = 0;
    int aboveTwenty = 0;

    cout << "You should enter " << length << " temperatures" << endl;
    for (int i = 0; i < length; ++i) {
        cout << "Please enter a temperature" << endl;
        cin >> num;
        cout << "Temperature " << i + 1 << " : " << num << endl;
        if(num < 10){
            subTen++;
        } else if(num <= 20){
            tenToTwenty++;
        } else{
            aboveTwenty++;
        }
    }
    cout << "There are " << subTen << " temperatures under ten degrees" << endl;
    cout << "There are " << tenToTwenty << " temperatures between 10 and 20 degrees" << endl;
    cout << "There are " << aboveTwenty << " temperatures above twenty degrees" << endl;
    return 0;
}
