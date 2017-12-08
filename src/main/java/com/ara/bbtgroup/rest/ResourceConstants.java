package com.ara.bbtgroup.rest;

public class ResourceConstants {

    public static final String USER_V1 = "/users";
    public static final String EMPLOYEE_V1 = "/employee";
    public static final String DB_HOSTNAME = "bbt-group-db-server.database.windows.net";
    public static final String DB_NAME = "bbtgroup";
    public static final String DB_USERNAME = "adison";
    public static final String DB_PASSWORT = "TzP9CTQaAdvwzb";

    public static final String CUSTOM_EXCEPTION_1="this is custom exception 1";
    public static final String CUSTOM_EXCEPTION_2="this is custom exception 2";

    public static final String DB_URL =  String.format(
            "jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;",
            DB_HOSTNAME,
            DB_NAME,
            DB_USERNAME,
            DB_PASSWORT
    );
}
