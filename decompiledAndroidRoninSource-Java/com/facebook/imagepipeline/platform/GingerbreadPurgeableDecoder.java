package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.MemoryFile;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class GingerbreadPurgeableDecoder
  extends DalvikPurgeableDecoder
{
  private static Method sGetFileDescriptorMethod;
  @Nullable
  private final WebpBitmapFactory mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
  
  /* Error */
  private static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, @Nullable byte[] paramArrayOfByte)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +8 -> 9
    //   4: iconst_0
    //   5: istore_3
    //   6: goto +6 -> 12
    //   9: aload_2
    //   10: arraylength
    //   11: istore_3
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 4
    //   18: new 28	android/os/MemoryFile
    //   21: dup
    //   22: aconst_null
    //   23: iload_3
    //   24: iload_1
    //   25: iadd
    //   26: invokespecial 31	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   29: astore 8
    //   31: aload 8
    //   33: iconst_0
    //   34: invokevirtual 35	android/os/MemoryFile:allowPurging	(Z)Z
    //   37: pop
    //   38: new 37	com/facebook/common/memory/PooledByteBufferInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokevirtual 43	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   46: checkcast 45	com/facebook/common/memory/PooledByteBuffer
    //   49: invokespecial 48	com/facebook/common/memory/PooledByteBufferInputStream:<init>	(Lcom/facebook/common/memory/PooledByteBuffer;)V
    //   52: astore 6
    //   54: new 50	com/facebook/common/streams/LimitedInputStream
    //   57: dup
    //   58: aload 6
    //   60: iload_1
    //   61: invokespecial 53	com/facebook/common/streams/LimitedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   64: astore 5
    //   66: aload 8
    //   68: invokevirtual 57	android/os/MemoryFile:getOutputStream	()Ljava/io/OutputStream;
    //   71: astore 7
    //   73: aload 7
    //   75: astore 4
    //   77: aload 5
    //   79: aload 7
    //   81: invokestatic 63	com/facebook/common/internal/ByteStreams:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   84: pop2
    //   85: aload_2
    //   86: ifnull +17 -> 103
    //   89: aload 7
    //   91: astore 4
    //   93: aload 8
    //   95: aload_2
    //   96: iconst_0
    //   97: iload_1
    //   98: aload_2
    //   99: arraylength
    //   100: invokevirtual 67	android/os/MemoryFile:writeBytes	([BIII)V
    //   103: aload_0
    //   104: invokestatic 71	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   107: aload 6
    //   109: invokestatic 77	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   112: aload 5
    //   114: invokestatic 77	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   117: aload 7
    //   119: iconst_1
    //   120: invokestatic 81	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   123: aload 8
    //   125: areturn
    //   126: astore 7
    //   128: aload 4
    //   130: astore_2
    //   131: aload 7
    //   133: astore 4
    //   135: goto +10 -> 145
    //   138: astore 4
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: astore 5
    //   145: goto +14 -> 159
    //   148: astore 4
    //   150: aconst_null
    //   151: astore_2
    //   152: aload_2
    //   153: astore 5
    //   155: aload 7
    //   157: astore 6
    //   159: aload_0
    //   160: invokestatic 71	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   163: aload 6
    //   165: invokestatic 77	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   168: aload 5
    //   170: invokestatic 77	com/facebook/common/internal/Closeables:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: iconst_1
    //   175: invokestatic 81	com/facebook/common/internal/Closeables:close	(Ljava/io/Closeable;Z)V
    //   178: aload 4
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramCloseableReference	CloseableReference<PooledByteBuffer>
    //   0	181	1	paramInt	int
    //   0	181	2	paramArrayOfByte	byte[]
    //   5	21	3	i	int
    //   16	118	4	localObject1	Object
    //   138	1	4	localObject2	Object
    //   148	31	4	localObject3	Object
    //   64	105	5	localObject4	Object
    //   52	112	6	localObject5	Object
    //   13	105	7	localOutputStream	java.io.OutputStream
    //   126	30	7	localObject6	Object
    //   29	95	8	localMemoryFile	MemoryFile
    // Exception table:
    //   from	to	target	type
    //   66	73	126	finally
    //   77	85	126	finally
    //   93	103	126	finally
    //   54	66	138	finally
    //   38	54	148	finally
  }
  
  /* Error */
  private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: iload_2
    //   8: aload_3
    //   9: invokestatic 89	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:copyToMemoryFile	(Lcom/facebook/common/references/CloseableReference;I[B)Landroid/os/MemoryFile;
    //   12: astore_1
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 93	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:getMemoryFileDescriptor	(Landroid/os/MemoryFile;)Ljava/io/FileDescriptor;
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 21	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:mWebpBitmapFactory	Lcom/facebook/common/webp/WebpBitmapFactory;
    //   23: ifnull +35 -> 58
    //   26: aload_0
    //   27: getfield 21	com/facebook/imagepipeline/platform/GingerbreadPurgeableDecoder:mWebpBitmapFactory	Lcom/facebook/common/webp/WebpBitmapFactory;
    //   30: aload_3
    //   31: aconst_null
    //   32: aload 4
    //   34: invokeinterface 99 4 0
    //   39: ldc 101
    //   41: invokestatic 107	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 109	android/graphics/Bitmap
    //   47: astore_3
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 111	android/os/MemoryFile:close	()V
    //   56: aload_3
    //   57: areturn
    //   58: new 113	java/lang/IllegalStateException
    //   61: dup
    //   62: ldc 115
    //   64: invokespecial 118	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: astore_3
    //   69: aload_1
    //   70: astore 5
    //   72: aload_3
    //   73: astore_1
    //   74: goto +26 -> 100
    //   77: astore_3
    //   78: aload_1
    //   79: astore 5
    //   81: aload_3
    //   82: astore_1
    //   83: goto +12 -> 95
    //   86: astore_1
    //   87: goto +13 -> 100
    //   90: astore_1
    //   91: aload 6
    //   93: astore 5
    //   95: aload_1
    //   96: invokestatic 124	com/facebook/common/internal/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   99: athrow
    //   100: aload 5
    //   102: ifnull +8 -> 110
    //   105: aload 5
    //   107: invokevirtual 111	android/os/MemoryFile:close	()V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	GingerbreadPurgeableDecoder
    //   0	112	1	paramCloseableReference	CloseableReference<PooledByteBuffer>
    //   0	112	2	paramInt	int
    //   0	112	3	paramArrayOfByte	byte[]
    //   0	112	4	paramOptions	BitmapFactory.Options
    //   4	102	5	localObject1	Object
    //   1	91	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	48	68	finally
    //   58	68	68	finally
    //   13	48	77	java/io/IOException
    //   58	68	77	java/io/IOException
    //   6	13	86	finally
    //   95	100	86	finally
    //   6	13	90	java/io/IOException
  }
  
  private Method getFileDescriptorMethod()
  {
    try
    {
      Method localMethod1 = sGetFileDescriptorMethod;
      if (localMethod1 == null) {
        try
        {
          sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
        }
        catch (Exception localException)
        {
          throw Throwables.propagate(localException);
        }
      }
      Method localMethod2 = sGetFileDescriptorMethod;
      return localMethod2;
    }
    finally {}
  }
  
  private FileDescriptor getMemoryFileDescriptor(MemoryFile paramMemoryFile)
  {
    try
    {
      paramMemoryFile = (FileDescriptor)getFileDescriptorMethod().invoke(paramMemoryFile, new Object[0]);
      return paramMemoryFile;
    }
    catch (Exception paramMemoryFile)
    {
      throw Throwables.propagate(paramMemoryFile);
    }
  }
  
  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, ((PooledByteBuffer)paramCloseableReference.get()).size(), null, paramOptions);
  }
  
  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    byte[] arrayOfByte;
    if (endsWithEOI(paramCloseableReference, paramInt)) {
      arrayOfByte = null;
    } else {
      arrayOfByte = EOI;
    }
    return decodeFileDescriptorAsPurgeable(paramCloseableReference, paramInt, arrayOfByte, paramOptions);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\GingerbreadPurgeableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */