package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;

public class HoneycombBitmapFactory
  extends PlatformBitmapFactory
{
  private static final String TAG = HoneycombBitmapFactory.class.getSimpleName();
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  private boolean mImmutableBitmapFallback;
  private final EmptyJpegGenerator mJpegGenerator;
  private final PlatformDecoder mPurgeableDecoder;
  
  public HoneycombBitmapFactory(EmptyJpegGenerator paramEmptyJpegGenerator, PlatformDecoder paramPlatformDecoder, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    this.mJpegGenerator = paramEmptyJpegGenerator;
    this.mPurgeableDecoder = paramPlatformDecoder;
    this.mCloseableReferenceFactory = paramCloseableReferenceFactory;
  }
  
  private CloseableReference<Bitmap> createFallbackBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return this.mCloseableReferenceFactory.create(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig), SimpleBitmapReleaser.getInstance());
  }
  
  /* Error */
  public CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mImmutableBitmapFallback	Z
    //   4: ifeq +11 -> 15
    //   7: aload_0
    //   8: iload_1
    //   9: iload_2
    //   10: aload_3
    //   11: invokespecial 62	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:createFallbackBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;
    //   14: areturn
    //   15: aload_0
    //   16: getfield 31	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   19: iload_1
    //   20: i2s
    //   21: iload_2
    //   22: i2s
    //   23: invokevirtual 68	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   26: astore 4
    //   28: new 70	com/facebook/imagepipeline/image/EncodedImage
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 73	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   37: astore 5
    //   39: aload 5
    //   41: getstatic 79	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   44: invokevirtual 83	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   47: aload_0
    //   48: getfield 33	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mPurgeableDecoder	Lcom/facebook/imagepipeline/platform/PlatformDecoder;
    //   51: aload 5
    //   53: aload_3
    //   54: aconst_null
    //   55: aload 4
    //   57: invokevirtual 89	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   60: checkcast 91	com/facebook/common/memory/PooledByteBuffer
    //   63: invokeinterface 95 1 0
    //   68: invokeinterface 101 5 0
    //   73: astore 6
    //   75: aload 6
    //   77: invokevirtual 89	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   80: checkcast 39	android/graphics/Bitmap
    //   83: invokevirtual 105	android/graphics/Bitmap:isMutable	()Z
    //   86: ifne +41 -> 127
    //   89: aload 6
    //   91: invokestatic 108	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 60	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:mImmutableBitmapFallback	Z
    //   99: getstatic 24	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:TAG	Ljava/lang/String;
    //   102: ldc 110
    //   104: invokestatic 116	com/facebook/common/logging/FLog:wtf	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: iload_1
    //   109: iload_2
    //   110: aload_3
    //   111: invokespecial 62	com/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory:createFallbackBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/facebook/common/references/CloseableReference;
    //   114: astore_3
    //   115: aload 5
    //   117: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   120: aload 4
    //   122: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   125: aload_3
    //   126: areturn
    //   127: aload 6
    //   129: invokevirtual 89	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   132: checkcast 39	android/graphics/Bitmap
    //   135: iconst_1
    //   136: invokevirtual 126	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   139: aload 6
    //   141: invokevirtual 89	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   144: checkcast 39	android/graphics/Bitmap
    //   147: iconst_0
    //   148: invokevirtual 130	android/graphics/Bitmap:eraseColor	(I)V
    //   151: aload 5
    //   153: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   156: aload 4
    //   158: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   161: aload 6
    //   163: areturn
    //   164: astore_3
    //   165: aload 5
    //   167: invokestatic 119	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   170: aload_3
    //   171: athrow
    //   172: astore_3
    //   173: aload 4
    //   175: invokevirtual 122	com/facebook/common/references/CloseableReference:close	()V
    //   178: aload_3
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	HoneycombBitmapFactory
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   0	180	3	paramConfig	Bitmap.Config
    //   26	148	4	localCloseableReference1	CloseableReference
    //   37	129	5	localEncodedImage	com.facebook.imagepipeline.image.EncodedImage
    //   73	89	6	localCloseableReference2	CloseableReference
    // Exception table:
    //   from	to	target	type
    //   47	115	164	finally
    //   127	151	164	finally
    //   28	47	172	finally
    //   115	120	172	finally
    //   151	156	172	finally
    //   165	172	172	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\HoneycombBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */