package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000+\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020\t\n\000\n\002\b\003\n\002\030\002\n\002\b\002*\001\n\032\016\020\f\032\004\030\0010\r*\0020\005H\000\032\f\020\016\032\0020\005*\0020\rH\000\"\030\020\000\032\n\022\006\022\004\030\0010\0020\001X\004¢\006\004\n\002\020\003\"\026\020\004\032\b\022\004\022\0020\0050\001X\004¢\006\004\n\002\020\006\"\016\020\007\032\0020\bXT¢\006\002\n\000\"\020\020\t\032\0020\nX\004¢\006\004\n\002\020\013¨\006\017"}, d2={"BROWSER_COMPATIBLE_DATE_FORMATS", "", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "", "[Ljava/lang/String;", "MAX_DATE", "", "STANDARD_DATE_FORMAT", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"}, k=2, mv={1, 1, 16})
public final class DatesKt
{
  private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
  private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
  public static final long MAX_DATE = 253402300799999L;
  private static final STANDARD_DATE_FORMAT.1 STANDARD_DATE_FORMAT = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
      localSimpleDateFormat.setLenient(false);
      localSimpleDateFormat.setTimeZone(Util.UTC);
      return (DateFormat)localSimpleDateFormat;
    }
  };
  
  static
  {
    String[] arrayOfString = new String[15];
    arrayOfString[0] = "EEE, dd MMM yyyy HH:mm:ss zzz";
    arrayOfString[1] = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    arrayOfString[2] = "EEE MMM d HH:mm:ss yyyy";
    arrayOfString[3] = "EEE, dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[4] = "EEE, dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[5] = "EEE, dd MMM yy HH:mm:ss z";
    arrayOfString[6] = "EEE dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[7] = "EEE dd MMM yyyy HH:mm:ss z";
    arrayOfString[8] = "EEE dd-MMM-yyyy HH-mm-ss z";
    arrayOfString[9] = "EEE dd-MMM-yy HH:mm:ss z";
    arrayOfString[10] = "EEE dd MMM yy HH:mm:ss z";
    arrayOfString[11] = "EEE,dd-MMM-yy HH:mm:ss z";
    arrayOfString[12] = "EEE,dd-MMM-yyyy HH:mm:ss z";
    arrayOfString[13] = "EEE, dd-MM-yyyy HH:mm:ss z";
    arrayOfString[14] = "EEE MMM d yyyy HH:mm:ss z";
    BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = arrayOfString;
    BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[arrayOfString.length];
  }
  
  public static final Date toHttpDateOrNull(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toHttpDateOrNull");
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    ParsePosition localParsePosition = new ParsePosition(0);
    Object localObject = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(paramString, localParsePosition);
    if (localParsePosition.getIndex() == paramString.length()) {
      return (Date)localObject;
    }
    synchronized (BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS)
    {
      int j = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
      i = 0;
      while (i < j)
      {
        DateFormat localDateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[i];
        localObject = localDateFormat;
        if (localDateFormat == null)
        {
          localObject = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i], Locale.US);
          ((SimpleDateFormat)localObject).setTimeZone(Util.UTC);
          localObject = (DateFormat)localObject;
          BROWSER_COMPATIBLE_DATE_FORMATS[i] = localObject;
        }
        localParsePosition.setIndex(0);
        localObject = ((DateFormat)localObject).parse(paramString, localParsePosition);
        int k = localParsePosition.getIndex();
        if (k != 0) {
          return (Date)localObject;
        }
        i += 1;
      }
      paramString = Unit.INSTANCE;
      return null;
    }
  }
  
  public static final String toHttpDateString(Date paramDate)
  {
    Intrinsics.checkParameterIsNotNull(paramDate, "$this$toHttpDateString");
    paramDate = ((DateFormat)STANDARD_DATE_FORMAT.get()).format(paramDate);
    Intrinsics.checkExpressionValueIsNotNull(paramDate, "STANDARD_DATE_FORMAT.get().format(this)");
    return paramDate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\DatesKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */