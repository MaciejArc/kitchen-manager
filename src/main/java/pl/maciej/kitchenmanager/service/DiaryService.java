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
}
