package com.xiaomi.push;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class fw
{
  public static int a(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof gf;
    Throwable localThrowable = paramThrowable;
    if (bool)
    {
      gf localgf = (gf)paramThrowable;
      localThrowable = paramThrowable;
      if (localgf.a() != null) {
        localThrowable = localgf.a();
      }
    }
    paramThrowable = localThrowable.getMessage();
    if (localThrowable.getCause() != null) {
      paramThrowable = localThrowable.getCause().getMessage();
    }
    if ((localThrowable instanceof SocketTimeoutException)) {
      return 105;
    }
    if ((localThrowable instanceof SocketException))
    {
      if (paramThrowable.indexOf("Network is unreachable") != -1) {
        return 102;
      }
      if (paramThrowable.indexOf("Connection refused") != -1) {
        return 103;
      }
      if (paramThrowable.indexOf("Connection timed out") != -1) {
        return 105;
      }
      if (paramThrowable.endsWith("EACCES (Permission denied)")) {
        return 101;
      }
      if (paramThrowable.indexOf("Connection reset by peer") != -1) {
        return 109;
      }
      if (paramThrowable.indexOf("Broken pipe") != -1) {
        return 110;
      }
      if (paramThrowable.indexOf("No route to host") != -1) {
        return 104;
      }
      if (paramThrowable.endsWith("EINVAL (Invalid argument)")) {
        return 106;
      }
      return 199;
    }
    if ((localThrowable instanceof UnknownHostException)) {
      return 107;
    }
    if (bool) {
      return 399;
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */