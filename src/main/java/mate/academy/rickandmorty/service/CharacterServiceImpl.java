package mate.academy.rickandmorty.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterResultsDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    @Override
    public void saveCharacters(List<CharacterResultsDto> characterResultsDto) {
        List<Character> characterModel = characterMapper.toCharacterModels(characterResultsDto);
        characterRepository.saveAll(characterModel);
    }

    @Override
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Override
    public List<Character> getCharacterByName(String name) {
        return characterRepository.findByNameContains(name);
    }
}
