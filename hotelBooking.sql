create DATABASE hotelBooking;
create TABLE Clients(
  ClientID            INT NOT NULL AUTO_INCREMENT, 
  Clientfname         varchar(30) ,
  Clientlname         varchar(30),
  Clientmail          varchar(30),
  Clientpwd           varchar(20),
  primary key (ClientID)
);