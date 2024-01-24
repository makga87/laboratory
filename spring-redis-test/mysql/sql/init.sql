CREATE TABLE IF NOT EXISTS spring_redis_test.ticket(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    member_no INT(11)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS spring_redis_test.ticket_history(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    `ticket_id` INT(11)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into ticket (member_no) values (1);
insert into ticket (member_no) values (1);
insert into ticket (member_no) values (2);
insert into ticket (member_no) values (2);
insert into ticket (member_no) values (3);
insert into ticket (member_no) values (3);
insert into ticket (member_no) values (3);
insert into ticket (member_no) values (4);
insert into ticket (member_no) values (4);
insert into ticket (member_no) values (4);
insert into ticket (member_no) values (5);
insert into ticket (member_no) values (5);
insert into ticket (member_no) values (5);
insert into ticket (member_no) values (6);
insert into ticket (member_no) values (6);
insert into ticket (member_no) values (6);
insert into ticket (member_no) values (6);
insert into ticket (member_no) values (6);
insert into ticket (member_no) values (7);
insert into ticket (member_no) values (7);


