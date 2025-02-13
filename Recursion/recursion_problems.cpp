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

int factorial3 (int number){
     if(number < 0) return -1;
	if(number < 2) return 1;
	return number*factorial3(number - 1);
}

//sum of first N numbers
int sum(int n){
	if(n == 0) return 0;
	return n + sum(n - 1);
}

// 1**3 + 2**3 + ... n**3
int sumOfSeries(int n) {
    if (n == 0) return 0;
   	return pow(n, 3) + sumOfSeries(n - 1);
}

//Factorials Less than or Equal to n
vector<long long> factorialNumbers(long long n) {
        vector<long long>v;
        long long m, i;
        m = 1; i = 1;
        while(m <= n){
            v.push_back(m);
            m *= i++;
        };
        v.erase(v.begin());
        return v;
   	}
void f(int i, vector<int> &arr, int n){
            if(i >= n/2) return;
            swap(arr[i], arr[n-i-1]);
            f(i+1, arr, n);
        }
        
        
    void reverseArray(vector<int> &arr) {
        int n = arr.size();
        f(0, arr, n);
        for(int i = 0; i < n; i++) cout << arr[i] << " ";
    }
// check palindrome
bool check(int i, int r, string &temp){
        if (i >= r) return true;
        while (i < r && !isalnum(temp[i])) i++;
        while (i < r && !isalnum(temp[r])) r--;
        if (tolower(temp[i]) != tolower(temp[r])) return false;
        else return check(i+1, r-1, temp);
    }
    bool isPalindrome(string s) {
        string temp = s;
        if (temp.empty()) return true;
        return check(0, s.size() - 1, temp);
    }
// Fibonacci series
int fib(int n) {
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

// printing subsequence
    void subsequence(int i, vector<int> sub, int n, vector<int> arr){
        if(i >= n){
            for(auto it: sub){
                cout << it << " ";
            }
            cout << endl;
            return;
        }
        sub.push_back(arr[i]);
        subsequence(i+1, sub, n, arr);
        sub.pop_back();
        subsequence(i+1, sub, n, arr);
    }

// printing subsequences whose sum is k
    void subsequenceSum(int i, vector<int> sub, int n, vector<int> arr, int sum, int k){
        if(i >= n){
            if (sum == k){
                for(auto it: sub){
                    cout << it << " ";
                }
                cout << endl;
            }
            return;
        }
        sub.push_back(arr[i]);
        sum += arr[i];
        subsequenceSum(i+1, sub, n, arr, sum, k);
        sub.pop_back();
        sum -= arr[i];
        subsequenceSum(i+1, sub, n, arr, sum, k);
    }
// printing any one subseqence whose sum is k
bool subsequenceSumAnyOne(int i, vector<int> sub, int n, vector<int> arr, int sum, int k){
        if(i >= n){
            if (sum == k){
                for(auto it: sub){
                    cout << it << " ";
                }
                cout << endl;
                return true;
            }
            else return false;
        }
        sub.push_back(arr[i]);
        sum += arr[i];
        if(subsequenceSumAnyOne(i+1, sub, n, arr, sum, k) == true) return true;
        sub.pop_back();
        sum -= arr[i];
        if(subsequenceSumAnyOne(i+1, sub, n, arr, sum, k) == true) return true;

        return false;
    }

// printing count of subsequences whose sum is k
    int subsequenceSumCount(int i, vector<int> sub, int n, vector<int> arr, int sum, int k){
        if(i >= n){
            if (sum == k){
                return 1;
            }
            else return 0;
        }
        sub.push_back(arr[i]);
        sum += arr[i];
        int l = subsequenceSumCount(i+1, sub, n, arr, sum, k);
        sub.pop_back();
        sum -= arr[i];
        int r = subsequenceSumCount(i+1, sub, n, arr, sum, k);

        return l + r;
    }

int main(){
	vector<int> arr = {1,2,1};
    int n = 3;
    int k = 2;
    vector<int> sub = {};
    cout << subsequenceSumCount(0, sub, n, arr, 0, k);
    return 0;
}

