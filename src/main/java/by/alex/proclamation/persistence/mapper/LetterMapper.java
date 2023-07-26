package by.alex.proclamation.persistence.mapper;

import by.alex.proclamation.persistence.dto.LetterDto;
import by.alex.proclamation.persistence.model.Letter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LetterMapper {

    LetterDto toDto(Letter letter);

//    @Mapping(target = "id", source = "")
    Letter toModel(LetterDto letterDto);

}
