package dji.publics.DJIKit;

import android.graphics.Camera;
import android.graphics.Matrix;

public class DJIMatrix
{
  private float centerX;
  private float centerY;
  private float degX;
  private float degY;
  private float degZ;
  private float deltaX;
  private float deltaY;
  private float deltaZ;
  private boolean isCenter = false;
  private boolean isRotate = false;
  private boolean isScale = false;
  private boolean isTranslate = false;
  private Camera mCamera = new Camera();
  private Matrix mMatrix = new Matrix();
  private float scaleX;
  private float scaleY;
  
  /* Error */
  private void rotate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void translate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Matrix get()
  {
    return null;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setCenter(float paramFloat1, float paramFloat2)
  {
    this.centerX = paramFloat1;
    this.centerY = paramFloat2;
    this.isCenter = true;
  }
  
  public void setRotate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.degX = paramFloat1;
    this.degY = paramFloat2;
    this.degZ = paramFloat3;
    this.isRotate = true;
  }
  
  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.isScale = true;
  }
  
  public void setTranslate(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.deltaX = paramFloat1;
    this.deltaY = paramFloat2;
    this.deltaZ = paramFloat3;
    this.isTranslate = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIKit\DJIMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */