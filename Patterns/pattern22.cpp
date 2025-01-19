#include<bits/stdc++.h>
using namespace std;
int main () {
 	int i, j, n, val;
 	cin >> n;
 	for (i=0; i<2*n-1; i++) {
 			for (j=0; j<2*n-1; j++) {
 				int left = j;
 				int top = i;
 				int right = (2*n-2)-j;
 				int down = (2*n-2)-i;
 				cout<<(n- min(min(top,down), min(left,right)))<<" ";
 			}
 		 cout << endl;
 		}
 	}