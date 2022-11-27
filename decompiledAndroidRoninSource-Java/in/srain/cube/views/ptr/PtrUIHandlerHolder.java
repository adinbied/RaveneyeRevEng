package in.srain.cube.views.ptr;

class PtrUIHandlerHolder
  implements PtrUIHandler
{
  private PtrUIHandler mHandler;
  private PtrUIHandlerHolder mNext;
  
  public static void addHandler(PtrUIHandlerHolder paramPtrUIHandlerHolder, PtrUIHandler paramPtrUIHandler)
  {
    if (paramPtrUIHandler == null) {
      return;
    }
    if (paramPtrUIHandlerHolder == null) {
      return;
    }
    PtrUIHandlerHolder localPtrUIHandlerHolder = paramPtrUIHandlerHolder;
    if (paramPtrUIHandlerHolder.mHandler == null)
    {
      paramPtrUIHandlerHolder.mHandler = paramPtrUIHandler;
      return;
    }
    for (;;)
    {
      if (localPtrUIHandlerHolder.contains(paramPtrUIHandler)) {
        return;
      }
      paramPtrUIHandlerHolder = localPtrUIHandlerHolder.mNext;
      if (paramPtrUIHandlerHolder == null)
      {
        paramPtrUIHandlerHolder = new PtrUIHandlerHolder();
        paramPtrUIHandlerHolder.mHandler = paramPtrUIHandler;
        localPtrUIHandlerHolder.mNext = paramPtrUIHandlerHolder;
        return;
      }
      localPtrUIHandlerHolder = paramPtrUIHandlerHolder;
    }
  }
  
  private boolean contains(PtrUIHandler paramPtrUIHandler)
  {
    return false;
  }
  
  public static PtrUIHandlerHolder create()
  {
    return new PtrUIHandlerHolder();
  }
  
  private PtrUIHandler getHandler()
  {
    return this.mHandler;
  }
  
  public static PtrUIHandlerHolder removeHandler(PtrUIHandlerHolder paramPtrUIHandlerHolder, PtrUIHandler paramPtrUIHandler)
  {
    if ((paramPtrUIHandlerHolder != null) && (paramPtrUIHandler != null))
    {
      if (paramPtrUIHandlerHolder.mHandler == null) {
        return paramPtrUIHandlerHolder;
      }
      Object localObject2 = paramPtrUIHandlerHolder;
      Object localObject3 = null;
      PtrUIHandlerHolder localPtrUIHandlerHolder = paramPtrUIHandlerHolder;
      Object localObject1;
      do
      {
        if (localPtrUIHandlerHolder.contains(paramPtrUIHandler))
        {
          if (localObject3 == null)
          {
            localObject1 = localPtrUIHandlerHolder.mNext;
            localPtrUIHandlerHolder.mNext = null;
            paramPtrUIHandlerHolder = (PtrUIHandlerHolder)localObject1;
          }
          else
          {
            ((PtrUIHandlerHolder)localObject3).mNext = localPtrUIHandlerHolder.mNext;
            localPtrUIHandlerHolder.mNext = null;
            paramPtrUIHandlerHolder = ((PtrUIHandlerHolder)localObject3).mNext;
            localObject1 = localObject2;
          }
        }
        else
        {
          paramPtrUIHandlerHolder = localPtrUIHandlerHolder.mNext;
          localObject3 = localPtrUIHandlerHolder;
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        localPtrUIHandlerHolder = paramPtrUIHandlerHolder;
      } while (paramPtrUIHandlerHolder != null);
      paramPtrUIHandlerHolder = (PtrUIHandlerHolder)localObject1;
      if (localObject1 == null) {
        paramPtrUIHandlerHolder = new PtrUIHandlerHolder();
      }
      return paramPtrUIHandlerHolder;
    }
    return paramPtrUIHandlerHolder;
  }
  
  public boolean hasHandler()
  {
    return this.mHandler != null;
  }
  
  /* Error */
  public void onUIPositionChange(PtrFrameLayout arg1, boolean arg2, byte arg3, in.srain.cube.views.ptr.indicator.PtrIndicator arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUIRefreshBegin(PtrFrameLayout arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUIRefreshComplete(PtrFrameLayout arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUIRefreshPrepare(PtrFrameLayout arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onUIReset(PtrFrameLayout arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\ptr\PtrUIHandlerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */