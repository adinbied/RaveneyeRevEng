package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource
  extends DirectorySoSource
{
  private static final String DEPS_FILE_NAME = "dso_deps";
  private static final String LOCK_FILE_NAME = "dso_lock";
  private static final String MANIFEST_FILE_NAME = "dso_manifest";
  private static final byte MANIFEST_VERSION = 1;
  private static final byte STATE_CLEAN = 1;
  private static final byte STATE_DIRTY = 0;
  private static final String STATE_FILE_NAME = "dso_state";
  private static final String TAG = "fb-UnpackingSoSource";
  @Nullable
  private String[] mAbis;
  protected final Context mContext;
  @Nullable
  protected String mCorruptedLib;
  private final Map<String, Object> mLibsBeingLoaded = new HashMap();
  
  protected UnpackingSoSource(Context paramContext, File paramFile)
  {
    super(paramFile, 1);
    this.mContext = paramContext;
  }
  
  protected UnpackingSoSource(Context paramContext, String paramString)
  {
    super(getSoStorePath(paramContext, paramString), 1);
    this.mContext = paramContext;
  }
  
  private void deleteUnmentionedFiles(Dso[] paramArrayOfDso)
    throws IOException
  {
    String[] arrayOfString = this.soDirectory.list();
    if (arrayOfString != null)
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        Object localObject = arrayOfString[i];
        if ((!((String)localObject).equals("dso_state")) && (!((String)localObject).equals("dso_lock")) && (!((String)localObject).equals("dso_deps")) && (!((String)localObject).equals("dso_manifest")))
        {
          int k = 0;
          int j = 0;
          while ((k == 0) && (j < paramArrayOfDso.length))
          {
            if (paramArrayOfDso[j].name.equals(localObject)) {
              k = 1;
            }
            j += 1;
          }
          if (k == 0)
          {
            localObject = new File(this.soDirectory, (String)localObject);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("deleting unaccounted-for file ");
            localStringBuilder.append(localObject);
            Log.v("fb-UnpackingSoSource", localStringBuilder.toString());
            SysUtil.dumbDeleteRecursive((File)localObject);
          }
        }
        i += 1;
      }
      return;
    }
    paramArrayOfDso = new StringBuilder();
    paramArrayOfDso.append("unable to list directory ");
    paramArrayOfDso.append(this.soDirectory);
    throw new IOException(paramArrayOfDso.toString());
  }
  
  /* Error */
  private void extractDso(InputDso paramInputDso, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 106	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc -115
    //   13: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_1
    //   20: getfield 145	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   23: getfield 101	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   26: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 43
    //   32: aload 5
    //   34: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 148	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   45: iconst_1
    //   46: iconst_1
    //   47: invokevirtual 152	java/io/File:setWritable	(ZZ)Z
    //   50: ifeq +224 -> 274
    //   53: new 88	java/io/File
    //   56: dup
    //   57: aload_0
    //   58: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   61: aload_1
    //   62: getfield 145	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   65: getfield 101	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   68: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore 6
    //   73: new 154	java/io/RandomAccessFile
    //   76: dup
    //   77: aload 6
    //   79: ldc -100
    //   81: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: astore 5
    //   86: goto +69 -> 155
    //   89: astore 5
    //   91: new 106	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   98: astore 7
    //   100: aload 7
    //   102: ldc -97
    //   104: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 7
    //   110: aload 6
    //   112: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 7
    //   118: ldc -95
    //   120: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: ldc 43
    //   126: aload 7
    //   128: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aload 5
    //   133: invokestatic 165	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   136: pop
    //   137: aload 6
    //   139: invokestatic 132	com/facebook/soloader/SysUtil:dumbDeleteRecursive	(Ljava/io/File;)V
    //   142: new 154	java/io/RandomAccessFile
    //   145: dup
    //   146: aload 6
    //   148: ldc -100
    //   150: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   153: astore 5
    //   155: aload_1
    //   156: getfield 169	com/facebook/soloader/UnpackingSoSource$InputDso:content	Ljava/io/InputStream;
    //   159: invokevirtual 175	java/io/InputStream:available	()I
    //   162: istore_3
    //   163: iload_3
    //   164: iconst_1
    //   165: if_icmple +13 -> 178
    //   168: aload 5
    //   170: invokevirtual 179	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   173: iload_3
    //   174: i2l
    //   175: invokestatic 183	com/facebook/soloader/SysUtil:fallocateIfSupported	(Ljava/io/FileDescriptor;J)V
    //   178: aload 5
    //   180: aload_1
    //   181: getfield 169	com/facebook/soloader/UnpackingSoSource$InputDso:content	Ljava/io/InputStream;
    //   184: ldc -72
    //   186: aload_2
    //   187: invokestatic 188	com/facebook/soloader/SysUtil:copyBytes	(Ljava/io/RandomAccessFile;Ljava/io/InputStream;I[B)I
    //   190: pop
    //   191: aload 5
    //   193: aload 5
    //   195: invokevirtual 192	java/io/RandomAccessFile:getFilePointer	()J
    //   198: invokevirtual 196	java/io/RandomAccessFile:setLength	(J)V
    //   201: aload 6
    //   203: iconst_1
    //   204: iconst_0
    //   205: invokevirtual 199	java/io/File:setExecutable	(ZZ)Z
    //   208: istore 4
    //   210: iload 4
    //   212: ifeq +9 -> 221
    //   215: aload 5
    //   217: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   220: return
    //   221: new 106	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   228: astore_1
    //   229: aload_1
    //   230: ldc -52
    //   232: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: aload 6
    //   239: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: new 76	java/io/IOException
    //   246: dup
    //   247: aload_1
    //   248: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   254: athrow
    //   255: astore_1
    //   256: goto +11 -> 267
    //   259: astore_1
    //   260: aload 6
    //   262: invokestatic 132	com/facebook/soloader/SysUtil:dumbDeleteRecursive	(Ljava/io/File;)V
    //   265: aload_1
    //   266: athrow
    //   267: aload 5
    //   269: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: new 106	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc -50
    //   285: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: aload_0
    //   291: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   294: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: new 76	java/io/IOException
    //   301: dup
    //   302: aload_1
    //   303: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   309: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	UnpackingSoSource
    //   0	310	1	paramInputDso	InputDso
    //   0	310	2	paramArrayOfByte	byte[]
    //   162	12	3	i	int
    //   208	3	4	bool	boolean
    //   7	78	5	localObject	Object
    //   89	43	5	localIOException	IOException
    //   153	115	5	localRandomAccessFile	java.io.RandomAccessFile
    //   71	190	6	localFile	File
    //   98	29	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	86	89	java/io/IOException
    //   155	163	255	finally
    //   168	178	255	finally
    //   178	210	255	finally
    //   221	255	255	finally
    //   260	267	255	finally
    //   155	163	259	java/io/IOException
    //   168	178	259	java/io/IOException
    //   178	210	259	java/io/IOException
    //   221	255	259	java/io/IOException
  }
  
  private Object getLibraryLock(String paramString)
  {
    synchronized (this.mLibsBeingLoaded)
    {
      Object localObject2 = this.mLibsBeingLoaded.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new Object();
        this.mLibsBeingLoaded.put(paramString, localObject1);
      }
      return localObject1;
    }
  }
  
  public static File getSoStorePath(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getApplicationInfo().dataDir);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString);
    return new File(localStringBuilder.toString());
  }
  
  /* Error */
  private boolean refreshLocked(final FileLocker paramFileLocker, int paramInt, final byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: new 88	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   8: ldc 40
    //   10: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   13: astore 10
    //   15: new 154	java/io/RandomAccessFile
    //   18: dup
    //   19: aload 10
    //   21: ldc -100
    //   23: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: invokevirtual 243	java/io/RandomAccessFile:readByte	()B
    //   33: istore 5
    //   35: iload 5
    //   37: istore 4
    //   39: iload 5
    //   41: iconst_1
    //   42: if_icmpeq +77 -> 119
    //   45: new 106	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   52: astore 8
    //   54: aload 8
    //   56: ldc -11
    //   58: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 8
    //   64: aload_0
    //   65: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   68: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: ldc -9
    //   76: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 43
    //   82: aload 8
    //   84: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: iconst_0
    //   92: istore 4
    //   94: goto +25 -> 119
    //   97: astore_1
    //   98: aload_1
    //   99: athrow
    //   100: astore_3
    //   101: aload 7
    //   103: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   106: goto +11 -> 117
    //   109: astore 7
    //   111: aload_1
    //   112: aload 7
    //   114: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   117: aload_3
    //   118: athrow
    //   119: aload 7
    //   121: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   124: new 88	java/io/File
    //   127: dup
    //   128: aload_0
    //   129: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   132: ldc 25
    //   134: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   137: astore 12
    //   139: aconst_null
    //   140: astore 7
    //   142: new 154	java/io/RandomAccessFile
    //   145: dup
    //   146: aload 12
    //   148: ldc -100
    //   150: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   153: astore 9
    //   155: aload 9
    //   157: invokevirtual 256	java/io/RandomAccessFile:length	()J
    //   160: l2i
    //   161: istore 6
    //   163: iload 6
    //   165: newarray <illegal type>
    //   167: astore 8
    //   169: aload 9
    //   171: aload 8
    //   173: invokevirtual 260	java/io/RandomAccessFile:read	([B)I
    //   176: iload 6
    //   178: if_icmpeq +15 -> 193
    //   181: ldc 43
    //   183: ldc_w 262
    //   186: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   189: pop
    //   190: iconst_0
    //   191: istore 4
    //   193: aload 8
    //   195: aload_3
    //   196: invokestatic 267	java/util/Arrays:equals	([B[B)Z
    //   199: ifne +263 -> 462
    //   202: ldc 43
    //   204: ldc_w 269
    //   207: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: iconst_0
    //   212: istore 4
    //   214: goto +248 -> 462
    //   217: ldc 43
    //   219: ldc_w 271
    //   222: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   225: pop
    //   226: aload 10
    //   228: iconst_0
    //   229: invokestatic 79	com/facebook/soloader/UnpackingSoSource:writeState	(Ljava/io/File;B)V
    //   232: aload_0
    //   233: invokevirtual 275	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   236: astore 11
    //   238: aload 11
    //   240: invokevirtual 279	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   243: astore 8
    //   245: aload 11
    //   247: invokevirtual 283	com/facebook/soloader/UnpackingSoSource$Unpacker:openDsoIterator	()Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;
    //   250: astore 7
    //   252: aload_0
    //   253: iload 4
    //   255: aload 8
    //   257: aload 7
    //   259: invokespecial 287	com/facebook/soloader/UnpackingSoSource:regenerate	(BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Lcom/facebook/soloader/UnpackingSoSource$InputDsoIterator;)V
    //   262: aload 7
    //   264: ifnull +8 -> 272
    //   267: aload 7
    //   269: invokevirtual 288	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   272: aload 8
    //   274: astore 7
    //   276: aload 11
    //   278: ifnull +198 -> 476
    //   281: aload 11
    //   283: invokevirtual 289	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   286: aload 8
    //   288: astore 7
    //   290: goto +186 -> 476
    //   293: aload 9
    //   295: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   298: aload 7
    //   300: ifnonnull +5 -> 305
    //   303: iconst_0
    //   304: ireturn
    //   305: new 6	com/facebook/soloader/UnpackingSoSource$1
    //   308: dup
    //   309: aload_0
    //   310: aload 12
    //   312: aload_3
    //   313: aload 7
    //   315: aload 10
    //   317: aload_1
    //   318: invokespecial 292	com/facebook/soloader/UnpackingSoSource$1:<init>	(Lcom/facebook/soloader/UnpackingSoSource;Ljava/io/File;[BLcom/facebook/soloader/UnpackingSoSource$DsoManifest;Ljava/io/File;Lcom/facebook/soloader/FileLocker;)V
    //   321: astore_1
    //   322: iload_2
    //   323: iconst_1
    //   324: iand
    //   325: ifeq +48 -> 373
    //   328: new 106	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   335: astore_3
    //   336: aload_3
    //   337: ldc_w 294
    //   340: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_3
    //   345: aload_0
    //   346: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   349: invokevirtual 297	java/io/File:getName	()Ljava/lang/String;
    //   352: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: new 299	java/lang/Thread
    //   359: dup
    //   360: aload_1
    //   361: aload_3
    //   362: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokespecial 302	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   368: invokevirtual 305	java/lang/Thread:start	()V
    //   371: iconst_1
    //   372: ireturn
    //   373: aload_1
    //   374: invokeinterface 310 1 0
    //   379: iconst_1
    //   380: ireturn
    //   381: astore_1
    //   382: aload_1
    //   383: athrow
    //   384: astore_3
    //   385: aload 7
    //   387: ifnull +19 -> 406
    //   390: aload 7
    //   392: invokevirtual 288	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:close	()V
    //   395: goto +11 -> 406
    //   398: astore 7
    //   400: aload_1
    //   401: aload 7
    //   403: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   406: aload_3
    //   407: athrow
    //   408: astore_1
    //   409: aload_1
    //   410: athrow
    //   411: astore_3
    //   412: aload 11
    //   414: ifnull +19 -> 433
    //   417: aload 11
    //   419: invokevirtual 289	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   422: goto +11 -> 433
    //   425: astore 7
    //   427: aload_1
    //   428: aload 7
    //   430: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   433: aload_3
    //   434: athrow
    //   435: astore_1
    //   436: aload_1
    //   437: athrow
    //   438: astore_3
    //   439: aload 9
    //   441: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   444: goto +11 -> 455
    //   447: astore 7
    //   449: aload_1
    //   450: aload 7
    //   452: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   455: aload_3
    //   456: athrow
    //   457: astore 8
    //   459: goto -368 -> 91
    //   462: iload 4
    //   464: ifeq -247 -> 217
    //   467: iload_2
    //   468: iconst_2
    //   469: iand
    //   470: ifeq +6 -> 476
    //   473: goto -256 -> 217
    //   476: goto -183 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	UnpackingSoSource
    //   0	479	1	paramFileLocker	FileLocker
    //   0	479	2	paramInt	int
    //   0	479	3	paramArrayOfByte	byte[]
    //   37	426	4	b1	byte
    //   33	10	5	b2	byte
    //   161	18	6	i	int
    //   26	76	7	localRandomAccessFile1	java.io.RandomAccessFile
    //   109	11	7	localThrowable1	Throwable
    //   140	251	7	localObject1	Object
    //   398	4	7	localThrowable2	Throwable
    //   425	4	7	localThrowable3	Throwable
    //   447	4	7	localThrowable4	Throwable
    //   52	235	8	localObject2	Object
    //   457	1	8	localEOFException	java.io.EOFException
    //   153	287	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   13	303	10	localFile1	File
    //   236	182	11	localUnpacker	Unpacker
    //   137	174	12	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   28	35	97	finally
    //   45	91	97	finally
    //   98	100	100	finally
    //   101	106	109	finally
    //   252	262	381	finally
    //   382	384	384	finally
    //   390	395	398	finally
    //   238	252	408	finally
    //   267	272	408	finally
    //   400	406	408	finally
    //   406	408	408	finally
    //   409	411	411	finally
    //   417	422	425	finally
    //   155	169	435	finally
    //   169	190	435	finally
    //   193	211	435	finally
    //   217	238	435	finally
    //   281	286	435	finally
    //   427	433	435	finally
    //   433	435	435	finally
    //   436	438	438	finally
    //   439	444	447	finally
    //   28	35	457	java/io/EOFException
    //   45	91	457	java/io/EOFException
  }
  
  /* Error */
  private void regenerate(byte paramByte, DsoManifest paramDsoManifest, InputDsoIterator paramInputDsoIterator)
    throws IOException
  {
    // Byte code:
    //   0: new 106	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 314
    //   14: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_0
    //   21: invokevirtual 318	java/lang/Object:getClass	()Ljava/lang/Class;
    //   24: invokevirtual 321	java/lang/Class:getName	()Ljava/lang/String;
    //   27: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 43
    //   33: aload 6
    //   35: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   41: pop
    //   42: new 154	java/io/RandomAccessFile
    //   45: dup
    //   46: new 88	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: getfield 86	com/facebook/soloader/UnpackingSoSource:soDirectory	Ljava/io/File;
    //   54: ldc 31
    //   56: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   59: ldc -100
    //   61: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore 8
    //   66: iload_1
    //   67: iconst_1
    //   68: if_icmpne +277 -> 345
    //   71: aload 8
    //   73: invokestatic 324	com/facebook/soloader/UnpackingSoSource$DsoManifest:read	(Ljava/io/DataInput;)Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   76: astore 6
    //   78: goto +23 -> 101
    //   81: astore_2
    //   82: goto +242 -> 324
    //   85: astore 6
    //   87: ldc 43
    //   89: ldc_w 326
    //   92: aload 6
    //   94: invokestatic 328	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   97: pop
    //   98: goto +247 -> 345
    //   101: aload 6
    //   103: astore 7
    //   105: aload 6
    //   107: ifnonnull +16 -> 123
    //   110: new 11	com/facebook/soloader/UnpackingSoSource$DsoManifest
    //   113: dup
    //   114: iconst_0
    //   115: anewarray 8	com/facebook/soloader/UnpackingSoSource$Dso
    //   118: invokespecial 330	com/facebook/soloader/UnpackingSoSource$DsoManifest:<init>	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   121: astore 7
    //   123: aload_0
    //   124: aload_2
    //   125: getfield 334	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   128: invokespecial 336	com/facebook/soloader/UnpackingSoSource:deleteUnmentionedFiles	([Lcom/facebook/soloader/UnpackingSoSource$Dso;)V
    //   131: ldc_w 337
    //   134: newarray <illegal type>
    //   136: astore 6
    //   138: aload_3
    //   139: invokevirtual 341	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:hasNext	()Z
    //   142: ifeq +138 -> 280
    //   145: aload_3
    //   146: invokevirtual 345	com/facebook/soloader/UnpackingSoSource$InputDsoIterator:next	()Lcom/facebook/soloader/UnpackingSoSource$InputDso;
    //   149: astore_2
    //   150: iconst_1
    //   151: istore 4
    //   153: iconst_0
    //   154: istore_1
    //   155: iload 4
    //   157: ifeq +73 -> 230
    //   160: iload_1
    //   161: aload 7
    //   163: getfield 334	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   166: arraylength
    //   167: if_icmpge +63 -> 230
    //   170: iload 4
    //   172: istore 5
    //   174: aload 7
    //   176: getfield 334	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   179: iload_1
    //   180: aaload
    //   181: getfield 101	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   184: aload_2
    //   185: getfield 145	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   188: getfield 101	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   191: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   194: ifeq +157 -> 351
    //   197: iload 4
    //   199: istore 5
    //   201: aload 7
    //   203: getfield 334	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   206: iload_1
    //   207: aaload
    //   208: getfield 348	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   211: aload_2
    //   212: getfield 145	com/facebook/soloader/UnpackingSoSource$InputDso:dso	Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   215: getfield 348	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   218: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifeq +130 -> 351
    //   224: iconst_0
    //   225: istore 5
    //   227: goto +124 -> 351
    //   230: iload 4
    //   232: ifeq +37 -> 269
    //   235: aload_0
    //   236: aload_2
    //   237: aload 6
    //   239: invokespecial 350	com/facebook/soloader/UnpackingSoSource:extractDso	(Lcom/facebook/soloader/UnpackingSoSource$InputDso;[B)V
    //   242: goto +27 -> 269
    //   245: aload 6
    //   247: athrow
    //   248: astore_3
    //   249: aload_2
    //   250: ifnull +17 -> 267
    //   253: aload_2
    //   254: invokevirtual 351	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   257: goto +10 -> 267
    //   260: astore_2
    //   261: aload 6
    //   263: aload_2
    //   264: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   267: aload_3
    //   268: athrow
    //   269: aload_2
    //   270: ifnull -132 -> 138
    //   273: aload_2
    //   274: invokevirtual 351	com/facebook/soloader/UnpackingSoSource$InputDso:close	()V
    //   277: goto -139 -> 138
    //   280: aload 8
    //   282: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   285: new 106	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   292: astore_2
    //   293: aload_2
    //   294: ldc_w 353
    //   297: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: aload_0
    //   303: invokevirtual 318	java/lang/Object:getClass	()Ljava/lang/Class;
    //   306: invokevirtual 321	java/lang/Class:getName	()Ljava/lang/String;
    //   309: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 43
    //   315: aload_2
    //   316: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 126	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   322: pop
    //   323: return
    //   324: aload_2
    //   325: athrow
    //   326: astore_3
    //   327: aload 8
    //   329: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   332: goto +11 -> 343
    //   335: astore 6
    //   337: aload_2
    //   338: aload 6
    //   340: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   343: aload_3
    //   344: athrow
    //   345: aconst_null
    //   346: astore 6
    //   348: goto -247 -> 101
    //   351: iload_1
    //   352: iconst_1
    //   353: iadd
    //   354: istore_1
    //   355: iload 5
    //   357: istore 4
    //   359: goto -204 -> 155
    //   362: astore 6
    //   364: goto -119 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	UnpackingSoSource
    //   0	367	1	paramByte	byte
    //   0	367	2	paramDsoManifest	DsoManifest
    //   0	367	3	paramInputDsoIterator	InputDsoIterator
    //   151	207	4	i	int
    //   172	184	5	j	int
    //   7	70	6	localObject1	Object
    //   85	21	6	localException	Exception
    //   136	126	6	arrayOfByte	byte[]
    //   335	4	6	localThrowable	Throwable
    //   346	1	6	localObject2	Object
    //   362	1	6	localObject3	Object
    //   103	99	7	localObject4	Object
    //   64	264	8	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   71	78	81	finally
    //   87	98	81	finally
    //   110	123	81	finally
    //   123	138	81	finally
    //   138	150	81	finally
    //   261	267	81	finally
    //   267	269	81	finally
    //   273	277	81	finally
    //   71	78	85	java/lang/Exception
    //   245	248	248	finally
    //   253	257	260	finally
    //   324	326	326	finally
    //   327	332	335	finally
    //   160	170	362	finally
    //   174	197	362	finally
    //   201	224	362	finally
    //   235	242	362	finally
  }
  
  /* Error */
  private static void writeState(File paramFile, byte paramByte)
    throws IOException
  {
    // Byte code:
    //   0: new 154	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc -100
    //   7: invokespecial 157	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: lconst_0
    //   13: invokevirtual 356	java/io/RandomAccessFile:seek	(J)V
    //   16: aload_3
    //   17: iload_1
    //   18: invokevirtual 360	java/io/RandomAccessFile:write	(I)V
    //   21: aload_3
    //   22: aload_3
    //   23: invokevirtual 192	java/io/RandomAccessFile:getFilePointer	()J
    //   26: invokevirtual 196	java/io/RandomAccessFile:setLength	(J)V
    //   29: aload_3
    //   30: invokevirtual 179	java/io/RandomAccessFile:getFD	()Ljava/io/FileDescriptor;
    //   33: invokevirtual 365	java/io/FileDescriptor:sync	()V
    //   36: aload_3
    //   37: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   40: return
    //   41: astore_0
    //   42: aload_0
    //   43: athrow
    //   44: astore_2
    //   45: aload_3
    //   46: invokevirtual 202	java/io/RandomAccessFile:close	()V
    //   49: goto +9 -> 58
    //   52: astore_3
    //   53: aload_0
    //   54: aload_3
    //   55: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramFile	File
    //   0	60	1	paramByte	byte
    //   44	15	2	localObject	Object
    //   10	36	3	localRandomAccessFile	java.io.RandomAccessFile
    //   52	3	3	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	36	41	finally
    //   42	44	44	finally
    //   45	49	52	finally
  }
  
  /* Error */
  protected byte[] getDepsBlock()
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 373	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_0
    //   5: invokevirtual 275	com/facebook/soloader/UnpackingSoSource:makeUnpacker	()Lcom/facebook/soloader/UnpackingSoSource$Unpacker;
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 279	com/facebook/soloader/UnpackingSoSource$Unpacker:getDsoManifest	()Lcom/facebook/soloader/UnpackingSoSource$DsoManifest;
    //   13: getfield 334	com/facebook/soloader/UnpackingSoSource$DsoManifest:dsos	[Lcom/facebook/soloader/UnpackingSoSource$Dso;
    //   16: astore 4
    //   18: aload_3
    //   19: iconst_1
    //   20: invokevirtual 377	android/os/Parcel:writeByte	(B)V
    //   23: aload_3
    //   24: aload 4
    //   26: arraylength
    //   27: invokevirtual 380	android/os/Parcel:writeInt	(I)V
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: aload 4
    //   35: arraylength
    //   36: if_icmpge +32 -> 68
    //   39: aload_3
    //   40: aload 4
    //   42: iload_1
    //   43: aaload
    //   44: getfield 101	com/facebook/soloader/UnpackingSoSource$Dso:name	Ljava/lang/String;
    //   47: invokevirtual 383	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   50: aload_3
    //   51: aload 4
    //   53: iload_1
    //   54: aaload
    //   55: getfield 348	com/facebook/soloader/UnpackingSoSource$Dso:hash	Ljava/lang/String;
    //   58: invokevirtual 383	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   61: iload_1
    //   62: iconst_1
    //   63: iadd
    //   64: istore_1
    //   65: goto -33 -> 32
    //   68: aload_2
    //   69: ifnull +7 -> 76
    //   72: aload_2
    //   73: invokevirtual 289	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   76: aload_3
    //   77: invokevirtual 386	android/os/Parcel:marshall	()[B
    //   80: astore_2
    //   81: aload_3
    //   82: invokevirtual 389	android/os/Parcel:recycle	()V
    //   85: aload_2
    //   86: areturn
    //   87: astore_3
    //   88: aload_3
    //   89: athrow
    //   90: astore 4
    //   92: aload_2
    //   93: ifnull +16 -> 109
    //   96: aload_2
    //   97: invokevirtual 289	com/facebook/soloader/UnpackingSoSource$Unpacker:close	()V
    //   100: goto +9 -> 109
    //   103: astore_2
    //   104: aload_3
    //   105: aload_2
    //   106: invokevirtual 253	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   109: aload 4
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	UnpackingSoSource
    //   31	34	1	i	int
    //   8	89	2	localObject1	Object
    //   103	3	2	localThrowable	Throwable
    //   3	79	3	localParcel	android.os.Parcel
    //   87	18	3	localObject2	Object
    //   16	36	4	arrayOfDso	Dso[]
    //   90	20	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   9	30	87	finally
    //   32	61	87	finally
    //   88	90	90	finally
    //   96	100	103	finally
  }
  
  public String[] getSoSourceAbis()
  {
    String[] arrayOfString2 = this.mAbis;
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = super.getSoSourceAbis();
    }
    return arrayOfString1;
  }
  
  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    synchronized (getLibraryLock(paramString))
    {
      paramInt = loadLibraryFrom(paramString, paramInt, this.soDirectory, paramThreadPolicy);
      return paramInt;
    }
  }
  
  protected abstract Unpacker makeUnpacker()
    throws IOException;
  
  protected void prepare(int paramInt)
    throws IOException
  {
    SysUtil.mkdirOrThrow(this.soDirectory);
    Object localObject1 = FileLocker.lock(new File(this.soDirectory, "dso_lock"));
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("locked dso store ");
      localStringBuilder1.append(this.soDirectory);
      Log.v("fb-UnpackingSoSource", localStringBuilder1.toString());
      if (refreshLocked((FileLocker)localObject1, paramInt, getDepsBlock()))
      {
        localObject1 = null;
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("dso store is up-to-date: ");
        localStringBuilder1.append(this.soDirectory);
        Log.i("fb-UnpackingSoSource", localStringBuilder1.toString());
      }
      if (localObject1 != null)
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("releasing dso store lock for ");
        localStringBuilder1.append(this.soDirectory);
        Log.v("fb-UnpackingSoSource", localStringBuilder1.toString());
        ((FileLocker)localObject1).close();
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("not releasing dso store lock for ");
      ((StringBuilder)localObject1).append(this.soDirectory);
      ((StringBuilder)localObject1).append(" (syncer thread started)");
      Log.v("fb-UnpackingSoSource", ((StringBuilder)localObject1).toString());
      return;
    }
    finally
    {
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("releasing dso store lock for ");
        localStringBuilder2.append(this.soDirectory);
        Log.v("fb-UnpackingSoSource", localStringBuilder2.toString());
        ((FileLocker)localObject1).close();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("not releasing dso store lock for ");
        ((StringBuilder)localObject1).append(this.soDirectory);
        ((StringBuilder)localObject1).append(" (syncer thread started)");
        Log.v("fb-UnpackingSoSource", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  /* Error */
  protected void prepare(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 398	com/facebook/soloader/UnpackingSoSource:getLibraryLock	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 429	com/facebook/soloader/UnpackingSoSource:mCorruptedLib	Ljava/lang/String;
    //   15: aload_0
    //   16: iconst_2
    //   17: invokevirtual 431	com/facebook/soloader/UnpackingSoSource:prepare	(I)V
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	UnpackingSoSource
    //   0	35	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   10	22	25	finally
    //   26	28	25	finally
    //   2	10	30	finally
    //   28	30	30	finally
  }
  
  public void setSoSourceAbis(String[] paramArrayOfString)
  {
    this.mAbis = paramArrayOfString;
  }
  
  public static class Dso
  {
    public final String hash;
    public final String name;
    
    public Dso(String paramString1, String paramString2)
    {
      this.name = paramString1;
      this.hash = paramString2;
    }
  }
  
  public static final class DsoManifest
  {
    public final UnpackingSoSource.Dso[] dsos;
    
    public DsoManifest(UnpackingSoSource.Dso[] paramArrayOfDso)
    {
      this.dsos = paramArrayOfDso;
    }
    
    static final DsoManifest read(DataInput paramDataInput)
      throws IOException
    {
      if (paramDataInput.readByte() == 1)
      {
        int j = paramDataInput.readInt();
        if (j >= 0)
        {
          UnpackingSoSource.Dso[] arrayOfDso = new UnpackingSoSource.Dso[j];
          int i = 0;
          while (i < j)
          {
            arrayOfDso[i] = new UnpackingSoSource.Dso(paramDataInput.readUTF(), paramDataInput.readUTF());
            i += 1;
          }
          return new DsoManifest(arrayOfDso);
        }
        throw new RuntimeException("illegal number of shared libraries");
      }
      throw new RuntimeException("wrong dso manifest version");
    }
    
    public final void write(DataOutput paramDataOutput)
      throws IOException
    {
      paramDataOutput.writeByte(1);
      paramDataOutput.writeInt(this.dsos.length);
      int i = 0;
      for (;;)
      {
        UnpackingSoSource.Dso[] arrayOfDso = this.dsos;
        if (i >= arrayOfDso.length) {
          break;
        }
        paramDataOutput.writeUTF(arrayOfDso[i].name);
        paramDataOutput.writeUTF(this.dsos[i].hash);
        i += 1;
      }
    }
  }
  
  protected static final class InputDso
    implements Closeable
  {
    public final InputStream content;
    public final UnpackingSoSource.Dso dso;
    
    public InputDso(UnpackingSoSource.Dso paramDso, InputStream paramInputStream)
    {
      this.dso = paramDso;
      this.content = paramInputStream;
    }
    
    public void close()
      throws IOException
    {
      this.content.close();
    }
  }
  
  protected static abstract class InputDsoIterator
    implements Closeable
  {
    public void close()
      throws IOException
    {}
    
    public abstract boolean hasNext();
    
    public abstract UnpackingSoSource.InputDso next()
      throws IOException;
  }
  
  protected static abstract class Unpacker
    implements Closeable
  {
    public void close()
      throws IOException
    {}
    
    protected abstract UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException;
    
    protected abstract UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\UnpackingSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */