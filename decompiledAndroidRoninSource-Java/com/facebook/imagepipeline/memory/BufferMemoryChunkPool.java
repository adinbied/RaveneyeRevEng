package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

public class BufferMemoryChunkPool
  extends MemoryChunkPool
{
  public BufferMemoryChunkPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
  }
  
  protected BufferMemoryChunk alloc(int paramInt)
  {
    return new BufferMemoryChunk(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BufferMemoryChunkPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */