package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.gestures.OnGestureListener;
import uk.co.senab.photoview.gestures.VersionedGestureDetector;
import uk.co.senab.photoview.scrollerproxy.ScrollerProxy;

public class PhotoViewAttacher
  implements IPhotoView, View.OnTouchListener, OnGestureListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private static final boolean DEBUG = Log.isLoggable("PhotoViewAttacher", 3);
  static final int EDGE_BOTH = 2;
  static final int EDGE_LEFT = 0;
  static final int EDGE_NONE = -1;
  static final int EDGE_RIGHT = 1;
  private static final String LOG_TAG = "PhotoViewAttacher";
  static int SINGLE_TOUCH = 1;
  int ZOOM_DURATION = 200;
  private boolean mAllowParentInterceptOnEdge = true;
  private final Matrix mBaseMatrix = new Matrix();
  private float mBaseRotation;
  private boolean mBlockParentIntercept = false;
  private FlingRunnable mCurrentFlingRunnable;
  private final RectF mDisplayRect = new RectF();
  private final Matrix mDrawMatrix = new Matrix();
  private android.view.GestureDetector mGestureDetector;
  private WeakReference<ImageView> mImageView;
  private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
  private int mIvBottom;
  private int mIvLeft;
  private int mIvRight;
  private int mIvTop;
  private View.OnLongClickListener mLongClickListener;
  private OnMatrixChangedListener mMatrixChangeListener;
  private final float[] mMatrixValues = new float[9];
  private float mMaxScale = 3.0F;
  private float mMidScale = 1.75F;
  private float mMinScale = 1.0F;
  private OnPhotoTapListener mPhotoTapListener;
  private OnScaleChangeListener mScaleChangeListener;
  private uk.co.senab.photoview.gestures.GestureDetector mScaleDragDetector;
  private ImageView.ScaleType mScaleType = ImageView.ScaleType.FIT_CENTER;
  private int mScrollEdge = 2;
  private OnSingleFlingListener mSingleFlingListener;
  private final Matrix mSuppMatrix = new Matrix();
  private OnViewTapListener mViewTapListener;
  private boolean mZoomEnabled;
  
  public PhotoViewAttacher(ImageView paramImageView)
  {
    this(paramImageView, true);
  }
  
  public PhotoViewAttacher(ImageView paramImageView, boolean paramBoolean)
  {
    this.mImageView = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    setImageViewScaleTypeMatrix(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.mScaleDragDetector = VersionedGestureDetector.newInstance(paramImageView.getContext(), this);
    paramImageView = new android.view.GestureDetector(paramImageView.getContext(), new GestureDetector.SimpleOnGestureListener()
    {
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      /* Error */
      public void onLongPress(MotionEvent arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
    this.mGestureDetector = paramImageView;
    paramImageView.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
    this.mBaseRotation = 0.0F;
    setZoomable(paramBoolean);
  }
  
  /* Error */
  private void cancelFling()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkAndDisplayMatrix()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkImageViewScaleType()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkMatrixBounds()
  {
    return false;
  }
  
  private static void checkZoomLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
    {
      if (paramFloat2 < paramFloat3) {
        return;
      }
      throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
    }
    throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
  }
  
  private RectF getDisplayRect(Matrix paramMatrix)
  {
    return null;
  }
  
  private Matrix getDrawMatrix()
  {
    return null;
  }
  
  private int getImageViewHeight(ImageView paramImageView)
  {
    return 0;
  }
  
  private int getImageViewWidth(ImageView paramImageView)
  {
    return 0;
  }
  
  private float getValue(Matrix paramMatrix, int paramInt)
  {
    return 0.0F;
  }
  
  private static boolean hasDrawable(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }
  
  private static boolean isSupportedScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    if (2.$SwitchMap$android$widget$ImageView$ScaleType[paramScaleType.ordinal()] != 1) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramScaleType.name());
    localStringBuilder.append(" is not supported in PhotoView");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  /* Error */
  private void resetMatrix()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setImageViewMatrix(Matrix arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static void setImageViewScaleTypeMatrix(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof IPhotoView)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  /* Error */
  private void updateBaseMatrix(android.graphics.drawable.Drawable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean canZoom()
  {
    return this.mZoomEnabled;
  }
  
  /* Error */
  public void cleanup()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getDisplayMatrix(Matrix paramMatrix)
  {
    paramMatrix.set(getDrawMatrix());
  }
  
  public RectF getDisplayRect()
  {
    return null;
  }
  
  public IPhotoView getIPhotoViewImplementation()
  {
    return this;
  }
  
  public Matrix getImageMatrix()
  {
    return this.mDrawMatrix;
  }
  
  public ImageView getImageView()
  {
    return null;
  }
  
  public float getMaximumScale()
  {
    return this.mMaxScale;
  }
  
  public float getMediumScale()
  {
    return this.mMidScale;
  }
  
  public float getMinimumScale()
  {
    return this.mMinScale;
  }
  
  OnPhotoTapListener getOnPhotoTapListener()
  {
    return this.mPhotoTapListener;
  }
  
  OnViewTapListener getOnViewTapListener()
  {
    return this.mViewTapListener;
  }
  
  public float getScale()
  {
    return 0.0F;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void getSuppMatrix(Matrix paramMatrix)
  {
    paramMatrix.set(this.mSuppMatrix);
  }
  
  public Bitmap getVisibleRectangleBitmap()
  {
    return null;
  }
  
  /* Error */
  public void onDrag(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onFling(float arg1, float arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void onGlobalLayout()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onScale(float arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.mAllowParentInterceptOnEdge = paramBoolean;
  }
  
  /* Error */
  public void setBaseRotation(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean setDisplayMatrix(Matrix paramMatrix)
  {
    return false;
  }
  
  /* Error */
  public void setMaximumScale(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMediumScale(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMinimumScale(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.mLongClickListener = paramOnLongClickListener;
  }
  
  public void setOnMatrixChangeListener(OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    this.mMatrixChangeListener = paramOnMatrixChangedListener;
  }
  
  public void setOnPhotoTapListener(OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.mPhotoTapListener = paramOnPhotoTapListener;
  }
  
  public void setOnScaleChangeListener(OnScaleChangeListener paramOnScaleChangeListener)
  {
    this.mScaleChangeListener = paramOnScaleChangeListener;
  }
  
  public void setOnSingleFlingListener(OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.mSingleFlingListener = paramOnSingleFlingListener;
  }
  
  public void setOnViewTapListener(OnViewTapListener paramOnViewTapListener)
  {
    this.mViewTapListener = paramOnViewTapListener;
  }
  
  /* Error */
  public void setRotationBy(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setRotationTo(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setScale(float paramFloat)
  {
    setScale(paramFloat, false);
  }
  
  /* Error */
  public void setScale(float arg1, float arg2, float arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void setScale(float arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    checkZoomLevels(paramFloat1, paramFloat2, paramFloat3);
    this.mMinScale = paramFloat1;
    this.mMidScale = paramFloat2;
    this.mMaxScale = paramFloat3;
  }
  
  /* Error */
  public void setScaleType(ImageView.ScaleType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setZoomInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 200;
    }
    this.ZOOM_DURATION = i;
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.mZoomEnabled = paramBoolean;
    update();
  }
  
  /* Error */
  public void update()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class AnimatedZoomRunnable
    implements Runnable
  {
    private final float mFocalX;
    private final float mFocalY;
    private final long mStartTime;
    private final float mZoomEnd;
    private final float mZoomStart;
    
    public AnimatedZoomRunnable(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mFocalX = paramFloat3;
      this.mFocalY = paramFloat4;
      this.mStartTime = System.currentTimeMillis();
      this.mZoomStart = paramFloat1;
      this.mZoomEnd = paramFloat2;
    }
    
    private float interpolate()
    {
      return 0.0F;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private class FlingRunnable
    implements Runnable
  {
    private int mCurrentX;
    private int mCurrentY;
    private final ScrollerProxy mScroller;
    
    public FlingRunnable(Context paramContext)
    {
      this.mScroller = ScrollerProxy.getScroller(paramContext);
    }
    
    /* Error */
    public void cancelFling()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void fling(int arg1, int arg2, int arg3, int arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore 5
      //   3: goto -3 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface OnMatrixChangedListener
  {
    public abstract void onMatrixChanged(RectF paramRectF);
  }
  
  public static abstract interface OnPhotoTapListener
  {
    public abstract void onOutsidePhotoTap();
    
    public abstract void onPhotoTap(View paramView, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface OnScaleChangeListener
  {
    public abstract void onScaleChange(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public static abstract interface OnSingleFlingListener
  {
    public abstract boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface OnViewTapListener
  {
    public abstract void onViewTap(View paramView, float paramFloat1, float paramFloat2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\PhotoViewAttacher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */