package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.memory.PooledByteBufferFactory;

public class EmptyJpegGenerator
{
  private static final byte[] EMPTY_JPEG_PREFIX = { -1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8 };
  private static final byte[] EMPTY_JPEG_SUFFIX = { 3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, -127, -111, -95, 8, 35, 66, -79, -63, 21, 82, -47, -16, 36, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, 35, 51, 82, -16, 21, 98, 114, -47, 10, 22, 36, 52, -31, 37, -15, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, 40, -96, 15, -1, -39 };
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public EmptyJpegGenerator(PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
  }
  
  /* Error */
  public com.facebook.common.references.CloseableReference<com.facebook.common.memory.PooledByteBuffer> generate(short paramShort1, short paramShort2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 196	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:mPooledByteBufferFactory	Lcom/facebook/common/memory/PooledByteBufferFactory;
    //   9: getstatic 21	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:EMPTY_JPEG_PREFIX	[B
    //   12: arraylength
    //   13: getstatic 189	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:EMPTY_JPEG_SUFFIX	[B
    //   16: arraylength
    //   17: iadd
    //   18: iconst_4
    //   19: iadd
    //   20: invokeinterface 206 2 0
    //   25: astore 5
    //   27: aload 5
    //   29: astore_3
    //   30: aload 5
    //   32: astore 4
    //   34: aload 5
    //   36: getstatic 21	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:EMPTY_JPEG_PREFIX	[B
    //   39: invokevirtual 212	com/facebook/common/memory/PooledByteBufferOutputStream:write	([B)V
    //   42: aload 5
    //   44: astore_3
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: iload_2
    //   52: bipush 8
    //   54: ishr
    //   55: i2b
    //   56: invokevirtual 215	com/facebook/common/memory/PooledByteBufferOutputStream:write	(I)V
    //   59: aload 5
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: aload 5
    //   68: iload_2
    //   69: sipush 255
    //   72: iand
    //   73: i2b
    //   74: invokevirtual 215	com/facebook/common/memory/PooledByteBufferOutputStream:write	(I)V
    //   77: aload 5
    //   79: astore_3
    //   80: aload 5
    //   82: astore 4
    //   84: aload 5
    //   86: iload_1
    //   87: bipush 8
    //   89: ishr
    //   90: i2b
    //   91: invokevirtual 215	com/facebook/common/memory/PooledByteBufferOutputStream:write	(I)V
    //   94: aload 5
    //   96: astore_3
    //   97: aload 5
    //   99: astore 4
    //   101: aload 5
    //   103: iload_1
    //   104: sipush 255
    //   107: iand
    //   108: i2b
    //   109: invokevirtual 215	com/facebook/common/memory/PooledByteBufferOutputStream:write	(I)V
    //   112: aload 5
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: getstatic 189	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:EMPTY_JPEG_SUFFIX	[B
    //   124: invokevirtual 212	com/facebook/common/memory/PooledByteBufferOutputStream:write	([B)V
    //   127: aload 5
    //   129: astore_3
    //   130: aload 5
    //   132: astore 4
    //   134: aload 5
    //   136: invokevirtual 219	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
    //   139: invokestatic 225	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    //   142: astore 6
    //   144: aload 5
    //   146: ifnull +8 -> 154
    //   149: aload 5
    //   151: invokevirtual 228	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
    //   154: aload 6
    //   156: areturn
    //   157: astore 4
    //   159: goto +18 -> 177
    //   162: astore 5
    //   164: aload 4
    //   166: astore_3
    //   167: new 230	java/lang/RuntimeException
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 233	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: aload_3
    //   178: ifnull +7 -> 185
    //   181: aload_3
    //   182: invokevirtual 228	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
    //   185: aload 4
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	EmptyJpegGenerator
    //   0	188	1	paramShort1	short
    //   0	188	2	paramShort2	short
    //   4	178	3	localObject1	Object
    //   1	132	4	localObject2	Object
    //   157	29	4	localObject3	Object
    //   25	125	5	localPooledByteBufferOutputStream	com.facebook.common.memory.PooledByteBufferOutputStream
    //   162	10	5	localIOException	java.io.IOException
    //   142	13	6	localCloseableReference	com.facebook.common.references.CloseableReference
    // Exception table:
    //   from	to	target	type
    //   5	27	157	finally
    //   34	42	157	finally
    //   49	59	157	finally
    //   66	77	157	finally
    //   84	94	157	finally
    //   101	112	157	finally
    //   119	127	157	finally
    //   134	144	157	finally
    //   167	177	157	finally
    //   5	27	162	java/io/IOException
    //   34	42	162	java/io/IOException
    //   49	59	162	java/io/IOException
    //   66	77	162	java/io/IOException
    //   84	94	162	java/io/IOException
    //   101	112	162	java/io/IOException
    //   119	127	162	java/io/IOException
    //   134	144	162	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\EmptyJpegGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */