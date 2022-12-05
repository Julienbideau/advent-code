package com.advent.code.days.second;

import com.advent.code.days.first.Elve;
import com.advent.code.days.first.Items;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AdventOfCode2 {

   public Integer getTotalScoreOfGame(List<InputValue> games){
       final int totalScore = games.stream().map(this::computeScoreGame).mapToInt(v -> v).sum();
       return totalScore;
   }

   private Integer computeScoreGame(InputValue game){
      if(game.getOpponentChoice() == game.getOurChoice()){
         return 3 + game.getOurChoice().value;
      }
      if(game.getOpponentChoice().equals(RockScissorsPaper.PAPER)){
         if (game.getOurChoice().equals(RockScissorsPaper.SCISSORS)){
             return 6 + game.getOurChoice().value;
         }
       }
       if(game.getOpponentChoice().equals(RockScissorsPaper.SCISSORS)){
           if (game.getOurChoice().equals(RockScissorsPaper.ROCK)){
               return 6 + game.getOurChoice().value;
           }
       }
       if(game.getOpponentChoice().equals(RockScissorsPaper.ROCK)){
           if (game.getOurChoice().equals(RockScissorsPaper.PAPER)){
               return 6 + game.getOurChoice().value;
           }
       }
       return game.getOurChoice().value;
   }

    public Integer getTotalScoreOfGame2(List<InputValue> games){
        final int totalScore = games.stream().map(this::computeScoreGame2).mapToInt(v -> v).sum();
        return totalScore;
    }

    private Integer computeScoreGame2(InputValue game){
       if(game.getOurChoice().equals(RockScissorsPaper.ROCK)){
           // NEED TO LOOSE
            return computeLoosingGame(game);
       }
       if (game.getOurChoice().equals(RockScissorsPaper.SCISSORS)) {
           return computeDrawGame(game);
       }
       else {
           return computeWinningGame(game);
       }
    }

    private Integer computeLoosingGame(InputValue game){
        return switch (game.opponentChoice){
            case SCISSORS -> 2;
            case PAPER -> 1;
            case ROCK -> 3;
        };
    }

    private Integer computeDrawGame(InputValue game){
        return 3 + game.opponentChoice.value;
    }

    private Integer computeWinningGame(InputValue game){
        return switch (game.opponentChoice){
            case SCISSORS -> 6 + 1;
            case PAPER -> 6+ 3;
            case ROCK -> 6+ 2;
        };
    }
}
