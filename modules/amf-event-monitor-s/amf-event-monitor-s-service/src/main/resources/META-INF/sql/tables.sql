create table AMF_AMFEvent (
	uuid_ VARCHAR(75) null,
	auditEventId LONG not null primary key,
	userId LONG,
	username VARCHAR(75) null,
	createDate DATE null,
	eventType VARCHAR(75) null,
	clientIp VARCHAR(75) null
);