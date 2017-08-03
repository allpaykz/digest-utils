### Simple library that provides methods to generate SHA-1 SHA-512 and MD5 digest

Briefly, look code [here](https://github.com/allpaykz/digest-utils/blob/master/src/main/java/SecurityUtils.java) and [here](https://github.com/allpaykz/digest-utils/blob/master/src/test/java/SecurityUtilsTest.java)

# Motivation

This library was inspired by problem with [Apache Commons Codec](https://commons.apache.org/proper/commons-codec/) library in Android. We noticed that we often use a small part of this library. This small part can be extracted to one little class

# Problem

Here is part of according stacktrace in Android

>java.lang.NoSuchMethodError: No static method encodeHexString([B)Ljava/lang/String; in class Lorg/apache/commons/codec/binary/Hex; or its super classes (declaration of 'org.apache.commons.codec.binary.Hex' appears in /system/framework/org.apache.http.legacy.boot.jar)
                                                                       at org.apache.commons.codec.digest.DigestUtils.sha512Hex(DigestUtils.java:720)

Here is the [link](https://stackoverflow.com/questions/9126567/method-not-found-using-digestutils-in-android) to SO about this problem

Here is the [very nice deep explanation](https://stackoverflow.com/a/29833101/1845894) of the problem.

# Solution

The solution is to avoid using apache.commons.codec library. It is usually used only to calculate MD5, SHA512 or SHA1 digest in Android or other Java project.
 
This project shows how to calculate digests using native Java SDK without **any** dependency

The **only class** you need is [here](https://github.com/allpaykz/digest-utils/blob/master/src/main/java/SecurityUtils.java)
