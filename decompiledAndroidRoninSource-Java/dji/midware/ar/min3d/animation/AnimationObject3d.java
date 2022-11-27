package dji.midware.ar.min3d.animation;

import dji.midware.ar.min3d.core.FacesBufferedList;
import dji.midware.ar.min3d.core.Object3d;
import dji.midware.ar.min3d.core.TextureList;
import dji.midware.ar.min3d.core.Vertices;

public class AnimationObject3d
  extends Object3d
{
  private int currentFrameIndex;
  private String currentFrameName;
  private long currentTime;
  private float fps = 70.0F;
  private KeyFrame[] frames;
  private float interpolation;
  private boolean isPlaying;
  private boolean loop = false;
  private int loopStartIndex;
  private int numFrames;
  private long startTime;
  private boolean updateVertices = true;
  
  public AnimationObject3d(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.numFrames = paramInt3;
    this.frames = new KeyFrame[paramInt3];
    this.currentFrameIndex = 0;
    this.isPlaying = false;
    this.interpolation = 0.0F;
    this._animationEnabled = true;
  }
  
  public AnimationObject3d(Vertices paramVertices, FacesBufferedList paramFacesBufferedList, TextureList paramTextureList, KeyFrame[] paramArrayOfKeyFrame)
  {
    super(paramVertices, paramFacesBufferedList, paramTextureList);
    this.numFrames = paramArrayOfKeyFrame.length;
    this.frames = paramArrayOfKeyFrame;
  }
  
  /* Error */
  public void addFrame(KeyFrame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Object3d clone(boolean paramBoolean)
  {
    return null;
  }
  
  public KeyFrame[] getClonedFrames()
  {
    return null;
  }
  
  public int getCurrentFrame()
  {
    return this.currentFrameIndex;
  }
  
  public float getFps()
  {
    return this.fps;
  }
  
  public boolean getUpdateVertices()
  {
    return this.updateVertices;
  }
  
  public void pause()
  {
    this.isPlaying = false;
  }
  
  /* Error */
  public void play()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void play(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void play(String paramString, boolean paramBoolean)
  {
    this.loop = paramBoolean;
    play(paramString);
  }
  
  public void setFps(float paramFloat)
  {
    this.fps = paramFloat;
  }
  
  public void setFrames(KeyFrame[] paramArrayOfKeyFrame)
  {
    this.frames = paramArrayOfKeyFrame;
  }
  
  public void setUpdateVertices(boolean paramBoolean)
  {
    this.updateVertices = paramBoolean;
  }
  
  public void stop()
  {
    this.isPlaying = false;
    this.currentFrameIndex = 0;
  }
  
  /* Error */
  public void update()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\animation\AnimationObject3d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */