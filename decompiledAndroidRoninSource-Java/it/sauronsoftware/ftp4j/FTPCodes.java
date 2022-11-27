package it.sauronsoftware.ftp4j;

public abstract interface FTPCodes
{
  public static final int BAD_SEQUENCE_OF_COMMANDS = 503;
  public static final int CANNOT_OPEN_DATA_CONNECTION = 425;
  public static final int COMMAND_NOT_IMPLEMENTED = 502;
  public static final int COMMAND_OK = 200;
  public static final int COMMAND_PARAMETER_NOT_IMPLEMENTED = 504;
  public static final int CONNECTION_CLOSED = 426;
  public static final int DATA_CONNECTION_ALREADY_OPEN = 125;
  public static final int DATA_CONNECTION_CLOSING = 226;
  public static final int DATA_CONNECTION_OPEN = 225;
  public static final int DIRECTORY_STATUS = 212;
  public static final int ENTER_PASSIVE_MODE = 227;
  public static final int EXCEEDED_STORAGE_ALLOCATION = 552;
  public static final int FILE_ACTION_COMPLETED = 250;
  public static final int FILE_ACTION_NOT_TAKEN = 450;
  public static final int FILE_NAME_NOT_ALLOWED = 553;
  public static final int FILE_NOT_FOUND = 550;
  public static final int FILE_STATUS = 213;
  public static final int FILE_STATUS_OK = 150;
  public static final int FILE_UNAVAILABLE = 452;
  public static final int HELP_MESSAGE = 214;
  public static final int LOCAL_ERROR_IN_PROCESSING = 451;
  public static final int NAME_SYSTEM_TIME = 215;
  public static final int NEED_ACCOUNT = 332;
  public static final int NOT_LOGGED_IN = 530;
  public static final int PAGE_TYPE_UNKNOWN = 551;
  public static final int PATHNAME_CREATED = 257;
  public static final int PENDING_FURTHER_INFORMATION = 350;
  public static final int RESTART_MARKER = 110;
  public static final int SERVICE_CLOSING_CONTROL_CONNECTION = 221;
  public static final int SERVICE_NOT_AVAILABLE = 421;
  public static final int SERVICE_NOT_READY = 120;
  public static final int SERVICE_READY_FOR_NEW_USER = 220;
  public static final int STATUS_MESSAGE = 211;
  public static final int SUPERFLOUS_COMMAND = 202;
  public static final int SYNTAX_ERROR = 500;
  public static final int SYNTAX_ERROR_IN_PARAMETERS = 501;
  public static final int USERNAME_OK = 331;
  public static final int USER_LOGGED_IN = 230;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */