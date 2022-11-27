package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.drawable.FadeDrawable.OnFadeFinishedListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.gestures.GestureDetector.ClickListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2.Extras;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class AbstractDraweeController<T, INFO>
  implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener
{
  private static final Map<String, Object> COMPONENT_EXTRAS = ImmutableMap.of("component_tag", "drawee");
  private static final Map<String, Object> SHORTCUT_EXTRAS = ImmutableMap.of("origin", "memory_bitmap", "origin_sub", "shortcut");
  private static final Class<?> TAG = AbstractDraweeController.class;
  private Object mCallerContext;
  @Nullable
  private String mContentDescription;
  @Nullable
  protected ControllerListener<INFO> mControllerListener;
  protected ForwardingControllerListener2<INFO> mControllerListener2 = new ForwardingControllerListener2();
  @Nullable
  private Drawable mControllerOverlay;
  @Nullable
  private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
  @Nullable
  private DataSource<T> mDataSource;
  private final DeferredReleaser mDeferredReleaser;
  @Nullable
  protected Drawable mDrawable;
  private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
  @Nullable
  private T mFetchedImage;
  @Nullable
  private GestureDetector mGestureDetector;
  private boolean mHasFetchFailed;
  private String mId;
  private boolean mIsAttached;
  private boolean mIsRequestSubmitted;
  private boolean mIsVisibleInViewportHint;
  private boolean mJustConstructed = true;
  @Nullable
  protected LoggingListener mLoggingListener;
  private boolean mRetainImageOnFailure;
  @Nullable
  private RetryManager mRetryManager;
  @Nullable
  private SettableDraweeHierarchy mSettableDraweeHierarchy;
  private final Executor mUiThreadImmediateExecutor;
  
  public AbstractDraweeController(DeferredReleaser paramDeferredReleaser, Executor paramExecutor, String paramString, Object paramObject)
  {
    this.mDeferredReleaser = paramDeferredReleaser;
    this.mUiThreadImmediateExecutor = paramExecutor;
    init(paramString, paramObject);
  }
  
  @Nullable
  private Rect getDimensions()
  {
    SettableDraweeHierarchy localSettableDraweeHierarchy = this.mSettableDraweeHierarchy;
    if (localSettableDraweeHierarchy == null) {
      return null;
    }
    return localSettableDraweeHierarchy.getBounds();
  }
  
  private void init(String paramString, Object paramObject)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("AbstractDraweeController#init");
      }
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
      if ((!this.mJustConstructed) && (this.mDeferredReleaser != null)) {
        this.mDeferredReleaser.cancelDeferredRelease(this);
      }
      this.mIsAttached = false;
      this.mIsVisibleInViewportHint = false;
      releaseFetch();
      this.mRetainImageOnFailure = false;
      if (this.mRetryManager != null) {
        this.mRetryManager.init();
      }
      if (this.mGestureDetector != null)
      {
        this.mGestureDetector.init();
        this.mGestureDetector.setClickListener(this);
      }
      if ((this.mControllerListener instanceof InternalForwardingListener)) {
        ((InternalForwardingListener)this.mControllerListener).clearListeners();
      } else {
        this.mControllerListener = null;
      }
      this.mControllerViewportVisibilityListener = null;
      if (this.mSettableDraweeHierarchy != null)
      {
        this.mSettableDraweeHierarchy.reset();
        this.mSettableDraweeHierarchy.setControllerOverlay(null);
        this.mSettableDraweeHierarchy = null;
      }
      this.mControllerOverlay = null;
      if (FLog.isLoggable(2)) {
        FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString);
      }
      this.mId = paramString;
      this.mCallerContext = paramObject;
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      if (this.mLoggingListener != null) {
        setUpLoggingListener();
      }
      return;
    }
    finally {}
  }
  
  private boolean isExpectedDataSource(String paramString, DataSource<T> paramDataSource)
  {
    if ((paramDataSource == null) && (this.mDataSource == null)) {
      return true;
    }
    return (paramString.equals(this.mId)) && (paramDataSource == this.mDataSource) && (this.mIsRequestSubmitted);
  }
  
  private void logMessageAndFailure(String paramString, Throwable paramThrowable)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, paramThrowable);
    }
  }
  
  private void logMessageAndImage(String paramString, T paramT)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: %s: image: %s %x", new Object[] { Integer.valueOf(System.identityHashCode(this)), this.mId, paramString, getImageClass(paramT), Integer.valueOf(getImageHash(paramT)) });
    }
  }
  
  private ControllerListener2.Extras obtainExtras(@Nullable DataSource<T> paramDataSource, @Nullable INFO paramINFO, @Nullable Uri paramUri)
  {
    if (paramDataSource == null) {
      paramDataSource = null;
    } else {
      paramDataSource = paramDataSource.getExtras();
    }
    return obtainExtras(paramDataSource, obtainExtrasFromImage(paramINFO), paramUri);
  }
  
  private ControllerListener2.Extras obtainExtras(@Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2, @Nullable Uri paramUri)
  {
    Object localObject1 = this.mSettableDraweeHierarchy;
    Object localObject2;
    if ((localObject1 instanceof GenericDraweeHierarchy))
    {
      localObject1 = String.valueOf(((GenericDraweeHierarchy)localObject1).getActualImageScaleType());
      localObject2 = ((GenericDraweeHierarchy)this.mSettableDraweeHierarchy).getActualImageFocusPoint();
    }
    else
    {
      localObject1 = null;
      localObject2 = localObject1;
    }
    return MiddlewareUtils.obtainExtras(COMPONENT_EXTRAS, SHORTCUT_EXTRAS, paramMap1, getDimensions(), (String)localObject1, (PointF)localObject2, paramMap2, getCallerContext(), paramUri);
  }
  
  private void onFailureInternal(String paramString, DataSource<T> paramDataSource, Throwable paramThrowable, boolean paramBoolean)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
    }
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onFailure", paramThrowable);
      paramDataSource.close();
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return;
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramBoolean) {
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
    } else {
      paramString = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
    }
    localDraweeEventTracker.recordEvent(paramString);
    if (paramBoolean)
    {
      logMessageAndFailure("final_failed @ onFailure", paramThrowable);
      this.mDataSource = null;
      this.mHasFetchFailed = true;
      if (this.mRetainImageOnFailure)
      {
        paramString = this.mDrawable;
        if (paramString != null)
        {
          this.mSettableDraweeHierarchy.setImage(paramString, 1.0F, true);
          break label158;
        }
      }
      if (shouldRetryOnTap()) {
        this.mSettableDraweeHierarchy.setRetry(paramThrowable);
      } else {
        this.mSettableDraweeHierarchy.setFailure(paramThrowable);
      }
      label158:
      reportFailure(paramThrowable, paramDataSource);
    }
    else
    {
      logMessageAndFailure("intermediate_failed @ onFailure", paramThrowable);
      reportIntermediateFailure(paramThrowable);
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  private void onNewResultInternal(String paramString, DataSource<T> paramDataSource, @Nullable T paramT, float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
        }
        if (!isExpectedDataSource(paramString, paramDataSource))
        {
          logMessageAndImage("ignore_old_datasource @ onNewResult", paramT);
          releaseImage(paramT);
          paramDataSource.close();
          return;
        }
        Object localObject2 = this.mEventTracker;
        Object localObject1;
        if (paramBoolean1) {
          localObject1 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT;
        } else {
          localObject1 = DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT;
        }
        ((DraweeEventTracker)localObject2).recordEvent((DraweeEventTracker.Event)localObject1);
        try
        {
          localObject1 = createDrawable(paramT);
          localObject2 = this.mFetchedImage;
          localDrawable = this.mDrawable;
          this.mFetchedImage = paramT;
          this.mDrawable = ((Drawable)localObject1);
          if (!paramBoolean1) {}
        }
        catch (Exception localException)
        {
          Drawable localDrawable;
          logMessageAndImage("drawable_failed @ onNewResult", paramT);
          releaseImage(paramT);
          onFailureInternal(paramString, paramDataSource, localException, paramBoolean1);
          return;
        }
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      try
      {
        logMessageAndImage("set_final_result @ onNewResult", paramT);
        this.mDataSource = null;
        this.mSettableDraweeHierarchy.setImage((Drawable)localObject1, 1.0F, paramBoolean2);
        reportSuccess(paramString, paramT, paramDataSource);
        continue;
        if (paramBoolean3)
        {
          logMessageAndImage("set_temporary_result @ onNewResult", paramT);
          this.mSettableDraweeHierarchy.setImage((Drawable)localObject1, 1.0F, paramBoolean2);
          reportSuccess(paramString, paramT, paramDataSource);
        }
        else
        {
          logMessageAndImage("set_intermediate_result @ onNewResult", paramT);
          this.mSettableDraweeHierarchy.setImage((Drawable)localObject1, paramFloat, paramBoolean2);
          reportIntermediateSet(paramString, paramT);
        }
        if ((localDrawable != null) && (localDrawable != localObject1)) {
          releaseDrawable(localDrawable);
        }
        if ((localObject2 != null) && (localObject2 != paramT))
        {
          logMessageAndImage("release_previous_result @ onNewResult", localObject2);
          releaseImage(localObject2);
        }
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
        return;
      }
      finally {}
    }
    if ((localDrawable != null) && (localDrawable != localObject1)) {
      releaseDrawable(localDrawable);
    }
    if ((localObject2 != null) && (localObject2 != paramT))
    {
      logMessageAndImage("release_previous_result @ onNewResult", localObject2);
      releaseImage(localObject2);
    }
    throw paramString;
  }
  
  private void onProgressUpdateInternal(String paramString, DataSource<T> paramDataSource, float paramFloat, boolean paramBoolean)
  {
    if (!isExpectedDataSource(paramString, paramDataSource))
    {
      logMessageAndFailure("ignore_old_datasource @ onProgress", null);
      paramDataSource.close();
      return;
    }
    if (!paramBoolean) {
      this.mSettableDraweeHierarchy.setProgress(paramFloat, false);
    }
  }
  
  private void releaseFetch()
  {
    boolean bool = this.mIsRequestSubmitted;
    this.mIsRequestSubmitted = false;
    this.mHasFetchFailed = false;
    Object localObject1 = this.mDataSource;
    Map localMap = null;
    if (localObject1 != null)
    {
      localObject1 = ((DataSource)localObject1).getExtras();
      this.mDataSource.close();
      this.mDataSource = null;
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = this.mDrawable;
    if (localObject2 != null) {
      releaseDrawable((Drawable)localObject2);
    }
    if (this.mContentDescription != null) {
      this.mContentDescription = null;
    }
    this.mDrawable = null;
    localObject2 = this.mFetchedImage;
    if (localObject2 != null)
    {
      localMap = obtainExtrasFromImage(getImageInfo(localObject2));
      logMessageAndImage("release", this.mFetchedImage);
      releaseImage(this.mFetchedImage);
      this.mFetchedImage = null;
    }
    if (bool) {
      reportRelease((Map)localObject1, localMap);
    }
  }
  
  private void reportFailure(Throwable paramThrowable, @Nullable DataSource<T> paramDataSource)
  {
    paramDataSource = obtainExtras(paramDataSource, null, null);
    getControllerListener().onFailure(this.mId, paramThrowable);
    getControllerListener2().onFailure(this.mId, paramThrowable, paramDataSource);
  }
  
  private void reportIntermediateFailure(Throwable paramThrowable)
  {
    getControllerListener().onIntermediateImageFailed(this.mId, paramThrowable);
    getControllerListener2().onIntermediateImageFailed(this.mId);
  }
  
  private void reportIntermediateSet(String paramString, @Nullable T paramT)
  {
    paramT = getImageInfo(paramT);
    getControllerListener().onIntermediateImageSet(paramString, paramT);
    getControllerListener2().onIntermediateImageSet(paramString, paramT);
  }
  
  private void reportRelease(@Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2)
  {
    getControllerListener().onRelease(this.mId);
    getControllerListener2().onRelease(this.mId, obtainExtras(paramMap1, paramMap2, null));
  }
  
  private void reportSuccess(String paramString, @Nullable T paramT, @Nullable DataSource<T> paramDataSource)
  {
    paramT = getImageInfo(paramT);
    getControllerListener().onFinalImageSet(paramString, paramT, getAnimatable());
    getControllerListener2().onFinalImageSet(paramString, paramT, obtainExtras(paramDataSource, paramT, null));
  }
  
  private void setUpLoggingListener()
  {
    SettableDraweeHierarchy localSettableDraweeHierarchy = this.mSettableDraweeHierarchy;
    if ((localSettableDraweeHierarchy instanceof GenericDraweeHierarchy)) {
      ((GenericDraweeHierarchy)localSettableDraweeHierarchy).setOnFadeFinishedListener(new FadeDrawable.OnFadeFinishedListener()
      {
        public void onFadeFinished()
        {
          if (AbstractDraweeController.this.mLoggingListener != null) {
            AbstractDraweeController.this.mLoggingListener.onFadeFinished(AbstractDraweeController.this.mId);
          }
        }
      });
    }
  }
  
  private boolean shouldRetryOnTap()
  {
    if (this.mHasFetchFailed)
    {
      RetryManager localRetryManager = this.mRetryManager;
      if ((localRetryManager != null) && (localRetryManager.shouldRetryOnTap())) {
        return true;
      }
    }
    return false;
  }
  
  public void addControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    ControllerListener localControllerListener = this.mControllerListener;
    if ((localControllerListener instanceof InternalForwardingListener))
    {
      ((InternalForwardingListener)localControllerListener).addListener(paramControllerListener);
      return;
    }
    if (localControllerListener != null)
    {
      this.mControllerListener = InternalForwardingListener.createInternal(localControllerListener, paramControllerListener);
      return;
    }
    this.mControllerListener = paramControllerListener;
  }
  
  public void addControllerListener2(ControllerListener2<INFO> paramControllerListener2)
  {
    this.mControllerListener2.addListener(paramControllerListener2);
  }
  
  protected abstract Drawable createDrawable(T paramT);
  
  @Nullable
  public Animatable getAnimatable()
  {
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable instanceof Animatable)) {
      return (Animatable)localDrawable;
    }
    return null;
  }
  
  @Nullable
  protected T getCachedImage()
  {
    return null;
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  @Nullable
  public String getContentDescription()
  {
    return this.mContentDescription;
  }
  
  protected ControllerListener<INFO> getControllerListener()
  {
    ControllerListener localControllerListener2 = this.mControllerListener;
    ControllerListener localControllerListener1 = localControllerListener2;
    if (localControllerListener2 == null) {
      localControllerListener1 = BaseControllerListener.getNoOpListener();
    }
    return localControllerListener1;
  }
  
  protected ControllerListener2<INFO> getControllerListener2()
  {
    return this.mControllerListener2;
  }
  
  @Nullable
  protected Drawable getControllerOverlay()
  {
    return this.mControllerOverlay;
  }
  
  protected abstract DataSource<T> getDataSource();
  
  @Nullable
  protected GestureDetector getGestureDetector()
  {
    return this.mGestureDetector;
  }
  
  @Nullable
  public DraweeHierarchy getHierarchy()
  {
    return this.mSettableDraweeHierarchy;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  protected String getImageClass(@Nullable T paramT)
  {
    if (paramT != null) {
      return paramT.getClass().getSimpleName();
    }
    return "<null>";
  }
  
  protected int getImageHash(@Nullable T paramT)
  {
    return System.identityHashCode(paramT);
  }
  
  @Nullable
  protected abstract INFO getImageInfo(T paramT);
  
  @Nullable
  protected LoggingListener getLoggingListener()
  {
    return this.mLoggingListener;
  }
  
  @Nullable
  protected Uri getMainUri()
  {
    return null;
  }
  
  protected RetryManager getRetryManager()
  {
    if (this.mRetryManager == null) {
      this.mRetryManager = new RetryManager();
    }
    return this.mRetryManager;
  }
  
  protected void initialize(String paramString, Object paramObject)
  {
    init(paramString, paramObject);
    this.mJustConstructed = false;
  }
  
  @Nullable
  public abstract Map<String, Object> obtainExtrasFromImage(INFO paramINFO);
  
  public void onAttach()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
    }
    if (FLog.isLoggable(2))
    {
      Class localClass = TAG;
      int i = System.identityHashCode(this);
      String str2 = this.mId;
      String str1;
      if (this.mIsRequestSubmitted) {
        str1 = "request already submitted";
      } else {
        str1 = "request needs submit";
      }
      FLog.v(localClass, "controller %x %s: onAttach: %s", Integer.valueOf(i), str2, str1);
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
    Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
    this.mDeferredReleaser.cancelDeferredRelease(this);
    this.mIsAttached = true;
    if (!this.mIsRequestSubmitted) {
      submitRequest();
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  public boolean onClick()
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
    }
    if (shouldRetryOnTap())
    {
      this.mRetryManager.notifyTapToRetry();
      this.mSettableDraweeHierarchy.reset();
      submitRequest();
      return true;
    }
    return false;
  }
  
  public void onDetach()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
    }
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
    this.mIsAttached = false;
    this.mDeferredReleaser.scheduleDeferredRelease(this);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  protected void onImageLoadedFromCacheImmediately(String paramString, T paramT) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramMotionEvent);
    }
    GestureDetector localGestureDetector = this.mGestureDetector;
    if (localGestureDetector == null) {
      return false;
    }
    if ((!localGestureDetector.isCapturingGesture()) && (!shouldHandleGesture())) {
      return false;
    }
    this.mGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void onViewportVisibilityHint(boolean paramBoolean)
  {
    ControllerViewportVisibilityListener localControllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
    if (localControllerViewportVisibilityListener != null) {
      if ((paramBoolean) && (!this.mIsVisibleInViewportHint)) {
        localControllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
      } else if ((!paramBoolean) && (this.mIsVisibleInViewportHint)) {
        localControllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
      }
    }
    this.mIsVisibleInViewportHint = paramBoolean;
  }
  
  public void release()
  {
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
    Object localObject = this.mRetryManager;
    if (localObject != null) {
      ((RetryManager)localObject).reset();
    }
    localObject = this.mGestureDetector;
    if (localObject != null) {
      ((GestureDetector)localObject).reset();
    }
    localObject = this.mSettableDraweeHierarchy;
    if (localObject != null) {
      ((SettableDraweeHierarchy)localObject).reset();
    }
    releaseFetch();
  }
  
  protected abstract void releaseDrawable(@Nullable Drawable paramDrawable);
  
  protected abstract void releaseImage(@Nullable T paramT);
  
  public void removeControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    Preconditions.checkNotNull(paramControllerListener);
    ControllerListener localControllerListener = this.mControllerListener;
    if ((localControllerListener instanceof InternalForwardingListener))
    {
      ((InternalForwardingListener)localControllerListener).removeListener(paramControllerListener);
      return;
    }
    if (localControllerListener == paramControllerListener) {
      this.mControllerListener = null;
    }
  }
  
  public void removeControllerListener2(ControllerListener2<INFO> paramControllerListener2)
  {
    this.mControllerListener2.removeListener(paramControllerListener2);
  }
  
  protected void reportSubmit(DataSource<T> paramDataSource, @Nullable INFO paramINFO)
  {
    getControllerListener().onSubmit(this.mId, this.mCallerContext);
    getControllerListener2().onSubmit(this.mId, this.mCallerContext, obtainExtras(paramDataSource, paramINFO, getMainUri()));
  }
  
  public void setContentDescription(@Nullable String paramString)
  {
    this.mContentDescription = paramString;
  }
  
  protected void setControllerOverlay(@Nullable Drawable paramDrawable)
  {
    this.mControllerOverlay = paramDrawable;
    SettableDraweeHierarchy localSettableDraweeHierarchy = this.mSettableDraweeHierarchy;
    if (localSettableDraweeHierarchy != null) {
      localSettableDraweeHierarchy.setControllerOverlay(paramDrawable);
    }
  }
  
  public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener paramControllerViewportVisibilityListener)
  {
    this.mControllerViewportVisibilityListener = paramControllerViewportVisibilityListener;
  }
  
  protected void setGestureDetector(@Nullable GestureDetector paramGestureDetector)
  {
    this.mGestureDetector = paramGestureDetector;
    if (paramGestureDetector != null) {
      paramGestureDetector.setClickListener(this);
    }
  }
  
  public void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy)
  {
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, paramDraweeHierarchy);
    }
    DraweeEventTracker localDraweeEventTracker = this.mEventTracker;
    if (paramDraweeHierarchy != null) {
      localObject = DraweeEventTracker.Event.ON_SET_HIERARCHY;
    } else {
      localObject = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY;
    }
    localDraweeEventTracker.recordEvent((DraweeEventTracker.Event)localObject);
    if (this.mIsRequestSubmitted)
    {
      this.mDeferredReleaser.cancelDeferredRelease(this);
      release();
    }
    Object localObject = this.mSettableDraweeHierarchy;
    if (localObject != null)
    {
      ((SettableDraweeHierarchy)localObject).setControllerOverlay(null);
      this.mSettableDraweeHierarchy = null;
    }
    if (paramDraweeHierarchy != null)
    {
      Preconditions.checkArgument(paramDraweeHierarchy instanceof SettableDraweeHierarchy);
      paramDraweeHierarchy = (SettableDraweeHierarchy)paramDraweeHierarchy;
      this.mSettableDraweeHierarchy = paramDraweeHierarchy;
      paramDraweeHierarchy.setControllerOverlay(this.mControllerOverlay);
    }
    if (this.mLoggingListener != null) {
      setUpLoggingListener();
    }
  }
  
  public void setLoggingListener(LoggingListener paramLoggingListener)
  {
    this.mLoggingListener = paramLoggingListener;
  }
  
  protected void setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
  }
  
  protected boolean shouldHandleGesture()
  {
    return shouldRetryOnTap();
  }
  
  protected void submitRequest()
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
    }
    Object localObject = getCachedImage();
    if (localObject != null)
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
      }
      this.mDataSource = null;
      this.mIsRequestSubmitted = true;
      this.mHasFetchFailed = false;
      this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
      reportSubmit(this.mDataSource, getImageInfo(localObject));
      onImageLoadedFromCacheImmediately(this.mId, localObject);
      onNewResultInternal(this.mId, this.mDataSource, localObject, 1.0F, true, true, true);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return;
    }
    this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
    this.mSettableDraweeHierarchy.setProgress(0.0F, true);
    this.mIsRequestSubmitted = true;
    this.mHasFetchFailed = false;
    localObject = getDataSource();
    this.mDataSource = ((DataSource)localObject);
    reportSubmit((DataSource)localObject, null);
    if (FLog.isLoggable(2)) {
      FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
    }
    localObject = new BaseDataSubscriber()
    {
      public void onFailureImpl(DataSource<T> paramAnonymousDataSource)
      {
        AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, paramAnonymousDataSource.getFailureCause(), true);
      }
      
      public void onNewResultImpl(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool1 = paramAnonymousDataSource.isFinished();
        boolean bool2 = paramAnonymousDataSource.hasMultipleResults();
        float f = paramAnonymousDataSource.getProgress();
        Object localObject = paramAnonymousDataSource.getResult();
        if (localObject != null)
        {
          AbstractDraweeController.this.onNewResultInternal(this.val$id, paramAnonymousDataSource, localObject, f, bool1, this.val$wasImmediate, bool2);
          return;
        }
        if (bool1) {
          AbstractDraweeController.this.onFailureInternal(this.val$id, paramAnonymousDataSource, new NullPointerException(), true);
        }
      }
      
      public void onProgressUpdate(DataSource<T> paramAnonymousDataSource)
      {
        boolean bool = paramAnonymousDataSource.isFinished();
        float f = paramAnonymousDataSource.getProgress();
        AbstractDraweeController.this.onProgressUpdateInternal(this.val$id, paramAnonymousDataSource, f, bool);
      }
    };
    this.mDataSource.subscribe((DataSubscriber)localObject, this.mUiThreadImmediateExecutor);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", this.mEventTracker.toString()).toString();
  }
  
  private static class InternalForwardingListener<INFO>
    extends ForwardingControllerListener<INFO>
  {
    public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> paramControllerListener1, ControllerListener<? super INFO> paramControllerListener2)
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
      }
      InternalForwardingListener localInternalForwardingListener = new InternalForwardingListener();
      localInternalForwardingListener.addListener(paramControllerListener1);
      localInternalForwardingListener.addListener(paramControllerListener2);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return localInternalForwardingListener;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\controller\AbstractDraweeController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */