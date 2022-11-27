package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class n
{
  public static final long a = ;
  private static n b;
  private Context c;
  private String d;
  private Map<Integer, Map<String, m>> e;
  private SharedPreferences f;
  
  private n(Context paramContext)
  {
    this.c = paramContext;
    this.e = new HashMap();
    this.d = a.b().d;
    this.f = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static n a()
  {
    try
    {
      n localn = b;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new n(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private <T extends List<?>> void a(int paramInt, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 38	com/tencent/bugly/proguard/n:c	Landroid/content/Context;
    //   13: ldc 53
    //   15: iconst_0
    //   16: invokevirtual 81	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   19: astore_3
    //   20: new 83	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: iload_1
    //   32: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: new 90	java/io/File
    //   39: dup
    //   40: aload_3
    //   41: aload 4
    //   43: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_3
    //   50: new 99	java/io/ObjectOutputStream
    //   53: dup
    //   54: new 101	java/io/FileOutputStream
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 107	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   65: astore 4
    //   67: aload 4
    //   69: astore_3
    //   70: aload 4
    //   72: aload_2
    //   73: invokevirtual 111	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   76: aload 4
    //   78: invokevirtual 114	java/io/ObjectOutputStream:close	()V
    //   81: goto +81 -> 162
    //   84: astore_3
    //   85: aload 4
    //   87: astore_2
    //   88: aload_3
    //   89: astore 4
    //   91: goto +13 -> 104
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_3
    //   97: goto +41 -> 138
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: astore_3
    //   106: aload 4
    //   108: invokevirtual 117	java/io/IOException:printStackTrace	()V
    //   111: aload_2
    //   112: astore_3
    //   113: ldc 119
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 124	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload_2
    //   124: ifnull +10 -> 134
    //   127: aload_2
    //   128: invokevirtual 114	java/io/ObjectOutputStream:close	()V
    //   131: goto +31 -> 162
    //   134: aload_0
    //   135: monitorexit
    //   136: return
    //   137: astore_2
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 114	java/io/ObjectOutputStream:close	()V
    //   146: aload_2
    //   147: athrow
    //   148: astore_2
    //   149: goto +16 -> 165
    //   152: ldc 126
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 128	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   161: pop
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: aload_0
    //   166: monitorexit
    //   167: aload_2
    //   168: athrow
    //   169: astore_2
    //   170: goto -18 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	n
    //   0	173	1	paramInt	int
    //   0	173	2	paramT	T
    //   19	51	3	localObject1	Object
    //   84	5	3	localIOException1	java.io.IOException
    //   96	47	3	?	T
    //   27	63	4	localObject2	Object
    //   100	7	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   70	76	84	java/io/IOException
    //   50	67	94	finally
    //   50	67	100	java/io/IOException
    //   70	76	137	finally
    //   106	111	137	finally
    //   113	123	137	finally
    //   9	50	148	finally
    //   76	81	148	finally
    //   127	131	148	finally
    //   142	146	148	finally
    //   146	148	148	finally
    //   152	162	148	finally
    //   9	50	169	java/lang/Exception
    //   76	81	169	java/lang/Exception
    //   127	131	169	java/lang/Exception
    //   142	146	169	java/lang/Exception
    //   146	148	169	java/lang/Exception
  }
  
  /* Error */
  private boolean b(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 72	com/tencent/bugly/proguard/n:c	(I)Ljava/util/List;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnonnull +7 -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: invokestatic 29	java/lang/System:currentTimeMillis	()J
    //   21: lstore_2
    //   22: new 137	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 138	java/util/ArrayList:<init>	()V
    //   29: astore 5
    //   31: new 137	java/util/ArrayList
    //   34: dup
    //   35: invokespecial 138	java/util/ArrayList:<init>	()V
    //   38: astore 6
    //   40: aload 4
    //   42: invokeinterface 144 1 0
    //   47: astore 7
    //   49: aload 7
    //   51: invokeinterface 150 1 0
    //   56: ifeq +83 -> 139
    //   59: aload 7
    //   61: invokeinterface 154 1 0
    //   66: checkcast 156	com/tencent/bugly/proguard/m
    //   69: astore 8
    //   71: aload 8
    //   73: getfield 158	com/tencent/bugly/proguard/m:b	Ljava/lang/String;
    //   76: ifnull +36 -> 112
    //   79: aload 8
    //   81: getfield 158	com/tencent/bugly/proguard/m:b	Ljava/lang/String;
    //   84: aload_0
    //   85: getfield 51	com/tencent/bugly/proguard/n:d	Ljava/lang/String;
    //   88: invokevirtual 164	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   91: ifeq +21 -> 112
    //   94: aload 8
    //   96: getfield 167	com/tencent/bugly/proguard/m:d	I
    //   99: ifle +13 -> 112
    //   102: aload 5
    //   104: aload 8
    //   106: invokeinterface 171 2 0
    //   111: pop
    //   112: aload 8
    //   114: getfield 173	com/tencent/bugly/proguard/m:c	J
    //   117: ldc2_w 174
    //   120: ladd
    //   121: lload_2
    //   122: lcmp
    //   123: ifge -74 -> 49
    //   126: aload 6
    //   128: aload 8
    //   130: invokeinterface 171 2 0
    //   135: pop
    //   136: goto -87 -> 49
    //   139: aload 5
    //   141: invokestatic 181	java/util/Collections:sort	(Ljava/util/List;)V
    //   144: aload 5
    //   146: invokeinterface 185 1 0
    //   151: iconst_2
    //   152: if_icmplt +66 -> 218
    //   155: aload 5
    //   157: invokeinterface 185 1 0
    //   162: ifle +52 -> 214
    //   165: aload 5
    //   167: aload 5
    //   169: invokeinterface 185 1 0
    //   174: iconst_1
    //   175: isub
    //   176: invokeinterface 189 2 0
    //   181: checkcast 156	com/tencent/bugly/proguard/m
    //   184: getfield 173	com/tencent/bugly/proguard/m:c	J
    //   187: ldc2_w 174
    //   190: ladd
    //   191: lload_2
    //   192: lcmp
    //   193: ifge +21 -> 214
    //   196: aload 4
    //   198: invokeinterface 192 1 0
    //   203: aload_0
    //   204: iload_1
    //   205: aload 4
    //   207: invokespecial 133	com/tencent/bugly/proguard/n:a	(ILjava/util/List;)V
    //   210: aload_0
    //   211: monitorexit
    //   212: iconst_0
    //   213: ireturn
    //   214: aload_0
    //   215: monitorexit
    //   216: iconst_1
    //   217: ireturn
    //   218: aload 4
    //   220: aload 6
    //   222: invokeinterface 196 2 0
    //   227: pop
    //   228: aload_0
    //   229: iload_1
    //   230: aload 4
    //   232: invokespecial 133	com/tencent/bugly/proguard/n:a	(ILjava/util/List;)V
    //   235: aload_0
    //   236: monitorexit
    //   237: iconst_0
    //   238: ireturn
    //   239: astore 4
    //   241: goto +17 -> 258
    //   244: ldc -58
    //   246: iconst_0
    //   247: anewarray 4	java/lang/Object
    //   250: invokestatic 128	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   253: pop
    //   254: aload_0
    //   255: monitorexit
    //   256: iconst_0
    //   257: ireturn
    //   258: aload_0
    //   259: monitorexit
    //   260: aload 4
    //   262: athrow
    //   263: astore 4
    //   265: goto -21 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	n
    //   0	268	1	paramInt	int
    //   21	171	2	l	long
    //   7	224	4	localList	List
    //   239	22	4	localObject	Object
    //   263	1	4	localException	Exception
    //   29	139	5	localArrayList1	ArrayList
    //   38	183	6	localArrayList2	ArrayList
    //   47	13	7	localIterator	Iterator
    //   69	60	8	localm	m
    // Exception table:
    //   from	to	target	type
    //   2	9	239	finally
    //   18	49	239	finally
    //   49	112	239	finally
    //   112	136	239	finally
    //   139	210	239	finally
    //   218	235	239	finally
    //   244	254	239	finally
    //   2	9	263	java/lang/Exception
    //   18	49	263	java/lang/Exception
    //   49	112	263	java/lang/Exception
    //   112	136	263	java/lang/Exception
    //   139	210	263	java/lang/Exception
    //   218	235	263	java/lang/Exception
  }
  
  /* Error */
  private <T extends List<?>> T c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/bugly/proguard/n:c	Landroid/content/Context;
    //   6: ldc 53
    //   8: iconst_0
    //   9: invokevirtual 81	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   12: astore_3
    //   13: new 83	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: iload_1
    //   25: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: new 90	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: aload 4
    //   36: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: invokevirtual 207	java/io/File:exists	()Z
    //   47: istore_2
    //   48: iload_2
    //   49: ifne +7 -> 56
    //   52: aload_0
    //   53: monitorexit
    //   54: aconst_null
    //   55: areturn
    //   56: new 209	java/io/ObjectInputStream
    //   59: dup
    //   60: new 211	java/io/FileInputStream
    //   63: dup
    //   64: aload_3
    //   65: invokespecial 212	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 215	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: aload 4
    //   75: astore_3
    //   76: aload 4
    //   78: invokevirtual 218	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   81: checkcast 140	java/util/List
    //   84: astore 5
    //   86: aload 4
    //   88: invokevirtual 219	java/io/ObjectInputStream:close	()V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 5
    //   95: areturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore 4
    //   100: goto +64 -> 164
    //   103: aconst_null
    //   104: astore 4
    //   106: aload 4
    //   108: astore_3
    //   109: ldc -35
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 124	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload 4
    //   121: ifnull +69 -> 190
    //   124: aload 4
    //   126: invokevirtual 219	java/io/ObjectInputStream:close	()V
    //   129: goto +61 -> 190
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: astore_3
    //   138: ldc 119
    //   140: iconst_0
    //   141: anewarray 4	java/lang/Object
    //   144: invokestatic 124	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   147: pop
    //   148: aload 4
    //   150: ifnull +40 -> 190
    //   153: goto -29 -> 124
    //   156: astore 5
    //   158: aload_3
    //   159: astore 4
    //   161: aload 5
    //   163: astore_3
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 219	java/io/ObjectInputStream:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_3
    //   177: goto +17 -> 194
    //   180: ldc -33
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 128	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: monitorexit
    //   192: aconst_null
    //   193: areturn
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_3
    //   197: athrow
    //   198: astore_3
    //   199: goto -19 -> 180
    //   202: astore_3
    //   203: goto -71 -> 132
    //   206: astore_3
    //   207: goto -104 -> 103
    //   210: astore_3
    //   211: goto -76 -> 135
    //   214: astore_3
    //   215: goto -109 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	n
    //   0	218	1	paramInt	int
    //   47	2	2	bool	boolean
    //   12	64	3	localObject1	Object
    //   96	1	3	localObject2	Object
    //   108	67	3	localObject3	Object
    //   176	21	3	localObject4	Object
    //   198	1	3	localException	Exception
    //   202	1	3	localIOException1	java.io.IOException
    //   206	1	3	localClassNotFoundException1	ClassNotFoundException
    //   210	1	3	localIOException2	java.io.IOException
    //   214	1	3	localClassNotFoundException2	ClassNotFoundException
    //   20	150	4	localObject5	Object
    //   84	10	5	localList	List
    //   156	6	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   56	73	96	finally
    //   76	86	156	finally
    //   109	119	156	finally
    //   138	148	156	finally
    //   2	48	176	finally
    //   86	91	176	finally
    //   124	129	176	finally
    //   169	174	176	finally
    //   174	176	176	finally
    //   180	190	176	finally
    //   2	48	198	java/lang/Exception
    //   86	91	198	java/lang/Exception
    //   124	129	198	java/lang/Exception
    //   169	174	198	java/lang/Exception
    //   174	176	198	java/lang/Exception
    //   56	73	202	java/io/IOException
    //   56	73	206	java/lang/ClassNotFoundException
    //   76	86	210	java/io/IOException
    //   76	86	214	java/lang/ClassNotFoundException
  }
  
  public final void a(int paramInt1, final int paramInt2)
  {
    w.a().a(new Runnable()
    {
      public final void run()
      {
        try
        {
          if (TextUtils.isEmpty(n.a(n.this))) {
            return;
          }
          Object localObject2 = n.a(n.this, this.a);
          Object localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          if (n.b(n.this).get(Integer.valueOf(this.a)) == null)
          {
            localObject2 = new HashMap();
            n.b(n.this).put(Integer.valueOf(this.a), localObject2);
          }
          if (((Map)n.b(n.this).get(Integer.valueOf(this.a))).get(n.a(n.this)) == null)
          {
            localObject2 = new m();
            ((m)localObject2).a = this.a;
            ((m)localObject2).g = n.a;
            ((m)localObject2).b = n.a(n.this);
            ((m)localObject2).f = a.b().j;
            ((m)localObject2).e = a.b().f;
            ((m)localObject2).c = System.currentTimeMillis();
            ((m)localObject2).d = paramInt2;
            ((Map)n.b(n.this).get(Integer.valueOf(this.a))).put(n.a(n.this), localObject2);
          }
          else
          {
            localObject2 = (m)((Map)n.b(n.this).get(Integer.valueOf(this.a))).get(n.a(n.this));
            ((m)localObject2).d = paramInt2;
          }
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)localObject1).iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            m localm = (m)localIterator.next();
            int j = i;
            if (localm.g == ((m)localObject2).g)
            {
              j = i;
              if (localm.b != null)
              {
                j = i;
                if (localm.b.equalsIgnoreCase(((m)localObject2).b))
                {
                  j = 1;
                  localm.d = ((m)localObject2).d;
                }
              }
            }
            if (((localm.e == null) || (localm.e.equalsIgnoreCase(((m)localObject2).e))) && ((localm.f == null) || (localm.f.equalsIgnoreCase(((m)localObject2).f))))
            {
              i = j;
              if (localm.d > 0) {}
            }
            else
            {
              localArrayList.add(localm);
              i = j;
            }
          }
          ((List)localObject1).removeAll(localArrayList);
          if (i == 0) {
            ((List)localObject1).add(localObject2);
          }
          n.a(n.this, this.a, (List)localObject1);
          return;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        x.e("saveCrashRecord failed", new Object[0]);
      }
    });
  }
  
  /* Error */
  public final boolean a(final int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_1
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: aload_0
    //   7: getfield 61	com/tencent/bugly/proguard/n:f	Landroid/content/SharedPreferences;
    //   10: astore 4
    //   12: iload_3
    //   13: istore_2
    //   14: new 83	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: iload_3
    //   24: istore_2
    //   25: aload 5
    //   27: iload_1
    //   28: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: iload_3
    //   33: istore_2
    //   34: aload 5
    //   36: ldc -18
    //   38: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: iload_3
    //   43: istore_2
    //   44: aload 5
    //   46: aload_0
    //   47: getfield 51	com/tencent/bugly/proguard/n:d	Ljava/lang/String;
    //   50: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: iload_3
    //   55: istore_2
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: iconst_1
    //   64: invokeinterface 247 3 0
    //   69: istore_3
    //   70: iload_3
    //   71: istore_2
    //   72: invokestatic 230	com/tencent/bugly/proguard/w:a	()Lcom/tencent/bugly/proguard/w;
    //   75: new 8	com/tencent/bugly/proguard/n$2
    //   78: dup
    //   79: aload_0
    //   80: iload_1
    //   81: invokespecial 250	com/tencent/bugly/proguard/n$2:<init>	(Lcom/tencent/bugly/proguard/n;I)V
    //   84: invokevirtual 236	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   87: pop
    //   88: aload_0
    //   89: monitorexit
    //   90: iload_3
    //   91: ireturn
    //   92: astore 4
    //   94: goto +17 -> 111
    //   97: ldc -4
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 128	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_0
    //   108: monitorexit
    //   109: iload_2
    //   110: ireturn
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 4
    //   115: athrow
    //   116: astore 4
    //   118: goto -21 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	n
    //   0	121	1	paramInt	int
    //   5	105	2	bool1	boolean
    //   3	88	3	bool2	boolean
    //   10	47	4	localSharedPreferences	SharedPreferences
    //   92	22	4	localObject	Object
    //   116	1	4	localException	Exception
    //   21	38	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	12	92	finally
    //   14	23	92	finally
    //   25	32	92	finally
    //   34	42	92	finally
    //   44	54	92	finally
    //   56	70	92	finally
    //   72	88	92	finally
    //   97	107	92	finally
    //   6	12	116	java/lang/Exception
    //   14	23	116	java/lang/Exception
    //   25	32	116	java/lang/Exception
    //   34	42	116	java/lang/Exception
    //   44	54	116	java/lang/Exception
    //   56	70	116	java/lang/Exception
    //   72	88	116	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */