#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n, stars, space;
 	cin >> n; 
 	for (i=1; i<=2*n-1; i++) {
 		stars = i;
 		space = 2*n-2*i;
 		if (i>n) {
 			stars = 2*n-i;
 			space += 2*(-space);
 		}
 		for (j=1; j<=stars; j++) {
 			cout << "*";
 		}
 		for (j=1; j<=space; j++) {
 			cout << " ";
 		}
 		for (j=1; j<=stars; j++) {
 			cout << "*";
 		}
 		cout << endl;
 	}
 }