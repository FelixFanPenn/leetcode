public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l1 = C - A;
        int w1 = D - B;

        int l2 = G - E;
        int w2 = H - F;

        int ret = l1 * w1 + l2 * w2;

        if (G <= A || C <= E || H <= B || D <= F) //no overlap
            return ret;

        int l3 = Math.min(C, G) - Math.max(A, E);
        int w3 = Math.min(D, H) - Math.max(B, F);
        int overlap = l3 * w3;

        return ret - overlap;
    }
}