#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NUM_THREADS           8
#define INCREMENTS_PER_THREAD 1000000          /* 1 million increments each */


long long counter = 0;

pthread_mutex_t counter_mutex = PTHREAD_MUTEX_INITIALIZER;

void *increment(void *arg)
{
    for (int i = 0; i < INCREMENTS_PER_THREAD; i++) {

       
        pthread_mutex_lock(&counter_mutex);
        
        counter++;
        
        pthread_mutex_unlock(&counter_mutex);
    }
    return NULL;
}

int main(void)
{
    pthread_t threads[NUM_THREADS];

    long long expected = (long long)NUM_THREADS * INCREMENTS_PER_THREAD;
    printf("=== WITH mutex synchronization (correct) ===\n");
    printf("Threads            : %d\n", NUM_THREADS);
    printf("Increments / thread: %d\n", INCREMENTS_PER_THREAD);
    printf("Expected counter   : %lld\n\n", expected);

    for (int i = 0; i < NUM_THREADS; i++) {
        if (pthread_create(&threads[i], NULL, increment, NULL) != 0) {
            perror("pthread_create");
            exit(EXIT_FAILURE);
        }
    }


    for (int i = 0; i < NUM_THREADS; i++) {
        if (pthread_join(threads[i], NULL) != 0) {
            perror("pthread_join");
            exit(EXIT_FAILURE);
        }
    }


    pthread_mutex_destroy(&counter_mutex);

    printf("Actual   counter   : %lld\n", counter);
    long long delta = expected - counter;
    printf("Lost increments    : %lld\n", delta);

    if (delta == 0)
        printf("\n Final value is CORRECT — mutex eliminated the race!\n");
    else
        printf("\n Something went wrong (should not happen with the mutex).\n");

    return 0;
}