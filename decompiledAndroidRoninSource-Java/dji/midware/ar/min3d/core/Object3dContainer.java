package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.interfaces.IObject3dContainer;
import java.util.ArrayList;

public class Object3dContainer
  extends Object3d
  implements IObject3dContainer
{
  protected ArrayList<Object3d> _children = new ArrayList();
  
  public Object3dContainer()
  {
    super(0, 0, localBoolean, localBoolean, localBoolean);
  }
  
  public Object3dContainer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, localBoolean, localBoolean, localBoolean);
  }
  
  public Object3dContainer(int paramInt1, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
  {
    super(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public Object3dContainer(Vertices paramVertices, FacesBufferedList paramFacesBufferedList, TextureList paramTextureList)
  {
    super(paramVertices, paramFacesBufferedList, paramTextureList);
  }
  
  /* Error */
  public void addChild(Object3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addChildAt(Object3d arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  ArrayList<Object3d> children()
  {
    return this._children;
  }
  
  public Object3dContainer clone()
  {
    return null;
  }
  
  public Object3d getChildAt(int paramInt)
  {
    return null;
  }
  
  public Object3d getChildByName(String paramString)
  {
    return null;
  }
  
  public int getChildIndexOf(Object3d paramObject3d)
  {
    return this._children.indexOf(paramObject3d);
  }
  
  public int numChildren()
  {
    return this._children.size();
  }
  
  public boolean removeChild(Object3d paramObject3d)
  {
    return false;
  }
  
  public Object3d removeChildAt(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Object3dContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */