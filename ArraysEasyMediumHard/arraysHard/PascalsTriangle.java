import java.util.ArrayList;
public class PascalsTriangle{

	// FINDING nCr
	int findNcr(int n, int r){
		int res = 1;
		for(int i = 0; i<r; i++){
			res = res*(n-i);
			res = res/(i+1);
		}
		return res;
	}

	// FINDING PARTICULAR ELEMENT IN PASCAL'S TRIANGLE
	int findElementInPascalsTriangle(int row, int column){
		return findNcr(row-1, column-1);
	}

	// FINDING PARTICULAR ROW IN PASCAL'S TRIANGLE
	ArrayList<Integer> nthRowInPascalsTriangle(int row){
		int res = 1;
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(1);
		for(int i = 1; i<row; i++){
			res = res * (row-i);
			res = res/i;
			ans.add(res);
		}
		return ans;
	}

	// PRINT PASCAL'S TRIANGLE FOR N ROWS
	ArrayList<ArrayList<Integer>> completePascalsTriangle(int row){
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 1; i<=row; i++){
			ans.add(nthRowInPascalsTriangle(i));
		}
		return ans;
	}
}