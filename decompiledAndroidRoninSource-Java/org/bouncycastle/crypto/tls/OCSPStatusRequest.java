package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.util.io.Streams;

public class OCSPStatusRequest
{
  protected Extensions requestExtensions;
  protected Vector responderIDList;
  
  public OCSPStatusRequest(Vector paramVector, Extensions paramExtensions)
  {
    this.responderIDList = paramVector;
    this.requestExtensions = paramExtensions;
  }
  
  public static OCSPStatusRequest parse(InputStream paramInputStream)
    throws IOException
  {
    Vector localVector = new Vector();
    int i = TlsUtils.readUint16(paramInputStream);
    if (i > 0)
    {
      localObject = new ByteArrayInputStream(TlsUtils.readFully(i, paramInputStream));
      do
      {
        localVector.addElement(ResponderID.getInstance(TlsUtils.readDERObject(TlsUtils.readOpaque16((InputStream)localObject))));
      } while (((ByteArrayInputStream)localObject).available() > 0);
    }
    Object localObject = null;
    i = TlsUtils.readUint16(paramInputStream);
    if (i > 0) {
      localObject = Extensions.getInstance(TlsUtils.readDERObject(TlsUtils.readFully(i, paramInputStream)));
    }
    return new OCSPStatusRequest(localVector, (Extensions)localObject);
  }
  
  public void encode(OutputStream paramOutputStream)
    throws IOException
  {
    Object localObject = this.responderIDList;
    if ((localObject != null) && (!((Vector)localObject).isEmpty()))
    {
      localObject = new ByteArrayOutputStream();
      int i = 0;
      while (i < this.responderIDList.size())
      {
        TlsUtils.writeOpaque16(((ResponderID)this.responderIDList.elementAt(i)).getEncoded("DER"), (OutputStream)localObject);
        i += 1;
      }
      TlsUtils.checkUint16(((ByteArrayOutputStream)localObject).size());
      TlsUtils.writeUint16(((ByteArrayOutputStream)localObject).size(), paramOutputStream);
      Streams.writeBufTo((ByteArrayOutputStream)localObject, paramOutputStream);
    }
    else
    {
      TlsUtils.writeUint16(0, paramOutputStream);
    }
    localObject = this.requestExtensions;
    if (localObject == null)
    {
      TlsUtils.writeUint16(0, paramOutputStream);
      return;
    }
    localObject = ((Extensions)localObject).getEncoded("DER");
    TlsUtils.checkUint16(localObject.length);
    TlsUtils.writeUint16(localObject.length, paramOutputStream);
    paramOutputStream.write((byte[])localObject);
  }
  
  public Extensions getRequestExtensions()
  {
    return this.requestExtensions;
  }
  
  public Vector getResponderIDList()
  {
    return this.responderIDList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\OCSPStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */