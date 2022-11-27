package dji.publics.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;

public class DJI3dAnimation
  extends Animation
{
  private Camera camera;
  private float mCenterX;
  private float mCenterY;
  private float mFromXDegrees;
  private float mFromXDistances;
  private float mFromYDegrees;
  private float mFromYDistances;
  private float mFromZDegrees;
  private float mFromZDistances;
  private float mToXDegrees;
  private float mToXDistances;
  private float mToYDegrees;
  private float mToYDistances;
  private float mToZDegrees;
  private float mToZDistances;
  private Matrix matrix;
  
  public DJI3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    this.mFromXDegrees = paramFloat3;
    this.mToXDegrees = paramFloat4;
  }
  
  public DJI3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    this.mFromXDegrees = paramFloat3;
    this.mToXDegrees = paramFloat4;
    this.mFromYDegrees = paramFloat5;
    this.mToYDegrees = paramFloat6;
    this.mFromZDegrees = paramFloat7;
    this.mToZDegrees = paramFloat8;
  }
  
  public DJI3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    this.mFromXDegrees = paramFloat3;
    this.mToXDegrees = paramFloat4;
    this.mFromYDegrees = paramFloat5;
    this.mToYDegrees = paramFloat6;
    this.mFromZDegrees = paramFloat7;
    this.mToZDegrees = paramFloat8;
    this.mFromXDistances = paramFloat9;
    this.mToXDistances = paramFloat10;
    this.mFromYDistances = paramFloat11;
    this.mToYDistances = paramFloat12;
    this.mFromZDistances = paramFloat13;
    this.mToZDistances = paramFloat14;
  }
  
  /* Error */
  protected void applyTransformation(float arg1, android.view.animation.Transformation arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.camera = new Camera();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\animation\DJI3dAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */