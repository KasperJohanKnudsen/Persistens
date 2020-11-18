CREATE TABLE Customer   
(id		int		IDENDITY(1,1)		not null,
		fname       varchar(25) not null,
		lname       varchar(25) not null,
		adress         varchar(35) not null,
		zip       varchar(10) not null,
		address     varchar(30),
		phoneno    varchar(16),
		PRIMARY KEY (id),
		FOREIGN KEY(zip) REFERENCES Employee(zip)
		on update cascade);