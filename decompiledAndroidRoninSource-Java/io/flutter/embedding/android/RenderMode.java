package io.flutter.embedding.android;

public enum RenderMode
{
  static
  {
    RenderMode localRenderMode = new RenderMode("texture", 1);
    texture = localRenderMode;
    $VALUES = new RenderMode[] { surface, localRenderMode };
  }
  
  private RenderMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\RenderMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */