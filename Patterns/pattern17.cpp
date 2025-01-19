#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n;
 	char ch;
 	cin >> n;
 	for(i=0; i<n; i++){
 		ch = 64;
 		for(j=0; j<n-i; j++){
 			cout << " ";
 		}
 		for(j=0; j<2*i + 1; j++){
 			if (j>(2*i + 1)/2){	
 				ch--;
 			}
 			else{
 				ch++;
 			}
 			cout << ch;
 		}
 		for(j=0; j<n-i; j++){
 			cout << " ";
 		}
 		cout << endl;	
 	}

 }