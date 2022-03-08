package com.company.controller;
import com.company.TicTac;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GameController {

    @RequestMapping("/startMatch/{size}")
    public Map<String,String> startMatch (@PathVariable("size") int size) {

        TicTac ticTac = new TicTac(size);
        Map <String, String> response = new HashMap<String, String>();
        try {
            int result = ticTac.play();
            ticTac.playedGame();
            String str = String.valueOf(result) + " won the match";
            response.put("status", str);

        } catch (Exception e) {
            response.put("status", "0");
            e.printStackTrace();
        }
        return response;
    }

}
