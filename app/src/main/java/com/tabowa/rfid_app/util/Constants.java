package com.tabowa.rfid_app.util;

public class Constants {

    //column names of student table
    public static final String TABLE_STUDENT = "student";
    public static final String STUDENT_ID = "_id";
    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_REGISTRATION_NUM = "registration_no";
    public static final String STUDENT_PHONE = "phone";
    public static final String STUDENT_EMAIL = "email";

    public static final String STUDENT_DEPARTMENT = "department";
    public static final String STUDENT_SCHOOL = "school";
    public static final String STUDENT_PROGRAME = "program";
    public static final String STUDENT_CATEGORY = "category";
    public static final String STUDENT_SESSION = "session";
    public static final String STUDENT_BLOODGROUP = "blood_group";
    public static final String STUDENT_NOK = "nok";
    public static final String STUDENT_NOKADDR = "nok_addr";
    public static final String STUDENT_NOKPHONE = "nok_phone";
    public static final String STUDENT_STATE = "state";
    public static final String STUDENT_LGA = "lga";
    public static final String STUDENT_HOMETOWN = "home_town";
    public static final String STUDENT_HEALTHNO = "health_no";
    public static final String STUDENT_PHOTO = "photo";
    public static final String STUDENT_THUMBPRINT = "thumbprint";
    public static final String STUDENT_DOB = "dob";
    public static final String STUDENT_EXPDATE = "expiry_date";
    public static final String STUDENT_GENDER = "gender";
    public static final String STUDENT_NIN = "nin";
    public static final String STUDENT_MEDICALNO = "medical_no";




    //column names of subject table
    public static final String TABLE_SUBJECT = "subject";
    public static final String SUBJECT_ID = "_id";
    public static final String SUBJECT_NAME = "name";
    public static final String SUBJECT_CODE = "code";
    public static final String SUBJECT_CREDIT = "credit";
    public static final String SUBJECT_GRADE = "grade";

    //column names of course registration table
    public static final String TABLE_COURSE = "course";
    public static final String COURSE_ID = "_id";
    public static final String REGISTRATION_NUMBER = "reg_no";
    public static final String PROGRAM = "program";
    public static final String CATEGORY = "category";
    public static final String SESSION = "session";
    public static final String SEMESTER = "semester";
    public static final String COURSE_TITLE = "course_title";
    public static final String COURSE_CODE = "course_code";
    public static final String UNITS = "units";


//    public static final String COURSE_NAME = "name";
//    public static final String COURSE_CODE = "code";


    //column names of Administrative information table
    public static final String TABLE_ADMIN = "admin";
    public static final String ADMIN_ID = "_id";
    public static final String ADMIN_REGISTRATION_NUMBER = "admin_regno";
    public static final String ADMIN_SESSION = "session";
    public static final String ADMIN_PROGRAM = "program";
    public static final String ADMIN_CATEGORY = "category";
    public static final String ADMIN_DATE_OF_PAYMENT = "date_payment";
    public static final String ADMIN_MODE_OF_PAYMENT = "mode_of_payment";
    public static final String ADMIN_AMOUNT_PAID = "amount_paid";
    public static final String ADMIN_PURPOSE_OF_PAYMENT = "purpose_payment";

//    public static final String ADMIN_PAYMENT_ID_NUMBER = "Payment_id";
//    public static final String ADMIN_STUDY_LEVEL = "level";


    //column names of student grade data table
    public static final String TABLE_GRADE = "grade";
    public static final String  GRADE_REGISTRATION_NUMBER = "grade_regno";
    public static final String  GRADE_PROGRAM = "program";
    public static final String  GRADE_CATEGORY = "category";
    public static final String  GRADE_SESSION = "session";
    public static final String  GRADE_SEMESTER = "semester";
    public static final String  GRADE_COURSE_TITLE = "cousrse_title";
    public static final String  GRADE_COURSE_CODE = "course_code";
    public static final String  GRADE_UNITS = "units";
    public static final String  GRADE_CLASS_ATTENDANCE = "class_attendance";
    public static final String  GRADE_CA_SCORE = "score";
    public static final String  GRADE_EXAMINATION= "examination";
    public static final String  GRADE_TOTAL = "total";
    public static final String  GRADE_GRADE = "grade";



