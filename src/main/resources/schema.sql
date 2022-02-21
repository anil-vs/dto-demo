create table student (
    id integer auto_increment,
    name varchar2(50),
    age number(2),
    gpa number(3, 2),
    primary key (id)
);

create table teacher (
    id integer auto_increment,
    name varchar2(50),
    age number(2),
    branch varchar2(10),
    type varchar2(1),
    primary key (id)
);

create table quiz (
    id integer auto_increment,
    teacher_id integer,
    primary key (id),
    foreign key (teacher_id) references teacher(id)
);

create table quiz_result (
    id integer auto_increment,
    quiz_id integer,
    student_id integer,
    score integer,
    primary key (id),
    foreign key (quiz_id) references quiz(id),
    foreign key (student_id) references student(id)
);