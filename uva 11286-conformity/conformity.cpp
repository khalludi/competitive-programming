#include <stdio.h>
#include <set>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
  int testcases;
  while (scanf("%d", &testcases) != EOF)
  {
    // Exit
    if (testcases == 0)
    {
      break;
    }

    map<int, set<int>> course_map;
    while (testcases)
    {
      int n1;
      int idx = 5;
      while (idx > 0)
      {
        scanf("%d", &n1);
        map<int, set<int>>::iterator it = course_map.find(n1);
        if (it == course_map.end())
        {
          set<int> tmp;
          tmp.insert(testcases);
          course_map.insert(make_pair(n1, tmp));
        }
        else
        {
          it->second.insert(testcases);
        }

        idx--;
      }

      testcases--;
    }

    // Get second sheet
    vector<int> values;
    map<int, set<int>>::iterator it = course_map.begin();
    while (it != course_map.end())
    {
      values.push_back(it->second.size());
      // printf("%d :: %d\n", it->first, it->second.size());
      it++;
    }

    // Find 5 largest values
    int idx_arr[5] = {};
    for (int i = 0; i < 5; i++)
    {
      int maxi = 0;
      int tmp_idx;
      for (int j = 0; j < values.size(); j++)
      {
        if (values.at(j) > maxi)
        {
          idx_arr[i] = j;
        }
      }

      values[idx_arr[i]] = -1;
    }

    // Sort
    sort(begin(idx_arr), end(idx_arr));

    // Get students
    set<int> students;
    map<int, set<int>>::iterator it2 = course_map.begin();
    int k = 0;
    int m = 0;
    while (it2 != course_map.end())
    {
      if (k == idx_arr[m])
      {
        students.insert(it2->second.begin(), it2->second.end());
        m++;
      }
      k++;
      it2++;
    }

    printf("%d\n", students.size());
  }
}