public class Twitter {
    private static int timeStamp = 0;
    HashMap<Integer, Set<Integer>> followMap;
    HashMap<Integer, ArrayList<Tweet>> tweetMap;
    
    private class Tweet{
        public int id;
        public int time;
        
        Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
        }
        
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId);
        
        if (!tweetMap.containsKey(userId)){
            tweetMap.put(userId, new ArrayList<>());
        }
        follow(userId, userId);
        tweetMap.get(userId).add(t);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
           @Override
           public int compare(Tweet t1, Tweet t2){
               return t2.time - t1.time;
           }
        });
        
        List<Integer> res = new ArrayList<>();
        Set<Integer> users = new HashSet<>();
        users.add(userId);
        
        if (followMap.containsKey(userId)) {
		    users.addAll(followMap.get(userId));
	    }
        
        for (int i : users){
            if (tweetMap.containsKey(i)){
                for (Tweet t : tweetMap.get(i)){
                    queue.offer(t);
                }
            }
        }
        
        int i = 0;
        while (i < 10 && !queue.isEmpty()){
            res.add(queue.poll().id);
            i++;
        }
        
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followMap.get(followerId);
        if (set == null){
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followMap.get(followerId);
        if (set == null){
            followMap.put(followerId, new HashSet<Integer>());
        }
        followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
