### Simple library that provides methods to generate SHA-1 SHA-512 and MD5 digest


This library was inspired by problem with apache commons-codec library in Android

Here is part of according stacktrace

>java.lang.NoSuchMethodError: No static method encodeHexString([B)Ljava/lang/String; in class Lorg/apache/commons/codec/binary/Hex; or its super classes (declaration of 'org.apache.commons.codec.binary.Hex' appears in /system/framework/org.apache.http.legacy.boot.jar)
                                                                       at org.apache.commons.codec.digest.DigestUtils.sha512Hex(DigestUtils.java:720)

Here is the [link](https://stackoverflow.com/questions/9126567/method-not-found-using-digestutils-in-android) to SO about this problem

The solution is to avoid using apache.commons.codec library. It is usually used
 only to calculate MD5, SHA512 or SHA1 digest in Android or other Java project.
 
This project shows how to calculate digests using native Java SDK without any dependency
