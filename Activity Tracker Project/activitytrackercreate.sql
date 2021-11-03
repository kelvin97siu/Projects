    
CREATE SCHEMA IF NOT EXISTS ActivityTracker;


USE ActivityTracker;


DROP TABLE IF EXISTS Activity_Summary;
DROP TABLE IF EXISTS Activity_SegmentTypes;
DROP TABLE IF EXISTS Activity_Places;
DROP TABLE IF EXISTS Place;
DROP TABLE IF EXISTS SegmentTypes;
DROP TABLE IF EXISTS Summary;
DROP TABLE IF EXISTS Records;
DROP TABLE IF EXISTS Record;


CREATE TABLE Records(
    date DATE,
    calorieIdle INTEGER,
    lastUpdate DATE,
    CONSTRAINT pk_Records_date PRIMARY KEY (date)
    );


CREATE TABLE Summary(
    summaryID INT AUTO_INCREMENT,
    date DATE,
    CONSTRAINT pk_Summary_summaryID PRIMARY KEY (summaryID),
    CONSTRAINT fk_Summary_date FOREIGN KEY (date)
    REFERENCES Records(date)
    );
    
CREATE TABLE SegmentTypes(
    segmentID INT AUTO_INCREMENT,
    date DATE,
    SegmentType VARCHAR(255),
    startTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    endTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    lastUpdate DATE,
    CONSTRAINT pk_SegmentTypes_segmentID PRIMARY KEY (segmentID),
    CONSTRAINT fk_SegmentTypes_date FOREIGN KEY (date)
    REFERENCES Records(date)
    );
    
CREATE TABLE Place(
    placetypeID INT AUTO_INCREMENT,
    segmentID INT,
    placeID INT,
    name VARCHAR(255),
    PlaceType VARCHAR(255),
    CONSTRAINT pk_Place_placetypeID PRIMARY KEY (placetypeID),
    CONSTRAINT fk_Place_segmentID FOREIGN KEY (segmentID)
    REFERENCES SegmentTypes(segmentID)
    );
    
    CREATE TABLE Activity_Summary(
    activity_summaryId INT AUTO_INCREMENT,
    summaryId INT,
    activity VARCHAR(255),
    duration FLOAT(100,2),
    distance FLOAT(100,2),
    calories FLOAT(100,2) DEFAULT 0,
    steps INT DEFAULT 0,
    CONSTRAINT pk_Activity_Summary_activity_summaryId PRIMARY KEY(activity_summaryId),
    CONSTRAINT fk_Activity_Summary_summaryId FOREIGN KEY(summaryId) REFERENCES Summary(summaryId)
    );
    
    CREATE TABLE Activity_SegmentTypes(
    activity_segmentTypesId INT AUTO_INCREMENT,
    segmentId INT,
    startTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    endTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    activity VARCHAR(255),
    duration FLOAT(100,2),
    distance FLOAT(100,2),
    calories FLOAT(100,2) DEFAULT 0,
    steps INT DEFAULT 0,
    CONSTRAINT pk_Activity_SegmentTypes_activity_segmentTypesId PRIMARY KEY(activity_segmentTypesId),
    CONSTRAINT fk_Activity_SegmentTypes_segmentId FOREIGN KEY(segmentId) REFERENCES SegmentTypes(segmentId)
    );
    
    CREATE TABLE Activity_Places(
    activity_placesId INT AUTO_INCREMENT,
    placetypeId INT,
    startTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    endTime DATETIME DEFAULT CURRENT_TIMESTAMP,
    activity VARCHAR(255),
    duration FLOAT(100,2),
    distance FLOAT(100,2),
    calories FLOAT(100,2) DEFAULT 0,
    steps INT DEFAULT 0,
    CONSTRAINT pk_Activity_Places_activity_placesId PRIMARY KEY(activity_placesId),
    CONSTRAINT fk_Activity_Places_placeId FOREIGN KEY(placetypeId) REFERENCES Place(placetypeId)
    );
    





