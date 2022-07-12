package bebeShare.service;

import bebeShare.domain.code.CodeRepository;
import bebeShare.web.dto.category.CategoryReqeustDto;
import bebeShare.web.dto.codeDto.CodeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CodeRepository codeRepository;

    public List<CodeResponseDto> lookup(String code){
        return codeRepository.lookup(code);
    }


    public List<CodeResponseDto> findAll(){
         return codeRepository.findAll()
                 .stream()
                 .map(CodeResponseDto::new)
                 .collect(Collectors.toList());
    }
}
