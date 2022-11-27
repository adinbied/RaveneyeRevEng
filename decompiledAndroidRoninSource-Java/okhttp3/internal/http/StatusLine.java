package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\016\n\002\b\004\030\000 \n2\0020\001:\001\nB\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\t\032\0020\007H\026R\020\020\004\032\0020\0058\006X\004¢\006\002\n\000R\020\020\006\032\0020\0078\006X\004¢\006\002\n\000R\020\020\002\032\0020\0038\006X\004¢\006\002\n\000¨\006\013"}, d2={"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", "code", "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class StatusLine
{
  public static final Companion Companion = new Companion(null);
  public static final int HTTP_CONTINUE = 100;
  public static final int HTTP_MISDIRECTED_REQUEST = 421;
  public static final int HTTP_PERM_REDIRECT = 308;
  public static final int HTTP_TEMP_REDIRECT = 307;
  public final int code;
  public final String message;
  public final Protocol protocol;
  
  public StatusLine(Protocol paramProtocol, int paramInt, String paramString)
  {
    this.protocol = paramProtocol;
    this.code = paramInt;
    this.message = paramString;
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    if (this.protocol == Protocol.HTTP_1_0) {
      ((StringBuilder)localObject).append("HTTP/1.0");
    } else {
      ((StringBuilder)localObject).append("HTTP/1.1");
    }
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(this.code);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(this.message);
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return (String)localObject;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\b\032\0020\t2\006\020\n\032\0020\013J\016\020\f\032\0020\t2\006\020\r\032\0020\016R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000R\016\020\007\032\0020\004XT¢\006\002\n\000¨\006\017"}, d2={"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", "response", "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final StatusLine get(Response paramResponse)
    {
      Intrinsics.checkParameterIsNotNull(paramResponse, "response");
      return new StatusLine(paramResponse.protocol(), paramResponse.code(), paramResponse.message());
    }
    
    public final StatusLine parse(String paramString)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramString, "statusLine");
      boolean bool = StringsKt.startsWith$default(paramString, "HTTP/1.", false, 2, null);
      int i = 9;
      if (bool)
      {
        if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
        {
          j = paramString.charAt(7) - '0';
          if (j == 0)
          {
            localObject = Protocol.HTTP_1_0;
          }
          else if (j == 1)
          {
            localObject = Protocol.HTTP_1_1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unexpected status line: ");
            ((StringBuilder)localObject).append(paramString);
            throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected status line: ");
          ((StringBuilder)localObject).append(paramString);
          throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
        }
      }
      else
      {
        if (!StringsKt.startsWith$default(paramString, "ICY ", false, 2, null)) {
          break label388;
        }
        localObject = Protocol.HTTP_1_0;
        i = 4;
      }
      int k = paramString.length();
      int j = i + 3;
      if (k >= j) {}
      try
      {
        String str = paramString.substring(i, j);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        k = Integer.parseInt(str);
        if (paramString.length() > j)
        {
          if (paramString.charAt(j) == ' ')
          {
            paramString = paramString.substring(i + 4);
            Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Unexpected status line: ");
            ((StringBuilder)localObject).append(paramString);
            throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
          }
        }
        else {
          paramString = "";
        }
        return new StatusLine((Protocol)localObject, k, paramString);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected status line: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected status line: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
      label388:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected status line: ");
      ((StringBuilder)localObject).append(paramString);
      throw ((Throwable)new ProtocolException(((StringBuilder)localObject).toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\StatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */