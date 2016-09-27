public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        int diff = 1;
        
        for (String s: str){
            if (--diff < 0) return false;
            if (!s.equals("#")) diff += 2;    //for String, you MUST use .equals() to check equality
        }
        return diff == 0;
    }
}

/*
public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<Character> st = new Stack();
        st.push('#');
        String[] tokens = preorder.split(",");
        if(tokens.length==1 && tokens[0].equals("#"))return true;
        for(String s : tokens){
            if(st.isEmpty())return false;
                st.pop();
            if(!s.equals("#")){
                st.push('#');
                st.push('#');
            }
        }
        return st.isEmpty();
        
    }
}

/*
        List<String> str = Array.asList(preorder.split(","));   // how to split a string using seperator
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < str.size(); i++){
            if (str.get(i) != "#"){
                num.add(Integer.parseInt(str.get(i)));          // how to convert string to int
            } else {
                num.add(0);
            }
        }
*/
