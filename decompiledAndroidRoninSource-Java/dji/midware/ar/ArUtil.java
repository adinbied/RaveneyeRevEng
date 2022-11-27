package dji.midware.ar;

import android.content.res.Resources;
import android.opengl.GLU;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.parser.IParser;
import dji.midware.ar.min3d.parser.Parser;
import dji.midware.ar.min3d.parser.Parser.Type;
import dji.midware.ar.min3d.vos.Number3d;
import java.io.InputStream;
import java.lang.reflect.Array;
import javax.microedition.khronos.opengles.GL11;

public class ArUtil
{
  public static double calHeightFromFov(float paramFloat1, float paramFloat2)
  {
    return Math.tan(paramFloat1 / 2.0F) * 2.0D * paramFloat2;
  }
  
  public static double calcDistance(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    float f1 = paramNumber3d1.x - paramNumber3d2.x;
    float f2 = paramNumber3d1.y - paramNumber3d2.y;
    float f3 = paramNumber3d1.z - paramNumber3d2.z;
    return Math.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
  }
  
  public static void dcm2Quat(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat1 != null))
    {
      if (paramArrayOfFloat1.length < 4) {
        return;
      }
      float f = paramArrayOfFloat[0][0] + paramArrayOfFloat[1][1] + paramArrayOfFloat[2][2];
      if (f > 0.0F)
      {
        f = (float)(Math.sqrt(f + 1.0F) * 2.0D);
        paramArrayOfFloat1[0] = (0.25F * f);
        paramArrayOfFloat1[1] = ((paramArrayOfFloat[2][1] - paramArrayOfFloat[1][2]) / f);
        paramArrayOfFloat1[2] = ((paramArrayOfFloat[0][2] - paramArrayOfFloat[2][0]) / f);
        paramArrayOfFloat1[3] = ((paramArrayOfFloat[1][0] - paramArrayOfFloat[0][1]) / f);
        return;
      }
      if ((paramArrayOfFloat[0][0] > paramArrayOfFloat[1][1]) && (paramArrayOfFloat[0][0] > paramArrayOfFloat[2][2]))
      {
        f = (float)Math.sqrt(paramArrayOfFloat[0][0] + 1.0F - paramArrayOfFloat[1][1] - paramArrayOfFloat[2][2]) * 2.0F;
        paramArrayOfFloat1[0] = ((paramArrayOfFloat[2][1] - paramArrayOfFloat[1][2]) / f);
        paramArrayOfFloat1[1] = (0.25F * f);
        paramArrayOfFloat1[2] = ((paramArrayOfFloat[0][1] + paramArrayOfFloat[1][0]) / f);
        paramArrayOfFloat1[3] = ((paramArrayOfFloat[0][2] + paramArrayOfFloat[2][0]) / f);
        return;
      }
      if (paramArrayOfFloat[1][1] > paramArrayOfFloat[2][2])
      {
        f = (float)Math.sqrt(paramArrayOfFloat[1][1] + 1.0F - paramArrayOfFloat[0][0] - paramArrayOfFloat[2][2]) * 2.0F;
        paramArrayOfFloat1[0] = ((paramArrayOfFloat[0][2] + paramArrayOfFloat[2][0]) / f);
        paramArrayOfFloat1[1] = ((paramArrayOfFloat[0][1] + paramArrayOfFloat[1][0]) / f);
        paramArrayOfFloat1[2] = (0.25F * f);
        paramArrayOfFloat1[0] = ((paramArrayOfFloat[1][2] - paramArrayOfFloat[2][1]) / f);
        return;
      }
      f = (float)Math.sqrt(paramArrayOfFloat[2][2] + 1.0F - paramArrayOfFloat[0][0] - paramArrayOfFloat[1][1]) * 2.0F;
      paramArrayOfFloat1[0] = ((paramArrayOfFloat[1][0] + paramArrayOfFloat[0][1]) / f);
      paramArrayOfFloat1[1] = ((paramArrayOfFloat[0][2] + paramArrayOfFloat[2][0]) / f);
      paramArrayOfFloat1[2] = ((paramArrayOfFloat[1][2] - paramArrayOfFloat[2][1]) / f);
      paramArrayOfFloat1[3] = (f * 0.25F);
    }
  }
  
  public static void eularAngles2Dcm(float[] paramArrayOfFloat, float[][] paramArrayOfFloat1)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat1 == null) {
        return;
      }
      double d1 = Math.toRadians(paramArrayOfFloat[0]);
      double d2 = Math.toRadians(paramArrayOfFloat[1]);
      double d3 = Math.toRadians(paramArrayOfFloat[2]);
      float f1 = (float)Math.cos(d1);
      float f2 = (float)Math.cos(d2);
      float f3 = (float)Math.cos(d3);
      float f4 = (float)Math.sin(d1);
      float f6 = (float)Math.sin(d2);
      float f5 = (float)Math.sin(d3);
      paramArrayOfFloat1[0][0] = (f2 * f1);
      paramArrayOfFloat1[1][0] = (f2 * f4);
      paramArrayOfFloat1[2][0] = (-f6);
      paramArrayOfFloat = paramArrayOfFloat1[0];
      float f7 = f5 * f6;
      paramArrayOfFloat[1] = (f7 * f1 - f3 * f4);
      paramArrayOfFloat1[1][1] = (f7 * f4 + f3 * f1);
      paramArrayOfFloat1[2][1] = (f5 * f2);
      paramArrayOfFloat = paramArrayOfFloat1[0];
      f6 *= f3;
      paramArrayOfFloat[2] = (f6 * f1 + f5 * f4);
      paramArrayOfFloat1[1][2] = (f6 * f4 - f5 * f1);
      paramArrayOfFloat1[2][2] = (f3 * f2);
    }
  }
  
  public static Object3dContainer loadModel(Parser.Type paramType, Resources paramResources, InputStream paramInputStream, boolean paramBoolean, float paramFloat)
  {
    paramType = Parser.createParser(paramType, paramResources, paramInputStream, paramBoolean);
    paramType.parse();
    paramType = paramType.getParsedObject();
    paramType.scale().x = paramFloat;
    paramType.scale().y = paramFloat;
    paramType.scale().z = paramFloat;
    return paramType;
  }
  
  public static Object3dContainer loadModel(Parser.Type paramType, Resources paramResources, InputStream paramInputStream, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramType = loadModel(paramType, paramResources, paramInputStream, paramBoolean, paramFloat1);
    paramType.position().x = paramFloat2;
    paramType.position().y = paramFloat3;
    paramType.position().z = paramFloat4;
    return paramType;
  }
  
  public static Object3dContainer loadModel(Parser.Type paramType, Resources paramResources, InputStream paramInputStream, boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    paramType = loadModel(paramType, paramResources, paramInputStream, paramBoolean, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramType.rotation().x = paramFloat5;
    paramType.rotation().y = paramFloat6;
    paramType.rotation().z = paramFloat7;
    return paramType;
  }
  
  public static float[][] matrixMulti(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null))
    {
      int m = Math.min(Math.min(paramArrayOfFloat1.length, paramArrayOfFloat1[0].length), Math.min(paramArrayOfFloat2.length, paramArrayOfFloat2[0].length));
      float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { m, m });
      int i = 0;
      while (i < m)
      {
        int j = 0;
        while (j < m)
        {
          float f = 0.0F;
          int k = 0;
          while (k < m)
          {
            f += paramArrayOfFloat1[i][k] * paramArrayOfFloat2[k][j];
            k += 1;
          }
          arrayOfFloat[i][j] = f;
          j += 1;
        }
        i += 1;
      }
      return arrayOfFloat;
    }
    return (float[][])null;
  }
  
  public static float[] matrixMultiplyVector(float[][] paramArrayOfFloat, float[] paramArrayOfFloat1)
  {
    if ((paramArrayOfFloat != null) && (paramArrayOfFloat1 != null) && (paramArrayOfFloat[0].length == paramArrayOfFloat1.length))
    {
      float[] arrayOfFloat = new float[paramArrayOfFloat.length];
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        int j = 0;
        while (j < paramArrayOfFloat1.length)
        {
          arrayOfFloat[i] += paramArrayOfFloat[i][j] * paramArrayOfFloat1[j];
          j += 1;
        }
        i += 1;
      }
      return arrayOfFloat;
    }
    return null;
  }
  
  public static void matrixTranspose(float[][] paramArrayOfFloat1, float[][] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1 != null)
    {
      if (paramArrayOfFloat2 == null) {
        return;
      }
      int j = paramArrayOfFloat1.length;
      int i = 0;
      int k = Math.min(j, paramArrayOfFloat1[0].length);
      while (i < k)
      {
        j = i;
        while (j < k)
        {
          paramArrayOfFloat2[i][j] = paramArrayOfFloat1[j][i];
          paramArrayOfFloat2[j][i] = paramArrayOfFloat1[i][j];
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static void quaternions2EularAngles(float[] paramArrayOfFloat1, int paramInt, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat1.length - paramInt >= 4) && (paramArrayOfFloat2 != null))
    {
      if (paramArrayOfFloat2.length < 3) {
        return;
      }
      float f1 = paramArrayOfFloat1[(paramInt + 0)];
      float f2 = paramArrayOfFloat1[(paramInt + 1)];
      float f3 = paramArrayOfFloat1[(paramInt + 2)];
      float f4 = paramArrayOfFloat1[(paramInt + 3)];
      double d = (f1 * f2 + f3 * f4) * 2.0F;
      float f5 = f3 * f3;
      paramArrayOfFloat2[0] = ((float)Math.toDegrees(Math.atan2(d, 1.0F - (f2 * f2 + f5) * 2.0F)));
      paramArrayOfFloat2[1] = ((float)Math.toDegrees(Math.asin((f1 * f3 - f4 * f2) * 2.0F)));
      paramArrayOfFloat2[2] = ((float)Math.toDegrees(Math.atan2((f1 * f4 + f2 * f3) * 2.0F, 1.0F - (f5 + f4 * f4) * 2.0F)));
    }
  }
  
  public static float[] quaternionsMultiply(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null) && (paramArrayOfFloat1.length >= 4) && (paramArrayOfFloat2.length >= 4)) {
      return new float[] { paramArrayOfFloat1[0] * paramArrayOfFloat2[0] - paramArrayOfFloat1[1] * paramArrayOfFloat2[1] - paramArrayOfFloat1[2] * paramArrayOfFloat2[2] - paramArrayOfFloat1[3] * paramArrayOfFloat2[3], paramArrayOfFloat1[0] * paramArrayOfFloat2[1] + paramArrayOfFloat1[1] * paramArrayOfFloat2[0] + paramArrayOfFloat1[2] * paramArrayOfFloat2[3] - paramArrayOfFloat1[3] * paramArrayOfFloat2[2], paramArrayOfFloat1[0] * paramArrayOfFloat2[2] - paramArrayOfFloat1[1] * paramArrayOfFloat2[3] + paramArrayOfFloat1[2] * paramArrayOfFloat2[0] + paramArrayOfFloat1[3] * paramArrayOfFloat2[1], paramArrayOfFloat1[0] * paramArrayOfFloat2[3] + paramArrayOfFloat1[1] * paramArrayOfFloat2[2] - paramArrayOfFloat1[2] * paramArrayOfFloat2[1] + paramArrayOfFloat1[3] * paramArrayOfFloat2[0] };
    }
    return null;
  }
  
  public static Number3d screenCoor2WorldCoor(GL11 paramGL11, float paramFloat1, float paramFloat2)
  {
    float[] arrayOfFloat1 = new float[4];
    int[] arrayOfInt = new int[16];
    float[] arrayOfFloat2 = new float[16];
    float[] arrayOfFloat3 = new float[16];
    paramGL11.glGetIntegerv(2978, arrayOfInt, 0);
    paramGL11.glGetFloatv(2982, arrayOfFloat2, 0);
    paramGL11.glGetFloatv(2983, arrayOfFloat3, 0);
    GLU.gluUnProject(paramFloat1, paramFloat2, 0.0F, arrayOfFloat2, 0, arrayOfFloat3, 0, arrayOfInt, 0, arrayOfFloat1, 0);
    return new Number3d(arrayOfFloat1[0] / arrayOfFloat1[3], arrayOfFloat1[1] / arrayOfFloat1[3], arrayOfFloat1[2] / arrayOfFloat1[3]);
  }
  
  public static float[] worldCoor2ScreenCoor(GL11 paramGL11, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int[] arrayOfInt = new int[16];
    float[] arrayOfFloat1 = new float[16];
    float[] arrayOfFloat2 = new float[16];
    paramGL11.glGetIntegerv(2978, arrayOfInt, 0);
    paramGL11.glGetFloatv(2982, arrayOfFloat1, 0);
    paramGL11.glGetFloatv(2983, arrayOfFloat2, 0);
    paramGL11 = new float[3];
    GLU.gluProject(paramFloat1, paramFloat2, paramFloat3, arrayOfFloat1, 0, arrayOfFloat2, 0, arrayOfInt, 0, paramGL11, 0);
    return paramGL11;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\ArUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */