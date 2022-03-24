CREATE DATABASE IF NOT EXISTS `db_school_online` DEFAULT CHARACTER SET utf8;

CREATE USER school_application@localhost IDENTIFIED BY 'root';
CREATE USER school_application@'%' IDENTIFIED BY 'root';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `db_school_online`.*
TO school_application@localhost
;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `db_school_online`.*
TO school_application@'%'
;
