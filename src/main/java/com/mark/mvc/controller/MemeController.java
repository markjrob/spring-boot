package com.mark.mvc.controller;

import com.mark.mvc.entity.Meme;
import com.mark.mvc.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//ส่วนของController สร้าง Path API ต่างๆ
@RestController
public class MemeController {

    //ประกาศคลาสของ Service
    @Autowired
    MemeService memeService;

    //Path สำหรับสร้าง meme ตัวใหม่
    @PostMapping("/newMeme")
    public Meme newMeme(@RequestBody String path) {
        return memeService.newMeme(path);
    }

    //Path สำหรับแสดงข้อมูลทั้งหมดใน Database
    @GetMapping("/findAll")
    public List<Meme> findAll() {
        return memeService.findAll();
    }

    //Path สำหรับแสดงข้อมูลที่ติด Viral
    @GetMapping("/isViral")
    public List<Meme> isViral() {
        return memeService.findViral();
    }

    //Path สำหรับแสดงข้อมูลที่ไม่ติด Viral
    @GetMapping("/notViral")
    public List<Meme> notViral() {
        return memeService.findNotViral();
    }
}
