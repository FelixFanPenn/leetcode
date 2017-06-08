public class ValidWordAbbr {
    
    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dic) {
        for (String s : dic){
            if (map.containsKey(getAbbr(s))) {
                if (!map.get(getAbbr(s)).equals(s)) {
                    map.put(getAbbr(s), "");
                } else {
                    map.put(getAbbr(s), s);
                }
            } else {
                map.put(getAbbr(s), s);
            }
        }
    }
    
    public boolean isUnique(String s) {
        return !map.containsKey(getAbbr(s)) || map.get(getAbbr(s)).equals(s);
    }
    
    public String getAbbr(String s){
        int len = s.length();
        if (len < 2) return s;
        char b = s.charAt(0);
        char e = s.charAt(s.length()-1);
        return "" + b + (s.length()-2) + e;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */