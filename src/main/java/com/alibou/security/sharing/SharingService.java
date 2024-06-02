//package com.alibou.security.sharing;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class SharingService {
//
//    private final SharingRepository sharingRepository;
//
//    public String saveSharing(String title, String weight, String price, String region, String image) throws IOException {
//
//        // Save the entity with the image data
//        SharingEntity sharingEntity = new SharingEntity();
//        sharingEntity.setTitle(title);
//        sharingEntity.setWeight(weight);
//        sharingEntity.setPrice(price);
//        sharingEntity.setRegion(region);
//        sharingEntity.setImage(image);
//
//        sharingRepository.save(sharingEntity);
//
//        // Return a success message
//        return "Product saved successfully.";
//    }
//
//
//    public List<SharingEntity> getAllSharings() {
//        return sharingRepository.findAll();
//    }
//
//    public SharingEntity getSharingById(Long id) {
//        return sharingRepository.findById(id).get();
//    }
//
//
//    public String updateSharingEntity(SharingEntity sharingEntity) {
//        sharingRepository.save(sharingEntity);
//
//        return "Product is updated successfully";
//    }
//
//
//    public String deleteSharing(Long id) {
//
//        sharingRepository.deleteById(id);
//        return "Product deleted";
//    }
//
//}
