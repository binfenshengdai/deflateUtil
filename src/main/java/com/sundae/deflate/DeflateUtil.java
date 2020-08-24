package com.sundae.deflate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

/**
 * @author huojw
 * @date 2020/8/24
 */
public class DeflateUtil {

    public static void main(String[] args) {
        if(args.length<3){
            System.out.println("参数输入有误，请重新运行!");
            System.out.println("命令说明： java -jar defalteUtil.jar [参数1] [参数2] [参数3]");
            System.out.println("解压: java -jar deflateUtil.jar j [源文件] [生成文件]");
            System.out.println("压缩: java -jar deflateUtil.jar y [源文件] [生成文件]");
            System.out.println("例如: java -jar deflateUtil.jar y /usr/sundae/a.txt /usr/sundae/a.txt.deflate");
            return;
        }
        String mode = args[0];
        String srcStr = args[1];
        String targetStr = args[2];

        switch (mode){
            case "j":
                File src = new File(srcStr);
                File target = new File(targetStr);
                inflate(src,target);
                break;
            case "y":
                File src1 = new File(srcStr);
                File target1 = new File(targetStr);
                deflate(src1,target1);
                break;
            default:
                System.out.println("命令说明： java -jar defalteUtil.jar [参数1] [参数2] [参数3]");
                System.out.println("解压: java -jar deflateUtil.jar j [源文件] [生成文件]");
                System.out.println("压缩: java -jar deflateUtil.jar y [源文件] [生成文件]");
                System.out.println("例如: java -jar deflateUtil.jar y /usr/sundae/a.txt /usr/sundae/a.txt.deflate");
                break;
        }
    }


    /**
     * 解压deflate格式文件
     * @param src 源文件
     * @param target 目标文件
     */
    private static void inflate(File src, File target){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        InflaterOutputStream inflaterOutputStream = null;
        try {
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(target);
            inflaterOutputStream = new InflaterOutputStream(fileOutputStream);

            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(b)) != -1) {
                inflaterOutputStream.write(b, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                inflaterOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用deflate算法压缩文件
     * @param src 源文件
     * @param target 目标文件
     */
    public static void deflate(File src,File target) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        try {
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(target);
            deflaterOutputStream = new DeflaterOutputStream(fileOutputStream,new Deflater(8));
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(b)) != -1) {
                deflaterOutputStream.write(b, 0, len);
            }

            fileInputStream.close();
            deflaterOutputStream.close();
            fileOutputStream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
