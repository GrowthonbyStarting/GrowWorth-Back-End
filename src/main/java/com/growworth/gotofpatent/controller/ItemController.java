package com.growworth.gotofpatent.controller;

import com.growworth.gotofpatent.repository.AnswerRepository;
import com.growworth.gotofpatent.repository.ItemRepository;
import com.growworth.gotofpatent.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item" )
public class ItemController {
    @Autowired
    ItemService itemService;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    ItemRepository itemRepository;

//    @GetMapping("/{answerId}")
//    public ResponseEntity<List<Item>> getItemsByAnswerId(@PathVariable Long answerId) {
//        List<Item> items = itemService.getItemsByAnswerId(answerId);
//        return ResponseEntity.ok(items);
//    }
//    @PostMapping("")
//    public ResponseEntity createItem(@RequestBody ItemRequestDto itemRequestDto) {
//
//        Item item = new Item();
//        item.setQuestion(itemRequestDto.getQuestion());
//        item.setResponse(itemRequestDto.getResponse());
//        item.setQuestionOrder(itemRequestDto.getOrder());
//        Item savedItem = itemRepository.save(item);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
//    }
}
