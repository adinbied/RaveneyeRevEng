package kotlin.annotation;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2={"Lkotlin/annotation/AnnotationRetention;", "", "(Ljava/lang/String;I)V", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"}, k=1, mv={1, 1, 15})
public enum AnnotationRetention
{
  static
  {
    AnnotationRetention localAnnotationRetention1 = new AnnotationRetention("SOURCE", 0);
    SOURCE = localAnnotationRetention1;
    AnnotationRetention localAnnotationRetention2 = new AnnotationRetention("BINARY", 1);
    BINARY = localAnnotationRetention2;
    AnnotationRetention localAnnotationRetention3 = new AnnotationRetention("RUNTIME", 2);
    RUNTIME = localAnnotationRetention3;
    $VALUES = new AnnotationRetention[] { localAnnotationRetention1, localAnnotationRetention2, localAnnotationRetention3 };
  }
  
  private AnnotationRetention() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\annotation\AnnotationRetention.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */