package net.fullstack7.chap1.dto;

import java.time.LocalDateTime;

public class BbsDTO {
    private int idx;
    private int bbsRefIdx;
    private short bbsLevel;
    private short sortOrder;
    private String memberId;
    private String title;
    private String content;
    private short readCnt;
    private String fileName;
    private String filePath;
    private String fileType;
    private String fileExt;
    private String fileSize;
    private LocalDateTime modifyDate;
    private LocalDateTime regDate;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getBbsRefIdx() {
        return bbsRefIdx;
    }

    public void setBbsRefIdx(int bbsRefIdx) {
        this.bbsRefIdx = bbsRefIdx;
    }

    public short getBbsLevel() {
        return bbsLevel;
    }

    public void setBbsLevel(short bbsLevel) {
        this.bbsLevel = bbsLevel;
    }

    public short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getReadCnt() {
        return readCnt;
    }

    public void setReadCnt(short readCnt) {
        this.readCnt = readCnt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }
}
