package com.google.android.material.shape;

public class RoundedCornerTreatment
  extends CornerTreatment
{
  private final float radius;
  
  public RoundedCornerTreatment(float paramFloat)
  {
    this.radius = paramFloat;
  }
  
  public void getCornerPath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    paramShapePath.reset(0.0F, this.radius * paramFloat2);
    float f = this.radius;
    paramShapePath.addArc(0.0F, 0.0F, f * 2.0F * paramFloat2, f * 2.0F * paramFloat2, paramFloat1 + 180.0F, 90.0F);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\shape\RoundedCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */