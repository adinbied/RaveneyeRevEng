package dji.thirdparty.plogger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;

final class Helper
{
  static boolean equals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int j = paramCharSequence1.length();
      if (j == paramCharSequence2.length())
      {
        if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
          return paramCharSequence1.equals(paramCharSequence2);
        }
        int i = 0;
        while (i < j)
        {
          if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)) {
            return false;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\Helper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */