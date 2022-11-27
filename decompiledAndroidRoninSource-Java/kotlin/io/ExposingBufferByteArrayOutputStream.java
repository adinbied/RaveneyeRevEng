package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\022\n\002\b\003\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\005\032\0020\0068F¢\006\006\032\004\b\007\020\b¨\006\t"}, d2={"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "size", "", "(I)V", "buffer", "", "getBuffer", "()[B", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
final class ExposingBufferByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public ExposingBufferByteArrayOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  public final byte[] getBuffer()
  {
    byte[] arrayOfByte = this.buf;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "buf");
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\ExposingBufferByteArrayOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */