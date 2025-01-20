#include <bits/stdc++.h>
using namespace std;

void printName(int i, int n){
	if(i  > n) return;
	cout << "zwanzei" << endl;
	printName(i+1, n);
}

//print 1 to n linearly
void printNosLinearly(int i, int n){
	if(i  > n) return;
	cout << i << endl;
	printNosLinearly(i+1, n);
}

//print n to 1
void printNosNto1(int i, int n){
	if(i < 1) return;
	cout << i << endl;
	printNosNto1(i-1, n);
}

//print 1 to n using backtracking
void print1toNBacktracking(int i, int n){
	if(i < 1) return;
	print1toNBacktracking(i-1, n);
	cout << i << endl;
}

//print 1 to n using backtracking
void printNto1Backtracking(int i, int n){
	if(i > n) return;
	printNto1Backtracking(i+1, n);
	cout << i << endl;
}

int main(){
	printNto1Backtracking(1,10);

}

