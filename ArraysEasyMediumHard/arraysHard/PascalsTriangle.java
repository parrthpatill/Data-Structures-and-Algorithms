public class PascalsTriangle{
	int findNcr(int n, int r){
		int res = 1;
		for(int i = 0; i<r; i++){
			res = res*(n-i);
			res = res/(i+1);
		}
		return res;
	}
	int findElementInPascalsTriangle(int row, int column){
		return findNcr(row-1, column-1);
	}
}