package pl.maciej.kitchenmanager.service;

import org.springframework.context.annotation.Configuration;
import pl.maciej.kitchenmanager.entity.Diary;
import pl.maciej.kitchenmanager.entity.Expenditure;
import pl.maciej.kitchenmanager.repository.DiaryRepository;
import pl.maciej.kitchenmanager.repository.ExpenditureRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DiaryService {
    private final DiaryRepository diaryRepository;
    private final ExpenditureRepository expenditureRepository;

    public DiaryService(DiaryRepository diaryRepository, ExpenditureRepository expenditureRepository) {
        this.diaryRepository = diaryRepository;
        this.expenditureRepository = expenditureRepository;
    }

    public List<Expenditure> findExpenditureByDateAndPurpose(String purpose){
        List<Expenditure> expenditureList = new ArrayList<>();
        expenditureList = expenditureRepository.findAllByPickUpDateAndPurpose(LocalDate.now(),purpose);
        return expenditureList;
    }
    
    public Diary saveDiary(Diary diary){
        diaryRepository.save(diary);
        List<Expenditure> expenditureList = diary.getExpenditureList();
        for (Expenditure ex :
                expenditureList) {
            ex.setDiaryNumber(diary.getNumber());
            expenditureRepository.save(ex);
        }
        return diary;
    }
    public Diary findDiaryByNumber(String number){
        return diaryRepository.findDiaryByNumber(number);
    }

    public double sumValue(Diary diary){


        List<Expenditure> expenditureList = diary.getExpenditureList();

        double value = 0;
        for (Expenditure ex : expenditureList) {

            value =value+ ex.getValue();

        }


        return value;
    }

    public List<String> selectDiary(){
      return diaryRepository.selectDiary();

    }
}
