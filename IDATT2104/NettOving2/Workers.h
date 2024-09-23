//
// Created by sverr on 30/01/2024.
//

#ifndef OVING_2_WORKERS_H
#define OVING_2_WORKERS_H

#include "vector"
#include "thread"
#include "queue"
#include "mutex"
#include "condition_variable"

using namespace std;

class Workers {

private:

    bool run = true;
    vector<thread> threads;
    queue<void(*)()> queue;
    mutex queueLock;
    condition_variable cv;

    void work();

public:

    Workers(int nrThreads);

    ~Workers();

    void post(void (*func)());

    void post_delayed(void (*func)());

    void join();

};


#endif //OVING_2_WORKERS_H
