package sample;
/*
 * Sample implementation of the BoyreMoores String search algo
 * 
 * Reference : https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_string_search_algorithm
 */
public class BoyreMoore {

	private static int indexOf(char[] searchText, char[] searchString) {
	
		if (searchString.length == 0) {
			return 0;
		}
		
		int[] charTable = makeCharTable(searchString);
		int offsetTable[] = makeOffsetTable(searchString);
		
		for (int i = searchString.length - 1, j; i < searchText.length;) {
            for (j = searchString.length - 1; searchString[j] == searchText[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(offsetTable[searchString.length - 1 - j], charTable[searchText[i]]);
        }
		
		return -1;
	}
	

	private static int[] makeOffsetTable(char[] searchString) {
		
		int[] table = new int[searchString.length];
        
		int lastPrefixPosition = searchString.length;
        
		for (int i = searchString.length - 1; i >= 0; i--) {
            if (isPrefix(searchString, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[searchString.length - 1 - i] = lastPrefixPosition - i + searchString.length - 1;
        }
        
		for (int i = 0; i < searchString.length - 1; ++i) {
            int slen = suffixLength(searchString, i);
            table[slen] = searchString.length - 1 - i + slen;
        }
        return table;
	}
	
	private static int[] makeCharTable(char[] searchString) {
		final int ALPHABET_SIZE = 256;
		int[] table = new int[ALPHABET_SIZE];
		
		for (int i = 0; i < table.length; i++) {
			table [i] = searchString.length;
		}
		
		//this is the weird step i dont get
		for (int i = 0; i < searchString.length; i++) {
            table[searchString[i]] = searchString.length - 1 - i;
        }
		
		return table;
	}
	
	/**
     * Is needle[p:end] a prefix of needle?
     */
    private static boolean isPrefix(char[] searchString, int p) {
        for (int i = p, j = 0; i < searchString.length; i++, j++) {
            if (searchString[i] != searchString[j]) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns the maximum length of the substring ends at p and is a suffix.
     */
    private static int suffixLength(char[] searchString, int p) {
        int len = 0;
        for (int i = p, j = searchString.length - 1;
                 i >= 0 && searchString[i] == searchString[j]; i--, j--) {
            len += 1;
        }
        return len;
    }
	
	
	
	public static void main (String args[]) {
		String searchText = "blah berivbr ugifrerufg u3efuryfgrf hey frofhrfb heyheyhaahaa ue3fiu3firf firfrugfruf";
		String searchString = "hey";
		System.out.println(indexOf(searchText.toCharArray(), searchString.toCharArray()));
	}
}
