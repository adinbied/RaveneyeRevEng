package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.interfaces.IObject3dContainer;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Number3d;
import dji.midware.ar.min3d.vos.RenderType;
import dji.midware.ar.min3d.vos.ShadeModel;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

public class Object3d
{
  protected boolean _animationEnabled;
  protected ArrayList<Object3d> _children;
  private boolean _colorMaterialEnabled;
  private Color4 _defaultColor;
  private boolean _doubleSidedEnabled;
  protected FacesBufferedList _faces;
  private boolean _ignoreFaces;
  private volatile boolean _isVisible;
  private boolean _lightingEnabled;
  private boolean _lineSmoothing;
  private float _lineWidth;
  private String _name;
  private boolean _normalsEnabled;
  private IObject3dContainer _parent;
  private float _pointSize;
  private boolean _pointSmoothing;
  private Number3d _position;
  private RenderType _renderType = RenderType.TRIANGLES;
  private Number3d _rotation;
  private Number3d _scale;
  private Scene _scene;
  private ShadeModel _shadeModel;
  protected TextureList _textures;
  private boolean _texturesEnabled;
  private boolean _vertexColorsEnabled;
  protected Vertices _vertices;
  
  public Object3d(int paramInt1, int paramInt2)
  {
    Boolean localBoolean = Boolean.valueOf(true);
    this._isVisible = true;
    this._vertexColorsEnabled = true;
    this._doubleSidedEnabled = false;
    this._texturesEnabled = true;
    this._normalsEnabled = true;
    this._ignoreFaces = false;
    this._colorMaterialEnabled = false;
    this._lightingEnabled = true;
    this._position = new Number3d(0.0F, 0.0F, 0.0F);
    this._rotation = new Number3d(0.0F, 0.0F, 0.0F);
    this._scale = new Number3d(1.0F, 1.0F, 1.0F);
    this._defaultColor = new Color4();
    this._shadeModel = ShadeModel.SMOOTH;
    this._pointSize = 3.0F;
    this._pointSmoothing = true;
    this._lineWidth = 1.0F;
    this._lineSmoothing = false;
    this._animationEnabled = false;
    this._vertices = new Vertices(paramInt1, localBoolean, localBoolean, localBoolean);
    this._faces = new FacesBufferedList(paramInt2);
    this._textures = new TextureList();
  }
  
  public Object3d(int paramInt1, int paramInt2, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3)
  {
    this._isVisible = true;
    this._vertexColorsEnabled = true;
    this._doubleSidedEnabled = false;
    this._texturesEnabled = true;
    this._normalsEnabled = true;
    this._ignoreFaces = false;
    this._colorMaterialEnabled = false;
    this._lightingEnabled = true;
    this._position = new Number3d(0.0F, 0.0F, 0.0F);
    this._rotation = new Number3d(0.0F, 0.0F, 0.0F);
    this._scale = new Number3d(1.0F, 1.0F, 1.0F);
    this._defaultColor = new Color4();
    this._shadeModel = ShadeModel.SMOOTH;
    this._pointSize = 3.0F;
    this._pointSmoothing = true;
    this._lineWidth = 1.0F;
    this._lineSmoothing = false;
    this._animationEnabled = false;
    this._vertices = new Vertices(paramInt1, paramBoolean1, paramBoolean2, paramBoolean3);
    this._faces = new FacesBufferedList(paramInt2);
    this._textures = new TextureList();
  }
  
  public Object3d(Vertices paramVertices, FacesBufferedList paramFacesBufferedList, TextureList paramTextureList)
  {
    this._isVisible = true;
    this._vertexColorsEnabled = true;
    this._doubleSidedEnabled = false;
    this._texturesEnabled = true;
    this._normalsEnabled = true;
    this._ignoreFaces = false;
    this._colorMaterialEnabled = false;
    this._lightingEnabled = true;
    this._position = new Number3d(0.0F, 0.0F, 0.0F);
    this._rotation = new Number3d(0.0F, 0.0F, 0.0F);
    this._scale = new Number3d(1.0F, 1.0F, 1.0F);
    this._defaultColor = new Color4();
    this._shadeModel = ShadeModel.SMOOTH;
    this._pointSize = 3.0F;
    this._pointSmoothing = true;
    this._lineWidth = 1.0F;
    this._lineSmoothing = false;
    this._animationEnabled = false;
    this._vertices = paramVertices;
    this._faces = paramFacesBufferedList;
    this._textures = paramTextureList;
  }
  
  public void animationEnabled(boolean paramBoolean)
  {
    this._animationEnabled = paramBoolean;
  }
  
  public boolean animationEnabled()
  {
    return this._animationEnabled;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object3d clone()
  {
    return null;
  }
  
  public void colorMaterialEnabled(boolean paramBoolean)
  {
    this._colorMaterialEnabled = paramBoolean;
  }
  
  public boolean colorMaterialEnabled()
  {
    return this._colorMaterialEnabled;
  }
  
  public Color4BufferList colors()
  {
    return this._vertices.colors();
  }
  
  public Boolean customRenderer(GL10 paramGL10)
  {
    return Boolean.valueOf(false);
  }
  
  public Color4 defaultColor()
  {
    return this._defaultColor;
  }
  
  public void defaultColor(Color4 paramColor4)
  {
    this._defaultColor = paramColor4;
  }
  
  public void doubleSidedEnabled(boolean paramBoolean)
  {
    this._doubleSidedEnabled = paramBoolean;
  }
  
  public boolean doubleSidedEnabled()
  {
    return this._doubleSidedEnabled;
  }
  
  public FacesBufferedList faces()
  {
    return this._faces;
  }
  
  public boolean hasNormals()
  {
    return this._vertices.hasNormals();
  }
  
  public boolean hasUvs()
  {
    return this._vertices.hasUvs();
  }
  
  public boolean hasVertexColors()
  {
    return this._vertices.hasColors();
  }
  
  public void ignoreFaces(boolean paramBoolean)
  {
    this._ignoreFaces = paramBoolean;
  }
  
  public boolean ignoreFaces()
  {
    return this._ignoreFaces;
  }
  
  public void isVisible(Boolean paramBoolean)
  {
    this._isVisible = paramBoolean.booleanValue();
  }
  
  public boolean isVisible()
  {
    return this._isVisible;
  }
  
  public void lightingEnabled(boolean paramBoolean)
  {
    this._lightingEnabled = paramBoolean;
  }
  
  public boolean lightingEnabled()
  {
    return this._lightingEnabled;
  }
  
  public void lineSmoothing(boolean paramBoolean)
  {
    this._lineSmoothing = paramBoolean;
  }
  
  public boolean lineSmoothing()
  {
    return this._lineSmoothing;
  }
  
  public float lineWidth()
  {
    return this._lineWidth;
  }
  
  public void lineWidth(float paramFloat)
  {
    this._lineWidth = paramFloat;
  }
  
  public String name()
  {
    return this._name;
  }
  
  public void name(String paramString)
  {
    this._name = paramString;
  }
  
  public Number3dBufferList normals()
  {
    return this._vertices.normals();
  }
  
  public void normalsEnabled(boolean paramBoolean)
  {
    this._normalsEnabled = paramBoolean;
  }
  
  public boolean normalsEnabled()
  {
    return this._normalsEnabled;
  }
  
  public IObject3dContainer parent()
  {
    return this._parent;
  }
  
  void parent(IObject3dContainer paramIObject3dContainer)
  {
    this._parent = paramIObject3dContainer;
  }
  
  public float pointSize()
  {
    return this._pointSize;
  }
  
  public void pointSize(float paramFloat)
  {
    this._pointSize = paramFloat;
  }
  
  public void pointSmoothing(boolean paramBoolean)
  {
    this._pointSmoothing = paramBoolean;
  }
  
  public boolean pointSmoothing()
  {
    return this._pointSmoothing;
  }
  
  public Number3dBufferList points()
  {
    return this._vertices.points();
  }
  
  public Number3d position()
  {
    return this._position;
  }
  
  public RenderType renderType()
  {
    return this._renderType;
  }
  
  public void renderType(RenderType paramRenderType)
  {
    this._renderType = paramRenderType;
  }
  
  public Number3d rotation()
  {
    return this._rotation;
  }
  
  public Number3d scale()
  {
    return this._scale;
  }
  
  Scene scene()
  {
    return this._scene;
  }
  
  void scene(Scene paramScene)
  {
    this._scene = paramScene;
  }
  
  public ShadeModel shadeModel()
  {
    return this._shadeModel;
  }
  
  public void shadeModel(ShadeModel paramShadeModel)
  {
    this._shadeModel = paramShadeModel;
  }
  
  public TextureList textures()
  {
    return this._textures;
  }
  
  public void texturesEnabled(Boolean paramBoolean)
  {
    this._texturesEnabled = paramBoolean.booleanValue();
  }
  
  public boolean texturesEnabled()
  {
    return this._texturesEnabled;
  }
  
  public UvBufferList uvs()
  {
    return this._vertices.uvs();
  }
  
  public void vertexColorsEnabled(Boolean paramBoolean)
  {
    this._vertexColorsEnabled = paramBoolean.booleanValue();
  }
  
  public boolean vertexColorsEnabled()
  {
    return this._vertexColorsEnabled;
  }
  
  public Vertices vertices()
  {
    return this._vertices;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Object3d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */