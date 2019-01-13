create table Department (
    departmentID number generated always as identity,
    name varchar2(255) not null,
    location varchar2(255),
    constraint pk_department primary key (departmentID)
);

create table Employee (
    employeeID number generated always as identity,
    firstname varchar2(255) not null,
    lastname varchar2(255) not null,
    ssn varchar2(255) not null,
    birthdate varchar2(255) not null,
    address varchar2(255) not null,
    city varchar2(255) not null,
    country varchar2(255) not null,
    email varchar2(255) not null,
    sex char(1) not null,
    jobtitle varchar2(255) not null,
    department number not null,
    constraint fk_employee_department foreign key (department) references department(departmentID),
    constraint pk_employee primary key (employeeID)
);
 


create table Project (
    projectID number generated always as identity,
    name varchar2(255) not null,
    location varchar2(255),
    constraint pk_project primary key (projectID)
);

create table WorksOn (
    jobID number generated always as identity,
    projectID number references Project (projectID),
    employeeID number references Employee (employeeID),
    constraint pk_workson primary key (jobID)
)