package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Number3d;
import dji.midware.ar.min3d.vos.Uv;

public class Vertices
{
  private Color4BufferList _colors;
  private boolean _hasColors;
  private boolean _hasNormals;
  private boolean _hasUvs;
  private Number3dBufferList _normals;
  private Number3dBufferList _points;
  private UvBufferList _uvs;
  
  public Vertices(int paramInt)
  {
    this._points = new Number3dBufferList(paramInt);
    this._hasUvs = true;
    this._hasNormals = true;
    this._hasColors = true;
    if (1 != 0) {
      this._uvs = new UvBufferList(paramInt);
    }
    if (this._hasNormals) {
      this._normals = new Number3dBufferList(paramInt);
    }
    if (this._hasColors) {
      this._colors = new Color4BufferList(paramInt);
    }
  }
  
  public Vertices(int paramInt, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
  {
    this._points = new Number3dBufferList(paramInt);
    this._hasUvs = paramBoolean1.booleanValue();
    this._hasNormals = paramBoolean2.booleanValue();
    this._hasColors = paramBoolean3.booleanValue();
    if (this._hasUvs) {
      this._uvs = new UvBufferList(paramInt);
    }
    if (this._hasNormals) {
      this._normals = new Number3dBufferList(paramInt);
    }
    if (this._hasColors) {
      this._colors = new Color4BufferList(paramInt);
    }
  }
  
  public Vertices(Number3dBufferList paramNumber3dBufferList1, UvBufferList paramUvBufferList, Number3dBufferList paramNumber3dBufferList2, Color4BufferList paramColor4BufferList)
  {
    this._points = paramNumber3dBufferList1;
    this._uvs = paramUvBufferList;
    this._normals = paramNumber3dBufferList2;
    this._colors = paramColor4BufferList;
    boolean bool2 = true;
    boolean bool1;
    if ((paramUvBufferList != null) && (paramUvBufferList.size() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this._hasUvs = bool1;
    paramNumber3dBufferList1 = this._normals;
    if ((paramNumber3dBufferList1 != null) && (paramNumber3dBufferList1.size() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this._hasNormals = bool1;
    paramNumber3dBufferList1 = this._colors;
    if ((paramNumber3dBufferList1 != null) && (paramNumber3dBufferList1.size() > 0)) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this._hasColors = bool1;
  }
  
  public short addVertex(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    return 0;
  }
  
  public short addVertex(Number3d paramNumber3d1, Uv paramUv, Number3d paramNumber3d2, Color4 paramColor4)
  {
    return 0;
  }
  
  public int capacity()
  {
    return this._points.capacity();
  }
  
  public Vertices clone()
  {
    return null;
  }
  
  Color4BufferList colors()
  {
    return this._colors;
  }
  
  public boolean hasColors()
  {
    return this._hasColors;
  }
  
  public boolean hasNormals()
  {
    return this._hasNormals;
  }
  
  public boolean hasUvs()
  {
    return this._hasUvs;
  }
  
  Number3dBufferList normals()
  {
    return this._normals;
  }
  
  public void overwriteNormals(float[] paramArrayOfFloat)
  {
    this._normals.overwrite(paramArrayOfFloat);
  }
  
  public void overwriteVerts(float[] paramArrayOfFloat)
  {
    this._points.overwrite(paramArrayOfFloat);
  }
  
  Number3dBufferList points()
  {
    return this._points;
  }
  
  public int size()
  {
    return this._points.size();
  }
  
  UvBufferList uvs()
  {
    return this._uvs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Vertices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */