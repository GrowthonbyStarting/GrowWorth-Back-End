package com.growworth.gotofpatent.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.UUID;

public class FileUploadUtil {
    public static String saveFile(MultipartFile mf, String custdir) {
        byte[] data;
        String uuid = UUID.randomUUID().toString().substring(0,25); // UUID 생성
        String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf(".")); // 파일 확장자
        String imgname = uuid + ext;
        try {
            data = mf.getBytes();
            FileOutputStream fo2 =
                    new FileOutputStream(custdir+imgname);
            fo2.write(data);
            fo2.close();
        }catch(Exception e) {

        }
        return imgname;
    }
}
