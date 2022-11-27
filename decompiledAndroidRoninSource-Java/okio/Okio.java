package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000R\n\000\n\002\020\013\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\032\r\020\005\032\0020\006H\007¢\006\002\b\007\032\n\020\b\032\0020\006*\0020\t\032\n\020\n\032\0020\013*\0020\006\032\n\020\n\032\0020\f*\0020\r\032\026\020\016\032\0020\006*\0020\t2\b\b\002\020\017\032\0020\001H\007\032\n\020\016\032\0020\006*\0020\020\032\n\020\016\032\0020\006*\0020\021\032%\020\016\032\0020\006*\0020\0222\022\020\023\032\n\022\006\b\001\022\0020\0250\024\"\0020\025H\007¢\006\002\020\026\032\n\020\027\032\0020\r*\0020\t\032\n\020\027\032\0020\r*\0020\030\032\n\020\027\032\0020\r*\0020\021\032%\020\027\032\0020\r*\0020\0222\022\020\023\032\n\022\006\b\001\022\0020\0250\024\"\0020\025H\007¢\006\002\020\031\"\034\020\000\032\0020\001*\0060\002j\002`\0038@X\004¢\006\006\032\004\b\000\020\004¨\006\032"}, d2={"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "blackholeSink", "Lokio/Sink;", "blackhole", "appendingSink", "Ljava/io/File;", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k=2, mv={1, 1, 16})
public final class Okio
{
  public static final Sink appendingSink(File paramFile)
    throws FileNotFoundException
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$appendingSink");
    return sink((OutputStream)new FileOutputStream(paramFile, true));
  }
  
  public static final Sink blackhole()
  {
    return (Sink)new BlackholeSink();
  }
  
  public static final BufferedSink buffer(Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "$this$buffer");
    return (BufferedSink)new RealBufferedSink(paramSink);
  }
  
  public static final BufferedSource buffer(Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "$this$buffer");
    return (BufferedSource)new RealBufferedSource(paramSource);
  }
  
  public static final boolean isAndroidGetsocknameError(AssertionError paramAssertionError)
  {
    Intrinsics.checkParameterIsNotNull(paramAssertionError, "$this$isAndroidGetsocknameError");
    Throwable localThrowable = paramAssertionError.getCause();
    boolean bool3 = false;
    boolean bool2 = bool3;
    if (localThrowable != null)
    {
      paramAssertionError = paramAssertionError.getMessage();
      boolean bool1;
      if (paramAssertionError != null) {
        bool1 = StringsKt.contains$default((CharSequence)paramAssertionError, (CharSequence)"getsockname failed", false, 2, null);
      } else {
        bool1 = false;
      }
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public static final Sink sink(File paramFile)
    throws FileNotFoundException
  {
    return sink$default(paramFile, false, 1, null);
  }
  
  public static final Sink sink(File paramFile, boolean paramBoolean)
    throws FileNotFoundException
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$sink");
    return sink((OutputStream)new FileOutputStream(paramFile, paramBoolean));
  }
  
  public static final Sink sink(OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "$this$sink");
    return (Sink)new OutputStreamSink(paramOutputStream, new Timeout());
  }
  
  public static final Sink sink(Socket paramSocket)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "$this$sink");
    SocketAsyncTimeout localSocketAsyncTimeout = new SocketAsyncTimeout(paramSocket);
    paramSocket = paramSocket.getOutputStream();
    Intrinsics.checkExpressionValueIsNotNull(paramSocket, "getOutputStream()");
    return localSocketAsyncTimeout.sink((Sink)new OutputStreamSink(paramSocket, (Timeout)localSocketAsyncTimeout));
  }
  
  public static final Sink sink(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "$this$sink");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    paramPath = Files.newOutputStream(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramPath, "Files.newOutputStream(this, *options)");
    return sink(paramPath);
  }
  
  public static final Source source(File paramFile)
    throws FileNotFoundException
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$source");
    return source((InputStream)new FileInputStream(paramFile));
  }
  
  public static final Source source(InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "$this$source");
    return (Source)new InputStreamSource(paramInputStream, new Timeout());
  }
  
  public static final Source source(Socket paramSocket)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "$this$source");
    SocketAsyncTimeout localSocketAsyncTimeout = new SocketAsyncTimeout(paramSocket);
    paramSocket = paramSocket.getInputStream();
    Intrinsics.checkExpressionValueIsNotNull(paramSocket, "getInputStream()");
    return localSocketAsyncTimeout.source((Source)new InputStreamSource(paramSocket, (Timeout)localSocketAsyncTimeout));
  }
  
  public static final Source source(Path paramPath, OpenOption... paramVarArgs)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "$this$source");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    paramPath = Files.newInputStream(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    Intrinsics.checkExpressionValueIsNotNull(paramPath, "Files.newInputStream(this, *options)");
    return source(paramPath);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Okio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */