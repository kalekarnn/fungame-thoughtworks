package com.thoughtwork.programming.fungame.impl;

import com.thoughtwork.programming.fungame.external.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Service
public class GameServiceImpl {

    private final RemoteChallengeServiceImpl remoteChallengeService;

    @Autowired
    public GameServiceImpl(RemoteChallengeServiceImpl remoteChallengeService) {
        this.remoteChallengeService = remoteChallengeService;
    }

    @PostConstruct
    void init() {
        startGame();
    }

    public void startGame() {
        int letterCount = 0;
        int wordCount = 0;
        int sentenceCount = 0;
        int aCount = 0;
        int eCount = 0;
        int iCount = 0;
        int oCount = 0;
        int uCount = 0;

        GetChallengeResponse challenge = remoteChallengeService.getChallenge();
        String input = challenge.getText().toLowerCase();
        if (input != null) {
            letterCount = input.length();
        }
        LetterCountChallengeResult letterCountChallengeResult = new LetterCountChallengeResult();
        letterCountChallengeResult.setCount(letterCount);
        SubmitChallengeResponse challengeResponse = remoteChallengeService.submitChallengeResult(letterCountChallengeResult);

        challenge = remoteChallengeService.getChallenge();
        input = challenge.getText().toLowerCase();
        if (input != null) {
            wordCount = input.split(" ").length;
        }
        WordCountChallengeResult wordCountChallengeResult = new WordCountChallengeResult();
        wordCountChallengeResult.setWordCount(wordCount);
        challengeResponse = remoteChallengeService.submitChallengeResult(wordCountChallengeResult);

        challenge = remoteChallengeService.getChallenge();
        input = challenge.getText().toLowerCase();
        if (input != null) {
            sentenceCount = input.split("[?.][ ]").length;
        }
        SentenceCountChallengeResult sentenceCountChallengeResult = new SentenceCountChallengeResult();
        sentenceCountChallengeResult.setSentenceCount(sentenceCount);
        challengeResponse = remoteChallengeService.submitChallengeResult(wordCountChallengeResult);

        challenge = remoteChallengeService.getChallenge();
        input = challenge.getText().toLowerCase();
        if (input != null) {
            aCount = StringUtils.countOccurrencesOf(input, "a");
            eCount = StringUtils.countOccurrencesOf(input, "e");
            iCount = StringUtils.countOccurrencesOf(input, "i");
            oCount = StringUtils.countOccurrencesOf(input, "o");
            uCount = StringUtils.countOccurrencesOf(input, "u");
        }
        VowelCountChallengeResult vowelCountChallengeResult = new VowelCountChallengeResult();
        vowelCountChallengeResult.setA(aCount);
        vowelCountChallengeResult.setE(eCount);
        vowelCountChallengeResult.setI(iCount);
        vowelCountChallengeResult.setO(oCount);
        vowelCountChallengeResult.setU(uCount);
        challengeResponse = remoteChallengeService.submitChallengeResult(vowelCountChallengeResult);
    }
}
