DROP TABLE `classes`;
DROP TABLE `staff`;
DROP TABLE `students`;
DROP TABLE `sub_depts`;
DROP TABLE `subjects`;

CREATE TABLE `classes` ( `class_id` int(10) NOT NULL, `class_type` varchar(40) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `staff` (`staff_id` int(10) NOT NULL, `staff_firstname` varchar(40) NOT NULL, `staff_secondname` varchar(40) NOT NULL, `ganeder` varchar(40) NOT NULL, `degree` varchar(40) NOT NULL, `address` varchar(40) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `students` ( `student_id` int(11) NOT NULL, `student_firstname` varchar(40) NOT NULL, `student_lastname` varchar(40) NOT NULL, `student_gander` varchar(40) NOT NULL, `section` varchar(40) NOT NULL, `division` varchar(40) NOT NULL, `stage` varchar(15) NOT NULL, `address` varchar(40) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `sub_depts` ( `sub_depts_ID` int(10) NOT NULL, `sub_depts_Name` varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `subjects` ( `subject_id` int(11) NOT NULL, `sub_depts_name` varchar(50) NOT NULL, `subject_name` varchar(50) NOT NULL, `chr_no` varchar(20) NOT NULL, `subject_degree` int(20) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO `classes` (`class_id`, `class_type`) VALUES (1, 'office'), (2, 'laboratory'), (3, 'lecture hall'); 
INSERT INTO `staff` (`staff_id`, `staff_firstname`, `staff_secondname`, `ganeder`, `degree`, `address`) VALUES (1, 'ahmed', 'salma', 'male', 'doctor', 'mansora'),(2, 'ibrahim', 'hanafy', 'male', 'prof', 'portsaid'), (3, 'anas', 'arafa', 'male', 'doctor', 'portsaid'), (4, 'mostfa', 'haragy', 'male', 'doctor', 'portsaid');
INSERT INTO `students` (`student_id`, `student_firstname`, `student_lastname`, `student_gander`, `section`, `division`, `stage`, `address`) VALUES (1, 'ahmed', 'abd elaziz', 'male', 'mathematics and com_science', 'it and com_science', 'fourth', 'portsaid'), (2, 'mohamed', 'elsherey', 'male', 'mathematics and com_science', 'it and com_science', 'fourth', 'portsaid'), (3, 'noor eldien', 'mostafa', 'male', 'mathematics and com_science', 'it and com_science', 'fourth', 'portsaid'), (4, 'walid', 'abd elnasser', 'male', 'Mathematics and com_science', 'IT and com_science', 'fourth', 'portsaid'), (5, 'nabil', 'hemdan', 'male', 'mathematics and com_science', 'it and com_science', 'fourth', 'portsaid'), (6, 'mahmoud', 'radwan', 'male', 'mathematics and com_science', 'it and com_science', 'fourth', 'portsaid');
INSERT INTO `sub_depts` (`sub_depts_ID`, `sub_depts_Name`) VALUES(1, 'information technology and computer science'),(2, 'Mathematics and Applied Statistics');
INSERT INTO `subjects` (`subject_id`, `sub_depts_name`, `subject_name`, `chr_no`, `subject_degree`) VALUES(1, 'information technologyand computer science', 'system analysis', 'three hour', 300),(2, 'information technologyand computer science', 'theory of computation', 'three hour', 300),(3, 'Mathematics and Applied Statistics', 'topology', 'three hour', 300);

ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_id`);
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`);
ALTER TABLE `sub_depts`
  ADD PRIMARY KEY (`sub_depts_ID`);
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);
