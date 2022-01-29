package pl.maciej.kitchenmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.maciej.kitchenmanager.entity.Diary;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

Diary findDiaryByNumber(String number);

@Query("SELECT b.number FROM Diary b")
    List<String> selectDiary();
}
