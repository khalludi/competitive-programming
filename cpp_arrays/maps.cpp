#include <stdio.h>
#include <map>
#include <string>
#include <iterator>
#include <iostream>

using namespace std;

int main()
{
    map<string, int> mapOfWords;

    // Insert data
    mapOfWords.insert(make_pair("earth", 1));
    mapOfWords.insert(make_pair("moon", 2));
    mapOfWords["sun"] = 3;

    // replace key by reassignment
    mapOfWords["earth"] = 4;

    // Iterate
    map<string, int>::iterator it = mapOfWords.begin();
    while (it != mapOfWords.end())
    {
        cout << it->first << " :: " << it->second << endl;
        it++;
    }

    // Check insertion success
    if (mapOfWords.insert(make_pair("earth", 1)).second == false)
    {
        cout << "Element with key 'earth' not inserted because already existed" << endl;
    }

    // Search element by key
    if (mapOfWords.find("sun") != mapOfWords.end())
        cout << "word 'sun' found" << std::endl;
    if (mapOfWords.find("mars") == mapOfWords.end())
    {
        cout << "word 'mars' not found" << endl;
    }

    // Deleting data
    map<string, int>::iterator it1 = mapOfWords.find("moon");
    mapOfWords.erase(it1);

    mapOfWords.erase("earth");

    return 0;
}