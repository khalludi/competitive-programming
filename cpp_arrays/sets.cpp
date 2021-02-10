#include <iostream>
#include <set>
#include <string>

using namespace std;

int main()
{
    set<string> setOfNumbers;

    // Insert
    setOfNumbers.insert("first");
    setOfNumbers.insert("second");
    setOfNumbers.insert("third");
    setOfNumbers.insert("first");

    // Check size
    cout << "Set Size = " << setOfNumbers.size() << endl;

    // Iterate
    for (set<string>::iterator it = setOfNumbers.begin(); it != setOfNumbers.end(); ++it)
    {
        cout << ' ' << *it;
    }
    cout << "\n";

    // Check if inserted
    if (setOfNumbers.insert("third").second)
    {
        cout << "third was inserted" << endl;
    }
    else
    {
        cout << "third was not inserted" << endl;
    }

    // Remove
    setOfNumbers.erase("second");
}