package com.youth.banner.transformer;

public class RotateDownTransformer
  extends ABaseTransformer
{
  private static final float ROT_MOD = -15.0F;
  
  protected boolean isPagingEnabled()
  {
    return true;
  }
  
  /* Error */
  protected void onTransform(android.view.View arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\transformer\RotateDownTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */