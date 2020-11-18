CREATE TABLE Customer   
(		id		int		IDENTITY(1,1)		not null,
		fname       varchar(25) not null,
		lname       varchar(25) not null,
		adress         varchar(35) not null,
		zip       varchar(10) not null,
		address     varchar(30),
		phoneno    varchar(16),
		PRIMARY KEY (id));



CREATE TABLE SaleOrder   
(		id		int		IDENTITY(1,1)		not null,
		date       DATETIME not null,
		quantity       int not null,
		deliveryStatus         varchar(15) not null,
		deliveryDate       DATETIME,
		deliveryNote     varchar(300),
		orderDate    DATETIME not null,
		customer_id     int,
		PRIMARY KEY (id),
		foreign key (customer_id) references Customer(id));



CREATE TABLE SaleOrderLine   
(		id		int		IDENTITY(1,1)		not null,
		quantity       int not null,
		saleorder_id         int not null,
		PRIMARY KEY (id),
		foreign key (saleorder_id) references SaleOrder(id));



CREATE TABLE Product   
(		id		int		IDENTITY(1,1)		not null,
		name       varchar(100) not null,
		barcode       int not null,
		purchasePrice       decimal not null,
		salesPrice       decimal not null,
		origin       varchar(25),
		stock       int not null,
		size       varchar(20),
		description       varchar(300),
		saleorderline_id         int not null,
		PRIMARY KEY (id),
		foreign key (saleorderline_id) references SaleOrderLine(id));

		ALTER TABLE Customer
		ADD FOREIGN KEY (id) REFERENCES SaleOrder(customer_id)
		ON UPDATE CASCADE;