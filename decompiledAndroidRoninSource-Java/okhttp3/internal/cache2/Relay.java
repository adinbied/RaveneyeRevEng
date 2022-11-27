package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.ByteString.Companion;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000L\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\020\013\n\002\b\n\n\002\020\b\n\002\b\016\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\t\030\000 :2\0020\001:\002:;B3\b\002\022\b\020\002\032\004\030\0010\003\022\b\020\004\032\004\030\0010\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\006\020\n\032\0020\007¢\006\002\020\013J\016\0202\032\002032\006\0204\032\0020\007J\006\020\b\032\0020\tJ\b\0205\032\004\030\0010\005J \0206\032\002032\006\0207\032\0020\t2\006\0204\032\0020\0072\006\0208\032\0020\007H\002J\020\0209\032\002032\006\0204\032\0020\007H\002R\021\020\f\032\0020\r¢\006\b\n\000\032\004\b\016\020\017R\021\020\n\032\0020\007¢\006\b\n\000\032\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R\034\020\002\032\004\030\0010\003X\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\021\020\034\032\0020\0238F¢\006\006\032\004\b\034\020\025R\016\020\b\032\0020\tX\004¢\006\002\n\000R\032\020\035\032\0020\036X\016¢\006\016\n\000\032\004\b\037\020 \"\004\b!\020\"R\034\020\004\032\004\030\0010\005X\016¢\006\016\n\000\032\004\b#\020$\"\004\b%\020&R\021\020'\032\0020\r¢\006\b\n\000\032\004\b(\020\017R\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b)\020\021\"\004\b*\020+R\034\020,\032\004\030\0010-X\016¢\006\016\n\000\032\004\b.\020/\"\004\b0\0201¨\006<"}, d2={"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k=1, mv={1, 1, 16})
public final class Relay
{
  public static final Companion Companion = new Companion(null);
  private static final long FILE_HEADER_SIZE = 32L;
  public static final ByteString PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
  public static final ByteString PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
  private static final int SOURCE_FILE = 2;
  private static final int SOURCE_UPSTREAM = 1;
  private final Buffer buffer;
  private final long bufferMaxSize;
  private boolean complete;
  private RandomAccessFile file;
  private final ByteString metadata;
  private int sourceCount;
  private Source upstream;
  private final Buffer upstreamBuffer;
  private long upstreamPos;
  private Thread upstreamReader;
  
  private Relay(RandomAccessFile paramRandomAccessFile, Source paramSource, long paramLong1, ByteString paramByteString, long paramLong2)
  {
    this.file = paramRandomAccessFile;
    this.upstream = paramSource;
    this.upstreamPos = paramLong1;
    this.metadata = paramByteString;
    this.bufferMaxSize = paramLong2;
    this.upstreamBuffer = new Buffer();
    boolean bool;
    if (this.upstream == null) {
      bool = true;
    } else {
      bool = false;
    }
    this.complete = bool;
    this.buffer = new Buffer();
  }
  
  private final void writeHeader(ByteString paramByteString, long paramLong1, long paramLong2)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(paramByteString);
    localBuffer.writeLong(paramLong1);
    localBuffer.writeLong(paramLong2);
    int i;
    if (localBuffer.size() == 32L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramByteString = this.file;
      if (paramByteString == null) {
        Intrinsics.throwNpe();
      }
      paramByteString = paramByteString.getChannel();
      Intrinsics.checkExpressionValueIsNotNull(paramByteString, "file!!.channel");
      new FileOperator(paramByteString).write(0L, localBuffer, 32L);
      return;
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  private final void writeMetadata(long paramLong)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.metadata);
    Object localObject = this.file;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((RandomAccessFile)localObject).getChannel();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "file!!.channel");
    new FileOperator((FileChannel)localObject).write(32L + paramLong, localBuffer, this.metadata.size());
  }
  
  public final void commit(long paramLong)
    throws IOException
  {
    writeMetadata(paramLong);
    Object localObject1 = this.file;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((RandomAccessFile)localObject1).getChannel().force(false);
    writeHeader(PREFIX_CLEAN, paramLong, this.metadata.size());
    localObject1 = this.file;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((RandomAccessFile)localObject1).getChannel().force(false);
    try
    {
      this.complete = true;
      localObject1 = Unit.INSTANCE;
      localObject1 = this.upstream;
      if (localObject1 != null) {
        Util.closeQuietly((Closeable)localObject1);
      }
      this.upstream = ((Source)null);
      return;
    }
    finally {}
  }
  
  public final Buffer getBuffer()
  {
    return this.buffer;
  }
  
  public final long getBufferMaxSize()
  {
    return this.bufferMaxSize;
  }
  
  public final boolean getComplete()
  {
    return this.complete;
  }
  
  public final RandomAccessFile getFile()
  {
    return this.file;
  }
  
  public final int getSourceCount()
  {
    return this.sourceCount;
  }
  
  public final Source getUpstream()
  {
    return this.upstream;
  }
  
  public final Buffer getUpstreamBuffer()
  {
    return this.upstreamBuffer;
  }
  
  public final long getUpstreamPos()
  {
    return this.upstreamPos;
  }
  
  public final Thread getUpstreamReader()
  {
    return this.upstreamReader;
  }
  
  public final boolean isClosed()
  {
    return this.file == null;
  }
  
  public final ByteString metadata()
  {
    return this.metadata;
  }
  
  public final Source newSource()
  {
    try
    {
      RandomAccessFile localRandomAccessFile = this.file;
      if (localRandomAccessFile == null) {
        return null;
      }
      this.sourceCount += 1;
      return (Source)new RelaySource();
    }
    finally {}
  }
  
  public final void setComplete(boolean paramBoolean)
  {
    this.complete = paramBoolean;
  }
  
  public final void setFile(RandomAccessFile paramRandomAccessFile)
  {
    this.file = paramRandomAccessFile;
  }
  
  public final void setSourceCount(int paramInt)
  {
    this.sourceCount = paramInt;
  }
  
  public final void setUpstream(Source paramSource)
  {
    this.upstream = paramSource;
  }
  
  public final void setUpstreamPos(long paramLong)
  {
    this.upstreamPos = paramLong;
  }
  
  public final void setUpstreamReader(Thread paramThread)
  {
    this.upstreamReader = paramThread;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0062\006\020\022\032\0020\004J\016\020\023\032\0020\f2\006\020\r\032\0020\016R\016\020\003\032\0020\004XT¢\006\002\n\000R\020\020\005\032\0020\0068\006X\004¢\006\002\n\000R\020\020\007\032\0020\0068\006X\004¢\006\002\n\000R\016\020\b\032\0020\tXT¢\006\002\n\000R\016\020\n\032\0020\tXT¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Relay edit(File paramFile, Source paramSource, ByteString paramByteString, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramFile, "file");
      Intrinsics.checkParameterIsNotNull(paramSource, "upstream");
      Intrinsics.checkParameterIsNotNull(paramByteString, "metadata");
      paramFile = new RandomAccessFile(paramFile, "rw");
      paramSource = new Relay(paramFile, paramSource, 0L, paramByteString, paramLong, null);
      paramFile.setLength(0L);
      Relay.access$writeHeader(paramSource, Relay.PREFIX_DIRTY, -1L, -1L);
      return paramSource;
    }
    
    public final Relay read(File paramFile)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramFile, "file");
      paramFile = new RandomAccessFile(paramFile, "rw");
      Object localObject = paramFile.getChannel();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "randomAccessFile.channel");
      localObject = new FileOperator((FileChannel)localObject);
      Buffer localBuffer = new Buffer();
      ((FileOperator)localObject).read(0L, localBuffer, 32L);
      if (!(Intrinsics.areEqual(localBuffer.readByteString(Relay.PREFIX_CLEAN.size()), Relay.PREFIX_CLEAN) ^ true))
      {
        long l1 = localBuffer.readLong();
        long l2 = localBuffer.readLong();
        localBuffer = new Buffer();
        ((FileOperator)localObject).read(l1 + 32L, localBuffer, l2);
        return new Relay(paramFile, null, l1, localBuffer.readByteString(), 0L, null);
      }
      throw ((Throwable)new IOException("unreadable cache file"));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J\b\020\t\032\0020\nH\026J\030\020\013\032\0020\0062\006\020\f\032\0020\r2\006\020\016\032\0020\006H\026J\b\020\007\032\0020\bH\026R\020\020\003\032\004\030\0010\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\017"}, d2={"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 1, 16})
  public final class RelaySource
    implements Source
  {
    private FileOperator fileOperator;
    private long sourcePos;
    private final Timeout timeout = new Timeout();
    
    public RelaySource()
    {
      this$1 = this$1.getFile();
      if (this$1 == null) {
        Intrinsics.throwNpe();
      }
      this$1 = this$1.getChannel();
      Intrinsics.checkExpressionValueIsNotNull(this$1, "file!!.channel");
      this.fileOperator = new FileOperator(this$1);
    }
    
    public void close()
      throws IOException
    {
      if (this.fileOperator == null) {
        return;
      }
      this.fileOperator = ((FileOperator)null);
      RandomAccessFile localRandomAccessFile = (RandomAccessFile)null;
      synchronized (this.this$0)
      {
        Object localObject2 = this.this$0;
        ((Relay)localObject2).setSourceCount(((Relay)localObject2).getSourceCount() - 1);
        if (this.this$0.getSourceCount() == 0)
        {
          localRandomAccessFile = this.this$0.getFile();
          this.this$0.setFile((RandomAccessFile)null);
        }
        localObject2 = Unit.INSTANCE;
        if (localRandomAccessFile != null) {
          Util.closeQuietly((Closeable)localRandomAccessFile);
        }
        return;
      }
    }
    
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(???, "sink");
      ??? = this.fileOperator;
      int j = 1;
      int i;
      if (??? != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        synchronized (this.this$0)
        {
          long l;
          for (;;)
          {
            l = this.this$0.getUpstreamPos();
            if (this.sourcePos != l)
            {
              l = this.this$0.getUpstreamPos() - this.this$0.getBuffer().size();
              if (this.sourcePos < l)
              {
                i = 2;
                break label209;
              }
              paramLong = Math.min(paramLong, this.this$0.getUpstreamPos() - this.sourcePos);
              this.this$0.getBuffer().copyTo(???, this.sourcePos - l, paramLong);
              this.sourcePos += paramLong;
              return paramLong;
            }
            boolean bool = this.this$0.getComplete();
            if (bool) {
              return -1L;
            }
            if (this.this$0.getUpstreamReader() == null) {
              break;
            }
            this.timeout.waitUntilNotified(this.this$0);
          }
          this.this$0.setUpstreamReader(Thread.currentThread());
          i = j;
          label209:
          if (i == 2)
          {
            paramLong = Math.min(paramLong, this.this$0.getUpstreamPos() - this.sourcePos);
            ??? = this.fileOperator;
            if (??? == null) {
              Intrinsics.throwNpe();
            }
            ((FileOperator)???).read(this.sourcePos + 32L, ???, paramLong);
            this.sourcePos += paramLong;
            return paramLong;
          }
          try
          {
            ??? = this.this$0.getUpstream();
            if (??? == null) {
              Intrinsics.throwNpe();
            }
            l = ((Source)???).read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());
            if (l == -1L)
            {
              this.this$0.commit(this.this$0.getUpstreamPos());
              synchronized (this.this$0)
              {
                this.this$0.setUpstreamReader((Thread)null);
                ??? = this.this$0;
                if (??? != null)
                {
                  ((Object)???).notifyAll();
                  ??? = Unit.INSTANCE;
                  return -1L;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              }
            }
            paramLong = Math.min(l, paramLong);
            this.this$0.getUpstreamBuffer().copyTo(???, 0L, paramLong);
            this.sourcePos += paramLong;
            ??? = this.fileOperator;
            if (??? == null) {
              Intrinsics.throwNpe();
            }
            ???.write(this.this$0.getUpstreamPos() + 32L, this.this$0.getUpstreamBuffer().clone(), l);
            synchronized (this.this$0)
            {
              this.this$0.getBuffer().write(this.this$0.getUpstreamBuffer(), l);
              if (this.this$0.getBuffer().size() > this.this$0.getBufferMaxSize()) {
                this.this$0.getBuffer().skip(this.this$0.getBuffer().size() - this.this$0.getBufferMaxSize());
              }
              Object localObject3 = this.this$0;
              ((Relay)localObject3).setUpstreamPos(((Relay)localObject3).getUpstreamPos() + l);
              localObject3 = Unit.INSTANCE;
              synchronized (this.this$0)
              {
                this.this$0.setUpstreamReader((Thread)null);
                localObject3 = this.this$0;
                if (localObject3 != null)
                {
                  ((Object)localObject3).notifyAll();
                  localObject3 = Unit.INSTANCE;
                  return paramLong;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              }
            }
            Object localObject8;
            ??? = finally;
          }
          finally
          {
            synchronized (this.this$0)
            {
              this.this$0.setUpstreamReader((Thread)null);
              localObject8 = this.this$0;
              if (localObject8 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              }
              ((Object)localObject8).notifyAll();
              localObject8 = Unit.INSTANCE;
              throw ((Throwable)localObject6);
            }
          }
        }
      }
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\cache2\Relay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */