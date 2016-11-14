INSERT INTO Users (id, full_name, user_name, password, credit_limit) VALUES (1, 'Dave Kavanagh', 'davykav87', 123456789, 2000);
INSERT INTO Users (userId, full_name, user_name, password, credit_limit) VALUES (2, 'Thomas O Halloran', 'tamoh1', 147258369, 3000);
INSERT INTO Users (userId, full_name, user_name, password, credit_limit) VALUES (3, 'Darren Smith', 'foxylocks', 987654321, 5500);

INSERT INTO Projects (id, name, description, imgUrl, goalAmt, timeLimit) VALUES (1, 'Trickstick', 'The Trickstick is a unique, high res, handheld LED POV display. Wave it and a colorful, detailed image appears in thin air – Magic!', 'https://ksr-ugc.imgix.net/assets/014/337/274/29ae0199e1917fb66c0909bfdb05e79a_original.jpg?w=680&fit=max&v=1477958772&auto=format&q=92&s=2b4d83c488c1f133514b1a4191287c2f', 98000, 30);
INSERT INTO Projects (projectId, name, description, imgUrl, goalAmt, timeLimit) VALUES (2, 'Dialect: A Game about Language and How it Dies', 'Build a language, build a world. Who were the Isolation, and how were they lost? In this game, your language is the story.', 'https://ksr-ugc.imgix.net/assets/014/233/249/f0daaca7912d700d58bd3e060588e987_original.png?w=680&fit=max&v=1477272636&auto=format&lossless=true&s=e252984bb5348f17783ef41b0bf1a7e5', 3000, 15);
INSERT INTO Projects (projectId, name, description, imgUrl, goalAmt, timeLimit) VALUES (3, 'Findster Duo - The 1st GPS Pet Tracker Free of Monthly Fees!', 'Findster Duo tracks your pets’ location using GPS with no data fees, and rewards you for keeping them healthy! Smart. Connected. Fun.', 'https://ksr-ugc.imgix.net/assets/012/925/070/6710c78aee17b9225cf4ccd1a1194f7f_original.png?w=680&fit=max&v=1467382915&auto=format&lossless=true&s=e412ed1cd0b66d859de6a3eec4fcaf80', 50,000, 45);

INSERT INTO Pledges VALUES (1, 150, false, 1);
INSERT INTO Pledges VALUES (2, 100, false, 1);
INSERT INTO Pledges VALUES (3, 50, false, 1);
INSERT INTO Pledges VALUES (4, 70, false, 2);
INSERT INTO Pledges VALUES (5, 500, false, 2);
INSERT INTO Pledges VALUES (6, 100, false, 3);

INSERT INTO User_projects VALUES (1,1), (2,2), (3,3);

INSERT INTO User_pledges VALUES (1,1), (1,2) (2,3), (2,4), (3,5), (3,6);

INSERT INTO Project_pledges VALUES (1,1), (2,2), (3,3), (1,4), (2,5), (3,6);
