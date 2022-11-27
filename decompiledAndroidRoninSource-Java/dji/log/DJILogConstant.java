package dji.log;

import java.io.File;

public class DJILogConstant
{
  static final int DEFAULT_LEVEL = 3;
  static final String DEFAULT_TAG = "DJIGo";
  public static final String FORMAT_CONSOLE = "%s";
  public static final String FORMAT_CONSOLE_BOTTOM = "└─────────────────────────────────────────────────────────────────────────────────────────────────";
  public static final String FORMAT_CONSOLE_LEFT = "│";
  public static final String FORMAT_CONSOLE_TOP = "┌─────────────────────────────────────────────────────────────────────────────────────────────────";
  public static final String FORMAT_CONSOLE_WARN = "┌─────────────────────────────────────────────────────────────────────────────────────────────────\n│Bomb!!有人要发红包了!!!\n│\n│警告关键字：%1$s\n│警告内容：%2$s\n│警告说明：%3$s\n└─────────────────────────────────────────────────────────────────────────────────────────────────";
  public static final String FORMAT_FILE = "[%1$s][%2$s]: %3$s";
  public static final String FORMAT_TOAST_WARN = "Bomb!!有人要发红包了!!!\n警告关键字：%1$s\n警告内容：%2$s\n警告说明：%3$s";
  static final String LOG_DIRECTORY_ROOT;
  static final String LOG_DIR_ROOT;
  static final String LOG_FILE_PREFIX = "log-";
  static final String LOG_FILE_TYPE_DEBUG = ".txt";
  static final String LOG_FILE_TYPE_RELEASE = ".log";
  static final String LOG_INFO_LINE_FEED = "\r\n";
  public static final String LOG_INFO_TIME_FORMAT = "kk:mm:ss.SSS";
  static final String PREFIX_WARN_TAG = "DJIWarn│";
  public static boolean WARN_ENABLE = true;
  public static String appVerion;
  public static boolean isDebuggable;
  public static boolean isFactory;
  public static boolean isInner;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LOG");
    localStringBuilder.append(File.separator);
    LOG_DIR_ROOT = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("DJI");
    localStringBuilder.append(File.separator);
    LOG_DIRECTORY_ROOT = localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */