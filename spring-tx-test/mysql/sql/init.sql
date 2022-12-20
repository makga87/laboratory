CREATE TABLE IF NOT EXISTS spring_tx_test.ticket(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    `use_yn` CHAR(1)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS spring_tx_test.ticket_history(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    `ticket_id` INT(11)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into ticket values (1, 'N');
insert into ticket values (2, 'N');
insert into ticket values (3, 'N');
insert into ticket values (4, 'N');
insert into ticket values (5, 'N');
insert into ticket values (6, 'N');
insert into ticket values (7, 'N');
insert into ticket values (8, 'N');
insert into ticket values (9, 'N');
insert into ticket values (10, 'N');