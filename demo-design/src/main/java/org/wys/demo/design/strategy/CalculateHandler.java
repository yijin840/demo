package org.wys.demo.design.strategy;

import org.wys.demo.design.strategy.request.CalculateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2021/7/19
 */
@Component
public class CalculateHandler {

    @Autowired
    private List<AbstractCalculateStrategy> calculateStrategyList;

    public int calculateSelector(CalculateRequest calculateRequest) {
        List<Integer> list = calculateStrategyList.stream().map(item -> {
            if (Objects.equals(item.getType(), calculateRequest.getType())) {
                item.calculate(calculateRequest.getA(), calculateRequest.getB());
                return item.getResult();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        if(list.size() != 1) {
            throw new RuntimeException("类型错误");
        }
        return list.get(0);
    }

}
