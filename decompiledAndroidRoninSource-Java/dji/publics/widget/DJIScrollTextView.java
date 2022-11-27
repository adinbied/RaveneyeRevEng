package dji.publics.widget;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import dji.publics.DJIUI.DJITextView;

public class DJIScrollTextView
  extends DJITextView
{
  public DJIScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setMovementMethod(ScrollingMovementMethod.getInstance());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\DJIScrollTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */