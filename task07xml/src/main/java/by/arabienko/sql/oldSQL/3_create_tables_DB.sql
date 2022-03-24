use `db_school_online`;

create TABLE `users` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`login` VARCHAR(255) NOT NULL UNIQUE,
	`password` CHAR(255) NOT NULL,
	/*
	 * 0 - администратор (Role.ADMINISTRATOR)
	 * 1 - преподаватель (Role.TEACHER)
	 * 2 - студент (Role.STUDENT)
	 */
	`role` TINYINT NOT NULL CHECK (`role` IN (0, 1, 2)),
    CONSTRAINT PK_users PRIMARY KEY (`id`)
) ;
create TABLE `students` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`surname` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`phoneStudent` VARCHAR(255) NOT NULL,
	`level` TINYTEXT NOT NULL CHECK (`level`IN ('start', 'medium', 'advance')),
    `status` TINYTEXT NOT NULL CHECK (`status`IN ('wait', 'confirm')),
    CONSTRAINT PK_readers PRIMARY KEY (`id`),
    CONSTRAINT FK_readers FOREIGN KEY (`id`)
    REFERENCES `users` (`id`)
     ON update CASCADE
     ON delete RESTRICT
    ) ;

create TABLE `subjects` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`nameSubject` VARCHAR(255) NOT NULL,
    CONSTRAINT PK_subjects PRIMARY KEY (`id`)
) ;
create TABLE `teachers` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`surname` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) NOT NULL,
	`idSubject` INTEGER,
	`phoneTeacher` VARCHAR(255) NOT NULL,
	`degree` VARCHAR(255) ,
	`pathImage` text,
    CONSTRAINT PK_teachers PRIMARY KEY (`id`),
    CONSTRAINT FK_teachers FOREIGN KEY (`idSubject`)
     REFERENCES `subjects` (`id`)
     ON update CASCADE
     ON delete RESTRICT
) ;

create TABLE `schedule_subjects`(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `data_time` TIMESTAMP NOT NULL,
    `idTeacher` INTEGER,
    CONSTRAINT PK_schedule PRIMARY KEY(`id`),
    CONSTRAINT FK_schedule FOREIGN KEY (`idTeacher`)
    REFERENCES `teachers` (`id`)
    ON update CASCADE
    ON delete RESTRICT
);
create TABLE `schedule`(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `data_time` TIMESTAMP NOT NULL,
    `idTeacher` INTEGER,
    `idRecord` INTEGER,
    CONSTRAINT PK_schedule PRIMARY KEY(`id`),
    CONSTRAINT FK_teacher FOREIGN KEY (`idTeacher`)
    REFERENCES `teachers` (`id`)
    ON update CASCADE
    ON delete RESTRICT,
    CONSTRAINT FK_sch_record FOREIGN KEY (`idRecord`)
    REFERENCES `record` (`id`)
    ON update CASCADE
    ON delete RESTRICT
);
create TABLE `record`(
	`id` INTEGER NOT NULL AUTO_INCREMENT,
    `idSubject` INTEGER,
    `idStudent` INTEGER,
    `status` TINYTEXT NOT NULL CHECK (`status`IN ('wait', 'confirm')),
    CONSTRAINT PK_record PRIMARY KEY(`id`),
    CONSTRAINT FK_record FOREIGN KEY (`idSubject`)
    REFERENCES `subjects` (`id`)
    ON update CASCADE
    ON delete RESTRICT,
    CONSTRAINT FK_student FOREIGN KEY (`idStudent`)
    REFERENCES `students` (`id`)
    ON update CASCADE
    ON delete RESTRICT
),
create TABLE `record_students`(
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `idSchedule` INTEGER,
    `idStudent` INTEGER,
    CONSTRAINT PK_record_students PRIMARY KEY(`id`),
    CONSTRAINT FK_record_schedule FOREIGN KEY (`idSchedule`)
    REFERENCES `schedule_subjects` (`id`)
    ON update CASCADE
    ON delete RESTRICT,
    CONSTRAINT FK_record_student FOREIGN KEY (`idStudent`)
    REFERENCES `students` (`id`)
    ON update CASCADE
    ON delete RESTRICT
);
create TABLE `record_student`(
`id` INTEGER NOT NULL AUTO_INCREMENT,
`nameSubject` VARCHAR(255) NOT NULL,

)