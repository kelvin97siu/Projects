CREATE SCHEMA IF NOT EXISTS ActivityTracker;

USE ActivityTracker;
DROP TABLE IF EXISTS Activity;
DROP TABLE IF EXISTS Place;
DROP TABLE IF EXISTS SegmentTypes;
DROP TABLE IF EXISTS Summary;
DROP TABLE IF EXISTS SegmentJoin;
DROP TABLE IF EXISTS Records;

CREATE TABLE Records(
    date DATE,
    calorieIdle INTEGER,
    lastUpdate TIMESTAMP,
    CONSTRAINT pk_Records_date PRIMARY KEY (date)
    );
    
CREATE TABLE Summary(
    summaryID INT AUTO_INCREMENT,
    date DATE,
    CONSTRAINT pk_Summary_summaryID PRIMARY KEY (summaryID),
    CONSTRAINT fk_Summary_date FOREIGN KEY (date)
    REFERENCES Records(date)
    );
    
    CREATE TABLE SegmentJoin(
    segmentID INT AUTO_INCREMENT,
    date DATE,
    CONSTRAINT pk_SegmentJoin_segmentID PRIMARY KEY (segmentID),
    CONSTRAINT fk_SegmentJoin_date FOREIGN KEY (date)
    REFERENCES Records(date)
    );
    
CREATE TABLE SegmentTypes(
    sid INT AUTO_INCREMENT,
    segmentID INT NOT NULL,
    SegmentType ENUM ('move', 'place', 'off'),
    startTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    endTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    lastUpdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_SegmentTypes_sid PRIMARY KEY (sid),
    CONSTRAINT fk_SegmentTypes_date FOREIGN KEY (segmentID)
    REFERENCES SegmentJoin(segmentID)
    );
    
CREATE TABLE Place(
    placetypeID INT AUTO_INCREMENT,
    sid INT,
    placeID INT,
    name VARCHAR(255),
    PlaceType VARCHAR(255) DEFAULT NULL,
    CONSTRAINT pk_Place_placetypeID PRIMARY KEY (placetypeID),
    CONSTRAINT fk_Place_sid FOREIGN KEY (sid)
    REFERENCES SegmentTypes(sid)
    );
    
CREATE TABLE Activity(
    activityID INT AUTO_INCREMENT,
    sid INT DEFAULT NULL,
    summaryID INT DEFAULT NULL,
    placetypeID INT DEFAULT NULL,
    startTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    endTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activity varchar(255) DEFAULT NULL,
    duration FLOAT(100,2) DEFAULT 0,
    distance FLOAT(100,2) DEFAULT 0,
    calories FLOAT(100,2) DEFAULT 0,
    steps INT DEFAULT 0,
    CONSTRAINT pk_Activity_activityID PRIMARY KEY(activityID),
    CONSTRAINT fk_Activity_sid FOREIGN KEY(sid)
    REFERENCES SegmentTypes(sid),
    CONSTRAINT fk_Activity_summaryID FOREIGN KEY(summaryID)
    REFERENCES Summary(summaryID),
    CONSTRAINT fk_Activity_placetypeID FOREIGN KEY (placetypeID)
    REFERENCES Place(placetypeID)
    );