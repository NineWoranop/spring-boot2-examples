CREATE TABLE tbl_schools (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP NOT NULL
);

CREATE TABLE tbl_students (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  school_id INT,
  name VARCHAR(250) NOT NULL,
  created_date TIMESTAMP NOT NULL,
  last_modified_date TIMESTAMP NOT NULL
);
