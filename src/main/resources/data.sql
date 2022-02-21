insert into student (name, age, gpa) values ('student1', 28, 2.0);
insert into student (name, age, gpa) values ('student2', 27, 4.0);
insert into student (name, age, gpa) values ('student3', 26, 3.0);

insert into teacher (name, age, branch, type) values ('teacher1', 40, 'SPORT', 'I');
insert into teacher (name, age, branch, type) values ('teacher2', 40, 'MATH', 'I');
insert into teacher (name, age, branch, type) values ('teacher3', 40, 'MATH', 'I');
insert into teacher (name, age, branch, type) values ('teacher4', 50, 'PHYSICS', 'P');

insert into quiz (teacher_id) values (1);
insert into quiz (teacher_id) values (2);

insert into quiz_result (quiz_id, student_id, score) values (1, 1, 60);
insert into quiz_result (quiz_id, student_id, score) values (1, 2, 70);
insert into quiz_result (quiz_id, student_id, score) values (1, 3, 80);

insert into quiz_result (quiz_id, student_id, score) values (2, 1, 30);
insert into quiz_result (quiz_id, student_id, score) values (2, 2, 40);
insert into quiz_result (quiz_id, student_id, score) values (2, 3, 50);