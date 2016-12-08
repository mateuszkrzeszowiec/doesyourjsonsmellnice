/**
 * Created by mat on 12/8/16.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
public class SmellyController {

    @RequestMapping(value = "/nosniff.html")
    WhatsThatSmell nosniff(@RequestParam String grouyere, @RequestParam String oldAmsterdam, @RequestParam String gouda, @RequestParam String comte, HttpServletResponse response) {
        response.addHeader("X-Content-Type-Options", "nosniff");
        return new WhatsThatSmell(grouyere, oldAmsterdam, gouda, comte);
    }

    @RequestMapping("/sniff.html")
    WhatsThatSmell sniff(@RequestParam String grouyere, @RequestParam String oldAmsterdam, @RequestParam String gouda, @RequestParam String comte) {
        return new WhatsThatSmell(grouyere, oldAmsterdam, gouda, comte);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SmellyController.class, args);
    }
}

class WhatsThatSmell {
    private String gruyere;
    private String oldAmsterdam;
    private String gouda;
    private String comte;

    public WhatsThatSmell(String grouyere, String oldAmsterdam, String gouda, String comte) {
        this.gruyere = grouyere;
        this.oldAmsterdam = oldAmsterdam;
        this.gouda = gouda;
        this.comte = comte;
    }

    public String getGruyere() {
        return gruyere;
    }

    public String getOldAmsterdam() {
        return oldAmsterdam;
    }

    public String getGouda() {
        return gouda;
    }

    public String getComte() {
        return comte;
    }
}
