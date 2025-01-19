#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n;
 	cin >> n;
 	char ch = 65;
 	for(i=0; i<n; i++){
 		for(j=0; j<=i; j++){
 			cout << ch;
 		}
 		ch++;
 		cout << endl;	
 	}

 }