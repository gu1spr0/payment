package com.pgt360.payment.util;

import org.springframework.util.ObjectUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class NettyUtil {
    public static byte[] convertObjectToByteArray(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public static Object convertByteArrayToObject(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
    public static String convertNullToEmptyString(String valor){
        if(ObjectUtils.isEmpty(valor) || valor.equals("null"))
            return "";
        return valor;
    }
    public static String convertDate(Date date){
        String format = "dd/MM/yyyy HH:mm:ss aa";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }
    public static String convertFileToBase64(String path){
        File file =  new File(path);
        byte[] bytesFile = convertFileToByteArray(file);
        return Base64.getEncoder().encodeToString(bytesFile);
    }
    public static byte[] convertFileToByteArray(File file){
        FileInputStream fis =  null;
        byte[] fileArray = new byte[(int) file.length()];
        try{
            fis = new FileInputStream(file);
            fis.read(fileArray);
            fis.close();
        } catch(IOException ioExp) {
            ioExp.printStackTrace();
        } finally {
            if(fis != null){
                try{
                    fis.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return fileArray;
    }
    public static String currentPath(){
        return new File("").getAbsolutePath();
    }
    public static Date currentDate(){
        return new Date();
    }
    public static String decodeBase64String(String encodedString){
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return new String(decodedBytes);
    }


    public static String bytesToHex(byte[] bytes) {
        char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}
