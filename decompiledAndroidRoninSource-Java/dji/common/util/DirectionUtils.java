package dji.common.util;

import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.data.model.P3.DataCameraGetImageSize.RatioType;
import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import dji.midware.data.model.P3.DataCameraGetPushFovParam;
import dji.midware.data.model.P3.DataCameraGetPushShotParams;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.media.DJIVideoDecoder;

public class DirectionUtils
{
  public static final float DEG2RAD = 0.017453292F;
  public static final float RAD2DEG = 57.29578F;
  private static float[] e = new float[3];
  private static float[] mCurrMovingDir = new float[2];
  private static float[] r = new float[9];
  
  public static void adjustXY(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    DataCameraGetImageSize.RatioType localRatioType = getRatio();
    float f1 = VisualUtils.cameraHorizontalFov();
    float f2 = VisualUtils.cameraHorizontalStandardFov();
    float f3 = (float)(Math.tan(f1 * 0.017453292F / 2.0F) / Math.tan(f2 * 0.017453292F / 2.0F));
    boolean bool = DataCameraGetPushFovParam.getInstance().hasFovData();
    f2 = 0.75F;
    f1 = f2;
    if (!bool) {
      if (localRatioType == DataCameraGetImageSize.RatioType.R_4_3) {
        f1 = f2;
      } else if (localRatioType == DataCameraGetImageSize.RatioType.R_3_2) {
        f1 = 0.6666667F;
      } else {
        f1 = 0.5625F;
      }
    }
    double d1 = paramFloat1;
    double d2 = f3;
    paramArrayOfFloat[0] = ((float)((d1 - 0.5D) * d2 + 0.5D));
    paramArrayOfFloat[1] = ((float)((paramFloat2 - 0.5D) * (f1 * 1.3333334F) * d2 + 0.5D));
    if (paramArrayOfFloat[0] < 0.0F) {
      paramArrayOfFloat[0] = 0.0F;
    } else if (paramArrayOfFloat[0] > 1.0F) {
      paramArrayOfFloat[0] = 1.0F;
    }
    if (paramArrayOfFloat[1] < 0.0F)
    {
      paramArrayOfFloat[1] = 0.0F;
      return;
    }
    if (paramArrayOfFloat[1] > 1.0F) {
      paramArrayOfFloat[1] = 1.0F;
    }
  }
  
  public static float[] calculateCurrMovingDir(float[] paramArrayOfFloat)
  {
    DataCameraGetImageSize.RatioType localRatioType = getRatio();
    float[] arrayOfFloat = r;
    float f2 = (float)(arrayOfFloat[0] * paramArrayOfFloat[0] + arrayOfFloat[3] * paramArrayOfFloat[1] + arrayOfFloat[6] * paramArrayOfFloat[2] + 1.0E-8D);
    float f3 = arrayOfFloat[1];
    float f4 = paramArrayOfFloat[0];
    float f5 = arrayOfFloat[4];
    float f6 = paramArrayOfFloat[1];
    float f7 = arrayOfFloat[7];
    float f8 = paramArrayOfFloat[2];
    float f9 = arrayOfFloat[2];
    float f10 = paramArrayOfFloat[0];
    float f11 = arrayOfFloat[5];
    float f12 = paramArrayOfFloat[1];
    float f13 = arrayOfFloat[8];
    float f14 = paramArrayOfFloat[2];
    float f1;
    if (localRatioType == DataCameraGetImageSize.RatioType.R_4_3) {
      f1 = 0.75F;
    } else if (localRatioType == DataCameraGetImageSize.RatioType.R_3_2) {
      f1 = 0.6666667F;
    } else {
      f1 = 0.5625F;
    }
    float f15 = VisualUtils.cameraHorizontalFov();
    double d = Math.atan(Math.tan(0.5F * f15 * 0.017453292F) * f1);
    mCurrMovingDir[0] = ((float)(((f3 * f4 + f5 * f6 + f7 * f8) / f2 / Math.tan(f15 * 0.5D * 0.01745329238474369D) + 1.0D) * 0.5D));
    mCurrMovingDir[1] = ((float)(((f9 * f10 + f11 * f12 + f13 * f14) / f2 / Math.tan(d * 57.295780181884766D * 2.0D * 0.5D * 0.01745329238474369D) + 1.0D) * 0.5D));
    return mCurrMovingDir;
  }
  
