package dji.midware.ar.min3d.objectPrimitives;

import android.graphics.Bitmap;
import dji.midware.ar.min3d.core.Object3dContainer;
import dji.midware.ar.min3d.core.TextureList;
import dji.midware.ar.min3d.vos.Color4;

public class SkyBox
  extends Object3dContainer
{
  private Color4 color;
  private Rectangle[] faces;
  private float halfSize;
  private int quality;
  private float size;
  
  public SkyBox(float paramFloat, int paramInt)
  {
    super(0, 0);
    this.size = paramFloat;
    this.halfSize = (paramFloat * 0.5F);
    this.quality = paramInt;
    build();
  }
  
  /* Error */
  private void build()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addTexture(Face arg1, int arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void addTexture(Face paramFace, Bitmap paramBitmap, String paramString)
  {
    if (paramFace == Face.All)
    {
      int i = 0;
      while (i < 6)
      {
        this.faces[i].textures().addById(paramString);
        i += 1;
      }
    }
    this.faces[paramFace.ordinal()].textures().addById(paramString);
  }
  
  public static enum Face
  {
    static
    {
      East = new Face("East", 1);
      South = new Face("South", 2);
      West = new Face("West", 3);
      Up = new Face("Up", 4);
      Down = new Face("Down", 5);
      Face localFace = new Face("All", 6);
      All = localFace;
      $VALUES = new Face[] { North, East, South, West, Up, Down, localFace };
    }
    
    private Face() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\objectPrimitives\SkyBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */