package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(bv={1, 0, 3}, d1={"\0004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\020\002\n\002\b\002\n\002\020\013\n\002\b\006\n\002\030\002\n\000\n\002\020\t\n\000\b\020\030\0002\0020\001B!\022\006\020\002\032\0020\003\022\022\020\004\032\016\022\004\022\0020\006\022\004\022\0020\0070\005¢\006\002\020\bJ\b\020\r\032\0020\007H\026J\b\020\016\032\0020\007H\026J\030\020\017\032\0020\0072\006\020\020\032\0020\0212\006\020\022\032\0020\023H\026R\016\020\t\032\0020\nX\016¢\006\002\n\000R\035\020\004\032\016\022\004\022\0020\006\022\004\022\0020\0070\005¢\006\b\n\000\032\004\b\013\020\f¨\006\024"}, d2={"Lokhttp3/internal/cache/FaultHidingSink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "onException", "Lkotlin/Function1;", "Ljava/io/IOException;", "", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "hasErrors", "", "getOnException", "()Lkotlin/jvm/functions/Function1;", "close", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k=1, mv={1, 1, 16})
public class FaultHidingSink
  extends ForwardingSink
{
  private boolean hasErrors;
  private final Function1<IOException, Unit> onException;
  
  public FaultHidingSink(Sink paramSink, Function1<? super IOException, Unit> paramFunction1)
  {
    super(paramSink);
    this.onException = paramFunction1;
  }
  
  public void close()
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      this.onException.invoke(localIOException);
    }
  }
  
  public void flush()
  {
    if (this.hasErrors) {
      return;
    }
    try
    {
      super.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.hasErrors = true;
      this.onException.invoke(localIOException);
    }
  }
  
  public final Function1<IOException, Unit> getOnException()
  {
    return this.onException;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    if (this.hasErrors)
    {
      paramBuffer.skip(paramLong);
      return;
    }
    try
    {
      super.write(paramBuffer, paramLong);
      return;
    }
    catch (IOException paramBuffer)
    {
      this.hasErrors = true;
      this.onException.invoke(paramBuffer);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\cache\FaultHidingSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */