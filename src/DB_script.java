CREATE TABLE Customer   
(id		int		IDENDITY(1,1)		not null,
		fname       varchar(25) not null,
		lname       varchar(25) not null,
		adress         varchar(35) not null,
		zip       varchar(10) not null,
		address     varchar(30),
		phoneno    varchar(16),
		PRIMARY KEY (id)
		on update cascade);



CREATE TABLE SaleOrder   
(id		int		IDENDITY(1,1)		not null,
		date       DATETIME not null,
		quantity       int not null,
		deliveryStatus         varchar(15) not null,
		deliveryDate       DATETIME,
		deliveryNote     varchar(300),
		orderDate    DATETIME not null,
		customer_id     int,
		PRIMARY KEY (id),
		foreign key (Custumor_id) references Customer(id)
		on update cascade);



CREATE TABLE SaleOrderLine   
(id		int		IDENDITY(1,1)		not null,
		quantity       int not null,
		saleorder_id         int not null,
		PRIMARY KEY (id),
		foreign key (saleorder_id) references SaleOrder(id));