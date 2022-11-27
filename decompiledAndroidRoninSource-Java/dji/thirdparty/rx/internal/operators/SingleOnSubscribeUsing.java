package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Single;
import dji.thirdparty.rx.Single.OnSubscribe;
import dji.thirdparty.rx.SingleSubscriber;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.functions.Func1;

public final class SingleOnSubscribeUsing<T, Resource>
  implements Single.OnSubscribe<T>
{
  final Action1<? super Resource> disposeAction;
  final boolean disposeEagerly;
  final Func0<Resource> resourceFactory;
  final Func1<? super Resource, ? extends Single<? extends T>> singleFactory;
  
  public SingleOnSubscribeUsing(Func0<Resource> paramFunc0, Func1<? super Resource, ? extends Single<? extends T>> paramFunc1, Action1<? super Resource> paramAction1, boolean paramBoolean)
  {
    this.resourceFactory = paramFunc0;
    this.singleFactory = paramFunc1;
    this.disposeAction = paramAction1;
    this.disposeEagerly = paramBoolean;
  }
  
  /* Error */
  public void call(SingleSubscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void handleSubscriptionTimeError(SingleSubscriber<? super T> arg1, Resource arg2, Throwable arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\SingleOnSubscribeUsing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */