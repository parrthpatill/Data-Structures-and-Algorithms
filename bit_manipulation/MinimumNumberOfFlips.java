public class MinimumNumberOfFlips {
	int minimumNumberOfFlips(int start, int goal){
		int xor = start ^ goal;
		int cnt = 0;
		while(xor > 0){
			cnt += xor & 1;
			xor = xor >> 1;
		}
		return cnt;
	}
}