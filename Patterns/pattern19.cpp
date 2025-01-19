#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n, sp=0;
 	cin >> n;
 	for(i=n; i>0; i--){
 		for(j=0; j<i; j++){
 			cout << "*";
 		}
 		for(j=0; j<sp; j++){
 			cout << " ";
 		}
 		for(j=0; j<i; j++){
 			cout << "*";
 		}
 		sp += 2;
 		cout << endl;	
 	}
 	sp = 2*(n-1);
 	for(i=0; i<n; i++){
 		for(j=0; j<=i; j++){
 			cout << "*";
 		}
 		for(j=0; j<sp; j++){
 			cout << " ";
 		}
 		for(j=0; j<=i; j++){
 			cout << "*";
 		}
 		sp -= 2;
 		cout << endl;	
 	}
 }