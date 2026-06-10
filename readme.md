# Assignment 15 — Threading: Race Condition vs Mutex

This folder contains two small POSIX threads (pthreads) C programs that illustrate the difference between unsynchronized access to a shared counter (race condition) and synchronized access using a mutex.

Files

- `counter_race.c` — spawns multiple threads that concurrently increment a shared `counter` without any synchronization. The final counter value is typically less than the expected value due to lost increments caused by the race condition.
- `counter_mutex.c` — same workload, but each increment is protected by a `pthread_mutex_t`. The final counter should equal the expected value.

Goals

- Demonstrate how data races cause incorrect results in multithreaded programs.
- Show how a mutex can serialize access to a shared resource and prevent lost updates.

Build

You need a POSIX-capable compiler and pthreads support (Linux, macOS, or MinGW/MSYS on Windows). Compile with `-pthread`.

```bash
gcc counter_race.c -o counter_race -pthread
gcc counter_mutex.c -o counter_mutex -pthread
```

Run

```bash
./counter_race
./counter_mutex
```

Output (example)

counter_race output will typically show a lower than expected value, for example:

```
=== WITHOUT synchronization (race condition) ===
Threads            : 8
Increments / thread: 1000000
Expected counter   : 8000000

Actual   counter   : 5423912
Lost increments    : 2576088

 Final value is WRONG  race condition caused data loss!
```

counter_mutex output should match the expected value exactly:

```
=== WITH mutex synchronization (correct) ===
Threads            : 8
Increments / thread: 1000000
Expected counter   : 8000000

Actual   counter   : 8000000
Lost increments    : 0

 Final value is CORRECT — mutex eliminated the race!
```

Notes & Suggestions

- Increase `NUM_THREADS` or `INCREMENTS_PER_THREAD` in the source to stress-test timing.
- Replace the mutex with atomic operations (e.g., `__atomic` builtins or `stdatomic.h`) to compare performance.
- Add timing measurements to compare the overhead of mutex locking vs atomic increments.

Security & Portability

- These are simple educational examples and do not handle signal safety or thread cancellation.
- On Windows, use MSYS2/MinGW or WSL to compile and run the programs.
