public class Vector2D implements Iterator<Integer> {
    
    int row;
    int col;
    List<List<Integer>> vector;
    public Vector2D(List<List<Integer>> vec2d) {
        vector = vec2d;
        row = 0;
        col = 0;
    }

    @Override
    public Integer next() {
        return vector.get(row).get(col++);
    }

    @Override
    public boolean hasNext() {
        if (vector.size() == 0){
            return false;
        }
        if (vector.get(row).size() > col){
            return true;
        }
        row++;
        while(vector.size() > row && vector.get(row).size() == 0){
            row++;
        }
        
        if (vector.size() == row) return false;
        col = 0;
        return true;
        
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
