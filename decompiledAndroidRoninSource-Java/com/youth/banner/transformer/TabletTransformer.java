package com.youth.banner.transformer;

import android.graphics.Camera;
import android.graphics.Matrix;

public class TabletTransformer
  extends ABaseTransformer
{
  private static final Camera OFFSET_CAMERA = new Camera();
  private static final Matrix OFFSET_MATRIX = new Matrix();
  private static final float[] OFFSET_TEMP_FLOAT = new float[2];
  
  protected static final float getOffsetXForRotation(float paramFloat, int paramInt1, int paramInt2)
  {
    OFFSET_MATRIX.reset();
    OFFSET_CAMERA.save();
    OFFSET_CAMERA.rotateY(Math.abs(paramFloat));
    OFFSET_CAMERA.getMatrix(OFFSET_MATRIX);
    OFFSET_CAMERA.restore();
    OFFSET_MATRIX.preTranslate(-paramInt1 * 0.5F, -paramInt2 * 0.5F);
    Object localObject = OFFSET_MATRIX;
    float f1 = paramInt1;
    float f2 = paramInt2;
    ((Matrix)localObject).postTranslate(f1 * 0.5F, 0.5F * f2);
    localObject = OFFSET_TEMP_FLOAT;
    localObject[0] = f1;
    localObject[1] = f2;
    OFFSET_MATRIX.mapPoints((float[])localObject);
    f2 = OFFSET_TEMP_FLOAT[0];
    if (paramFloat > 0.0F) {
      paramFloat = 1.0F;
    } else {
      paramFloat = -1.0F;
    }
    return (f1 - f2) * paramFloat;
  }
  
  /* Error */
  protected void onTransform(android.view.View arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\transformer\TabletTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */