package dji.thirdparty.sanselan.util;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class Debug
{
  private static long counter = 0L;
  public static String newline = "\r\n";
  
  private static final String byteQuadToString(int paramInt)
  {
    int n = (byte)(paramInt >> 24 & 0xFF);
    int i1 = (byte)(paramInt >> 16 & 0xFF);
    int i2 = (byte)(paramInt >> 8 & 0xFF);
    int i3 = (byte)(paramInt >> 0 & 0xFF);
    int i = (char)n;
    int j = (char)i1;
    int k = (char)i2;
    int m = (char)i3;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(new String(new char[] { i, j, k, m }));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" bytequad: ");
    localStringBuilder.append(paramInt);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" b1: ");
    localStringBuilder.append(n);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" b2: ");
    localStringBuilder.append(i1);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" b3: ");
    localStringBuilder.append(i2);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" b4: ");
    localStringBuilder.append(i3);
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
  
  public static boolean compare(String paramString, Map paramMap1, Map paramMap2)
  {
    return compare(paramString, paramMap1, paramMap2, null, null);
  }
  
  public static boolean compare(String paramString, Map paramMap1, Map paramMap2, ArrayList paramArrayList, StringBuffer paramStringBuffer)
  {
    boolean bool = true;
    if ((paramMap1 == null) && (paramMap2 == null))
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(paramString);
      paramMap1.append(" both maps null");
      log(paramStringBuffer, paramMap1.toString());
      return true;
    }
    if (paramMap1 == null)
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(paramString);
      paramMap1.append(" map a: null, map b: map");
      log(paramStringBuffer, paramMap1.toString());
      return false;
    }
    if (paramMap2 == null)
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(paramString);
      paramMap1.append(" map a: map, map b: null");
      log(paramStringBuffer, paramMap1.toString());
      return false;
    }
    ArrayList localArrayList2 = new ArrayList(paramMap1.keySet());
    ArrayList localArrayList1 = new ArrayList(paramMap2.keySet());
    if (paramArrayList != null)
    {
      localArrayList2.removeAll(paramArrayList);
      localArrayList1.removeAll(paramArrayList);
    }
    int i = 0;
    while (i < localArrayList2.size())
    {
      paramArrayList = localArrayList2.get(i);
      Object localObject1;
      if (!localArrayList1.contains(paramArrayList))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("b is missing key '");
        ((StringBuilder)localObject1).append(paramArrayList);
        ((StringBuilder)localObject1).append("' from a");
        log(paramStringBuffer, ((StringBuilder)localObject1).toString());
      }
      for (;;)
      {
        bool = false;
        break;
        localArrayList1.remove(paramArrayList);
        localObject1 = paramMap1.get(paramArrayList);
        Object localObject2 = paramMap2.get(paramArrayList);
        if (localObject1.equals(localObject2)) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("key(");
        localStringBuilder.append(paramArrayList);
        localStringBuilder.append(") value a: ");
        localStringBuilder.append(localObject1);
        localStringBuilder.append(") !=  b: ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(")");
        log(paramStringBuffer, localStringBuilder.toString());
      }
      i += 1;
    }
    i = 0;
    while (i < localArrayList1.size())
    {
      paramMap1 = localArrayList1.get(i);
      paramMap2 = new StringBuilder();
      paramMap2.append(paramString);
      paramMap2.append("a is missing key '");
      paramMap2.append(paramMap1);
      paramMap2.append("' from b");
      log(paramStringBuffer, paramMap2.toString());
      i += 1;
      bool = false;
    }
    if (bool)
    {
      paramMap1 = new StringBuilder();
      paramMap1.append(paramString);
      paramMap1.append("a is the same as  b");
      log(paramStringBuffer, paramMap1.toString());
    }
    return bool;
  }
  
  public static void debug() {}
  
  public static void debug(Class paramClass, Throwable paramThrowable)
  {
    debug(paramClass.getName(), paramThrowable);
  }
  
  public static void debug(Object paramObject)
  {
    PrintStream localPrintStream = System.out;
    if (paramObject == null) {
      paramObject = "null";
    } else {
      paramObject = paramObject.toString();
    }
    localPrintStream.println((String)paramObject);
  }
  
  public static void debug(String paramString)
  {
    System.out.println(paramString);
  }
  
  public static void debug(String paramString, double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramDouble);
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt);
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(Long.toString(paramLong));
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    if (paramFile == null) {
      paramString = "null";
    } else {
      paramString = paramFile.getPath();
    }
    localStringBuilder.append(paramString);
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      debug(paramString, "null");
      return;
    }
    if ((paramObject instanceof char[]))
    {
      debug(paramString, (char[])paramObject);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      debug(paramString, (byte[])paramObject);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      debug(paramString, (int[])paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      debug(paramString, (String)paramObject);
      return;
    }
    if ((paramObject instanceof List))
    {
      debug(paramString, (List)paramObject);
      return;
    }
    if ((paramObject instanceof Map))
    {
      debug(paramString, (Map)paramObject);
      return;
    }
    if ((paramObject instanceof File))
    {
      debug(paramString, (File)paramObject);
      return;
    }
    if ((paramObject instanceof Date))
    {
      debug(paramString, (Date)paramObject);
      return;
    }
    if ((paramObject instanceof Calendar))
    {
      debug(paramString, (Calendar)paramObject);
      return;
    }
    debug(paramString, paramObject.toString());
  }
  
  public static void debug(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, Throwable paramThrowable)
  {
    debug(getDebug(paramString, paramThrowable));
  }
  
  public static void debug(String paramString, Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    if (paramCalendar == null) {
      paramCalendar = "null";
    } else {
      paramCalendar = localSimpleDateFormat.format(paramCalendar.getTime());
    }
    debug(paramString, paramCalendar);
  }
  
  public static void debug(String paramString, Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    if (paramDate == null) {
      paramDate = "null";
    } else {
      paramDate = localSimpleDateFormat.format(paramDate);
    }
    debug(paramString, paramDate);
  }
  
  public static void debug(String paramString, List paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" [");
    long l = counter;
    counter = 1L + l;
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (");
    localStringBuilder.append(paramList.size());
    localStringBuilder.append(")");
    localStringBuilder.append((String)localObject);
    debug(localStringBuilder.toString());
    int i = 0;
    while (i < paramList.size())
    {
      paramString = new StringBuilder();
      paramString.append("\t");
      paramString.append(paramList.get(i).toString());
      paramString.append((String)localObject);
      debug(paramString.toString());
      i += 1;
    }
    debug();
  }
  
  public static void debug(String paramString, Map paramMap)
  {
    debug(getDebug(paramString, paramMap));
  }
  
  public static void debug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if (paramBoolean) {
      paramString = "true";
    } else {
      paramString = "false";
    }
    localStringBuilder.append(paramString);
    debug(localStringBuilder.toString());
  }
  
  public static void debug(String paramString, byte[] paramArrayOfByte)
  {
    debug(getDebug(paramString, paramArrayOfByte));
  }
  
  public static void debug(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    debug(getDebug(paramString, paramArrayOfByte, paramInt));
  }
  
  public static void debug(String paramString, char[] paramArrayOfChar)
  {
    debug(getDebug(paramString, paramArrayOfChar));
  }
  
  public static void debug(String paramString, int[] paramArrayOfInt)
  {
    debug(getDebug(paramString, paramArrayOfInt));
  }
  
  public static void debug(String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null) {
      debug(paramString, "null");
    }
    debug(paramString, paramArrayOfObject.length);
    int i = 0;
    while ((i < paramArrayOfObject.length) && (i < 10))
    {
      paramString = new StringBuilder();
      paramString.append("\t");
      paramString.append(i);
      debug(paramString.toString(), paramArrayOfObject[i]);
      i += 1;
    }
    if (paramArrayOfObject.length > 10) {
      debug("\t...");
    }
    debug();
  }
  
  public static void debug(Throwable paramThrowable)
  {
    debug(getDebug(paramThrowable));
  }
  
  public static void debug(Throwable paramThrowable, int paramInt)
  {
    debug(getDebug(paramThrowable, paramInt));
  }
  
  public static void debugByteQuad(String paramString, int paramInt)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": alpha: ");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    localStringBuilder.append(", red: ");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(", green: ");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(", blue: ");
    localStringBuilder.append(paramInt >> 0 & 0xFF);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public static void debugIPQuad(String paramString, int paramInt)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": b1: ");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    localStringBuilder.append(", b2: ");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(", b3: ");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(", b4: ");
    localStringBuilder.append(paramInt >> 0 & 0xFF);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public static void debugIPQuad(String paramString, byte[] paramArrayOfByte)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localPrintStream.print(localStringBuilder.toString());
    if (paramArrayOfByte == null)
    {
      System.out.print("null");
    }
    else
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        if (i > 0) {
          System.out.print(".");
        }
        System.out.print(paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
    }
    System.out.println();
  }
  
  public static void dump(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      debug(paramString, "null");
      return;
    }
    boolean bool = paramObject instanceof Object[];
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i = 0;
    if (bool)
    {
      paramObject = (Object[])paramObject;
      debug(paramString, (Object[])paramObject);
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        dump(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      debug(paramString, (int[])paramObject);
      i = j;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof char[]))
    {
      paramObject = (char[])paramObject;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(new String((char[])paramObject));
      ((StringBuilder)localObject1).append("]");
      debug(paramString, ((StringBuilder)localObject1).toString());
      return;
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (long[])paramObject;
      debug(paramString, paramObject);
      i = k;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])paramObject;
      debug(paramString, paramObject);
      i = m;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    bool = paramObject instanceof byte[];
    if (bool)
    {
      paramObject = (byte[])paramObject;
      debug(paramString, (byte[])paramObject);
      i = n;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
      debug(paramString, paramObject);
      i = i1;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if (bool)
    {
      paramObject = (double[])paramObject;
      debug(paramString, paramObject);
      i = i2;
      while (i < paramObject.length)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        debug(((StringBuilder)localObject1).toString(), paramObject[i]);
        i += 1;
      }
    }
    if ((paramObject instanceof List))
    {
      paramObject = (List)paramObject;
      debug(paramString, "list");
      i = i3;
      while (i < ((List)paramObject).size())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("\tlist: ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(": ");
        dump(((StringBuilder)localObject1).toString(), ((List)paramObject).get(i));
        i += 1;
      }
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      debug(paramString, "map");
      localObject1 = new ArrayList(((Map)paramObject).keySet());
      Collections.sort((List)localObject1);
      i = i4;
      while (i < ((ArrayList)localObject1).size())
      {
        Object localObject2 = ((ArrayList)localObject1).get(i);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\tmap: ");
        localStringBuilder.append(localObject2);
        localStringBuilder.append(" -> ");
        dump(localStringBuilder.toString(), ((Map)paramObject).get(localObject2));
        i += 1;
      }
    }
    debug(paramString, paramObject.toString());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("\t");
    debug(((StringBuilder)localObject1).toString(), paramObject.getClass().getName());
  }
  
  public static void dumpStack()
  {
    debug(getStackTrace(new Exception("Stack trace"), -1, 1));
  }
  
  public static void dumpStack(int paramInt)
  {
    debug(getStackTrace(new Exception("Stack trace"), paramInt, 1));
  }
  
  public static String getDebug(Class paramClass, Throwable paramThrowable)
  {
    if (paramClass == null) {
      paramClass = "[Unknown]";
    } else {
      paramClass = paramClass.getName();
    }
    return getDebug(paramClass, paramThrowable);
  }
  
  public static String getDebug(String paramString)
  {
    return paramString;
  }
  
  public static String getDebug(String paramString, double paramDouble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramDouble);
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramInt);
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(Long.toString(paramLong));
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    if (paramFile == null) {
      paramString = "null";
    } else {
      paramString = paramFile.getPath();
    }
    localStringBuilder.append(paramString);
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return getDebug(paramString, "null");
    }
    if ((paramObject instanceof Calendar)) {
      return getDebug(paramString, (Calendar)paramObject);
    }
    if ((paramObject instanceof Date)) {
      return getDebug(paramString, (Date)paramObject);
    }
    if ((paramObject instanceof File)) {
      return getDebug(paramString, (File)paramObject);
    }
    boolean bool = paramObject instanceof Map;
    if (bool) {
      return getDebug(paramString, (Map)paramObject);
    }
    if (bool) {
      return getDebug(paramString, (Map)paramObject);
    }
    if ((paramObject instanceof String)) {
      return getDebug(paramString, (String)paramObject);
    }
    if ((paramObject instanceof byte[])) {
      return getDebug(paramString, (byte[])paramObject);
    }
    if ((paramObject instanceof char[])) {
      return getDebug(paramString, (char[])paramObject);
    }
    if ((paramObject instanceof int[])) {
      return getDebug(paramString, (int[])paramObject);
    }
    if ((paramObject instanceof List)) {
      return getDebug(paramString, (List)paramObject);
    }
    return getDebug(paramString, paramObject.toString());
  }
  
  public static String getDebug(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(newline);
    localStringBuilder.append(getDebug(paramThrowable));
    return localStringBuilder.toString();
  }
  
  public static String getDebug(String paramString, Calendar paramCalendar)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    if (paramCalendar == null) {
      paramCalendar = "null";
    } else {
      paramCalendar = localSimpleDateFormat.format(paramCalendar.getTime());
    }
    return getDebug(paramString, paramCalendar);
  }
  
  public static String getDebug(String paramString, Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    if (paramDate == null) {
      paramDate = "null";
    } else {
      paramDate = localSimpleDateFormat.format(paramDate);
    }
    return getDebug(paramString, paramDate);
  }
  
  public static String getDebug(String paramString, List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" [");
    long l = counter;
    counter = 1L + l;
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(" (");
    localStringBuilder2.append(paramList.size());
    localStringBuilder2.append(")");
    localStringBuilder2.append((String)localObject);
    localStringBuilder1.append(getDebug(localStringBuilder2.toString()));
    localStringBuilder1.append(newline);
    localStringBuffer.append(localStringBuilder1.toString());
    int i = 0;
    while (i < paramList.size())
    {
      paramString = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("\t");
      localStringBuilder1.append(paramList.get(i).toString());
      localStringBuilder1.append((String)localObject);
      paramString.append(getDebug(localStringBuilder1.toString()));
      paramString.append(newline);
      localStringBuffer.append(paramString.toString());
      i += 1;
    }
    localStringBuffer.append(newline);
    return localStringBuffer.toString();
  }
  
  public static String getDebug(String paramString, Map paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramMap == null)
    {
      paramMap = new StringBuilder();
      paramMap.append(paramString);
      paramMap.append(" map: ");
      paramMap.append(null);
      return getDebug(paramMap.toString());
    }
    ArrayList localArrayList = new ArrayList(paramMap.keySet());
    Object localObject = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" map: ");
    localStringBuilder1.append(localArrayList.size());
    ((StringBuilder)localObject).append(getDebug(localStringBuilder1.toString()));
    ((StringBuilder)localObject).append(newline);
    localStringBuffer.append(((StringBuilder)localObject).toString());
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString = localArrayList.get(i);
      localObject = paramMap.get(paramString);
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\t");
      localStringBuilder2.append(i);
      localStringBuilder2.append(": '");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("' -> '");
      localStringBuilder2.append(localObject);
      localStringBuilder2.append("'");
      localStringBuilder1.append(getDebug(localStringBuilder2.toString()));
      localStringBuilder1.append(newline);
      localStringBuffer.append(localStringBuilder1.toString());
      i += 1;
    }
    localStringBuffer.append(newline);
    return localStringBuffer.toString();
  }
  
  public static String getDebug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    if (paramBoolean) {
      paramString = "true";
    } else {
      paramString = "false";
    }
    localStringBuilder.append(paramString);
    return getDebug(localStringBuilder.toString());
  }
  
  public static String getDebug(String paramString, byte[] paramArrayOfByte)
  {
    return getDebug(paramString, paramArrayOfByte, 250);
  }
  
  public static String getDebug(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(paramString);
      paramArrayOfByte.append(" (");
      paramArrayOfByte.append(null);
      paramArrayOfByte.append(")");
      paramArrayOfByte.append(newline);
      localStringBuffer.append(paramArrayOfByte.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" (");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(")");
      localStringBuilder.append(newline);
      localStringBuffer.append(localStringBuilder.toString());
      int i = 0;
      while ((i < paramInt) && (i < paramArrayOfByte.length))
      {
        int j = paramArrayOfByte[i] & 0xFF;
        char c;
        if ((j != 0) && (j != 10) && (j != 11) && (j != 13)) {
          c = (char)j;
        } else {
          c = ' ';
        }
        paramString = new StringBuilder();
        paramString.append("\t");
        paramString.append(i);
        paramString.append(": ");
        paramString.append(j);
        paramString.append(" (");
        paramString.append(c);
        paramString.append(", 0x");
        paramString.append(Integer.toHexString(j));
        paramString.append(")");
        paramString.append(newline);
        localStringBuffer.append(paramString.toString());
        i += 1;
      }
      if (paramArrayOfByte.length > paramInt)
      {
        paramString = new StringBuilder();
        paramString.append("\t...");
        paramString.append(newline);
        localStringBuffer.append(paramString.toString());
      }
      localStringBuffer.append(newline);
    }
    return localStringBuffer.toString();
  }
  
  public static String getDebug(String paramString, char[] paramArrayOfChar)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder1;
    if (paramArrayOfChar == null)
    {
      paramArrayOfChar = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(" (");
      localStringBuilder1.append(null);
      localStringBuilder1.append(")");
      paramArrayOfChar.append(getDebug(localStringBuilder1.toString()));
      paramArrayOfChar.append(newline);
      localStringBuffer.append(paramArrayOfChar.toString());
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(" (");
      localStringBuilder2.append(paramArrayOfChar.length);
      localStringBuilder2.append(")");
      localStringBuilder1.append(getDebug(localStringBuilder2.toString()));
      localStringBuilder1.append(newline);
      localStringBuffer.append(localStringBuilder1.toString());
      int i = 0;
      while (i < paramArrayOfChar.length)
      {
        paramString = new StringBuilder();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("\t");
        localStringBuilder1.append(paramArrayOfChar[i]);
        localStringBuilder1.append(" (");
        localStringBuilder1.append(paramArrayOfChar[i] & 0xFF);
        paramString.append(getDebug(localStringBuilder1.toString()));
        paramString.append(")");
        paramString.append(newline);
        localStringBuffer.append(paramString.toString());
        i += 1;
      }
      localStringBuffer.append(newline);
    }
    return localStringBuffer.toString();
  }
  
  public static String getDebug(String paramString, int[] paramArrayOfInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfInt == null)
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append(paramString);
      paramArrayOfInt.append(" (");
      paramArrayOfInt.append(null);
      paramArrayOfInt.append(")");
      paramArrayOfInt.append(newline);
      localStringBuffer.append(paramArrayOfInt.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" (");
      localStringBuilder.append(paramArrayOfInt.length);
      localStringBuilder.append(")");
      localStringBuilder.append(newline);
      localStringBuffer.append(localStringBuilder.toString());
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramString = new StringBuilder();
        paramString.append("\t");
        paramString.append(paramArrayOfInt[i]);
        paramString.append(newline);
        localStringBuffer.append(paramString.toString());
        i += 1;
      }
      localStringBuffer.append(newline);
    }
    return localStringBuffer.toString();
  }
  
  public static String getDebug(String paramString, Object[] paramArrayOfObject)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder;
    if (paramArrayOfObject == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getDebug(paramString, "null"));
      localStringBuilder.append(newline);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append(getDebug(paramString, paramArrayOfObject.length));
    int i = 0;
    while ((i < paramArrayOfObject.length) && (i < 10))
    {
      paramString = new StringBuilder();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("\t");
      localStringBuilder.append(i);
      paramString.append(getDebug(localStringBuilder.toString(), paramArrayOfObject[i]));
      paramString.append(newline);
      localStringBuffer.append(paramString.toString());
      i += 1;
    }
    if (paramArrayOfObject.length > 10)
    {
      paramString = new StringBuilder();
      paramString.append(getDebug("\t..."));
      paramString.append(newline);
      localStringBuffer.append(paramString.toString());
    }
    localStringBuffer.append(newline);
    return localStringBuffer.toString();
  }
  
  public static String getDebug(Throwable paramThrowable)
  {
    return getDebug(paramThrowable, -1);
  }
  
  public static String getDebug(Throwable paramThrowable, int paramInt)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = ((SimpleDateFormat)localObject1).format(new Date()).toLowerCase();
    localStringBuffer.append(newline);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Throwable: ");
    if (paramThrowable == null)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramThrowable.getClass().getName());
      ((StringBuilder)localObject1).append(")");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(newline);
    localStringBuffer.append(localStringBuilder.toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Throwable: ");
    if (paramThrowable == null) {
      localObject1 = "null";
    } else {
      localObject1 = paramThrowable.getLocalizedMessage();
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(newline);
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localStringBuffer.append(newline);
    localStringBuffer.append(getStackTrace(paramThrowable, paramInt));
    paramThrowable = new StringBuilder();
    paramThrowable.append("Caught here:");
    paramThrowable.append(newline);
    localStringBuffer.append(paramThrowable.toString());
    localStringBuffer.append(getStackTrace(new Exception(), paramInt, 1));
    localStringBuffer.append(newline);
    return localStringBuffer.toString();
  }
  
  public static String getStackTrace(Throwable paramThrowable)
  {
    return getStackTrace(paramThrowable, -1);
  }
  
  public static String getStackTrace(Throwable paramThrowable, int paramInt)
  {
    return getStackTrace(paramThrowable, paramInt, 0);
  }
  
  public static String getStackTrace(Throwable paramThrowable, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramThrowable != null)
    {
      paramThrowable = paramThrowable.getStackTrace();
      if (paramThrowable != null)
      {
        while ((paramInt2 < paramThrowable.length) && ((paramInt1 < 0) || (paramInt2 < paramInt1)))
        {
          Object localObject = paramThrowable[paramInt2];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("\tat ");
          localStringBuilder.append(((StackTraceElement)localObject).getClassName());
          localStringBuilder.append(".");
          localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
          localStringBuilder.append("(");
          localStringBuilder.append(((StackTraceElement)localObject).getFileName());
          localStringBuilder.append(":");
          localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
          localStringBuilder.append(")");
          localStringBuilder.append(newline);
          localStringBuffer.append(localStringBuilder.toString());
          paramInt2 += 1;
        }
        if ((paramInt1 >= 0) && (paramThrowable.length > paramInt1))
        {
          paramThrowable = new StringBuilder();
          paramThrowable.append("\t...");
          paramThrowable.append(newline);
          localStringBuffer.append(paramThrowable.toString());
        }
      }
      localStringBuffer.append(newline);
    }
    return localStringBuffer.toString();
  }
  
  public static String getType(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    StringBuilder localStringBuilder;
    if ((paramObject instanceof Object[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Object[]: ");
      localStringBuilder.append(((Object[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof char[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[char[]: ");
      localStringBuilder.append(((char[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof byte[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[byte[]: ");
      localStringBuilder.append(((byte[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof short[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[short[]: ");
      localStringBuilder.append(((short[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof int[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[int[]: ");
      localStringBuilder.append(((int[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof long[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[long[]: ");
      localStringBuilder.append(((long[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof float[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[float[]: ");
      localStringBuilder.append(((float[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof double[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[double[]: ");
      localStringBuilder.append(((double[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    if ((paramObject instanceof boolean[]))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[boolean[]: ");
      localStringBuilder.append(((boolean[])paramObject).length);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return paramObject.getClass().getName();
  }
  
  public static boolean isArray(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if ((paramObject instanceof Object[])) {
      return true;
    }
    if ((paramObject instanceof char[])) {
      return true;
    }
    if ((paramObject instanceof byte[])) {
      return true;
    }
    if ((paramObject instanceof short[])) {
      return true;
    }
    if ((paramObject instanceof int[])) {
      return true;
    }
    if ((paramObject instanceof long[])) {
      return true;
    }
    if ((paramObject instanceof float[])) {
      return true;
    }
    if ((paramObject instanceof double[])) {
      return true;
    }
    return (paramObject instanceof boolean[]);
  }
  
  private static void log(StringBuffer paramStringBuffer, String paramString)
  {
    debug(paramString);
    if (paramStringBuffer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(newline);
      paramStringBuffer.append(localStringBuilder.toString());
    }
  }
  
  public static void newline()
  {
    System.out.print(newline);
  }
  
  public static final void purgeMemory()
  {
    try
    {
      System.runFinalization();
      Thread.sleep(50L);
      System.gc();
      Thread.sleep(50L);
      return;
    }
    finally
    {
      debug(localThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\Debug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */