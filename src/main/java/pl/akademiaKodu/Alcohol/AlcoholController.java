package pl.akademiaKodu.Alcohol;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class AlcoholController {
    // ścieżka serwera localhost:8080/
    @GetMapping("/")
    public String home() {
        return "alcohol";  //zwróć plik alcohol.html z folderu resources/templates
    }
    private AlcoholCounter alcoholCounter = new AlcoholCounter();

    @GetMapping("/result")
    public String getResult(
            @RequestParam Double quantity,
            @RequestParam Double weight,
            @RequestParam String alcohol, ModelMap modelMap

    ) {
        Alcohol alcoholEnum = Alcohol.valueOf(alcohol);

        double result = alcoholCounter.calculatePerMil(quantity,weight,true,alcoholEnum);
        String resultString = String.format("%.2f",result);
        modelMap.put("result",resultString);
        return "result";                // templates/result.html
    }
    // GetMapping ("/hello)
    // localhost :8080/hello


}
