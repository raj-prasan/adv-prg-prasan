#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

int buffer = 0;

// Semaphores
sem_t empty;
sem_t full;

// Mutex
pthread_mutex_t mutex;

// Producer function
void* producer(void* arg) {

    for(int i = 1; i <= 5; i++) {

        sem_wait(&empty);

        pthread_mutex_lock(&mutex);

        buffer = i;
        printf("Producer produced: %d\n", buffer);

        pthread_mutex_unlock(&mutex);

        sem_post(&full);

        sleep(1);
    }

    return NULL;
}

// Consumer function
void* consumer(void* arg) {

    for(int i = 1; i <= 5; i++) {

        sem_wait(&full);

        pthread_mutex_lock(&mutex);

        printf("Consumer consumed: %d\n", buffer);

        pthread_mutex_unlock(&mutex);

        sem_post(&empty);

        sleep(1);
    }

    return NULL;
}

int main() {

    pthread_t p, c;

    // Initialize semaphores
    sem_init(&empty, 0, 1);
    sem_init(&full, 0, 0);

    // Initialize mutex
    pthread_mutex_init(&mutex, NULL);

    // Create threads
    pthread_create(&p, NULL, producer, NULL);
    pthread_create(&c, NULL, consumer, NULL);

    // Wait for threads
    pthread_join(p, NULL);
    pthread_join(c, NULL);

    // Destroy
    sem_destroy(&empty);
    sem_destroy(&full);
    pthread_mutex_destroy(&mutex);

    return 0;
}