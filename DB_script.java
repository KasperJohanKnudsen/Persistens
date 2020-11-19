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
		
		
		// brugt til at lave et set test data
		insert into Customer values ('lars','kurtsen', 'vejvej 20', '9000', 'Aalborg', '55555555');
		insert into Customer values ('jens','larsen', 'gågade 23, 1th', '9200', 'Aalborg', '44446666');
		insert into Customer values ('hans','hansen', 'vestergade 1', '1291', 'Rønne', '22223232');

		insert into SaleOrder values (GETDATE(), '30', 'shipped', GETDATE(), 'nyd produktet', GETDATE() , '1');
		insert into SaleOrder values (GETDATE(), '22', 'waiting', GETDATE(), 'nyd produktet', GETDATE() , '2');
		insert into SaleOrder values (GETDATE(), '213', 'shipped', GETDATE(), 'efterlad pakken ved fordøren', GETDATE() , '3');

		insert into SaleOrderLine values ('30', '1');
		insert into SaleOrderLine values ('12', '2');
		insert into SaleOrderLine values ('22', '3');

		insert into Product values ('Hat', '444333', '99', '199', 'USA', '20', 'LARGE', 'dette er en hat', '1');
		insert into Product values ('sko', '111222', '400', '999', 'USA', '5', '48', 'dette er en sko', '2');
		insert into Product values ('belte', '123456', '49', '149', 'USA', '10', '', 'dette er et belte', '3');
		
		