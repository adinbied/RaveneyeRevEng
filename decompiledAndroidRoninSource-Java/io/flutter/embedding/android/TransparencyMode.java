package io.flutter.embedding.android;

public enum TransparencyMode
{
  static
  {
    TransparencyMode localTransparencyMode = new TransparencyMode("transparent", 1);
    transparent = localTransparencyMode;
    $VALUES = new TransparencyMode[] { opaque, localTransparencyMode };
  }
  
  private TransparencyMode() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\TransparencyMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */