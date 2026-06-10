
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#define NUM_THREADS          8
#define INCREMENTS_PER_THREAD 1000000          


long long counter = 0;
void *increment(void *arg)
{
    for (int i = 0; i < INCREMENTS_PER_THREAD; i++) {
        counter++;
    }
    return NULL;
}

int main(void)
{
    pthread_t threads[NUM_THREADS];

    long long expected = (long long)NUM_THREADS * INCREMENTS_PER_THREAD;
    printf("=== WITHOUT synchronization (race condition) ===\n");
    printf("Threads            : %d\n", NUM_THREADS);
    printf("Increments / thread: %d\n", INCREMENTS_PER_THREAD);
    printf("Expected counter   : %lld\n\n", expected);

    /* ── Create threads */
    for (int i = 0; i < NUM_THREADS; i++) {
        if (pthread_create(&threads[i], NULL, increment, NULL) != 0) {
            perror("pthread_create");
            exit(EXIT_FAILURE);
        }
    }

    /*  Wait for all threads to finish  */
    for (int i = 0; i < NUM_THREADS; i++) {
        if (pthread_join(threads[i], NULL) != 0) {
            perror("pthread_join");
            exit(EXIT_FAILURE);
        }
    }

    printf("Actual   counter   : %lld\n", counter);
    printf("Lost increments    : %lld\n", expected - counter);
    printf("\n Final value is WRONG  race condition caused data loss!\n");

    return 0;
}