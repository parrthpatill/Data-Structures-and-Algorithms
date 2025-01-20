#include<bits/stdc++.h>
using namespace std;

int countDigits(int n){
	// Write your code here.
	int cnt, x, temp;
	temp = n;
	cnt = 0;
	while (n > 0){
		x = n % 10;
		n = n/10;
                if (x != 0) {
                  if (temp % x == 0)
                    cnt++;
                }
        }

	return cnt;
}

 int reverseNumber(int n) {
	 	int revNum = 0, x;
	 	while (n > 0) {
	 		x = n % 10;
	 		revNum = (revNum * 10) + x;
	 		n /= 10;
	 	}
	 	return revNum;
	 }
int reverse(int x) {
    long revNum = 0, r;
    while (x != 0){
        r = x % 10;
        revNum = revNum * 10 + r;
        x /= 10;
    }
  		if (revNum > INT_MAX || revNum < INT_MIN) return 0;
  		else return revNum;
	}
	
    bool isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int temp = x;
	 	long long revNum = 0;
	 	while (x != 0) {
	 		revNum = (revNum * 10) + x%10;
	 		x /= 10;
    	}
    if (temp == revNum) return true;
	else return false;
	}

bool checkArmstrong(int n){
	if (n < 1) return false;
	int r, cnt = 0;
	int temp = n;
	int armNum = 0;
	vector <int> v;
        while (n != 0){
            r = n % 10;
			cnt++;
			v.emplace_back(r);
            n /= 10;
        }
    for (auto it : v){
    	cout << it;
    	}
	for (int i : v){
		armNum += pow(i, cnt);
		}
	if (armNum == temp) return true;
    else return false;
	}

int sumOfAllDivisors(int n){
	int sum=1, i, j;
    for (i=2; i=n; i++){
        for(j=1; j=sqrt(i); j++){
            if(i%j==0){
                if(j==i/j) sum+=j;
                else sum += j + i/j;
            } 
       	}
    }
    return sum;
}

bool isPrime(int n)
{
	if(n<2) return false;
	int i;
	for(i = 2; i*i <= n; i++){
		if (n%i == 0) return false;
	}
	return true;
    
}

 vector<int> lcmAndGcd(int a, int b) {
        vector<int> ls;
        int gcd, lcm, c=a, d=b;
        while (a != 0 && b != 0) {
            if(a>b) a %= b;
            else b %= a;
        }
        if (a == 0) gcd = b;
        else gcd = a;
        
        lcm = (c*d)/gcd;
        
        ls.push_back(lcm);
        ls.push_back(gcd);
        
        return ls;
    }


int main (){
	
	return 0;
}
