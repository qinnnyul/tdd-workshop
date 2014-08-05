package com.github.wenhao.tdd.guess.number.view;

import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleGameView implements GameView
{
    @Override
    public void showGuessHistory(List<GuessResult> guessResults)
    {
        for (GuessResult guessResult : guessResults) {
            showCurrentResult(guessResult);
        }
    }

    @Override
    public void showMessage(String message)
    {
        System.out.println(message);
    }

    @Override
    public void showCurrentResult(GuessResult guessResult)
    {
        System.out.println(guessResult.getInputAnswer() + ":" + guessResult.getResult());
    }
}
