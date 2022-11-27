package dji.midware.ar.min3d.objectPrimitives;

import dji.midware.ar.min3d.core.FacesBufferedList;
import dji.midware.ar.min3d.core.Object3dContainer;

public class HollowCylinder
  extends Object3dContainer
{
  private double DEG = 0.017453292519943295D;
  private float _height;
  private float _radiusInner;
  private float _radiusOuter;
  private int _segs;
  
  public HollowCylinder(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super(paramInt * 4, paramInt * 8);
    this._segs = paramInt;
    this._height = paramFloat3;
    this._radiusOuter = paramFloat1;
    this._radiusInner = paramFloat2;
    addHorizontalSurface(false, paramFloat3 / 2.0F);
    addHorizontalSurface(true, this._height / -2.0F);
    addVerticalSurface(true);
    addVerticalSurface(false);
  }
  
  /* Error */
  private void addHorizontalSurface(boolean arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  private void addQuad(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localFacesBufferedList = this._faces;
      s1 = (short)paramInt1;
      s2 = (short)paramInt2;
      s3 = (short)paramInt3;
      localFacesBufferedList.add(s1, s2, s3);
      this._faces.add(s2, (short)paramInt4, s3);
      return;
    }
    FacesBufferedList localFacesBufferedList = this._faces;
    short s1 = (short)paramInt3;
    short s2 = (short)paramInt4;
    short s3 = (short)paramInt1;
    localFacesBufferedList.add(s1, s2, s3);
    this._faces.add(s2, (short)paramInt2, s3);
  }
  
  /* Error */
  private void addVerticalSurface(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\HollowCylinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */