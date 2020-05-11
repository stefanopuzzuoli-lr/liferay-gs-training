create index IX_D677E619 on AMF_AMFEvent (eventType[$COLUMN_LENGTH:75$]);
create index IX_58C7C09F on AMF_AMFEvent (userId, eventType[$COLUMN_LENGTH:75$]);
create index IX_379FBEA9 on AMF_AMFEvent (uuid_[$COLUMN_LENGTH:75$]);