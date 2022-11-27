package it.sauronsoftware.ftp4j.extrecognizers;

public class DefaultTextualExtensionRecognizer
  extends ParametricTextualExtensionRecognizer
{
  private static DefaultTextualExtensionRecognizer instance = null;
  private static final Object lock = new Object();
  
  /* Error */
  private DefaultTextualExtensionRecognizer()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 23	it/sauronsoftware/ftp4j/extrecognizers/ParametricTextualExtensionRecognizer:<init>	()V
    //   4: aconst_null
    //   5: astore_2
    //   6: new 25	java/io/BufferedReader
    //   9: dup
    //   10: new 27	java/io/InputStreamReader
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 31	java/lang/Object:getClass	()Ljava/lang/Class;
    //   18: ldc 33
    //   20: invokevirtual 39	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 42	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: invokespecial 45	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 49	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnull +30 -> 66
    //   39: new 51	java/util/StringTokenizer
    //   42: dup
    //   43: aload_2
    //   44: invokespecial 54	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 58	java/util/StringTokenizer:hasMoreTokens	()Z
    //   52: ifeq -22 -> 30
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 61	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   60: invokevirtual 64	it/sauronsoftware/ftp4j/extrecognizers/DefaultTextualExtensionRecognizer:addExtension	(Ljava/lang/String;)V
    //   63: goto -15 -> 48
    //   66: aload_1
    //   67: invokevirtual 67	java/io/BufferedReader:close	()V
    //   70: return
    //   71: astore_2
    //   72: goto +9 -> 81
    //   75: goto +16 -> 91
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 67	java/io/BufferedReader:close	()V
    //   89: aload_2
    //   90: athrow
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 67	java/io/BufferedReader:close	()V
    //   99: return
    //   100: astore_1
    //   101: aload_2
    //   102: astore_1
    //   103: goto -12 -> 91
    //   106: astore_2
    //   107: goto -32 -> 75
    //   110: astore_1
    //   111: return
    //   112: astore_1
    //   113: goto -24 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	DefaultTextualExtensionRecognizer
    //   29	67	1	localBufferedReader	java.io.BufferedReader
    //   100	1	1	localException1	Exception
    //   102	1	1	localObject1	Object
    //   110	1	1	localObject2	Object
    //   112	1	1	localObject3	Object
    //   5	52	2	localObject4	Object
    //   71	1	2	localObject5	Object
    //   78	24	2	localObject6	Object
    //   106	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   30	35	71	finally
    //   39	48	71	finally
    //   48	63	71	finally
    //   6	30	78	finally
    //   6	30	100	java/lang/Exception
    //   30	35	106	java/lang/Exception
    //   39	48	106	java/lang/Exception
    //   48	63	106	java/lang/Exception
    //   66	70	110	finally
    //   95	99	110	finally
    //   85	89	112	finally
  }
  
  public static DefaultTextualExtensionRecognizer getInstance()
  {
    synchronized (lock)
    {
      if (instance == null) {
        instance = new DefaultTextualExtensionRecognizer();
      }
      return instance;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\extrecognizers\DefaultTextualExtensionRecognizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */