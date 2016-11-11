 CREATE TABLE Users (
  id			INT(11) NOT NULL AUTO_INCREMENT,
  full_name		VARCHAR(30),
  user_name		VARCHAR(20),
  password		VARCHAR(20),
  credit_limit	FLOAT(15)
);

CREATE TABLE Projects (
  project_id	INT(11) NOT NULL AUTO_INCREMENT,
  name			VARCHAR(30),
  description	VARCHAR(500),
  image_url		VARCHAR(100),
  goal_amount	FLOAT(15),
  time_limit	INT(11),
  user_id		INT(11),
  FOREIGN KEY 	(user_id) REFERENCES Users(id)
);

 CREATE TABLE Pledges (
  pledge_id		INT(11) NOT NULL AUTO_INCREMENT,
  amount		FLOAT(11),
  permanent		BOOLEAN,
  user_id		INT(11),
  FOREIGN KEY 	(user_id) REFERENCES Users(id)
);