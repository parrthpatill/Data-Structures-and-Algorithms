#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n;
 	cin >> n;
 	for(i=0; i<n; i++){
 		char ch = 65;
 		for(j=0; j<n-i; j++){
 			cout << ch << " ";
 			ch++;
 		}
 		cout << endl;	
 	}

 }