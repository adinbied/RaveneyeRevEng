package kotlin;

import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={"\000\032\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\002\030\002\n\002\b\006\032-\020\000\032\0020\0012\006\020\002\032\0020\0032\022\020\004\032\016\022\004\022\0020\003\022\004\022\0020\0060\005H\bø\001\000¢\006\002\020\007\032\037\020\b\032\0020\0012\n\020\t\032\0020\001\"\0020\006H\bø\001\000¢\006\004\b\n\020\013\002\004\n\002\b\031¨\006\f"}, d2={"UByteArray", "Lkotlin/UByteArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UByte;", "(ILkotlin/jvm/functions/Function1;)[B", "ubyteArrayOf", "elements", "ubyteArrayOf-GBYM_sE", "([B)[B", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class UByteArrayKt
{
  private static final byte[] UByteArray(int paramInt, Function1<? super Integer, UByte> paramFunction1)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      arrayOfByte[i] = ((UByte)paramFunction1.invoke(Integer.valueOf(i))).unbox-impl();
      i += 1;
    }
    return UByteArray.constructor-impl(arrayOfByte);
  }
  
  private static final byte[] ubyteArrayOf-GBYM_sE(byte... paramVarArgs)
  {
    return paramVarArgs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\UByteArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */