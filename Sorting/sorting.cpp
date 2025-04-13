#include<bits/stdc++.h>
using namespace std;

void selectionSort(int arr[], int size){
	for(int i = 0; i <= size-2; i++){
		int min = i;
		for(int j = i + 1; j <= size-1; j++){
			if(arr[j] < arr[min]) min = j;
		}
		swap(arr[i], arr[min]);
	}
}

void bubbleSort(int arr[], int size){
	for(int i = size - 1; i >= 1; i--){
		for(int j = 0; j <= i-1; j++){
			if(arr[j] > arr[j+1])
				swap(arr[j], arr[j+1]);
		}
	}
}

void insertionSort(int arr[], int n){
	for(int i = 1; i <= n-1; i++){
		int j = i;
		while(arr[j-1] > arr[j]){
			swap(arr[j-1], arr[j]);
			j--;
		}
	}
}

int main(){
	int arr[] = {13, 46, 24, 52, 20, 9};
	int n = 6;
	insertionSort(arr, n);
	for(int i = 0; i < n; i++){
		cout << arr[i] << " ";
	}
	return 0;
}

