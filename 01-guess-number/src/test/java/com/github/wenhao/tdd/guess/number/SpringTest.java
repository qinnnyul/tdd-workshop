package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.controller.GameController;
import com.github.wenhao.tdd.guess.number.domain.Answer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.*;

public class SpringTest
{

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception
    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }


    @Test
    public void should_get_gamecontroller_from_application_context() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));
        // when
        GameController gameController = (GameController) applicationContext.getBean("gameController");
        // then
        gameController.play(inputCommand);
        verify(inputCommand, times(6)).input();
    }
}
