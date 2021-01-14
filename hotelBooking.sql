create DATABASE hotelBooking;
create TABLE Clients(
  ClientID            INT NOT NULL AUTO_INCREMENT, 
  Clientfname         varchar(30) ,
  Clientlname         varchar(30),
  Clientmail          varchar(30),
  ClientCreationDate  date,
  Clientpwd           varchar(20),
  primary key (ClientID)
);
Create TABLE Admins(
  AdminID            INT NOT NULL AUTO_INCREMENT, 
  Adminfname         varchar(30) ,
  Adminlname         varchar(30),
  Adminmail          varchar(30),
  AdminCreationDate  date,
  Adminpwd           varchar(20),
  primary key (AdminID)
);
Create TABLE Hotels(
	 HotelName       text,
	 HotelRating     float,
     Availability  	 text,
	 ExpectedPrice   double,
     roomsAvailable  int,
     roomType        text,
     roomFacilities  text
);

