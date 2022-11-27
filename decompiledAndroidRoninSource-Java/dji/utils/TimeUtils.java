package dji.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils
{
  public static final int TIMECONSTANT_DAY = 86400000;
  public static final int TIMECONSTANT_HOUR = 3600000;
  public static final int TIMECONSTANT_MIN = 60000;
  public static final int TIMECONSTANT_MSEC = 1;
  public static final int TIMECONSTANT_SEC = 1000;
  
  public static long date2Millis(Date paramDate)
  {
    if (paramDate != null) {
      return paramDate.getTime();
    }
    return -1L;
  }
  
  public static String date2String(Date paramDate)
  {
    return date2String(paramDate, getDefaultFormat());
  }
  
  public static String date2String(Date paramDate, DateFormat paramDateFormat)
  {
    return paramDateFormat.format(paramDate);
  }
  
  public static String formatTimeString(long paramLong)
  {
    long l = paramLong / 60000L;
    paramLong = paramLong % 60000L / 1000L;
    return String.format(Locale.ENGLISH, "%d:%02d", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) });
  }
  
  private static SimpleDateFormat getDefaultFormat()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  }
  
  public static Date getNowDate()
  {
    return new Date();
  }
  
  public static long getNowMills()
  {
    return System.currentTimeMillis();
  }
  
  public static String getNowString()
  {
    return millis2String(System.currentTimeMillis(), getDefaultFormat());
  }
  
  public static String getNowString(DateFormat paramDateFormat)
  {
    return millis2String(System.currentTimeMillis(), paramDateFormat);
  }
  
  public static long getTimeSpan(long paramLong1, long paramLong2, int paramInt)
  {
    return millis2TimeSpan(paramLong1 - paramLong2, paramInt);
  }
  
  public static long getTimeSpan(String paramString1, String paramString2, int paramInt)
  {
    return getTimeSpan(paramString1, paramString2, getDefaultFormat(), paramInt);
  }
  
  public static long getTimeSpan(String paramString1, String paramString2, DateFormat paramDateFormat, int paramInt)
  {
    return millis2TimeSpan(string2Millis(paramString1, paramDateFormat) - string2Millis(paramString2, paramDateFormat), paramInt);
  }
  
  public static long getTimeSpan(Date paramDate1, Date paramDate2, int paramInt)
  {
    return millis2TimeSpan(date2Millis(paramDate1) - date2Millis(paramDate2), paramInt);
  }
  
  public static long getTimeSpanByNow(long paramLong, int paramInt)
  {
    return getTimeSpan(paramLong, System.currentTimeMillis(), paramInt);
  }
  
  public static long getTimeSpanByNow(String paramString, int paramInt)
  {
    return getTimeSpan(paramString, getNowString(), getDefaultFormat(), paramInt);
  }
  
  public static long getTimeSpanByNow(String paramString, DateFormat paramDateFormat, int paramInt)
  {
    return getTimeSpan(paramString, getNowString(paramDateFormat), paramDateFormat, paramInt);
  }
  
  public static long getTimeSpanByNow(Date paramDate, int paramInt)
  {
    return getTimeSpan(paramDate, new Date(), paramInt);
  }
  
  private static long getZeroOfToday()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static boolean isSameDay(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    localCalendar2.setTime(paramDate2);
    return (localCalendar1.get(6) == localCalendar2.get(6)) && (localCalendar1.get(1) == localCalendar2.get(1));
  }
  
  public static boolean isSameDayOfMillis(long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLong1 != 0L)
    {
      bool1 = bool2;
      if (paramLong2 != 0L)
      {
        long l = paramLong1 - paramLong2;
        bool1 = bool2;
        if (l < 86400000L)
        {
          bool1 = bool2;
          if (l > -86400000L)
          {
            bool1 = bool2;
            if (millis2Date(paramLong1) == millis2Date(paramLong2)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isSameYear(long paramLong1, long paramLong2)
  {
    return isSameYear(new Date(paramLong1), new Date(paramLong2));
  }
  
  public static boolean isSameYear(Date paramDate1, Date paramDate2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    localCalendar2.setTime(paramDate2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static boolean isToday(long paramLong)
  {
    return isSameDay(new Date(paramLong), new Date());
  }
  
  public static boolean isYesterday(long paramLong)
  {
    return isYesterday(new Date(paramLong));
  }
  
  public static boolean isYesterday(Date paramDate)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(paramDate);
    localCalendar2.setTime(new Date());
    return (localCalendar1.get(6) == localCalendar2.get(6) - 1) && (localCalendar1.get(1) == localCalendar2.get(1));
  }
  
  public static Date millis2Date(long paramLong)
  {
    return new Date(paramLong);
  }
  
  public static String millis2String(long paramLong)
  {
    return millis2String(paramLong, getDefaultFormat());
  }
  
  public static String millis2String(long paramLong, DateFormat paramDateFormat)
  {
    if ((paramLong != 0L) && (paramDateFormat != null)) {
      try
      {
        paramDateFormat = paramDateFormat.format(new Date(paramLong));
        return paramDateFormat;
      }
      catch (RuntimeException paramDateFormat)
      {
        paramDateFormat.printStackTrace();
      }
    }
    return null;
  }
  
  private static long millis2TimeSpan(long paramLong, int paramInt)
  {
    if ((paramLong != 0L) && (paramInt != 0)) {
      return paramLong / paramInt;
    }
    return -1L;
  }
  
  public static String millsSpanToMinSecString(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)(paramLong % 60L);
    int j = (int)(paramLong / 60L);
    return String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
  }
  
  public static Date string2Date(String paramString)
  {
    return string2Date(paramString, getDefaultFormat());
  }
  
  public static Date string2Date(String paramString, DateFormat paramDateFormat)
  {
    if ((paramString != null) && (paramDateFormat != null)) {
      try
      {
        paramString = paramDateFormat.parse(paramString);
        return paramString;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static long string2Millis(String paramString)
  {
    return string2Millis(paramString, getDefaultFormat());
  }
  
  public static long string2Millis(String paramString, DateFormat paramDateFormat)
  {
    if ((paramString != null) && (paramDateFormat != null)) {
      try
      {
        long l = paramDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -1L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */