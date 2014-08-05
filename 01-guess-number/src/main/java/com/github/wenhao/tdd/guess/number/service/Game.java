package com.github.wenhao.tdd.guess.number.service;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class Game
{
    private Answer answer;
    private List<GuessResult> guessResults;

    @Autowired
    public Game(AnswerGenerator answerGenerator)
    {
        this.answer = answerGenerator.generate();
        this.guessResults = newArrayList();
    }

    public GuessResult guess(Answer answer)
    {
        String result = this.answer.compare(answer);
        GuessResult guessResult = createGuessResult(answer, result);
        guessResults.add(guessResult);
        return guessResult;
    }

    private GuessResult createGuessResult(Answer answer, String result)
    {
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer(answer.getValue());
        guessResult.setResult(result);
        return guessResult;
    }

    public List<GuessResult> getHistory()
    {
        return guessResults;
    }

    public String actualAnswer()
    {
        return answer.getValue();
    }
}
