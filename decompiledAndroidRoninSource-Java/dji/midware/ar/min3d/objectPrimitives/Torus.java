package dji.midware.ar.min3d.objectPrimitives;

import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Vertex3d;

public class Torus
  extends Object3dContainer
{
  private final int MIN_SEGMENTSH = 2;
  private final int MIN_SEGMENTSW = 3;
  private float largeRadius;
  private int segmentsH;
  private int segmentsW;
  private float smallRadius;
  
  public Torus()
  {
    this(2.0F, 1.0F, 12, 8, new Color4());
  }
  
  public Torus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this(paramFloat1, paramFloat2, paramInt1, paramInt2, new Color4());
  }
  
  public Torus(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, Color4 paramColor4)
  {
    super(i * 3, i);
    this.largeRadius = paramFloat1;
    this.smallRadius = paramFloat2;
    this.segmentsW = Math.max(3, paramInt1);
    this.segmentsH = Math.max(2, paramInt2);
    defaultColor(paramColor4);
    build();
  }
  
  public Torus(Color4 paramColor4)
  {
    this(2.0F, 1.0F, 12, 8, paramColor4);
  }
  
  /* Error */
  private void build()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private Vertex3d getVertex(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\Torus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */