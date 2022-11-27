package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.Client;
import java.util.ArrayList;

final class zaaq
  extends zaau
{
  private final ArrayList<Api.Client> zagp;
  
  public zaaq(ArrayList<Api.Client> paramArrayList)
  {
    super(paramArrayList, null);
    ArrayList localArrayList;
    this.zagp = localArrayList;
  }
  
  public final void zaan()
  {
    zaak.zad(this.zagj).zaee.zaha = zaak.zag(this.zagj);
    ArrayList localArrayList = (ArrayList)this.zagp;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList.get(i);
      i += 1;
      ((Api.Client)localObject).getRemoteService(zaak.zah(this.zagj), zaak.zad(this.zagj).zaee.zaha);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\zaaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */