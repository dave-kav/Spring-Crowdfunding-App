INSERT INTO Users (id, full_name, user_name, password, credit_limit) VALUES (1, 'Dave Kavanagh', 'davykav87', 123456789, 2000);
INSERT INTO Users (id, full_name, user_name, password, credit_limit) VALUES (2, 'Thomas O Halloran', 'tamoh1', 147258369, 3000);
INSERT INTO Users (id, full_name, user_name, password, credit_limit) VALUES (3, 'Darren Smith', 'foxylocks', 987654321, 5500);

INSERT INTO Projects (id, name, description, image, goal_amt, time_limit) VALUES (1, 'Trickstick', 'unique, high res, handheld LED POV display.', 'someURL', 98000, 30);
INSERT INTO Projects (id, name, description, image, goal_amt, time_limit) VALUES (2, 'Dialect: A Game about Language and How it Dies', 'Build a language, build a world.', 'someURL', 3000, 15);
INSERT INTO Projects (id, name, description, image, goal_amt, time_limit) VALUES (3, 'Findster Duo - The 1st GPS Pet Tracker Free of Monthly Fees!', 'Findster Duo tracks your pets location using GPS with no data fees.', 'someURL', 50000, 45);

INSERT INTO Pledges VALUES (1, 150, false, 1);
INSERT INTO Pledges VALUES (2, 100, false, 1);
INSERT INTO Pledges VALUES (3, 50, false, 1);
INSERT INTO Pledges VALUES (4, 70, false, 2);
INSERT INTO Pledges VALUES (5, 500, false, 2);
INSERT INTO Pledges VALUES (6, 100, false, 3);

INSERT INTO User_projects VALUES (1,1), (2,2), (3,3);

INSERT INTO User_pledges VALUES (1,1), (1,2), (2,3), (2,4), (3,5), (3,6);

INSERT INTO Project_pledges VALUES (1,1), (2,2), (3,3), (1,4), (2,5), (3,6);
