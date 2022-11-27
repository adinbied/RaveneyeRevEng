package dji.midware.ar.min3d.parser;

import android.content.res.Resources;
import java.io.InputStream;

public class Parser
{
  public static IParser createParser(Type paramType, Resources paramResources, InputStream paramInputStream, boolean paramBoolean)
  {
    int i = 1.$SwitchMap$dji$midware$ar$min3d$parser$Parser$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return new MD2Parser(paramResources, paramInputStream, paramBoolean);
      }
      return new Max3DSParser(paramResources, paramInputStream, paramBoolean);
    }
    return new ObjParser(paramResources, paramInputStream, paramBoolean);
  }
  
  public static IParser createParser(Type paramType, Resources paramResources, String paramString, boolean paramBoolean)
  {
    int i = 1.$SwitchMap$dji$midware$ar$min3d$parser$Parser$Type[paramType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return new MD2Parser(paramResources, paramString, paramBoolean);
      }
      return new Max3DSParser(paramResources, paramString, paramBoolean);
    }
    return new ObjParser(paramResources, paramString, paramBoolean);
  }
  
  public static enum Type
  {
    static
    {
      MAX_3DS = new Type("MAX_3DS", 1);
      Type localType = new Type("MD2", 2);
      MD2 = localType;
      $VALUES = new Type[] { OBJ, MAX_3DS, localType };
    }
    
    private Type() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\parser\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */