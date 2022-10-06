package com.mark.mvc.service;

import com.mark.mvc.entity.Meme;
import com.mark.mvc.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//ส่วนนี้จะไว้เขียน Logic ของ code โดยจะแยกเป็น function ต่างๆที่จำเป็นต้องใช้
@Service
public class MemeService {

    //ประกาศ class ของตัว repository
    @Autowired
    MemeRepository memeRepository;

    //ไว้สำหรับ random ค่าต่างๆที่ใช้ โดยจะรับ max, min มา
    public int randomValue(int max, int min) {
        return (int) (Math.random()*(max-min+1)+min);
    }

    //ไว้สำหรับ คำนวณค่า Viral ตามสูตรที่กำหนดให้ในโจทย์
    public double generateViral(double like, double share, double comment, double reach) {
        return (like + share + comment) / reach;
    }

    //ไว้สำหรับสร้าง Meme ตัวใหม่ Map ค่าต่างๆให้พร้อม save ลง Database
    public Meme newMeme(String path) {
        //new Obj ขึ้นมาเตรียมไว้
        Meme meme = new Meme();
        //random ค่า Reach อยู่ระหว่าง 1000-100000
        int reach = randomValue(100000, 1000);
        //random ค่า like อยู่ระหว่าง 1-ค่าReach
        int like = randomValue(reach, 1);
        //random ค่า share อยู่ระหว่าง 1-ค่าReach
        int share = randomValue(reach, 1);
        //random ค่า comment อยู่ระหว่าง 1-ค่าReach
        int comment = randomValue(reach, 1);
        //คำนวณค่า viral
        double viral = generateViral(like, share, comment, reach);
        //set ค่าลง Obj
        meme.setMemePath(path);
        meme.setMemeLike(like);
        meme.setMemeShare(share);
        meme.setMemeComment(comment);
        meme.setMemeReach(reach);
        meme.setMemeViral(viral);
        return saveMeme(meme);
    }

    //เรียกใช้ Repository ในการค้นหาข้อมูลที่ไม่ติด Viral
    public List<Meme> findNotViral() {
        return memeRepository.findAllByMemeViralLessThan(0.1);
    }

    //เรียกใช้ Repository ในการค้นหาข้อมูลที่ติด Viral
    public List<Meme> findViral() {
        return memeRepository.findAllByMemeViralGreaterThanEqual(0.1);
    }

    //เรียกใช้ Repository ในการค้นหาข้อมูลทั้งหมด
    public List<Meme> findAll() {
        return memeRepository.findAll();
    }

    //เรียกใช้ Repository ในการ save ข้อมูลลง Database
    public Meme saveMeme(Meme meme) {
        return memeRepository.save(meme);
    }
}