  public static void e2rGimbal(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f6 = (float)Math.sin(paramArrayOfFloat1[2]);
    float f1 = (float)Math.cos(paramArrayOfFloat1[2]);
    float f2 = (float)Math.sin(paramArrayOfFloat1[1]);
    float f3 = (float)Math.cos(paramArrayOfFloat1[1]);
    float f4 = (float)Math.sin(paramArrayOfFloat1[0]);
    float f5 = (float)Math.cos(paramArrayOfFloat1[0]);
    float f7 = f6 * f2;
    paramArrayOfFloat2[0] = (f3 * f5 - f7 * f4);
    paramArrayOfFloat2[3] = (f3 * f4 + f7 * f5);
    paramArrayOfFloat2[6] = (-f2 * f1);
    paramArrayOfFloat2[1] = (-f1 * f4);
    paramArrayOfFloat2[4] = (f1 * f5);
    paramArrayOfFloat2[7] = f6;
    f6 *= f3;
    paramArrayOfFloat2[2] = (f2 * f5 + f6 * f4);
    paramArrayOfFloat2[5] = (f2 * f4 - f6 * f5);
    paramArrayOfFloat2[8] = (f1 * f3);
  }
  
  private static DataCameraGetImageSize.RatioType getRatio()
  {
    Object localObject1 = DataCameraGetImageSize.RatioType.R_16_9;
    Object localObject2 = DataCameraGetImageSize.RatioType.OTHER;
    localObject1 = ServiceManager.getInstance().getDecoder();
    int i;
    if (localObject1 == null) {
      i = 16;
    } else {
      i = ((DJIVideoDecoder)localObject1).width;
    }
    int j;
    if (localObject1 == null) {
      j = 9;
    } else {
      j = ((DJIVideoDecoder)localObject1).height;
    }
    localObject1 = localObject2;
    if (localObject2 == DataCameraGetImageSize.RatioType.OTHER) {
      if (DataCameraGetPushShotParams.getInstance().isGetted()) {
        localObject1 = DataCameraGetPushShotParams.getInstance().getImageRatio();
      } else {
        localObject1 = DataCameraGetImageSize.RatioType.R_4_3;
      }
    }
    localObject2 = DJIProductManager.getInstance().getType();
    if ((localObject2 != ProductType.litchiC) && (localObject2 != ProductType.litchiS) && (localObject2 != ProductType.P34K) && (localObject2 != ProductType.KumquatS) && (localObject2 != ProductType.Pomato))
    {
      if ((localObject1 == DataCameraGetImageSize.RatioType.R_4_3) && (DataCameraGetPushStateInfo.getInstance().getMode(new int[0]) == DataCameraGetMode.MODE.TAKEPHOTO)) {
        return DataCameraGetImageSize.RatioType.R_4_3;
      }
      if ((localObject1 == DataCameraGetImageSize.RatioType.R_3_2) && (DataCameraGetPushStateInfo.getInstance().getMode(new int[0]) == DataCameraGetMode.MODE.TAKEPHOTO)) {
        return DataCameraGetImageSize.RatioType.R_3_2;
      }
      return DataCameraGetImageSize.RatioType.R_16_9;
    }
    float f1 = i * 1.0F / j;
    float f2 = Math.abs(f1 - 1.7777778F);
    float f3 = f1 - 1.5F;
    if (f2 < Math.abs(f3)) {
      return DataCameraGetImageSize.RatioType.R_16_9;
    }
    if (Math.abs(f3) < Math.abs(f1 - 1.3333334F)) {
      return DataCameraGetImageSize.RatioType.R_3_2;
    }
    return DataCameraGetImageSize.RatioType.R_4_3;
  }
  
  public static void updateGimbalParam(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = e;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[2] = paramFloat3;
    e2rGimbal(arrayOfFloat, r);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\DirectionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */