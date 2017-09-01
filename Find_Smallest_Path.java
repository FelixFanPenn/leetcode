class FindSmallPath {
    public List<Integer> find(TreeNode root) {
        Result result = helper(root);
        return result.path;
    }

    private Result helper(TreeNode root) {
        if (root == null) {
            Result result = new Result();
            result.path.add(Integer.MAX_VALUE);
            return result;
        }
        if (root.left == null && root.right == null) {
            Result result = new Result();
            result.min = root.val;
            result.path.add(root.val);
            return result;
        }
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result result = new Result();
        result.path.add(root.val);
        if (left.min > right.min) {
            result.path.addAll(right.path);
        }
        else {      // no duplicates in tree. so this is ok!
            result.path.addAll(left.path);
        }
        result.min = Math.min(root.val, Math.min(left.min, right.min));
        return result;
    }
    class Result {
        public int min = Integer.MAX_VALUE;
        public List<Integer> path = new ArrayList<>();
        public Result() {
        }
    }
}