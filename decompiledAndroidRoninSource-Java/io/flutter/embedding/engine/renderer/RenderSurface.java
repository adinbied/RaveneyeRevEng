package io.flutter.embedding.engine.renderer;

public abstract interface RenderSurface
{
  public abstract void attachToRenderer(FlutterRenderer paramFlutterRenderer);
  
  public abstract void detachFromRenderer();
  
  public abstract FlutterRenderer getAttachedRenderer();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\renderer\RenderSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */