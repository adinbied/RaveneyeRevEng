package dji.midware.ar.min3d.parser;

import dji.midware.ar.min3d.animation.AnimationObject3d;
import dji.midware.ar.min3d.core.Object3dContainer;

public abstract interface IParser
{
  public abstract AnimationObject3d getParsedAnimationObject();
  
  public abstract Object3dContainer getParsedObject();
  
  public abstract void parse();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\IParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */