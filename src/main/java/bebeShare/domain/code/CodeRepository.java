package bebeShare.domain.code;

import bebeShare.web.dto.codeDto.CodeResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CodeRepository extends JpaRepository<Code, Long> {

    @Query("select new bebeShare.web.dto.codeDto.CodeResponseDto(c) from Code c where c.code = :code")
    List<CodeResponseDto> lookup(@Param("code") String code);


    List<Code> findByCode(@Param("code") String code);
}
