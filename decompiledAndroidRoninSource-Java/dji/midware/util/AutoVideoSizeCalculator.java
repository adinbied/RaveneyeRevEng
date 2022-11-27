package dji.midware.util;

public class AutoVideoSizeCalculator
{
  private static final String TAG = "AutoVideoSizeCalculator";
  public static String testOutput = "";
  private AutoVideoSizeListener listener;
  private Options options = new Options();
  private int[] showHeightLimit = new int[2];
  private int[] showWidthLimit = new int[2];
  private int videoHeight;
  private int videoRelHeight;
  private int videoRelWidth;
  private int videoWidth;
  
  private boolean calcSize()
  {
    return false;
  }
  
  private int calcTheSideOfMatchScreen()
  {
    return 0;
  }
  
  public static AutoVideoSizeCalculator.Options.VideoType findMathRatioType(float paramFloat)
  {
    AutoVideoSizeCalculator.Options.VideoType[] arrayOfVideoType = AutoVideoSizeCalculator.Options.VideoType.values();
    int j = arrayOfVideoType.length;
    Object localObject1 = null;
    float f1 = Float.MAX_VALUE;
    int i = 0;
    while (i < j)
    {
      localObject2 = arrayOfVideoType[i];
      float f2 = f1;
      if (Math.abs(paramFloat - ((AutoVideoSizeCalculator.Options.VideoType)localObject2).getRelRatio()) < f1)
      {
        f2 = Math.abs(paramFloat - ((AutoVideoSizeCalculator.Options.VideoType)localObject2).getRelRatio());
        localObject1 = localObject2;
      }
      i += 1;
      f1 = f2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = AutoVideoSizeCalculator.Options.VideoType.Ratio16X9;
    }
    return (AutoVideoSizeCalculator.Options.VideoType)localObject2;
  }
  
  public Options getOptions()
  {
    return this.options;
  }
  
  public int getRelVideoHeight()
  {
    return this.videoRelHeight;
  }
  
  public int getRelVideoWidth()
  {
    return this.videoRelWidth;
  }
  
  public int[] getShowHeightLimit()
  {
    return this.showHeightLimit;
  }
  
  public int[] getShowWidthLimit()
  {
    return this.showWidthLimit;
  }
  
  public int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public boolean isVideoFullScreen()
  {
    return false;
  }
  
  /* Error */
  public void notifyCalc()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setListener(AutoVideoSizeListener paramAutoVideoSizeListener)
  {
    this.listener = paramAutoVideoSizeListener;
  }
  
  public static abstract interface AutoVideoSizeListener
  {
    public abstract void onVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static class Options
  {
    public static final float ratio16X10 = 1.6F;
    public static final float ratio16X9 = 1.7777778F;
    public static final float ratio17X9 = 1.8888888F;
    public static final float ratio18x9 = 2.0F;
    public static final float ratio244X100 = 2.44F;
    public static final float ratio3X2 = 1.5F;
    public static final float ratio4X3 = 1.3333334F;
    public static final float ratio5x4 = 1.25F;
    private boolean isRotated = false;
    private int screenHeight = 0;
    private ScreenType screenType = ScreenType.Ratio16X9;
    private int screenWidth = 0;
    private VideoType videoType = VideoType.Ratio16X9;
    
    public boolean getIsRotated()
    {
      return this.isRotated;
    }
    
    public int getScreenHeight()
    {
      return this.screenHeight;
    }
    
    public ScreenType getScreenType()
    {
      return this.screenType;
    }
    
    public int getScreenWidth()
    {
      return this.screenWidth;
    }
    
    public VideoType getVideoType()
    {
      return this.videoType;
    }
    
    public void setIsRotated(boolean paramBoolean)
    {
      this.isRotated = paramBoolean;
    }
    
    /* Error */
    public void setScreenTypeByScreenSize(int arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    public void setVideoType(VideoType paramVideoType)
    {
      this.videoType = paramVideoType;
    }
    
    /* Error */
    public void setVideoTypeByVideoSize(int arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    public static enum ScreenType
    {
      private float ratio;
      
      static
      {
        Ratio16X10 = new ScreenType("Ratio16X10", 1, 1.6F);
        Ratio4X3 = new ScreenType("Ratio4X3", 2, 1.3333334F);
        ScreenType localScreenType = new ScreenType("Ratio18x9", 3, 2.0F);
        Ratio18x9 = localScreenType;
        $VALUES = new ScreenType[] { Ratio16X9, Ratio16X10, Ratio4X3, localScreenType };
      }
      
      private ScreenType(float paramFloat)
      {
        this.ratio = paramFloat;
      }
      
      public float getRatio()
      {
        return this.ratio;
      }
    }
    
    public static enum VideoType
    {
      private float ratio;
      private float relRatio;
      
      static
      {
        Ratio3X2_IN16X9 = new VideoType("Ratio3X2_IN16X9", 4, 1.5F, 1.7777778F);
        Ratio17X9 = new VideoType("Ratio17X9", 5, 1.8888888F);
        Ratio17X9_IN16x9 = new VideoType("Ratio17X9_IN16x9", 6, 1.8888888F, 1.7777778F);
        Ratio5x4 = new VideoType("Ratio5x4", 7, 1.25F);
        Ratio5x4_IN16x9 = new VideoType("Ratio5x4_IN16x9", 8, 1.25F, 1.7777778F);
        VideoType localVideoType = new VideoType("Ratio244X100", 9, 2.44F);
        Ratio244X100 = localVideoType;
        $VALUES = new VideoType[] { Ratio16X9, Ratio3X2, Ratio4X3, Ratio4X3_IN16X9, Ratio3X2_IN16X9, Ratio17X9, Ratio17X9_IN16x9, Ratio5x4, Ratio5x4_IN16x9, localVideoType };
      }
      
      private VideoType(float paramFloat)
      {
        this.ratio = paramFloat;
        this.relRatio = paramFloat;
      }
      
      private VideoType(float paramFloat1, float paramFloat2)
      {
        this.ratio = paramFloat2;
        this.relRatio = paramFloat1;
      }
      
      public float getRatio()
      {
        return this.ratio;
      }
      
      public float getRelRatio()
      {
        return this.relRatio;
      }
      
      public boolean isNormalType()
      {
        return this.ratio == this.relRatio;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\AutoVideoSizeCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */