package org.bouncycastle.jce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import javax.crypto.Mac;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;

public class PKCS12Util
{
  private static byte[] calculatePbeMac(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte1, int paramInt, char[] paramArrayOfChar, byte[] paramArrayOfByte2, String paramString)
    throws Exception
  {
    SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(paramASN1ObjectIdentifier.getId(), paramString);
    paramArrayOfByte1 = new PBEParameterSpec(paramArrayOfByte1, paramInt);
    paramArrayOfChar = localSecretKeyFactory.generateSecret(new PBEKeySpec(paramArrayOfChar));
    paramASN1ObjectIdentifier = Mac.getInstance(paramASN1ObjectIdentifier.getId(), paramString);
    paramASN1ObjectIdentifier.init(paramArrayOfChar, paramArrayOfByte1);
    paramASN1ObjectIdentifier.update(paramArrayOfByte2);
    return paramASN1ObjectIdentifier.doFinal();
  }
  
  public static byte[] convertToDefiniteLength(byte[] paramArrayOfByte)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    DEROutputStream localDEROutputStream = new DEROutputStream(localByteArrayOutputStream);
    paramArrayOfByte = Pfx.getInstance(paramArrayOfByte);
    localByteArrayOutputStream.reset();
    localDEROutputStream.writeObject(paramArrayOfByte);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] convertToDefiniteLength(byte[] paramArrayOfByte, char[] paramArrayOfChar, String paramString)
    throws IOException
  {
    Object localObject1 = Pfx.getInstance(paramArrayOfByte);
    ContentInfo localContentInfo = ((Pfx)localObject1).getAuthSafe();
    Object localObject2 = ASN1OctetString.getInstance(localContentInfo.getContent());
    paramArrayOfByte = new ByteArrayOutputStream();
    DEROutputStream localDEROutputStream = new DEROutputStream(paramArrayOfByte);
    localDEROutputStream.writeObject(new ASN1InputStream(((ASN1OctetString)localObject2).getOctets()).readObject());
    localContentInfo = new ContentInfo(localContentInfo.getContentType(), new DEROctetString(paramArrayOfByte.toByteArray()));
    localObject1 = ((Pfx)localObject1).getMacData();
    try
    {
      int i = ((MacData)localObject1).getIterationCount().intValue();
      localObject2 = ASN1OctetString.getInstance(localContentInfo.getContent()).getOctets();
      paramArrayOfChar = calculatePbeMac(((MacData)localObject1).getMac().getAlgorithmId().getAlgorithm(), ((MacData)localObject1).getSalt(), i, paramArrayOfChar, (byte[])localObject2, paramString);
      paramArrayOfChar = new MacData(new DigestInfo(new AlgorithmIdentifier(((MacData)localObject1).getMac().getAlgorithmId().getAlgorithm(), DERNull.INSTANCE), paramArrayOfChar), ((MacData)localObject1).getSalt(), i);
      paramArrayOfChar = new Pfx(localContentInfo, paramArrayOfChar);
      paramArrayOfByte.reset();
      localDEROutputStream.writeObject(paramArrayOfChar);
      return paramArrayOfByte.toByteArray();
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("error constructing MAC: ");
      paramArrayOfChar.append(paramArrayOfByte.toString());
      throw new IOException(paramArrayOfChar.toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\PKCS12Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */