package com.ronin.connect.wificonnect;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.IComponent;
import com.dji.componentbase.connect.wifi.cc.IConnectComponent;

public class RoninConnectComponent
  implements IComponent, IConnectComponent
{
  public String getName()
  {
    return "RoninConnectComponent";
  }
  
  public boolean onCall(CC paramCC)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\RoninConnectComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */