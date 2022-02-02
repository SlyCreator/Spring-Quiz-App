package com.slycreator.springquizapp.repository;

import com.slycreator.springquizapp.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option,Integer> {
    List<Option> findAllByIdIn(List<Integer> optionIdList);

}
