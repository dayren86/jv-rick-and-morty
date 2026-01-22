package mate.academy.rickandmorty.controler;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping
    public Character getRandomCharacter() {
        return characterService.getRandomCharacter();
    }

    @GetMapping("/{name}")
    public List<Character> getCharacterByName(@PathVariable String name) {
        return characterService.getCharacterByName(name);
    }
}
