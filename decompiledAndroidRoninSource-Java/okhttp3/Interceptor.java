package okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\bf\030\000 \0072\0020\001:\002\006\007J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&¨\006\b"}, d2={"Lokhttp3/Interceptor;", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Chain", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface Interceptor
{
  public static final Companion Companion = Companion.$$INSTANCE;
  
  public abstract Response intercept(Chain paramChain)
    throws IOException;
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J\b\020\004\032\0020\005H&J\n\020\006\032\004\030\0010\007H&J\020\020\b\032\0020\t2\006\020\n\032\0020\013H&J\b\020\f\032\0020\005H&J\b\020\n\032\0020\013H&J\030\020\r\032\0020\0002\006\020\016\032\0020\0052\006\020\017\032\0020\020H&J\030\020\021\032\0020\0002\006\020\016\032\0020\0052\006\020\017\032\0020\020H&J\030\020\022\032\0020\0002\006\020\016\032\0020\0052\006\020\017\032\0020\020H&J\b\020\023\032\0020\005H&¨\006\024"}, d2={"Lokhttp3/Interceptor$Chain;", "", "call", "Lokhttp3/Call;", "connectTimeoutMillis", "", "connection", "Lokhttp3/Connection;", "proceed", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "readTimeoutMillis", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "writeTimeoutMillis", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract interface Chain
  {
    public abstract Call call();
    
    public abstract int connectTimeoutMillis();
    
    public abstract Connection connection();
    
    public abstract Response proceed(Request paramRequest)
      throws IOException;
    
    public abstract int readTimeoutMillis();
    
    public abstract Request request();
    
    public abstract Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit);
    
    public abstract int writeTimeoutMillis();
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J.\020\003\032\0020\0042#\b\004\020\005\032\035\022\023\022\0210\007¢\006\f\b\b\022\b\b\t\022\004\b\b(\n\022\004\022\0020\0130\006H\n¨\006\f"}, d2={"Lokhttp3/Interceptor$Companion;", "", "()V", "invoke", "Lokhttp3/Interceptor;", "block", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", "name", "chain", "Lokhttp3/Response;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Interceptor invoke(Function1<? super Interceptor.Chain, Response> paramFunction1)
    {
      Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
      (Interceptor)new Interceptor()
      {
        public Response intercept(Interceptor.Chain paramAnonymousChain)
        {
          Intrinsics.checkParameterIsNotNull(paramAnonymousChain, "chain");
          return (Response)this.$block.invoke(paramAnonymousChain);
        }
      };
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Interceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */