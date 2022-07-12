package bebeShare.web;


import bebeShare.service.CategoryService;
import lombok.AllArgsConstructor;
import bebeShare.web.dto.category.CategoryReqeustDto;
import bebeShare.web.dto.codeDto.CodeResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CategoryApiController {
    private final CategoryService categoryService;

    // 카테고리 조회
    @GetMapping("/categories")
    public void lookupCategory(@RequestParam String code){
        categoryService.lookup(code);
    }


    @PostMapping("/categories")
    public List<CodeResponseDto> findAllCategories(){

        List<CodeResponseDto> byCode = categoryService.findAll();

        log.debug("@@@@@ :" + byCode.toString());
        return byCode;

    }
}