package okhttp3.internal.platform.android;

import android.util.Log;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv={1, 0, 3}, d1={"\000\034\n\000\n\002\020\b\n\000\n\002\020\002\n\002\b\002\n\002\020\016\n\000\n\002\020\003\n\000\032\"\020\002\032\0020\0032\006\020\004\032\0020\0012\006\020\005\032\0020\0062\b\020\007\032\004\030\0010\bH\000\"\016\020\000\032\0020\001XT¢\006\002\n\000¨\006\t"}, d2={"MAX_LOG_LENGTH", "", "androidLog", "", "level", "message", "", "t", "", "okhttp"}, k=2, mv={1, 1, 16})
public final class UtilKt
{
  private static final int MAX_LOG_LENGTH = 4000;
  
  public static final void androidLog(int paramInt, String paramString, Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    int i = 5;
    if (paramInt != 5) {
      i = 3;
    }
    Object localObject = paramString;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramInt = 0;
    int k = ((String)localObject).length();
    if (paramInt < k)
    {
      int j = StringsKt.indexOf$default((CharSequence)localObject, '\n', paramInt, false, 4, null);
      if (j == -1) {
        j = k;
      }
      for (;;)
      {
        int m = Math.min(j, paramInt + 4000);
        if (localObject == null) {
          break label168;
        }
        paramString = ((String)localObject).substring(paramInt, m);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Log.println(i, "OkHttp", paramString);
        if (m >= j)
        {
          paramInt = m + 1;
          break;
        }
        paramInt = m;
      }
      label168:
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\UtilKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */