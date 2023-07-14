package com.growworth.gotofpatent.service;

import org.springframework.stereotype.Service;

@Service
public class FileService {
//    public void save(FileDto fileDto) throws IOException {
//        // 파일 첨부 여부에 따라 로직 분리
//        if (fileDto.getBoardFile().isEmpty()) {
//            // 첨부 파일 없음.
//            BoardEntity boardEntity = Item.toSaveEntity(boardDTO);
//            boardRepository.save(boardEntity);
//        } else {
//            // 첨부 파일 있음.
//            /*
//                1. DTO에 담긴 파일을 꺼냄
//                2. 파일의 이름 가져옴
//                3. 서버 저장용 이름을 만듦
//                // 내사진.jpg => 839798375892_내사진.jpg
//                4. 저장 경로 설정
//                5. 해당 경로에 파일 저장
//                6. board_table에 해당 데이터 save 처리
//                7. board_file_table에 해당 데이터 save 처리
//             */
//            MultipartFile boardFile = boardDTO.getBoardFile(); // 1.
//            String originalFilename = boardFile.getOriginalFilename(); // 2.
//            String storedFileName = System.currentTimeMillis() + "_" + originalFilename; // 3.
//            String savePath = "C:/springboot_img/" + storedFileName; // 4. C:/springboot_img/9802398403948_내사진.jpg
////            String savePath = "/Users/사용자이름/springboot_img/" + storedFileName; // C:/springboot_img/9802398403948_내사진.jpg
//            boardFile.transferTo(new File(savePath)); // 5.
//            BoardEntity boardEntity = BoardEntity.toSaveFileEntity(boardDTO);
//            Long savedId = boardRepository.save(boardEntity).getId();
//            BoardEntity board = boardRepository.findById(savedId).get();
//
//            BoardFileEntity boardFileEntity = BoardFileEntity.toBoardFileEntity(board, originalFilename, storedFileName);
//            boardFileRepository.save(boardFileEntity);
//        }
//
//    }

}
