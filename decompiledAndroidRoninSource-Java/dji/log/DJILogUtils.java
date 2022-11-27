package dji.log;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DJILogUtils
{
  private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
  private static final int CALL_STACK_INDEX = 3;
  public static final String FORMAT_1 = "yyyy-MM-dd";
  public static final String FORMAT_2 = "yyyy-MM-dd HH:mm:ss";
  private static final String JSON_ARRAY_PREFIX = "[";
  private static final int JSON_INDENT = 2;
  private static final String JSON_INVALID = "Invalid Json";
  private static final String JSON_OBJECT_PREFIX = "{";
  private static final int MAX_TAG_LENGTH = 23;
  private static final String XMl_INVALID = "Invalid Xml";
  
  public static String exceptionToString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return null;
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = new StringBuilder();
      paramThrowable.append("\r\n");
      paramThrowable.append(localStringWriter.toString());
      paramThrowable.append("\r\n");
      paramThrowable = paramThrowable.toString();
      return paramThrowable;
    }
    catch (Exception paramThrowable)
    {
      for (;;) {}
    }
    return "bad getErrorInfoFromException";
  }
  
  public static String format(long paramLong)
  {
    return format(new Date(paramLong), "yyyy-MM-dd");
  }
  
  public static String format(long paramLong, String paramString)
  {
    return format(new Date(paramLong), paramString);
  }
  
  public static String format(Date paramDate)
  {
    return format(paramDate, "yyyy-MM-dd");
  }
  
  public static String format(Date paramDate, String paramString)
  {
    return obtainDateFormat(paramString).format(Long.valueOf(paramDate.getTime()));
  }
  
  static String formatJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "Invalid Json";
    }
    try
    {
      paramString = paramString.trim();
      if (paramString.startsWith("{")) {
        return new JSONObject(paramString).toString(2);
      }
      if (paramString.startsWith("["))
      {
        paramString = new JSONArray(paramString).toString(2);
        return paramString;
      }
      return "Invalid Json";
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid Json | ");
      localStringBuilder.append(paramString.toString());
      return localStringBuilder.toString();
    }
  }
  
  static String formatMessage(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    try
    {
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
      return str;
    }
    catch (Exception paramVarArgs) {}
    return paramString;
  }
  
  public static String formatNow()
  {
    return format(Calendar.getInstance().getTime(), "yyyy-MM-dd");
  }
  
  public static String formatNow(String paramString)
  {
    return format(Calendar.getInstance().getTime(), paramString);
  }
  
  static String formatObject(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    if (!paramObject.getClass().isArray()) {
      return paramObject.toString();
    }
    if ((paramObject instanceof boolean[])) {
      return Arrays.toString((boolean[])paramObject);
    }
    if ((paramObject instanceof byte[])) {
      return Arrays.toString((byte[])paramObject);
    }
    if ((paramObject instanceof char[])) {
      return Arrays.toString((char[])paramObject);
    }
    if ((paramObject instanceof short[]))
    {
      TextUtils.concat(new CharSequence[0]);
      return Arrays.toString((short[])paramObject);
    }
    if ((paramObject instanceof int[])) {
      return Arrays.toString((int[])paramObject);
    }
    if ((paramObject instanceof long[])) {
      return Arrays.toString((long[])paramObject);
    }
    if ((paramObject instanceof float[])) {
      return Arrays.toString((float[])paramObject);
    }
    if ((paramObject instanceof double[])) {
      return Arrays.toString((double[])paramObject);
    }
    if ((paramObject instanceof Object[])) {
      return Arrays.deepToString((Object[])paramObject);
    }
    return paramObject.toString();
  }
  
  static String formatXml(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "Invalid Xml";
    }
    try
    {
      paramString = new StreamSource(new StringReader(paramString));
      StreamResult localStreamResult = new StreamResult(new StringWriter());
      Transformer localTransformer = TransformerFactory.newInstance().newTransformer();
      localTransformer.setOutputProperty("indent", "yes");
      localTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      localTransformer.transform(paramString, localStreamResult);
      paramString = localStreamResult.getWriter().toString().replaceFirst(">", ">\n");
      return paramString;
    }
    catch (TransformerException paramString) {}
    return "Invalid Xml";
  }
  
  public static String getCurrentStack()
  {
    return getCurrentStack(2, 100);
  }
  
  public static String getCurrentStack(int paramInt)
  {
    return getCurrentStack(2, paramInt);
  }
  
  static String getCurrentStack(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((paramInt1 < arrayOfStackTraceElement.length) && (paramInt1 >= 0) && (paramInt2 > 0))
    {
      int i = Math.min(paramInt2, arrayOfStackTraceElement.length - paramInt1);
      localStringBuilder.append("┌─────────────────────────────────────────────────────────────────────────────────────────────────\n");
      paramInt2 = paramInt1;
      while (paramInt2 < arrayOfStackTraceElement.length)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[paramInt2];
        localStringBuilder.append("│ ");
        localStringBuilder.append(localStackTraceElement.toString());
        localStringBuilder.append("\n");
        if (paramInt2 - paramInt1 + 1 >= i) {
          break;
        }
        paramInt2 += 1;
      }
      localStringBuilder.append("└─────────────────────────────────────────────────────────────────────────────────────────────────");
      return localStringBuilder.toString();
    }
    return "empty stack!!!";
  }
  
  static String getStackTraceString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter(256);
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, false);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return localStringWriter.toString();
  }
  
  public static String getThreadStack(Thread paramThread)
  {
    if (paramThread == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramThread = paramThread.getStackTrace();
    int k = paramThread.length;
    int j = 1;
    int i = 0;
    while (i < k)
    {
      Object localObject = paramThread[i];
      if (j != 0)
      {
        j = 0;
      }
      else
      {
        localStringBuilder.append("\t");
        localStringBuilder.append(((StackTraceElement)localObject).toString());
        localStringBuilder.append("\n");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static SimpleDateFormat obtainDateFormat(String paramString)
  {
    return new SimpleDateFormat(paramString, Locale.getDefault());
  }
  
  static String obtainStackElementTag()
  {
    return obtainStackElementTag(3);
  }
  
  static String obtainStackElementTag(int paramInt)
  {
    Object localObject1 = new Throwable().getStackTrace();
    if (localObject1.length <= paramInt) {
      return "DJIGo";
    }
    localObject1 = localObject1[paramInt].getClassName();
    Object localObject2 = ANONYMOUS_CLASS.matcher((CharSequence)localObject1);
    if (((Matcher)localObject2).find()) {
      localObject1 = ((Matcher)localObject2).replaceAll("");
    }
    localObject2 = ((String)localObject1).substring(((String)localObject1).lastIndexOf('.') + 1);
    localObject1 = localObject2;
    if (((String)localObject2).length() > 23)
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return (String)localObject2;
      }
      localObject1 = ((String)localObject2).substring(0, 23);
    }
    return (String)localObject1;
  }
  
  public static Date parse(String paramString)
  {
    return parse(paramString, "yyyy-MM-dd");
  }
  
  public static Date parse(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = obtainDateFormat(paramString2).parse(paramString1);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */