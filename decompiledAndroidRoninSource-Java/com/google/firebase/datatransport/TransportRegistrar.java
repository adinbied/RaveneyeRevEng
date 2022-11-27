package com.google.firebase.datatransport;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;

public class TransportRegistrar
  implements ComponentRegistrar
{
  public List<Component<?>> getComponents()
  {
    return Collections.singletonList(Component.builder(TransportFactory.class).add(Dependency.required(Context.class)).factory(TransportRegistrar..Lambda.1.lambdaFactory$()).build());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\datatransport\TransportRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */