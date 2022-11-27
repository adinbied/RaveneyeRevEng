package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;

public class EncodedImage
  implements Closeable
{
  public static final int DEFAULT_SAMPLE_SIZE = 1;
  public static final int UNKNOWN_HEIGHT = -1;
  public static final int UNKNOWN_ROTATION_ANGLE = -1;
  public static final int UNKNOWN_STREAM_SIZE = -1;
  public static final int UNKNOWN_WIDTH = -1;
  @Nullable
  private BytesRange mBytesRange;
  @Nullable
  private ColorSpace mColorSpace;
  private int mExifOrientation = 0;
  private int mHeight = -1;
  private ImageFormat mImageFormat = ImageFormat.UNKNOWN;
  @Nullable
  private final Supplier<FileInputStream> mInputStreamSupplier;
  @Nullable
  private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
  private int mRotationAngle = -1;
  private int mSampleSize = 1;
  private int mStreamSize = -1;
  private int mWidth = -1;
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier)
  {
    Preconditions.checkNotNull(paramSupplier);
    this.mPooledByteBufferRef = null;
    this.mInputStreamSupplier = paramSupplier;
  }
  
  public EncodedImage(Supplier<FileInputStream> paramSupplier, int paramInt)
  {
    this(paramSupplier);
    this.mStreamSize = paramInt;
  }
  
  public EncodedImage(CloseableReference<PooledByteBuffer> paramCloseableReference)
  {
    Preconditions.checkArgument(CloseableReference.isValid(paramCloseableReference));
    this.mPooledByteBufferRef = paramCloseableReference.clone();
    this.mInputStreamSupplier = null;
  }
  
  @Nullable
  public static EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      return paramEncodedImage.cloneOrNull();
    }
    return null;
  }
  
  public static void closeSafely(@Nullable EncodedImage paramEncodedImage)
  {
    if (paramEncodedImage != null) {
      paramEncodedImage.close();
    }
  }
  
  public static boolean isMetaDataAvailable(EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage.mRotationAngle >= 0) && (paramEncodedImage.mWidth >= 0) && (paramEncodedImage.mHeight >= 0);
  }
  
  public static boolean isValid(@Nullable EncodedImage paramEncodedImage)
  {
    return (paramEncodedImage != null) && (paramEncodedImage.isValid());
  }
  
  private void parseMetaDataIfNeeded()
  {
    if ((this.mWidth < 0) || (this.mHeight < 0)) {
      parseMetaData();
    }
  }
  
  /* Error */
  private ImageMetaData readImageMetaData()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 119	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
    //   4: astore_2
    //   5: aload_2
    //   6: invokestatic 125	com/facebook/imageutils/BitmapUtil:decodeDimensionsAndColorSpace	(Ljava/io/InputStream;)Lcom/facebook/imageutils/ImageMetaData;
    //   9: astore_1
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 131	com/facebook/imageutils/ImageMetaData:getColorSpace	()Landroid/graphics/ColorSpace;
    //   15: putfield 133	com/facebook/imagepipeline/image/EncodedImage:mColorSpace	Landroid/graphics/ColorSpace;
    //   18: aload_1
    //   19: invokevirtual 137	com/facebook/imageutils/ImageMetaData:getDimensions	()Landroid/util/Pair;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +31 -> 55
    //   27: aload_0
    //   28: aload_3
    //   29: getfield 143	android/util/Pair:first	Ljava/lang/Object;
    //   32: checkcast 145	java/lang/Integer
    //   35: invokevirtual 149	java/lang/Integer:intValue	()I
    //   38: putfield 51	com/facebook/imagepipeline/image/EncodedImage:mWidth	I
    //   41: aload_0
    //   42: aload_3
    //   43: getfield 152	android/util/Pair:second	Ljava/lang/Object;
    //   46: checkcast 145	java/lang/Integer
    //   49: invokevirtual 149	java/lang/Integer:intValue	()I
    //   52: putfield 53	com/facebook/imagepipeline/image/EncodedImage:mHeight	I
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 155	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_1
    //   66: goto +6 -> 72
    //   69: astore_1
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull +7 -> 80
    //   76: aload_2
    //   77: invokevirtual 155	java/io/InputStream:close	()V
    //   80: aload_1
    //   81: athrow
    //   82: astore_2
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: goto -6 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	EncodedImage
    //   9	55	1	localImageMetaData1	ImageMetaData
    //   65	1	1	localObject	Object
    //   69	15	1	localImageMetaData2	ImageMetaData
    //   4	73	2	localInputStream	InputStream
    //   82	1	2	localIOException1	java.io.IOException
    //   85	1	2	localIOException2	java.io.IOException
    //   22	21	3	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   5	23	65	finally
    //   27	55	65	finally
    //   0	5	69	finally
    //   59	63	82	java/io/IOException
    //   76	80	85	java/io/IOException
  }
  
  private Pair<Integer, Integer> readWebPImageSize()
  {
    Pair localPair = WebpUtil.getSize(getInputStream());
    if (localPair != null)
    {
      this.mWidth = ((Integer)localPair.first).intValue();
      this.mHeight = ((Integer)localPair.second).intValue();
    }
    return localPair;
  }
  
  @Nullable
  public EncodedImage cloneOrNull()
  {
    Object localObject1 = this.mInputStreamSupplier;
    CloseableReference localCloseableReference;
    if (localObject1 != null)
    {
      localObject1 = new EncodedImage((Supplier)localObject1, this.mStreamSize);
    }
    else
    {
      localCloseableReference = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
      if (localCloseableReference == null) {
        localObject1 = null;
      }
    }
    try
    {
      localObject1 = new EncodedImage(localCloseableReference);
      CloseableReference.closeSafely(localCloseableReference);
      if (localObject1 != null) {
        ((EncodedImage)localObject1).copyMetaDataFrom(this);
      }
      return (EncodedImage)localObject1;
    }
    finally
    {
      CloseableReference.closeSafely(localCloseableReference);
    }
  }
  
  public void close()
  {
    CloseableReference.closeSafely(this.mPooledByteBufferRef);
  }
  
  public void copyMetaDataFrom(EncodedImage paramEncodedImage)
  {
    this.mImageFormat = paramEncodedImage.getImageFormat();
    this.mWidth = paramEncodedImage.getWidth();
    this.mHeight = paramEncodedImage.getHeight();
    this.mRotationAngle = paramEncodedImage.getRotationAngle();
    this.mExifOrientation = paramEncodedImage.getExifOrientation();
    this.mSampleSize = paramEncodedImage.getSampleSize();
    this.mStreamSize = paramEncodedImage.getSize();
    this.mBytesRange = paramEncodedImage.getBytesRange();
    this.mColorSpace = paramEncodedImage.getColorSpace();
  }
  
  public CloseableReference<PooledByteBuffer> getByteBufferRef()
  {
    return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
  }
  
  @Nullable
  public BytesRange getBytesRange()
  {
    return this.mBytesRange;
  }
  
  @Nullable
  public ColorSpace getColorSpace()
  {
    parseMetaDataIfNeeded();
    return this.mColorSpace;
  }
  
  public int getExifOrientation()
  {
    parseMetaDataIfNeeded();
    return this.mExifOrientation;
  }
  
  public String getFirstBytesAsHexString(int paramInt)
  {
    Object localObject1 = getByteBufferRef();
    if (localObject1 == null) {
      return "";
    }
    int i = Math.min(getSize(), paramInt);
    byte[] arrayOfByte = new byte[i];
    try
    {
      PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)((CloseableReference)localObject1).get();
      if (localPooledByteBuffer == null) {
        return "";
      }
      localPooledByteBuffer.read(0, arrayOfByte, 0, i);
      ((CloseableReference)localObject1).close();
      localObject1 = new StringBuilder(i * 2);
      paramInt = 0;
      while (paramInt < i)
      {
        ((StringBuilder)localObject1).append(String.format("%02X", new Object[] { Byte.valueOf(arrayOfByte[paramInt]) }));
        paramInt += 1;
      }
      return ((StringBuilder)localObject1).toString();
    }
    finally
    {
      ((CloseableReference)localObject1).close();
    }
  }
  
  public int getHeight()
  {
    parseMetaDataIfNeeded();
    return this.mHeight;
  }
  
  public ImageFormat getImageFormat()
  {
    parseMetaDataIfNeeded();
    return this.mImageFormat;
  }
  
  @Nullable
  public InputStream getInputStream()
  {
    Object localObject1 = this.mInputStreamSupplier;
    if (localObject1 != null) {
      return (InputStream)((Supplier)localObject1).get();
    }
    localObject1 = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    if (localObject1 != null) {
      try
      {
        PooledByteBufferInputStream localPooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer)((CloseableReference)localObject1).get());
        return localPooledByteBufferInputStream;
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject1);
      }
    }
    return null;
  }
  
  public int getRotationAngle()
  {
    parseMetaDataIfNeeded();
    return this.mRotationAngle;
  }
  
  public int getSampleSize()
  {
    return this.mSampleSize;
  }
  
  public int getSize()
  {
    CloseableReference localCloseableReference = this.mPooledByteBufferRef;
    if ((localCloseableReference != null) && (localCloseableReference.get() != null)) {
      return ((PooledByteBuffer)this.mPooledByteBufferRef.get()).size();
    }
    return this.mStreamSize;
  }
  
  @Nullable
  public SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly()
  {
    try
    {
      SharedReference localSharedReference;
      if (this.mPooledByteBufferRef != null) {
        localSharedReference = this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly();
      } else {
        localSharedReference = null;
      }
      return localSharedReference;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getWidth()
  {
    parseMetaDataIfNeeded();
    return this.mWidth;
  }
  
  public boolean isCompleteAt(int paramInt)
  {
    if ((this.mImageFormat != DefaultImageFormats.JPEG) && (this.mImageFormat != DefaultImageFormats.DNG)) {
      return true;
    }
    if (this.mInputStreamSupplier != null) {
      return true;
    }
    Preconditions.checkNotNull(this.mPooledByteBufferRef);
    PooledByteBuffer localPooledByteBuffer = (PooledByteBuffer)this.mPooledByteBufferRef.get();
    return (localPooledByteBuffer.read(paramInt - 2) == -1) && (localPooledByteBuffer.read(paramInt - 1) == -39);
  }
  
  public boolean isValid()
  {
    try
    {
      if (!CloseableReference.isValid(this.mPooledByteBufferRef))
      {
        Supplier localSupplier = this.mInputStreamSupplier;
        if (localSupplier == null)
        {
          bool = false;
          break label31;
        }
      }
      boolean bool = true;
      label31:
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void parseMetaData()
  {
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
    this.mImageFormat = localImageFormat;
    Pair localPair;
    if (DefaultImageFormats.isWebpFormat(localImageFormat)) {
      localPair = readWebPImageSize();
    } else {
      localPair = readImageMetaData().getDimensions();
    }
    int i;
    if ((localImageFormat == DefaultImageFormats.JPEG) && (this.mRotationAngle == -1))
    {
      if (localPair != null)
      {
        i = JfifUtil.getOrientation(getInputStream());
        this.mExifOrientation = i;
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(i);
      }
    }
    else
    {
      if ((localImageFormat == DefaultImageFormats.HEIF) && (this.mRotationAngle == -1))
      {
        i = HeifExifUtil.getOrientation(getInputStream());
        this.mExifOrientation = i;
        this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(i);
        return;
      }
      if (this.mRotationAngle == -1) {
        this.mRotationAngle = 0;
      }
    }
  }
  
  public void setBytesRange(@Nullable BytesRange paramBytesRange)
  {
    this.mBytesRange = paramBytesRange;
  }
  
  public void setExifOrientation(int paramInt)
  {
    this.mExifOrientation = paramInt;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setImageFormat(ImageFormat paramImageFormat)
  {
    this.mImageFormat = paramImageFormat;
  }
  
  public void setRotationAngle(int paramInt)
  {
    this.mRotationAngle = paramInt;
  }
  
  public void setSampleSize(int paramInt)
  {
    this.mSampleSize = paramInt;
  }
  
  public void setStreamSize(int paramInt)
  {
    this.mStreamSize = paramInt;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\image\EncodedImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */