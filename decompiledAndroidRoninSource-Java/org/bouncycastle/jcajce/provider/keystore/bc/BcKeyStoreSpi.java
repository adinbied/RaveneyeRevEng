package org.bouncycastle.jcajce.provider.keystore.bc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.crypto.io.DigestInputStream;
import org.bouncycastle.crypto.io.DigestOutputStream;
import org.bouncycastle.crypto.io.MacInputStream;
import org.bouncycastle.crypto.io.MacOutputStream;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;
import org.bouncycastle.util.io.TeeOutputStream;

public class BcKeyStoreSpi
  extends KeyStoreSpi
  implements BCKeyStore
{
  static final int CERTIFICATE = 1;
  static final int KEY = 2;
  private static final String KEY_CIPHER = "PBEWithSHAAnd3-KeyTripleDES-CBC";
  static final int KEY_PRIVATE = 0;
  static final int KEY_PUBLIC = 1;
  private static final int KEY_SALT_SIZE = 20;
  static final int KEY_SECRET = 2;
  private static final int MIN_ITERATIONS = 1024;
  static final int NULL = 0;
  static final int SEALED = 4;
  static final int SECRET = 3;
  private static final String STORE_CIPHER = "PBEWithSHAAndTwofish-CBC";
  private static final int STORE_SALT_SIZE = 20;
  private static final int STORE_VERSION = 2;
  private final JcaJceHelper helper = new BCJcaJceHelper();
  protected SecureRandom random = new SecureRandom();
  protected Hashtable table = new Hashtable();
  protected int version;
  
  public BcKeyStoreSpi(int paramInt)
  {
    this.version = paramInt;
  }
  
  private Certificate decodeCertificate(DataInputStream paramDataInputStream)
    throws IOException
  {
    String str = paramDataInputStream.readUTF();
    byte[] arrayOfByte = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.readFully(arrayOfByte);
    try
    {
      paramDataInputStream = this.helper.createCertificateFactory(str).generateCertificate(new ByteArrayInputStream(arrayOfByte));
      return paramDataInputStream;
    }
    catch (CertificateException paramDataInputStream)
    {
      throw new IOException(paramDataInputStream.toString());
    }
    catch (NoSuchProviderException paramDataInputStream)
    {
      throw new IOException(paramDataInputStream.toString());
    }
  }
  
  private Key decodeKey(DataInputStream paramDataInputStream)
    throws IOException
  {
    int i = paramDataInputStream.read();
    String str = paramDataInputStream.readUTF();
    localObject = paramDataInputStream.readUTF();
    byte[] arrayOfByte = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.readFully(arrayOfByte);
    if ((!str.equals("PKCS#8")) && (!str.equals("PKCS8")))
    {
      if ((!str.equals("X.509")) && (!str.equals("X509")))
      {
        if (str.equals("RAW")) {
          return new SecretKeySpec(arrayOfByte, (String)localObject);
        }
        paramDataInputStream = new StringBuilder();
        paramDataInputStream.append("Key format ");
        paramDataInputStream.append(str);
        paramDataInputStream.append(" not recognised!");
        throw new IOException(paramDataInputStream.toString());
      }
      paramDataInputStream = new X509EncodedKeySpec(arrayOfByte);
    }
    else
    {
      paramDataInputStream = new PKCS8EncodedKeySpec(arrayOfByte);
    }
    if ((i == 0) || ((i == 1) || (i == 2))) {}
    try
    {
      return this.helper.createSecretKeyFactory((String)localObject).generateSecret(paramDataInputStream);
    }
    catch (Exception paramDataInputStream)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Exception creating key: ");
      ((StringBuilder)localObject).append(paramDataInputStream.toString());
      throw new IOException(((StringBuilder)localObject).toString());
    }
    paramDataInputStream = new StringBuilder();
    paramDataInputStream.append("Key type ");
    paramDataInputStream.append(i);
    paramDataInputStream.append(" not recognised!");
    throw new IOException(paramDataInputStream.toString());
    return this.helper.createKeyFactory((String)localObject).generatePublic(paramDataInputStream);
    paramDataInputStream = this.helper.createKeyFactory((String)localObject).generatePrivate(paramDataInputStream);
    return paramDataInputStream;
  }
  
  private void encodeCertificate(Certificate paramCertificate, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = paramCertificate.getEncoded();
      paramDataOutputStream.writeUTF(paramCertificate.getType());
      paramDataOutputStream.writeInt(arrayOfByte.length);
      paramDataOutputStream.write(arrayOfByte);
      return;
    }
    catch (CertificateEncodingException paramCertificate)
    {
      throw new IOException(paramCertificate.toString());
    }
  }
  
  private void encodeKey(Key paramKey, DataOutputStream paramDataOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = paramKey.getEncoded();
    int i;
    if ((paramKey instanceof PrivateKey)) {
      i = 0;
    }
    for (;;)
    {
      paramDataOutputStream.write(i);
      break;
      if ((paramKey instanceof PublicKey)) {
        i = 1;
      } else {
        i = 2;
      }
    }
    paramDataOutputStream.writeUTF(paramKey.getFormat());
    paramDataOutputStream.writeUTF(paramKey.getAlgorithm());
    paramDataOutputStream.writeInt(arrayOfByte.length);
    paramDataOutputStream.write(arrayOfByte);
  }
  
  static Provider getBouncyCastleProvider()
  {
    if (Security.getProvider("BC") != null) {
      return Security.getProvider("BC");
    }
    return new BouncyCastleProvider();
  }
  
  public Enumeration engineAliases()
  {
    return this.table.keys();
  }
  
  public boolean engineContainsAlias(String paramString)
  {
    return this.table.get(paramString) != null;
  }
  
  public void engineDeleteEntry(String paramString)
    throws KeyStoreException
  {
    if (this.table.get(paramString) == null) {
      return;
    }
    this.table.remove(paramString);
  }
  
  public Certificate engineGetCertificate(String paramString)
  {
    paramString = (StoreEntry)this.table.get(paramString);
    if (paramString != null)
    {
      if (paramString.getType() == 1) {
        return (Certificate)paramString.getObject();
      }
      paramString = paramString.getCertificateChain();
      if (paramString != null) {
        return paramString[0];
      }
    }
    return null;
  }
  
  public String engineGetCertificateAlias(Certificate paramCertificate)
  {
    Enumeration localEnumeration = this.table.elements();
    while (localEnumeration.hasMoreElements())
    {
      StoreEntry localStoreEntry = (StoreEntry)localEnumeration.nextElement();
      if ((localStoreEntry.getObject() instanceof Certificate))
      {
        if (((Certificate)localStoreEntry.getObject()).equals(paramCertificate)) {
          return localStoreEntry.getAlias();
        }
      }
      else
      {
        Certificate[] arrayOfCertificate = localStoreEntry.getCertificateChain();
        if ((arrayOfCertificate != null) && (arrayOfCertificate[0].equals(paramCertificate))) {
          return localStoreEntry.getAlias();
        }
      }
    }
    return null;
  }
  
  public Certificate[] engineGetCertificateChain(String paramString)
  {
    paramString = (StoreEntry)this.table.get(paramString);
    if (paramString != null) {
      return paramString.getCertificateChain();
    }
    return null;
  }
  
  public Date engineGetCreationDate(String paramString)
  {
    paramString = (StoreEntry)this.table.get(paramString);
    if (paramString != null) {
      return paramString.getDate();
    }
    return null;
  }
  
  public Key engineGetKey(String paramString, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, UnrecoverableKeyException
  {
    paramString = (StoreEntry)this.table.get(paramString);
    if ((paramString != null) && (paramString.getType() != 1)) {
      return (Key)paramString.getObject(paramArrayOfChar);
    }
    return null;
  }
  
  public boolean engineIsCertificateEntry(String paramString)
  {
    paramString = (StoreEntry)this.table.get(paramString);
    return (paramString != null) && (paramString.getType() == 1);
  }
  
  public boolean engineIsKeyEntry(String paramString)
  {
    paramString = (StoreEntry)this.table.get(paramString);
    return (paramString != null) && (paramString.getType() != 1);
  }
  
  public void engineLoad(InputStream paramInputStream, char[] paramArrayOfChar)
    throws IOException
  {
    this.table.clear();
    if (paramInputStream == null) {
      return;
    }
    paramInputStream = new DataInputStream(paramInputStream);
    int i = paramInputStream.readInt();
    if ((i != 2) && (i != 0) && (i != 1)) {
      throw new IOException("Wrong version of key store.");
    }
    int j = paramInputStream.readInt();
    if (j > 0)
    {
      Object localObject2 = new byte[j];
      paramInputStream.readFully((byte[])localObject2);
      j = paramInputStream.readInt();
      Object localObject1 = new HMac(new SHA1Digest());
      if ((paramArrayOfChar != null) && (paramArrayOfChar.length != 0))
      {
        paramArrayOfChar = PBEParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar);
        PKCS12ParametersGenerator localPKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
        localPKCS12ParametersGenerator.init(paramArrayOfChar, (byte[])localObject2, j);
        if (i != 2) {
          i = ((HMac)localObject1).getMacSize();
        } else {
          i = ((HMac)localObject1).getMacSize() * 8;
        }
        localObject2 = localPKCS12ParametersGenerator.generateDerivedMacParameters(i);
        Arrays.fill(paramArrayOfChar, (byte)0);
        ((HMac)localObject1).init((CipherParameters)localObject2);
        loadStore(new MacInputStream(paramInputStream, (Mac)localObject1));
        paramArrayOfChar = new byte[((HMac)localObject1).getMacSize()];
        ((HMac)localObject1).doFinal(paramArrayOfChar, 0);
        localObject1 = new byte[((HMac)localObject1).getMacSize()];
        paramInputStream.readFully((byte[])localObject1);
        if (Arrays.constantTimeAreEqual(paramArrayOfChar, (byte[])localObject1)) {
          return;
        }
        this.table.clear();
        throw new IOException("KeyStore integrity check failed.");
      }
      loadStore(paramInputStream);
      paramInputStream.readFully(new byte[((HMac)localObject1).getMacSize()]);
      return;
    }
    throw new IOException("Invalid salt detected");
  }
  
  public void engineSetCertificateEntry(String paramString, Certificate paramCertificate)
    throws KeyStoreException
  {
    StoreEntry localStoreEntry = (StoreEntry)this.table.get(paramString);
    if ((localStoreEntry != null) && (localStoreEntry.getType() != 1))
    {
      paramCertificate = new StringBuilder();
      paramCertificate.append("key store already has a key entry with alias ");
      paramCertificate.append(paramString);
      throw new KeyStoreException(paramCertificate.toString());
    }
    this.table.put(paramString, new StoreEntry(paramString, paramCertificate));
  }
  
  public void engineSetKeyEntry(String paramString, Key paramKey, char[] paramArrayOfChar, Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    if (((paramKey instanceof PrivateKey)) && (paramArrayOfCertificate == null)) {
      throw new KeyStoreException("no certificate chain for private key");
    }
    try
    {
      this.table.put(paramString, new StoreEntry(paramString, paramKey, paramArrayOfChar, paramArrayOfCertificate));
      return;
    }
    catch (Exception paramString)
    {
      throw new KeyStoreException(paramString.toString());
    }
  }
  
  public void engineSetKeyEntry(String paramString, byte[] paramArrayOfByte, Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    this.table.put(paramString, new StoreEntry(paramString, paramArrayOfByte, paramArrayOfCertificate));
  }
  
  public int engineSize()
  {
    return this.table.size();
  }
  
  public void engineStore(OutputStream paramOutputStream, char[] paramArrayOfChar)
    throws IOException
  {
    paramOutputStream = new DataOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte[20];
    int i = (this.random.nextInt() & 0x3FF) + 1024;
    this.random.nextBytes(arrayOfByte);
    paramOutputStream.writeInt(this.version);
    paramOutputStream.writeInt(20);
    paramOutputStream.write(arrayOfByte);
    paramOutputStream.writeInt(i);
    HMac localHMac = new HMac(new SHA1Digest());
    MacOutputStream localMacOutputStream = new MacOutputStream(localHMac);
    PKCS12ParametersGenerator localPKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
    paramArrayOfChar = PBEParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar);
    localPKCS12ParametersGenerator.init(paramArrayOfChar, arrayOfByte, i);
    if (this.version < 2) {
      i = localHMac.getMacSize();
    } else {
      i = localHMac.getMacSize() * 8;
    }
    localHMac.init(localPKCS12ParametersGenerator.generateDerivedMacParameters(i));
    i = 0;
    while (i != paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = '\000';
      i += 1;
    }
    saveStore(new TeeOutputStream(paramOutputStream, localMacOutputStream));
    paramArrayOfChar = new byte[localHMac.getMacSize()];
    localHMac.doFinal(paramArrayOfChar, 0);
    paramOutputStream.write(paramArrayOfChar);
    paramOutputStream.close();
  }
  
  protected void loadStore(InputStream paramInputStream)
    throws IOException
  {
    DataInputStream localDataInputStream = new DataInputStream(paramInputStream);
    for (int i = localDataInputStream.read(); i > 0; i = localDataInputStream.read())
    {
      String str = localDataInputStream.readUTF();
      Object localObject2 = new Date(localDataInputStream.readLong());
      int k = localDataInputStream.readInt();
      paramInputStream = null;
      Object localObject1;
      if (k != 0)
      {
        localObject1 = new Certificate[k];
        int j = 0;
        for (;;)
        {
          paramInputStream = (InputStream)localObject1;
          if (j == k) {
            break;
          }
          localObject1[j] = decodeCertificate(localDataInputStream);
          j += 1;
        }
      }
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            throw new RuntimeException("Unknown object type in store.");
          }
          localObject1 = new byte[localDataInputStream.readInt()];
          localDataInputStream.readFully((byte[])localObject1);
          this.table.put(str, new StoreEntry(str, (Date)localObject2, i, localObject1, paramInputStream));
          continue;
        }
        Key localKey = decodeKey(localDataInputStream);
        localObject1 = this.table;
        localObject2 = new StoreEntry(str, (Date)localObject2, 2, localKey, paramInputStream);
        paramInputStream = (InputStream)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = decodeCertificate(localDataInputStream);
        paramInputStream = this.table;
        localObject1 = new StoreEntry(str, (Date)localObject2, 1, localObject1);
      }
      paramInputStream.put(str, localObject1);
    }
  }
  
  protected Cipher makePBECipher(String paramString, int paramInt1, char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt2)
    throws IOException
  {
    try
    {
      paramArrayOfChar = new PBEKeySpec(paramArrayOfChar);
      SecretKeyFactory localSecretKeyFactory = this.helper.createSecretKeyFactory(paramString);
      paramArrayOfByte = new PBEParameterSpec(paramArrayOfByte, paramInt2);
      paramString = this.helper.createCipher(paramString);
      paramString.init(paramInt1, localSecretKeyFactory.generateSecret(paramArrayOfChar), paramArrayOfByte);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("Error initialising store of key store: ");
      paramArrayOfChar.append(paramString);
      throw new IOException(paramArrayOfChar.toString());
    }
  }
  
  protected void saveStore(OutputStream paramOutputStream)
    throws IOException
  {
    Enumeration localEnumeration = this.table.elements();
    paramOutputStream = new DataOutputStream(paramOutputStream);
    for (;;)
    {
      boolean bool = localEnumeration.hasMoreElements();
      int i = 0;
      if (!bool) {
        break;
      }
      Object localObject = (StoreEntry)localEnumeration.nextElement();
      paramOutputStream.write(((StoreEntry)localObject).getType());
      paramOutputStream.writeUTF(((StoreEntry)localObject).getAlias());
      paramOutputStream.writeLong(((StoreEntry)localObject).getDate().getTime());
      Certificate[] arrayOfCertificate = ((StoreEntry)localObject).getCertificateChain();
      if (arrayOfCertificate == null)
      {
        paramOutputStream.writeInt(0);
      }
      else
      {
        paramOutputStream.writeInt(arrayOfCertificate.length);
        while (i != arrayOfCertificate.length)
        {
          encodeCertificate(arrayOfCertificate[i], paramOutputStream);
          i += 1;
        }
      }
      i = ((StoreEntry)localObject).getType();
      if (i != 1)
      {
        if (i != 2)
        {
          if ((i != 3) && (i != 4)) {
            throw new RuntimeException("Unknown object type in store.");
          }
          localObject = (byte[])((StoreEntry)localObject).getObject();
          paramOutputStream.writeInt(localObject.length);
          paramOutputStream.write((byte[])localObject);
        }
        else
        {
          encodeKey((Key)((StoreEntry)localObject).getObject(), paramOutputStream);
        }
      }
      else {
        encodeCertificate((Certificate)((StoreEntry)localObject).getObject(), paramOutputStream);
      }
    }
    paramOutputStream.write(0);
  }
  
  public void setRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
  }
  
  public static class BouncyCastleStore
    extends BcKeyStoreSpi
  {
    public BouncyCastleStore()
    {
      super();
    }
    
    public void engineLoad(InputStream paramInputStream, char[] paramArrayOfChar)
      throws IOException
    {
      this.table.clear();
      if (paramInputStream == null) {
        return;
      }
      Object localObject = new DataInputStream(paramInputStream);
      int i = ((DataInputStream)localObject).readInt();
      if ((i != 2) && (i != 0) && (i != 1)) {
        throw new IOException("Wrong version of key store.");
      }
      int j = ((DataInputStream)localObject).readInt();
      byte[] arrayOfByte = new byte[j];
      if (j == 20)
      {
        ((DataInputStream)localObject).readFully(arrayOfByte);
        j = ((DataInputStream)localObject).readInt();
        if ((j >= 0) && (j <= 4096))
        {
          if (i == 0) {
            paramInputStream = "OldPBEWithSHAAndTwofish-CBC";
          } else {
            paramInputStream = "PBEWithSHAAndTwofish-CBC";
          }
          paramInputStream = new CipherInputStream((InputStream)localObject, makePBECipher(paramInputStream, 2, paramArrayOfChar, arrayOfByte, j));
          localObject = new SHA1Digest();
          loadStore(new DigestInputStream(paramInputStream, (Digest)localObject));
          paramArrayOfChar = new byte[((Digest)localObject).getDigestSize()];
          ((Digest)localObject).doFinal(paramArrayOfChar, 0);
          localObject = new byte[((Digest)localObject).getDigestSize()];
          Streams.readFully(paramInputStream, (byte[])localObject);
          if (Arrays.constantTimeAreEqual(paramArrayOfChar, (byte[])localObject)) {
            return;
          }
          this.table.clear();
          throw new IOException("KeyStore integrity check failed.");
        }
        throw new IOException("Key store corrupted.");
      }
      throw new IOException("Key store corrupted.");
    }
    
    public void engineStore(OutputStream paramOutputStream, char[] paramArrayOfChar)
      throws IOException
    {
      paramOutputStream = new DataOutputStream(paramOutputStream);
      byte[] arrayOfByte = new byte[20];
      int i = (this.random.nextInt() & 0x3FF) + 1024;
      this.random.nextBytes(arrayOfByte);
      paramOutputStream.writeInt(this.version);
      paramOutputStream.writeInt(20);
      paramOutputStream.write(arrayOfByte);
      paramOutputStream.writeInt(i);
      paramOutputStream = new CipherOutputStream(paramOutputStream, makePBECipher("PBEWithSHAAndTwofish-CBC", 1, paramArrayOfChar, arrayOfByte, i));
      paramArrayOfChar = new DigestOutputStream(new SHA1Digest());
      saveStore(new TeeOutputStream(paramOutputStream, paramArrayOfChar));
      paramOutputStream.write(paramArrayOfChar.getDigest());
      paramOutputStream.close();
    }
  }
  
  public static class Std
    extends BcKeyStoreSpi
  {
    public Std()
    {
      super();
    }
  }
  
  private class StoreEntry
  {
    String alias;
    Certificate[] certChain;
    Date date = new Date();
    Object obj;
    int type;
    
    StoreEntry(String paramString, Key paramKey, char[] paramArrayOfChar, Certificate[] paramArrayOfCertificate)
      throws Exception
    {
      this.type = 4;
      this.alias = paramString;
      this.certChain = paramArrayOfCertificate;
      paramArrayOfCertificate = new byte[20];
      BcKeyStoreSpi.this.random.setSeed(System.currentTimeMillis());
      BcKeyStoreSpi.this.random.nextBytes(paramArrayOfCertificate);
      int i = (BcKeyStoreSpi.this.random.nextInt() & 0x3FF) + 1024;
      paramString = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(paramString);
      localDataOutputStream.writeInt(20);
      localDataOutputStream.write(paramArrayOfCertificate);
      localDataOutputStream.writeInt(i);
      paramArrayOfChar = new DataOutputStream(new CipherOutputStream(localDataOutputStream, BcKeyStoreSpi.this.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, paramArrayOfChar, paramArrayOfCertificate, i)));
      BcKeyStoreSpi.this.encodeKey(paramKey, paramArrayOfChar);
      paramArrayOfChar.close();
      this.obj = paramString.toByteArray();
    }
    
    StoreEntry(String paramString, Certificate paramCertificate)
    {
      this.type = 1;
      this.alias = paramString;
      this.obj = paramCertificate;
      this.certChain = null;
    }
    
    StoreEntry(String paramString, Date paramDate, int paramInt, Object paramObject)
    {
      this.alias = paramString;
      this.date = paramDate;
      this.type = paramInt;
      this.obj = paramObject;
    }
    
    StoreEntry(String paramString, Date paramDate, int paramInt, Object paramObject, Certificate[] paramArrayOfCertificate)
    {
      this.alias = paramString;
      this.date = paramDate;
      this.type = paramInt;
      this.obj = paramObject;
      this.certChain = paramArrayOfCertificate;
    }
    
    StoreEntry(String paramString, byte[] paramArrayOfByte, Certificate[] paramArrayOfCertificate)
    {
      this.type = 3;
      this.alias = paramString;
      this.obj = paramArrayOfByte;
      this.certChain = paramArrayOfCertificate;
    }
    
    String getAlias()
    {
      return this.alias;
    }
    
    Certificate[] getCertificateChain()
    {
      return this.certChain;
    }
    
    Date getDate()
    {
      return this.date;
    }
    
    Object getObject()
    {
      return this.obj;
    }
    
    Object getObject(char[] paramArrayOfChar)
      throws NoSuchAlgorithmException, UnrecoverableKeyException
    {
      if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
      {
        localObject = this.obj;
        if ((localObject instanceof Key)) {
          return localObject;
        }
      }
      if (this.type == 4) {
        localObject = new DataInputStream(new ByteArrayInputStream((byte[])this.obj));
      }
      try
      {
        arrayOfByte = new byte[((DataInputStream)localObject).readInt()];
        ((DataInputStream)localObject).readFully(arrayOfByte);
        i = ((DataInputStream)localObject).readInt();
        localObject = new CipherInputStream((InputStream)localObject, BcKeyStoreSpi.this.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 2, paramArrayOfChar, arrayOfByte, i));
      }
      catch (Exception paramArrayOfChar)
      {
        byte[] arrayOfByte;
        int i;
        label116:
        for (;;) {}
      }
      try
      {
        localObject = BcKeyStoreSpi.this.decodeKey(new DataInputStream((InputStream)localObject));
        return localObject;
      }
      catch (Exception localException1)
      {
        break label116;
      }
      Object localObject = new DataInputStream(new ByteArrayInputStream((byte[])this.obj));
      arrayOfByte = new byte[((DataInputStream)localObject).readInt()];
      ((DataInputStream)localObject).readFully(arrayOfByte);
      i = ((DataInputStream)localObject).readInt();
      for (localObject = new CipherInputStream((InputStream)localObject, BcKeyStoreSpi.this.makePBECipher("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, paramArrayOfChar, arrayOfByte, i));; localObject = BcKeyStoreSpi.this.decodeKey(new DataInputStream((InputStream)localObject)))
      {
        try
        {
          localObject = BcKeyStoreSpi.this.decodeKey(new DataInputStream((InputStream)localObject));
        }
        catch (Exception localException2)
        {
          ByteArrayOutputStream localByteArrayOutputStream;
          DataOutputStream localDataOutputStream;
          for (;;) {}
        }
        localObject = new DataInputStream(new ByteArrayInputStream((byte[])this.obj));
        arrayOfByte = new byte[((DataInputStream)localObject).readInt()];
        ((DataInputStream)localObject).readFully(arrayOfByte);
        i = ((DataInputStream)localObject).readInt();
        localObject = new CipherInputStream((InputStream)localObject, BcKeyStoreSpi.this.makePBECipher("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, paramArrayOfChar, arrayOfByte, i));
      }
      if (localObject != null)
      {
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        localDataOutputStream.writeInt(arrayOfByte.length);
        localDataOutputStream.write(arrayOfByte);
        localDataOutputStream.writeInt(i);
        paramArrayOfChar = new DataOutputStream(new CipherOutputStream(localDataOutputStream, BcKeyStoreSpi.this.makePBECipher("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, paramArrayOfChar, arrayOfByte, i)));
        BcKeyStoreSpi.this.encodeKey((Key)localObject, paramArrayOfChar);
        paramArrayOfChar.close();
        this.obj = localByteArrayOutputStream.toByteArray();
        return localObject;
      }
      throw new UnrecoverableKeyException("no match");
      throw new UnrecoverableKeyException("no match");
      throw new RuntimeException("forget something!");
    }
    
    int getType()
    {
      return this.type;
    }
  }
  
  public static class Version1
    extends BcKeyStoreSpi
  {
    public Version1()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\keystore\bc\BcKeyStoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */