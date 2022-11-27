package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.interfaces.IDirtyParent;

public class FrustumManaged
  extends AbstractDirtyManaged
{
  private float _horizontalCenter;
  private float _shortSideLength;
  private float _verticalCenter;
  private float _zFar;
  private float _zNear;
  
  public FrustumManaged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._horizontalCenter = paramFloat1;
    this._verticalCenter = paramFloat2;
    this._shortSideLength = paramFloat3;
    this._zNear = paramFloat4;
    this._zFar = paramFloat5;
  }
  
  public FrustumManaged(IDirtyParent paramIDirtyParent)
  {
    super(paramIDirtyParent);
    this._horizontalCenter = 0.0F;
    this._verticalCenter = 0.0F;
    this._shortSideLength = 1.0F;
    this._zNear = 1.0F;
    this._zFar = 100.0F;
  }
  
  public float horizontalCenter()
  {
    return this._horizontalCenter;
  }
  
  public void horizontalCenter(float paramFloat)
  {
    this._horizontalCenter = paramFloat;
    setDirtyFlag();
  }
  
  public float shortSideLength()
  {
    return this._shortSideLength;
  }
  
  public void shortSideLength(float paramFloat)
  {
    this._shortSideLength = paramFloat;
    setDirtyFlag();
  }
  
  public float verticalCenter()
  {
    return this._verticalCenter;
  }
  
  public void verticalCenter(float paramFloat)
  {
    this._verticalCenter = paramFloat;
    setDirtyFlag();
  }
  
  public float zFar()
  {
    return this._zFar;
  }
  
  public void zFar(float paramFloat)
  {
    this._zFar = paramFloat;
    setDirtyFlag();
  }
  
  public float zNear()
  {
    return this._zNear;
  }
  
  public void zNear(float paramFloat)
  {
    this._zNear = paramFloat;
    setDirtyFlag();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\FrustumManaged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */