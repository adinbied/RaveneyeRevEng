package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\025\n\000\n\002\020\022\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\b\n\002\b\004\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\bÆ\002\030\0002\0020\001:\001\032B\007\b\002¢\006\002\020\002J \020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\f2\006\020\016\032\0020\fH\002J\036\020\017\032\0020\n2\006\020\020\032\0020\0212\006\020\022\032\0020\0232\006\020\024\032\0020\025J\026\020\026\032\0020\n2\006\020\020\032\0020\0272\006\020\024\032\0020\025J\016\020\030\032\0020\f2\006\020\031\032\0020\027R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\004¢\006\002\n\000¨\006\033"}, d2={"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, k=1, mv={1, 1, 16})
public final class Huffman
{
  private static final int[] CODES;
  private static final byte[] CODE_BIT_COUNTS;
  public static final Huffman INSTANCE;
  private static final Node root;
  
  static
  {
    Huffman localHuffman = new Huffman();
    INSTANCE = localHuffman;
    CODES = new int[] { 8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846 };
    CODE_BIT_COUNTS = new byte[] { 13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26 };
    root = new Node();
    int j = CODE_BIT_COUNTS.length;
    int i = 0;
    while (i < j)
    {
      localHuffman.addCode(i, CODES[i], CODE_BIT_COUNTS[i]);
      i += 1;
    }
  }
  
  private final void addCode(int paramInt1, int paramInt2, int paramInt3)
  {
    Node localNode2 = new Node(paramInt1, paramInt3);
    Object localObject = root;
    while (paramInt3 > 8)
    {
      paramInt3 -= 8;
      paramInt1 = paramInt2 >>> paramInt3 & 0xFF;
      Node[] arrayOfNode = ((Node)localObject).getChildren();
      if (arrayOfNode == null) {
        Intrinsics.throwNpe();
      }
      Node localNode1 = arrayOfNode[paramInt1];
      localObject = localNode1;
      if (localNode1 == null)
      {
        localObject = new Node();
        arrayOfNode[paramInt1] = localObject;
      }
    }
    paramInt1 = 8 - paramInt3;
    paramInt2 = paramInt2 << paramInt1 & 0xFF;
    localObject = ((Node)localObject).getChildren();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ArraysKt.fill((Object[])localObject, localNode2, paramInt2, (1 << paramInt1) + paramInt2);
  }
  
  public final void decode(BufferedSource paramBufferedSource, long paramLong, BufferedSink paramBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    Object localObject1 = root;
    int j = 0;
    long l = 0L;
    int i = 0;
    Object localObject2;
    int k;
    for (;;)
    {
      localObject2 = localObject1;
      k = i;
      if (l >= paramLong) {
        break;
      }
      j = j << 8 | Util.and(paramBufferedSource.readByte(), 255);
      i += 8;
      while (i >= 8)
      {
        k = i - 8;
        localObject1 = ((Node)localObject1).getChildren();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = localObject1[(j >>> k & 0xFF)];
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        if (((Node)localObject1).getChildren() == null)
        {
          paramBufferedSink.writeByte(((Node)localObject1).getSymbol());
          i -= ((Node)localObject1).getTerminalBitCount();
          localObject1 = root;
        }
        else
        {
          i = k;
        }
      }
      l += 1L;
    }
    while (k > 0)
    {
      paramBufferedSource = ((Node)localObject2).getChildren();
      if (paramBufferedSource == null) {
        Intrinsics.throwNpe();
      }
      paramBufferedSource = paramBufferedSource[(j << 8 - k & 0xFF)];
      if (paramBufferedSource == null) {
        Intrinsics.throwNpe();
      }
      if (paramBufferedSource.getChildren() != null) {
        break;
      }
      if (paramBufferedSource.getTerminalBitCount() > k) {
        return;
      }
      paramBufferedSink.writeByte(paramBufferedSource.getSymbol());
      k -= paramBufferedSource.getTerminalBitCount();
      localObject2 = root;
    }
  }
  
  public final void encode(ByteString paramByteString, BufferedSink paramBufferedSink)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "source");
    Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
    int k = paramByteString.size();
    int j = 0;
    long l = 0L;
    int i = 0;
    while (j < k)
    {
      int n = Util.and(paramByteString.getByte(j), 255);
      int m = CODES[n];
      n = CODE_BIT_COUNTS[n];
      l = l << n | m;
      i += n;
      while (i >= 8)
      {
        i -= 8;
        paramBufferedSink.writeByte((int)(l >> i));
      }
      j += 1;
    }
    if (i > 0) {
      paramBufferedSink.writeByte((int)(l << 8 - i | 255L >>> i));
    }
  }
  
  public final int encodedLength(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    int j = paramByteString.size();
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      int k = Util.and(paramByteString.getByte(i), 255);
      l += CODE_BIT_COUNTS[k];
      i += 1;
    }
    return (int)(l + 7 >> 3);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\003\n\002\020\021\n\002\b\b\b\002\030\0002\0020\001B\007\b\026¢\006\002\020\002B\027\b\026\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004¢\006\002\020\006R\035\020\007\032\f\022\006\022\004\030\0010\000\030\0010\b¢\006\n\n\002\020\013\032\004\b\t\020\nR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\f\020\rR\021\020\016\032\0020\004¢\006\b\n\000\032\004\b\017\020\r¨\006\020"}, d2={"Lokhttp3/internal/http2/Huffman$Node;", "", "()V", "symbol", "", "bits", "(II)V", "children", "", "getChildren", "()[Lokhttp3/internal/http2/Huffman$Node;", "[Lokhttp3/internal/http2/Huffman$Node;", "getSymbol", "()I", "terminalBitCount", "getTerminalBitCount", "okhttp"}, k=1, mv={1, 1, 16})
  private static final class Node
  {
    private final Node[] children;
    private final int symbol;
    private final int terminalBitCount;
    
    public Node()
    {
      this.children = new Node['Ā'];
      this.symbol = 0;
      this.terminalBitCount = 0;
    }
    
    public Node(int paramInt1, int paramInt2)
    {
      this.children = ((Node[])null);
      this.symbol = paramInt1;
      paramInt2 &= 0x7;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = 8;
      }
      this.terminalBitCount = paramInt1;
    }
    
    public final Node[] getChildren()
    {
      return this.children;
    }
    
    public final int getSymbol()
    {
      return this.symbol;
    }
    
    public final int getTerminalBitCount()
    {
      return this.terminalBitCount;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Huffman.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */