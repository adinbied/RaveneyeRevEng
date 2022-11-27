package com.facebook.soloader;

import java.util.List;
import javax.annotation.Nullable;

public abstract class NativeLibrary
{
  private static final String TAG = NativeLibrary.class.getName();
  private boolean mLibrariesLoaded = false;
  @Nullable
  private List<String> mLibraryNames;
  @Nullable
  private volatile UnsatisfiedLinkError mLinkError = null;
  private Boolean mLoadLibraries = Boolean.valueOf(true);
  private final Object mLock = new Object();
  
  protected NativeLibrary(List<String> paramList)
  {
    this.mLibraryNames = paramList;
  }
  
  public void ensureLoaded()
    throws UnsatisfiedLinkError
  {
    if (loadLibraries()) {
      return;
    }
    throw this.mLinkError;
  }
  
  @Nullable
  public UnsatisfiedLinkError getError()
  {
    return this.mLinkError;
  }
  
  protected void initialNativeCheck()
    throws UnsatisfiedLinkError
  {}
  
  /* Error */
  @Nullable
  public boolean loadLibraries()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/facebook/soloader/NativeLibrary:mLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/facebook/soloader/NativeLibrary:mLoadLibraries	Ljava/lang/Boolean;
    //   11: invokevirtual 66	java/lang/Boolean:booleanValue	()Z
    //   14: ifne +12 -> 26
    //   17: aload_0
    //   18: getfield 45	com/facebook/soloader/NativeLibrary:mLibrariesLoaded	Z
    //   21: istore_1
    //   22: aload_2
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 49	com/facebook/soloader/NativeLibrary:mLibraryNames	Ljava/util/List;
    //   30: ifnull +38 -> 68
    //   33: aload_0
    //   34: getfield 49	com/facebook/soloader/NativeLibrary:mLibraryNames	Ljava/util/List;
    //   37: invokeinterface 72 1 0
    //   42: astore_3
    //   43: aload_3
    //   44: invokeinterface 77 1 0
    //   49: ifeq +19 -> 68
    //   52: aload_3
    //   53: invokeinterface 81 1 0
    //   58: checkcast 83	java/lang/String
    //   61: invokestatic 89	com/facebook/soloader/SoLoader:loadLibrary	(Ljava/lang/String;)Z
    //   64: pop
    //   65: goto -22 -> 43
    //   68: aload_0
    //   69: invokevirtual 91	com/facebook/soloader/NativeLibrary:initialNativeCheck	()V
    //   72: aload_0
    //   73: iconst_1
    //   74: putfield 45	com/facebook/soloader/NativeLibrary:mLibrariesLoaded	Z
    //   77: aload_0
    //   78: aconst_null
    //   79: putfield 49	com/facebook/soloader/NativeLibrary:mLibraryNames	Ljava/util/List;
    //   82: goto +65 -> 147
    //   85: astore_3
    //   86: getstatic 28	com/facebook/soloader/NativeLibrary:TAG	Ljava/lang/String;
    //   89: ldc 93
    //   91: aload_3
    //   92: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   95: pop
    //   96: aload_0
    //   97: new 54	java/lang/UnsatisfiedLinkError
    //   100: dup
    //   101: ldc 101
    //   103: invokespecial 104	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   106: putfield 47	com/facebook/soloader/NativeLibrary:mLinkError	Ljava/lang/UnsatisfiedLinkError;
    //   109: aload_0
    //   110: getfield 47	com/facebook/soloader/NativeLibrary:mLinkError	Ljava/lang/UnsatisfiedLinkError;
    //   113: aload_3
    //   114: invokevirtual 108	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   117: pop
    //   118: aload_0
    //   119: iconst_0
    //   120: putfield 45	com/facebook/soloader/NativeLibrary:mLibrariesLoaded	Z
    //   123: goto +24 -> 147
    //   126: astore_3
    //   127: getstatic 28	com/facebook/soloader/NativeLibrary:TAG	Ljava/lang/String;
    //   130: ldc 110
    //   132: aload_3
    //   133: invokestatic 99	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   136: pop
    //   137: aload_0
    //   138: aload_3
    //   139: putfield 47	com/facebook/soloader/NativeLibrary:mLinkError	Ljava/lang/UnsatisfiedLinkError;
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 45	com/facebook/soloader/NativeLibrary:mLibrariesLoaded	Z
    //   147: aload_0
    //   148: iconst_0
    //   149: invokestatic 41	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   152: putfield 43	com/facebook/soloader/NativeLibrary:mLoadLibraries	Ljava/lang/Boolean;
    //   155: aload_0
    //   156: getfield 45	com/facebook/soloader/NativeLibrary:mLibrariesLoaded	Z
    //   159: istore_1
    //   160: aload_2
    //   161: monitorexit
    //   162: iload_1
    //   163: ireturn
    //   164: astore_3
    //   165: aload_2
    //   166: monitorexit
    //   167: aload_3
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	NativeLibrary
    //   21	142	1	bool	boolean
    //   4	162	2	localObject1	Object
    //   42	11	3	localIterator	java.util.Iterator
    //   85	29	3	localThrowable	Throwable
    //   126	13	3	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   164	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	43	85	finally
    //   43	65	85	finally
    //   68	82	85	finally
    //   26	43	126	java/lang/UnsatisfiedLinkError
    //   43	65	126	java/lang/UnsatisfiedLinkError
    //   68	82	126	java/lang/UnsatisfiedLinkError
    //   7	24	164	finally
    //   86	123	164	finally
    //   127	147	164	finally
    //   147	162	164	finally
    //   165	167	164	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\NativeLibrary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */