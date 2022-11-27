package dji.midware.media.player;

import dji.midware.data.config.P3.ProductType;

public class DJIMediaPlayerFactory
{
  public static DJIMediaPlayer buildMediaPlayer(ProductType paramProductType, int... paramVarArgs)
  {
    int i = 1.$SwitchMap$dji$midware$data$model$P3$DataCameraGetPushStateInfo$CameraType[dji.midware.data.model.P3.DataCameraGetPushStateInfo.getInstance().getCameraType(paramVarArgs).ordinal()];
    if ((i != 1) && (i != 2) && (i != 3))
    {
      if ((i != 4) && (i != 5)) {
        paramVarArgs = null;
      } else {
        paramVarArgs = new DJIMediaPlayerH1(paramVarArgs);
      }
    }
    else {
      paramVarArgs = new DJIMediaPlayerLitchis(paramVarArgs);
    }
    if (paramVarArgs != null) {
      return paramVarArgs;
    }
    switch (1.$SwitchMap$dji$midware$data$config$P3$ProductType[paramProductType.ordinal()])
    {
    default: 
      return new DJIMediaPlayerLitchix();
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
      return new DJIMediaPlayerH1(new int[0]);
    case 11: 
      return new DJIMediaPlayerLitchix();
    case 8: 
    case 9: 
    case 10: 
      return new DJIMediaPlayerLitchis(new int[0]);
    }
    return new DJIMediaPlayerLitchix();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */