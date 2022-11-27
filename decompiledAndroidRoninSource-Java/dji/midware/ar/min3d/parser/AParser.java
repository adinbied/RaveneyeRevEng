package dji.midware.ar.min3d.parser;

import android.content.res.Resources;
import android.graphics.Bitmap;
import dji.midware.ar.min3d.animation.AnimationObject3d;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Number3d;
import dji.midware.ar.min3d.vos.Uv;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public abstract class AParser
  implements IParser
{
  protected ParseObjectData co;
  protected String currentMaterialKey;
  protected boolean firstObject = true;
  protected boolean generateMipMap;
  protected InputStream inputStream;
  protected HashMap<String, Material> materialMap = new HashMap();
  protected ArrayList<Number3d> normals = new ArrayList();
  protected String packageID;
  protected ArrayList<ParseObjectData> parseObjects = new ArrayList();
  protected String resourceID;
  protected Resources resources;
  protected ArrayList<Uv> texCoords = new ArrayList();
  protected TextureAtlas textureAtlas = new TextureAtlas();
  protected ArrayList<Number3d> vertices = new ArrayList();
  
  public AParser() {}
  
  public AParser(Resources paramResources, InputStream paramInputStream, boolean paramBoolean)
  {
    this();
    this.resources = paramResources;
    this.inputStream = paramInputStream;
    this.generateMipMap = paramBoolean;
  }
  
  public AParser(Resources paramResources, String paramString, Boolean paramBoolean)
  {
    this();
    this.resources = paramResources;
    this.resourceID = paramString;
    if (paramString.indexOf(":") > -1) {
      this.packageID = paramString.split(":")[0];
    }
    this.generateMipMap = paramBoolean.booleanValue();
  }
  
  /* Error */
  protected void cleanup()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public AnimationObject3d getParsedAnimationObject()
  {
    return null;
  }
  
  public Object3dContainer getParsedObject()
  {
    return null;
  }
  
  public void parse() {}
  
  protected float readFloat(InputStream paramInputStream)
    throws IOException
  {
    return Float.intBitsToFloat(readInt(paramInputStream));
  }
  
  protected int readInt(InputStream paramInputStream)
    throws IOException
  {
    return 0;
  }
  
  protected int readShort(InputStream paramInputStream)
    throws IOException
  {
    return 0;
  }
  
  protected String readString(InputStream paramInputStream)
    throws IOException
  {
    return null;
  }
  
  protected class BitmapAsset
  {
    public Bitmap bitmap;
    public String key;
    public String resourceID;
    public float uOffset;
    public float uScale;
    public boolean useForAtlasDimensions;
    public float vOffset;
    public float vScale;
    
    public BitmapAsset(String paramString1, String paramString2)
    {
      this.key = paramString1;
      this.resourceID = paramString2;
      this.useForAtlasDimensions = false;
    }
  }
  
  protected class Material
  {
    public Color4 diffuseColor;
    public String diffuseTextureMap;
    public String name;
    
    public Material(String paramString)
    {
      this.name = paramString;
    }
  }
  
  protected class TextureAtlas
  {
    private Bitmap atlas;
    private String atlasId;
    private ArrayList<AParser.BitmapAsset> bitmaps = new ArrayList();
    
    public TextureAtlas() {}
    
    /* Error */
    public void addBitmapAsset(AParser.BitmapAsset arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void cleanup()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void generate()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public Bitmap getBitmap()
    {
      return this.atlas;
    }
    
    public AParser.BitmapAsset getBitmapAssetByName(String paramString)
    {
      return null;
    }
    
    public AParser.BitmapAsset getBitmapAssetByResourceID(String paramString)
    {
      return null;
    }
    
    public String getId()
    {
      return this.atlasId;
    }
    
    public boolean hasBitmaps()
    {
      return false;
    }
    
    public void setId(String paramString)
    {
      this.atlasId = paramString;
    }
    
    private class BitmapHeightComparer
      implements Comparator<AParser.BitmapAsset>
    {
      private BitmapHeightComparer() {}
      
      public int compare(AParser.BitmapAsset paramBitmapAsset1, AParser.BitmapAsset paramBitmapAsset2)
      {
        int i = paramBitmapAsset1.bitmap.getHeight();
        int j = paramBitmapAsset2.bitmap.getHeight();
        if (i < j) {
          return 1;
        }
        if (i == j) {
          return 0;
        }
        return -1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\AParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */