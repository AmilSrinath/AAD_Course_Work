package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DTO.SizeDTO;
import lk.ijse.gdse.service.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/size")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SizeController {
    private final SizeService sizeService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean save(@RequestBody SizeDTO sizeDTO){
        return sizeService.saveSize(sizeDTO);
    }

    @GetMapping
    public List<SizeDTO> getAll(){
        return sizeService.getAllSizes();
    }

    @GetMapping("/getItemIds")
    public List<String> getItemIds(){
        for(SizeDTO sizeDTO : sizeService.getAllSizes()){
            System.out.println(sizeDTO.getItem_code());
        }
        return sizeService.getItemIds();
    }
}

