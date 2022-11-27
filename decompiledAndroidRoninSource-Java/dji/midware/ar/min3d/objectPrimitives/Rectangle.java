package dji.midware.ar.min3d.objectPrimitives;

import dji.midware.ar.min3d.Utils;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.core.Vertices;
import dji.midware.ar.min3d.vos.Color4;

public class Rectangle
  extends Object3dContainer
{
  public Rectangle(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this(paramFloat1, paramFloat2, paramInt1, paramInt2, new Color4(255, 0, 0, 255));
  }
  
  public Rectangle(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Color4 paramColor4)
  {
    super(paramInt1 * 4 * paramInt2, paramInt1 * 2 * paramInt2);
    float f1 = paramInt1;
    float f2 = paramFloat1 / f1;
    float f3 = paramInt2;
    float f4 = paramFloat2 / f3;
    float f5 = paramFloat1 / 2.0F;
    float f6 = paramFloat2 / 2.0F;
    int i = 0;
    paramFloat1 = f3;
    paramFloat2 = f2;
    int j;
    while (i <= paramInt2)
    {
      j = 0;
      while (j <= paramInt1)
      {
        Vertices localVertices = vertices();
        f2 = j;
        f3 = i;
        localVertices.addVertex(f2 * paramFloat2 - f5, f3 * f4 - f6, 0.0F, f2 / f1, 1.0F - f3 / paramFloat1, 0.0F, 0.0F, 1.0F, paramColor4.r, paramColor4.g, paramColor4.b, paramColor4.a);
        j += 1;
      }
      i += 1;
    }
    int k = paramInt1 + 1;
    i = 1;
    while (i <= paramInt2)
    {
      j = 1;
      while (j <= paramInt1)
      {
        int m = i * k + j;
        int n = m - k;
        Utils.addQuad(this, n - 1, n, m, m - 1);
        j += 1;
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\Rectangle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */