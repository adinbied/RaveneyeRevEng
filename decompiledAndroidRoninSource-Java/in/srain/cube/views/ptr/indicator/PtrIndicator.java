package in.srain.cube.views.ptr.indicator;

import android.graphics.PointF;

public class PtrIndicator
{
  public static final int POS_START = 0;
  private int mCurrentPos = 0;
  private int mHeaderHeight;
  private boolean mIsUnderTouch = false;
  private int mLastPos = 0;
  private int mOffsetToKeepHeaderWhileLoading = -1;
  protected int mOffsetToRefresh = 0;
  private float mOffsetX;
  private float mOffsetY;
  private int mPressedPos = 0;
  private PointF mPtLastMove = new PointF();
  private float mRatioOfHeaderHeightToRefresh = 1.2F;
  private int mRefreshCompleteY = 0;
  private float mResistance = 1.7F;
  
  /* Error */
  public void convertFrom(PtrIndicator arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean crossRefreshLineFromTopToBottom()
  {
    return false;
  }
  
  public float getCurrentPercent()
  {
    return 0.0F;
  }
  
  public int getCurrentPosY()
  {
    return this.mCurrentPos;
  }
  
  public int getHeaderHeight()
  {
    return this.mHeaderHeight;
  }
  
  public float getLastPercent()
  {
    return 0.0F;
  }
  
  public int getLastPosY()
  {
    return this.mLastPos;
  }
  
  public int getOffsetToKeepHeaderWhileLoading()
  {
    int i = this.mOffsetToKeepHeaderWhileLoading;
    if (i >= 0) {
      return i;
    }
    return this.mHeaderHeight;
  }
  
  public int getOffsetToRefresh()
  {
    return this.mOffsetToRefresh;
  }
  
  public float getOffsetX()
  {
    return this.mOffsetX;
  }
  
  public float getOffsetY()
  {
    return this.mOffsetY;
  }
  
  public float getRatioOfHeaderToHeightRefresh()
  {
    return this.mRatioOfHeaderHeightToRefresh;
  }
  
  public float getResistance()
  {
    return this.mResistance;
  }
  
  public boolean goDownCrossFinishPosition()
  {
    return false;
  }
  
  public boolean hasJustBackToStartPosition()
  {
    return false;
  }
  
  public boolean hasJustLeftStartPosition()
  {
    return false;
  }
  
  public boolean hasJustReachedHeaderHeightFromTopToBottom()
  {
    return false;
  }
  
  public boolean hasLeftStartPosition()
  {
    return this.mCurrentPos > 0;
  }
  
  public boolean hasMovedAfterPressedDown()
  {
    return false;
  }
  
  public boolean isAlreadyHere(int paramInt)
  {
    return this.mCurrentPos == paramInt;
  }
  
  public boolean isInStartPosition()
  {
    return this.mCurrentPos == 0;
  }
  
  public boolean isOverOffsetToKeepHeaderWhileLoading()
  {
    return false;
  }
  
  public boolean isOverOffsetToRefresh()
  {
    return false;
  }
  
  public boolean isUnderTouch()
  {
    return this.mIsUnderTouch;
  }
  
  /* Error */
  public final void onMove(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onPressDown(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void onRelease()
  {
    this.mIsUnderTouch = false;
  }
  
  public void onUIRefreshComplete()
  {
    this.mRefreshCompleteY = this.mCurrentPos;
  }
  
  protected void onUpdatePos(int paramInt1, int paramInt2) {}
  
  protected void processOnMove(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    setOffset(paramFloat3, paramFloat4 / this.mResistance);
  }
  
  /* Error */
  public final void setCurrentPos(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.mHeaderHeight = paramInt;
    updateHeight();
  }
  
  protected void setOffset(float paramFloat1, float paramFloat2)
  {
    this.mOffsetX = paramFloat1;
    this.mOffsetY = paramFloat2;
  }
  
  public void setOffsetToKeepHeaderWhileLoading(int paramInt)
  {
    this.mOffsetToKeepHeaderWhileLoading = paramInt;
  }
  
  /* Error */
  public void setOffsetToRefresh(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRatioOfHeaderHeightToRefresh(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setResistance(float paramFloat)
  {
    this.mResistance = paramFloat;
  }
  
  public String toString()
  {
    return null;
  }
  
  /* Error */
  protected void updateHeight()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean willOverTop(int paramInt)
  {
    return paramInt < 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\indicator\PtrIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */