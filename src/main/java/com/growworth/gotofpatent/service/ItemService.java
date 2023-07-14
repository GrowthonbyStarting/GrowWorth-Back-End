package com.growworth.gotofpatent.service;

import com.growworth.gotofpatent.entity.Answer;
import com.growworth.gotofpatent.entity.Item;
import com.growworth.gotofpatent.repository.AnswerRepository;
import com.growworth.gotofpatent.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private AnswerRepository answerRepository;

    public List<Item> getItemsByAnswerId(Long answerId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new NoSuchElementException("Answer not found"));

        return itemRepository.findByAnswer(answer);
    }

//    public Item createItem(Long answerId, ItemRequestDto itemRequestDto) {
//        Answer answer = answerRepository.findById(answerId)
//                .orElseThrow(() -> new NoSuchElementException("Answer not found"));
//
//        Item item = new Item();
//        item.setQuestionContent(itemRequestDto.getQuestion());
//        item.setAnswer(answer);
//        item.setOrder(itemRequestDto.getOrder());
//        // Set other properties as needed
//
//        return itemRepository.save(item);
//    }
}
