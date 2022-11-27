package dji.publics.widget.djiviewpager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class OutlineContainer
  extends FrameLayout
  implements Animatable
{
  private static final long ANIMATION_DURATION = 500L;
  private static final long FRAME_DURATION = 16L;
  private float mAlpha = 1.0F;
  private final Interpolator mInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      return 0.0F;
    }
  };
  private boolean mIsRunning = false;
  private Paint mOutlinePaint;
  private long mStartTime;
  private final Runnable mUpdater = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public OutlineContainer(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void dispatchDraw(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  public void setOutlineAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\djiviewpager\OutlineContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */