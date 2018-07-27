package com.fundation.search.model;

public class AssetMultimedia extends Asset {

    private String  frameRate;
    private String aspectRite;
    private String  videoCode;
    private String  audioCode;


    public AssetMultimedia(String path, String fileName, String extent, boolean hidden, long size, String owner) {
        super(path, fileName, extent, hidden, size, owner);
    }


    public String getAspectRite() {
        return aspectRite;
    }

    public void setAspectRite(String aspectRite) {
        this.aspectRite = aspectRite;
    }

    public String getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(String frameRate) {
        this.frameRate = frameRate;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getAudioCode() {
        return audioCode;
    }

    public void setAudioCode(String audioCode) {
        this.audioCode = audioCode;
    }

}
