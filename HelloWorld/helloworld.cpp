#include <stdio.h>

using namespace std;

int main()
{
  // int cases, x, y;
  // scanf("%d", &cases);
  // while (cases > 0)
  // {
  //   --cases;
  //   scanf("%d %d", &x, &y);
  //   printf("%d\n", x + y);
  // }

  int x, y;
  while (scanf("%d %d", &x, &y) != EOF)
  {
    if (x == -1 && y == -1)
      break;
    printf("%d\n", x + y);
    fflush(stdout);
  }
}