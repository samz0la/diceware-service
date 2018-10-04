package edu.cnm.deepdive.dicewareservice;

import edu.cnm.deepdive.cryptogrophy.ArtifactGenerator;
import edu.cnm.deepdive.cryptogrophy.PassphraseGenerator;
import edu.cnm.deepdive.cryptogrophy.WordSource;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DicewareController {

  private ArtifactGenerator generator;


  public DicewareController(WordSource source, Random rng) {
    generator = new PassphraseGenerator(source, rng);
  }
  @GetMapping("/diceware")
  public String get(@RequestParam(name = "length", defaultValue = "6") int length) {
    return generator.generate(length);
  }
}
