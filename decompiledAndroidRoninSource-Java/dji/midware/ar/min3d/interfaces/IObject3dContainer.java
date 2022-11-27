package dji.midware.ar.min3d.interfaces;

import dji.midware.ar.min3d.core.Object3d;

public abstract interface IObject3dContainer
{
  public abstract void addChild(Object3d paramObject3d);
  
  public abstract void addChildAt(Object3d paramObject3d, int paramInt);
  
  public abstract Object3d getChildAt(int paramInt);
  
  public abstract Object3d getChildByName(String paramString);
  
  public abstract int getChildIndexOf(Object3d paramObject3d);
  
  public abstract int numChildren();
  
  public abstract boolean removeChild(Object3d paramObject3d);
  
  public abstract Object3d removeChildAt(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\interfaces\IObject3dContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */