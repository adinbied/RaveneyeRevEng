package com.google.firebase.platforminfo;

import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;
import java.util.Iterator;
import java.util.Set;

public class DefaultUserAgentPublisher
  implements UserAgentPublisher
{
  private final GlobalLibraryVersionRegistrar gamesSDKRegistrar;
  private final String javaSDKVersionUserAgent;
  
  DefaultUserAgentPublisher(Set<LibraryVersion> paramSet, GlobalLibraryVersionRegistrar paramGlobalLibraryVersionRegistrar)
  {
    this.javaSDKVersionUserAgent = toUserAgent(paramSet);
    this.gamesSDKRegistrar = paramGlobalLibraryVersionRegistrar;
  }
  
  public static Component<UserAgentPublisher> component()
  {
    return Component.builder(UserAgentPublisher.class).add(Dependency.setOf(LibraryVersion.class)).factory(DefaultUserAgentPublisher..Lambda.1.lambdaFactory$()).build();
  }
  
  private static String toUserAgent(Set<LibraryVersion> paramSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      LibraryVersion localLibraryVersion = (LibraryVersion)paramSet.next();
      localStringBuilder.append(localLibraryVersion.getLibraryName());
      localStringBuilder.append('/');
      localStringBuilder.append(localLibraryVersion.getVersion());
      if (paramSet.hasNext()) {
        localStringBuilder.append(' ');
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getUserAgent()
  {
    if (this.gamesSDKRegistrar.getRegisteredVersions().isEmpty()) {
      return this.javaSDKVersionUserAgent;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.javaSDKVersionUserAgent);
    localStringBuilder.append(' ');
    localStringBuilder.append(toUserAgent(this.gamesSDKRegistrar.getRegisteredVersions()));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\platforminfo\DefaultUserAgentPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */