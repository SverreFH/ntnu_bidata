#include <iostream>
#include "string"

using namespace std;

int main() {
    cout << "Hello" << endl;
    string word1;
    string word2;
    string word3;
    cout << "Enter the first word" << endl;
    cin >> word1;
    cout << "Enter the second word" << endl;
    cin >> word2;
    cout << "Enter the third word" << endl;
    cin >> word3;

    string sentence = word1 + " " + word2 + " " + word3 + ".";
    cout << "You wrote: " << sentence << endl;

    cout << "Your first word is " << word1.length() << " characters long" << endl;
    cout << "Your second word is " << word2.length() << " characters long" << endl;
    cout << "Your third word is " << word3.length() << " characters long" << endl;
    //Including spaces and punctuation
    cout << "The total sentence length is " << sentence.length() << " characters long" << endl;

    string sentence2 = sentence;
    if (sentence2.length() > 12) {
        sentence2.replace(10, 3, "xxx");
        cout << "Original sentence: " << sentence << endl;
        cout << "Modified sentence: " << sentence2 << endl;
    } else {
        cout << "Sentence not long enough for replacements" << endl;
    }

    string sentenceStart;
    if(sentence.length() > 5){
        sentenceStart = sentence.substr(0,5);
        cout << "Your sentence is: " << sentence << endl;
        cout << "The first five characters of the sentence are: " << sentenceStart << endl;
    } else {
        cout << "sentence is less than 5 characters long" << endl;
    }

    if (sentence.find("hallo") != string::npos) {
        std::cout << "\"hallo\" is found in the string." << std::endl;
    } else {
        std::cout << "\"hallo\" is not found in the string." << std::endl;
    }

    string searchFor = "er";

    int count = 0;
    size_t pos = 0;

    // Search for the substring in the main string
    while ((pos = sentence.find(searchFor, pos)) != string::npos) {
        ++count;            // Increment count for each occurrence
        pos += searchFor.length();  // Move to the next position after the current occurrence
    }

    cout << "The substring '" << searchFor << "' occurs " << count << " times." << std::endl;
}