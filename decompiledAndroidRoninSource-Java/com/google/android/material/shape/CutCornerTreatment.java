package com.google.android.material.shape;

public class CutCornerTreatment
  extends CornerTreatment
{
  private final float size;
  
  public CutCornerTreatment(float paramFloat)
  {
    this.size = paramFloat;
  }
  
  public void getCornerPath(float paramFloat1, float paramFloat2, ShapePath paramShapePath)
  {
    paramShapePath.reset(0.0F, this.size * paramFloat2);
    double d1 = paramFloat1;
    double d2 = Math.sin(d1);
    double d3 = this.size;
    double d4 = paramFloat2;
    paramShapePath.lineTo((float)(d2 * d3 * d4), (float)(Math.cos(d1) * this.size * d4));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\shape\CutCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */