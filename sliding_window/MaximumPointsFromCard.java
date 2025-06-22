public class MaximumPointsFromCard{
	int MaximumPointsFromCard(int[] cardPoints, int k){
		int maxPoints = 0;
		int sum = 0;
		for(int i = 0; i < k; i++){
			sum+= cardPoints[i];
		}
		int n = cardPoints.length;
		maxPoints = Integer.max(maxPoints, sum);
		int ind = 1;
		for(int i = k-1; i>=0; i--){
			sum -= cardPoints[i];
			sum += cardPoints[n - ind++];
			maxPoints = Integer.max(maxPoints, sum);
		}
		return maxPoints;
	}
}