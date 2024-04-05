-- #1 
SELECT t.retweet_count, t.text_body, u.screen_name, u.category, u.sub_category
FROM tweets t, twitteruser u
WHERE year_posted = 2016 AND retweet_count > 0
AND t.posting_user = u.screen_name
ORDER BY retweet_count DESC
LIMIT 10; 

-- #2
SELECT COUNT(DISTINCT CASE WHEN u.state <> 'na' THEN u.state END) AS num_states, GROUP_CONCAT(DISTINCT u.state ORDER BY u.state ASC) AS states, UPPER(h.tag_name) AS hashtag_name
FROM hashtags h
INNER JOIN hashtag_used hu ON h.tag_name = hu.tag_name
INNER JOIN tweets t ON hu.tweet_id = t.tweet_id
INNER JOIN TwitterUser u ON t.posting_user = u.screen_name
WHERE t.year_posted = 2016
GROUP BY h.tag_name
ORDER BY num_states DESC
LIMIT 10;

-- #3
WITH cte AS (
  SELECT DISTINCT u.screen_name, u.state
  FROM twitteruser u, hashtag_used hu, tweets t
  WHERE (hu.tag_name = "iowacaucus" or hu.tag_name = "iacaucus")
    AND hu.tweet_id = t.tweet_id AND t.posting_user = u.screen_name
)
SELECT cte.screen_name, cte.state
FROM cte
INNER JOIN twitteruser u ON cte.screen_name = u.screen_name
ORDER BY u.followers DESC;

-- #4
(SELECT u.screen_name, u.sub_category, u.followers
 FROM twitteruser u
 WHERE u.sub_category = "GOP"
 ORDER BY u.followers DESC
 LIMIT 5)
UNION
(SELECT u.screen_name, u.sub_category, u.followers
 FROM twitteruser u
 WHERE u.sub_category = "Democrat"
 ORDER BY u.followers DESC
 LIMIT 5);
 
 -- #5
 SELECT hu.tag_name, COUNT(t.tweet_id) AS num_tweets
 FROM hashtag_used hu, tweets t, twitteruser u
 WHERE t.month_posted = 1 AND t.year_posted = 2016 AND u.state = "Iowa"
 AND hu.tweet_id = t.tweet_id AND t.posting_user = u.screen_name
 GROUP BY hu.tag_name
 ORDER BY num_tweets DESC;
 
 -- #6
 SELECT t.text_body, hu.tag_name, u.screen_name, u.sub_category
 FROM hashtag_used hu, twitteruser u, tweets t
 WHERE hu.tag_name = "Iowa" AND (u.sub_category = "GOP" or u.sub_category = "Democrat")
 AND t.month_posted = 2 AND t.year_posted = 2016
 AND hu.tweet_id = t.tweet_id AND t.posting_user = u.screen_name;
 
 -- #7
SELECT u.screen_name, COUNT(DISTINCT t_all.tweet_id) AS total_tweets, GROUP_CONCAT(DISTINCT url.url SEPARATOR ', ') AS urls_list
FROM TwitterUser u
JOIN tweets t_all ON u.screen_name = t_all.posting_user
JOIN tweets t_filtered ON u.screen_name = t_filtered.posting_user
JOIN url_used uu ON t_filtered.tweet_id = uu.tweet_id
JOIN urls url ON uu.url = url.url
WHERE u.sub_category = 'GOP' AND t_filtered.year_posted = 2016 AND t_filtered.month_posted = 1
GROUP BY u.screen_name
ORDER BY total_tweets DESC;

 -- #8
SELECT tm.screen_name, COUNT(DISTINCT t.posting_user) AS posting_users_count, u.followers
FROM tweet_mentions tm
JOIN tweets t ON tm.tweet_id = t.tweet_id
JOIN TwitterUser u ON tm.screen_name = u.screen_name
GROUP BY tm.screen_name
ORDER BY COUNT(DISTINCT tm.tweet_id) DESC, posting_users_count DESC, u.followers DESC
LIMIT 10;

 -- #9
SELECT uu.url, COUNT(DISTINCT uu.tweet_id) AS count
FROM url_used AS uu
JOIN tweets AS t ON uu.tweet_id = t.tweet_id
JOIN twitteruser AS u ON t.posting_user = u.screen_name
JOIN urls AS url ON BINARY uu.url = BINARY url.url
WHERE u.sub_category = 'GOP' AND (t.month_posted = 1 OR t.month_posted = 2 OR t.month_posted = 3) AND t.year_posted = 2016
GROUP BY uu.url
ORDER BY count DESC
LIMIT 10;








