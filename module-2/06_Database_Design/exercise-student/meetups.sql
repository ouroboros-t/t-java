BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interest_group, group_member,event_attendee,event CASCADE;

--CREATE MEMBER TABLE

CREATE TABLE member (
      member_number SERIAL,
      last_name VARCHAR(100) NOT NULL,
      first_name VARCHAR(100) NOT NULL,
      email_address VARCHAR(254) NOT NULL,
      phone_number CHAR(25),
      date_of_birth DATE,
      get_reminder_email BOOLEAN DEFAULT(true),
      CONSTRAINT PK_member_number PRIMARY KEY(member_number)
);

--ADD MEMBERS:

INSERT INTO member(last_name, first_name, email_address,date_of_birth,get_reminder_email)
VALUES('Doo', 'Scoobert', 'scoobysnacklover45@scrapmail.com', '09-01-1965', false);

INSERT INTO member(last_name, first_name, email_address,phone_number,date_of_birth,get_reminder_email)
VALUES('Fanceh', 'Perfume', 'gracefulskunk@skunkmail.com','876-453-2110', '07-09-1965', true);

INSERT INTO member(last_name, first_name, email_address,phone_number,date_of_birth,get_reminder_email)
VALUES('Dinkley', 'Velma', 'jinkies@minc.org','873-231-7643', '03-09-1951', false);

INSERT INTO member(last_name, first_name, email_address,phone_number,date_of_birth,get_reminder_email)
VALUES('Bunny', 'Bugs', 'buggster@looney.com','998-221-1653', '01-01-1921', true);

INSERT INTO member(last_name, first_name, email_address,date_of_birth,get_reminder_email)
VALUES('Norvelle', 'Shaggert', 'scoobysnacklover420@scrapmail.com', '09-01-1965', false);

INSERT INTO member(last_name, first_name, email_address,phone_number,date_of_birth,get_reminder_email)
VALUES('Nova', 'Casa', 'llolosa@loves.gov','220-321-7421', '04-09-1981', true);

INSERT INTO member(last_name, first_name, email_address,date_of_birth)
VALUES('The Donkey', 'Eeyore', 'juststickhouses@myspace.com', '02-14-1911');

INSERT INTO member(last_name, first_name, email_address,date_of_birth)
VALUES('The Pooh', 'Winnie', 'ohhoneyplease@myspace.com', '02-14-1911');


SELECT * FROM member;





--CREATE GROUP TABLE 

CREATE TABLE interest_group (
        group_number SERIAL,
        name VARCHAR(100) NOT NULL,
        CONSTRAINT group_name_unique UNIQUE(name),
        CONSTRAINT PK_group_number PRIMARY KEY(group_number)
);

--ADD GROUPS:

INSERT INTO interest_group(name) VALUES('Foodies Unite!');
INSERT INTO interest_group(name) VALUES('Friendship is AWESOME!');
INSERT INTO interest_group(name) VALUES('The Third Group! WOW!');


SELECT * FROM interest_group;

--LINK GROUP AND MEMBER TABLES

CREATE TABLE group_member (
        group_number INT NOT NULL,
        member_number INT NOT NULL,
        CONSTRAINT FK_group_number FOREIGN KEY(group_number) REFERENCES interest_group(group_number),
        CONSTRAINT FK_member_number FOREIGN KEY(member_number) REFERENCES member(member_number)
); 


--ADD MEMBERS TO GROUP

------------------------------------------------------------------GROUP 1:
INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'Foodies Unite!'), (SELECT member_number FROM member WHERE first_name = 'Winnie')); 

INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'Foodies Unite!'), (SELECT member_number FROM member WHERE first_name = 'Scoobert'));

INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'Foodies Unite!'), (SELECT member_number FROM member WHERE first_name = 'Shaggert'));

------------------------------------------------------------------GROUP 2:
INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'Friendship is AWESOME!'), (SELECT member_number FROM member WHERE first_name = 'Eeyore'));

INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'Friendship is AWESOME!'), (SELECT member_number FROM member WHERE first_name = 'Velma'));

------------------------------------------------------------------GROUP 3:
INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'The Third Group! WOW!'), (SELECT member_number FROM member WHERE first_name = 'Casa'));

INSERT INTO group_member(group_number, member_number) 
VALUES((SELECT group_number FROM interest_group WHERE name = 'The Third Group! WOW!'), (SELECT member_number FROM member WHERE first_name = 'Bugs'));



SELECT member.member_number, first_name, name FROM group_member AS gm JOIN member ON member.member_number = gm.member_number JOIN interest_group AS ig ON gm.group_number = ig.group_number ;
       

--CREATE EVENT TABLE

CREATE TABLE event (
        event_number SERIAL,
        name VARCHAR(100) NOT NULL,
        description VARCHAR(250),
        start_date_and_time TIMESTAMP WITH TIME ZONE, 
        duration_minutes INT,
        host_group_number INT NOT NULL,
        CONSTRAINT event_name_unique UNIQUE(name),
        CONSTRAINT PK_event_number PRIMARY KEY(event_number),
        CONSTRAINT FK_host_group_number FOREIGN KEY(host_group_number) REFERENCES interest_group(group_number),
        CONSTRAINT CH_duration CHECK(duration_minutes >= 30)
);

--CREATE EVENTS:
INSERT INTO event(name, description, start_date_and_time, duration_minutes, host_group_number) 
VALUES('First Foodie Yummy Cook-Off','Kickin Off With a Cook-Off!', '2021-10-19 18:30:00 EST', 230, (SELECT group_number FROM interest_group WHERE name = 'Foodies Unite!'));

INSERT INTO event(name, start_date_and_time, duration_minutes, host_group_number) 
VALUES('Third Groups Are Fun...', '2021-10-19 18:30:00 EST', 230, (SELECT group_number FROM interest_group WHERE name = 'The Third Group! WOW!'));

INSERT INTO event(name, description, start_date_and_time, duration_minutes, host_group_number) 
VALUES('The Foodicious Conference','The ultimate annual foodie conference for any respectable lover of food', '2022-01-19 08:30:00 EST', 830, (SELECT group_number FROM interest_group WHERE name = 'Foodies Unite!'));

INSERT INTO event(name, description, start_date_and_time, duration_minutes, host_group_number) 
VALUES('SpeedFriending Happy Hour','Come peek from underneath the rock you"ve been living in to make new friends!' , '2021-10-23 17:30:00 EST', 60, (SELECT group_number FROM interest_group WHERE name = 'Friendship is AWESOME!'));



SELECT * FROM event;


--create a link between members and events because many members can be in one event
CREATE TABLE event_attendee (
        event_number INT NOT NULL,
        attendee_number INT NOT NULL,
        CONSTRAINT FK_attendee_number FOREIGN KEY(attendee_number) REFERENCES member(member_number),
        CONSTRAINT FK_event_number FOREIGN KEY(event_number) REFERENCES event(event_number)
);


--ADD attendees(members) to events

------------------------------------------------------------------EVENT 1:


INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='First Foodie Yummy Cook-Off'), (SELECT member_number FROM member WHERE first_name = 'Shaggert'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='First Foodie Yummy Cook-Off'), (SELECT member_number FROM member WHERE first_name = 'Scoobert'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='First Foodie Yummy Cook-Off'), (SELECT member_number FROM member WHERE first_name = 'Winnie'));

------------------------------------------------------------------EVENT 2:
INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='Third Groups Are Fun...'), (SELECT member_number FROM member WHERE first_name = 'Bugs'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='Third Groups Are Fun...'), (SELECT member_number FROM member WHERE first_name = 'Casa'));

------------------------------------------------------------------EVENT 3:
INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='The Foodicious Conference'), (SELECT member_number FROM member WHERE first_name = 'Shaggert'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='The Foodicious Conference'), (SELECT member_number FROM member WHERE first_name = 'Scoobert'));

------------------------------------------------------------------EVENT 4:
INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='SpeedFriending Happy Hour'), (SELECT member_number FROM member WHERE first_name = 'Bugs'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='SpeedFriending Happy Hour'), (SELECT member_number FROM member WHERE first_name = 'Eeyore'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='SpeedFriending Happy Hour'), (SELECT member_number FROM member WHERE first_name = 'Velma'));

INSERT INTO event_attendee(event_number, attendee_number)
VALUES((SELECT event_number FROM event WHERE name ='SpeedFriending Happy Hour'), (SELECT member_number FROM member WHERE first_name = 'Winnie'));





COMMIT;
        




