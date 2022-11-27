package okio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv={1, 0, 3}, d1={"\0000\n\002\b\003\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\022\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\032*\020\000\032\002H\001\"\004\b\000\020\0012\006\020\002\032\0020\0032\f\020\004\032\b\022\004\022\002H\0010\005H\b¢\006\002\020\006\032\f\020\007\032\0020\b*\0020\tH\000\032\f\020\n\032\0020\t*\0020\bH\000*\n\020\013\"\0020\f2\0020\f*\n\020\r\"\0020\0162\0020\016*\n\020\017\"\0020\0202\0020\020¨\006\021"}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "EOFException", "Ljava/io/EOFException;", "IOException", "Ljava/io/IOException;", "okio"}, k=2, mv={1, 1, 16})
public final class -Platform
{
  public static final byte[] asUtf8ToByteArray(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$asUtf8ToByteArray");
    paramString = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
    return paramString;
  }
  
  public static final <R> R jdMethod_synchronized(Object paramObject, Function0<? extends R> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "lock");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    try
    {
      paramFunction0 = paramFunction0.invoke();
      return paramFunction0;
    }
    finally
    {
      InlineMarker.finallyStart(1);
      InlineMarker.finallyEnd(1);
    }
  }
  
  public static final String toUtf8String(byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toUtf8String");
    return new String(paramArrayOfByte, Charsets.UTF_8);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\-Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */