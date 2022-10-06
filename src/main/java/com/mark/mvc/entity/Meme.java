package com.mark.mvc.entity;

import javax.persistence.*;

//ส่วนของ Database
@Entity
public class Meme {

    //Annotation เพื่อกำหนดให้ตัวแปรเป็น Primary Key
    @Id
    //Annotation เพื่อให้ Primary Key Gen ตัวเลขไปAuto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memeId;

    private String memePath;

    private Integer memeLike;

    private Integer memeShare;

    private Integer memeComment;

    private Integer memeReach;

    private double memeViral;

    public Long getMemeId() {
        return memeId;
    }

    public void setMemeId(Long id) {
        this.memeId = id;
    }

    public String getMemePath() {
        return memePath;
    }

    public void setMemePath(String path) {
        this.memePath = path;
    }

    public Integer getMemeLike() {
        return memeLike;
    }

    public void setMemeLike(Integer like) {
        this.memeLike = like;
    }

    public Integer getMemeShare() {
        return memeShare;
    }

    public void setMemeShare(Integer share) {
        this.memeShare = share;
    }

    public Integer getMemeComment() {
        return memeComment;
    }

    public void setMemeComment(Integer comment) {
        this.memeComment = comment;
    }

    public Integer getMemeReach() {
        return memeReach;
    }

    public void setMemeReach(Integer reach) {
        this.memeReach = reach;
    }

    public double getMemeViral() {
        return memeViral;
    }

    public void setMemeViral(double memeViral) {
        this.memeViral = memeViral;
    }
}
