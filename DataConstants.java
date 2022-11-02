
public abstract class DataConstants {
    // General Data Constants
    public static final String LIST_UUID = "UUID";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String BIRTHDAY = "birthday";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String NOTES = "notes";
    public static final String ALLERGIES = "allergies";
    public static final String EMERGENCY_CONTACT = "emergencyContact";
    public static final String CONDITIONS = "conditions";
    public static final String ADDRESS = "address";
    public static final String CHILDREN = "children";
    public static final String PEDIATRICIAN = "pediatrician";

    // User Data Constants
    public static final String USER_FILE_NAME = "./JSON/User.JSON";
    public static final String USER_TYPE = "userType";

    public static final String USER_EMAIL = "email";
    public static final String USER_PASSWORD = "password";


    // Child Data Constants
    public static final String CHILD_FILE_NAME = "./JSON/Child.JSON";


    // Emergency Contact Data Constants
    public static final String EC_RELATIONSHIP = "relationship";

    // Group Data Constants
    public static final String GROUP_FILE_NAME = "./JSON/Group.JSON";
    public static final String GROUP_NAME = "groupName";
    public static final String GROUP_CABIN = "cabin";
    public static final String GROUP_SIZE = "groupSize";
    public static final String GROUP_COUNSELOR = "counselorID";
    public static final String GROUP_SCHEDULE = "schedule";
    public static final String GROUP_MAX = "max";
    public static final String GROUP_MIN = "min";

    // Camp Data Constants
    public static final String CAMP_FILE_NAME = "./JSON/Camp.JSON";
    public static final String CAMP_DATE = "date";
    public static final String CAMP_THEME = "theme";
    public static final String CAMP_PRICE = "price";
    public static final String CAMP_GROUP_ID = "groupID";

    // Activity Data Constants
    public static final String ACTIVITY_FILE_NAME = "./JSON/Activity.JSON";
    public static final String ACTIVITY_TITLE = "title";
    public static final String ACTIVITY_DURATION = "duration";
    public static final String ACTIVITY_DESCRIPTION = "description";
    public static final String ACTIVITY_LOCATION = "location";

    // Pediatrician Data Constants
    public static final String PEDIATRICIAN_BUSINESS = "business";

    // Schedule Data Constants
    public static final String[] SCHEDULE_DAYS= {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
            "THURSDAY", "FRIDAY", "SATURDAY"};

    // faq Data Constants
    public static final String FAQ_FILE_NAME = "./JSON/faq.JSON";
    public static final String FAQ_QUESTION = "question";
    public static final String FAQ_ANSWER = "answer";
}
