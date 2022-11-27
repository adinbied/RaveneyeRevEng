package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;

public class KitKatPurgeableDecoder
  extends DalvikPurgeableDecoder
{
  private final FlexByteArrayPool mFlexByteArrayPool;
  
  public KitKatPurgeableDecoder(FlexByteArrayPool paramFlexByteArrayPool)
  {
    this.mFlexByteArrayPool = paramFlexByteArrayPool;
  }
  
  private static void putEOI(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = -1;
    paramArrayOfByte[(paramInt + 1)] = -39;
  }
  
  protected Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions)
  {
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
    int i = localPooledByteBuffer.size();
    paramCloseableReference = this.mFlexByteArrayPool.get(i);
    try
    {
      byte[] arrayOfByte = (byte[])paramCloseableReference.get();
      localPooledByteBuffer.read(0, arrayOfByte, 0, i);
      paramOptions = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte, 0, i, paramOptions), "BitmapFactory returned null");
      return paramOptions;
    }
    finally
    {
      CloseableReference.closeSafely(paramCloseableReference);
    }
  }
  
  protected Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions)
  {
    byte[] arrayOfByte1;
    if (endsWithEOI(paramCloseableReference, paramInt)) {
      arrayOfByte1 = null;
    } else {
      arrayOfByte1 = EOI;
    }
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)paramCloseableReference.get();
    boolean bool;
    if (paramInt <= localPooledByteBuffer.size()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    paramCloseableReference = this.mFlexByteArrayPool;
    int j = paramInt + 2;
    paramCloseableReference = paramCloseableReference.get(j);
    try
    {
      byte[] arrayOfByte2 = (byte[])paramCloseableReference.get();
      localPooledByteBuffer.read(0, arrayOfByte2, 0, paramInt);
      int i = paramInt;
      if (arrayOfByte1 != null)
      {
        putEOI(arrayOfByte2, paramInt);
        i = j;
      }
      paramOptions = (Bitmap)Preconditions.checkNotNull(BitmapFactory.decodeByteArray(arrayOfByte2, 0, i, paramOptions), "BitmapFactory returned null");
      return paramOptions;
    }
    finally
    {
      CloseableReference.closeSafely(paramCloseableReference);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\KitKatPurgeableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */