package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Deprecated(message="changed in Okio 2.x")
@Metadata(bv={1, 0, 3}, d1={"\000R\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\bÇ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007J\b\020\007\032\0020\004H\007J\020\020\b\032\0020\t2\006\020\n\032\0020\004H\007J\020\020\b\032\0020\0132\006\020\f\032\0020\rH\007J\020\020\n\032\0020\0042\006\020\005\032\0020\006H\007J\020\020\n\032\0020\0042\006\020\016\032\0020\017H\007J\020\020\n\032\0020\0042\006\020\020\032\0020\021H\007J)\020\n\032\0020\0042\006\020\022\032\0020\0232\022\020\024\032\n\022\006\b\001\022\0020\0260\025\"\0020\026H\007¢\006\002\020\027J\020\020\f\032\0020\r2\006\020\005\032\0020\006H\007J\020\020\f\032\0020\r2\006\020\030\032\0020\031H\007J\020\020\f\032\0020\r2\006\020\020\032\0020\021H\007J)\020\f\032\0020\r2\006\020\022\032\0020\0232\022\020\024\032\n\022\006\b\001\022\0020\0260\025\"\0020\026H\007¢\006\002\020\032¨\006\033"}, d2={"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k=1, mv={1, 1, 16})
public final class -DeprecatedOkio
{
  public static final -DeprecatedOkio INSTANCE = new -DeprecatedOkio();
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.appendingSink()", imports={"okio.appendingSink"}))
  public final Sink appendingSink(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.appendingSink(paramFile);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="blackholeSink()", imports={"okio.blackholeSink"}))
  public final Sink blackhole()
  {
    return Okio.blackhole();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="sink.buffer()", imports={"okio.buffer"}))
  public final BufferedSink buffer(Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    return Okio.buffer(paramSink);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="source.buffer()", imports={"okio.buffer"}))
  public final BufferedSource buffer(Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    return Okio.buffer(paramSource);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.sink()", imports={"okio.sink"}))
  public final Sink sink(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.sink$default(paramFile, false, 1, null);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="outputStream.sink()", imports={"okio.sink"}))
  public final Sink sink(OutputStream paramOutputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramOutputStream, "outputStream");
    return Okio.sink(paramOutputStream);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="socket.sink()", imports={"okio.sink"}))
  public final Sink sink(Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    return Okio.sink(paramSocket);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="path.sink(*options)", imports={"okio.sink"}))
  public final Sink sink(Path paramPath, OpenOption... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "path");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    return Okio.sink(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="file.source()", imports={"okio.source"}))
  public final Source source(File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    return Okio.source(paramFile);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="inputStream.source()", imports={"okio.source"}))
  public final Source source(InputStream paramInputStream)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    return Okio.source(paramInputStream);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="socket.source()", imports={"okio.source"}))
  public final Source source(Socket paramSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    return Okio.source(paramSocket);
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="path.source(*options)", imports={"okio.source"}))
  public final Source source(Path paramPath, OpenOption... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramPath, "path");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "options");
    return Okio.source(paramPath, (OpenOption[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\-DeprecatedOkio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */