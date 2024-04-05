
Use project3;
SET GLOBAL local_infile = 'ON';  
LOAD DATA LOCAL INFILE "C:\\Users\\paige\\OneDrive\\Desktop\\Iowa State\\COM S 363\\project3\\dataCSV\\user.csv"
INTO TABLE users
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

Use project3;
SET GLOBAL local_infile = 'ON';  
LOAD DATA LOCAL INFILE "C:\\Users\\paige\\OneDrive\\Desktop\\Iowa State\\COM S 363\\project3\\dataCSV\\tweets.csv"
INTO TABLE tweet
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

Use project3;
SET GLOBAL local_infile = 'ON';  
LOAD DATA LOCAL INFILE "C:\\Users\\paige\\OneDrive\\Desktop\\Iowa State\\COM S 363\\project3\\dataCSV\\mentioned.csv"
INTO TABLE mentioned
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

Use project3;
SET GLOBAL local_infile = 'ON'; 
LOAD DATA LOCAL INFILE "C:\\Users\\paige\\OneDrive\\Desktop\\Iowa State\\COM S 363\\project3\\dataCSV\\tagged.csv"
INTO TABLE tagged
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

Use project3;
SET GLOBAL local_infile = 'ON';  
LOAD DATA LOCAL INFILE "C:\\Users\\paige\\OneDrive\\Desktop\\Iowa State\\COM S 363\\project3\\dataCSV\\urlused.csv"
INTO TABLE url
FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;


