#include <iostream>
#include <thread>
#include <mutex>
#include <vector>
#include <algorithm>

using namespace std;

bool isPrime(int n)
{
    if (n <= 1)
        return false;

    for (int i = 2; i <= n / 2; i++)
        if (n % i == 0)
            return false;

    return true;
}

int main() {

    int startNumb = 0;
    int endNumb = 25;
// create 3 threads to handel task

    vector<int> primeNumbs = {};
    mutex primeNumbs_mutex;

    thread t1([&startNumb, &endNumb, &primeNumbs, &primeNumbs_mutex]{
        for(int i = startNumb; i < endNumb/2; i++){
            if(isPrime(i)){
                primeNumbs_mutex.lock();
                primeNumbs.push_back(i);
                primeNumbs_mutex.unlock();
            }
        }
    });

    thread t2([&endNumb, &primeNumbs, &primeNumbs_mutex]{
        for(int i = endNumb/2; i < endNumb - endNumb / 8; i++){
            if(isPrime(i)){
                primeNumbs_mutex.lock();
                primeNumbs.push_back(i);
                primeNumbs_mutex.unlock();
            }
        }
    });

    thread t3([&endNumb, &primeNumbs, &primeNumbs_mutex]{
        for(int i = endNumb - endNumb / 8; i <= endNumb; i++){
            if(isPrime(i)){
                primeNumbs_mutex.lock();
                primeNumbs.push_back(i);
                primeNumbs_mutex.unlock();
            }
        }
    });

    t1.join();
    t2.join();
    t3.join();


    sort(primeNumbs.begin(), primeNumbs.end());

    cout << "Prime numbers in range : " << startNumb << " to " << endNumb << endl;
    for(int i : primeNumbs){
        cout << i << " ";
    }

    return 0;
}

