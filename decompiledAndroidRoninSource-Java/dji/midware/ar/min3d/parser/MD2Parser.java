package dji.midware.ar.min3d.parser;

import android.content.res.Resources;
import dji.midware.ar.min3d.animation.AnimationObject3d;
import dji.midware.ar.min3d.animation.KeyFrame;
import java.io.InputStream;

public class MD2Parser
  extends AParser
  implements IParser
{
  private String currentTextureName;
  private KeyFrame[] frames;
  private MD2Header header;
  
  public MD2Parser(Resources paramResources, InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramResources, paramInputStream, paramBoolean);
  }
  
  public MD2Parser(Resources paramResources, String paramString, boolean paramBoolean)
  {
    super(paramResources, paramString, Boolean.valueOf(paramBoolean));
  }
  
  /* Error */
  private void getFrames(java.io.BufferedInputStream arg1, byte[] arg2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getMaterials(java.io.BufferedInputStream arg1, byte[] arg2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getTexCoords(java.io.BufferedInputStream arg1, byte[] arg2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getTriangles(java.io.BufferedInputStream arg1, byte[] arg2)
    throws java.io.IOException
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
  
  /* Error */
  public void parse()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class MD2Header
  {
    public int frameSize;
    public int id;
    public int numFrames;
    public int numGLCommands;
    public int numSkins;
    public int numTexCoord;
    public int numTriangles;
    public int numVerts;
    public int offsetEnd;
    public int offsetFrames;
    public int offsetGLCommands;
    public int offsetSkins;
    public int offsetTexCoord;
    public int offsetTriangles;
    public int skinHeight;
    public int skinWidth;
    public int version;
    
    private MD2Header() {}
    
    /* Error */
    public void parse(InputStream arg1)
      throws java.lang.Exception
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\MD2Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */