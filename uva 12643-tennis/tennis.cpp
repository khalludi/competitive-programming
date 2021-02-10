#include <stdio.h>
#include <math.h>

int main()
{
  int N, p1, p2;

  while (scanf("%d %d %d", &N, &p1, &p2) != EOF)
  {
    if (p1 > p2)
    {
      int tmp = p2;
      p2 = p1;
      p1 = tmp;
    }
    double total = pow(2, (double)N) / 2;
    int curr = total;
    for (int i = 1; i <= N; i++)
    {
      if (p1 <= curr && p2 > curr)
      {
        printf("%d\n", N - i + 1);
        fflush(stdout);
        break;
      }
      else
      {
        total /= 2;
        if (p1 > curr)
        {
          curr += total;
        }
        else
        {
          curr -= total;
        }
      }
    }
  }

  return 0;
}