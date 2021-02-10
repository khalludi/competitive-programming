#include <stdio.h>
#include <algorithm>

using namespace std;

int main()
{

  int people, budget, hotels, weeks;
  while (scanf("%d %d %d %d", &people, &budget, &hotels, &weeks) != EOF)
  {
    int best_price = -1;
    while (hotels > 0)
    {
      hotels--;

      int price, space;
      scanf("%d", &price);

      int wks = weeks;
      while (wks > 0)
      {
        wks--;
        scanf("%d", &space);
        if (space >= people && people * price < budget)
        {
          if (best_price == -1)
            best_price = people * price;
          else
            best_price = min(best_price, price * people);
        }
      }
    }

    if (best_price == -1)
      printf("stay home\n");
    else
      printf("%d\n", best_price);
    fflush(stdout);
  }

  return 0;
}