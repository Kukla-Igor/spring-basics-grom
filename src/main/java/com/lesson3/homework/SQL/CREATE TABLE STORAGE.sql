CREATE TABLE STORAGE (
    ID NUMBER,
    CONSTRAINT STORAGE_ID PRIMARY KEY (ID),
    FORMATSSUPPORTED NVARCHAR2 (30),
    STORAGECOUNTRY NVARCHAR2 (30),
    STORAGEMAXSIZE NUMBER
);