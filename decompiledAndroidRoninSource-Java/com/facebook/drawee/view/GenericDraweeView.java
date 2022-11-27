package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class GenericDraweeView
  extends DraweeView<GenericDraweeHierarchy>
{
  public GenericDraweeView(Context paramContext)
  {
    super(paramContext);
    inflateHierarchy(paramContext, null);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflateHierarchy(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflateHierarchy(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    inflateHierarchy(paramContext, paramAttributeSet);
  }
  
  public GenericDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext);
    setHierarchy(paramGenericDraweeHierarchy);
  }
  
  protected void inflateHierarchy(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
    }
    paramContext = GenericDraweeHierarchyInflater.inflateBuilder(paramContext, paramAttributeSet);
    setAspectRatio(paramContext.getDesiredAspectRatio());
    setHierarchy(paramContext.build());
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\view\GenericDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */