#include <iostream>
#include <cstdlib>
#include <fstream>

using namespace std;
void read_temperatures(double temperatures[], int length){
    const char filename[] = "../OppgaveB/Temperatures.txt";
    ifstream file;
    file.open(filename);
    if(!file){
        cout << "Failed to open file" << endl;
        exit(EXIT_FAILURE);
    }
    string entry;
    int lineCount = 0;
    while(getline(file, entry) && lineCount < length){
        temperatures[lineCount] = stod(entry);
        lineCount++;
    }
}

int main() {
    const int length = 5;
    double temperatures[length];

    read_temperatures(temperatures, length);

    int subTen = 0;
    int tenToTwenty = 0;
    int aboveTwenty = 0;

    for(int i = 0; i < length; i++) {
        cout << "Temperature " << i + 1 << ": " << temperatures[i] << endl;
        if(temperatures[i] < 10){
            subTen++;
        } else if(temperatures[i] <= 20){
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
