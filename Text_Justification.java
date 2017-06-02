public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < words.length){
            int j = i, len = 0;
            while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                len += words[j++].length();
            }
            
            String res = "";
            int space = maxWidth - len;
            for (int k = i; k < j; k++){
                res += words[k];
                if (space > 0) {
                    int tmp;
                    if (j == words.length) {
                        if (j - k == 1) tmp = space;
                        else tmp = 1;
                    } else {
                        if (j - k - 1 > 0) {
                            if (space % (j - k - 1) == 0) tmp = space / (j - k - 1);
                            else tmp = space / (j - k - 1) + 1;
                        } else tmp = space;
                    }
                    
                    for (int m = 0; m < tmp; m++){
                        res += " ";
                    }
                    
                    space -= tmp;
                }
            }
            list.add(res);
            i = j;
        }
        return list;
    }
}