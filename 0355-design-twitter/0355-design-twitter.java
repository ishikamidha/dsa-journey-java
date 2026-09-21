import java.util.*;

class Twitter {
    private static int timestamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    private Map<Integer, Set<Integer>> userFollows;
    private Map<Integer, Tweet> userTweets;

    public Twitter() {
        userFollows = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = userTweets.get(userId);
        userTweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (userTweets.containsKey(userId) && userTweets.get(userId) != null) {
            maxHeap.add(userTweets.get(userId));
        }

        Set<Integer> followed = userFollows.get(userId);
        if (followed != null) {
            for (int followeeId : followed) {
                Tweet tweet = userTweets.get(followeeId);
                if (tweet != null) {
                    maxHeap.add(tweet);
                }
            }
        }

        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet top = maxHeap.poll();
            result.add(top.id);
            count++;

            if (top.next != null) {
                maxHeap.add(top.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        userFollows.putIfAbsent(followerId, new HashSet<>());
        userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (userFollows.containsKey(followerId)) {
            userFollows.get(followerId).remove(followeeId);
        }
    }
}