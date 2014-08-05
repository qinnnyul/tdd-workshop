package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.validate.AnswerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnswerGenerator
{
    private RandomIntGenerator randomIntGenerator;
    private AnswerValidator answerValidator;

    @Autowired
    public AnswerGenerator(RandomIntGenerator randomIntGenerator, AnswerValidator answerValidator)
    {
        this.randomIntGenerator = randomIntGenerator;
        this.answerValidator = answerValidator;
    }

    public Answer generate()
    {
        Answer answer = Answer.createAnswer(randomIntGenerator.nextInt());
        answerValidator.validate(answer);
        return answer;
    }
}
