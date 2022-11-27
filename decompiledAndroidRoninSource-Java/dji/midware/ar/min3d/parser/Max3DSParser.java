package dji.midware.ar.min3d.parser;

import android.content.res.Resources;
import dji.midware.ar.min3d.core.Object3dContainer;
import java.io.InputStream;

public class Max3DSParser
  extends AParser
  implements IParser
{
  private final int FACES = 16672;
  private final int IDENTIFIER_3DS = 19789;
  private final int MATERIAL = 45055;
  private final int MESH_BLOCK = 15677;
  private final int OBJECT_BLOCK = 16384;
  private final int TEXCOORD = 16704;
  private final int TEX_FILENAME = 41728;
  private final int TEX_MAP = 41472;
  private final int TEX_NAME = 40960;
  private final int TRIMESH = 16640;
  private final int TRI_MATERIAL = 16688;
  private final int VERTICES = 16656;
  private int chunkEndOffset;
  private int chunkID;
  private String currentObjName;
  private boolean endReached;
  
  public Max3DSParser(Resources paramResources, InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramResources, paramInputStream, paramBoolean);
  }
  
  public Max3DSParser(Resources paramResources, String paramString, boolean paramBoolean)
  {
    super(paramResources, paramString, Boolean.valueOf(paramBoolean));
  }
  
  /* Error */
  private void readChunk(InputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readFaces(InputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readHeader(InputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readTexCoords(InputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void readVertices(InputStream arg1)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void skipRead(InputStream arg1)
    throws java.io.IOException
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\Max3DSParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */