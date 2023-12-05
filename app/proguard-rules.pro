
 # Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
 -keep,allowobfuscation,allowshrinking interface retrofit2.Call
 -keep,allowobfuscation,allowshrinking class retrofit2.Response

 # With R8 full mode generic signatures are stripped for classes that are not
 # kept. Suspend functions are wrapped in continuations where the type argument
 # is used.
 -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

 ## Rules for Gson
 # Gson specific classes
 -keep @androidx.annotation.Keep public class *

  # Copied from missing_rules file while compling
 -dontwarn org.bouncycastle.jsse.BCSSLParameters
 -dontwarn org.bouncycastle.jsse.BCSSLSocket
 -dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
 -dontwarn org.conscrypt.Conscrypt$Version
 -dontwarn org.conscrypt.Conscrypt
 -dontwarn org.conscrypt.ConscryptHostnameVerifier
 -dontwarn org.openjsse.javax.net.ssl.SSLParameters
 -dontwarn org.openjsse.javax.net.ssl.SSLSocket
 -dontwarn org.openjsse.net.ssl.OpenJSSE

 




