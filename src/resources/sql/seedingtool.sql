insert into DATABASETYPE (dialect,TRIGGERTEMPLATE,CONSTRAINTTEMPLATE) VALUES ('oracle',
'create or replace trigger $name
 before delete or insert or update
 on $tablename
 for each row
declare
 l_oper varchar2 ( 3 );
 l_error_stack varchar2 ( 4000 );
begin
 if inserting
 then
 l_oper := ''INS'';
 elsif updating
 then
 l_oper := ''UPD'';
 elsif deleting
 then
 l_oper := ''DEL'';
 end if;','alter table $tablename drop constraint $name ; alter table $tablename add constraint $name check ($statement)');


INSERT INTO database(databasetype,name,username,password,host,schema,port) VALUES(1,'EDUC14','target','targetdb','ondora04.hu.nl','target','8521');


INSERT INTO targettable(database,name) VALUES(1,'department');
INSERT INTO targettable(database,name) VALUES(1,'employee');
INSERT INTO targettable(database,name) VALUES(1,'project');


INSERT INTO targetcolumn(targettable,name,datatype) VALUES(1,'departmentid','number');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(1,'name','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(1,'location','varchar2');

INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'employeeid','number');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'firstname','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'lastname','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'ssn','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'birthdate','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'address','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'city','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'country','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'email','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'sex','char');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'jobtitle','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(2,'department','number');

INSERT INTO targetcolumn(targettable,name,datatype) VALUES(3,'projectid','number');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(3,'name','varchar2');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(3,'location','varchar2');

INSERT INTO targetcolumn(targettable,name,datatype) VALUES(4,'jobid','number');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(4,'projectid','number');
INSERT INTO targetcolumn(targettable,name,datatype) VALUES(4,'employeeid','number');
