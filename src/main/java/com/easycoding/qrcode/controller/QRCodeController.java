package com.easycoding.qrcode.controller;

import com.easycoding.qrcode.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class QRCodeController {



    @GetMapping("/generateQRCode")
    public ResponseEntity<byte[]> generateQRCode(@RequestParam String text) {
        try {
            byte[] qrCodeImage = QRCodeGenerator.generateQRCodeImage(text, 220, 220);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png");
            return ResponseEntity.ok().headers(headers).body(qrCodeImage);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    //https://img.alicdn.com/imgextra/i3/O1CN01CrlKFC1S9wGnqRPFC_!!6000000002205-2-tps-54-54.png

    /**
     * {
     *   "gmkey": "CLK",
     *   "gokey": "newSimLogin%3Dfalse%26appName%3Dtaobao%26appEntrance%3Dtaobao_pc%26loginFrom%3D%26bizId%3D%26defaultView%3Dpassword%26behaviorTraceId%3D_2150419817569775644351574eb7ae%26currentView%3Dpassword%26queue%3D1%257C2%257C3%257C4%257C5%26frame%3D0%26release%3D0.10.29%26parentUrl%3D-%26aws%3D1%26jsver%3Daplus_std%26lver%3D8.15.24%26pver%3D0.7.12%26cache%3D4982779%26page_cna%3DBEdAIXGZ6TIBASQJih5sNCdO%26_slog%3D0",
     *   "cna": "BEdAIXGZ6TIBASQJih5sNCdO",
     *   "_p_url": "https%3A%2F%2Flogin.taobao.com%2Fhavanaone%2Flogin%2Flogin.htm%3FbizName%3Dtaobao%26redirectURL%3Dhttp%253A%252F%252Fcart.taobao.com%252Fcart.htm%253Fspm%253Dtbpc.pc_sem_alimama%25252Fa.1997525049.1.4ebb2a89caA1a1%2526from%253Dmini%2526pm_id%253D1501036000a02c5c3739",
     *   "spm-cnt": "a212t0.1.0.0.4bc51b05mNmWHp",
     *   "logtype": "2"
     * }
     *
     * */
    @GetMapping("/generateRandomQRCode")
    public ResponseEntity<byte[]> generateRandomQRCode() {
        String randomText = RandomStringGenerator.generateRandomString();
        try {
            byte[] qrCodeImage = QRCodeGenerator.generateQRCodeImage(randomText, 220, 220);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "image/png");
            return ResponseEntity.ok().headers(headers).body(qrCodeImage);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


    public class RandomStringGenerator {
        public static String generateRandomString() {
            return UUID.randomUUID().toString().concat("\n To be or not to be, this is a question \n").concat(String.valueOf(LocalDateTime.now()));
        }
    }
}