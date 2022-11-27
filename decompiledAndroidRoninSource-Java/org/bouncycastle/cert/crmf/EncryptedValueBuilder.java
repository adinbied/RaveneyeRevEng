package org.bouncycastle.cert.crmf;

import java.io.IOException;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.KeyWrapper;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.util.Strings;

public class EncryptedValueBuilder
{
  private OutputEncryptor encryptor;
  private EncryptedValuePadder padder;
  private KeyWrapper wrapper;
  
  public EncryptedValueBuilder(KeyWrapper paramKeyWrapper, OutputEncryptor paramOutputEncryptor)
  {
    this(paramKeyWrapper, paramOutputEncryptor, null);
  }
  
  public EncryptedValueBuilder(KeyWrapper paramKeyWrapper, OutputEncryptor paramOutputEncryptor, EncryptedValuePadder paramEncryptedValuePadder)
  {
    this.wrapper = paramKeyWrapper;
    this.encryptor = paramOutputEncryptor;
    this.padder = paramEncryptedValuePadder;
  }
  
  /* Error */
  private EncryptedValue encryptData(byte[] paramArrayOfByte)
    throws CRMFException
  {
    // Byte code:
    //   0: new 35	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 36	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: getfield 23	org/bouncycastle/cert/crmf/EncryptedValueBuilder:encryptor	Lorg/bouncycastle/operator/OutputEncryptor;
    //   12: aload_2
    //   13: invokeinterface 42 2 0
    //   18: astore_3
    //   19: aload_3
    //   20: aload_1
    //   21: invokevirtual 48	java/io/OutputStream:write	([B)V
    //   24: aload_3
    //   25: invokevirtual 51	java/io/OutputStream:close	()V
    //   28: aload_0
    //   29: getfield 23	org/bouncycastle/cert/crmf/EncryptedValueBuilder:encryptor	Lorg/bouncycastle/operator/OutputEncryptor;
    //   32: invokeinterface 55 1 0
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 21	org/bouncycastle/cert/crmf/EncryptedValueBuilder:wrapper	Lorg/bouncycastle/operator/KeyWrapper;
    //   42: aload_0
    //   43: getfield 23	org/bouncycastle/cert/crmf/EncryptedValueBuilder:encryptor	Lorg/bouncycastle/operator/OutputEncryptor;
    //   46: invokeinterface 59 1 0
    //   51: invokeinterface 65 2 0
    //   56: pop
    //   57: new 67	org/bouncycastle/asn1/DERBitString
    //   60: dup
    //   61: aload_0
    //   62: getfield 21	org/bouncycastle/cert/crmf/EncryptedValueBuilder:wrapper	Lorg/bouncycastle/operator/KeyWrapper;
    //   65: aload_0
    //   66: getfield 23	org/bouncycastle/cert/crmf/EncryptedValueBuilder:encryptor	Lorg/bouncycastle/operator/OutputEncryptor;
    //   69: invokeinterface 59 1 0
    //   74: invokeinterface 65 2 0
    //   79: invokespecial 69	org/bouncycastle/asn1/DERBitString:<init>	([B)V
    //   82: astore_3
    //   83: new 71	org/bouncycastle/asn1/crmf/EncryptedValue
    //   86: dup
    //   87: aconst_null
    //   88: aload_1
    //   89: aload_3
    //   90: aload_0
    //   91: getfield 21	org/bouncycastle/cert/crmf/EncryptedValueBuilder:wrapper	Lorg/bouncycastle/operator/KeyWrapper;
    //   94: invokeinterface 72 1 0
    //   99: aconst_null
    //   100: new 67	org/bouncycastle/asn1/DERBitString
    //   103: dup
    //   104: aload_2
    //   105: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   108: invokespecial 69	org/bouncycastle/asn1/DERBitString:<init>	([B)V
    //   111: invokespecial 79	org/bouncycastle/asn1/crmf/EncryptedValue:<init>	(Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/DERBitString;Lorg/bouncycastle/asn1/x509/AlgorithmIdentifier;Lorg/bouncycastle/asn1/ASN1OctetString;Lorg/bouncycastle/asn1/DERBitString;)V
    //   114: areturn
    //   115: astore_1
    //   116: new 81	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc 84
    //   127: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: aload_1
    //   133: invokevirtual 92	org/bouncycastle/operator/OperatorException:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: new 29	org/bouncycastle/cert/crmf/CRMFException
    //   143: dup
    //   144: aload_2
    //   145: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload_1
    //   149: invokespecial 98	org/bouncycastle/cert/crmf/CRMFException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    //   153: astore_1
    //   154: new 81	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   161: astore_2
    //   162: aload_2
    //   163: ldc 100
    //   165: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_2
    //   170: aload_1
    //   171: invokevirtual 101	java/io/IOException:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: new 29	org/bouncycastle/cert/crmf/CRMFException
    //   181: dup
    //   182: aload_2
    //   183: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: aload_1
    //   187: invokespecial 98	org/bouncycastle/cert/crmf/CRMFException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	EncryptedValueBuilder
    //   0	191	1	paramArrayOfByte	byte[]
    //   7	176	2	localObject1	Object
    //   18	72	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	83	115	org/bouncycastle/operator/OperatorException
    //   19	28	153	java/io/IOException
  }
  
  private byte[] padData(byte[] paramArrayOfByte)
  {
    EncryptedValuePadder localEncryptedValuePadder = this.padder;
    byte[] arrayOfByte = paramArrayOfByte;
    if (localEncryptedValuePadder != null) {
      arrayOfByte = localEncryptedValuePadder.getPaddedData(paramArrayOfByte);
    }
    return arrayOfByte;
  }
  
  public EncryptedValue build(X509CertificateHolder paramX509CertificateHolder)
    throws CRMFException
  {
    try
    {
      paramX509CertificateHolder = encryptData(padData(paramX509CertificateHolder.getEncoded()));
      return paramX509CertificateHolder;
    }
    catch (IOException paramX509CertificateHolder)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot encode certificate: ");
      localStringBuilder.append(paramX509CertificateHolder.getMessage());
      throw new CRMFException(localStringBuilder.toString(), paramX509CertificateHolder);
    }
  }
  
  public EncryptedValue build(char[] paramArrayOfChar)
    throws CRMFException
  {
    return encryptData(padData(Strings.toUTF8ByteArray(paramArrayOfChar)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\EncryptedValueBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */