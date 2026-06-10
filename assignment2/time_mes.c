#include <stdio.h>

#include <time.h>

void linearFun(int n) {

  int max = n;

  int target = n;

  volatile long sum = 0;

  for (int i = 1; i <= max; i++) {

    sum += i * i;

    if (i == target) {

      printf("Completed Linear Serach.\n");

      return;
    }
  }
}

void logaritmicFun(int n) {

  int max = n;

  int target = n;

  int st = 1;

  int end = max;

  while (st <= end) {

    int mid = (st + end) / 2;

    if (mid == target) {

      printf("Completed Exponetial Search\n");

      return;

    }

    else if (mid > target) {

      end = mid - 1;

    }

    else {

      st = mid + 1;
    }
  }
}

void quadraticFun(int n) {

  int max = n;

  volatile long sink = 0;

  for (int i = 1; i <= n; i++) {

    for (int j = 1; j <= n; j++) {

      sink += i;
    }
  }

  printf("Completed Quadrratic Function.\n");
}

int main() {

  printf("Enter number of inputs: ");

  int inputs;

  scanf("%d", &inputs);

  printf("Executing logarithmic function: \n");

  time_t log_st = clock();

  logaritmicFun(inputs);

  time_t log_end = clock();

  printf("Executing Linear function: \n");

  time_t linear_st = clock();

  linearFun(inputs);

  time_t linear_end = clock();

  printf("Executing Quadratic function: \n");

  time_t quad_st = clock();

  quadraticFun(inputs);

  time_t quad_end = clock();

  double linearTime = ((float)linear_end - (float)linear_st) / CLOCKS_PER_SEC;

  double logarithmicTime = ((float)log_end - (float)log_st) / CLOCKS_PER_SEC;

  double quadTime = ((float)quad_end - (float)quad_st) / CLOCKS_PER_SEC;

  printf("Time(in seconds) to perform logarithmic operation on %d input size: "
         "%lf\n",
         inputs, logarithmicTime);

  printf("Time(in seconds) to perform linear operation on %d input size: %lf\n",
         inputs, linearTime);

  printf(
      "Time(in seconds) to perform quadratic operation on %d input size: %lf\n",
      inputs, quadTime);
}