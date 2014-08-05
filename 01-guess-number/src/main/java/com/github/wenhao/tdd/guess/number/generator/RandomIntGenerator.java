package com.github.wenhao.tdd.guess.number.generator;

import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Set;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_RANGE;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SIZE;
import static com.google.common.collect.Sets.newHashSet;

@Component
public class RandomIntGenerator
{
    private Random random;

    @Autowired
    public RandomIntGenerator(Random random)
    {
        this.random = random;
    }

    public String nextInt()
    {
        Set<Integer> numbers = newHashSet();
        while (numbers.size() < ANSWER_SIZE) {
            numbers.add(random.nextInt(ANSWER_RANGE.upperEndpoint()) + ANSWER_RANGE.lowerEndpoint());
        }
        return Joiner.on(ANSWER_SEPARATOR).join(numbers);
    }
}
