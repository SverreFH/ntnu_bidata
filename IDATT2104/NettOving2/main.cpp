#include <iostream>
#include "Workers.h"

void threadMethod(int nr){
    cout << "Thread : " << nr << endl;
}

int main() {

    Workers worker_threads(4);
    Workers event_loop(1);

    worker_threads.post([]{ threadMethod(1);});
    worker_threads.post([]{ threadMethod(2);});
    worker_threads.post([]{ threadMethod(3);});
    worker_threads.post([]{ threadMethod(4);});
    event_loop.post([]{ threadMethod(5);});
    event_loop.post([]{ threadMethod(6);});
    event_loop.post([]{ threadMethod(7);});
    event_loop.post([]{ threadMethod(8);});


    worker_threads.join();
    event_loop.join();

    return 0;
}
