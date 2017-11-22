#include <string>
#include <iostream>
using namespace std;

string super_reduced_string(string s) {
	int i = 1;
	for (i = 1; i<s.length(); i++)
	{
		if (s.at(i)==s.at(i-1))
		{
			s.erase(i - 1, 2);
			i = 0;
		}
	}
	if (s.empty())
	{
		return "Empty String";
	}
	return s;
}

int main() {
	string s;
	cin >> s;
	string result = super_reduced_string(s);
	cout << result << endl;
	system("Pause");
	return 0;
}
