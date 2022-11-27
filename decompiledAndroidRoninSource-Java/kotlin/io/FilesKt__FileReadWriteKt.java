package kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

@Metadata(bv={1, 0, 3}, d1={"\000z\n\000\n\002\020\002\n\002\030\002\n\000\n\002\020\022\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\000\032\022\020\000\032\0020\001*\0020\0022\006\020\003\032\0020\004\032\034\020\005\032\0020\001*\0020\0022\006\020\006\032\0020\0072\b\b\002\020\b\032\0020\t\032!\020\n\032\0020\013*\0020\0022\b\b\002\020\b\032\0020\t2\b\b\002\020\f\032\0020\rH\b\032!\020\016\032\0020\017*\0020\0022\b\b\002\020\b\032\0020\t2\b\b\002\020\f\032\0020\rH\b\032B\020\020\032\0020\001*\0020\00226\020\021\0322\022\023\022\0210\004¢\006\f\b\023\022\b\b\024\022\004\b\b(\025\022\023\022\0210\r¢\006\f\b\023\022\b\b\024\022\004\b\b(\026\022\004\022\0020\0010\022\032J\020\020\032\0020\001*\0020\0022\006\020\027\032\0020\r26\020\021\0322\022\023\022\0210\004¢\006\f\b\023\022\b\b\024\022\004\b\b(\025\022\023\022\0210\r¢\006\f\b\023\022\b\b\024\022\004\b\b(\026\022\004\022\0020\0010\022\0327\020\030\032\0020\001*\0020\0022\b\b\002\020\b\032\0020\t2!\020\021\032\035\022\023\022\0210\007¢\006\f\b\023\022\b\b\024\022\004\b\b(\032\022\004\022\0020\0010\031\032\r\020\033\032\0020\034*\0020\002H\b\032\r\020\035\032\0020\036*\0020\002H\b\032\027\020\037\032\0020 *\0020\0022\b\b\002\020\b\032\0020\tH\b\032\n\020!\032\0020\004*\0020\002\032\032\020\"\032\b\022\004\022\0020\0070#*\0020\0022\b\b\002\020\b\032\0020\t\032\024\020$\032\0020\007*\0020\0022\b\b\002\020\b\032\0020\t\032\027\020%\032\0020&*\0020\0022\b\b\002\020\b\032\0020\tH\b\032?\020'\032\002H(\"\004\b\000\020(*\0020\0022\b\b\002\020\b\032\0020\t2\030\020)\032\024\022\n\022\b\022\004\022\0020\0070*\022\004\022\002H(0\031H\bø\001\000¢\006\002\020,\032\022\020-\032\0020\001*\0020\0022\006\020\003\032\0020\004\032\034\020.\032\0020\001*\0020\0022\006\020\006\032\0020\0072\b\b\002\020\b\032\0020\t\032\027\020/\032\00200*\0020\0022\b\b\002\020\b\032\0020\tH\b\002\b\n\006\b\021(+0\001¨\0061"}, d2={"appendBytes", "", "Ljava/io/File;", "array", "", "appendText", "text", "", "charset", "Ljava/nio/charset/Charset;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", "", "bufferedWriter", "Ljava/io/BufferedWriter;", "forEachBlock", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lkotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", "readLines", "", "readText", "reader", "Ljava/io/InputStreamReader;", "useLines", "T", "block", "Lkotlin/sequences/Sequence;", "Requires newer compiler version to be inlined correctly.", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FileReadWriteKt
  extends FilesKt__FilePathComponentsKt
{
  public static final void appendBytes(File paramFile, byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$appendBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramFile = (Closeable)new FileOutputStream(paramFile, true);
    Throwable localThrowable = (Throwable)null;
    try
    {
      ((FileOutputStream)paramFile).write(paramArrayOfByte);
      paramArrayOfByte = Unit.INSTANCE;
      CloseableKt.closeFinally(paramFile, localThrowable);
      return;
    }
    finally
    {
      try
      {
        throw paramArrayOfByte;
      }
      finally
      {
        CloseableKt.closeFinally(paramFile, paramArrayOfByte);
      }
    }
  }
  
  public static final void appendText(File paramFile, String paramString, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$appendText");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    FilesKt.appendBytes(paramFile, paramString);
  }
  
  private static final BufferedReader bufferedReader(File paramFile, Charset paramCharset, int paramInt)
  {
    paramFile = (Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedReader)) {
      return (BufferedReader)paramFile;
    }
    return new BufferedReader(paramFile, paramInt);
  }
  
  private static final BufferedWriter bufferedWriter(File paramFile, Charset paramCharset, int paramInt)
  {
    paramFile = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedWriter)) {
      return (BufferedWriter)paramFile;
    }
    return new BufferedWriter(paramFile, paramInt);
  }
  
  /* Error */
  public static final void forEachBlock(File paramFile, int paramInt, Function2<? super byte[], ? super Integer, Unit> paramFunction2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc -78
    //   3: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc -77
    //   9: invokestatic 81	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: iload_1
    //   13: sipush 512
    //   16: invokestatic 185	kotlin/ranges/RangesKt:coerceAtLeast	(II)I
    //   19: newarray <illegal type>
    //   21: astore_3
    //   22: new 140	java/io/FileInputStream
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 143	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: checkcast 89	java/io/Closeable
    //   33: astore_0
    //   34: aconst_null
    //   35: checkcast 91	java/lang/Throwable
    //   38: astore 4
    //   40: aload_0
    //   41: checkcast 140	java/io/FileInputStream
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: invokevirtual 189	java/io/FileInputStream:read	([B)I
    //   52: istore_1
    //   53: iload_1
    //   54: ifgt +14 -> 68
    //   57: getstatic 101	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   60: astore_2
    //   61: aload_0
    //   62: aload 4
    //   64: invokestatic 107	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   67: return
    //   68: aload_2
    //   69: aload_3
    //   70: iload_1
    //   71: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokeinterface 201 3 0
    //   79: pop
    //   80: goto -34 -> 46
    //   83: astore_2
    //   84: aload_2
    //   85: athrow
    //   86: astore_3
    //   87: aload_0
    //   88: aload_2
    //   89: invokestatic 107	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile	File
    //   0	94	1	paramInt	int
    //   0	94	2	paramFunction2	Function2<? super byte[], ? super Integer, Unit>
    //   21	49	3	arrayOfByte	byte[]
    //   86	7	3	localObject	Object
    //   38	25	4	localThrowable	Throwable
    //   44	3	5	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   40	46	83	finally
    //   46	53	83	finally
    //   57	61	83	finally
    //   68	80	83	finally
    //   84	86	86	finally
  }
  
  public static final void forEachBlock(File paramFile, Function2<? super byte[], ? super Integer, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$forEachBlock");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    FilesKt.forEachBlock(paramFile, 4096, paramFunction2);
  }
  
  public static final void forEachLine(File paramFile, Charset paramCharset, Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$forEachLine");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "action");
    TextStreamsKt.forEachLine((Reader)new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset)), paramFunction1);
  }
  
  private static final FileInputStream inputStream(File paramFile)
  {
    return new FileInputStream(paramFile);
  }
  
  private static final FileOutputStream outputStream(File paramFile)
  {
    return new FileOutputStream(paramFile);
  }
  
  private static final PrintWriter printWriter(File paramFile, Charset paramCharset)
  {
    paramFile = (Writer)new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedWriter)) {
      paramFile = (BufferedWriter)paramFile;
    } else {
      paramFile = new BufferedWriter(paramFile, 8192);
    }
    return new PrintWriter((Writer)paramFile);
  }
  
  public static final byte[] readBytes(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readBytes");
    Closeable localCloseable = (Closeable)new FileInputStream(paramFile);
    Throwable localThrowable = (Throwable)null;
    try
    {
      FileInputStream localFileInputStream = (FileInputStream)localCloseable;
      long l = paramFile.length();
      if (l <= Integer.MAX_VALUE)
      {
        int k = (int)l;
        localObject1 = new byte[k];
        int j = k;
        int i = 0;
        while (j > 0)
        {
          int m = localFileInputStream.read((byte[])localObject1, i, j);
          if (m < 0) {
            break;
          }
          j -= m;
          i += m;
        }
        if (j > 0)
        {
          paramFile = Arrays.copyOf((byte[])localObject1, i);
          Intrinsics.checkExpressionValueIsNotNull(paramFile, "java.util.Arrays.copyOf(this, newSize)");
        }
        else
        {
          i = localFileInputStream.read();
          if (i == -1)
          {
            paramFile = (File)localObject1;
          }
          else
          {
            ExposingBufferByteArrayOutputStream localExposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
            localExposingBufferByteArrayOutputStream.write(i);
            ByteStreamsKt.copyTo$default((InputStream)localFileInputStream, (OutputStream)localExposingBufferByteArrayOutputStream, 0, 2, null);
            i = localExposingBufferByteArrayOutputStream.size() + k;
            if (i < 0) {
              break label224;
            }
            paramFile = localExposingBufferByteArrayOutputStream.getBuffer();
            localObject1 = Arrays.copyOf((byte[])localObject1, i);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.util.Arrays.copyOf(this, newSize)");
            paramFile = ArraysKt.copyInto(paramFile, (byte[])localObject1, k, 0, localExposingBufferByteArrayOutputStream.size());
          }
        }
        CloseableKt.closeFinally(localCloseable, localThrowable);
        return paramFile;
        label224:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("File ");
        ((StringBuilder)localObject1).append(paramFile);
        ((StringBuilder)localObject1).append(" is too big to fit in memory.");
        throw ((Throwable)new OutOfMemoryError(((StringBuilder)localObject1).toString()));
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("File ");
      ((StringBuilder)localObject1).append(paramFile);
      ((StringBuilder)localObject1).append(" is too big (");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append(" bytes) to fit in memory.");
      throw ((Throwable)new OutOfMemoryError(((StringBuilder)localObject1).toString()));
    }
    finally
    {
      try
      {
        throw paramFile;
      }
      finally
      {
        CloseableKt.closeFinally(localCloseable, paramFile);
      }
    }
  }
  
  public static final List<String> readLines(File paramFile, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readLines");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    ArrayList localArrayList = new ArrayList();
    FilesKt.forEachLine(paramFile, paramCharset, (Function1)new Lambda(localArrayList)
    {
      public final void invoke(String paramAnonymousString)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousString, "it");
        this.$result.add(paramAnonymousString);
      }
    });
    return (List)localArrayList;
  }
  
  public static final String readText(File paramFile, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$readText");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramFile = (Closeable)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    paramCharset = (Throwable)null;
    try
    {
      String str = TextStreamsKt.readText((Reader)paramFile);
      CloseableKt.closeFinally(paramFile, paramCharset);
      return str;
    }
    finally
    {
      try
      {
        throw paramCharset;
      }
      finally
      {
        CloseableKt.closeFinally(paramFile, paramCharset);
      }
    }
  }
  
  private static final InputStreamReader reader(File paramFile, Charset paramCharset)
  {
    return new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
  }
  
  public static final <T> T useLines(File paramFile, Charset paramCharset, Function1<? super Sequence<String>, ? extends T> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$useLines");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    paramFile = (Reader)new InputStreamReader((InputStream)new FileInputStream(paramFile), paramCharset);
    if ((paramFile instanceof BufferedReader)) {
      paramFile = (BufferedReader)paramFile;
    } else {
      paramFile = new BufferedReader(paramFile, 8192);
    }
    paramFile = (Closeable)paramFile;
    paramCharset = (Throwable)null;
    try
    {
      paramFunction1 = paramFunction1.invoke(TextStreamsKt.lineSequence((BufferedReader)paramFile));
      InlineMarker.finallyStart(1);
      if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
        CloseableKt.closeFinally(paramFile, paramCharset);
      } else {
        paramFile.close();
      }
      InlineMarker.finallyEnd(1);
      return paramFunction1;
    }
    finally
    {
      try
      {
        throw paramFunction1;
      }
      finally
      {
        InlineMarker.finallyStart(1);
      }
    }
    label158:
    try
    {
      paramFile.close();
      break label158;
    }
    finally {}
    CloseableKt.closeFinally(paramFile, paramFunction1);
    InlineMarker.finallyEnd(1);
    throw paramCharset;
  }
  
  public static final void writeBytes(File paramFile, byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$writeBytes");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    paramFile = (Closeable)new FileOutputStream(paramFile);
    Throwable localThrowable = (Throwable)null;
    try
    {
      ((FileOutputStream)paramFile).write(paramArrayOfByte);
      paramArrayOfByte = Unit.INSTANCE;
      CloseableKt.closeFinally(paramFile, localThrowable);
      return;
    }
    finally
    {
      try
      {
        throw paramArrayOfByte;
      }
      finally
      {
        CloseableKt.closeFinally(paramFile, paramArrayOfByte);
      }
    }
  }
  
  public static final void writeText(File paramFile, String paramString, Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$writeText");
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    FilesKt.writeBytes(paramFile, paramString);
  }
  
  private static final OutputStreamWriter writer(File paramFile, Charset paramCharset)
  {
    return new OutputStreamWriter((OutputStream)new FileOutputStream(paramFile), paramCharset);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\FilesKt__FileReadWriteKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */