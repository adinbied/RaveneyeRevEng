package kotlin.coroutines.experimental.migration;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.experimental.AbstractCoroutineContextElement;
import kotlin.coroutines.experimental.CoroutineContext.Key;

@Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\b\002\030\000 \0072\0020\001:\001\007B\r\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\b"}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContextMigration;", "Lkotlin/coroutines/experimental/AbstractCoroutineContextElement;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Key", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
final class ExperimentalContextMigration
  extends AbstractCoroutineContextElement
{
  public static final Key Key = new Key(null);
  private final CoroutineContext context;
  
  public ExperimentalContextMigration(CoroutineContext paramCoroutineContext)
  {
    super((CoroutineContext.Key)Key);
    this.context = paramCoroutineContext;
  }
  
  public final CoroutineContext getContext()
  {
    return this.context;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\020\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\b\003\030\0002\b\022\004\022\0020\0020\001B\007\b\002¢\006\002\020\003¨\006\004"}, d2={"Lkotlin/coroutines/experimental/migration/ExperimentalContextMigration$Key;", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "Lkotlin/coroutines/experimental/migration/ExperimentalContextMigration;", "()V", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 15})
  public static final class Key
    implements CoroutineContext.Key<ExperimentalContextMigration>
  {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\coroutines\experimental\migration\ExperimentalContextMigration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */