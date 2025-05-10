INSERT INTO user_details(id, email, name, password, birth_date)
VALUES (1, 'alice@example.com', 'Alice Johnson', 'pass1234', '1990-03-15'),
       (2, 'bob@example.com', 'Bob Smith', 'secret12', '1985-07-21'),
       (3, 'carol@example.com', 'Carol Lee', 'mypwd987', '1992-11-05'),
       (4, 'david@example.com', 'David Kim', 'letmein00', '1988-06-01'),
       (5, 'emma@example.com', 'Emma Brown', 'abc12345', '1995-12-20'),
       (6, 'frank@example.com', 'Frank Lewis', 'xyz56789', '1982-10-18'),
       (7, 'grace@example.com', 'Grace Clark', 'gracepwd', '1993-02-25'),
       (8, 'henry@example.com', 'Henry Adams', 'hunter22', '1986-08-30'),
       (9, 'irene@example.com', 'Irene Scott', 'p@ssw0rd', '1991-04-12'),
       (10, 'jack@example.com', 'Jack Turner', 'j4ckpass', '1983-09-14'),
       (11, 'kate@example.com', 'Kate Diaz', 'k@t3pwd', '1996-05-08'),
       (12, 'leo@example.com', 'Leo Grant', 'lgr12345', '1994-01-03'),
       (13, 'maya@example.com', 'Maya Bell', 'mayab123', '1989-11-17'),
       (14, 'nick@example.com', 'Nick Fox', 'nickpwd9', '1990-06-11'),
       (15, 'olivia@example.com', 'Olivia Reed', 'olivpass', '1997-07-24'),
       (16, 'peter@example.com', 'Peter Hall', 'p3t3r@pp', '1987-03-02'),
       (17, 'quinn@example.com', 'Quinn Ward', 'qu1nnpwd', '1993-12-19'),
       (18, 'rachel@example.com', 'Rachel Cox', 'r@chel88', '1992-08-06'),
       (19, 'sam@example.com', 'Sam Price', 's4mpass!', '1995-10-27'),
       (20, 'tina@example.com', 'Tina Long', 'tina4you', '1984-01-22'),
       (21, 'uma@example.com', 'Uma Hunt', 'umapwd77', '1996-03-10'),
       (22, 'vince@example.com', 'Vince Cole', 'vince@12', '1988-05-29'),
       (23, 'wendy@example.com', 'Wendy Boyd', 'w3ndypwd', '1991-02-13'),
       (24, 'xavier@example.com', 'Xavier Ray', 'xavpass9', '1990-07-09'),
       (25, 'yvonne@example.com', 'Yvonne Page', 'yvpass23', '1989-04-04'),
       (26, 'zack@example.com', 'Zack Rice', 'zacko123', '1987-06-17'),
       (27, 'lisa@example.com', 'Lisa Newton', 'lisapwd!', '1993-01-31'),
       (28, 'mark@example.com', 'Mark Owen', 'mark@dev', '1985-08-12'),
       (29, 'nina@example.com', 'Nina Ford', 'ninafox1', '1994-09-07'),
       (30, 'oscar@example.com', 'Oscar Neal', 'oscarpwd', '1992-10-15');
ALTER TABLE user_details
    ALTER COLUMN id RESTART WITH 31;


INSERT INTO post (id, user_id, description, title)
VALUES (1, 1, 'This is a test for user 1', 'Testing'),
       (2, 4, 'This is amazing', 'Amazing'),
       (3, 2, 'I started a new blog', 'Blog'),
       (4, 1, 'The test was successfully', 'Finishing testing'),
       (5, 1, 'I am hungy', 'Need to eat');

ALTER TABLE post
    ALTER COLUMN id RESTART WITH 6;