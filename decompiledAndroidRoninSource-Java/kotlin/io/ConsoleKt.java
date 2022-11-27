package kotlin.io;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

@Metadata(bv={1, 0, 3}, d1={"\000n\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\020\000\n\002\020\013\n\002\020\005\n\002\020\f\n\002\020\031\n\002\020\006\n\002\020\007\n\002\020\t\n\002\020\n\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\032\023\020\t\032\0020\n2\b\020\013\032\004\030\0010\fH\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\rH\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\016H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\017H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\020H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\021H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\022H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\001H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\023H\b\032\021\020\t\032\0020\n2\006\020\013\032\0020\024H\b\032\t\020\025\032\0020\nH\b\032\023\020\025\032\0020\n2\b\020\013\032\004\030\0010\fH\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\rH\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\016H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\017H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\020H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\021H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\022H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\001H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\023H\b\032\021\020\025\032\0020\n2\006\020\013\032\0020\024H\b\032\b\020\026\032\004\030\0010\027\032\032\020\026\032\004\030\0010\0272\006\020\030\032\0020\0312\006\020\003\032\0020\004H\000\032\f\020\032\032\0020\r*\0020\033H\002\032\f\020\034\032\0020\n*\0020\035H\002\032\030\020\036\032\0020\n*\0020\0332\n\020\037\032\0060 j\002`!H\002\032$\020\"\032\0020\r*\0020\0042\006\020#\032\0020$2\006\020%\032\0020\0332\006\020&\032\0020\rH\002\"\016\020\000\032\0020\001XT¢\006\002\n\000\"\016\020\002\032\0020\001XT¢\006\002\n\000\"\033\020\003\032\0020\0048BX\002¢\006\f\n\004\b\007\020\b\032\004\b\005\020\006¨\006'"}, d2={"BUFFER_SIZE", "", "LINE_SEPARATOR_MAX_LENGTH", "decoder", "Ljava/nio/charset/CharsetDecoder;", "getDecoder", "()Ljava/nio/charset/CharsetDecoder;", "decoder$delegate", "Lkotlin/Lazy;", "print", "", "message", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "inputStream", "Ljava/io/InputStream;", "endsWithLineSeparator", "Ljava/nio/CharBuffer;", "flipBack", "Ljava/nio/Buffer;", "offloadPrefixTo", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tryDecode", "byteBuffer", "Ljava/nio/ByteBuffer;", "charBuffer", "isEndOfStream", "kotlin-stdlib"}, k=2, mv={1, 1, 15})
public final class ConsoleKt
{
  private static final int BUFFER_SIZE = 32;
  private static final int LINE_SEPARATOR_MAX_LENGTH = 2;
  private static final Lazy decoder$delegate = LazyKt.lazy((Function0)decoder.2.INSTANCE);
  
  private static final boolean endsWithLineSeparator(CharBuffer paramCharBuffer)
  {
    int i = paramCharBuffer.position();
    return (i > 0) && (paramCharBuffer.get(i - 1) == '\n');
  }
  
  private static final void flipBack(Buffer paramBuffer)
  {
    paramBuffer.position(paramBuffer.limit());
    paramBuffer.limit(paramBuffer.capacity());
  }
  
  private static final CharsetDecoder getDecoder()
  {
    Lazy localLazy = decoder$delegate;
    KProperty localKProperty = $$delegatedProperties[0];
    return (CharsetDecoder)localLazy.getValue();
  }
  
  private static final void offloadPrefixTo(CharBuffer paramCharBuffer, StringBuilder paramStringBuilder)
  {
    paramCharBuffer.flip();
    int j = paramCharBuffer.limit();
    int i = 0;
    while (i < j - 1)
    {
      paramStringBuilder.append(paramCharBuffer.get());
      i += 1;
    }
    paramCharBuffer.compact();
  }
  
  private static final void print(byte paramByte)
  {
    System.out.print(Byte.valueOf(paramByte));
  }
  
  private static final void print(char paramChar)
  {
    System.out.print(paramChar);
  }
  
  private static final void print(double paramDouble)
  {
    System.out.print(paramDouble);
  }
  
  private static final void print(float paramFloat)
  {
    System.out.print(paramFloat);
  }
  
  private static final void print(int paramInt)
  {
    System.out.print(paramInt);
  }
  
  private static final void print(long paramLong)
  {
    System.out.print(paramLong);
  }
  
  private static final void print(Object paramObject)
  {
    System.out.print(paramObject);
  }
  
  private static final void print(short paramShort)
  {
    System.out.print(Short.valueOf(paramShort));
  }
  
  private static final void print(boolean paramBoolean)
  {
    System.out.print(paramBoolean);
  }
  
  private static final void print(char[] paramArrayOfChar)
  {
    System.out.print(paramArrayOfChar);
  }
  
  private static final void println()
  {
    System.out.println();
  }
  
  private static final void println(byte paramByte)
  {
    System.out.println(Byte.valueOf(paramByte));
  }
  
  private static final void println(char paramChar)
  {
    System.out.println(paramChar);
  }
  
  private static final void println(double paramDouble)
  {
    System.out.println(paramDouble);
  }
  
  private static final void println(float paramFloat)
  {
    System.out.println(paramFloat);
  }
  
  private static final void println(int paramInt)
  {
    System.out.println(paramInt);
  }
  
  private static final void println(long paramLong)
  {
    System.out.println(paramLong);
  }
  
  private static final void println(Object paramObject)
  {
    System.out.println(paramObject);
  }
  
  private static final void println(short paramShort)
  {
    System.out.println(Short.valueOf(paramShort));
  }
  
  private static final void println(boolean paramBoolean)
  {
    System.out.println(paramBoolean);
  }
  
  private static final void println(char[] paramArrayOfChar)
  {
    System.out.println(paramArrayOfChar);
  }
  
  public static final String readLine()
  {
    InputStream localInputStream = System.in;
    Intrinsics.checkExpressionValueIsNotNull(localInputStream, "System.`in`");
    return readLine(localInputStream, getDecoder());
  }
  
  public static final String readLine(InputStream paramInputStream, CharsetDecoder paramCharsetDecoder)
  {
    Intrinsics.checkParameterIsNotNull(paramInputStream, "inputStream");
    Intrinsics.checkParameterIsNotNull(paramCharsetDecoder, "decoder");
    float f1 = paramCharsetDecoder.maxCharsPerByte();
    float f2 = 1;
    int j = 0;
    int i;
    if (f1 <= f2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(32);
      CharBuffer localCharBuffer = CharBuffer.allocate(4);
      StringBuilder localStringBuilder = new StringBuilder();
      int k = paramInputStream.read();
      i = k;
      if (k == -1) {
        return null;
      }
      do
      {
        localByteBuffer.put((byte)i);
        Intrinsics.checkExpressionValueIsNotNull(localByteBuffer, "byteBuffer");
        Intrinsics.checkExpressionValueIsNotNull(localCharBuffer, "charBuffer");
        if (tryDecode(paramCharsetDecoder, localByteBuffer, localCharBuffer, false))
        {
          if (endsWithLineSeparator(localCharBuffer)) {
            break;
          }
          if (localCharBuffer.remaining() < 2) {
            offloadPrefixTo(localCharBuffer, localStringBuilder);
          }
        }
        k = paramInputStream.read();
        i = k;
      } while (k != -1);
      tryDecode(paramCharsetDecoder, localByteBuffer, localCharBuffer, true);
      paramCharsetDecoder.reset();
      k = localCharBuffer.position();
      i = k;
      if (k > 0)
      {
        i = k;
        if (localCharBuffer.get(k - 1) == '\n')
        {
          k -= 1;
          i = k;
          if (k > 0)
          {
            i = k;
            if (localCharBuffer.get(k - 1) == '\r') {
              i = k - 1;
            }
          }
        }
      }
      localCharBuffer.flip();
      while (j < i)
      {
        localStringBuilder.append(localCharBuffer.get());
        j += 1;
      }
      return localStringBuilder.toString();
    }
    throw ((Throwable)new IllegalArgumentException("Encodings with multiple chars per byte are not supported".toString()));
  }
  
  private static final boolean tryDecode(CharsetDecoder paramCharsetDecoder, ByteBuffer paramByteBuffer, CharBuffer paramCharBuffer, boolean paramBoolean)
  {
    int i = paramCharBuffer.position();
    paramByteBuffer.flip();
    paramCharsetDecoder = paramCharsetDecoder.decode(paramByteBuffer, paramCharBuffer, paramBoolean);
    if (paramCharsetDecoder.isError()) {
      paramCharsetDecoder.throwException();
    }
    if (paramCharBuffer.position() > i) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      paramByteBuffer.clear();
      return paramBoolean;
    }
    flipBack((Buffer)paramByteBuffer);
    return paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\io\ConsoleKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */