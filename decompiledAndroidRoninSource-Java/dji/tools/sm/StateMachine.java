package dji.tools.sm;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

public class StateMachine
{
  public static final boolean HANDLED = true;
  public static final boolean NOT_HANDLED = false;
  private static final int SM_INIT_CMD = -2;
  private static final int SM_QUIT_CMD = -1;
  private String mName;
  private SmHandler mSmHandler;
  private HandlerThread mSmThread;
  
  protected StateMachine(String paramString)
  {
    HandlerThread localHandlerThread = new HandlerThread(paramString);
    this.mSmThread = localHandlerThread;
    localHandlerThread.start();
    initStateMachine(paramString, this.mSmThread.getLooper());
  }
  
  protected StateMachine(String paramString, Handler paramHandler)
  {
    initStateMachine(paramString, paramHandler.getLooper());
  }
  
  protected StateMachine(String paramString, Looper paramLooper)
  {
    initStateMachine(paramString, paramLooper);
  }
  
  /* Error */
  private void initStateMachine(String arg1, Looper arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final void addState(State paramState)
  {
    this.mSmHandler.addState(paramState, null);
  }
  
  public final void addState(State paramState1, State paramState2)
  {
    this.mSmHandler.addState(paramState1, paramState2);
  }
  
  public final Collection<LogRec> copyLogRecs()
  {
    return null;
  }
  
  public final void deferMessage(Message paramMessage)
  {
    this.mSmHandler.deferMessage(paramMessage);
  }
  
  /* Error */
  public void dump(java.io.FileDescriptor arg1, java.io.PrintWriter arg2, String[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public final IState getCurrentState()
  {
    return null;
  }
  
  public final Handler getHandler()
  {
    return this.mSmHandler;
  }
  
  public final LogRec getLogRec(int paramInt)
  {
    return null;
  }
  
  public final int getLogRecCount()
  {
    return 0;
  }
  
  public final int getLogRecMaxSize()
  {
    return 0;
  }
  
  public final int getLogRecSize()
  {
    return 0;
  }
  
  protected String getLogRecString(Message paramMessage)
  {
    return "";
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  protected String getWhatToString(int paramInt)
  {
    return null;
  }
  
  protected void haltedProcessMessage(Message paramMessage) {}
  
  protected final boolean hasDeferredMessages(int paramInt)
  {
    return false;
  }
  
  protected final boolean hasMessages(int paramInt)
  {
    return false;
  }
  
  public boolean isDbg()
  {
    return false;
  }
  
  protected final boolean isQuit(Message paramMessage)
  {
    return false;
  }
  
  protected void log(String paramString)
  {
    Log.d(this.mName, paramString);
  }
  
  protected void logd(String paramString)
  {
    Log.d(this.mName, paramString);
  }
  
  protected void loge(String paramString)
  {
    Log.e(this.mName, paramString);
  }
  
  protected void loge(String paramString, Throwable paramThrowable)
  {
    Log.e(this.mName, paramString, paramThrowable);
  }
  
  protected void logi(String paramString)
  {
    Log.i(this.mName, paramString);
  }
  
  protected void logv(String paramString)
  {
    Log.v(this.mName, paramString);
  }
  
  protected void logw(String paramString)
  {
    Log.w(this.mName, paramString);
  }
  
  public final Message obtainMessage()
  {
    return Message.obtain(this.mSmHandler);
  }
  
  public final Message obtainMessage(int paramInt)
  {
    return Message.obtain(this.mSmHandler, paramInt);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, 0);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3);
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return Message.obtain(this.mSmHandler, paramInt1, paramInt2, paramInt3, paramObject);
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    return Message.obtain(this.mSmHandler, paramInt, paramObject);
  }
  
  protected void onHalting() {}
  
  protected void onPostHandleMessage(Message paramMessage) {}
  
  protected void onPreHandleMessage(Message paramMessage) {}
  
  protected void onQuitting() {}
  
  /* Error */
  public final void quit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void quitNow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected boolean recordLogRec(Message paramMessage)
  {
    return true;
  }
  
  /* Error */
  protected final void removeDeferredMessages(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void removeMessages(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessage(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessage(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessage(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessage(int arg1, int arg2, int arg3, Object arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessage(int arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessage(Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(int arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(int arg1, int arg2, int arg3, Object arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(int arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected final void sendMessageAtFrontOfQueue(Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(int arg1, int arg2, int arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore 6
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(int arg1, int arg2, int arg3, Object arg4, long arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(int arg1, int arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 5
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(int arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(int arg1, Object arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void sendMessageDelayed(Message arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDbg(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public final void setInitialState(State paramState)
  {
    this.mSmHandler.setInitialState(paramState);
  }
  
  /* Error */
  public final void setLogOnlyTransitions(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public final void setLogRecSize(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
  
  public final void transitionTo(IState paramIState)
  {
    this.mSmHandler.transitionTo(paramIState);
  }
  
  /* Error */
  public final void transitionToHaltingState()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void unhandledMessage(Message arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class LogRec
  {
    private IState mDstState;
    private String mInfo;
    private IState mOrgState;
    private StateMachine mSm;
    private IState mState;
    private long mTime;
    private int mWhat;
    
    LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
    {
      update(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
    }
    
    public IState getDestState()
    {
      return this.mDstState;
    }
    
    public String getInfo()
    {
      return this.mInfo;
    }
    
    public IState getOriginalState()
    {
      return this.mOrgState;
    }
    
    public IState getState()
    {
      return this.mState;
    }
    
    public long getTime()
    {
      return this.mTime;
    }
    
    public long getWhat()
    {
      return this.mWhat;
    }
    
    public String toString()
    {
      return null;
    }
    
    /* Error */
    public void update(StateMachine arg1, Message arg2, String arg3, IState arg4, IState arg5, IState arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class LogRecords
  {
    private static final int DEFAULT_SIZE = 20;
    private int mCount = 0;
    private boolean mLogOnlyTransitions = false;
    private Vector<StateMachine.LogRec> mLogRecVector = new Vector();
    private int mMaxSize = 20;
    private int mOldestIndex = 0;
    
    /* Error */
    void add(StateMachine arg1, Message arg2, String arg3, IState arg4, IState arg5, IState arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    void cleanup()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    int count()
    {
      try
      {
        int i = this.mCount;
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    StateMachine.LogRec get(int paramInt)
    {
      return null;
    }
    
    boolean logOnlyTransitions()
    {
      try
      {
        boolean bool = this.mLogOnlyTransitions;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    void setLogOnlyTransitions(boolean paramBoolean)
    {
      try
      {
        this.mLogOnlyTransitions = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    void setSize(int paramInt)
    {
      try
      {
        this.mMaxSize = paramInt;
        this.mOldestIndex = 0;
        this.mCount = 0;
        this.mLogRecVector.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    int size()
    {
      return 0;
    }
  }
  
  private static class SmHandler
    extends Handler
  {
    private static final Object mSmHandlerObj = new Object();
    private boolean mDbg = false;
    private ArrayList<Message> mDeferredMessages = new ArrayList();
    private State mDestState;
    private HaltingState mHaltingState = new HaltingState(null);
    private boolean mHasQuit = false;
    private State mInitialState;
    private boolean mIsConstructionCompleted;
    private StateMachine.LogRecords mLogRecords = new StateMachine.LogRecords(null);
    private QuittingState mQuittingState = new QuittingState(null);
    private StateMachine mSm;
    private HashMap<State, StateInfo> mStateInfo = new HashMap();
    private StateInfo[] mStateStack;
    private int mStateStackTopIndex = -1;
    private StateInfo[] mTempStateStack;
    private int mTempStateStackCount;
    private boolean mTransitionInProgress = false;
    
    private SmHandler(Looper paramLooper, StateMachine paramStateMachine)
    {
      super();
      this.mSm = paramStateMachine;
      addState(this.mHaltingState, null);
      addState(this.mQuittingState, null);
    }
    
    private final StateInfo addState(State paramState1, State paramState2)
    {
      return null;
    }
    
    /* Error */
    private final void cleanupAfterQuitting()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private final void completeConstruction()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private final void deferMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final IState getCurrentState()
    {
      return null;
    }
    
    /* Error */
    private final void invokeEnterMethods(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private final void invokeExitMethods(StateInfo arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final boolean isDbg()
    {
      return this.mDbg;
    }
    
    private final boolean isQuit(Message paramMessage)
    {
      return false;
    }
    
    /* Error */
    private final void moveDeferredMessageAtFrontOfQueue()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final int moveTempStateStackToStateStack()
    {
      return 0;
    }
    
    /* Error */
    private void performTransitions(State arg1, Message arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final State processMsg(Message paramMessage)
    {
      return null;
    }
    
    /* Error */
    private final void quit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private final void quitNow()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final void setDbg(boolean paramBoolean)
    {
      this.mDbg = paramBoolean;
    }
    
    /* Error */
    private final void setInitialState(State arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private final void setupInitialStateStack()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private final StateInfo setupTempStateStackWithStatesToEnter(State paramState)
    {
      return null;
    }
    
    /* Error */
    private final void transitionTo(IState arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public final void handleMessage(Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    private class HaltingState
      extends State
    {
      private HaltingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        return false;
      }
    }
    
    private class QuittingState
      extends State
    {
      private QuittingState() {}
      
      public boolean processMessage(Message paramMessage)
      {
        return false;
      }
    }
    
    private class StateInfo
    {
      boolean active;
      StateInfo parentStateInfo;
      State state;
      
      private StateInfo() {}
      
      public String toString()
      {
        return null;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\tools\sm\StateMachine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */