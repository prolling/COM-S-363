CREATE TABLE users (
	screen_name VARCHAR(50),
    name VARCHAR(50),
    sub_category VARCHAR(50),
    category VARCHAR(50),
    ofstate VARCHAR(20),
    numFollowers INTEGER,
    numFollowing INTEGER,
    PRIMARY KEY(screen_name)
);

CREATE TABLE tweet (
	tid BIGINT,
	textbody VARCHAR(280),
    retweet_count INTEGER,
    retweeted INT,
    posted TIMESTAMP, 
    posting_user VARCHAR(50),
    PRIMARY KEY(tid),
    FOREIGN KEY (posting_user) REFERENCES users(screen_name) ON DELETE CASCADE
);

CREATE TABLE mentioned (
	tid BIGINT,
    screen_name VARCHAR(50),
    FOREIGN KEY(tid) REFERENCES tweet(tid),
    FOREIGN KEY(screen_name) REFERENCES users(screen_name)
);
 
CREATE TABLE tagged (
	tid BIGINT,
	hastagname VARCHAR(280),
    PRIMARY KEY(hastagname),
    FOREIGN KEY(tid) REFERENCES tweet(tid)
);

CREATE TABLE url (
	tid BIGINT,
	url VARCHAR(500),
    PRIMARY KEY(url),
    FOREIGN KEY(tid) REFERENCES tweet(tid) ON DELETE CASCADE
);

 
