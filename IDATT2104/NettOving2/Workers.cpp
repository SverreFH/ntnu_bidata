//
// Created by sverr on 30/01/2024.
//
#include <iostream>
#include <mutex>
#include <thread>
#include "Workers.h"

Workers::Workers(int nrThreads) {
    threads.reserve(nrThreads);
    for (int i = 0; i < nrThreads; i++){
        threads.emplace_back(&Workers::work, this);
    }
}

Workers::~Workers() {
    join();
}

void Workers::post(void (*func)()) {
    queueLock.lock();
    queue.push(func);
    queueLock.unlock();
    cv.notify_one();
}

void Workers::post_delayed(void (*func)()) {
    this_thread::sleep_for(3s);
    queueLock.lock();
    queue.push(func);
    queueLock.unlock();
    cv.notify_one();
}

void Workers::work() {
    while(!queue.empty() || run){
        unique_lock<mutex> lock (queueLock);

        while(queue.empty() && run){
            cv.wait(lock);
        }

        if(queue.empty() && !run){
            lock.unlock();
            cv.notify_one();
            break;
        }

        void (*task)() = queue.front();
        queue.pop();

        cv.notify_one();

        task();
    }
}

void Workers::join() {
    if(!run){
        return;
    }

    run = false;
    cv.notify_one();

    for(thread& thread : threads){
        thread.join();
    }
}