package dji.midware.ar.min3d.parser;

import android.content.res.Resources;
import dji.midware.ar.min3d.core.Object3dContainer;
import java.io.InputStream;
import java.util.StringTokenizer;

public class ObjParser
  extends AParser
  implements IParser
{
  private final String DIFFUSE_COLOR = "Kd";
  private final String DIFFUSE_TEX_MAP = "map_Kd";
  private final String FACE = "f";
  private final String MATERIAL_LIB = "mtllib";
  private final String NEW_MATERIAL = "newmtl";
  private final String NORMAL = "vn";
  private final String OBJECT = "o";
  private final String TEXCOORD = "vt";
  private final String USE_MATERIAL = "usemtl";
  private final String VERTEX = "v";
  
  public ObjParser(Resources paramResources, InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramResources, paramInputStream, paramBoolean);
  }
  
  public ObjParser(Resources paramResources, String paramString, boolean paramBoolean)
  {
    super(paramResources, paramString, Boolean.valueOf(paramBoolean));
  }
  
  /* Error */
  private void readMaterialLib(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void cleanup()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object3dContainer getParsedObject()
  {
    return null;
  }
  
  /* Error */
  public void parse()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class ObjFace
    extends ParseObjectFace
  {
    public ObjFace(String paramString1, String paramString2, int paramInt)
    {
      this.materialKey = paramString2;
      this.faceLength = paramInt;
      int i = paramString1.indexOf("//");
      boolean bool2 = false;
      if (i > -1) {
        i = 1;
      } else {
        i = 0;
      }
      this$1 = paramString1;
      if (i != 0) {
        this$1 = paramString1.replace("//", "/");
      }
      paramString1 = new StringTokenizer(ObjParser.this);
      paramString1.nextToken();
      this$1 = new StringTokenizer(paramString1.nextToken(), "/");
      int j = ObjParser.this.countTokens();
      boolean bool1;
      if ((j >= 2) && (i == 0)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.hasuv = bool1;
      if (j != 3)
      {
        bool1 = bool2;
        if (j == 2)
        {
          bool1 = bool2;
          if (i == 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      this.hasn = bool1;
      this.v = new int[paramInt];
      if (this.hasuv) {
        this.uv = new int[paramInt];
      }
      if (this.hasn) {
        this.n = new int[paramInt];
      }
      i = 1;
      while (i < paramInt + 1)
      {
        if (i > 1) {
          this$1 = new StringTokenizer(paramString1.nextToken(), "/");
        }
        j = i - 1;
        this.v[j] = ((short)(Short.parseShort(ObjParser.this.nextToken()) - 1));
        if (this.hasuv) {
          this.uv[j] = ((short)(Short.parseShort(ObjParser.this.nextToken()) - 1));
        }
        if (this.hasn) {
          this.n[j] = ((short)(Short.parseShort(ObjParser.this.nextToken()) - 1));
        }
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\ObjParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */