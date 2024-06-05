package com.alibou.security.sharing;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sharing")
@RequiredArgsConstructor
public class SharingController {

    private final SharingService sharingService;

    @PostMapping(value = "/share", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> uploadSharingRequest(
            @RequestParam("title") String title,
            @RequestParam("weight") String weight,
            @RequestParam("price") String price,
            @RequestParam("region") String region,
            @RequestParam("image") String image) {
        try {
            // Save the image URL to the database
            String message = sharingService.saveSharing(title, weight, price, region, image);

            // Return the success message
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading request");
        }
    }


    @GetMapping(value = "/get-all-sharing", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SharingEntity> getAllSharings() {
        return sharingService.getAllSharings();
    }


    @PutMapping(value = "/update-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateSharing(@RequestParam("id") Long id,
                                                @RequestParam("title") String title,
                                                @RequestParam("weight") String weight,
                                                @RequestParam("price") String price,
                                                @RequestParam("region") String region,
                                                @RequestParam("image") String image) {
        try{
            SharingEntity sharingEntity = sharingService.getSharingById(id);
            sharingEntity.setId(id);
            sharingEntity.setTitle(title);
            sharingEntity.setWeight(weight);
            sharingEntity.setPrice(price);
            sharingEntity.setRegion(region);
            sharingEntity.setImage(image);

            String message = sharingService.updateSharingEntity(sharingEntity);

            return ResponseEntity.ok(message);
        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating request");
        }
    }


    @DeleteMapping(value = "/remove-by-id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSharingRequest(@RequestParam Long id) {
        try {
            String message = sharingService.deleteSharing(id);

            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting request");
        }
    }


}
