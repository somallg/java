insert into ch10.contact (first_name, last_name, birth_date) values ('Clarence', 'Ho', '1980-07-30');
insert into ch10.contact (first_name, last_name, birth_date) values ('Scott', 'Tiger', '1990-11-02');
insert into ch10.contact (first_name, last_name, birth_date) values ('John', 'Smith', '1964-02-28');

insert into ch10.contact_audit (first_name, last_name, birth_date) values ('Clarence', 'Ho', '1980-07-30');
insert into ch10.contact_audit (first_name, last_name, birth_date) values ('Scott', 'Tiger', '1990-11-02');
insert into ch10.contact_audit (first_name, last_name, birth_date) values ('John', 'Smith', '1964-02-28');

insert into ch10.contact_tel_detail (contact_id, tel_type, tel_number) values (1, 'Mobile', '1234567890');
insert into ch10.contact_tel_detail (contact_id, tel_type, tel_number) values (1, 'Home', '1234567890');
insert into ch10.contact_tel_detail (contact_id, tel_type, tel_number) values (2, 'Home', '1234567890');

insert into ch10.contact_interest (contact_id, interest_type, interest_number) values (1, 'Type1', '1234567890');
insert into ch10.contact_interest (contact_id, interest_type, interest_number) values (1, 'Type2', '1234567890');
insert into ch10.contact_interest (contact_id, interest_type, interest_number) values (2, 'Type1', '1234567890');


insert into ch10.hobby (hobby_id) values ('Swimming');
insert into ch10.hobby (hobby_id) values ('Jogging');
insert into ch10.hobby (hobby_id) values ('Programming');
insert into ch10.hobby (hobby_id) values ('Movies');
insert into ch10.hobby (hobby_id) values ('Reading');

insert into ch10.contact_hobby_detail(contact_id, hobby_id) values (1, 'Swimming');
insert into ch10.contact_hobby_detail(contact_id, hobby_id) values (1, 'Movies');
insert into ch10.contact_hobby_detail(contact_id, hobby_id) values (2, 'Swimming');