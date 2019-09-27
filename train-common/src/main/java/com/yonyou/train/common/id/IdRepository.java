package com.yonyou.train.common.id;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

public class IdRepository implements IdType{

    public static String genId(String idType){
        switch (idType){
            case ID_TYPE_UUID:
                return genUUID();
            case ID_TYPE_RANDOM:
                return genRandomId();
        }
        return "";
    }

    private static String genUUID(){
        SecureRandom random=new SecureRandom();
        int randomNumber=random.nextInt();
        String randomDigits=new Integer(randomNumber).toString();
        try {
            MessageDigest encryptor = MessageDigest.getInstance("SHA");
            byte[] rawIdBytes = encryptor.digest(randomDigits.getBytes());
            return UUID.nameUUIDFromBytes(rawIdBytes).toString();
            //return UUID.randomUUID().toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String genRandomId(){
        SecureRandom random=new SecureRandom();
        int randomNumber=random.nextInt();
        String randomDigits=new Integer(randomNumber).toString();
        try {
            MessageDigest encryptor = MessageDigest.getInstance("SHA");
            byte[] rawIdBytes = encryptor.digest(randomDigits.getBytes());
            try {
                return byteArrayToHex(rawIdBytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }


    public static void main(String []args){
        String id=IdRepository.genId(IdType.ID_TYPE_UUID);
        System.out.println(id +" "+id.length());
    }
}
