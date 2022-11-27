package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class BufferMemoryChunk
  implements MemoryChunk, Closeable
{
  private static final String TAG = "BufferMemoryChunk";
  private ByteBuffer mBuffer;
  private final long mId;
  private final int mSize;
  
  public BufferMemoryChunk(int paramInt)
  {
    this.mBuffer = ByteBuffer.allocateDirect(paramInt);
    this.mSize = paramInt;
    this.mId = System.identityHashCode(this);
  }
  
  private void doCopy(int paramInt1, MemoryChunk paramMemoryChunk, int paramInt2, int paramInt3)
  {
    if ((paramMemoryChunk instanceof BufferMemoryChunk))
    {
      Preconditions.checkState(isClosed() ^ true);
      Preconditions.checkState(paramMemoryChunk.isClosed() ^ true);
      MemoryChunkUtil.checkBounds(paramInt1, paramMemoryChunk.getSize(), paramInt2, paramInt3, this.mSize);
      this.mBuffer.position(paramInt1);
      paramMemoryChunk.getByteBuffer().position(paramInt2);
      byte[] arrayOfByte = new byte[paramInt3];
      this.mBuffer.get(arrayOfByte, 0, paramInt3);
      paramMemoryChunk.getByteBuffer().put(arrayOfByte, 0, paramInt3);
      return;
    }
    throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
  }
  
  public void close()
  {
    try
    {
      this.mBuffer = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void copy(int paramInt1, MemoryChunk paramMemoryChunk, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 93	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: invokeinterface 97 1 0
    //   11: aload_0
    //   12: invokevirtual 98	com/facebook/imagepipeline/memory/BufferMemoryChunk:getUniqueId	()J
    //   15: lcmp
    //   16: ifne +79 -> 95
    //   19: new 100	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 103
    //   32: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: aload_0
    //   39: invokevirtual 98	com/facebook/imagepipeline/memory/BufferMemoryChunk:getUniqueId	()J
    //   42: invokestatic 113	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   45: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: ldc 115
    //   53: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: aload_2
    //   60: invokeinterface 97 1 0
    //   65: invokestatic 113	java/lang/Long:toHexString	(J)Ljava/lang/String;
    //   68: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: ldc 117
    //   76: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 12
    //   82: aload 5
    //   84: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 127	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: iconst_0
    //   92: invokestatic 130	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
    //   95: aload_2
    //   96: invokeinterface 97 1 0
    //   101: aload_0
    //   102: invokevirtual 98	com/facebook/imagepipeline/memory/BufferMemoryChunk:getUniqueId	()J
    //   105: lcmp
    //   106: ifge +35 -> 141
    //   109: aload_2
    //   110: monitorenter
    //   111: aload_0
    //   112: monitorenter
    //   113: aload_0
    //   114: iload_1
    //   115: aload_2
    //   116: iload_3
    //   117: iload 4
    //   119: invokespecial 132	com/facebook/imagepipeline/memory/BufferMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/MemoryChunk;II)V
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_2
    //   125: monitorexit
    //   126: return
    //   127: astore 5
    //   129: aload_0
    //   130: monitorexit
    //   131: aload 5
    //   133: athrow
    //   134: astore 5
    //   136: aload_2
    //   137: monitorexit
    //   138: aload 5
    //   140: athrow
    //   141: aload_0
    //   142: monitorenter
    //   143: aload_2
    //   144: monitorenter
    //   145: aload_0
    //   146: iload_1
    //   147: aload_2
    //   148: iload_3
    //   149: iload 4
    //   151: invokespecial 132	com/facebook/imagepipeline/memory/BufferMemoryChunk:doCopy	(ILcom/facebook/imagepipeline/memory/MemoryChunk;II)V
    //   154: aload_2
    //   155: monitorexit
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: astore 5
    //   161: aload_2
    //   162: monitorexit
    //   163: aload 5
    //   165: athrow
    //   166: astore_2
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_2
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	BufferMemoryChunk
    //   0	171	1	paramInt1	int
    //   0	171	2	paramMemoryChunk	MemoryChunk
    //   0	171	3	paramInt2	int
    //   0	171	4	paramInt3	int
    //   26	57	5	localStringBuilder	StringBuilder
    //   127	5	5	localObject1	Object
    //   134	5	5	localObject2	Object
    //   159	5	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   113	124	127	finally
    //   129	131	127	finally
    //   111	113	134	finally
    //   124	126	134	finally
    //   131	134	134	finally
    //   136	138	134	finally
    //   145	156	159	finally
    //   161	163	159	finally
    //   143	145	166	finally
    //   156	158	166	finally
    //   163	166	166	finally
    //   167	169	166	finally
  }
  
  @Nullable
  public ByteBuffer getByteBuffer()
  {
    try
    {
      ByteBuffer localByteBuffer = this.mBuffer;
      return localByteBuffer;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getNativePtr()
  {
    throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public long getUniqueId()
  {
    return this.mId;
  }
  
  public boolean isClosed()
  {
    try
    {
      ByteBuffer localByteBuffer = this.mBuffer;
      boolean bool;
      if (localByteBuffer == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public byte read(int paramInt)
  {
    for (;;)
    {
      try
      {
        bool1 = isClosed();
        boolean bool2 = true;
        if (!bool1)
        {
          bool1 = true;
          Preconditions.checkState(bool1);
          if (paramInt < 0) {
            break label79;
          }
          bool1 = true;
          Preconditions.checkArgument(bool1);
          if (paramInt >= this.mSize) {
            break label84;
          }
          bool1 = bool2;
          Preconditions.checkArgument(bool1);
          byte b = this.mBuffer.get(paramInt);
          return b;
        }
      }
      finally {}
      boolean bool1 = false;
      continue;
      label79:
      bool1 = false;
      continue;
      label84:
      bool1 = false;
    }
  }
  
  public int read(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        Preconditions.checkNotNull(paramArrayOfByte);
        if (!isClosed())
        {
          bool = true;
          Preconditions.checkState(bool);
          paramInt3 = MemoryChunkUtil.adjustByteCount(paramInt1, paramInt3, this.mSize);
          MemoryChunkUtil.checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, paramInt3, this.mSize);
          this.mBuffer.position(paramInt1);
          this.mBuffer.get(paramArrayOfByte, paramInt2, paramInt3);
          return paramInt3;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public int write(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        Preconditions.checkNotNull(paramArrayOfByte);
        if (!isClosed())
        {
          bool = true;
          Preconditions.checkState(bool);
          paramInt3 = MemoryChunkUtil.adjustByteCount(paramInt1, paramInt3, this.mSize);
          MemoryChunkUtil.checkBounds(paramInt1, paramArrayOfByte.length, paramInt2, paramInt3, this.mSize);
          this.mBuffer.position(paramInt1);
          this.mBuffer.put(paramArrayOfByte, paramInt2, paramInt3);
          return paramInt3;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BufferMemoryChunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */