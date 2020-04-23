CREATE DATABASE CrimeInvestigations;

-- Create the table in the specified schema
CREATE TABLE CrimeInvestigations.police_station
(
    police_stationId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- primary key AUTO_INCREMENT column
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) Not NULL
    -- specify more columns here
);

INSERT INTO CrimeInvestigations.police_station VALUES('1','SYSTEM','RQ12T3');

CREATE TABLE CrimeInvestigations.police_officer
(
    police_officerId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- primary key AUTO_INCREMENT column
    police_stationId INT NOT NULL ,
    name VARCHAR(50) NOT NULL,
    post VARCHAR(50) NOT NULL,
    mobile VARCHAR(12) NOT NULL,
    address VARCHAR(50) NOT NULL,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) Not NULL,
    
    FOREIGN KEY (police_stationId) REFERENCES police_station(police_stationId)
    -- specify more columns here
);

CREATE TABLE CrimeInvestigations.fir
(
    firId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- primary key AUTO_INCREMENT column
    policeStationName VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    act VARCHAR(10) NOT NULL,
    name VARCHAR(50) NOT NULL,
    address VARCHAR(1000) NOT NULL,
    city VARCHAR(50) NOT NULL,
    dateAdded VARCHAR(50) NOT NULL,
    mobile VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    details VARCHAR(1000) NOT NULL
    
    -- specify more columns here
);


CREATE TABLE CrimeInvestigations.cases
(
    caseId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- primary key AUTO_INCREMENT column
    firId INT NOT NULL,
    dateEnter VARCHAR(11),
    place VARCHAR(255),
    objects VARCHAR(255),
    typeOfCrime VARCHAR(255),
    details VARCHAR(1000) NOT NULL,

    FOREIGN KEY (firId) REFERENCES fir(firId)
    -- specify more columns here
);

CREATE TABLE CrimeInvestigations.criminal
(
	criminalId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, -- primary key AUTO_INCREMENT column
	name VARCHAR(255),
	address VARCHAR(255),
	city VARCHAR(255),
	mstatus VARCHAR(255),
	gender VARCHAR(255),
	weight VARCHAR(255),
	height VARCHAR(255),
	dateArrest VARCHAR(255),
	dateRelease VARCHAR(255) DEFAULT 'NILL',
	dateBirth VARCHAR(255),
	bplace VARCHAR(255),
	occupation VARCHAR(255),
	act VARCHAR(255)
);
	