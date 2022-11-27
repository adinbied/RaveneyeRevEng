package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;

public class MemoryPooledByteBufferFactory
  implements PooledByteBufferFactory
{
  private final MemoryChunkPool mPool;
  private final PooledByteStreams mPooledByteStreams;
  
  public MemoryPooledByteBufferFactory(MemoryChunkPool paramMemoryChunkPool, PooledByteStreams paramPooledByteStreams)
  {
    this.mPool = paramMemoryChunkPool;
    this.mPooledByteStreams = paramPooledByteStreams;
  }
  
  MemoryPooledByteBuffer newByteBuf(InputStream paramInputStream, MemoryPooledByteBufferOutputStream paramMemoryPooledByteBufferOutputStream)
    throws IOException
  {
    this.mPooledByteStreams.copy(paramInputStream, paramMemoryPooledByteBufferOutputStream);
    return paramMemoryPooledByteBufferOutputStream.toByteBuffer();
  }
  
  public MemoryPooledByteBuffer newByteBuffer(int paramInt)
  {
    boolean bool;
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    CloseableReference localCloseableReference = CloseableReference.of(this.mPool.get(paramInt), this.mPool);
    try
    {
      MemoryPooledByteBuffer localMemoryPooledByteBuffer = new MemoryPooledByteBuffer(localCloseableReference, paramInt);
      return localMemoryPooledByteBuffer;
    }
    finally
    {
      localCloseableReference.close();
    }
  }
  
  public MemoryPooledByteBuffer newByteBuffer(InputStream paramInputStream)
    throws IOException
  {
    MemoryPooledByteBufferOutputStream localMemoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localMemoryPooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localMemoryPooledByteBufferOutputStream.close();
    }
  }
  
  public MemoryPooledByteBuffer newByteBuffer(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    MemoryPooledByteBufferOutputStream localMemoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, paramInt);
    try
    {
      paramInputStream = newByteBuf(paramInputStream, localMemoryPooledByteBufferOutputStream);
      return paramInputStream;
    }
    finally
    {
      localMemoryPooledByteBufferOutputStream.close();
    }
  }
  
  /* Error */
  public MemoryPooledByteBuffer newByteBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 32	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 17	com/facebook/imagepipeline/memory/MemoryPooledByteBufferFactory:mPool	Lcom/facebook/imagepipeline/memory/MemoryChunkPool;
    //   8: aload_1
    //   9: arraylength
    //   10: invokespecial 89	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream:<init>	(Lcom/facebook/imagepipeline/memory/MemoryChunkPool;I)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: iconst_0
    //   17: aload_1
    //   18: arraylength
    //   19: invokevirtual 93	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream:write	([BII)V
    //   22: aload_2
    //   23: invokevirtual 36	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/imagepipeline/memory/MemoryPooledByteBuffer;
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 86	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream:close	()V
    //   31: aload_1
    //   32: areturn
    //   33: astore_1
    //   34: goto +9 -> 43
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 99	com/facebook/common/internal/Throwables:propagate	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   42: athrow
    //   43: aload_2
    //   44: invokevirtual 86	com/facebook/imagepipeline/memory/MemoryPooledByteBufferOutputStream:close	()V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	MemoryPooledByteBufferFactory
    //   0	49	1	paramArrayOfByte	byte[]
    //   13	31	2	localMemoryPooledByteBufferOutputStream	MemoryPooledByteBufferOutputStream
    // Exception table:
    //   from	to	target	type
    //   14	27	33	finally
    //   38	43	33	finally
    //   14	27	37	java/io/IOException
  }
  
  public MemoryPooledByteBufferOutputStream newOutputStream()
  {
    return new MemoryPooledByteBufferOutputStream(this.mPool);
  }
  
  public MemoryPooledByteBufferOutputStream newOutputStream(int paramInt)
  {
    return new MemoryPooledByteBufferOutputStream(this.mPool, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\MemoryPooledByteBufferFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */