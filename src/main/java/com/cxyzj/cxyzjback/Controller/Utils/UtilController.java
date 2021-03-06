package com.cxyzj.cxyzjback.Controller.Utils;

import com.cxyzj.cxyzjback.Service.Interface.Other.UtilService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Auther: 夏
 * @DATE: 2018/9/12 13:50
 * @Description:
 */

@RestController
@CrossOrigin
@Slf4j
@RequestMapping(value = "/v1/utils")
public class UtilController {

    private final UtilService utilService;

    @Autowired
    public UtilController(UtilService utilService) {
        this.utilService = utilService;
    }

    @PostMapping(value = "/upload/{type}")
    @PreAuthorize("hasAnyRole('ROLE_ANONYMITY','ROLE_USER','ROLE_ADMIN','ROLE_ADMINISTRATORS')")
    public String fileUpload(@RequestParam MultipartFile image, @PathVariable(name = "type") String type) {
        return utilService.fileUpload(image,type);
    }

}
