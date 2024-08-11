


CREATE TABLE STATUS_INTERVIEW
(	SI_ID NUMBER NOT NULL ENABLE,
     SI_NAME VARCHAR2(50 BYTE) NOT NULL ENABLE,
     SI_DATE DATE,
     CONSTRAINT STATUS_PK PRIMARY KEY (SI_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

COMMENT ON COLUMN STATUS_INTERVIEW.SI_ID IS 'Identifier';
COMMENT ON COLUMN STATUS_INTERVIEW.SI_NAME IS 'Status Name or Description';
COMMENT ON COLUMN STATUS_INTERVIEW.SI_DATE IS 'Store the last date of the change status';
COMMENT ON TABLE STATUS_INTERVIEW  IS 'Master of Interviews Status';


CREATE SEQUENCE SQ_STATUS_INTERVIEW INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;

CREATE TABLE CANDIDATE (
                           CA_ID NUMBER NOT NULL ENABLE,
                           CA_FIRST_NAME VARCHAR2(250 BYTE),
                           CA_LAST_NAME VARCHAR2(250 BYTE),
                           CA_DOB   DATE,
                           CA_NATIONALITY VARCHAR2(250 BYTE),
                           CA_ADDRESS VARCHAR2(250 BYTE),
                           CA_EMAIL VARCHAR2(250 BYTE),
                           CA_CONTACT_PHONE VARCHAR2(250 BYTE),
                           CA_WORK_PERMIT CHAR(2 BYTE),
    CA_WORKPERMIT_DESC VARCHAR2(250 BYTE),
    CA_CURRENT_SALARY DECIMAL(16,4),
    CA_EXPECT_SALARY_INIT DECIMAL(16,4),
    CA_EXPECT_SALARY_END DECIMAL(16,4),
    CA_RESUME CLOB,
    CA_CURRENT_PACKAGE VARCHAR2(450 BYTE),
    CA_OFFER_PACKAGE VARCHAR2(450 BYTE),
    CONSTRAINT CANDIDATE_PK PRIMARY KEY (CA_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

COMMENT ON COLUMN CANDIDATE.CA_ID IS 'Identifier';
COMMENT ON COLUMN CANDIDATE.CA_FIRST_NAME IS 'Name ';
COMMENT ON COLUMN CANDIDATE.CA_LAST_NAME IS 'Last name';
COMMENT ON COLUMN CANDIDATE.CA_DOB IS 'Date of birth';
COMMENT ON COLUMN CANDIDATE.CA_NATIONALITY IS 'Nationality';
COMMENT ON COLUMN CANDIDATE.CA_ADDRESS IS 'Curren Address';
COMMENT ON COLUMN CANDIDATE.CA_EMAIL IS 'Email';
COMMENT ON COLUMN CANDIDATE.CA_CONTACT_PHONE IS 'Contact phone';
COMMENT ON COLUMN CANDIDATE.CA_WORK_PERMIT IS 'Work permit';
COMMENT ON COLUMN CANDIDATE.CA_WORKPERMIT_DESC IS 'description of the work permit';
COMMENT ON COLUMN CANDIDATE.CA_CURRENT_SALARY IS 'current salary of the candidate';
COMMENT ON COLUMN CANDIDATE.CA_EXPECT_SALARY_INIT IS 'expected salary to';
COMMENT ON COLUMN CANDIDATE.CA_EXPECT_SALARY_END IS 'expected salary to';
COMMENT ON COLUMN CANDIDATE.CA_RESUME IS 'resume';
COMMENT ON COLUMN CANDIDATE.CA_CURRENT_PACKAGE IS 'current package';
COMMENT ON COLUMN CANDIDATE.CA_OFFER_PACKAGE IS 'Whats is offered to the candidate';
COMMENT ON TABLE  CANDIDATE  IS 'Table for store all the Candidates';

CREATE SEQUENCE SQ_CANDIDATE INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;

CREATE TABLE COMPANY (
                         C_ID NUMBER NOT NULL ENABLE,
                         C_NAME VARCHAR2(250 BYTE),
                         C_URL   VARCHAR2(250 BYTE),
                         C_PHONE VARCHAR2(250 BYTE),
                         CONSTRAINT COMPANYS_PK PRIMARY KEY (C_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

COMMENT ON COLUMN COMPANY.C_ID IS 'Identifier';
COMMENT ON COLUMN COMPANY.C_NAME IS 'Name of the company';
COMMENT ON COLUMN COMPANY.C_URL IS 'Website of the company';
COMMENT ON COLUMN COMPANY.C_PHONE IS 'Phone of the company';
COMMENT ON TABLE  COMPANY  IS 'Table for store all the Companies';

CREATE SEQUENCE SQ_COMPANY INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;

CREATE TABLE COMPANY_CONTACT (
                                 CC_ID NUMBER NOT NULL ENABLE,
                                 C_ID NUMBER ,
                                 CC_COMPANY_CONTACT   VARCHAR2(250 BYTE),
                                 CC_CONTACT_EMAIL VARCHAR2(250 BYTE),
                                 CC_CONTACT_PHONE VARCHAR2(250 BYTE),
                                 CONSTRAINT COMPANY_CONTACT_PK PRIMARY KEY (CC_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

ALTER TABLE COMPANY_CONTACT
    ADD CONSTRAINT COMPANY_CONTACT_FK1 FOREIGN KEY (C_ID)
        REFERENCES COMPANY (C_ID) ON DELETE CASCADE ENABLE;

COMMENT ON COLUMN COMPANY_CONTACT.CC_ID IS 'Identifier';
COMMENT ON COLUMN COMPANY_CONTACT.C_ID IS 'Identifier of the company';
COMMENT ON COLUMN COMPANY_CONTACT.CC_COMPANY_CONTACT IS 'Company contact foreingkey';
COMMENT ON COLUMN COMPANY_CONTACT.CC_CONTACT_EMAIL IS 'Means if we need to do something to advance in the process';
COMMENT ON COLUMN COMPANY_CONTACT.CC_CONTACT_PHONE IS 'Status Process foreignkey';
COMMENT ON TABLE COMPANY_CONTACT  IS 'Table for store all process of selections';

CREATE SEQUENCE SQ_COMPANY_CONTACT INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;


CREATE TABLE PROCESS_INTERVIEW
(	PI_ID NUMBER NOT NULL ENABLE,
     PI_POSITION VARCHAR2(250 BYTE),
     CC_ID   NUMBER NOT NULL ENABLE,
     PI_WHOCONTACT CHAR(2 BYTE),
    PI_TODO CHAR(2 BYTE),
    SI_ID NUMBER NOT NULL ENABLE,
    CA_ID NUMBER NOT NULL ENABLE,
    CONSTRAINT PROCESS_INTER_PK PRIMARY KEY (PI_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

COMMENT ON COLUMN PROCESS_INTERVIEW.PI_ID IS 'Identifier';
COMMENT ON COLUMN PROCESS_INTERVIEW.PI_POSITION IS 'Name of the position';
COMMENT ON COLUMN PROCESS_INTERVIEW.CC_ID IS 'Company contact foreingkey';
COMMENT ON COLUMN PROCESS_INTERVIEW.PI_WHOCONTACT IS 'Identify who reach out to the us';
COMMENT ON COLUMN PROCESS_INTERVIEW.PI_TODO IS 'Means if we need to do something to advance in the process';
COMMENT ON COLUMN PROCESS_INTERVIEW.SI_ID IS 'Status Process foreignkey';
COMMENT ON TABLE PROCESS_INTERVIEW  IS 'Table for store all process of selections';

ALTER TABLE PROCESS_INTERVIEW ADD(
     CONSTRAINT PROCESS_INTERVIEW_FK1 FOREIGN KEY (CC_ID)
    REFERENCES COMPANY_CONTACT (CC_ID) ON
DELETE
CASCADE ENABLE,
 CONSTRAINT PROCESS_INTERVIEW_FK2 FOREIGN KEY (SI_ID)
    REFERENCES STATUS_INTERVIEW (SI_ID) ON
DELETE
CASCADE ENABLE,
 CONSTRAINT PROCESS_INTERVIEW_FK3 FOREIGN KEY (CA_ID)
    REFERENCES CANDIDATE (CA_ID) ON
DELETE
CASCADE ENABLE
);

CREATE SEQUENCE SQ_PROCESS_INTERVIEW INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;


CREATE TABLE COMMENTS_INTERVIEW
(	CI_ID NUMBER NOT NULL ENABLE,
     CI_COMMENTS VARCHAR2(250 BYTE) NOT NULL ENABLE,
     PI_ID NUMBER NOT NULL ENABLE,
     CONSTRAINT COMMENTS_PK PRIMARY KEY (CI_ID)

) SEGMENT CREATION DEFERRED
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 ;

ALTER TABLE COMMENTS_INTERVIEW ADD(
     CONSTRAINT PCOMMENTS_INTERVIEW_FK1 FOREIGN KEY (PI_ID)
    REFERENCES PROCESS_INTERVIEW (PI_ID) ON
DELETE
CASCADE ENABLE
);

COMMENT ON COLUMN COMMENTS_INTERVIEW.CI_ID IS 'Identifier';
COMMENT ON COLUMN COMMENTS_INTERVIEW.CI_COMMENTS IS 'Comments';
COMMENT ON COLUMN COMMENTS_INTERVIEW.PI_ID IS 'Id of process interviews';
COMMENT ON TABLE COMMENTS_INTERVIEW  IS 'Table for store all comments of the process';


CREATE SEQUENCE SQ_COMMENTS_INTERVIEW INCREMENT BY 20 START WITH 1 NOCYCLE CACHE 20 ORDER;