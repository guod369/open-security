package com.github.guod.web;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：Guod
 * Date：2018/4/22
 * Time：21:39
 * Description：功能模块：
 * JDK：V1.8
 * GitHub地址：https://github.com/s121528
 * ========================
 */
@RestController
public class FileUpdateController {
    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    /**
     * 功能：上传单个文件方法
     *
     * @param file 前台上传的文件对象
     * @return
     */
    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir, file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 功能：上传多个文件方法
     *
     * @param request 请求对象
     * @param file    上传文件集合
     * @return
     */
    @PostMapping(value = "/uploads")
    public String uploads(HttpServletRequest request, MultipartFile[] file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 功能：下载文件
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("F:\\aaa.jpg");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(FileCopyUtils.copyToByteArray(file));
        outputStream.flush();
        outputStream.close();
    }
}
