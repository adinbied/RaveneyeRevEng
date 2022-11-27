package com.facebook.imagepipeline.common;

import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;

public class ImageDecodeOptions
{
  private static final ImageDecodeOptions DEFAULTS = newBuilder().build();
  public final Bitmap.Config bitmapConfig;
  @Nullable
  public final BitmapTransformation bitmapTransformation;
  @Nullable
  public final ColorSpace colorSpace;
  @Nullable
  public final ImageDecoder customImageDecoder;
  public final boolean decodeAllFrames;
  public final boolean decodePreviewFrame;
  public final boolean forceStaticImage;
  public final int maxDimensionPx;
  public final int minDecodeIntervalMs;
  public final boolean useLastFrameForPreview;
  
  public ImageDecodeOptions(ImageDecodeOptionsBuilder paramImageDecodeOptionsBuilder)
  {
    this.minDecodeIntervalMs = paramImageDecodeOptionsBuilder.getMinDecodeIntervalMs();
    this.maxDimensionPx = paramImageDecodeOptionsBuilder.getMaxDimensionPx();
    this.decodePreviewFrame = paramImageDecodeOptionsBuilder.getDecodePreviewFrame();
    this.useLastFrameForPreview = paramImageDecodeOptionsBuilder.getUseLastFrameForPreview();
    this.decodeAllFrames = paramImageDecodeOptionsBuilder.getDecodeAllFrames();
    this.forceStaticImage = paramImageDecodeOptionsBuilder.getForceStaticImage();
    this.bitmapConfig = paramImageDecodeOptionsBuilder.getBitmapConfig();
    this.customImageDecoder = paramImageDecodeOptionsBuilder.getCustomImageDecoder();
    this.bitmapTransformation = paramImageDecodeOptionsBuilder.getBitmapTransformation();
    this.colorSpace = paramImageDecodeOptionsBuilder.getColorSpace();
  }
  
  public static ImageDecodeOptions defaults()
  {
    return DEFAULTS;
  }
  
  public static ImageDecodeOptionsBuilder newBuilder()
  {
    return new ImageDecodeOptionsBuilder();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ImageDecodeOptions)paramObject;
      if (this.minDecodeIntervalMs != ((ImageDecodeOptions)paramObject).minDecodeIntervalMs) {
        return false;
      }
      if (this.maxDimensionPx != ((ImageDecodeOptions)paramObject).maxDimensionPx) {
        return false;
      }
      if (this.decodePreviewFrame != ((ImageDecodeOptions)paramObject).decodePreviewFrame) {
        return false;
      }
      if (this.useLastFrameForPreview != ((ImageDecodeOptions)paramObject).useLastFrameForPreview) {
        return false;
      }
      if (this.decodeAllFrames != ((ImageDecodeOptions)paramObject).decodeAllFrames) {
        return false;
      }
      if (this.forceStaticImage != ((ImageDecodeOptions)paramObject).forceStaticImage) {
        return false;
      }
      if (this.bitmapConfig != ((ImageDecodeOptions)paramObject).bitmapConfig) {
        return false;
      }
      if (this.customImageDecoder != ((ImageDecodeOptions)paramObject).customImageDecoder) {
        return false;
      }
      if (this.bitmapTransformation != ((ImageDecodeOptions)paramObject).bitmapTransformation) {
        return false;
      }
      return this.colorSpace == ((ImageDecodeOptions)paramObject).colorSpace;
    }
    return false;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageDecodeOptions{");
    localStringBuilder.append(toStringHelper().toString());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  protected Objects.ToStringHelper toStringHelper()
  {
    return Objects.toStringHelper(this).add("minDecodeIntervalMs", this.minDecodeIntervalMs).add("maxDimensionPx", this.maxDimensionPx).add("decodePreviewFrame", this.decodePreviewFrame).add("useLastFrameForPreview", this.useLastFrameForPreview).add("decodeAllFrames", this.decodeAllFrames).add("forceStaticImage", this.forceStaticImage).add("bitmapConfigName", this.bitmapConfig.name()).add("customImageDecoder", this.customImageDecoder).add("bitmapTransformation", this.bitmapTransformation).add("colorSpace", this.colorSpace);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\common\ImageDecodeOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */