package pl.maciej.kitchenmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.maciej.kitchenmanager.entity.Diary;
import pl.maciej.kitchenmanager.service.DiaryService;

@Controller
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping("/diary/add")
    public String diaryAdd(Model model){
        model.addAttribute("diary",new Diary());

        return "diary/addDiary";
    }

    @PostMapping("/diary/add")
    public String diaryAddPost(Diary diary,Model model){
        String purpose = diary.getPurpose();
        diary.setExpenditureList(diaryService.findExpenditureByDateAndPurpose(purpose));
        diaryService.saveDiary(diary);

        return "redirect:/diary/add";
    }

    @GetMapping("/diary/show")
    public String diaryShow(Model model, @RequestParam(value = "number") String number){

        model.addAttribute("sumValue",diaryService.sumValue(diaryService.findDiaryByNumber(number)));
        model.addAttribute("diary", diaryService.findDiaryByNumber(number));
        return "diary/showDiary";
    }
    @GetMapping("/diary/selectDiary")
    public String sectDiary(Model model,@RequestParam(value = "number")String number){
if(number.isEmpty()){
    model.addAttribute("diaryNumber",diaryService.selectDiary());
    return "diary/selectDiary";
}else{
    return "redirect:/diary/show?number="+number;
}

    }
}
