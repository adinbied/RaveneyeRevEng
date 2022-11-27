package dji.internal.network;

import android.database.Cursor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class AnalyticsEventHelper
{
  public static final int BOOLEAN_FALSE = 0;
  public static final int BOOLEAN_TRUE = 1;
  private static final String TAG = AnalyticsEventHelper.class.getSimpleName();
  private static final String TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
  
  private AnalyticsEventHelper()
  {
    throw new AssertionError("No instances.");
  }
  
  /* Error */
  public static DJIAnalyticsEvent deserializeEvent(Cursor paramCursor)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 43
    //   3: invokestatic 47	dji/internal/network/AnalyticsEventHelper:getByteArray	(Landroid/database/Cursor;Ljava/lang/String;)[B
    //   6: astore_0
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_3
    //   10: astore_1
    //   11: aload_0
    //   12: ifnull +171 -> 183
    //   15: new 49	java/io/ByteArrayInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 52	java/io/ByteArrayInputStream:<init>	([B)V
    //   23: astore 4
    //   25: new 54	java/io/ObjectInputStream
    //   28: dup
    //   29: aload 4
    //   31: invokespecial 57	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_0
    //   35: aload_0
    //   36: astore_1
    //   37: aload_0
    //   38: invokeinterface 63 1 0
    //   43: checkcast 65	dji/internal/network/DJIAnalyticsEvent
    //   46: astore_2
    //   47: aload 4
    //   49: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   52: aload_0
    //   53: invokeinterface 69 1 0
    //   58: aload_2
    //   59: astore_1
    //   60: goto +123 -> 183
    //   63: astore_2
    //   64: goto +12 -> 76
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_1
    //   70: goto +93 -> 163
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: astore_1
    //   78: getstatic 24	dji/internal/network/AnalyticsEventHelper:TAG	Ljava/lang/String;
    //   81: astore 5
    //   83: aload_0
    //   84: astore_1
    //   85: new 71	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload_0
    //   95: astore_1
    //   96: aload 6
    //   98: ldc 74
    //   100: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_0
    //   105: astore_1
    //   106: aload 6
    //   108: aload_2
    //   109: invokevirtual 81	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_0
    //   117: astore_1
    //   118: aload 5
    //   120: aload 6
    //   122: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: iconst_0
    //   126: anewarray 4	java/lang/Object
    //   129: invokestatic 90	dji/log/DJILog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload 4
    //   134: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   137: goto +3 -> 140
    //   140: aload_3
    //   141: astore_1
    //   142: aload_0
    //   143: ifnull +40 -> 183
    //   146: aload_0
    //   147: invokeinterface 69 1 0
    //   152: aload_3
    //   153: astore_1
    //   154: goto +29 -> 183
    //   157: aload_3
    //   158: astore_1
    //   159: goto +24 -> 183
    //   162: astore_0
    //   163: aload 4
    //   165: invokevirtual 68	java/io/ByteArrayInputStream:close	()V
    //   168: goto +3 -> 171
    //   171: aload_1
    //   172: ifnull +9 -> 181
    //   175: aload_1
    //   176: invokeinterface 69 1 0
    //   181: aload_0
    //   182: athrow
    //   183: aload_1
    //   184: astore_0
    //   185: aload_1
    //   186: ifnonnull +11 -> 197
    //   189: new 65	dji/internal/network/DJIAnalyticsEvent
    //   192: dup
    //   193: invokespecial 91	dji/internal/network/DJIAnalyticsEvent:<init>	()V
    //   196: astore_0
    //   197: aload_0
    //   198: areturn
    //   199: astore_1
    //   200: goto -148 -> 52
    //   203: astore_0
    //   204: goto -146 -> 58
    //   207: astore_1
    //   208: goto -68 -> 140
    //   211: astore_0
    //   212: goto -55 -> 157
    //   215: astore_2
    //   216: goto -45 -> 171
    //   219: astore_1
    //   220: goto -39 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramCursor	Cursor
    //   10	176	1	localObject1	Object
    //   199	1	1	localIOException1	java.io.IOException
    //   207	1	1	localIOException2	java.io.IOException
    //   219	1	1	localIOException3	java.io.IOException
    //   46	13	2	localDJIAnalyticsEvent	DJIAnalyticsEvent
    //   63	1	2	localException1	Exception
    //   73	36	2	localException2	Exception
    //   215	1	2	localIOException4	java.io.IOException
    //   8	150	3	localObject2	Object
    //   23	141	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   81	38	5	str	String
    //   92	29	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	47	63	java/lang/Exception
    //   25	35	67	finally
    //   25	35	73	java/lang/Exception
    //   37	47	162	finally
    //   78	83	162	finally
    //   85	94	162	finally
    //   96	104	162	finally
    //   106	116	162	finally
    //   118	132	162	finally
    //   47	52	199	java/io/IOException
    //   52	58	203	java/io/IOException
    //   132	137	207	java/io/IOException
    //   146	152	211	java/io/IOException
    //   163	168	215	java/io/IOException
    //   175	181	219	java/io/IOException
  }
  
  public static boolean getBoolean(Cursor paramCursor, String paramString)
  {
    return getInt(paramCursor, paramString) == 1;
  }
  
  public static byte[] getByteArray(Cursor paramCursor, String paramString)
  {
    return paramCursor.getBlob(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static String getCurrentTime()
  {
    long l = System.currentTimeMillis();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    localSimpleDateFormat.setLenient(false);
    return localSimpleDateFormat.format(new Date(l));
  }
  
  public static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static long getLong(Cursor paramCursor, String paramString)
  {
    return paramCursor.getLong(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
  }
  
  /* Error */
  public static android.content.ContentValues serializeData(DJIAnalyticsEvent paramDJIAnalyticsEvent)
  {
    // Byte code:
    //   0: new 167	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 168	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_3
    //   16: new 170	java/io/ObjectOutputStream
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 173	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: aload_0
    //   30: invokeinterface 178 2 0
    //   35: aload_2
    //   36: astore_1
    //   37: aload 6
    //   39: invokevirtual 182	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   42: astore 5
    //   44: aload_2
    //   45: astore_0
    //   46: aload 5
    //   48: astore_1
    //   49: aload_0
    //   50: invokeinterface 183 1 0
    //   55: aload 6
    //   57: invokevirtual 184	java/io/ByteArrayOutputStream:close	()V
    //   60: goto +86 -> 146
    //   63: astore_1
    //   64: aload_2
    //   65: astore_0
    //   66: aload_1
    //   67: astore_2
    //   68: goto +10 -> 78
    //   71: astore_0
    //   72: goto +92 -> 164
    //   75: astore_2
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: astore_1
    //   80: getstatic 24	dji/internal/network/AnalyticsEventHelper:TAG	Ljava/lang/String;
    //   83: astore 5
    //   85: aload_0
    //   86: astore_1
    //   87: new 71	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   94: astore 7
    //   96: aload_0
    //   97: astore_1
    //   98: aload 7
    //   100: ldc 74
    //   102: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_0
    //   107: astore_1
    //   108: aload 7
    //   110: aload_2
    //   111: invokevirtual 185	java/io/IOException:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_0
    //   119: astore_1
    //   120: aload 5
    //   122: aload 7
    //   124: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: iconst_0
    //   128: anewarray 4	java/lang/Object
    //   131: invokestatic 90	dji/log/DJILog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload 4
    //   136: astore_1
    //   137: aload_0
    //   138: ifnull -83 -> 55
    //   141: aload_3
    //   142: astore_1
    //   143: goto -94 -> 49
    //   146: new 187	android/content/ContentValues
    //   149: dup
    //   150: invokespecial 188	android/content/ContentValues:<init>	()V
    //   153: astore_0
    //   154: aload_0
    //   155: ldc 43
    //   157: aload_1
    //   158: invokevirtual 192	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: aload_1
    //   165: ifnull +9 -> 174
    //   168: aload_1
    //   169: invokeinterface 183 1 0
    //   174: aload 6
    //   176: invokevirtual 184	java/io/ByteArrayOutputStream:close	()V
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: goto -127 -> 55
    //   185: astore_0
    //   186: goto -40 -> 146
    //   189: astore_1
    //   190: goto -16 -> 174
    //   193: astore_1
    //   194: goto -15 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramDJIAnalyticsEvent	DJIAnalyticsEvent
    //   13	36	1	localObject1	Object
    //   63	4	1	localIOException1	java.io.IOException
    //   79	90	1	localObject2	Object
    //   189	1	1	localIOException2	java.io.IOException
    //   193	1	1	localIOException3	java.io.IOException
    //   25	43	2	localObject3	Object
    //   75	36	2	localIOException4	java.io.IOException
    //   15	127	3	localObject4	Object
    //   10	125	4	localObject5	Object
    //   42	79	5	localObject6	Object
    //   7	168	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   94	29	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	35	63	java/io/IOException
    //   37	44	63	java/io/IOException
    //   16	26	71	finally
    //   16	26	75	java/io/IOException
    //   28	35	163	finally
    //   37	44	163	finally
    //   80	85	163	finally
    //   87	96	163	finally
    //   98	106	163	finally
    //   108	118	163	finally
    //   120	134	163	finally
    //   49	55	181	java/io/IOException
    //   55	60	185	java/io/IOException
    //   168	174	189	java/io/IOException
    //   174	179	193	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\AnalyticsEventHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */