#include <bits/stdc++.h>
using namespace std;

void fun(int ln, int star) {
    if (ln > 7) return;

    if (ln < 5) {
        if (star > ln) {
            cout << endl;
        } else {
            cout << "* ";
            fun(ln, star + 1);
        }
    } else {
        if (star > (8 - ln)) {
            cout << endl;
        } else {
            cout << "* ";
            fun(ln, star + 1);
        }
    }

    if (star == 1) fun(ln + 1, 1); // Move to next line after printing
}

int main() {
    fun(1, 1);
    return 0;
}