    //column names of medical information table
    public static final String TABLE_MEDICAL = "medical";
    public static final String MEDICAL_REGISTRATION_NUMBER = "registration_number";
    public static final String MEDICAL_NAME = "name";
    public static final String MEDICAL_MEDICAL_CARD_NUMBER = "medical_card_number";
    public static final String MEDICAL_BLOOD_GROUP = "blood_group";
    public static final String MEDICAL_CONDITIONS = "blood_group";
//    public static final String MEDICAL_TUBERCULOSIS = "tuberculosis";
//    public static final String MEDICAL_EPILEPSY = "epilepsy";
//    public static final String MEDICAL_DIABETES = "diabetes";
//    public static final String MEDICAL_SICKLE_CELL = "sickle_cell";
//    public static final String MEDICAL_BLOOD_DISEASE = "blood_disease";
//    public static final String MEDICAL_HBP = "hbp";
//    public static final String MEDICAL_MENTAL_DISEASE = "mental_disease";
    public static final String MEDICAL_ALLERGY = "allergy";
//    public static final String MEDICAL_ALLERGY_LIST = "allergy_list";
//    public static final String MEDICAL_MEDICATION = "medication";
    public static final String MEDICAL_HISTORY = "medical_history";
    public static final String MEDICAL_ATTENDANT_DOCTOR= "attendant_doctor";
    public static final String MEDICAL_TTENDANT_DOCTOR_PHONE= "attendant_doctor_phone";



//    //column names of medical history table
//    public static final String TABLE_MEDICAL_HISTORY = "medical_history";
//    //public static final String MEDICAL_HISTORY_REGISTRATION_NUMBER = "registration_number";
//    public static final String MEDICAL_HISTORY_LAST_DATE_OF_VISIT = "last_date_of_visit";
//    public static final String MEDICAL_HISTORY_TEST = "test";
//    public static final String MEDICAL_HISTORY_TEST_RESULTNOS = "test_result_nos";
//    public static final String MEDICAL_HISTORY_AILMENT = "ailment";
//    public static final String MEDICAL_HISTORY_DRUG_ADMINISTERED = "drug_administered";
//    public static final String MEDICAL_HISTORY_DRUG_LIST = "drug_list";
//    public static final String MEDICAL_HISTORY_DOCTOR_NAME = "doctor_name";



    //column names of security table
    public static final String TABLE_SECURUTY = "security";
    public static final String WANTED_STATUS = "wanted";
    public static final String DATE_OF_BEING_WANTED = "wanted_date";
    public static final String DATE_OF_BEING_ACQUITTED = "acquitted";
    public static final String DATE_OF_CLOSE_OF_INVESTIGATION = "close_investigation_date";
    public static final String NAME_OF_CRIME_CONVICTED_ON = "crime_name";
    public static final String NUMBER_OF_REGISTERED_OFFENCES = "num_registerd_offences";
    public static final String LIST_OF_CRIMES = "list_of_crimes";
    public static final String DATE_OF_LAST_ARREST = "date_of_arrest";
//    public static final String SECURITY_WANTED = "wanted";
//    public static final String SECURITY_CRIME = "crime";
//    public static final String SECURITY_SP = "sp";
//    public static final String SECURITY_OF = "of";
//    public static final String SECURITY_NC = "nc";
//    public static final String SECURITY_DLA = "dla";
//    public static final String SECURITY_ACQ = "acq";







    //column names of voting table
    public static final String TABLE_ELECTION = "election";
    public static final String ELECTION_CLEARANCE_STATUS = "clearance_status";
    public static final String ELECTION_VOTING_STATUS = "voting_status";



    //column names of student_subject pivot table
    public static final String TABLE_STUDENT_SUBJECT = "student_subject";
    public static final String STUDENT_ID_FK = "student_id";
    public static final String SUBJECT_ID_FK = "subject_id";
    public static final String STUDENT_SUB_CONSTRAINT = "student_sub_unique";

    //others for general purpose key-value pair data
    public static final String TITLE = "title";
    public static final String CREATE_STUDENT = "create_student";
    public static final String UPDATE_STUDENT = "update_student";
    public static final String CREATE_SUBJECT = "create_subject";
    public static final String UPDATE_SUBJECT = "update_subject";
}