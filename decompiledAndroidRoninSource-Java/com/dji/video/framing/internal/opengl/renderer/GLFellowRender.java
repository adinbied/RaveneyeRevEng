package com.dji.video.framing.internal.opengl.renderer;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GLFellowRender
  extends GLIdentityRender
{
  private GLRenderBase mainRender;
  
  public GLFellowRender(boolean paramBoolean, GLRenderBase paramGLRenderBase)
  {
    super(paramBoolean);
    this.mainRender = paramGLRenderBase;
  }
  
  protected IntBuffer getTriangleVerticesIndices()
  {
    return this.mainRender.getTriangleVerticesIndices();
  }
  
  protected int getTriangleVerticesIndicesLength()
  {
    return this.mainRender.getTriangleVerticesIndicesLength();
  }
  
  protected FloatBuffer getTriangleVerticesPosBuffer()
  {
    return this.mainRender.getTriangleVerticesPosBuffer();
  }
  
  protected FloatBuffer getTriangleVerticesUvBuffer()
  {
    return this.mainRender.getTriangleVerticesUvBuffer();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLFellowRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */