package com.xiaomi.clientreport.data;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bl;

public class Config
{
  public static final boolean DEFAULT_EVENT_ENCRYPTED = true;
  public static final long DEFAULT_EVENT_UPLOAD_FREQUENCY = 86400L;
  public static final boolean DEFAULT_EVENT_UPLOAD_SWITCH_OPEN = false;
  public static final long DEFAULT_MAX_FILE_LENGTH = 1048576L;
  public static final long DEFAULT_PERF_UPLOAD_FREQUENCY = 86400L;
  public static final boolean DEFAULT_PERF_UPLOAD_SWITCH_OPEN = false;
  private String mAESKey;
  private boolean mEventEncrypted = true;
  private long mEventUploadFrequency;
  private boolean mEventUploadSwitchOpen = false;
  private long mMaxFileLength;
  private long mPerfUploadFrequency;
  private boolean mPerfUploadSwitchOpen = false;
  
  private Config()
  {
    this.mMaxFileLength = 1048576L;
    this.mEventUploadFrequency = 86400L;
    this.mPerfUploadFrequency = 86400L;
  }
  
  private Config(Context paramContext, Builder paramBuilder)
  {
    long l = 1048576L;
    this.mMaxFileLength = 1048576L;
    this.mEventUploadFrequency = 86400L;
    this.mPerfUploadFrequency = 86400L;
    if (paramBuilder.mEventEncrypted == 0) {
      this.mEventEncrypted = false;
    } else {
      this.mEventEncrypted = true;
    }
    if (!TextUtils.isEmpty(paramBuilder.mAESKey)) {
      paramContext = paramBuilder.mAESKey;
    } else {
      paramContext = bl.a(paramContext);
    }
    this.mAESKey = paramContext;
    if (paramBuilder.mMaxFileLength > -1L) {
      l = paramBuilder.mMaxFileLength;
    }
    this.mMaxFileLength = l;
    if (paramBuilder.mEventUploadFrequency > -1L) {
      this.mEventUploadFrequency = paramBuilder.mEventUploadFrequency;
    } else {
      this.mEventUploadFrequency = 86400L;
    }
    if (paramBuilder.mPerfUploadFrequency > -1L) {
      this.mPerfUploadFrequency = paramBuilder.mPerfUploadFrequency;
    } else {
      this.mPerfUploadFrequency = 86400L;
    }
    if (paramBuilder.mEventUploadSwitchOpen == 0) {}
    while (paramBuilder.mEventUploadSwitchOpen != 1)
    {
      this.mEventUploadSwitchOpen = false;
      break;
    }
    this.mEventUploadSwitchOpen = true;
    if (paramBuilder.mPerfUploadSwitchOpen == 0) {}
    while (paramBuilder.mPerfUploadSwitchOpen != 1)
    {
      this.mPerfUploadSwitchOpen = false;
      return;
    }
    this.mPerfUploadSwitchOpen = true;
  }
  
  public static Config defaultConfig(Context paramContext)
  {
    return getBuilder().setEventEncrypted(true).setAESKey(bl.a(paramContext)).setMaxFileLength(1048576L).setEventUploadSwitchOpen(false).setEventUploadFrequency(86400L).setPerfUploadSwitchOpen(false).setPerfUploadFrequency(86400L).build(paramContext);
  }
  
  public static Builder getBuilder()
  {
    return new Builder();
  }
  
  public long getEventUploadFrequency()
  {
    return this.mEventUploadFrequency;
  }
  
  public long getMaxFileLength()
  {
    return this.mMaxFileLength;
  }
  
  public long getPerfUploadFrequency()
  {
    return this.mPerfUploadFrequency;
  }
  
  public boolean isEventEncrypted()
  {
    return this.mEventEncrypted;
  }
  
  public boolean isEventUploadSwitchOpen()
  {
    return this.mEventUploadSwitchOpen;
  }
  
  public boolean isPerfUploadSwitchOpen()
  {
    return this.mPerfUploadSwitchOpen;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static class Builder
  {
    private String mAESKey = null;
    private int mEventEncrypted = -1;
    private long mEventUploadFrequency = -1L;
    private int mEventUploadSwitchOpen = -1;
    private long mMaxFileLength = -1L;
    private long mPerfUploadFrequency = -1L;
    private int mPerfUploadSwitchOpen = -1;
    
    public Config build(Context paramContext)
    {
      return new Config(paramContext, this, null);
    }
    
    public Builder setAESKey(String paramString)
    {
      this.mAESKey = paramString;
      return this;
    }
    
    public Builder setEventEncrypted(boolean paramBoolean)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public Builder setEventUploadFrequency(long paramLong)
    {
      this.mEventUploadFrequency = paramLong;
      return this;
    }
    
    public Builder setEventUploadSwitchOpen(boolean paramBoolean)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public Builder setMaxFileLength(long paramLong)
    {
      this.mMaxFileLength = paramLong;
      return this;
    }
    
    public Builder setPerfUploadFrequency(long paramLong)
    {
      this.mPerfUploadFrequency = paramLong;
      return this;
    }
    
    public Builder setPerfUploadSwitchOpen(boolean paramBoolean)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\data\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */