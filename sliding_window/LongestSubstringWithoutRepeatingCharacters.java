public class LongestSubstringWithoutRepeatingCharacters{
	int longestSubstringWithoutRepeatingCharactersBrute(String s){
		int n = s.length();
		int maxLen = 0;
		for(int i = 0; i<n; i++){
			int[] hash = new int[256];
			int len = 0;
			for(int j = i; j<n; j++){
				if(hash[s.charAt(j)] == 0){
					len = j - i + 1;
					maxLen = Integer.max(len, maxLen);
					hash[s.charAt(j)]++;
				} else {
					break;
				}
			}
		}
		return maxLen;
	}

	int longestSubstringWithoutRepeatingCharactersOptimal(String s){
		int l = 0, r = 0, maxLen = 0;
		int[] hash = new int[256];
		while(r < s.length()){
			hash[s.charAt(r)]++;
			while(hash[s.charAt(r)] > 1){
				hash[s.charAt(l)]--;
				l++;
			}
			maxLen = Integer.max(r-l+1, maxLen);
			r++;
		}
		return maxLen;
	}
}