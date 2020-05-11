create table AMFUR_AMFUser (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	userId LONG not null primary key,
	male BOOLEAN,
	dob DATE null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zip VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);