package com.kb.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

@Component
public class UploadFiles {

    @Value("${os.file.upload}")  // ✅ application.yml 또는 properties에서 업로드 경로 설정
    private static String baseDir;

    /**
     * 🔹 파일 업로드 기능
     */
    public static String upload(MultipartFile part) throws IOException {
        // 업로드 디렉토리 생성 (존재하지 않으면 생성)
        Path uploadDir = Paths.get(baseDir);
        if (Files.notExists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }

        // 파일 이름 설정
        String fileName = part.getOriginalFilename();
        String renameFileName = UploadFileName.getUniqueName(fileName);
        Path filePath = uploadDir.resolve(renameFileName);

        // 파일 저장 (Path 사용)
        part.transferTo(filePath.toFile());
        return renameFileName;
    }

    /**
     * 🔹 파일 크기 포맷 변환 (Bytes → KB, MB 등)
     */
    public static String getFormatSize(Long size) {
        if (size <= 0) return "0";
        final String[] units = {"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    /**
     * 🔹 일반 파일 다운로드
     */
    public void download(HttpServletResponse response, File file, String orgName) throws Exception {
        // HTTP 응답 설정
        response.setContentType("application/octet-stream");
        response.setContentLengthLong(file.length());
        response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(orgName, "UTF-8") + "\"");

        // 파일 복사 및 응답 스트림 전송
        try (InputStream is = new FileInputStream(file);
             OutputStream os = response.getOutputStream()) {
            Files.copy(file.toPath(), os);
            os.flush();
        }
    }

    /**
     * 🔹 이미지 파일 다운로드 (웹에서 직접 보기)
     */
    public static void downloadImage(HttpServletResponse response, File file) {
        try {
            Path path = file.toPath();
            String mimeType = Files.probeContentType(path);
            response.setContentType(mimeType);
            response.setContentLengthLong(file.length());

            try (InputStream is = new FileInputStream(file);
                 OutputStream os = response.getOutputStream()) {
                Files.copy(path, os);
                os.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException("파일 다운로드 중 오류 발생", e);
        }
    }
}
