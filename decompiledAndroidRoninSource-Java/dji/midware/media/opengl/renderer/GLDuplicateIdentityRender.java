package dji.midware.media.opengl.renderer;

import android.opengl.GLES20;

public class GLDuplicateIdentityRender
  extends GLIdentityRender
{
  public GLDuplicateIdentityRender(boolean paramBoolean)
  {
    super(paramBoolean);
    this.mTriangleVerticesData = new float[] { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  }
  
  public void preDrawArrays()
  {
    GLES20.glDrawArrays(5, 4, 4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\renderer\GLDuplicateIdentityRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */