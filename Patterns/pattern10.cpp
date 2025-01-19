#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n, stars;
 	cin >> n;
 	for(i=1; i<=2*n-1; i++){
 		int stars = i;
 		if (i>n) stars = 2*n-i;
 		for(j=1; j<=stars; j++){
 			cout << "* ";
 		}
 		cout << endl;	
 	}

 }