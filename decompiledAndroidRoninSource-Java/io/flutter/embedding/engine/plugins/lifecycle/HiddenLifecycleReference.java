package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.lifecycle.Lifecycle;

public class HiddenLifecycleReference
{
  private final Lifecycle lifecycle;
  
  public HiddenLifecycleReference(Lifecycle paramLifecycle)
  {
    this.lifecycle = paramLifecycle;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\lifecycle\HiddenLifecycleReference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */