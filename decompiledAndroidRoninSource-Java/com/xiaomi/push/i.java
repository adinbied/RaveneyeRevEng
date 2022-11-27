package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;

public class i
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static String b = "";
  private static String c;
  private static String d;
  private static final String e = String.valueOf('\002');
  private static String f;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "--", "a-", "u-", "v-", "o-", "g-" };
    f = null;
  }
  
  private static double a(double paramDouble)
  {
    int i = 1;
    double d1;
    for (;;)
    {
      d1 = i;
      if (d1 >= paramDouble) {
        break;
      }
      i <<= 1;
    }
    return d1;
  }
  
  public static int a()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return -1;
    }
    Object localObject = ba.a("android.os.UserHandle", "myUserId", new Object[0]);
    if (localObject == null) {
      return -1;
    }
    return ((Integer)Integer.class.cast(localObject)).intValue();
  }
  
  private static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    int k = paramString.length();
    int j = 0;
    while (i < k)
    {
      j = j * 31 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  private static long a(File paramFile)
  {
    paramFile = new StatFs(paramFile.getPath());
    long l = paramFile.getBlockCount();
    return paramFile.getBlockSize() * l;
  }
  
  public static String a()
  {
    int i = Build.VERSION.SDK_INT;
    String str = null;
    if ((i > 8) && (Build.VERSION.SDK_INT < 26)) {
      return Build.SERIAL;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      str = (String)ba.a("android.os.Build", "getSerial", (Object[])null);
    }
    return str;
  }
  
  private static String a(int paramInt)
  {
    if (paramInt > 0)
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return jdField_a_of_type_ArrayOfJavaLangString[0];
  }
  
  public static String a(Context paramContext)
  {
    paramContext = e(paramContext);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("a-");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(null);
    localStringBuilder2.append(paramContext);
    localStringBuilder2.append(null);
    localStringBuilder1.append(bf.b(localStringBuilder2.toString()));
    return localStringBuilder1.toString();
  }
  
  public static String a(Context paramContext, boolean paramBoolean)
  {
    if (c == null)
    {
      Object localObject2 = e(paramContext);
      Object localObject1;
      if (!l.d())
      {
        if (paramBoolean) {
          localObject1 = f(paramContext);
        } else {
          localObject1 = p(paramContext);
        }
      }
      else {
        localObject1 = "";
      }
      Object localObject3 = a();
      int i = Build.VERSION.SDK_INT;
      int j = 1;
      if (i < 26) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject3)))
      {
        localObject1 = au.a(paramContext).a();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject1 = ((StringBuilder)localObject3).toString();
          i = 2;
        }
        else
        {
          localObject1 = o(paramContext);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = 3;
          }
          else
          {
            localObject1 = au.a(paramContext).b();
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              i = 4;
            }
            else
            {
              i = 5;
              localObject1 = localObject2;
            }
          }
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject3);
        localObject1 = localStringBuilder.toString();
        i = j;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("devid rule select:");
      ((StringBuilder)localObject2).append(i);
      b.b(((StringBuilder)localObject2).toString());
      if (i == 3)
      {
        c = (String)localObject1;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(a(i));
        ((StringBuilder)localObject2).append(bf.b((String)localObject1));
        c = ((StringBuilder)localObject2).toString();
      }
      b(paramContext, c);
    }
    return c;
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 123	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc -75
    //   11: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 183	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifeq +4 -> 36
    //   35: return
    //   36: aload_1
    //   37: putstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   40: aconst_null
    //   41: astore 5
    //   43: aconst_null
    //   44: astore 6
    //   46: aconst_null
    //   47: astore_3
    //   48: aload 5
    //   50: astore 4
    //   52: aload 6
    //   54: astore_1
    //   55: aload_0
    //   56: invokestatic 186	com/xiaomi/push/i:a	(Landroid/content/Context;)Z
    //   59: istore_2
    //   60: iload_2
    //   61: ifeq +119 -> 180
    //   64: aload 5
    //   66: astore 4
    //   68: aload 6
    //   70: astore_1
    //   71: new 92	java/io/File
    //   74: dup
    //   75: invokestatic 192	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   78: ldc -62
    //   80: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 6
    //   90: astore_1
    //   91: aload_3
    //   92: invokevirtual 200	java/io/File:exists	()Z
    //   95: ifeq +29 -> 124
    //   98: aload 5
    //   100: astore 4
    //   102: aload 6
    //   104: astore_1
    //   105: aload_3
    //   106: invokevirtual 203	java/io/File:isFile	()Z
    //   109: ifeq +15 -> 124
    //   112: aload 5
    //   114: astore 4
    //   116: aload 6
    //   118: astore_1
    //   119: aload_3
    //   120: invokevirtual 206	java/io/File:delete	()Z
    //   123: pop
    //   124: aload 5
    //   126: astore 4
    //   128: aload 6
    //   130: astore_1
    //   131: new 92	java/io/File
    //   134: dup
    //   135: aload_3
    //   136: ldc -48
    //   138: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   141: astore 7
    //   143: aload 5
    //   145: astore 4
    //   147: aload 6
    //   149: astore_1
    //   150: aload_0
    //   151: aload 7
    //   153: invokestatic 213	com/xiaomi/push/u:a	(Landroid/content/Context;Ljava/io/File;)Lcom/xiaomi/push/u;
    //   156: astore_3
    //   157: aload_3
    //   158: astore 4
    //   160: aload_3
    //   161: astore_1
    //   162: aload 7
    //   164: invokestatic 218	com/xiaomi/push/y:a	(Ljava/io/File;)V
    //   167: aload_3
    //   168: astore 4
    //   170: aload_3
    //   171: astore_1
    //   172: aload 7
    //   174: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   177: invokestatic 220	com/xiaomi/push/y:a	(Ljava/io/File;Ljava/lang/String;)V
    //   180: aload_3
    //   181: astore 4
    //   183: aload_3
    //   184: astore_1
    //   185: new 92	java/io/File
    //   188: dup
    //   189: aload_0
    //   190: invokevirtual 225	android/content/Context:getFilesDir	()Ljava/io/File;
    //   193: ldc -48
    //   195: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   198: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   201: invokestatic 220	com/xiaomi/push/y:a	(Ljava/io/File;Ljava/lang/String;)V
    //   204: aload_3
    //   205: ifnull +65 -> 270
    //   208: aload_3
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   214: return
    //   215: astore_0
    //   216: goto +55 -> 271
    //   219: astore_0
    //   220: aload_1
    //   221: astore 4
    //   223: new 123	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   230: astore_3
    //   231: aload_1
    //   232: astore 4
    //   234: aload_3
    //   235: ldc -27
    //   237: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: astore 4
    //   244: aload_3
    //   245: aload_0
    //   246: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: astore 4
    //   256: aload_3
    //   257: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   263: aload_1
    //   264: ifnull +6 -> 270
    //   267: goto -57 -> 210
    //   270: return
    //   271: aload 4
    //   273: ifnull +8 -> 281
    //   276: aload 4
    //   278: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   281: aload_0
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramContext	Context
    //   0	283	1	paramString	String
    //   59	2	2	bool	boolean
    //   7	250	3	localObject1	Object
    //   50	227	4	localObject2	Object
    //   41	103	5	localObject3	Object
    //   44	104	6	localObject4	Object
    //   141	32	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   55	60	215	finally
    //   71	84	215	finally
    //   91	98	215	finally
    //   105	112	215	finally
    //   119	124	215	finally
    //   131	143	215	finally
    //   150	157	215	finally
    //   162	167	215	finally
    //   172	180	215	finally
    //   185	204	215	finally
    //   223	231	215	finally
    //   234	241	215	finally
    //   244	253	215	finally
    //   256	263	215	finally
    //   55	60	219	java/io/IOException
    //   71	84	219	java/io/IOException
    //   91	98	219	java/io/IOException
    //   105	112	219	java/io/IOException
    //   119	124	219	java/io/IOException
    //   131	143	219	java/io/IOException
    //   150	157	219	java/io/IOException
    //   162	167	219	java/io/IOException
    //   172	180	219	java/io/IOException
    //   185	204	219	java/io/IOException
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool2 = m.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (l.a()) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 26) {
      bool1 = true;
    }
    if (!bool1) {
      return t.a(paramContext);
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString.startsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static int b()
  {
    if (Build.VERSION.SDK_INT < 29) {
      return 10;
    }
    return 0;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: new 92	java/io/File
    //   3: dup
    //   4: ldc -2
    //   6: invokespecial 255	java/io/File:<init>	(Ljava/lang/String;)V
    //   9: invokevirtual 200	java/io/File:exists	()Z
    //   12: istore 4
    //   14: ldc_w 257
    //   17: astore 6
    //   19: aload 6
    //   21: astore 5
    //   23: iload 4
    //   25: ifeq +191 -> 216
    //   28: aconst_null
    //   29: astore 5
    //   31: new 259	java/io/BufferedReader
    //   34: dup
    //   35: new 261	java/io/FileReader
    //   38: dup
    //   39: ldc -2
    //   41: invokespecial 262	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: sipush 8192
    //   47: invokespecial 265	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   50: astore 8
    //   52: aload 8
    //   54: invokevirtual 268	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   57: astore 7
    //   59: aload 6
    //   61: astore 5
    //   63: aload 7
    //   65: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +98 -> 166
    //   71: aload 7
    //   73: ldc_w 270
    //   76: invokevirtual 274	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   79: astore 7
    //   81: aload 6
    //   83: astore 5
    //   85: aload 7
    //   87: ifnull +79 -> 166
    //   90: aload 6
    //   92: astore 5
    //   94: aload 7
    //   96: arraylength
    //   97: iconst_2
    //   98: if_icmplt +68 -> 166
    //   101: aload 7
    //   103: iconst_1
    //   104: aaload
    //   105: invokestatic 279	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   108: invokevirtual 283	java/lang/Double:doubleValue	()D
    //   111: ldc2_w 284
    //   114: ddiv
    //   115: ldc2_w 284
    //   118: ddiv
    //   119: dstore_2
    //   120: dload_2
    //   121: dstore_0
    //   122: dload_2
    //   123: ldc2_w 286
    //   126: dcmpl
    //   127: ifle +8 -> 135
    //   130: dload_2
    //   131: invokestatic 292	java/lang/Math:ceil	(D)D
    //   134: dstore_0
    //   135: new 123	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: dload_0
    //   147: invokevirtual 295	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 5
    //   153: ldc 12
    //   155: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 5
    //   161: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore 5
    //   166: aload 5
    //   168: astore 7
    //   170: aload 8
    //   172: invokevirtual 298	java/io/BufferedReader:close	()V
    //   175: goto +41 -> 216
    //   178: aload 6
    //   180: astore 5
    //   182: aload 8
    //   184: ifnull +32 -> 216
    //   187: aload 6
    //   189: astore 7
    //   191: aload 8
    //   193: invokevirtual 298	java/io/BufferedReader:close	()V
    //   196: aload 6
    //   198: astore 5
    //   200: goto +16 -> 216
    //   203: aload 8
    //   205: ifnull +8 -> 213
    //   208: aload 8
    //   210: invokevirtual 298	java/io/BufferedReader:close	()V
    //   213: aload 5
    //   215: athrow
    //   216: new 123	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   223: astore 6
    //   225: aload 6
    //   227: aload 5
    //   229: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 6
    //   235: ldc_w 300
    //   238: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 6
    //   244: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: areturn
    //   248: astore 7
    //   250: aload 5
    //   252: astore 8
    //   254: goto -76 -> 178
    //   257: astore 5
    //   259: goto +22 -> 281
    //   262: astore 5
    //   264: aload 7
    //   266: astore 5
    //   268: goto -52 -> 216
    //   271: astore 6
    //   273: goto -60 -> 213
    //   276: astore 5
    //   278: goto -75 -> 203
    //   281: goto -103 -> 178
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 8
    //   289: goto -86 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   121	26	0	d1	double
    //   119	12	2	d2	double
    //   12	12	4	bool	boolean
    //   21	230	5	localObject1	Object
    //   257	1	5	localException1	Exception
    //   262	1	5	localIOException1	java.io.IOException
    //   266	1	5	localObject2	Object
    //   276	1	5	localObject3	Object
    //   284	1	5	localObject4	Object
    //   17	226	6	localObject5	Object
    //   271	1	6	localIOException2	java.io.IOException
    //   57	133	7	localObject6	Object
    //   248	17	7	localException2	Exception
    //   50	238	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   31	52	248	java/lang/Exception
    //   52	59	257	java/lang/Exception
    //   63	81	257	java/lang/Exception
    //   94	120	257	java/lang/Exception
    //   130	135	257	java/lang/Exception
    //   135	166	257	java/lang/Exception
    //   170	175	262	java/io/IOException
    //   191	196	262	java/io/IOException
    //   208	213	271	java/io/IOException
    //   52	59	276	finally
    //   63	81	276	finally
    //   94	120	276	finally
    //   130	135	276	finally
    //   135	166	276	finally
    //   31	52	284	finally
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = j.a(paramContext).a();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failure to get gaid:");
      localStringBuilder.append(paramContext.getMessage());
      b.a(localStringBuilder.toString());
    }
    return null;
  }
  
  /* Error */
  private static void b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 123	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 313
    //   12: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 183	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   29: aload_1
    //   30: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifeq +4 -> 37
    //   36: return
    //   37: aconst_null
    //   38: astore_3
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore 5
    //   45: aload_3
    //   46: astore_2
    //   47: aload 4
    //   49: astore_1
    //   50: aload_0
    //   51: invokestatic 186	com/xiaomi/push/i:a	(Landroid/content/Context;)Z
    //   54: ifeq +214 -> 268
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: astore_1
    //   62: new 92	java/io/File
    //   65: dup
    //   66: invokestatic 192	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   69: ldc -62
    //   71: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 5
    //   76: aload_3
    //   77: astore_2
    //   78: aload 4
    //   80: astore_1
    //   81: aload 5
    //   83: invokevirtual 200	java/io/File:exists	()Z
    //   86: ifeq +27 -> 113
    //   89: aload_3
    //   90: astore_2
    //   91: aload 4
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 203	java/io/File:isFile	()Z
    //   99: ifeq +14 -> 113
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: astore_1
    //   107: aload 5
    //   109: invokevirtual 206	java/io/File:delete	()Z
    //   112: pop
    //   113: aload_3
    //   114: astore_2
    //   115: aload 4
    //   117: astore_1
    //   118: new 92	java/io/File
    //   121: dup
    //   122: aload 5
    //   124: ldc_w 315
    //   127: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   130: astore 5
    //   132: aload_3
    //   133: astore_2
    //   134: aload 4
    //   136: astore_1
    //   137: aload 5
    //   139: invokevirtual 200	java/io/File:exists	()Z
    //   142: ifeq +28 -> 170
    //   145: aload_3
    //   146: astore_2
    //   147: aload 4
    //   149: astore_1
    //   150: aload 5
    //   152: invokevirtual 203	java/io/File:isFile	()Z
    //   155: ifeq +15 -> 170
    //   158: aload_3
    //   159: astore_2
    //   160: aload 4
    //   162: astore_1
    //   163: ldc_w 317
    //   166: invokestatic 172	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   169: return
    //   170: aload_3
    //   171: astore_2
    //   172: aload 4
    //   174: astore_1
    //   175: aload_0
    //   176: aload 5
    //   178: invokestatic 213	com/xiaomi/push/u:a	(Landroid/content/Context;Ljava/io/File;)Lcom/xiaomi/push/u;
    //   181: astore_0
    //   182: aload_0
    //   183: astore_2
    //   184: aload_0
    //   185: astore_1
    //   186: aload 5
    //   188: invokestatic 218	com/xiaomi/push/y:a	(Ljava/io/File;)V
    //   191: aload_0
    //   192: astore_2
    //   193: aload_0
    //   194: astore_1
    //   195: new 123	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   202: astore_3
    //   203: aload_0
    //   204: astore_2
    //   205: aload_0
    //   206: astore_1
    //   207: aload_3
    //   208: getstatic 140	com/xiaomi/push/i:c	Ljava/lang/String;
    //   211: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_0
    //   216: astore_2
    //   217: aload_0
    //   218: astore_1
    //   219: aload_3
    //   220: getstatic 26	com/xiaomi/push/i:e	Ljava/lang/String;
    //   223: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_0
    //   228: astore_2
    //   229: aload_0
    //   230: astore_1
    //   231: aload_3
    //   232: getstatic 140	com/xiaomi/push/i:c	Ljava/lang/String;
    //   235: invokestatic 319	com/xiaomi/push/i:a	(Ljava/lang/String;)I
    //   238: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_0
    //   243: astore_2
    //   244: aload_0
    //   245: astore_1
    //   246: aload 5
    //   248: aload_3
    //   249: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 220	com/xiaomi/push/y:a	(Ljava/io/File;Ljava/lang/String;)V
    //   255: aload_0
    //   256: astore_2
    //   257: aload_0
    //   258: astore_1
    //   259: ldc_w 321
    //   262: invokestatic 172	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   265: goto +17 -> 282
    //   268: aload_3
    //   269: astore_2
    //   270: aload 4
    //   272: astore_1
    //   273: ldc_w 323
    //   276: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   279: aload 5
    //   281: astore_0
    //   282: aload_0
    //   283: ifnull +62 -> 345
    //   286: aload_0
    //   287: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   290: return
    //   291: astore_0
    //   292: goto +54 -> 346
    //   295: astore_0
    //   296: aload_1
    //   297: astore_2
    //   298: new 123	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   305: astore_3
    //   306: aload_1
    //   307: astore_2
    //   308: aload_3
    //   309: ldc_w 325
    //   312: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_1
    //   317: astore_2
    //   318: aload_3
    //   319: aload_0
    //   320: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   323: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_1
    //   328: astore_2
    //   329: aload_3
    //   330: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   336: aload_1
    //   337: ifnull +8 -> 345
    //   340: aload_1
    //   341: astore_0
    //   342: goto -56 -> 286
    //   345: return
    //   346: aload_2
    //   347: ifnull +7 -> 354
    //   350: aload_2
    //   351: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   354: aload_0
    //   355: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString	String
    //   7	344	2	localObject1	Object
    //   38	292	3	localStringBuilder	StringBuilder
    //   40	231	4	localObject2	Object
    //   43	237	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   50	57	291	finally
    //   62	76	291	finally
    //   81	89	291	finally
    //   94	102	291	finally
    //   107	113	291	finally
    //   118	132	291	finally
    //   137	145	291	finally
    //   150	158	291	finally
    //   163	169	291	finally
    //   175	182	291	finally
    //   186	191	291	finally
    //   195	203	291	finally
    //   207	215	291	finally
    //   219	227	291	finally
    //   231	242	291	finally
    //   246	255	291	finally
    //   259	265	291	finally
    //   273	279	291	finally
    //   298	306	291	finally
    //   308	316	291	finally
    //   318	327	291	finally
    //   329	336	291	finally
    //   50	57	295	java/io/IOException
    //   62	76	295	java/io/IOException
    //   81	89	295	java/io/IOException
    //   94	102	295	java/io/IOException
    //   107	113	295	java/io/IOException
    //   118	132	295	java/io/IOException
    //   137	145	295	java/io/IOException
    //   150	158	295	java/io/IOException
    //   163	169	295	java/io/IOException
    //   175	182	295	java/io/IOException
    //   186	191	295	java/io/IOException
    //   195	203	295	java/io/IOException
    //   207	215	295	java/io/IOException
    //   219	227	295	java/io/IOException
    //   231	242	295	java/io/IOException
    //   246	255	295	java/io/IOException
    //   259	265	295	java/io/IOException
    //   273	279	295	java/io/IOException
  }
  
  private static boolean b(Context paramContext)
  {
    String str = paramContext.getPackageName();
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", str) == 0;
  }
  
  private static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.length() <= 15)
    {
      if (paramString.length() < 14) {
        return false;
      }
      if (!bf.b(paramString)) {
        return false;
      }
      return !bf.c(paramString);
    }
    return false;
  }
  
  public static String c()
  {
    double d1 = a(a(Environment.getDataDirectory()) / 1024.0D / 1024.0D / 1024.0D);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(d1);
    localStringBuilder.append("GB");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 186	com/xiaomi/push/i:a	(Landroid/content/Context;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: iload_1
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   20: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +7 -> 30
    //   26: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   29: areturn
    //   30: new 92	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 225	android/content/Context:getFilesDir	()Ljava/io/File;
    //   38: ldc -48
    //   40: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: invokestatic 354	com/xiaomi/push/y:a	(Ljava/io/File;)Ljava/lang/String;
    //   46: astore_2
    //   47: aload_2
    //   48: putstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   51: aload_2
    //   52: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +7 -> 62
    //   58: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   61: areturn
    //   62: aload 4
    //   64: astore_2
    //   65: aload 5
    //   67: astore_3
    //   68: new 92	java/io/File
    //   71: dup
    //   72: new 92	java/io/File
    //   75: dup
    //   76: invokestatic 192	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   79: ldc -62
    //   81: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: ldc -48
    //   86: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   89: astore 6
    //   91: aload 4
    //   93: astore_2
    //   94: aload 5
    //   96: astore_3
    //   97: aload_0
    //   98: aload 6
    //   100: invokestatic 213	com/xiaomi/push/u:a	(Landroid/content/Context;Ljava/io/File;)Lcom/xiaomi/push/u;
    //   103: astore_0
    //   104: aload_0
    //   105: astore_2
    //   106: aload_0
    //   107: astore_3
    //   108: ldc 12
    //   110: putstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   113: aload_0
    //   114: astore_2
    //   115: aload_0
    //   116: astore_3
    //   117: aload 6
    //   119: invokestatic 354	com/xiaomi/push/y:a	(Ljava/io/File;)Ljava/lang/String;
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull +12 -> 138
    //   129: aload_0
    //   130: astore_2
    //   131: aload_0
    //   132: astore_3
    //   133: aload 4
    //   135: putstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   138: aload_0
    //   139: astore_2
    //   140: aload_0
    //   141: astore_3
    //   142: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   145: astore 4
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   155: aload 4
    //   157: areturn
    //   158: astore_0
    //   159: goto +60 -> 219
    //   162: astore_0
    //   163: aload_3
    //   164: astore_2
    //   165: new 123	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   172: astore 4
    //   174: aload_3
    //   175: astore_2
    //   176: aload 4
    //   178: ldc_w 356
    //   181: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_3
    //   186: astore_2
    //   187: aload 4
    //   189: aload_0
    //   190: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   193: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_3
    //   198: astore_2
    //   199: aload 4
    //   201: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   215: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   218: areturn
    //   219: aload_2
    //   220: ifnull +7 -> 227
    //   223: aload_2
    //   224: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   227: aload_0
    //   228: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramContext	Context
    //   4	8	1	bool	boolean
    //   46	178	2	localObject1	Object
    //   67	145	3	localObject2	Object
    //   9	191	4	localObject3	Object
    //   6	89	5	localObject4	Object
    //   89	29	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   68	91	158	finally
    //   97	104	158	finally
    //   108	113	158	finally
    //   117	124	158	finally
    //   133	138	158	finally
    //   142	147	158	finally
    //   165	174	158	finally
    //   176	185	158	finally
    //   187	197	158	finally
    //   199	207	158	finally
    //   68	91	162	java/io/IOException
    //   97	104	162	java/io/IOException
    //   108	113	162	java/io/IOException
    //   117	124	162	java/io/IOException
    //   133	138	162	java/io/IOException
    //   142	147	162	java/io/IOException
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 186	com/xiaomi/push/i:a	(Landroid/content/Context;)Z
    //   4: istore_1
    //   5: aconst_null
    //   6: astore_2
    //   7: iload_1
    //   8: ifeq +310 -> 318
    //   11: getstatic 44	com/xiaomi/push/i:jdField_a_of_type_Boolean	Z
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: iconst_1
    //   20: putstatic 44	com/xiaomi/push/i:jdField_a_of_type_Boolean	Z
    //   23: new 92	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 225	android/content/Context:getFilesDir	()Ljava/io/File;
    //   31: ldc -48
    //   33: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: invokestatic 354	com/xiaomi/push/y:a	(Ljava/io/File;)Ljava/lang/String;
    //   39: astore 5
    //   41: new 92	java/io/File
    //   44: dup
    //   45: new 92	java/io/File
    //   48: dup
    //   49: invokestatic 192	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   52: ldc -62
    //   54: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   57: ldc -48
    //   59: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   62: astore 4
    //   64: aload_0
    //   65: aload 4
    //   67: invokestatic 213	com/xiaomi/push/u:a	(Landroid/content/Context;Ljava/io/File;)Lcom/xiaomi/push/u;
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload 4
    //   75: invokestatic 354	com/xiaomi/push/y:a	(Ljava/io/File;)Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: astore_2
    //   83: aload_3
    //   84: ifnull +81 -> 165
    //   87: aload_3
    //   88: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   91: aload 4
    //   93: astore_2
    //   94: goto +71 -> 165
    //   97: astore 4
    //   99: goto +11 -> 110
    //   102: astore_0
    //   103: goto +205 -> 308
    //   106: astore 4
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_3
    //   111: astore_2
    //   112: new 123	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   119: astore 6
    //   121: aload_3
    //   122: astore_2
    //   123: aload 6
    //   125: ldc_w 358
    //   128: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_3
    //   133: astore_2
    //   134: aload 6
    //   136: aload 4
    //   138: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   141: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_3
    //   146: astore_2
    //   147: aload 6
    //   149: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   163: aconst_null
    //   164: astore_2
    //   165: aload 5
    //   167: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +127 -> 297
    //   173: aload 5
    //   175: putstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   178: aload_2
    //   179: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +33 -> 215
    //   185: aload_2
    //   186: invokevirtual 83	java/lang/String:length	()I
    //   189: sipush 128
    //   192: if_icmple +6 -> 198
    //   195: goto +20 -> 215
    //   198: aload 5
    //   200: aload_2
    //   201: invokestatic 362	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   204: ifne +46 -> 250
    //   207: ldc_w 364
    //   210: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   213: aload_2
    //   214: areturn
    //   215: new 123	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   222: astore_3
    //   223: aload_3
    //   224: ldc_w 366
    //   227: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_3
    //   232: aload_2
    //   233: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_3
    //   238: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   244: aload_0
    //   245: aload 5
    //   247: invokestatic 368	com/xiaomi/push/i:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   250: new 123	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: ldc_w 370
    //   262: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: getstatic 42	com/xiaomi/push/i:f	Ljava/lang/String;
    //   270: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_0
    //   275: ldc_w 372
    //   278: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload_0
    //   283: aload_2
    //   284: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_0
    //   289: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 183	com/xiaomi/channel/commonutils/logger/b:c	(Ljava/lang/String;)V
    //   295: aconst_null
    //   296: areturn
    //   297: ldc_w 374
    //   300: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   303: ldc_w 376
    //   306: areturn
    //   307: astore_0
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   316: aload_0
    //   317: athrow
    //   318: aconst_null
    //   319: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   4	4	1	bool	boolean
    //   6	307	2	localObject1	Object
    //   70	168	3	localObject2	Object
    //   62	30	4	localObject3	Object
    //   97	1	4	localIOException1	java.io.IOException
    //   106	31	4	localIOException2	java.io.IOException
    //   39	207	5	str	String
    //   119	29	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	80	97	java/io/IOException
    //   41	71	102	finally
    //   41	71	106	java/io/IOException
    //   73	80	307	finally
    //   112	121	307	finally
    //   123	132	307	finally
    //   134	145	307	finally
    //   147	155	307	finally
  }
  
  public static String e(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    finally
    {
      b.a(paramContext);
    }
    return null;
  }
  
  public static String f(Context paramContext)
  {
    int i = b();
    String str = g(paramContext);
    for (;;)
    {
      if ((str == null) && (i > 0)) {}
      try
      {
        Thread.sleep(500L);
        str = g(paramContext);
        i -= 1;
        continue;
        return str;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public static String g(Context paramContext)
  {
    if (l.d()) {
      return "";
    }
    Object localObject1 = jdField_a_of_type_JavaLangString;
    if (localObject1 != null) {
      return (String)localObject1;
    }
    for (;;)
    {
      try
      {
        if (l.a())
        {
          localObject1 = ba.a("miui.telephony.TelephonyManager", "getDefault", new Object[0]);
          if (localObject1 != null)
          {
            localObject1 = ba.a(localObject1, "getMiuiDeviceId", new Object[0]);
            if ((localObject1 != null) && ((localObject1 instanceof String)))
            {
              localObject1 = (String)String.class.cast(localObject1);
              Object localObject2 = localObject1;
              if (localObject1 == null)
              {
                localObject2 = localObject1;
                if (b(paramContext))
                {
                  paramContext = (TelephonyManager)paramContext.getSystemService("phone");
                  if (Build.VERSION.SDK_INT < 26)
                  {
                    localObject2 = paramContext.getDeviceId();
                  }
                  else if (1 == paramContext.getPhoneType())
                  {
                    paramContext = ba.a(paramContext, "getImei", (Object[])null);
                    localObject2 = (String)paramContext;
                  }
                  else
                  {
                    localObject2 = localObject1;
                    if (2 == paramContext.getPhoneType())
                    {
                      paramContext = ba.a(paramContext, "getMeid", (Object[])null);
                      continue;
                    }
                  }
                }
              }
              if (b((String)localObject2))
              {
                jdField_a_of_type_JavaLangString = (String)localObject2;
                return (String)localObject2;
              }
              return "";
            }
          }
        }
      }
      finally
      {
        b.a(paramContext);
        return null;
      }
      localObject1 = null;
    }
  }
  
  public static String h(Context paramContext)
  {
    int i = b();
    String str = j(paramContext);
    for (;;)
    {
      if ((str == null) && (i > 0)) {}
      try
      {
        Thread.sleep(500L);
        str = j(paramContext);
        i -= 1;
        continue;
        return str;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
  
  public static String i(Context paramContext)
  {
    if (l.d()) {
      return "";
    }
    if (Build.VERSION.SDK_INT < 22) {
      return "";
    }
    if (!TextUtils.isEmpty(b)) {
      return b;
    }
    if (!b(paramContext)) {
      return "";
    }
    g(paramContext);
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return "";
    }
    for (;;)
    {
      int i;
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        Integer localInteger = (Integer)ba.a(localTelephonyManager, "getPhoneCount", new Object[0]);
        if ((localInteger != null) && (localInteger.intValue() > 1))
        {
          paramContext = null;
          i = 0;
          if (i < localInteger.intValue())
          {
            if (Build.VERSION.SDK_INT < 26)
            {
              paramContext = ba.a(localTelephonyManager, "getDeviceId", new Object[] { Integer.valueOf(i) });
              paramContext = (String)paramContext;
            }
            else
            {
              if (1 == localTelephonyManager.getPhoneType())
              {
                paramContext = ba.a(localTelephonyManager, "getImei", new Object[] { Integer.valueOf(i) });
                continue;
              }
              if (2 == localTelephonyManager.getPhoneType())
              {
                paramContext = ba.a(localTelephonyManager, "getMeid", new Object[] { Integer.valueOf(i) });
                continue;
              }
            }
            if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(jdField_a_of_type_JavaLangString, paramContext)) && (b(paramContext)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(b);
              localStringBuilder.append(paramContext);
              localStringBuilder.append(",");
              b = localStringBuilder.toString();
            }
          }
          else
          {
            i = b.length();
            if (i > 0) {
              b = b.substring(0, i - 1);
            }
            paramContext = b;
            return paramContext;
          }
        }
        else
        {
          return "";
        }
      }
      catch (Exception paramContext)
      {
        b.d(paramContext.toString());
        return "";
      }
      i += 1;
    }
  }
  
  public static String j(Context paramContext)
  {
    i(paramContext);
    boolean bool = TextUtils.isEmpty(b);
    paramContext = "";
    if (bool) {
      return "";
    }
    Object localObject = b.split(",");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      String str = localObject[i];
      if (b(str))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append(bf.a(str));
        localStringBuilder.append(",");
        paramContext = localStringBuilder.toString();
      }
      i += 1;
    }
    i = paramContext.length();
    localObject = paramContext;
    if (i > 0) {
      localObject = paramContext.substring(0, i - 1);
    }
    return (String)localObject;
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      if (d != null)
      {
        paramContext = d;
        return paramContext;
      }
      paramContext = e(paramContext);
      String str = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(str);
      paramContext = bf.b(localStringBuilder.toString());
      d = paramContext;
      return paramContext;
    }
    finally {}
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      paramContext = e(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(null);
      paramContext = bf.b(localStringBuilder.toString());
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String m(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperatorName();
  }
  
  public static String n(Context paramContext)
  {
    return "";
  }
  
  /* Error */
  private static String o(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 186	com/xiaomi/push/i:a	(Landroid/content/Context;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore 6
    //   20: iload_3
    //   21: ifne +11 -> 32
    //   24: ldc_w 475
    //   27: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   30: aconst_null
    //   31: areturn
    //   32: aload 9
    //   34: astore 5
    //   36: new 92	java/io/File
    //   39: dup
    //   40: new 92	java/io/File
    //   43: dup
    //   44: invokestatic 192	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   47: ldc -62
    //   49: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: ldc_w 315
    //   55: invokespecial 197	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   58: astore 10
    //   60: aload 9
    //   62: astore 5
    //   64: aload 10
    //   66: invokevirtual 200	java/io/File:exists	()Z
    //   69: ifeq +162 -> 231
    //   72: aload 9
    //   74: astore 5
    //   76: aload 10
    //   78: invokevirtual 203	java/io/File:isFile	()Z
    //   81: ifeq +150 -> 231
    //   84: aload 9
    //   86: astore 5
    //   88: aload_0
    //   89: aload 10
    //   91: invokestatic 213	com/xiaomi/push/u:a	(Landroid/content/Context;Ljava/io/File;)Lcom/xiaomi/push/u;
    //   94: astore 4
    //   96: aload 7
    //   98: astore 5
    //   100: aload 10
    //   102: invokestatic 354	com/xiaomi/push/y:a	(Ljava/io/File;)Ljava/lang/String;
    //   105: astore 8
    //   107: aload 6
    //   109: astore_0
    //   110: aload 7
    //   112: astore 5
    //   114: aload 8
    //   116: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +70 -> 189
    //   122: aload 7
    //   124: astore 5
    //   126: aload 8
    //   128: getstatic 26	com/xiaomi/push/i:e	Ljava/lang/String;
    //   131: invokevirtual 274	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   134: astore 9
    //   136: aload 6
    //   138: astore_0
    //   139: aload 7
    //   141: astore 5
    //   143: aload 9
    //   145: arraylength
    //   146: iconst_2
    //   147: if_icmpne +42 -> 189
    //   150: aload 9
    //   152: iconst_0
    //   153: aaload
    //   154: astore 8
    //   156: aload 7
    //   158: astore 5
    //   160: aload 9
    //   162: iconst_1
    //   163: aaload
    //   164: invokestatic 478	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   167: istore_1
    //   168: aload 7
    //   170: astore 5
    //   172: aload 8
    //   174: invokestatic 319	com/xiaomi/push/i:a	(Ljava/lang/String;)I
    //   177: istore_2
    //   178: aload 6
    //   180: astore_0
    //   181: iload_2
    //   182: iload_1
    //   183: if_icmpne +6 -> 189
    //   186: aload 8
    //   188: astore_0
    //   189: aload_0
    //   190: astore 5
    //   192: aload_0
    //   193: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifeq +20 -> 216
    //   199: aload_0
    //   200: astore 5
    //   202: aload 10
    //   204: invokestatic 218	com/xiaomi/push/y:a	(Ljava/io/File;)V
    //   207: aload_0
    //   208: astore 5
    //   210: ldc_w 480
    //   213: invokestatic 172	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   216: goto +27 -> 243
    //   219: astore_0
    //   220: goto +121 -> 341
    //   223: astore 6
    //   225: aload 5
    //   227: astore_0
    //   228: goto +46 -> 274
    //   231: aload 9
    //   233: astore 5
    //   235: ldc_w 482
    //   238: invokestatic 172	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: astore 5
    //   246: aload 4
    //   248: ifnull +90 -> 338
    //   251: aload 4
    //   253: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   256: aload_0
    //   257: areturn
    //   258: astore_0
    //   259: aload 5
    //   261: astore 4
    //   263: goto +78 -> 341
    //   266: astore 6
    //   268: aconst_null
    //   269: astore_0
    //   270: aload 8
    //   272: astore 4
    //   274: aload 4
    //   276: astore 5
    //   278: new 123	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   285: astore 7
    //   287: aload 4
    //   289: astore 5
    //   291: aload 7
    //   293: ldc_w 484
    //   296: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 4
    //   302: astore 5
    //   304: aload 7
    //   306: aload 6
    //   308: invokevirtual 232	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 4
    //   317: astore 5
    //   319: aload 7
    //   321: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 234	com/xiaomi/channel/commonutils/logger/b:a	(Ljava/lang/String;)V
    //   327: aload_0
    //   328: astore 5
    //   330: aload 4
    //   332: ifnull +6 -> 338
    //   335: goto -84 -> 251
    //   338: aload 5
    //   340: areturn
    //   341: aload 4
    //   343: ifnull +8 -> 351
    //   346: aload 4
    //   348: invokevirtual 227	com/xiaomi/push/u:a	()V
    //   351: aload_0
    //   352: athrow
    //   353: astore_0
    //   354: aload 6
    //   356: astore_0
    //   357: goto -168 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	paramContext	Context
    //   167	17	1	i	int
    //   177	7	2	j	int
    //   4	17	3	bool	boolean
    //   9	338	4	localObject1	Object
    //   34	305	5	localObject2	Object
    //   18	161	6	localObject3	Object
    //   223	1	6	localIOException1	java.io.IOException
    //   266	89	6	localIOException2	java.io.IOException
    //   6	314	7	localStringBuilder	StringBuilder
    //   15	256	8	str	String
    //   12	220	9	arrayOfString	String[]
    //   58	145	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   100	107	219	finally
    //   114	122	219	finally
    //   126	136	219	finally
    //   143	150	219	finally
    //   160	168	219	finally
    //   172	178	219	finally
    //   192	199	219	finally
    //   202	207	219	finally
    //   210	216	219	finally
    //   100	107	223	java/io/IOException
    //   114	122	223	java/io/IOException
    //   126	136	223	java/io/IOException
    //   143	150	223	java/io/IOException
    //   160	168	223	java/io/IOException
    //   172	178	223	java/io/IOException
    //   192	199	223	java/io/IOException
    //   202	207	223	java/io/IOException
    //   210	216	223	java/io/IOException
    //   36	60	258	finally
    //   64	72	258	finally
    //   76	84	258	finally
    //   88	96	258	finally
    //   235	241	258	finally
    //   278	287	258	finally
    //   291	300	258	finally
    //   304	315	258	finally
    //   319	327	258	finally
    //   36	60	266	java/io/IOException
    //   64	72	266	java/io/IOException
    //   76	84	266	java/io/IOException
    //   88	96	266	java/io/IOException
    //   235	241	266	java/io/IOException
    //   160	168	353	java/lang/Exception
    //   172	178	353	java/lang/Exception
  }
  
  private static String p(Context paramContext)
  {
    int i = b();
    String str = g(paramContext);
    for (;;)
    {
      if ((TextUtils.isEmpty(str)) && (i > 0)) {}
      try
      {
        Thread.sleep(500L);
        str = g(paramContext);
        i -= 1;
        continue;
        return str;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */