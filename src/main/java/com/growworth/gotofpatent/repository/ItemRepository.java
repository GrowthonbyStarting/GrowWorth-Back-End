package com.growworth.gotofpatent.repository;

import com.growworth.gotofpatent.entity.Answer;
import com.growworth.gotofpatent.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository  extends JpaRepository<Item, Long> {
    List<Item> findByAnswer(Answer answer);

}
