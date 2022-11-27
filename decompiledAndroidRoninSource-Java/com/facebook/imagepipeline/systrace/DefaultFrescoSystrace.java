package com.facebook.imagepipeline.systrace;

import android.os.Build.VERSION;
import android.os.Trace;

public class DefaultFrescoSystrace
  implements FrescoSystrace.Systrace
{
  public void beginSection(String paramString) {}
  
  public FrescoSystrace.ArgsBuilder beginSectionWithArgs(String paramString)
  {
    return FrescoSystrace.NO_OP_ARGS_BUILDER;
  }
  
  public void endSection() {}
  
  public boolean isTracing()
  {
    return false;
  }
  
  private static final class DefaultArgsBuilder
    implements FrescoSystrace.ArgsBuilder
  {
    private final StringBuilder mStringBuilder;
    
    public DefaultArgsBuilder(String paramString)
    {
      this.mStringBuilder = new StringBuilder(paramString);
    }
    
    public FrescoSystrace.ArgsBuilder arg(String paramString, double paramDouble)
    {
      StringBuilder localStringBuilder = this.mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Double.toString(paramDouble));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder arg(String paramString, int paramInt)
    {
      StringBuilder localStringBuilder = this.mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Integer.toString(paramInt));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder arg(String paramString, long paramLong)
    {
      StringBuilder localStringBuilder = this.mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      localStringBuilder.append(Long.toString(paramLong));
      return this;
    }
    
    public FrescoSystrace.ArgsBuilder arg(String paramString, Object paramObject)
    {
      StringBuilder localStringBuilder = this.mStringBuilder;
      localStringBuilder.append(';');
      localStringBuilder.append(paramString);
      localStringBuilder.append('=');
      if (paramObject == null) {
        paramString = "null";
      } else {
        paramString = paramObject.toString();
      }
      localStringBuilder.append(paramString);
      return this;
    }
    
    public void flush()
    {
      if (this.mStringBuilder.length() > 127) {
        this.mStringBuilder.setLength(127);
      }
      if (Build.VERSION.SDK_INT >= 18) {
        Trace.beginSection(this.mStringBuilder.toString());
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\systrace\DefaultFrescoSystrace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */