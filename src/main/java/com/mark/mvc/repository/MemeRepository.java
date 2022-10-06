package com.mark.mvc.repository;

import com.mark.mvc.entity.Meme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//ส่วนที่เป็นตัวจัดการกับตัว Database ทั้งหมด
//ส่วนใหญ่จะมี function พื้นฐานให้อยู่แล้ว เช่น findAll, save, delete
@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    // Query ในการค้นหาข้อมูลที่ติด Viral
    List<Meme> findAllByMemeViralGreaterThanEqual(double viral);
    // Query ในการค้นหาข้อมูลที่ไม่ติด Viral
    List<Meme> findAllByMemeViralLessThan(double viral);
}
