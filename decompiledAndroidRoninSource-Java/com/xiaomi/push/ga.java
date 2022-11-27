package com.xiaomi.push;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;

public final class ga
{
  private static int jdField_a_of_type_Int = 5000;
  private static Vector<String> jdField_a_of_type_JavaUtilVector = new Vector();
  private static int b = 330000;
  private static int c = 600000;
  private static int d = 330000;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: new 20	java/util/Vector
    //   3: dup
    //   4: invokespecial 23	java/util/Vector:<init>	()V
    //   7: putstatic 25	com/xiaomi/push/ga:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   10: invokestatic 28	com/xiaomi/push/ga:a	()[Ljava/lang/ClassLoader;
    //   13: astore 7
    //   15: aload 7
    //   17: arraylength
    //   18: istore_3
    //   19: iconst_0
    //   20: istore_0
    //   21: iload_0
    //   22: iload_3
    //   23: if_icmpge +373 -> 396
    //   26: aload 7
    //   28: iload_0
    //   29: aaload
    //   30: ldc 30
    //   32: invokevirtual 36	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   35: astore 8
    //   37: aload 8
    //   39: invokeinterface 42 1 0
    //   44: ifeq +338 -> 382
    //   47: aload 8
    //   49: invokeinterface 46 1 0
    //   54: checkcast 48	java/net/URL
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 4
    //   62: aconst_null
    //   63: astore 5
    //   65: aload 6
    //   67: invokevirtual 52	java/net/URL:openStream	()Ljava/io/InputStream;
    //   70: astore 6
    //   72: aload 6
    //   74: astore 5
    //   76: aload 6
    //   78: astore 4
    //   80: invokestatic 58	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   83: invokevirtual 62	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   86: astore 9
    //   88: aload 6
    //   90: astore 5
    //   92: aload 6
    //   94: astore 4
    //   96: aload 9
    //   98: ldc 64
    //   100: iconst_1
    //   101: invokeinterface 70 3 0
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: astore 4
    //   114: aload 9
    //   116: aload 6
    //   118: ldc 72
    //   120: invokeinterface 76 3 0
    //   125: aload 6
    //   127: astore 5
    //   129: aload 6
    //   131: astore 4
    //   133: aload 9
    //   135: invokeinterface 80 1 0
    //   140: istore_1
    //   141: iload_1
    //   142: iconst_2
    //   143: if_icmpne +177 -> 320
    //   146: aload 6
    //   148: astore 5
    //   150: aload 6
    //   152: astore 4
    //   154: aload 9
    //   156: invokeinterface 84 1 0
    //   161: ldc 86
    //   163: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   166: ifeq +19 -> 185
    //   169: aload 6
    //   171: astore 5
    //   173: aload 6
    //   175: astore 4
    //   177: aload 9
    //   179: invokestatic 95	com/xiaomi/push/ga:a	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   182: goto +138 -> 320
    //   185: aload 6
    //   187: astore 5
    //   189: aload 6
    //   191: astore 4
    //   193: aload 9
    //   195: invokeinterface 84 1 0
    //   200: ldc 97
    //   202: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +25 -> 230
    //   208: aload 6
    //   210: astore 5
    //   212: aload 6
    //   214: astore 4
    //   216: aload 9
    //   218: getstatic 99	com/xiaomi/push/ga:jdField_a_of_type_Int	I
    //   221: invokestatic 102	com/xiaomi/push/ga:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   224: putstatic 99	com/xiaomi/push/ga:jdField_a_of_type_Int	I
    //   227: goto +93 -> 320
    //   230: aload 6
    //   232: astore 5
    //   234: aload 6
    //   236: astore 4
    //   238: aload 9
    //   240: invokeinterface 84 1 0
    //   245: ldc 104
    //   247: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +25 -> 275
    //   253: aload 6
    //   255: astore 5
    //   257: aload 6
    //   259: astore 4
    //   261: aload 9
    //   263: getstatic 106	com/xiaomi/push/ga:b	I
    //   266: invokestatic 102	com/xiaomi/push/ga:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   269: putstatic 106	com/xiaomi/push/ga:b	I
    //   272: goto +48 -> 320
    //   275: aload 6
    //   277: astore 5
    //   279: aload 6
    //   281: astore 4
    //   283: aload 9
    //   285: invokeinterface 84 1 0
    //   290: ldc 108
    //   292: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +25 -> 320
    //   298: aload 6
    //   300: astore 5
    //   302: aload 6
    //   304: astore 4
    //   306: getstatic 25	com/xiaomi/push/ga:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   309: aload 9
    //   311: invokeinterface 111 1 0
    //   316: invokevirtual 114	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   319: pop
    //   320: aload 6
    //   322: astore 5
    //   324: aload 6
    //   326: astore 4
    //   328: aload 9
    //   330: invokeinterface 117 1 0
    //   335: istore_2
    //   336: iload_2
    //   337: istore_1
    //   338: iload_2
    //   339: iconst_1
    //   340: if_icmpne -199 -> 141
    //   343: aload 6
    //   345: astore 4
    //   347: aload 4
    //   349: invokevirtual 122	java/io/InputStream:close	()V
    //   352: goto -315 -> 37
    //   355: astore 4
    //   357: goto +17 -> 374
    //   360: astore 6
    //   362: aload 4
    //   364: astore 5
    //   366: aload 6
    //   368: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   371: goto -24 -> 347
    //   374: aload 5
    //   376: invokevirtual 122	java/io/InputStream:close	()V
    //   379: aload 4
    //   381: athrow
    //   382: iload_0
    //   383: iconst_1
    //   384: iadd
    //   385: istore_0
    //   386: goto -365 -> 21
    //   389: astore 4
    //   391: aload 4
    //   393: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   396: return
    //   397: astore 4
    //   399: goto -362 -> 37
    //   402: astore 5
    //   404: goto -25 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	366	0	i	int
    //   140	198	1	j	int
    //   335	6	2	k	int
    //   18	6	3	m	int
    //   60	288	4	localObject1	Object
    //   355	25	4	localObject2	Object
    //   389	3	4	localException1	Exception
    //   397	1	4	localException2	Exception
    //   63	312	5	localObject3	Object
    //   402	1	5	localException3	Exception
    //   57	287	6	localObject4	Object
    //   360	7	6	localException4	Exception
    //   13	14	7	arrayOfClassLoader	ClassLoader[]
    //   35	13	8	localEnumeration	java.util.Enumeration
    //   86	243	9	localXmlPullParser	XmlPullParser
    // Exception table:
    //   from	to	target	type
    //   65	72	355	finally
    //   80	88	355	finally
    //   96	106	355	finally
    //   114	125	355	finally
    //   133	141	355	finally
    //   154	169	355	finally
    //   177	182	355	finally
    //   193	208	355	finally
    //   216	227	355	finally
    //   238	253	355	finally
    //   261	272	355	finally
    //   283	298	355	finally
    //   306	320	355	finally
    //   328	336	355	finally
    //   366	371	355	finally
    //   65	72	360	java/lang/Exception
    //   80	88	360	java/lang/Exception
    //   96	106	360	java/lang/Exception
    //   114	125	360	java/lang/Exception
    //   133	141	360	java/lang/Exception
    //   154	169	360	java/lang/Exception
    //   177	182	360	java/lang/Exception
    //   193	208	360	java/lang/Exception
    //   216	227	360	java/lang/Exception
    //   238	253	360	java/lang/Exception
    //   261	272	360	java/lang/Exception
    //   283	298	360	java/lang/Exception
    //   306	320	360	java/lang/Exception
    //   328	336	360	java/lang/Exception
    //   10	19	389	java/lang/Exception
    //   26	37	389	java/lang/Exception
    //   37	59	389	java/lang/Exception
    //   379	382	389	java/lang/Exception
    //   347	352	397	java/lang/Exception
    //   374	379	402	java/lang/Exception
  }
  
  public static int a()
  {
    return b;
  }
  
  private static int a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramXmlPullParser.nextText());
      return i;
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      paramXmlPullParser.printStackTrace();
    }
    return paramInt;
  }
  
  public static String a()
  {
    return "3.1.0";
  }
  
  private static void a(XmlPullParser paramXmlPullParser)
  {
    paramXmlPullParser = paramXmlPullParser.nextText();
    try
    {
      Class.forName(paramXmlPullParser);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      PrintStream localPrintStream;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localPrintStream = System.err;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Error! A startup class specified in smack-config.xml could not be loaded: ");
    localStringBuilder.append(paramXmlPullParser);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  private static ClassLoader[] a()
  {
    ClassLoader localClassLoader1 = ga.class.getClassLoader();
    int i = 0;
    ClassLoader localClassLoader2 = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    while (i < 2)
    {
      ClassLoader localClassLoader3 = new ClassLoader[] { localClassLoader1, localClassLoader2 }[i];
      if (localClassLoader3 != null) {
        localArrayList.add(localClassLoader3);
      }
      i += 1;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
  
  public static int b()
  {
    return c;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */