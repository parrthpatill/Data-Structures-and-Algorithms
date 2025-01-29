#include<bits/stdc++.h>
using namespace std;

vector<int> frequencyCount(vector<int>& arr) {
        int n = arr.size();
        vector<int> hash(n + 1, 0);
        for (int i = 0; i < n; i++){
            hash[arr[i]] += 1;
        }
        return hash;
    }

int main(){
    

}
