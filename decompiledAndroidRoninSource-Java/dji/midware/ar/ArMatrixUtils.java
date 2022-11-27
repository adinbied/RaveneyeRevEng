package dji.midware.ar;

import android.opengl.Matrix;

public class ArMatrixUtils
{
  private static float[] getCameraTranslateM(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat1 = new float[16];
    float[] arrayOfFloat2 = new float[16];
    Matrix.setIdentityM(arrayOfFloat2, 0);
    Matrix.translateM(arrayOfFloat1, 0, arrayOfFloat2, 0, paramFloat1, paramFloat2, paramFloat3);
    return arrayOfFloat1;
  }
  
  public static float[] getVectorTarget(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[4];
    Matrix.multiplyMV(arrayOfFloat, 0, paramArrayOfFloat, 0, new float[] { 0.0F, 1.0F, 0.0F, 1.0F }, 0);
    return arrayOfFloat;
  }
  
  public static float[] getVectorUp(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[4];
    Matrix.multiplyMV(arrayOfFloat, 0, paramArrayOfFloat, 0, new float[] { 0.0F, 0.0F, 1.0F, 1.0F }, 0);
    return arrayOfFloat;
  }
  
  public static float[] getViewM(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, getCameraTranslateM(paramFloat1, paramFloat2, paramFloat3), 0, paramArrayOfFloat, 0);
    return arrayOfFloat;
  }
  
  public static float[] rotateM(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float[] arrayOfFloat1 = new float[16];
    Matrix.setIdentityM(arrayOfFloat1, 0);
    float[] arrayOfFloat2 = new float[16];
    float[] arrayOfFloat3 = new float[16];
    Matrix.setIdentityM(arrayOfFloat3, 0);
    float[] arrayOfFloat4 = new float[16];
    Matrix.setIdentityM(arrayOfFloat4, 0);
    float[] arrayOfFloat5 = new float[16];
    Matrix.setIdentityM(arrayOfFloat5, 0);
    Matrix.rotateM(arrayOfFloat3, 0, paramFloat1, 1.0F, 0.0F, 0.0F);
    Matrix.rotateM(arrayOfFloat4, 0, paramFloat2, 0.0F, 1.0F, 0.0F);
    Matrix.rotateM(arrayOfFloat5, 0, paramFloat3, 0.0F, 0.0F, -1.0F);
    Matrix.multiplyMM(arrayOfFloat1, 0, arrayOfFloat4, 0, arrayOfFloat5, 0);
    Matrix.multiplyMM(arrayOfFloat2, 0, arrayOfFloat1, 0, arrayOfFloat3, 0);
    return arrayOfFloat2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArMatrixUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */