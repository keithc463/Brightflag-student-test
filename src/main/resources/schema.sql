create table student (
   studentID integer auto_increment not null,
   firstName varchar(255) not null,
   lastName varchar(255) not null,
   primary key(studentID)
);


create table subject (
   subjectID integer auto_increment not null,
   subjectName varchar(255) not null,
   primary key(subjectID)
);

create table faculty (
   facultyID integer auto_increment not null,
   facultyName varchar(255) not null,
   primary key(facultyID)
);

create table studentsubject (
   studentID integer,
   subjectID integer,
   primary key(studentID, subjectID),
   foreign key(studentID) references student(studentID),
   foreign key(subjectID) references subject(subjectID)
);

create table exam(
    examID integer auto_increment not null,
    examName varchar(255) not null,
    studentID integer,
    subjectID integer,
    grade integer,
    primary key(examID, subjectID),
    foreign key(studentID) references studentsubject(studentID),
    foreign key(subjectID) references studentsubject(subjectID)
);
