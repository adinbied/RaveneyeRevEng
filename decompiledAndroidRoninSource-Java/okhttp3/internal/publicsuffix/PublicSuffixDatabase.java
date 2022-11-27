package okhttp3.internal.publicsuffix;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\022\n\002\b\002\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\002\b\004\n\002\020\002\n\002\b\004\030\000 \0242\0020\001:\001\024B\005¢\006\002\020\002J\034\020\n\032\b\022\004\022\0020\f0\0132\f\020\r\032\b\022\004\022\0020\f0\013H\002J\020\020\016\032\004\030\0010\f2\006\020\017\032\0020\fJ\b\020\020\032\0020\021H\002J\b\020\022\032\0020\021H\002J\026\020\023\032\0020\0212\006\020\007\032\0020\0062\006\020\005\032\0020\006R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X.¢\006\002\n\000R\016\020\007\032\0020\006X.¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006\025"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class PublicSuffixDatabase
{
  public static final Companion Companion = new Companion(null);
  private static final char EXCEPTION_MARKER = '!';
  private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
  public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
  private static final byte[] WILDCARD_LABEL = { (byte)42 };
  private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
  private final AtomicBoolean listRead = new AtomicBoolean(false);
  private byte[] publicSuffixExceptionListBytes;
  private byte[] publicSuffixListBytes;
  private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
  
  private final List<String> findMatchingRule(List<String> paramList)
  {
    if ((!this.listRead.get()) && (this.listRead.compareAndSet(false, true))) {
      readTheListUninterruptibly();
    }
    try
    {
      this.readCompleteLatch.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      int i;
      int j;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      byte[][] arrayOfByte;
      Object localObject4;
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    if (((PublicSuffixDatabase)this).publicSuffixListBytes != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      j = paramList.size();
      localObject1 = new byte[j][];
      i = 0;
      while (i < j)
      {
        localObject2 = (String)paramList.get(i);
        localObject3 = StandardCharsets.UTF_8;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "UTF_8");
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
          localObject1[i] = localObject2;
          i += 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      arrayOfByte = (byte[][])localObject1;
      paramList = (String)null;
      j = arrayOfByte.length;
      i = 0;
      while (i < j)
      {
        localObject1 = Companion;
        localObject2 = this.publicSuffixListBytes;
        if (localObject2 == null) {
          Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        }
        localObject1 = Companion.access$binarySearch((Companion)localObject1, (byte[])localObject2, arrayOfByte, i);
        if (localObject1 != null) {
          break label228;
        }
        i += 1;
      }
      localObject1 = paramList;
      label228:
      localObject4 = (Object[])arrayOfByte;
      if (localObject4.length > 1)
      {
        localObject3 = (byte[][])localObject4.clone();
        j = ((Object[])localObject3).length;
        i = 0;
        while (i < j - 1)
        {
          localObject3[i] = WILDCARD_LABEL;
          localObject2 = Companion;
          byte[] arrayOfByte1 = this.publicSuffixListBytes;
          if (arrayOfByte1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
          }
          localObject2 = Companion.access$binarySearch((Companion)localObject2, arrayOfByte1, (byte[][])localObject3, i);
          if (localObject2 != null) {
            break label326;
          }
          i += 1;
        }
      }
      localObject2 = paramList;
      label326:
      localObject3 = paramList;
      if (localObject2 != null)
      {
        j = localObject4.length;
        i = 0;
        for (;;)
        {
          localObject3 = paramList;
          if (i >= j - 1) {
            break;
          }
          localObject3 = Companion;
          localObject4 = this.publicSuffixExceptionListBytes;
          if (localObject4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
          }
          localObject3 = Companion.access$binarySearch((Companion)localObject3, (byte[])localObject4, arrayOfByte, i);
          if (localObject3 != null) {
            break;
          }
          i += 1;
        }
      }
      if (localObject3 != null)
      {
        paramList = new StringBuilder();
        paramList.append('!');
        paramList.append((String)localObject3);
        return StringsKt.split$default((CharSequence)paramList.toString(), new char[] { '.' }, false, 0, 6, null);
      }
      if ((localObject1 == null) && (localObject2 == null)) {
        return PREVAILING_RULE;
      }
      if (localObject1 != null)
      {
        paramList = StringsKt.split$default((CharSequence)localObject1, new char[] { '.' }, false, 0, 6, null);
        if (paramList != null) {}
      }
      else
      {
        paramList = CollectionsKt.emptyList();
      }
      if (localObject2 != null)
      {
        localObject1 = StringsKt.split$default((CharSequence)localObject2, new char[] { '.' }, false, 0, 6, null);
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = CollectionsKt.emptyList();
      }
      if (paramList.size() > ((List)localObject1).size()) {
        return paramList;
      }
      return (List<String>)localObject1;
    }
    throw ((Throwable)new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString()));
  }
  
  private final void readTheList()
    throws IOException
  {
    Object localObject1 = (byte[])null;
    localObject1 = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
    if (localObject1 != null)
    {
      localObject1 = (Closeable)Okio.buffer((Source)new GzipSource(Okio.source((InputStream)localObject1)));
      Throwable localThrowable1 = (Throwable)null;
      try
      {
        Object localObject3 = (BufferedSource)localObject1;
        byte[] arrayOfByte = ((BufferedSource)localObject3).readByteArray(((BufferedSource)localObject3).readInt());
        localObject3 = ((BufferedSource)localObject3).readByteArray(((BufferedSource)localObject3).readInt());
        Unit localUnit = Unit.INSTANCE;
        CloseableKt.closeFinally((Closeable)localObject1, localThrowable1);
        if (arrayOfByte == null) {}
        try
        {
          Intrinsics.throwNpe();
          this.publicSuffixListBytes = arrayOfByte;
          if (localObject3 == null) {
            Intrinsics.throwNpe();
          }
          this.publicSuffixExceptionListBytes = ((byte[])localObject3);
          localObject1 = Unit.INSTANCE;
          this.readCompleteLatch.countDown();
          return;
        }
        finally {}
        return;
      }
      finally {}
    }
  }
  
  /* Error */
  private final void readTheListUninterruptibly()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 273	okhttp3/internal/publicsuffix/PublicSuffixDatabase:readTheList	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 125	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 128	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: goto +41 -> 59
    //   21: astore_2
    //   22: getstatic 278	okhttp3/internal/platform/Platform:Companion	Lokhttp3/internal/platform/Platform$Companion;
    //   25: invokevirtual 283	okhttp3/internal/platform/Platform$Companion:get	()Lokhttp3/internal/platform/Platform;
    //   28: ldc_w 285
    //   31: iconst_5
    //   32: aload_2
    //   33: checkcast 212	java/lang/Throwable
    //   36: invokevirtual 289	okhttp3/internal/platform/Platform:log	(Ljava/lang/String;ILjava/lang/Throwable;)V
    //   39: iload_1
    //   40: ifeq +9 -> 49
    //   43: invokestatic 125	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   46: invokevirtual 128	java/lang/Thread:interrupt	()V
    //   49: return
    //   50: invokestatic 292	java/lang/Thread:interrupted	()Z
    //   53: pop
    //   54: iconst_1
    //   55: istore_1
    //   56: goto -54 -> 2
    //   59: iload_1
    //   60: ifeq +9 -> 69
    //   63: invokestatic 125	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   66: invokevirtual 128	java/lang/Thread:interrupt	()V
    //   69: aload_2
    //   70: athrow
    //   71: astore_2
    //   72: goto -22 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	PublicSuffixDatabase
    //   1	59	1	i	int
    //   17	1	2	localObject	Object
    //   21	49	2	localIOException	IOException
    //   71	1	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	finally
    //   22	39	17	finally
    //   50	54	17	finally
    //   2	6	21	java/io/IOException
    //   10	16	21	java/io/IOException
    //   2	6	71	java/io/InterruptedIOException
    //   10	16	71	java/io/InterruptedIOException
  }
  
  public final String getEffectiveTldPlusOne(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "domain");
    Object localObject = IDN.toUnicode(paramString);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "unicodeDomain");
    localObject = StringsKt.split$default((CharSequence)localObject, new char[] { '.' }, false, 0, 6, null);
    List localList = findMatchingRule((List)localObject);
    if ((((List)localObject).size() == localList.size()) && (((String)localList.get(0)).charAt(0) != '!')) {
      return null;
    }
    int i;
    int j;
    if (((String)localList.get(0)).charAt(0) == '!')
    {
      i = ((List)localObject).size();
      j = localList.size();
    }
    else
    {
      i = ((List)localObject).size();
      j = localList.size() + 1;
    }
    return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence((Iterable)StringsKt.split$default((CharSequence)paramString, new char[] { '.' }, false, 0, 6, null)), i - j), (CharSequence)".", null, null, 0, null, null, 62, null);
  }
  
  public final void setListBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "publicSuffixListBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "publicSuffixExceptionListBytes");
    this.publicSuffixListBytes = paramArrayOfByte1;
    this.publicSuffixExceptionListBytes = paramArrayOfByte2;
    this.listRead.set(true);
    this.readCompleteLatch.countDown();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\f\n\000\n\002\020 \n\002\020\016\n\002\b\002\n\002\020\022\n\000\n\002\030\002\n\002\b\003\n\002\020\021\n\000\n\002\020\b\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\006\020\r\032\0020\fJ)\020\016\032\004\030\0010\007*\0020\n2\f\020\017\032\b\022\004\022\0020\n0\0202\006\020\021\032\0020\022H\002¢\006\002\020\023R\016\020\003\032\0020\004XT¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\016\020\b\032\0020\007XT¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final String binarySearch(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
    {
      int n = paramArrayOfByte.length;
      String str = (String)null;
      int m = 0;
      if (m < n)
      {
        int i = (m + n) / 2;
        while ((i > -1) && (paramArrayOfByte[i] != (byte)10)) {
          i -= 1;
        }
        int i3 = i + 1;
        i = 1;
        int i4;
        for (;;)
        {
          i4 = i3 + i;
          if (paramArrayOfByte[i4] == (byte)10) {
            break;
          }
          i += 1;
        }
        int i5 = i4 - i3;
        int i1 = paramInt;
        int j = 0;
        i = 0;
        int k = 0;
        label213:
        label336:
        label351:
        for (;;)
        {
          int i2;
          if (j != 0)
          {
            i2 = 46;
            j = 0;
          }
          else
          {
            i2 = Util.and(paramArrayOfByte1[i1][i], 255);
          }
          i2 -= Util.and(paramArrayOfByte[(i3 + k)], 255);
          if (i2 == 0)
          {
            k += 1;
            i += 1;
            if (k != i5)
            {
              if (paramArrayOfByte1[i1].length != i) {
                break label351;
              }
              if (i1 != ((Object[])paramArrayOfByte1).length - 1) {
                break label336;
              }
            }
          }
          if (i2 < 0)
          {
            n = i3 - 1;
            break;
          }
          if (i2 > 0) {}
          do
          {
            m = i4 + 1;
            break;
            k = i5 - k;
            j = paramArrayOfByte1[i1].length - i;
            i = i1 + 1;
            i1 = ((Object[])paramArrayOfByte1).length;
            while (i < i1)
            {
              j += paramArrayOfByte1[i].length;
              i += 1;
            }
            if (j < k) {
              break label213;
            }
          } while (j > k);
          paramArrayOfByte1 = StandardCharsets.UTF_8;
          Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte1, "UTF_8");
          return new String(paramArrayOfByte, i3, i5, paramArrayOfByte1);
          i1 += 1;
          j = 1;
          i = -1;
        }
      }
      return str;
    }
    
    public final PublicSuffixDatabase get()
    {
      return PublicSuffixDatabase.access$getInstance$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\publicsuffix\PublicSuffixDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */