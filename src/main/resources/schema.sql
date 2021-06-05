DROP TABLE IF EXISTS anime;
  
CREATE TABLE anime (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL
);

INSERT INTO anime (id, title) VALUES
  (101, 'Basilisk'),
  (102, 'Devil is Parttimer'),
  (103, 'Fate');